<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Exercício 2 Funcões Referência</h4>
            <br>

            <?php 
                $custo_producao = 560;
                
                function calcularcusto(&$custo_producao) {
                   $custo_producao = $custo_producao + ($custo_producao*0.70);
                }

                calcularcusto($custo_producao);
                echo "Valor final do custo de produção: R$ " . number_format($custo_producao,2,",",".") . "<br>";
            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>