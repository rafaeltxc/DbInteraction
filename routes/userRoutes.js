const controller = require('../controllers/userController');
const express = require('express');

const router = express.Router();

router.get('/sign-up', controller.signUp);
router.post('/newUser', controller.newUser);
router.get('/login', controller.login);
router.post('/authentication', controller.authentication);
router.get('/user/:id', controller.user);
router.get('/logout', controller.logout);
router.get('/deleteUser', controller.deleteUser);
router.get('/userDetails', controller.userDetails);

module.exports = router;