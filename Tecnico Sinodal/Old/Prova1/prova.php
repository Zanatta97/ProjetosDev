<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
	<form action="exercicio10.php" method="get">
		<!-- Dados Usuário-->
		<h1>Formulários</h1>
		<h2>Envie seus dados</h2>
		<fieldset id="usuario">
		<label>Nome: *</label></br>
		<input type="text" name="nome" id="edNome" placeholder="Nome Completo" required>
		</br></br>
		<label>E-mail: *</label></br>
		<input type="email" name="email" id="edEmail" placeholder="Digite seu Email" required>

		<br>
		<br>
		<button> Enviar </button>
	</form>
		<?php

		?>
		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>