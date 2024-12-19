<?php 
		include 'header.php';
		$aula_atual = 'variaveis';
	?>


	<body>
		<?php
			$produtos = array(
				"codigos" => array(1, 2, 3, 4),
				"produtos" => array("Maçã", "Banana", "Cebola", "Tomate"),
				"aumento" => array(20, 35, 12, 3)
			);
            $codigo = $_GET["codigo"];
			$preco = $_GET["preco"];
			
			$produto = $produtos["produtos"][$codigo - 1];
			$porcentagem = $produtos["aumento"][$codigo - 1];
			$diferenca = $preco / 100 * $porcentagem;
			$precofinal = $preco + $diferenca;

			echo "Produto: $produto</br>";
			echo "</br>Código: $codigo</br>Preço Anterior: R$" . number_format($preco, 2, ",", ".") . " </br></br>";
			echo "Aumentou R$" . number_format($diferenca, 2, ",", ".") . "</br>";
			echo "Passou a custar R$" . number_format($precofinal, 2, ",", ".") . "</br></br>";
		?>
        <a href="prova5.php">Voltar</a>
		<?php include 'functions/bottom_index.php'; ?>
	</body>

</html>