<?php

header('Content-type: application/json');

ini_set('default_charset', 'utf-8');

$response = array();
$email_cliente = $_POST["email_cliente"];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $statement = mysqli_prepare($con, 
    "SELECT * from clientes where email_cliente = '$email_cliente'");

    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,
                            $id_cliente, 
                            $nome_cliente, 
                            $email_cliente, 
                            $senha_cliente, 
                            $telefone_cliente,
                            $status_cliente, 
                            $token_cliente); 

    if (mysqli_stmt_num_rows($statement) > 0) {

        while (mysqli_stmt_fetch($statement)) {

            array_push($response, array(
                "id_cliente" => $id_cliente,
                "nome_cliente" => $nome_cliente,
                "email_cliente" => $email_cliente,
                "senha_cliente" => $senha_cliente,
                "telefone_cliente" => $telefone_cliente,
                "status_cliente" => $status_cliente,
                "token_cliente" => $token_cliente
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
	