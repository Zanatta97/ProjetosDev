<?php 
		include 'header.php';
		$aula_atual = 'variaveis-superglobais';
	?>

	<body>

		<h2>POST</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
        <h1>Receber dados da fazenda irrigada</h1>
            <form action="formulario_proc_post.php" method="POST">
                hectares: <input type="text" name="hectares" placeholder="Digite a qtde de hectares" require><br> <br>
                Qtde de m³: <input type="text" name="qnt_metros" placeholder="Digite a quantidade de m³ de agua" require><br> <br>
                Preço do m³: <input type="text" name="preco_metro" placeholder="Digite o preço do m³" require><br> <br>
                Valor agregado: <input type="text" name="valor_agregado" placeholder="Digite o valor agregado" require><br> <br>                
                      <input type="submit" value= "Cadastrar">                  
            </form>
          
		
            

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>