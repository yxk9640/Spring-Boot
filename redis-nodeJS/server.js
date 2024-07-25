//import 
const express = require('express');
const axios = require('axios');
const cors = require('cors');
const Redis = require('redis');

const app = express();
const redisClient = Redis.createClient();
// Handle Redis connection errors
redisClient.connect();

app.use(cors());

app.get("/photos", async (req, res) => {
	const albumId = req.query.albumId
	console.log('Loading photos...');
	const photos = await getOrSetCache(`photos?albumId=${albumId}`, async () => {
		console.log("Requesting the server.");
		const { data } = await axios.get(
			"https://jsonplaceholder.typicode.com/photos",
			{ params : { albumId } } //pass params to limit the results
		)
		return data;
	});
	res.json(photos);
});


app.get("/photos/:id", async(req, res) => {
	console.log('Loading photo...');

	const photo = await getOrSetCache(`photos:${req.params.id}`, async () => {
		console.log("Requesting the server.");
		const { data } = await axios.get(
			`https://jsonplaceholder.typicode.com/photos/${req.params.id}`
		)
		return data;
	});

	res.json(photo);
	

	
});

function getOrSetCache(key, cb){
	//check in cache before sending request
		return new Promise(async (resolve, reject) => {
			try  // reject if no redis
			{

				const data = await redisClient.get(key);
				
				if(data != null){
					console.log("Cache Hit Success! ")
					return resolve(JSON.parse(data)); 
				}//hit
				console.log("Cache Miss!");
				const freshData = await cb();
				console.log("Store in Cache!");
				await redisClient.setEx(key, 3600, JSON.stringify(freshData));
				resolve(freshData);
				

			} catch (err) {reject(err); }
		
	})
}


app.listen(3000);