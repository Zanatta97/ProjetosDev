<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>

		<h2>CONSTANTES</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
		<br>
		<small>Uma constante é um identificador (nome) para um valor único. Como o nome sugere, esse valor não pode mudar durante 
		a execução do script. As constantes são case-sensitive por padrão. Por convenção, identificadores de constantes são sempre 
		em maiúsculas.</small>
		<br>
		<h3>Apresentar valor de variáveis</h3>
		<?php 
			define('nome',"Edison Mello");
			define('saldo',7500.00);
		?>

		<h4>Nome:  </h4>	
		<p><?php echo nome?> </p>
		<br>

		<h4>Saldo:  </h4>	
		<p><?php echo saldo?> </p>
	

	
		

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>