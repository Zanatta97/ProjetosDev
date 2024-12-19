<!doctype html>
<?php
    $codigoSelecionado = $_GET["prato"];

    include_once('conexao.php');
    $tipo = [
        'codigo'=>$codigoSelecionado
    ];

    $strSelect = "SELECT * FROM pratos WHERE codigo = :codigo";

    $stmt = $conn->prepare($strSelect); 
    $result = $stmt->execute($tipo);

    $row = $stmt->fetch(PDO::FETCH_ASSOC);

    

    //codigo	nome	categoria	descricao	valor	calorias	destaque

    $codigo = $row['codigo'];
    $nome = $row['nome'];
    $categoria = $row['categoria'];
    $descricao = $row['descricao'];
    $valor = $row['valor'];
    $calorias = $row['calorias'];
?>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Cheff Mello</title>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/slick.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700|Permanent+Marker|Raleway:400,700" rel="stylesheet">
        <script src="js/vendor/modernizr.js"></script>
    </head>
    
    <body>


    <?php include 'header.php';?>

		<div class="ghost-element">
		</div>
           
        <div class="product-page small-11 large-12 columns no-padding small-centered">
            
            <div class="global-page-container">

                <div class="product-section">
                    <div class="product-info small-12 large-5 columns no-padding">
                        <h3><?php echo $nome?><!-- Salmão aos Legumes --></h3>
                        <h4><?php echo $categoria?></h4>
                        <p><?php echo $descricao?></p>

                        <h5><b>Preço: </b>R$ <?php echo $valor?></h5>
                        <h5><b>Calorias: </b><?php echo $calorias?></h5> 
                    </div>

                    <div class="product-picture small-12 large-7 columns no-padding">
                        <img src="img/cardapio/<?php echo $codigo?>.jpg" alt="picanha">
                    </div>

                </div>

                <div class="go-back small-12 columns no-padding">
                    <a href="cardapio.php"><< Voltar ao Cardápio</a>
                </div>

            </div>
        </div>
            


        <?php include 'footer.php';?>


        <script src="js/vendor/jquery.js"></script>
        <script src="js/vendor/slick.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/foundation.min.js"></script>
        <script>
            function initMap() {
            var local = {lat: -29.691453, lng: -51.4583307};
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                center: local,
                styles: 
                [
                    {
                        "featureType": "administrative",
                        "elementType": "geometry",
                        "stylers": [
                        {
                            "visibility": "off"
                        }
                        ]
                    },
                    {
                        "featureType": "poi",
                        "stylers": [
                        {
                            "visibility": "off"
                        }
                        ]
                    },
                    {
                        "featureType": "road",
                        "elementType": "labels.icon",
                        "stylers": [
                        {
                            "visibility": "off"
                        }
                        ]
                    },
                    {
                        "featureType": "transit",
                        "stylers": [
                        {
                            "visibility": "off"
                        }
                        ]
                    }
                ]
                
            });
            var marker = new google.maps.Marker({
                position: local,
                map: map
            });
            }
        </script>
        <script 
            async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlo2Bml6zmqP1_xtT3aLybZdWZNP7l8CM&callback=initMap">
        </script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>