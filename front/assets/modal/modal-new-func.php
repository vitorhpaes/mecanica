<div class="modal fade" id="modal-new-func" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Novo Funcionario</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body grey-bg">

				<form id="func" class="row">

					<input type="hidden" name="type" value="funcionario">
					<input type="hidden" name="method" value="insert">

					<div class="col-md-6">

						<div class="form-group">
							<label> Nome </label>
							<input type="text" name="nome" class="form-control">
						</div>
						<div class="form-group">
							<label> Setor </label>
							<select name="setor" class="form-control">
								<option value="Administrativo"> Administrativo </option>
								<option value="Mecânica"> Mecânica </option>
								<option value="Pintura"> Pintura </option>
								<option value="Espelhamento"> Espelhamento </option>
								<option value="Rodas"> Rodas </option>
							</select>
						</div>
						<div class="form-group">
							<label> Data de admissão </label>
							<input type="date" name="dataAdmissao" class="form-control">
						</div>

					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label> Salario </label>
							<input type="number" name="salario" class="form-control">
						</div>
						<div class="btn btn-success btn-save-func w-100"> Salvar funcionário </div>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>