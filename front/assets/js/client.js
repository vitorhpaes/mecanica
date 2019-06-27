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

	var mask = function(){

		$(".cpf").mask("999.999.999-99");
		$(".cep").mask("99999-999");
		$(".phonemask").mask("(99) 99999-9999");
		$(".placa-mask").mask("AAA-9999");

	}

	var getOSs = function(callback) {

		getServlet({
			type: 'OS',
			method: 'getOpen',
		}, callback);

	}

	var getClients = function(callback){

		getServlet({
			type: 'cliente',
			method: 'getAll',
		}, callback);

	}

	var getCarsByClient = function(id, callback){

		getServlet({
			type: 'veiculo',
			method: 'getByClientId',
			params: id,
		}, callback);

	}

	var getOsByCar = function(id, callback){

		console.log(id);

		getServlet({
			type: 'OS',
			method: 'getByCarId',
			params: id,
		}, callback);

	}

	var getData = function(){

		getClients(function(data){

			$.each(data, function(index, obj){

				var html = "<tr> <td data-id="+obj.Id+">" + obj.Id + "</td>"
				+"<td>" + obj.Nome + "</td>"
				+"<td>" + obj.CPF + "</td>"
				+"<td>" + obj.Telefone + "</td>"
				+"<td>" + obj.Email + "</td>"
				+"<td> <div class='btn btn-info btn-open-cars'> <i class='fas fa-car fa-2x'></i> </div> </td> </tr>";

				$('.table-clients tbody').append(html);

			});

		});

	}

	var click = function(){


		$('.btn-save-client').on('click', function(){

			postClient();

		});

		$('.btn-save-vehicle').on('click', function(){

			postVehicle();

		});

		$(document).on('click', '.btn-os-view', function(){

			var id = $(this).data('id');
			getOsByCar(id, function(data){
				$('table.table-os-view tbody').html('');
				$.each(data, function(index, obj){

					var html = '<tr>'
					+ '<td>'+ obj.Id +'</td>'
					+ '<td>'+ obj.DataRegistro +'</td>'
					+ '<td>'+ obj.DataPrevista +'</td>'
					+ '<td>'+ obj.ValorTotal +'</td>';
					if(obj.Status == 0){
						html = html + '<td> <div class="btn btn-danger disabled"> Não entregue </div> </td>';
					} else {
						html = html + '<td> <div class="btn btn-success disabled"> Entregue </div> </td>';
					}
					html = html + '<td> <div class="btn btn-info btn-os-open" data-id="'+obj.Id+'"> <i class="fas fa-eye"></i> </div> </td>'
					+ '</tr>';

					$('table.table-os-view tbody').append(html);

				});

				$('#modal-os-view').modal('show');

			});

		});

		$(document).on('click', '.btn-open-cars', function(){
			var id = $(this).parents('tr').find('[data-id]').data('id');

			getCarsByClient(id, function(data){
				$('.table-vehicles tbody').html('');
				$.each(data, function(index, obj){

					var html = "<tr> <td>" + obj.Id + "</td>"
					+"<td>" + obj.Modelo + "</td>"
					+"<td>" + obj.Marca + "</td>"
					+"<td>" + obj.Placa + "</td>"
					+"<td> <div class='btn btn-info btn-os-view' data-id="+obj.Id+"> <i class='fas fa-eye'></i> </div> </td> </tr>";

					$('.table-vehicles tbody').append(html);

				});

			});

			var modal = $('#modal-new-vehicle');
			modal.find('input[name="clienteId"]').val(id);
			modal.modal('show');

		})

	}

	var postVehicle = function(){

		var form = $('form#vehicle');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Veiculo cadastrado',
					showConfirmButton: false,
					timer: 3000,
					onClose: function(){
						location.reload();
					}
				})

			}
		});		

	}

	var postClient = function(){

		var form = $('form#client');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Cliente cadastrado',
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
		mask();

	});

})($);

