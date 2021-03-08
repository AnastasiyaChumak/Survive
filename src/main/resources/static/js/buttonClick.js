	  $(document).ready(() => {
	$('body').on('change', 'input[name=answers]', function (e) {
		e.preventDefault();

		console.log($(this).val())
		let testMessage = "testMessage";
	 //	if (	$('input:radio').is(':checked')){
	    $.get( "test?answerId="+$(this).val()).done( function (data){ 
 			//console.log(data);
			$("#replacingContent").replaceWith(data);
	    }); 
	//	  } 
	 })
});  

 
	
	
	

	
	




