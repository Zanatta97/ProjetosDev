<?php

header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $id_pk_cliente = $_POST["id_pk_cliente"];
    $nome_cliente = $_POST["nome_cliente"];
    $email_cliente = $_POST["email_cliente"];
    $senha_cliente = $_POST["senha_cliente"];   
    $telefone_cliente = $_POST["telefone_cliente"]; 
    $status_cliente = $_POST["status_cliente"];
    $token_cliente = $_POST["token_cliente"];

    $sql = "UPDATE clientes 
          SET nome_cliente='$nome_cliente',
          email_cliente='$email_cliente',
          senha_cliente='$senha_cliente',
          telefone_cliente='$telefone_cliente',
          status_cliente='$status_cliente',
          token_cliente='$token_cliente'                               
         WHERE id_cliente = '$id_pk_cliente'";

    if (mysqli_query($con, $sql))
     {
           echo "Sucesso";
           
      } else {
      
           echo "Erro ".$sql;
      }

    mysqli_close($con); 
    
} else {

   
	echo "Acesso Negado";
}

?>