
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Pé de Fava</title>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/slick.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700|Permanent+Marker|Raleway:400,700" rel="stylesheet">
        <script src="js/vendor/modernizr.js"></script>
        <?php
            include_once('conexao.php');
        ?>
    </head>
    
    <body>

        <?php
            //Conexão PDO
            $servidor = "localhost:3306";
            $usuario = "root";
            $senha = "";
            $dbname = "teste";

            $conn = new PDO ("mysql:dbname=restaurante;host=localhost","root","");
        ?>
        <?php include 'header.php';?>

		<div class="ghost-element">
		</div>

        <div class="welcome-gallery small-12 columns">

            <div class="photo-section small-12 columns">
                <img class="homepage-main-photo" src="img/main-photo.jpg" alt="slider imagem 1">
            </div>

            <div class="main-section-title small-10 columns">
                <div class="table">
                    <div class="table-cell">
                        <h1>Bem vindo ao Pé de Fava</h1>
                        <h2>A cozinha tradicional do Nordeste (Nós não desligamos o freezer a noitche)</h2>

                    </div>
                </div>
                
            </div>

            <div class="photo-gradient">
                
            </div>

        </div>


    

        <div class="about-us small-11 large-12 columns no-padding small-centered">

            <div class="global-page-container">
                <div id="about-us" class="about-us-title small-12 columns no-padding">
                <h3>Sobre Nós</h3>
                <hr></hr>
                </div>

                
                    <img src="img/fachada.jpg" alt="fachada do restaurante">
                

                <div class="about-us-text">
                <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus leo mi, 
                        condimentum ac convallis non, porta ac nibh. Morbi volutpat nibh lectus, quis 
                        convallis nunc rutrum vitae. Aenean volutpat aliquam elementum. Nunc consequat 
                        elit odio, vitae suscipit nunc pretium eu. Aenean vitae lacus auctor, condimentum 
                        ipsum at, suscipit erat. Donec dapibus ullamcorper bibendum. Vestibulum posuere 
                        augue in lectus dictum tincidunt. Pellentesque ornare eget enim sed dignissim. 
                        Sed nec nisi suscipit, feugiat risus ac, lacinia elit.
                    </p>
                    
                    <p>
                        Duis fermentum leo enim, eget dignissim dolor imperdiet at. Sed ut rutrum lacus. 
                        Aenean eleifend, urna eu dapibus imperdiet, turpis diam tristique mauris, nec 
                        luctus ante massa eu arcu. Duis tempor risus quis tellus posuere eleifend. 
                        Donec fringilla nulla ac odio sagittis tincidunt. Phasellus tempus id felis et 
                        finibus. Aenean felis ligula, varius nec varius at, feugiat nec felis. Morbi 
                        blandit sapien vel justo consequat laoreet.</p>
                </div>
            
            </div>

        </div>

    
        <div class="cardapio small-11 large-12 columns no-padding small-centered">
            <div class="global-page-container">
                <div class="cardapio-title small-12 columns no-padding">
                <h3>Cardapio</h3>
                <hr></hr>
                </div>
            </div>

            <div class="global-page-container">


                <div class="slider-cardapio">
                    <div class="slider-002 small-12 small-centered columns">
                        <?php
                            include 'destaques.php';
                        ?>
                    </div>
                </div>
            </div>
        </div>

        <div id="contact-us" class="contact-us small-11 large-12 columns no-padding small-centered">

            <div class="global-page-container">
                <div class="contact-us-title small-12 columns no-padding">
                <h3>Faça a sua reserva</h3>
                <hr></hr>
                </div>
                

                <div class="reservation-form small-12 columns no-padding">
                
                    <form action="script-reserva.php" method="get">

                        <div class="form-part1 small-12 large-8 xlarge-7 columns no-padding">
                            <input type="text" name="nome" class="field" placeholder="Nome completo"/>
                            
                            <input type="text" name="email" class="field" placeholder="E-mail"/>
                            
                            <textarea type="text" name="mensagem" class="field" placeholder="Mensagem"></textarea>


                        </div>
                        
                        <div id='teste' class="form-part2 small-12 large-3 xlarge-3 end columns no-padding">
                            <input type="text" name="telefone" class="field" placeholder="Telefone"/>
                            
                            <input type="datetime-local" name="data" class="field" placeholder="Data e hora"/>

                            <input type="text" name="data" class="field" placeholder="Número de pessoas"/>

                            <input type="submit" name="submit" value="Reservar" id="btnSubmit" class="button"/> <!-- disabled/>  -->
<!-----------------------------------------------------------------------------------------------------------------------------------TODO: Descomentar para liberar o Captcha e adicionar "disabled no botão------------------- -------------------------------------------------------------------------------------------------------------> 
                            <!-- <div class="g-recaptcha" data-sitekey="6LeDf8YUAAAAAH8c79pCAHT_1JgHnUZZxc2xx8lU" data-callback="recaptcha_Callback"></div>
                            <script type="text/javascript">
                                function recaptcha_Callback(){
                                $('.button').prop("disabled", false);
                                }
                            </script> -->
                        </div>
                    </form>
                    <!-- 6LeDf8YUAAAAAH8c79pCAHT_1JgHnUZZxc2xx8lU -->

                    
                        <!-- <script  type="text/javascript">
                                function recaptcha_Callback() {
                                            $('#btnSubmit').removeAttr('disabled');
                                        };                                  
                                    // var btnSubmit = document.getElementById("btnSubmit");

                                    // if (btnSubmit.classList.contains("hidden") ) {
                                    //     btnSubmit.classList.remove("hidden");
                                    //     btnSubmit.classList.add("show");
                                    // }
                                }
                        </script> -->
                </div>

            </div>
        </div>

        <?php
            //$ok = isset($_GET["num"])?$_GET["num"]:2;
            if (isset($_GET["num"])) {
                if ($_GET["num"] == 0){
                    echo '<script>alert("ERRO! Confira os dados digitados!")</script>';
                } else {
                    if ($_GET["num"] == 1) {
                        echo '<script>alert("Reserva Efetuada com Sucesso!")</script>';
                    }
                }
            }
                        
        ?>                        
        
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