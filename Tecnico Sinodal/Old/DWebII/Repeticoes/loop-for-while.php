<?php 
		include 'header.php';
		$aula_atual = 'arrays';
	?>


	<body>

		<h2>Loops For e While</h2>
		<hr>
		<small>Desenvolvimento Web II</small>
		<h3>Selecione o ano de nascimento</h3>

        <?php 
            $ano_atual = date('Y');
            $ano = $ano_atual;
        ?>
        <select>
            <option>Selecione o ano de nascimento</option>
            <?php while ($ano >= 1980) {?>
                <option><?php echo $ano; ?></option>
                <?php $ano--; ?>
               <?php } ?>            
        </select>

		<?php include 'functions/bottom_index.php'; ?>


	</body>

</html>