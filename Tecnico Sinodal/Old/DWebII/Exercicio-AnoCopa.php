<?php 
		include 'header.php';
		$aula_atual = 'loop-for-while';
	?>
	<body>
		<h2>Exercício Ano Copa</h2>
		<hr>
		<small>Desenvolvimento Web II</small>


        <?php 
            $ano_inicio_copa = 1930;        
            $ano_inicio_olimpiada = 1896;
            $ano_atual = date('Y');
            $primeiro_copa =  $ano_atual; 
            $primeiro_olimpiada =  $ano_atual; 
            //Pegar o próximo ano de copa a partir do ano atual. Para isso vamos
            //subtrair o ano atual do ano da primeira copa (1930). Se o resultado
            //dividido por 4 der um nro exato, sabemos que estamos em ano de copa.
            //senão entra em um loop até encontrar o próximo ano de copa.
            //lembrando que '%' é o operador módulo, que retorna o resto da divisão
            
            while((($primeiro_copa - $ano_inicio_copa) % 4) != 0  ){
                $primeiro_copa++;
            }

            while((($primeiro_olimpiada - $ano_inicio_olimpiada) % 4) != 0  ){
                $primeiro_olimpiada++;
            }
        ?>
            <br>
        <h4>Anos de Copa</h4>
        <p>
            <ul>
                <?php for ($a = $primeiro_copa; $a <= 2050; $a +=4 ) {?>
                    <li>
                        <?php echo $a ?>
                    </li>    
                <?php }?>
                
            </ul>
        </p>
        <br>
        <h4>Anos de Olimpíada</h4>
        <p>
            <ul>
                <?php for ($a = $primeiro_olimpiada; $a <= 2050; $a +=4 ) {?>
                    <li>
                        <?php echo $a ?>
                    </li>    
                <?php }?>
                
            </ul>
        </p>
       
        <br>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>

