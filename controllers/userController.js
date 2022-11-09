const { ObjectId } = require("mongodb");
const model = require('../models/userModel.js');


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
    }
}

const login = (req, res) => {
    res.render('login', { title: 'Login', css: '/css/login.css' });
}

const authentication = async (req, res) => {
    userObj = req.body;

    const validation = await model.findByEmail(userObj.email);
    if(userObj.password === validation.password) {
        req.session.idUser = await model.getIdUser(validation);
        res.redirect('/user/' + req.session.idUser);
    }
}

const user = (req, res) => {
    if(req.session.idUser == null) {
        res.redirect('/home');
    } else {
        if(ObjectId.isValid(req.params.id)) {
            res.render('user', { title: 'User', css: '/css/user.css'});
        } else {
            res.writeHead(500, { 'Content-Type': 'text/html' });
            res.end('Not valid id');
        }
    }
}

const logout = (req, res) => {
    req.session.destroy();
    res.redirect('/home');
}

const deleteUser = (req, res) => {
    model.deletion(req.session.idUser);
    res.redirect('/home');
}

const userDetails = async (req, res) => {
    const user = await model.find(req.session.idUser);
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(user));
}

module.exports = {
    signUp,
    newUser,
    login,
    authentication,
    user,
    logout,
    deleteUser,
    userDetails
}