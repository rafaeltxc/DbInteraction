const model = require('../model/UserModel.js');

async function findAll(req, res) {
    try {
        const data = await model.getAll();
        
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(data, null, 2));
    } catch(err) {
        throw err;
    }
}

async function findById(id, req, res) {
    try {
        const data = await model.getById(id);
        
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(data, null, 2));
    } catch (err) {
        throw err;
    }
}

async function insert(req, res) {
    try {
        let body = '';
        req.on('data', (chunk) => {
            body += chunk;
        })

        req.on('end', async () => {
            const { firstName, lastName, email, birth } = JSON.parse(body);
            const user = {
                firstName, 
                lastName, 
                email, 
                birth
            }

            await model.insert(firstName, lastName, email, birth);
            res.writeHead(201, { 'Content-Type': 'application/json' });
            res.end(JSON.stringify(user));
        })
    } catch (err) {
        throw err;
    }
}

async function update(req, res) {
    try {
        let body = '';
        req.on('data', (chunk) => {
            body += chunk;
        })
        
        req.on('end', async () => {
            const { firstName, lastName, email, birth, id } = JSON.parse(body);
            const user = {
                firstName, 
                lastName, 
                email,
                id
            }

            await model.update(firstName, lastName, email, birth, id)
            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.end(JSON.stringify(user));
        })
    } catch (err) {
        throw err;
    }
}

async function deletion(id, req, res) {
    try {
        await model.deletetion(id);

        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end('data deleted with success');
    } catch (err) {
        throw err;
    }
}

module.exports = {
    findAll,
    findById,
    insert,
    update,
    deletion
}