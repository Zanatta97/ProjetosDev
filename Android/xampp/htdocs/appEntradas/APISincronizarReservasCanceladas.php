<?php

header('Content-type: application/json');

ini_set('default_charset', 'utf-8');

$response = array();
$idEmpresa = $_POST["id_empresa"];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    date_default_timezone_set('America/Sao_Paulo');
    $date = date('Y-m-d', time());

    $statement = mysqli_prepare($con, 
    "SELECT * from reservas where id_empresa= '$idEmpresa' and date(hora_reserva) = '$date' and (status_reserva = 'Cancelada' OR status_reserva = 'Entrou') order by hora_reserva");

    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,
						    $id_reserva,
                            $id_cliente,
                            $nome_cliente,
						    $id_empresa,
						    $qtd_pessoas,
						    $hora_reserva,
						    $status_reserva,
						    $telefone_cliente); 

    if (mysqli_stmt_num_rows($statement) > 0) {

        while (mysqli_stmt_fetch($statement)) {

            array_push($response, array(
                "id_reserva" => $id_reserva,
                "id_cliente" => $id_cliente,
                "nome_cliente" => $nome_cliente,
                "id_empresa" => $id_empresa,
                "qtd_pessoas" => $qtd_pessoas,
                "hora_reserva" => $hora_reserva,
                "status_reserva" => $status_reserva,
                "telefone_cliente" => $telefone_cliente
                )
            );
        }
        
          
          
    } else {
    
           $response["sucesso"] = false;
    }

    echo json_encode($response);
    
} else {

    
    $response["sucesso"] = false;
    
    echo json_encode($response);
}
?>
	