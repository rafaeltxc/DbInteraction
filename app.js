const http = require('http');
const fs = require('fs');
const controller = require('./controller/UserController.js');

const server = http.createServer((req, res) => {
switch(req.url) {
    case('/User'):
        if(req.method === 'GET') {
            controller.findAll(req, res);
        } else if(req.method === 'POST') {
            controller.insert(req, res);
        } else if(req.method === 'PUT') {
            controller.update(req, res);
        }
        break;
    case('/User/' + req.url.split('/')[2]):
        const id = req.url.split('/')[2];

        if(req.method === 'GET') {
            controller.findById(id, req, res)
        } else if(req.method === 'DELETE') {
            controller.deletion(id, req, res)
        }
        break;
    default:
        res.writeHead(400, {'Content-Type': 'text/html'});
        res.end('Page not found');
}})

server.listen(3000, 'localhost', (err) => {
    if(err) throw err;
});
