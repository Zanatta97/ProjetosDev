<?php
define('HOST','localhost'); //informar endereço do servidor mysql
define('USER','root'); //informar nome de usuário
define('PASS',''); //informar senha do usuário
define('DB','db_media_escolar'); //informar nome do banco de dados.

$con = mysqli_connect(HOST,USER,PASS,DB) or die('Incapaz de acessar o banco de dados');
