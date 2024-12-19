<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$reviews = array(9,8,5,7,8,9,10,9,10,8,7,10,9);
			$somatotal = 0;
			$contador = 0;
			foreach ($reviews as $nota){
			$somatotal += $nota;
			$contador ++;
			}
			$media = $somatotal/$contador;
			echo "A média é " . number_format($media, 2);
		?>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>