<?php
header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $nome_empresa = $_POST["nome_empresa"];
    $cnpj_empresa = $_POST["cnpj_empresa"];
    $endereco_empresa = $_POST["endereco_empresa"];   
    $numero_empresa = $_POST["numero_empresa"]; 
    $complemento_empresa = $_POST["complemento_empresa"];
    $bairro_empresa = $_POST["bairro_empresa"];
    $cidade_empresa = $_POST["cidade_empresa"];
    $uf_empresa = $_POST["uf_empresa"];
    $cep_empresa = $_POST["cep_empresa"];
    $descricao_empresa = $_POST["descricao_empresa"];
    $abre_segunda = $_POST["abre_segunda"];
    $fecha_segunda = $_POST["fecha_segunda"];
    $abre_terca = $_POST["abre_terca"];
    $fecha_terca = $_POST["fecha_terca"];
    $abre_quarta = $_POST["abre_quarta"];
    $fecha_quarta = $_POST["fecha_quarta"];
    $abre_quinta = $_POST["abre_quinta"];
    $fecha_quinta = $_POST["fecha_quinta"];
    $abre_sexta = $_POST["abre_sexta"];
    $fecha_sexta = $_POST["fecha_sexta"];
    $abre_sabado = $_POST["abre_sabado"];
    $fecha_sabado = $_POST["fecha_sabado"];
    $abre_domingo = $_POST["abre_domingo"];
    $fecha_domingo = $_POST["fecha_domingo"];
    $token_firebase = $_POST["token_firebase"];
    $email_empresa = $_POST["email_empresa"];
    $senha_empresa = $_POST["senha_empresa"];

    $sql = "INSERT INTO empresas
                   (nome_empresa, cnpj_empresa, endereco_empresa,
                   numero_empresa, complemento_empresa, bairro_empresa, 
                   cidade_empresa, uf_empresa, cep_empresa, descricao_empresa, 
                   abre_segunda, fecha_segunda, abre_terca, fecha_terca, abre_quarta, 
                   fecha_quarta, abre_quinta, fecha_quinta, abre_sexta, fecha_sexta, abre_sabado, 
                   fecha_sabado, abre_domingo, fecha_domingo, token_firebase, email_empresa, senha_empresa)
    VALUES ('$nome_empresa', '$cnpj_empresa', '$endereco_empresa',
            '$numero_empresa', '$complemento_empresa', '$bairro_empresa',
            '$cidade_empresa', '$uf_empresa', '$cep_empresa', '$descricao_empresa', 
            '$abre_segunda', '$fecha_segunda', '$abre_terca', '$fecha_terca', '$abre_quarta', 
            '$fecha_quarta', '$abre_quinta', '$fecha_quinta', '$abre_sexta', '$fecha_sexta', '$abre_sabado', 
            '$fecha_sabado', '$abre_domingo', '$fecha_domingo', '$token_firebase', '$email_empresa', '$senha_empresa')";
            
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