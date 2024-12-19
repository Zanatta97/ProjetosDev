<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$num = 120;
			$contador = 100;
			if ($num > 100){
			do{
			echo $contador . "</br>";
			$contador++;
			}while($contador <= $num);
			} else {
			echo "Número Inválido";
			}
		?>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>