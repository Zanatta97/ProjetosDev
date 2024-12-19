<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções Recursiva</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Exemplo 1</h4>
            <br>
            <?php 
                function exibe($num){
                    if($num != 0){
                        echo "Valor passado para a função: $num; <br>";
                        exibe($num-1);
                    }
                }
                exibe(10);

            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>