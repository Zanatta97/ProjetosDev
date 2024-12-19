(function($) {
   
   
  /**
  * NEW Menu Mobile
  * Open Menu
  */

  $( '.hamburguer-icon' ).click( function() {
    $('.sliding-header-menu-outer').addClass("show-menu");
  });

  $( '.sliding-header-menu-close-button' ).click( function() {
    $('.sliding-header-menu-outer').removeClass("show-menu");
  });  
   


   $( '.slider-002' ).slick({
      dots: true,
      arrows: false,
      infinite: true,
      fade: false,
      speed: 700,
      slidesToShow: 3,
      slidesToScroll: 3,
      autoplay: true,
      autoplaySpeed: 7000,
      pauseOnHover: true,
      draggable: true,
      responsive: [
          {
            breakpoint: 640,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1
            }
          }
      ]
   });

  
   
   
   
})(jQuery);


   