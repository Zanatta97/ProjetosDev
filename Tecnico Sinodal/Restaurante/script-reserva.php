<?php
    include_once('conexao.php');
    //codigo 	nome 	email 	telefone 	data 	qtn_pessoas
    $dados = [
        'codigo'=>$tipoPrato,
        'nome' =>$tipoPrato,
        'email' =>$tipoPrato,
        'telefone' =>$tipoPrato,
        'data'  =>$tipoPrato,
        'qtn_pessoas'  =>$tipoPrato

    ];

    $strSelect = "";
    try{
        $stmt = $conn->prepare($strSelect); 
        $result = $stmt->execute($dados);
        header("Location:index.php?num=1");
    }catch(Exception $e){
        //echo $e->getMessage();
        header("Location:index.php?num=0");
    } 

    //header("Location:index.php?num=2");

    /* echo "<script type='javascript'>alert('Email enviado com Sucesso!');</script>";
    header("Location: index.php"); */
    


    //phpAlert(   "Reserva Efetuada com Sucesso!\\n\\nPHP has got an Alert Box"   );
?>