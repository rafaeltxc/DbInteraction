const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
res.setHeader('Content-Type', 'text/html');

let path = __dirname;
switch(req.url) {
    case('/'):
        res.setHeader('location', '/home');
        res.statusCode = 301;
        break;
    case('/home'):
        path += '/view/home.html';
        res.statusCode = 200;
        break;
    case('/login'):
        path += '/view/login.html';
        res.statusCode = 200;
        break;
    case('/register'):
        path += '/view/register.html';
        res.statusCode = 200;
        break;
    case('/user'):
        path += '/view/user.html';
        res.statusCode = 200;
        break;
    case('/welcome'):
        path += '/view/welcome.html';
        res.statusCode = 200;
        break;
    default:
        path += '/view/404.html'
        res.statusCode = 400;
}

fs.readFile(path, (err, data) => {
    if (err) {
        throw err;
    }
    res.end(data);
})

})

server.listen(3000, 'localhost', (err) => {
    if(err) {
        throw err;
    }
});
