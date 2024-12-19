<?php
// Configura o Script para receber e enviar respostas
// no formato JSON
//header('Content-Type: application/json; charset=utf-8');
header('Content-Type: text/html; charset=utf-8');

// Carrega os dados das variáveis para a conexão com o
// Banco de Dados
include 'db_config.php';

// Abre uma onexão com o Banco de Dados
$conn = new mysqli($HostName, $HostUser, $HostPass, $DataBaseName);

// Configura o ENCODE para utf8
// Muito importante para apresentar os caracteres
// Acentuados e especiais
mysqli_set_charset($conn, "utf8");

// Verifica se a conexão com o DB falhou
if ($conn->connect_error) {

    echo "<p>FALHA AO ACESSAR O BANCO DE DADOS<p>";

    //die("Falha na conexão: " . $conn->connect_error);
    echo "<p>Falha na conexão: " . $conn->connect_error."</p>";
    
}else{

	echo "<p>CONECTADO COM SUCESSO</p>";
   
}

 echo "Servidor: <strong>".$HostName."</strong><br>";
 echo "Banco de Dados: <strong>".$DataBaseName."</strong><br>";

// Fecha a conexão com o Banco de Dados
$conn->close();
?>