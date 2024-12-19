<?php

header('Content-type: application/json');

ini_set('default_charset', 'utf-8');

$response = array();
$email_empresa = $_POST["email_empresa"];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $statement = mysqli_prepare($con, 
    "SELECT * from empresas where email_empresa= '$email_empresa'");

    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,
                            $id_empresa,
                            $nome_empresa,
                            $cnpj_empresa,
                            $endereco_empresa,   
                            $numero_empresa,
                            $complemento_empresa,
                            $bairro_empresa,
                            $cidade_empresa,
                            $uf_empresa,
                            $cep_empresa,
                            $descricao_empresa,
                            $abre_segunda,
                            $fecha_segunda,
                            $abre_terca,
                            $fecha_terca,
                            $abre_quarta,
                            $fecha_quarta,
                            $abre_quinta,
                            $fecha_quinta,
                            $abre_sexta,
                            $fecha_sexta,
                            $abre_sabado,
                            $fecha_sabado,
                            $abre_domingo,
                            $fecha_domingo,
                            $token_firebase,
                            $email_empresa,
                            $senha_empresa); 

    if (mysqli_stmt_num_rows($statement) > 0) {

        while (mysqli_stmt_fetch($statement)) {

            array_push($response, array(
                "id_empresa"=>$id_empresa,
                "nome_empresa"=>$nome_empresa,
                "cnpj_empresa"=>$cnpj_empresa,
                "endereco_empresa"=>$endereco_empresa,
                "numero_empresa"=>$numero_empresa,
                "complemento_empresa"=>$complemento_empresa,
                "bairro_empresa"=>$bairro_empresa,
                "cidade_empresa"=>$cidade_empresa,
                "uf_empresa"=>$uf_empresa,
                "cep_empresa"=>$cep_empresa,
                "descricao_empresa"=>$descricao_empresa,
                "abre_segunda"=>$abre_segunda,
                "fecha_segunda"=>$fecha_segunda,
                "abre_terca"=>$abre_terca,
                "fecha_terca"=>$fecha_terca,
                "abre_quarta"=>$abre_quarta,
                "fecha_quarta"=>$fecha_quarta,
                "abre_quinta"=>$abre_quinta,
                "fecha_quinta"=>$fecha_quinta,
                "abre_sexta"=>$abre_sexta,
                "fecha_sexta"=>$fecha_sexta,
                "abre_sabado"=>$abre_sabado,
                "fecha_sabado"=>$fecha_sabado,
                "abre_domingo"=>$abre_domingo,
                "fecha_domingo"=>$fecha_domingo,
                "token_firebase"=>$token_firebase,
                "email_empresa"=>$email_empresa,
                "senha_empresa"=>$senha_empresa)
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
	