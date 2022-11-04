const { ObjectId } = require("mongodb");
const model = require('../models/userModel.js');
const { User } = require('../schemes/userScheme.js');

let userObj;

const signUp = (req, res) => {
    res.render('signUp', { title: 'Sign Up', css: '/css/signUp.css'});
}

const newUser = (req, res) => {
    userObj = req.body;

    const validation = model.findByEmail(userObj.email);
    if(validation !== null) {
        model.post(userObj)
            .then(() => {
                res.redirect('/login');
            })
            .catch((err) => {
                throw err;
            })
    } else {

    }
}

const login = (req, res) => {
    res.render('login', { title: 'Login', css: '/css/login.css' });
}

const authentication = async (req, res) => {
    userObj = req.body;

    const validation = model.findByEmail(userObj.email);
    if(userObj.password === validation.password) {
        req.session.id = model.getIdUser(validation);
        res.redirect('/user/' + req.session.id);
    } else {

    }
}

const userDetails = (req, res) => {
    if(ObjectId.isValid(req.params.id)) {
        res.render('user', { title: 'User', css: '/css/user.css'});
    } else {
        res.writeHead(500, { 'Content-Type': 'text/html' });
        res.end('Not valid id');
    }
}

module.exports = {
    signUp,
    newUser,
    login,
    authentication,
    userDetails
}