<?php
    include_once("conexao.php");
    session_start();
    $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);
    $comando_sql = "SELECT * FROM usuarios WHERE id='$id' ";
    $resultado_sql = mysqli_query($con,$comando_sql);
    $row_usuario = mysqli_fetch_assoc($resultado_sql);
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Crud Editar</title>
    </head>
    <body>    
        <a href="crud_listar.php">Listar</a>
        <h1>Alterar Usuários</h1>
        <?php
            
        ?>      
        <form method="POST" action="crud_proc_editar.php">
            <label>Nome: </label>
            <input type="text" name="nome" value="<?php echo $row_usuario['nome'];?>"><br><br>

            <label>E-mail: </label>
            <input type="email" name="email" value="<?php echo $row_usuario['email'];?>"><br><br>

            <input type="hidden" name="id" value="<?php echo $row_usuario['id'];?>"><br><br>

            <input type="submit" value="Editar">
        </form>
   </body>    
</html>