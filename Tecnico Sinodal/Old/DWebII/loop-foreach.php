<?php 
		include 'header.php';
		$aula_atual = 'arrays';
	?>


	<body>

		<h2>ARRAYS</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
		<?php 
				//Declaração de um array associativo
				$cursos = array(
								"Python" => array(
												   "n_alunos" => 100,
												   "titulo" => "Aprenda Python",
												   "aval" => 200,
												   "url" => 'http://www.sinodalprogresso.com.br'		
								),
								"HTML" => array(
									"n_alunos" => 120,
									"titulo" => "Aprenda HTML",
									"aval" => 150,
									"url" => 'http://www.sinodalprogresso.com.br'		
								),
								"PHP" => array(
									"n_alunos" => 50,
									"titulo" => "Aprenda PHP",
									"aval" => 40,
									"url" => 'http://www.sinodalprogresso.com.br'		
                                ),
                                "Javascrip" => array(
									"n_alunos" => 120,
									"titulo" => "Aprenda Javascrip",
									"aval" => 40,
									"url" => 'http://www.sinodalprogresso.com.br'		
				 				)
				);?><br>
			
			<h3>Informações dos Cursos</h3>
                <?php 
                    //Declaração do Foreach
                    // foreach($cursos as $item){
                    //     echo $item['titulo'];
                    //     echo '<br>';
                    // }
                 ?>   
               <!-- Montagem da Lista em tempo de execução (loop)-->
               <ul>
                 <?php  foreach ($cursos as $item) { ?>
                    <li>
                        <a href="<?php echo $item['url']; ?>"><?php echo $item['titulo']; ?></a><br>
                        <?php echo $item['n_alunos'] . ' Alunos' . ' / ' . $item['aval'] . ' Avaliações ';?> <br>
                    </li><br>
                     
                    <?php }?>   
               </ul>

		<h3>Agora é a sua vez</h3>

			<p>Crie um Array e solte as suas informações em sequência.
               Entregar Na proxima aula.....
               Imagine um Computador com os seguintes dados.
               Modelo : Lenovo
               processador: Coloque um valor qualquer
               ram: Coloque um valor qualquer
               HD: Coloque um valor qualquer
               

            </p>
			<br>
            <?php
                
            ?>





		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>