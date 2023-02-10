//const express = require('express');
//const app = express();
//const port = 8000;

// GET /reviews
////app.get('/reviews', (req, res) => {
//  res.send('Get all reviews');
//});

// GET /reviews/:id
//app.get('/reviews/:id', (req, res) => {
//  res.send(`Get review with id: ${req.params.id}`);
//});

// POST /reviews
//app.post('/reviews', (req, res) => {
//  res.send('Create a new review');
//});

// PUT /reviews/:id
//app.put('/reviews/:id', (req, res) => {
//  res.send(`Update review with id: ${req.params.id}`);
//});

// DELETE /reviews/:id
//app.delete('/reviews/:id', (req, res) => {
//  res.send(`Delete review with id: ${req.params.id}`);
//});

//app.listen(port, () => {
//  console.log(`Reviews API running at http://localhost:${port}`);
//});

//const express = require('express');
////const Review = require('./models/review');
//const app = express();
//const port = 3000;

// GET /reviews
//app.get('/reviews', (req, res) => {
//  res.json(Review.all());
//});

// GET /reviews/:id
//app.get('/reviews/:id', (req, res) => {
 // const review = Review.find(req.params.id);
//  if (!review) return res.status(404).send('Review not found');
//  res.json(review);
//});

// POST /reviews
//app.post('/reviews', (req, res) => {
//  const review = Review.create(req.body);
//  res.status(201).json(review);
//});
