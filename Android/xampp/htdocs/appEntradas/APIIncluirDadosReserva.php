<?php
header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $id_cliente = $_POST["id_cliente"];
    $nome_cliente = $_POST["nome_cliente"];
    $id_empresa = $_POST["id_empresa"];
    $qtd_pessoas = $_POST["qtd_pessoas"];   
    $hora_reserva = $_POST["hora_reserva"]; 
    $status_reserva = $_POST["status_reserva"];
    $telefone_cliente = $_POST["telefone_cliente"];

    $sql = "INSERT INTO reservas
                   (id_cliente, nome_cliente, id_empresa, qtd_pessoas, hora_reserva,
                   status_reserva, telefone_cliente)
    VALUES ('$id_cliente', '$nome_cliente', '$id_empresa', '$qtd_pessoas', '$hora_reserva',
            '$status_reserva', '$telefone_cliente')";
            
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