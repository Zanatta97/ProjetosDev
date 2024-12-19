<?php

header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $idpk = $_POST["idpk"];
    $materia = $_POST["materia"];
    $bimestre = $_POST["bimestre"];
    $situacao = $_POST["situacao"];
    $mediaFinal = $_POST["mediaFinal"];   
    $notaProva = $_POST["notaProva"]; 
    $notaMateria = $_POST["notaTrabalho"];

    $sql = "UPDATE media_escolar
         SET materia='$materia',
             bimestre='$bimestre',
             situacao='$situacao',
             mediaFinal='$mediaFinal',
             notaProva='$notaProva',
             notaTrabalho='$notaMateria'                                  
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