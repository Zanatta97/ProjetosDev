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
                $num_safra = 0;
                $qnt_agua_ano = 0;
                $custo_safra_ano = 0;
                $custo_cinco_anos = 0;
                $custo_implantacao = 0; 
            //Função para Calcular o custo
            function calculasafra($custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico,
                                  $num_safra,$qnt_agua_ano, $custo_safra_ano, $custo_cinco_anos){
              //Calcular o gasto da safra;
             
              //Calcular o gasto do ano;

              //Imprimir os custos da safra;
              echo "<h3>" . $num_safra . " Safra</h3>";
              echo "<br>Quantidade de m³ gasto de água: " . number_format($qnt_agua, 2, ",", ".") . " m³<br>";
              echo "Custo ano: R$" . number_format($custo_implantacao, 2, ",", ".") . "<br><hr>";
              //Incluir um teste para verificar se é a terceira Safra
              if ($num_safra % 3 == 0){
                echo "<br>Quantidade de m³ gasto de água: " . number_format($qnt_agua_ano, 2, ",", ".") . " m³<br>";
                echo "Custo ano: R$" . number_format($custo_safra_ano, 2, ",", ".") . "<br><hr>";
                $custo_cinco_anos += $custo_safra_ano;
                $custo_safra_ano = 0;
                $qnt_agua_ano = 0;  
              }
              //Incluir um teste para identificar a quantidade de safra. Se for menor que 15 acessa novamente a função. Senão
              //Cai fora pois já percorreu os cinco anos.
              if ($num_safra < 15){
                calculasafra();

                if($num_safra < 12){
                    $custo_implantacao = 1000;
                } else {
                    $custo_implantacao = 0;
                }
                $num_safra++;
                $qnt_agua = calculasafra($custo_implantacao,$area_hectare,$metro_hectare,$custo_cubico,
                $num_safra,$qnt_agua_ano, $custo_safra_ano, $custo_cinco_anos);
              } else {
                //*************************************Conclusão após 5 anos*******************/
                echo "Custo de 5 anos: R$" . number_format($custo_safra_ano, 2, ",", ".") . "<br><hr>";
              }

            }
           

            ?>



		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>