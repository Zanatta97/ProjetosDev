<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$salarioInicial = 7600.25;
            $comissao = 1321.45;
            $inss = 608.45;
            $irrf = 1364.65;
            $salarioFinal = 0;
            $salarioFinal += $salarioInicial;
            $salarioFinal += $comissao;
            $salarioFinal -= $inss;
            $salarioFinal -= $irrf;
            echo "Valor total a receber é R$" .
            number_format($salarioFinal, 2, ",",".");
		?>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>