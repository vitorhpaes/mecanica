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

	var getServicos = function(callback) {

		getServlet({
			type: 'servico',
			method: 'getAll',
		}, callback);

	}

	
	var getPecas = function(callback) {

		getServlet({
			type: 'pecas',
			method: 'getAll',
		}, callback);

	}

	var getData = function(){

		getServicos(function(data){

			$.each(data, function(index, obj){

				var html = "<tr> <td data-id="+obj.Id+">" + obj.Id + "</td>"
				+"<td>" + obj.Nome + "</td>"
				+"<td>" + obj.Descricao + "</td>"
				+"<td>" + obj.Valor + "</td>"
				+"<td> <div class='btn btn-info btn-open-peca'> <i class='fas fa-puzzle-piece'></i> </div> </td> </tr>";

				$('.table-servico tbody').append(html);

			});

		});

	}

	var postService = function(){

		var form = $('form#service');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Serviço cadastrado',
					showConfirmButton: false,
					timer: 3000,
					onClose: function(){
						location.reload();
					}
				})

			}
		});		

	}

	var validateForm = function(){

		validate = true;
		$('form#service').find('input:visible, textarea:visible').each(function(index) {

			el = $(this);
			if(el.val() == '') {

				var name = el.parent().find('label').text();
				swal({
					type: 'error',
					title: 'Ops!',
					text: 'Preencha o campo de: ' + name,
					showConfirmButton: false,
					timer: 3000,
					onClose: function(){

						el.focus();

					}
				});
				validate = false;
				return false;

			}

		}).promise().done(function(){

			return validate;

		});

		return validate;

	}

	var click = function(){

		$('.btn-save-service').on('click', function(){

			if(validateForm())
				postService();

		});

		$('.btn-open-modal').on('click', function(){

			var modal = $("#modal-new-services");

			getPecas(function(data){

				$.each(data, function(index, obj){

					var html = "<option value="+obj.Id+">"
					+ obj.Nome + " - R$ " + obj.Valor
					+"</option>";

					modal.find('select#pieces').append(html);

				});

			});

			modal.modal('show');

		});

	}

	$(document).ready(function(){

		getData();
		click();

	});

})($);

