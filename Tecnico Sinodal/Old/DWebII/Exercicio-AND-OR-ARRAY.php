<?php 
		include 'header.php';
		$aula_atual = 'loop-for-while';
	?>
	<body>
		<h2>Exercício AND OR com Array</h2>
		<hr>
		<small>Desenvolvimento Web II</small>


        <?php 
            $total_aulas = 20;
            $media_aprov = 6;
            $presenca_aprov = 0.7;

            $aluno = array(
                            'nome' => 'Edison Mello',
                            'media' => 7.5,
                            'faltas' => 6
            );
            //Calcular a presença do Aluno
            //Total de Aulas - Faltas do aluno dividido pelo total de aulas.
            $presenca_aluno = ($total_aulas-$aluno['faltas']/$total_aulas);     
        ?>
        <h2>AND</h2>
        <h3>Situação do Aluno</h3>
        <p>
            <?php 
                if ($aluno['media'] >= $media_aprov AND $presenca_aluno >= $presenca_aprov ){
                    echo "Aluno está Aprovado.";
                } else{
                    echo "Aluno está Reprovado.";
                }

            ?>
        </p>
        <br>
        <h2>OR</h2>
        <h3>Situação do Aluno</h3>
        <p>
            <?php 
                if ($aluno['media'] < $media_aprov OR $presenca_aluno < $presenca_aprov ){
                    echo "Aluno está Reprovado.";
                } else{
                    echo "Aluno está Aprovado.";
                }

            ?>
        </p>
        <br>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>