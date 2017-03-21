(function($){
  $(function(){

    $('.button-collapse').sideNav();

  }); // end of document ready
})(jQuery); // end of jQuery name space

$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
    $('select').material_select();
  });

$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    format: "yyyy/mm/dd",
    selectYears: 100, // Creates a dropdown of 15 years to control year
    max: new Date(),
    onStart: () => {
    	  $('.picker').appendTo('body');
    	}
  });