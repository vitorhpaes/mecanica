<div class="modal fade" id="modal-new-piece" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					<i class='fas fa-puzzle-piece mr-3'></i>
					Cadastro de peça
				</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body card-system">

				<form id="piece" class="row">

					<input type="hidden" name="type" value="pecas">
					<input type="hidden" name="method" value="insert">

					<div class="col-md-12">

						<div class="form-group">
							<label> Nome </label>
							<input type="text" name="nome" class="form-control">
						</div>
						<div class="form-group">
							<label> Descrição </label>
							<textarea name="descricao" class="form-control" style="height: 150px;"></textarea>
						</div>
						<div class="form-group">
							<label> Preço </label>
							<input type="number" name="valor" class="form-control">
						</div>

					</div>

				</form>

				<div class="btn btn-success btn-save-piece float-right" style="margin-top: 31px;">Cadastrar Peça
				</div>

			</div>
		</div>
	</div>
</div>