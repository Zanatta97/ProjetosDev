<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
	<form action="exercicio5.php" method="get">
		<!-- Dados Usuário-->
		<h1>Formulários</h1>
		<h2>Exercício 5</h2>
		<fieldset id="preco">
		<label>Código: *</label></br>
		<input type="number" min="1" max="4" name="codigo" id="edCodigo" placeholder="Código" required>
		</br></br>
		<label>Preço: *</label></br>
		<input type="number" min="0.01" max"10000.00" step="0.01"name="preco" id="edPreco" placeholder="Digite o preço do produto" required>

		<br>
		<br>
		<button> Enviar </button>
	</form>
		<?php

		?>
		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>