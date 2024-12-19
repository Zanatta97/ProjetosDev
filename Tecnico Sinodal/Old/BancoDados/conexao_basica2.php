<?php
    $servidor = "localhost";
    $usuario = "root";
    $senha = "";
    $dbname = "dweb";
    $porta = "3306";

  //Criar objeto de conexão
  $con = new mysqli($servidor,$usuario,$senha,$dbname,$porta);

  if ($con->connect_error == true){
    echo "Falha de conexão";
  }else{
    echo "Conexão realizada com sucesso";
  }

?>