<?php
    include_once('conexao.php');
    //codigo 	nome 	email 	telefone 	data 	qtn_pessoas

    //nome=&email=&mensagem=&telefone=&data=&pessoas=&
    $dados = [
        'nome'=>$_GET["nome"],
        'email' =>$_GET["email"],
        'mensagem' =>$_GET["mensagem"],
        'telefone' =>$_GET["telefone"],
        'dia'  =>$_GET["data"],
        'qtn_pessoas'  =>$_GET["pessoas"]

    ];

    $strSelect = 'INSERT INTO reservas SELECT IFNULL(MAX(codigo), 0) + 1, :nome, :email, :mensagem, :telefone, :dia, :qtn_pessoas FROM reservas';
    //INSERT INTO reservas SELECT IFNULL(MAX(codigo), 0) + 1, 'Samuel Zanatta', 'sa.zanatta@hotmail.com', 'teste 123', '(51)98150-5157', '07/12/2019 20:00', 2 FROM reservas
    $validacao = false;
    try{
        $stmt = $conn->prepare($strSelect); 
        $result = $stmt->execute($dados);
        $validacao = true;  
    }catch(Exception $e){
        $validacao = false;    
    }

    if ($result > 0){
        header("Location:index.php?num=1");
    }else{
        header("Location:index.php?num=0");
    }

    /* CREATE TABLE reservas (
        codigo varchar(30) NOT NULL,
        nome varchar(50) NOT NULL,
        email varchar(50) NOT NULL,
        telefone varchar(500) DEFAULT NULL,
        data varchar (30),
        qtn_pessoas int(11)

      ) */
?>
