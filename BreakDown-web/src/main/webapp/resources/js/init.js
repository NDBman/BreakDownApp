(function($){
  $(function(){

    $('.button-collapse').sideNav();

  }); // end of document ready
})(jQuery); // end of jQuery name space

$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
    $('select').material_select();
    var url = window.location.href;
    if(url.indexOf('?error') != -1) {
    	$('#login_modal').modal({
    		inDuration: 0
    	});
        $('#login_modal').modal('open');
        $('#login_modal').modal({
    		inDuration: 300
    	});
    }
    if(url.indexOf('?regerror') != -1) {
    	$('#reg_modal').modal({
    		inDuration: 0
    	});
        $('#reg_modal').modal('open');
        $('#reg_modal').modal({
    		inDuration: 300
    	});
    }
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

$('.dropdown-button').dropdown({
	hover: true,
	belowOrigin: true
});

