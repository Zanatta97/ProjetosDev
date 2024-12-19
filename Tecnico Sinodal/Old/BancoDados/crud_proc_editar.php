<?php
    session_start();
    include_once("conexao.php");

    $nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_STRING);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);    
    $id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);      
    //comando para inserir os dados.
    $result_usuarios = "UPDATE usuarios 
                           SET nome = '$nome',
                               email = '$email',
                               dta_alteracao = NOW()
                        WHERE id='$id'";
    
    $resultado_usuarios = mysqli_query($con,$result_usuarios);

    if(mysqli_affected_rows($con)){
        $_SESSION['msg'] = "<span style='color:green;'>'Usuário alterado com Sucesso!</span>";
        header("Location: crud_listar.php");
    }else{
        $_SESSION['msg'] = "<span style='color:red;'>'Problema ao alterar o usuário!</span>";
        header("Location: crud_editar.php");
    }


    


 