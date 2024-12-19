<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Sintaxe básica</h4>
            <br>
            <?php 
                $codigo = "Curso WEB";
                function promocao($codigo){
                    if($codigo == "Curso WEB" ){
                        $msg = "Código Válido";
                    }else {
                        $msg = "Código inválido";
                    }
                    return $msg;
                }
                $codigo1 = "cursophp";
                echo promocao($codigo1);
                //echo promocao();
            ?>
            <br>
            <h4>Passagem por parâmetro - Valor</h4>
            <br>
            <?php 
                
                function salario($num){
                    $num += 5;
                    echo "Salario com aumento : $num <br> ";
                }
                
                $salario = 9800;
                salario($salario);
                echo "Salario Sem alterar a variavel : $salario <br> ";
            ?>
            <br>
            <h4>Passagem por parâmetro - Referência</h4>
            <br>
            <?php 
                
                function salarioa(&$num){
                    $num += 10;
                    echo "Salario com aumento : $num <br> ";
                }
                
                $salarioa = 9800;
                salarioa($salarioa);
                echo "variável salario é alterado : $salarioa <br> ";

                
            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>