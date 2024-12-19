<?php

header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $id_pk_reserva = $_POST["id_pk_reserva"];
    
    $sql = "DELETE FROM reservas                                 
         WHERE id_reserva = '$id_pk_reserva'";

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