<div class="modal fade" id="modal-new-services" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					<i class="fas fa-people-carry mr-3"></i>
					Cadastro de Serviço
				</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body grey-bg">

				<form id="service" class="row">

					<input type="hidden" name="type" value="servico">
					<input type="hidden" name="method" value="insert">

					<div class="col-md-6">

						<div class="form-group">
							<label> Nome </label>
							<input type="text" name="nome" class="form-control">
						</div>
						<div class="form-group">
							<label> Descrição </label>
							<textarea name="descricao" class="form-control" style="height: 150px;"></textarea>
						</div>

					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label> Peça </label>
							<select id="pieces" class="form-control" name="pecaId">
								<option> Sem peça </option>
							</select>
						</div>
						<div class="form-group">
							<label> Horas </label>
							<input type="number" name="horas" class="form-control">
						</div>
						<div class="form-group">
							<label> Preço </label>
							<input type="number" name="valor" class="form-control">
						</div>
					</div>

				</form>

				<div class="btn btn-success btn-save-service float-right" style="margin-top: 31px;">Cadastrar Serviço
				</div>

			</div>
		</div>
	</div>
</div>