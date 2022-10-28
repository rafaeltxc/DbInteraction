const {db} = require('../connection.js');

function insert(firstName, lastName, email, birth) {
    if(db.state === 'connected') {
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
    if(db.state === 'connected') {
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
    if(db.state === 'connected') {
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
    if(db.state === 'connected') {
        db.connect();
    }
    const query = 'SELECT * FROM tbl_user;';
    return new Promise((resolve, reject) => {
        db.query(query, (err, rows) => {
            if(err) {
                reject(err);
            }
            resolve(rows);
        })
        db.end();
    })
}

function getById(id) {
    if(db.state === 'connected') {
        db.connect();
    }
    const query = `SELECT * FROM tbl_user WHERE id_user = ${id}`;
    return new Promise((resolve, reject) => {
        db.query(query, (err, rows) => {
            if(err) {
                reject(err);
            }
            resolve(rows);
        })
        db.end();
    })
}

let pad = function(num) { return ('00'+num).slice(-2) };
let date;
date = new Date();
date = date.getUTCFullYear()         + '-' +
        pad(date.getUTCMonth() + 1)  + '-' +
        pad(date.getUTCDate());

module.exports = {
    insert,
    update,
    deletetion,
    getAll,
    getById
}