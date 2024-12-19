<?php
    //Criar a sessão (sempre antes de usar ela deve ser criada)
    session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Exemplo de Sessão</title>
    </head>
    <body>    
        <?php
            $_SESSION['usuario'] = 'edison@gmail.com';
            $_SESSION['senha'] = '123@abc';
            echo "usuario: " .$_SESSION['usuario'] . "<br>";
            echo "senha: " .$_SESSION['senha'] . "<br>";

            unset($_SESSION['usuario'], $_SESSION['senha']);

            echo "usuario: " .$_SESSION['usuario'] . "<br>";
            echo "senha: " .$_SESSION['senha'] . "<br>";

        
        ?>      

   </body>    
</html>