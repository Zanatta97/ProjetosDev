<?php
    include_once('conexao.php');

    $destaques = [
        'destaque'=>1
    ];

    $strSelect = "SELECT * FROM pratos WHERE destaque = :destaque";

    $stmt = $conn->prepare($strSelect); 
    $result = $stmt->execute($destaques);

    while ($row = $stmt->fetch(PDO::FETCH_ASSOC))
    {   
        $codigo = $row['codigo'];
        $nome = $row['nome'];

        
        echo '<div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                <div class="cardapio-item">
                        <a href="prato-selecionado.php?prato='. $codigo . '">
                            
                            <div class="cardapio-item-image">
                                <img src="img/cardapio/' . $codigo . '.jpg" alt="camarao"/>   
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
 
 
 <!--  <div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                            <div class="cardapio-item">
                                <a href="camarao-alho.html">
                                    
                                    <div class="cardapio-item-image">
                                        <img src="img/cardapio/camarao-alho.jpg" alt="camarao"/>   
                                    </div>

                                    <div class="item-info">
                                        
                                    
                                        <div class="title">Camarão ao Alho</div>
                                    </div>

                                    <div class="gradient-filter">
                                    </div>
                                    
                                </a>
                            </div>
                        </div>

                        <div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                            <div class="cardapio-item">
                                <a href="picanha-brasileira.html">
                                    
                                    <div class="cardapio-item-image">
                                        <img src="img/cardapio/picanha-brasileira.jpg" alt="barbecue"/>   
                                    </div>

                                    <div class="item-info">
                                        
                                    
                                        <div class="title">Picanha à Brasileira</div>
                                    </div>

                                    <div class="gradient-filter">
                                    </div>
                                    
                                </a>
                            </div>
                        </div>

                        <div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                            <div class="cardapio-item">
                                <a href="cheesecake-cereja.html">
                                    
                                    <div class="cardapio-item-image">
                                        <img src="img/cardapio/cheesecake-cereja.jpg" alt="cheesecake"/>   
                                    </div>

                                    <div class="item-info">
                                        
                                    
                                        <div class="title">Cheesecake de cereja</div>
                                    </div>

                                    <div class="gradient-filter">
                                    </div>
                                    
                                </a>
                            </div>
                        </div>

                        <div class="cardapio-item-outer bounce-hover small-10 medium-4 columns"> 
                            <div class="cardapio-item">
                                <a href="salmao-legumes.html">
                                    
                                    <div class="cardapio-item-image">
                                        <img src="img/cardapio/salmao-legumes.jpg" alt="salmao"/>   
                                    </div>

                                    <div class="item-info">
                                        
                                    
                                        <div class="title">Salmão aos Legumes</div>
                                    </div>

                                    <div class="gradient-filter">
                                    </div>
                                    
                                </a>
                            </div>
                        </div> -->