<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções Recursiva</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Exercício 2 - Custo Safra</h4>
            <br>
            <?php 
                $area_hectare = 1287;
                $metro_hectare = 5267;
                $custo_cubico = 0.17;
            //Função para Calcular o custo
            function calculasafra(&$custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico){
              //calcular a quantidade de agua e imprimir;
             
              $qnt_agua = $area_hectare * $metro_hectare; 
                
                //custo da implantação e imprimir
                $custo_implantacao = ($custo_implantacao * $area_hectare) + ($qnt_agua * $custo_cubico);
                echo "Quantidade de m³ gasto de agua: " . number_format($qnt_agua, 2, ",",".") . " m³<br>";                                     
                echo "Custo da safra: R$ " . number_format($custo_implantacao, 2, ",",".") . " m³<br>";                                                     
                //retornar a quantidade de agua.
                return $qnt_agua;
            }
            /************************************************/
            /***************Primeiro Ano ********************/
            /************************************************/
            echo "<h1>Primeiro Ano</h1>";
            /*************Primeira Safra do ano *************/
            echo "<h3>Primeiro Safra do ano</h3>";
            $custo_implantacao = 1000;
            $qnt_agua = calculasafra($custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico);
            //quantidade de agua no ano;
            $qnt_agua_ano = $qnt_agua;
            //Custo da safra do ano;
            $custo_safra_ano = $custo_implantacao;

            /*************Segunda Safra do ano *************/
            echo "<h3>Segunda Safra do ano</h3>";
            $custo_implantacao = 1000;
            $qnt_agua = calculasafra($custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico);
            //quantidade de agua no ano;
            $qnt_agua_ano += $qnt_agua;
            //Custo da safra do ano;
            $custo_safra_ano += $custo_implantacao;

            /*************Terceira Safra do ano *************/
            echo "<h3>Terceira Safra do ano</h3>";
            $custo_implantacao = 1000;
            $qnt_agua = calculasafra($custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico);
            //quantidade de agua no ano;
            $qnt_agua_ano = $qnt_agua_ano + $qnt_agua;
            //Custo da safra do ano;
            $custo_safra_ano += $custo_implantacao;
            $custo_cinco_anos = $custo_safra_ano;
            
            echo "<br>Quantidade de m³ gasto de agua: " . number_format($qnt_agua_ano, 2, ",",".") . " m³<br>";                                     
            echo "Custo ano: R$ " . number_format($custo_safra_ano, 2, ",",".") . " m³<br>";                                                     
        

            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>