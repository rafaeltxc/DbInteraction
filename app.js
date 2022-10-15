const express = require('express');
const morgan = require('morgan');
const mongoose = require('mongoose');

const app = express();
app.listen(3000);

app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(express.urlencoded({ extended: true}));
app.use(morgan('dev'));

app.get('/', (req, res) => {
    res.redirect('/home');
})

app.get('/home', (req, res) => {
    res.render('home', { css: '/css/home.css', title: 'Home' });
})

app.get('/sign-in', (req, res) => {
    res.render('signIn', { css: '/css/signIn.css', title: 'Sign-in' });
})

app.get('/sign-up', (req, res) => {
    res.render('signUp', { css: '/css/signUp.css', title: 'Sign-up' });
})

app.get('/library', (req, res) => {
    res.render('library', { css: '/css/library.css', title: 'Library' });
})

app.get('/book', (req, res) => {
    res.render('book', { css: '/css/book.css', title: 'Book' });
})

app.get('/new-book', (req, res) => {
    res.render('newBook', { css: '/css/newBook.css', title: 'new-book' });
})