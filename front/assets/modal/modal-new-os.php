<div class="modal fade" id="modal-new-os" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Cadastro de ordem</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body card-system">

				<form id="os" class="row">
					
					<input type="hidden" name="bug" value="bug">
					<input type="hidden" name="type" value="os">
					<input type="hidden" name="method" value="insert">

					<div class="col-md-6">

						<div class="form-group">
							<label> Cliente </label>
							<input type="text" id="cliente-nome" class="form-control" list="clients-select">
							<input type="hidden" name="ClienteId" id="idcliente">
							<datalist id="clients-select">
							</datalist>
						</div>
						<div class="form-group">
							<label> Forma de pagamento </label>
							<select class="form-control" id="fpagto-select" name="formapagtoId">
								<option selected disabled> Selecionar </option>
							</select>
						</div>

					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label> Data prevista </label>
							<input type="date" name="DataPrevista" class="form-control">
						</div>
						<div class="form-group d-none">
							<label> Carro do cliente </label>
							<select id="client-cars" class="form-control" name="VeiculoId">
							</select>
						</div>
					</div>

					<div class="col-md-12">
						<hr>
						<table class="table table-striped table-services-index text-center">
							<thead>
								<tr>
									<th>Id</th>
									<th>Serviço</th>
									<th>Horas</th>
									<th>Preço</th>
									<th>Remover</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="btn btn-primary mt-3 w-100 modal-add-service"> Adicionar serviço/peça à OS </div>
					</div>
					<input type="hidden" name="ValorTotal">

				</form>

				<div class="col-md-12">
					<div class="precos mt-3 float-right d-none row">
						<h4 class="total mr-3"></h4>
						<div class="btn btn-success ml-2 btn-save-os"> Salvar OS </div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>