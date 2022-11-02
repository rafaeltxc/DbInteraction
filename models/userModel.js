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
        .then((result) => {
            //temporary
            console.log(lst);
        }).catch((err) => {
            throw err;
        });

    instance().close();
}

async function find(id) {
    await getInstance();

    await instance().db().collection('users').findOne({ _id: ObjectId(id)})
        .then((result) => {
            //temporary
            console.log(result);
        })
        .catch((err) => {
            throw err;
        });

    instance().close(); 
}

async function findByEmail(email) {
    await getInstance();

    await instance().db().collection('users').findOne({ email: email })
        .then((result) => {
            //temporary
            console.log(result);
        })
        .catch((err) => {
            throw err;
        })

    instance().close();
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

    instance().close();
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

    instance().close();
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

    instance().close();
}

module.exports = {
    findAll,
    find,
    findByEmail,
    post,
    patch,
    deletion
}
