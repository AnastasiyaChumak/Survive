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

 
	
	
	

	
	
/* window.onload = init;

function init(){
    let button = document.getElementById("button")
    button.onclick = handleButtonClick;
}

function handleButtonClick() {
var user = {
    name: "Tom"
};
 
var request = new XMLHttpRequest();
function reqReadyStateChange() {
    if (request.readyState == 4 && request.status == 200)
        document.getElementById("output").innerHTML=request.responseText;
}
var body = "name=" + user.name;
request.open("POST", "http://localhost:8080/postdata.php");
request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
request.onreadystatechange = reqReadyStateChange;
request.send(body);
console.log("ggegeegeg");
}*/




