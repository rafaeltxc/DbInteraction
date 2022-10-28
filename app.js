const http = require('http');
const fs = require('fs');
const controller = require('./controller/UserController.js');

const server = http.createServer((req, res) => {
switch(req.url) {
    case('/'):
        res.writeHead(302, {'location': '/home'});
    case('/home'):
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(fs.readFileSync('./views/home.html'));
        break;
    case('/User'):
        controller.findAll();
        break;
    default:
        res.writeHead(400, {'Content-Type': 'text/html'});
        res.end(fs.readFileSync('./views/404.html'));
}})

server.listen(3000, 'localhost', (err) => {
    if(err) throw err;
});
