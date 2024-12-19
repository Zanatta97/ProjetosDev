<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Variáveis SuperGlobais</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h2>$_SERVER</h2>
            <br>
            <pre><?php print_r($_SERVER);?><pre>
            <br>

            <h2>$_SERVER</h2>
            <br>
            <pre><?php print_r($GLOBALS);?><pre>
            <br>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>