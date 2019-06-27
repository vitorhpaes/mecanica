;(function($) {

	var getServlet = function(data, callback){

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'GET',
			data: data,
			dataType: 'JSON',
			complete: function(response){

				ret = response.responseJSON;
				callback(ret);

			}
		});

	}

	var getFPagto = function(callback) {

		getServlet({
			type: 'fpagto',
			method: 'getAll',
		}, callback);

	}


	var getData = function(){

		getFPagto(function(data){

			$.each(data, function(index, obj){

				var html = "<tr> <td data-id="+obj.Id+">" + obj.Id + "</td>"
				+"<td>" + obj.Tipo + "</td>"
				+"<td>" + obj.Vezes + "</td>"
				+ "</tr>";

				$('.table-fpagto tbody').append(html);

			});

		});

	}

	var click = function(){

		$('.btn-save-fpagto').on('click', function(){

			postFPagto();

		});

	}

	var postFPagto = function(){

		var form = $('form#fpagto');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Forma cadastrada',
					showConfirmButton: false,
					timer: 3000,
					onClose: function(){
						location.reload();
					}
				})

			}
		});		

	}

	$(document).ready(function(){

		getData();
		click();

	});

})($);

