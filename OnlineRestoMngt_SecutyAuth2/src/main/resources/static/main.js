$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#restoreg").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		city : $("#city").val(),
    		hotelname :  $("#hotelname").val(),
    		description :  $("#description").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url :"http://localhost:4000/hotels",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				console.log(result);
				console.log(formData);
				},
			error : function(e) {
				console.log(formData);
			}
		});
    	

    }

$("#tableform").submit(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	ajaxtablePost();
});

function ajaxtablePost(){
	
	// PREPARE FORM DATA
	var formData = {
			menu :  $("#menu").val(),
			numberofseats : $("#numberofseats").val(),
			price :  $("#price").val(),
			status :  $("#status").val(),
	}
	
	// DO POST
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url :"http://localhost:4000//hotels/"+$("#hotel_hotelid").val()+"/tables",
		data : JSON.stringify(formData),
		dataType : 'json',
		success : function(result) {
			console.log(result);
			console.log(formData);
			},
		error : function(e) {
			console.log(formData);
		}
	});
	

}

    
})