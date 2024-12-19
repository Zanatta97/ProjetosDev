<?php
    session_start();
    include_once("conexao.php");

  //$nome = $_POST['nome'];
  //$email = $_POST['email'];

    $nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_STRING);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);    
    
    //comando para inserir os dados.
    $result_usuarios = "INSERT INTO usuarios (nome, email, situacao_id, niveis_acesso_id, qnt_acessos, dta_inclusao) 
    values ('$nome', '$email', 1, 1, 15, now())";
    $resultado_usuarios = mysqli_query($con,$result_usuarios);

    if(mysqli_insert_id($con)){
        $_SESSION['msg'] = "<span style='color:green;'>'Usuário Cadastrado com Sucesso!</span>";
        header("Location: crud_listar.php");
    }else{
        $_SESSION['msg'] = "<span style='color:red;'>'Problema ao Cadastrar o usuário!</span>";
        header("Location: crud_inserir.php");
    }


 