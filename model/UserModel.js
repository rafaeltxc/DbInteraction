const {db} = require('../connection.js');

function insert(firstName, lastName, email, birth) {
    if(db.state === 'disconnected') {
        db.connect();
    }
    const query = `INSERT INTO tbl_user (first_name, last_name, email, birth) VALUES ('${firstName}', '${lastName}', '${email}', '${birth}')`;
    return new Promise((resolve, reject) => {
        resolve(
            db.query(query, (err) => {
                if(err) {
                    throw err;
                } else {
                    db.commit();
                    db.end();
                }
        }));
        reject(
            new Error('Insert failed')
        );
    })
}

function update(firstName, lastName, email, birth, id) {
    if(db.state === 'disconnected') {
        db.connect();
    }
    const query = `UPDATE tbl_user SET first_name = '${firstName}', last_name = '${lastName}', email = '${email}', birth = '${birth}' WHERE id_user = ${id}`;
    return new Promise((resolve, reject) => {
        resolve(
            db.query(query, (err) => {
                if(err) {
                    throw err;
                } else {
                    db.commit();
                    db.end();
                }
            })
        );
        reject(
            new Error('Update failed')
        );
    })
}

function deletetion(id) {
    if(db.state === 'disconnected') {
        db.connect();
    }
    const query = `DELETE FROM tbl_user WHERE id_user = ${id}`;
    return new Promise((resolve, reject) => {
        resolve(
            db.query(query, (err) => {
                if(err) {
                    throw err;
                } else {
                    db.commit();
                    db.end();
                }
            })
        );
        reject(
            new Error('Delete failed')
        );
    })
}

function getAll(callback) {
    if(db.state === 'disconnected') {
        db.connect();
    }
    const query = 'SELECT * FROM tbl_user;'
    db.query(query).on('result', (row) => {
        callback('Unable to get data', row);
    })
    db.end();
}

function getById(id, callback) {
    if(db.state === 'disconnected') {
        db.connect();
    }
    const query = `SELECT * FROM tbl_user WHERE id_user = ${id}`;
    db.query(query).on('result', (row) => {
        callback('Unable to get data', row);
    })
    db.end();
}

let pad = function(num) { return ('00'+num).slice(-2) };
let date;
date = new Date();
date = date.getUTCFullYear()         + '-' +
        pad(date.getUTCMonth() + 1)  + '-' +
        pad(date.getUTCDate())


deletetion(2).then((result) => {
    getAll((resolve) => {
        console.log(result);
    })
}).catch((err) => {
    
});;

module.exports = {
    insert,
    update,
    deletetion,
    getAll,
    getById
}