<div class="modal fade" id="modal-new-client" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Novo cliente</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body card-system">

				<form id="client" class="row">

					<input type="hidden" name="type" value="cliente">
					<input type="hidden" name="method" value="insert">

					<div class="col-md-6">

						<div class="form-group">
							<label> Cliente </label>
							<input type="text" name="nome" class="form-control">
						</div>
						<div class="form-group">
							<label> CPF </label>
							<input type="text" name="cpf" class="form-control cpf">
						</div>
						<div class="form-group">
							<label> Email </label>
							<input type="text" name="email" class="form-control">
						</div>

					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label> CEP </label>
							<input type="text" name="cep" class="form-control cep">
						</div>
						<div class="form-group">
							<label> Numero </label>
							<input type="number" name="numero" class="form-control"> 
						</div>
						<div class="form-group">
							<label> Telefone </label>
							<input type="text" name="telefone" class="form-control phonemask">
						</div>
					</div>

				</form>

				<div class="mt-3 col-md-3 offset-md-9">
					<div class="btn btn-success ml-2 btn-save-client w-100"> Salvar Cliente </div>
				</div>

				<div class="col-md-12">
					<hr>
					<h4>Veículos</h4>
					<table class="table table-striped table-services-index text-center">
						<thead>
							<tr>
								<th>Id</th>
								<th>Modelo</th>
								<th>Marca</th>
								<th>Placa</th>
								<th>Remover</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div class="btn btn-primary mt-3 w-100 modal-add-vehicle" data-target="#modal-new-vehicle" data-toggle="modal">
						Adicionar novo veículo 
					</div>
				</div>

			</div>
		</div>
	</div>
</div>