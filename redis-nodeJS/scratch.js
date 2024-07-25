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
	//check in cache before sending request
	try 
	{
		const photosCache = await redisClient.get('photos');
		console.log('Loading photos from Cache...');
		if(photosCache != null){
			console.log("Cache Hit!");
			return res.json(JSON.parse(photosCache));
		}
		else{
			console.log("Cache Miss! \nRequesting the server.");
			// main operations 
			const { data } = await axios.get(
				"https://jsonplaceholder.typicode.com/photos",
				{ params : { albumId } } //pass params to limit the results
			);
			await redisClient.setEx("photos", 3600, JSON.stringify(data));
			res.json(data);
		}
	}catch(error) {console.log("error in get request of cache, Issue in redis connections.")};
	

});


app.get("/photo/:id", async(req, res) => {
	console.log('Loading photo...');
	const { data } = await axios.get(
		`https://jsonplaceholder.typicode.com/photos/${req.params.id}`
	)

	res.json(data)
});

app.listen(3000);