<?php 
		include 'header.php';
		$aula_atual = 'arrays';
	?>


	<body>

		<h2>ARRAYS</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
			<?php 
			//Declaração simples de um array
			//	$cursos = array("Python","HTML","PHP");
							?><br>
			<!-- <h4>Conteúdo do array </h4> -->
			<!-- <p> <?php //echo $cursos[0] . ' / ' . $cursos[1] . ' / ' . $cursos[2]  ?></p> -->
	
			<?php 
				//Declaração de um array associativo
				// $cursos = array("Curso 1" => "Python",
				// 				"Curso 2" => "HTML",
				// 				"Curso 3" => "PHP"
				// 	           );
							?><br>
			
			<!-- <h4>Conteúdo do array </h4> -->
			
			<!-- <p> <?php //echo $cursos['Curso 2']  ?></p> -->

		<?php 
				//Declaração de um array associativo
				$cursos = array(
								"Python" => array(
												   "n_alunos" => 100,
												   "titulo" => "Básico",
												   "aval" => 200,
												   "url" => 'http//sinodalprogresso.com.br'		
								),
								"HTML" => array(
									"n_alunos" => 120,
									"titulo" => "Básico",
									"aval" => 150,
									"url" => 'http//sinodalprogresso.com.br'		
								),
								"PHP" => array(
									"n_alunos" => 50,
									"titulo" => "Básico",
									"aval" => 40,
									"url" => 'http//sinodalprogresso.com.br'		
				 				)
				);?><br>
			
			<h3>Informções dos Cursos</h3>
				<h4>Título: </h4>
			    <p> <?php echo $cursos['HTML']['titulo']  ?></p><br>			

				<h4>Número de alunos: </h4>
			    <p> <?php echo $cursos['HTML']['n_alunos'] ?></p><br>			

				<h4>Avaliações: </h4>
			    <p> <?php echo $cursos['HTML']['aval'] ?></p><br>			

				<h4>Url: </h4>
			    <p> <?php echo $cursos['HTML']['url'] ?></p><br>			

		<h3>Agora é a sua vez</h3>

			<p>Crie um Array e solte as suas informações em sequência. Pesquise também funções que podem ser aplicadas neste tipo de dados.</p>
			<br>






		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>