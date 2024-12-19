<!DOCTYPE html>
<html>
	<head lang="pt-br">
		<meta charset="utf-8">
		<title>Operadores</title>
	<body>
		<h2>Operadores Lógicos</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
		<br><br>
		<?php 	
			$a = 10;
			$b = 8;
			$c = 2;

			if (($a == 10) AND ($b == 7)){
				echo "Utilizando o AND: Verdadeiro <br>";
			}else {
				echo "Utilizando o AND: False <br>";
			}

			if (($a == 10) OR ($b == 7)){
				echo "Utilizando o OR: Verdadeiro <br>";
			}else {
				echo "Utilizando o OR: False <br>";
			}

			if (($a == 10) XOR ($b == 7)){
				echo "Utilizando o OR: Verdadeiro <br>";
			}else {
				echo "Utilizando o OR: False <br>";
			}

			if (!empty($c)){
				echo "Utilizando o !: Verdadeiro <br>";
			}

			if (($a == 10) && ($b == 8)){
				echo "Utilizando o &&: Verdadeiro <br>";
			}else {
				echo "Utilizando o &&: False <br>";
			}

			if (($a == 10) || ($b == 8)){
				echo "Utilizando o || Verdadeiro <br>";
			}else {
				echo "Utilizando o ||: False <br>";
			}
		?>
		
	</body>

</html>