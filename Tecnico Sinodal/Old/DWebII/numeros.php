<?php 
		include 'header.php';
		$aula_atual = 'numeros';
	?>


	<body>

		<h2>NÚMEROS</h2>
		<hr>
		<small>Desenvolvimento Web II</small>

		<h3>Operadores Aritméticos</h3>
		<?php echo 7*2 ?><br>
		<?php echo 7/2 ?><br>
		<?php echo 7**2 ?><br>
		<?php echo 7%2 ?><br>

		<?php 
			$quant = 60;
			$preco = 29.00;
			$cod = "330745";

			//Cálculo do Total
			$total = $quant * $preco;
		?>
		<br>
		<table>
			<tr>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Total</th>
			</tr>
			<tr>
				<td><?php echo $cod; ?></td>
				<td><?php echo $quant ?></td>
				<td><?php echo number_format($preco,2); ?></td>
				<td><?php echo number_format($total,2,",",".") ?></td>
			</tr>				
		</table>
	
		<h3>Agora é a sua vez</h3>

			<p>Pesquise outros operadores aritméticos e funções matemáticas em PHP e use este espaço para testá-los.</p>
			<br>

	<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>

