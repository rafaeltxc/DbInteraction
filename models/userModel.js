const { ObjectId } = require('mongodb');
const { instance } = require('../connection.js');

async function getInstance() {
    await instance();
}

async function findAll() {
    await getInstance();

    lst = [];
    await instance().db().collection('users').find()
        .forEach(user => {
            lst.push(user);
        })

    return lst;
}

async function find(id) {
    await getInstance();

    let user;
    await instance().db().collection('users').findOne({ _id: ObjectId(id)})
        .then((result) => {
            user = result;
        })
        .catch((err) => {
            throw err;
        });

    return user;
}

async function getIdUser(obj) {
    obj = new String(obj._id).split("'")[0];
    return obj;
}

async function findByEmail(email) {
    await getInstance();
    let userMail;
    await instance().db().collection('users').findOne({ email: email })
        .then((result) => {
            userMail = result;
        })
        .catch((err) => {
            throw err;
        })

    return userMail;
}

async function post(body) {
    await getInstance();

    await instance().db().collection('users').insertOne(body)
        .then((result) => {
            //temporary
            console.log(result);
        })
        .catch((err) => {
            throw err;
        });

}

async function patch(id, body) {
    await getInstance();

    await instance().db().collection('users').updateOne({_id: ObjectId(id)}, {$set: body})
        .then((result) => {
            //temporary
            console.log(result);
        })
        .catch((err) => {
            throw err;
        })

}

async function deletion(id) {
    await getInstance();

    await instance().db().collection('users').deleteOne({_id: ObjectId(id)})
        .then((result) => {
            //temporary
            console.log(result);
        })
        .catch((err) => {
            throw err;
        })

}

module.exports = {
    findAll,
    find,
    getIdUser,
    findByEmail,
    post,
    patch,
    deletion
}
