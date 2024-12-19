<?php
    include_once('conexao.php');
    //$tipoPrato = "Entradas";
    $tipo = [
        'tipo'=>$tipoPrato
    ];

    $strSelect = "SELECT * FROM pratos WHERE categoria = :tipo";

    $stmt = $conn->prepare($strSelect); 
    $result = $stmt->execute($tipo);

    while ($row = $stmt->fetch(PDO::FETCH_ASSOC))
    {   
        $codigo = $row['codigo'];
        $nome = $row['nome'];

        
        echo '<div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                <div class="cardapio-item">
                    <a href="prato-selecionado.php?prato='. $codigo . '">
                        
                        <div class="item-image">
                            <img src="img/cardapio/' . $codigo . '.jpg" alt="cogumelos"/>   
                        </div>

                        <div class="item-info">
                            
                        
                            <div class="title">' . $nome . '</div>
                        </div>

                        <div class="gradient-filter">
                        </div>
                        
                    </a>
                </div>
             </div>';
    }
?>