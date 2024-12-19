<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Pé de Fava</title>
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
     



           
        <div class="cardapio-list small-11 large-12 columns no-padding small-centered">
            
            <div class="global-page-container">
                <div class="cardapio-title small-12 columns no-padding">
                    <h3>Cardapio</h3>
                    <hr></hr>
                </div>

                <div class="category-slider small-12 columns no-padding">
                    <h4>Entradas</h4>
                    <div class="slider-cardapio">
                        <div class="slider-002 small-12 small-centered columns">

                            <?php
                                $tipoPrato = "Entradas";
                                include 'script-cardapio.php';
                            ?>

                        </div>
                    </div>
                </div>

                <div class="category-slider small-12 columns no-padding">
                    <h4>Pratos Principais</h4>

                    <div class="slider-cardapio">
                        <div class="slider-002 small-12 small-centered columns">
                            <?php
                                $tipoPrato = "Pratos Principais";
                                include 'script-cardapio.php';
                            ?>
                        </div>
                    </div>
                   
                </div>

                <div class="category-slider small-12 columns no-padding">
                    <h4>Sobremesas</h4>

                    <div class="slider-cardapio">
                        <div class="slider-002 small-12 small-centered columns">
                            <?php
                                $tipoPrato = "Sobremesas";
                                include 'script-cardapio.php';
                            ?>  
                        </div>
                    </div>
                   
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