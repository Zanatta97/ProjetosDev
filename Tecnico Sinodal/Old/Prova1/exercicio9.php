<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$resposta =array("S","S","S","N","S","N","N","S","S","S","S","N","S","S"
			,"N","S","S","S");
			$contadorSim = 0;
			$contadorNao = 0;
			foreach($resposta as $valor){
			if ($valor == "S"){
			$contadorSim++;
			} else {
			$contadorNao++;
			}
			}
			echo "$contadorSim pessoas disseram que sim </br>" . 
			"</br>E $contadorNao pessoas disseram que não";
		?>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>