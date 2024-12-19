<?php

header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $idpk = $_POST["idpk"];
    
    $sql = "DELETE FROM media_escolar                                 
         WHERE id = '$idpk'";

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