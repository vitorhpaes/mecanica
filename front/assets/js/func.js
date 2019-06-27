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

	var getFuncionario = function(callback) {

		getServlet({
			type: 'funcionario',
			method: 'getAll',
		}, callback);

	}


	var getData = function(){

		getFuncionario(function(data){

			$.each(data, function(index, obj){

				var html = "<tr> <td data-id="+obj.Id+">" + obj.Id + "</td>"
				+"<td>" + obj.Nome + "</td>"
				+"<td>" + obj.Setor + "</td>"
				+"<td>" + obj.DataAdmissao + "</td>"
				+"<td>" + obj.Salario + "</td>"
				+ "</tr>";

				$('.table-func tbody').append(html);

			});

		});

	}

	var click = function(){

		$('.btn-save-func').on('click', function(){

			postFuncionario();

		});

	}

	var postFuncionario = function(){

		var form = $('form#func');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Funcionário cadastrado',
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

