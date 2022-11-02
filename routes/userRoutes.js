const controller = require('../controllers/userController');
const express = require('express');

const router = express.Router();

router.get('/sign-up', controller.signUp);
router.post('/newUser', controller.newUser)
router.get('/login', controller.login);
router.get('/user/:id', controller.userDetails);

module.exports = router;