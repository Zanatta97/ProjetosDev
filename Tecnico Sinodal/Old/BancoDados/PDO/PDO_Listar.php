<?php
  //  include_once("conexao.php");
    session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>PDO Listar</title>
    </head>
    <body>  
        <?php
            //Conexão PDO
            $servidor = "localhost:3306";
            $usuario = "root";
            $senha = "";
            $dbname = "teste";

            $conn = new PDO ("mysql:dbname=teste;host=localhost","root","");
        ?>
        <?php
            //Criar uma Variável que recebe o SQL
            $monta_SQL = $conn->prepare ("SELECT user.*, 
                                         sit.nome nome_sit,
                                         nivac.nome nome_niv_ac
                                    FROM usuarios user
                            INNER JOIN situacao sit ON sit.id = user.situacao_id
                            INNER JOIN niveis_acessos nivac ON nivac.id = user.niveis_acesso_id");
                        
            $monta_SQL->execute();
            $resultado_usuarios = $monta_SQL->fetchAll(PDO::FETCH_ASSOC);

            foreach ($resultado_usuarios as $row){
                foreach ($row as $key => $value ){
                    echo "<b>" . $key . "</b>: " .$value . "<br>"; 
                }
                // print("<pre>".print_r($row,true)."</pre>");
                
            }

          

        ?>      
   </body>    
</html>