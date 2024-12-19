<?php
header ('Content-Type: application/json');
ini_set('default-charset','utf-8');

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
    require_once('db_connect.php');

    mysqli_set_charset($con, "utf-8");

    $uf = $_POST['uf'];

    $statement = mysqli_prepare($con, "SELECT Id, Nome FROM `municipio` WHERE Uf='".$uf."' ORDER BY Nome");

    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);

    mysqli_stmt_bind_result($statement, $id, $nome);

    if (mysqli_stmt_num_rows($statement) > 0){
        while (mysqli_stmt_fetch($statement)){
            array_push($response, array(
                "Id" => $id,
                "Nome" => $nome)
            );
        } 

    } else {
        $response["sucesso"] = false;
    }

    echo json_encode($response); 

}

?>