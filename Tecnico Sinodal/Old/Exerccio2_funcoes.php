<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Exercício 2 Funcões</h4>
            <br>

            <?php 
                $qnt_carregados = 100;
                $qnt_carregar = 100;

                function carregamento($qnt_carregados = null, $qnt_carregar = null) {
                    if ($qnt_carregados == $qnt_carregar){
                        echo "Carregamento Concluído";
                    }else{
                        echo "Carregamento Pendente";
                    }
                }

                carregamento(120,200);
            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>