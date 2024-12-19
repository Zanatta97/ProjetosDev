<?php
    $servidor = "localhost:3306";
    $usuario = "root";
    $senha = "";
    $dbname = "dweb";

    $con = mysqli_connect($servidor,$usuario,$senha,$dbname);

    if(!$con) {
        die("Falha de conexão " . mysqli_connect_error() );
    }else{
        echo "Conexão realizada com sucesso";
    }




?>