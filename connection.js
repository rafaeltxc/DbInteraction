const { MongoClient } = require('mongodb');

async function connect(callback) {

    return await MongoClient.connect('mongodb://localhost:27017/User')
        .then((client) => {
            callback();
            return client;
        })
        .catch((err) => {
                return callback(err);
            }
        );
}

let db = connect((err) => {
    if(err) {
        throw err;
    }
}).then((result) => {
    db = result;
})

module.exports = {
    connect,
    instance: () => db
}