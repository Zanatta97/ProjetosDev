<!doctype html>
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


		<header>
			
			<div class="main-header large-12 columns no-padding">

				<div class="global-page-container">
				
					<div class="logo small-6 small-offset-3 large-3 large-offset-0 columns no-padding">
						<a href="index.php" title="home">
							<div class="table">
								<div class="table-cell">
									<h1>Pé de Fava</h1>
								</div>
							</div>
						</a>
					</div>

					<div class="main-menu show-for-large-up large-9 columns text-right">		
						<div class="table">
							<div class="table-cell">
								<ul class="menu-items">
									<li><a href="index.php#about-us">Sobre</a></li>
									<li><a href="cardapio.php">Cardápio</a></li>
									<li><a href="index.php#contact-us">Reserva</a></li>
									<li><a href="index.php#footer">Contato</a></li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="hamburguer-icon small-2 columns text-right">
                        <div class="table">
                            <div class="table-cell">
                                <img src="img/menu/hamburguer.svg">
                            </div> 
                        </div>
					</div>

					<div class="right-space small-1 columns"></div>

				</div>
			</div>			
					
            <div class="sliding-header-menu-outer">						
                <div class="sliding-header-menu">
                    
                    <div class="sliding-header-menu-close-button small-12 columns">
                        <div class="table">
                            <div class="table-cell">
                                <img class="close-icon" src="img/menu/close.svg">
                            </div>	
                        </div>	
                    </div>

                    

                    <div class="sliding-header-menu-main-menu small-12 columns">
                        
                        <div class="table">
                            <div class="table-cell">
                                <ul class="sliding-header-menu-li">
                                    <li><a href="index.php#about-us">Sobre</a></li>
                                    <li><a href="cardapio.php">Cardápio</a></li>
                                    <li><a href="index.php#contact-us">Reserva</a></li>
                                    <li><a href="index.php#footer">Contacto</a></li>
                                </ul>
                            </div>
                        </div>
                        
                    </div>                           
                </div>
            </div>

		</header>

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

            

   


        <footer id="footer" class="small-12 columns no-padding">

            <div class="global-page-container">

                <div class="small-11 small-centered large-12 columns footer-section">

                    <div class="follow-us small-5 medium-3 small-offset-1 medium-offset-0 columns">
                        <h4 class="footer-section-title">Siga-nos</h4>
                        <a href="http://www.facebook.com"><img src="img/social-icons/facebook.svg" alt="facebook-icon"></a>
                        <a href="http://www.twitter.com"><img src="img/social-icons/twitter.svg" alt="facebook-icon"></a>
                        <a href="http://www.instagram.com"><img src="img/social-icons/instagram.svg" alt="facebook-icon"></a>
                    </div>
                    
                    <div class="contato small-5 medium-3 small-offset-1 medium-offset-0 columns">
                        <h4 class="footer-section-title">Contato</h4>
                        <p>
                            Rua Fernando Ferrari, 1450<br>
                            Montenegro/RS<br>
                            T. 93632-0977<br>
                            contato@cheffmello.com.br
                        </p>
                    </div>
                    
                    <div class="horario small-5 medium-3 small-offset-1 medium-offset-0 columns">
                        <h4 class="footer-section-title">Horários</h4>
                        <p><span class="horario-aberto">(Aberto Agora)</span><br>
                        Seg-Sex: 11h30 - 24h00<br>
                        Sábado 11h30 - 02h00<br>
                        Domingo 11h30 - 18h</p>
                    </div>
                    
                    <div class="como-chegar small-5 medium-3 small-offset-1 medium-offset-0 columns">
                        <h4 class="footer-section-title">Como chegar</h4>
                        <div id="map"></div>
                    </div>
                    
                    <hr></hr>
                    
                    <div class="copyright small-12 columns">
                    
                   2018 &c8opy; Todos os direitos reservados
                    
                    </div>
                </div>
            
            </div>

        </footer>


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