<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>

		<?php
            $nome = $_GET["nome"];
            $email = $_GET["email"];

            echo "Nome: $nome</br> Email: $email </br></br>";
		?>
        <a href="prova.php">Voltar</a>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>