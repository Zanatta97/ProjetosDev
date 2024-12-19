<?php 
		include 'header.php';
		$aula_atual = 'variaveis-superglobais';
?>

<?php 
    $nota = $_GET['nota'];
    echo "Nota - " . $nota;
    
    if (($nota <= 4.9) and ($nota >= 0)) {
        echo " Reprovado";
    }else{
        echo " Aprovado";    
    }
    

?>
