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
	
	redisClient.get('photos', async (error, photos) =>{
	console.log('Loading photos from Cache...');
	if(error) console.error(error);
	if(photos != null){
		console.log("Cache Hit!");
		return res.json(JSON.parse(photos));
	}
	else{
		console.log("Cache Miss! \n Request the server.");
		// main operations 
		const { data } = await axios.get(
			"https://jsonplaceholder.typicode.com/photos",
			{ params : { albumId } } //pass params to limit the results
		);
		redisClient.setEx("photos", 3600, JSON.stringify(data));
		res.json(data);
	}
	});
	

});


app.get("/photo/:id", async(req, res) => {
	console.log('Loading photo...');
	const { data } = await axios.get(
		`https://jsonplaceholder.typicode.com/photos/${req.params.id}`
	)

	res.json(data)
});

app.listen(3000);