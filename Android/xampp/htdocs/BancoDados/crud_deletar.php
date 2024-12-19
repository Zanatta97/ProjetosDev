<?php
    session_start();
    include_once("conexao.php");

    $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);      
    //comando para inserir os dados.
    $result_usuarios = "DELETE FROM usuarios WHERE id='$id'";
    
    $resultado_usuarios = mysqli_query($con,$result_usuarios);

    if(mysqli_affected_rows($con)){
        $_SESSION['msg'] = "<span style='color:green;'>'Usuário excluído com Sucesso!</span>";
        header("Location: crud_listar.php");
    }else{
        $_SESSION['msg'] = "<span style='color:red;'>'Problema ao excluir o usuário!</span>";
        header("Location: crud_listar.php");
    }


    


 