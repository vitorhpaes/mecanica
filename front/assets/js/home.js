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

	var confirmOs = function(id, callback){

		getServlet({
			type: 'OS',
			method: 'confirmOs',
			params: id
		}, callback);

	}

	var getOSs = function(callback) {

		getServlet({
			type: 'OS',
			method: 'getOpen',
		}, callback);

	}

	var getClosedOS = function(callback) {

		getServlet({
			type: 'OS',
			method: 'getClosed',
		}, callback);

	}

	var getServicos = function(callback) {

		getServlet({
			type: 'servico',
			method: 'getAll',
		}, callback);

	}

	var getClients = function(callback){

		getServlet({
			type: 'cliente',
			method: 'getAll',
		}, callback);

	}

	var getFuncionarios = function(callback){

		getServlet({
			type: 'funcionario',
			method: 'getAll',
		}, callback);

	}

	var getFormaPagto = function(callback){

		getServlet({
			type: 'fpagto',
			method: 'getAll',
		}, callback);

	}

	var getVehicles = function(callback){

		getServlet({
			type: 'veiculo',
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

	function distribute(arr = null) {

		var select = $('#clients-select');
		$.each(arr, function(id, obj){

			var html = '<option value="'+obj.Nome+'"">';
			html = html + obj.Id + "</option>";
			select.append(html);

		});

	} 

	var getData = function(){

		getClients(function(arr){

			var select = $('#clients-select');
			$.each(arr, function(id, obj){

				var html = '<option value="'+obj.Nome+'" data-id="'+obj.Id+'">';
				if(obj.Telefone != undefined) 
					html = html + obj.Telefone + "</option>";
				else 
					html = html + "Sem telefone cadastrado" + "</option>";

				select.append(html);

			});

		});

		getFormaPagto(function(arr){

			var select = $('#fpagto-select');
			$.each(arr, function(id, obj){

				var html = '<option value="'+obj.Id+'">';
				html = html + obj.Tipo + " - " + obj.Vezes + " vezes" + "</option>";
				select.append(html);

			});

		});

		getOSs(function(arr){

			$.each(arr, function(id, obj){

				var html = '<tr>'
				+ '<td>' + (id+1) + '</td>'
				+ '<td>' + obj.Nome[0] + '</td>'
				+ '<td>' + obj.Modelo[0] + '</td>'
				+ '<td>' + obj.DataPrevista + '</td>'
				+ '<td>' + obj.ValorTotal + '</td>'
				+ '<td> <div class="btn btn-success btn-confirm-os" data-id="' + obj.Id[0] + '"> Entregar </div></td>'
				+ '</tr>';

				$('.table-os').append(html);

			});

			if(arr.length == 0) {

				var html = '<tr class="text-center">'
				+ '<td>#</td>'
				+ '<td> <b> Não há OSs abertas </b> </td>'
				+ '<td>#</td>'
				+ '<td>#</td>'
				+ '<td>#</td>'
				+ '<td>#</td>'
				+ '</tr>';

				$('.table-os').append(html);

			}

		});

		getClosedOS(function(arr){

			$.each(arr, function(id, obj){

				var html = '<tr>'
				+ '<td>' + (id+1) + '</td>'
				+ '<td>' + obj.Nome[0] + '</td>'
				+ '<td>' + obj.Modelo[0] + '</td>'
				+ '<td>' + obj.DataPrevista + '</td>'
				+ '<td>' + obj.ValorTotal + '</td>'
				+ '<td> <div class="btn btn-secondary"> Entregue </div></td>'
				+ '</tr>';

				$('.table-os-closed').append(html);

			});
		});	

	}

	var confirmServices = function(){

		var html = $('.modal-services tbody').html();
		$('.modal-services tbody').html('');
		var modal = $('.modal-services');
		var indexTable = $('table.table-services-index tbody');
		indexTable.append(html);

		var preco = 0;
		indexTable.find('td input.value-service').each(function(){
			preco += parseFloat($(this).val());
		});

		$('div.precos').find('.total').text('Total: ' + preco);
		$('div.precos').removeClass('d-none');
		$('div.precos').hide();
		$('div.precos').fadeIn(500);

		modal.modal('hide');

	}

	var calcValor = function(){

		var total = 0;
		$(document).find('input.value-service').each(function(id, input){

			total = total + parseFloat($(this).val());

		}).promise().done(function(){

			$('input[name="ValorTotal"]').val(total);

		});

		return true;

	}

	var click = function(){

		$('input#cliente-nome').on('change', function(){

			var idSelected = $(this).parent().find('datalist option[value="'+$(this).val()+'"]').data('id');
			$('input[name="ClienteId"]').val(idSelected);
			getCarsByClient(idSelected, function(arr){

				var select = $('select#client-cars');
				console.log(arr);
				$.each(arr, function(id, obj){

					var html = '<option value="'+obj.Id+'"> '+ obj.Modelo +' - '+obj.Placa+' </option>';

					select.append(html);

				});
				select.parent().removeClass('d-none');
				select.hide();
				select.fadeIn(400);

			});

		});

		$('.modal-add-service').on('click', function(){

			getServicos(function(arr){

				var select = $('.modal-services .select-services');
				select.html('<option selected disabled>  Selecione o serviço </option>');

				$.each(arr, function(id, obj){

					var html = '<option value="'+obj.Id+'"'
					+' data-value="'+obj.Valor+'"'
					+' data-horas="'+obj.Horas+'">'
					+ obj.Nome 
					+ "</option>";
					select.append(html);

				})

				$('.modal-services').modal({
					show: true,
					backdrop: false,
				});

			});

		});

		$(document).on('change', '.modal-services .select-services', function(){
			var clone = $(this).clone();

			var table = $(this).parents('.modal-body').find('table.services tbody');

			var service = '<tr>'
			+'<td> <input type="hidden" name="consumo" value="'+$(this).find('option:selected').val()+'">'+$(this).find('option:selected').val()+'</td>'
			+'<td>'+$(this).find('option:selected').text()+'</td>'
			+'<td>'+$(this).find('option:selected').data('horas')+'</td>'
			+'<td> <input type="number" name="valor" class="form-control value-service" value="'+$(this).find('option:selected').data('value')+'"/></td>'
			+'<td> <div class="btn btn-danger btn-remove-service"> <i class="far fa-trash-alt"></i> </div> </td>'
			+'</tr>';
			table.append(service);

			$(this).parent().prepend(clone);
			$(this).remove();

		});

		$(document).on('click', '.btn-remove-service', function(){

			$(this).parents('tr').remove();

		});

		$('.confirm-services').on('click', function(){

			confirmServices();

		});

		$('.btn-save-os').on('click', function(){

			calcValor();
			postOs();

		});

		$(document).on('click', '.btn-confirm-os', function(){

			var id = $(this).data('id');
			confirmOs(id, function(data){

				if(data) {
					swal({
						type: 'success',
						title: 'Ok!',
						text: 'Ordem confirmada',
						timer: 3000,
						showConfirmButton: false,
						onClose: function(){
							location.reload();
						}
					})
				}

			});

		});

	}

	var postOs = function(){

		var form = $('form#os');

		$.ajax({
			url: 'http://localhost:8080/Backend_/webApp',
			type: 'POST',
			data: form.serialize(),
			dataType: 'JSON',
			complete: function(response){

				swal({
					type: 'success',
					title: 'Ok!',
					text: 'Ordem de serviço cadastrada',
					showConfirmButton: false,
					timer: 2000,
					onClose: function(){
						location.reload();
					}
				});

			}
		});		

	}

	$(document).ready(function(){

		getData();
		click();

	});

})($);

