<?php 
		include 'header.php';
		$aula_atual = 'variaveis-superglobais';
	?>

	<body>

		<h2>Variáveis SuperGlobais</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<!-- <h2>$_SERVER</h2>
            <br>
            <pre><?php //print_r($_SERVER);?><pre>
            <br> -->

            <h2>$GLOBALS</h2>
            <br>
            <pre><?php print_r($GLOBALS);?><pre>
            <br>
            
            <?php
                $msg = "Olá Pessoal";
                $bye = "Tchau Pessoal";

                function mensagem(){
                    echo $GLOBALS["msg"];
                }
                mensagem();
            ?>
            

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>