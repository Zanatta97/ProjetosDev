<?php 
		include 'header.php';
		$aula_atual = 'strings';
	?>


	<body>

		<h2>STRINGS</h2>
		<hr>
		<small>Desenvolvimento Web II</small>

		<h3>Uma string é uma série de caracteres, onde um caractere é o mesmo que um byte</h3>
		
		<?php 
			$str = 'Eu sou uma string';
		?>
		<br>
		<h4>Valor da variável string:</h4>
		<?php echo $str;?>
		<br>		
		<h4>Nro de caracteres:</h4>
		<?php echo strlen($str);?><br>

		<h4>Primeiro caracter:</h4>
		<?php echo $str[0];?>
		<br>
		<h4>Ultimo caracter:</h4>
		<?php echo $str[-1];?>
		<br>
		
		<h4>Como extrar parte de uma string:</h4>
		<?php echo substr($str,0,2);?>
		<br>
		<h3>Exemplo de Chassi - Trabalhando com Strings</h3>
		<?php 
			$chassi = '9BWZZZ377TT123456';
		?>
		<br>
		<h4>Chassi: </h4>
		<?php echo $chassi;?>
		<br>
		<h4>Código do País: </h4>
		<?php echo substr($chassi,0,3);?>
		<br>
		<h4>Modelo do Veículo: </h4>
		<?php echo substr($chassi,6,3);?>
		<br>
		<h4>Nro de série do Veículo: </h4>
		<?php echo substr($chassi,11);?>
		<br>

		<h3>Como limpar strings</h3>
		<?php 
			$email = '      edisonmello@gmail.com  ';
			$site = 'http://www.sinodalprogresso.com.br';
		?>
		<br>
		<h4>Limpar email: </h4>
		<?php echo trim($email);?>
		<br>
		<h4>Limpar site: </h4>
		<a href="<?php echo $site;?>"><?php echo trim($site,'http://')?> </a>
		<br>


		<h3>Agora é a sua vez</h3>

			<p>Use este espaço para testar novas funções com strings.</p>
			<br>


	<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>