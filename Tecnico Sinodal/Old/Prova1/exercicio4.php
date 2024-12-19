<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$valorTotal = 1220.44;
            $qtParcelas = 4;
            $valorParcelas = $valorTotal;
            $valorParcelas /= $qtParcelas;
            echo "$qtParcelas Parcelas: </br>";
            for ($c = 1; $c <= $qtParcelas; $c++){
            echo "R$" . number_format($valorParcelas, 2, ",", ".") . "</br>";
            }
		?>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>