<?php 
		include 'header.php';
		$aula_atual = 'funcoes';
	?>

	<body>

		<h2>Funções Recursiva</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
        <br>
			<h4>Exercício 1</h4>
            <br>
            <?php 
                function exibe($num){
                    if($num <= 10){
                        echo "Item do submenu: $num; <br>";
                        exibe($num+1);
                    }
                }
                
                echo "<br> Item do menu: 1 <br>";
                exibe(5);

                echo "<br> Item do menu: 2 <br>";
                exibe(5);
                
                echo "<br> Item do menu: 3 <br>";
                exibe(5);
                
                echo "<br> Item do menu: 4 <br>";
                exibe(5);
                
                echo "<br> Item do menu: 5 <br>";
                exibe(5);

            ?>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>