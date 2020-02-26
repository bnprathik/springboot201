$( document ).ready(function() {
	
	$("#restosearch").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	

	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : "http://localhost:4000/hotel/"+$("#city").val()+"",
			success: function(result){
				/*if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var custList = "";
					console.log(result.data);
					$.each(result.data, function( customer){
						var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + "<br>";
						$('#getResultDiv .list-group').append(customer)
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}*/
				console.log(result);
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})