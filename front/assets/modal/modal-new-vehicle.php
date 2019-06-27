<div class="modal fade" id="modal-new-vehicle" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Cadastro de veículo</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body card-system">

				<form id="vehicle" class="row">

					<input type="hidden" name="type" value="veiculo">
					<input type="hidden" name="method" value="insert">
					<input type="hidden" name="clienteId" value="">

					<div class="col-md-6">

						<div class="form-group">
							<label> Modelo </label>
							<input type="text" name="modelo" class="form-control" list="modelos-lista">
							<datalist id="modelos-lista"></datalist>
						</div>
						<div class="form-group">
							<label> Marca </label>
							<input type="text" name="marca" class="form-control" list="marcas-lista">
							<datalist id="marcas-lista">
								<option value="Chevrolet"></option>
								<option value="Hyundai"></option>
								<option value="Volkswagen"></option>
								<option value="Renault"></option>
								<option value="Lamborguini"></option>
								<option value="Audi"></option>
								<option value="Peugeot"></option>
								<option value="Honda"></option>
								<option value="Ford"></option>
								<option value="Mitstubishi"></option>
							</datalist>
						</div>

					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label> Placa </label>
							<input type="text" name="placa" class="form-control placa-mask" style="text-transform: uppercase;">
						</div>
						<div class="btn btn-success w-100 btn-save-vehicle" style="margin-top: 31px;">Cadastrar veículo
						</div>

					</div>

				</form>

				<div class="col-md-12">
					<hr>
					<table class="table table-striped table-vehicles text-center">
						<thead>
							<tr>
								<th>Id</th>
								<th>Modelo</th>
								<th>Marca</th>
								<th>Placa</th>
								<th>Vizualizar OSs</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>

				<div class="col-md-12">
					<div class="precos mt-3 float-right d-none row">
						<h4 class="total mr-3"></h4>
						<div class="btn btn-success ml-2 btn-save-os"> Salvar cliente </div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>