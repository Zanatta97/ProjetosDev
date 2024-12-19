
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
                        <!-- <p><span class="horario-aberto"> -->
                        <?php 
                            date_default_timezone_set ("America/Fortaleza");

                            //$diasemana = array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado");

                            // Aqui podemos usar a data atual ou qualquer outra data no formato Ano-mês-dia (2014-02-28)
                            $data = date("Y-m-d");
                            $hora = date("H:i");

                            //Horários de Domingo
                            $aberturaDomingo = date("11:30");
                            $fechamentoDomingo = date("18:00");

                            //Horários da Semana
                            $aberturaSemana = date("11:30");
                            $fechamentoSemana = date("24:00");

                            //Horários de Sábado
                            $aberturaSabado = date("11:30");
                            $fechamentoSabado = date("02:00");
                            
                            // Varivel que recebe o dia da semana (0 = Domingo, 1 = Segunda,  2= Terça, 3 = Quarta, 4 = Quinta 5 = Sexta, 6 = Sábado...)
                            $diasemana_numero = date("w", strtotime($data));

                            if ($diasemana_numero == 0){
                                if (($hora > $aberturaDomingo) && ($hora < $fechamentoDomingo) || ($hora < $fechamentoSabado)){
                                    echo '<p><span class="horario-aberto">';
                                    echo "Estamos abertos";
                                } else {
                                    echo '<p><span class="horario-fechado">';
                                    echo "Fechado";
                                }
                            } elseif (($diasemana_numero > 0) && ($diasemana_numero < 6)) {
                                if (($hora > $aberturaSemana) && ($hora < $fechamentoSemana)){
                                    echo '<p><span class="horario-aberto">';
                                    echo "Aberto";
                                    //echo $hora;
                                } else {
                                    echo '<p><span class="horario-fechado">';
                                    echo "Fechado";
                                } 
                            } elseif ($diasemana_numero == 6) { 
                                if ($hora > $aberturaSabado){
                                    echo '<p><span class="horario-aberto">';
                                    echo "Aberto";
                                } else {
                                    echo '<p><span class="horario-fechado">';
                                    echo "Fechado";
                                }
                            }
                           // echo  $hora//$diasemana[$diasemana_numero];
                        
                        ;?>
                        </span><br>
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
                    <?php
                        echo date("Y") . " &copy; Todos os direitos reservados"
                    ?>
                    </div>
                </div>
            
            </div>

        </footer>
    </body>

</html>