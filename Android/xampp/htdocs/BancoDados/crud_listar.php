<?php
    include_once("conexao.php");
    session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>CRUD Listar</title>
    </head>
    <body>    
        <?php


        ?>
            <a href="crud_inserir.php">Cadastrar</a>
        <?php
            echo "<h1>Listar Usuários</h1>";
            if(isset($_SESSION['msg'])){
                echo "<p>" . $_SESSION['msg']."</p>";
                unset($_SESSION['msg']);
            }
            //Criar uma Variável que recebe o SQL
            
            $result_qnt_user = "SELECT COUNT(id) AS qnt_usuarios FROM usuarios";
            $resultado_qnt_user = mysqli_query($con,$result_qnt_user);
            $row_qnt_user = mysqli_fetch_assoc($resultado_qnt_user);
            echo "<h3>Quantidade de Usuários: " . $row_qnt_user['qnt_usuarios'] . "</h3>";

            $monta_SQL = "SELECT user.*, 
                                 sit.nome nome_sit,
                                 nivac.nome nome_niv_ac
                          FROM usuarios user
                INNER JOIN situacao sit ON sit.id = user.situacao_id
                INNER JOIN niveis_acessos nivac ON nivac.id = user.niveis_acesso_id";
            $retorno_SQL = mysqli_query($con,$monta_SQL);

            while($row_usuarios = mysqli_fetch_assoc($retorno_SQL)){
                echo "ID: " . $row_usuarios['id'] . "<br>";
                echo "Nome: " . $row_usuarios['nome'] . "<br>";
                echo "E-mail: " . $row_usuarios['email'] . "<br>";
                echo "Situação: " . $row_usuarios['nome_sit'] . "<br>";
                echo "Nível de acesso: " . $row_usuarios['nome_niv_ac'] . "<br>";
                //Incluir o Link do Editar
                echo "<a href='crud_editar.php?id=" . $row_usuarios['id'] . "'>Editar</a><br>";
                echo "<a href='crud_deletar.php?id=" . $row_usuarios['id'] . "'>Apagar</a><hr>";                
            }

        ?>      
   </body>    
</html>