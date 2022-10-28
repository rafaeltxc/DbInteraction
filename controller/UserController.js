const model = require('../model/UserModel.js');

async function findAll(req, res) {
    try {
        const data = await model.getAll();
        
        // res.writeHead(200, { 'Content-Type': 'application/json' });
        // res.end(JSON.stringify(data, null, 2));
    } catch(err) {
        throw err;
    }
}

async function findById(id) {
    try {
        const data = await model.getById(id);
        
        // res.writeHead(200, { 'Content-Type': 'application/json' });
        // res.end(JSON.stringify(data, null, 2));
    } catch (err) {
        throw err;
    }
}

module.exports = {
    findAll,
    findById
}