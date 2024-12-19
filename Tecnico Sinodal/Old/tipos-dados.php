<?php 
		include 'header.php';
		$aula_atual = 'tipos-dados';
	?>


	<body>

		<h2>Tipos de Dados</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
		<br>
		<small>Quatro Grupos escalares:</small>
		<br>
			<ul>
				<li>string</li>
				<li>boolean</li>
				<li>integer</li>
				<li>float (número de ponto flutuante, ou também double)</li>
			</ul>

		<small>Tres Grupos Compostos:</small>
		<br>
			<ul>
				<li>array</li>
				<li>object</li>
				<li>Callback e callable</li>
			</ul>	

			<small>Dois Tipos Especiais:</small>	
			<br>
				<ul>
					<li>Null</li>
					<li>resource</li>
				</ul>						
		<h3>Função var_dump</h3>

		<?php 
			$str = 'Eu sou uma string';
		?>

		<h4>Valor da variável string:</h4>
		<?php var_dump($str);?>

	

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>