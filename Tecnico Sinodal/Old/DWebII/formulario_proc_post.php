<?php 
		include 'header.php';
		$aula_atual = 'variaveis-superglobais';
?>

<?php 
    $hectares = $_POST['hectares'];
    $qnt_metros = $_POST['qnt_metros'];
    $preco_metros = $_POST['preco_metro'];
    $valor_agregado = $_POST['valor_agregado'];
    
    echo "Quantidade de hectares: " . $hectares . "<br>" ;
    echo "Quantidade de m³ por hectare: " . $qnt_metros . "<br>" ;
    echo "Preço do m³: " . $preco_metros . "<br>" ;
    echo "Valores agregados: " . $valor_agregado . "<br>" ;

?>
