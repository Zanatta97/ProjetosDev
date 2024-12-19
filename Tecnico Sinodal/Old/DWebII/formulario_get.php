<?php 
		include 'header.php';
		$aula_atual = 'variaveis-superglobais';
	?>

	<body>

		<h2>GET</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
        <h1>Validar Notas</h1>
            <form action="formulario_proc_get.php" method="GET">
                Nota: <input type="text" name="nota" placeholder="Digte a nota" require><br> <br>
                      <input type="submit" value= "Validar">                  
            </form>
          
		
            

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>