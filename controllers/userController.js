const { ObjectId } = require("mongodb");
const model = require('../models/userModel.js');
const { User } = require('../schemes/userScheme.js');

const userObj = new User();

const signUp = (req, res) => {
    res.render('signUp', { title: 'Sign Up', css: '/css/signUp.css'});
}

const newUser = (req, res) => {
    userObj = req.body;

    const validation = model.findByEmail(userObj.getEmail());
    if(validation !== null) {
        model.post(userObj)
            .then(() => {
                res.redirect('/sign-up');
            })
            .catch((err) => {
                throw err;
            })
        }
}

const login = (req, res) => {
    res.render('login', { title: 'Login', css: '/css/login.css'});
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
    userDetails
}