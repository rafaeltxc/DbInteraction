const mysql = require('mysql');

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "root",
    database: "authentication"
});

function connect() {
    return new Promise((resolve, reject) => {
        resolve(
            db.connect((err) => {
                if(err) {
                    throw err;
                }
            })
        );
        reject(
            new Error('Unable to connect')
        )
    })
}

module.exports = {
    db,
    connect
}