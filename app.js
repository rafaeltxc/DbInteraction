const express = require('express');
const connection = require('./connection.js');
const userRoutes = require('./routes/userRoutes.js');

const app = express();

connection.connect((err) => {
    if(!err) {
        app.listen(3000, () => {
            console.log('listening at port 3000');
        })
    } else {
        throw err;
    }
})

app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.redirect('/home');
})

app.get('/home', (req, res) => {
    res.render('home', { title: 'Home', css: '/css/home.css'});
})

app.use(userRoutes);

app.use((req, res) => {
    res.status(404).render('404', { title: '404', css: '/css/404.css'});
})