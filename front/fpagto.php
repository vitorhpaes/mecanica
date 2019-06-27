<!DOCTYPE html>
<html>
<head>
	<title>Mecanica - clientes</title>
</head>
<body>

	<?php require 'shared/styles.php'; ?>

	<div class="container">
		<div class="row">

			<?php require 'shared/menu.php'; ?>

			<div class="col-md-10 card-system">
				<h3 class="w-100 text-center">
					Formas de pagamento
				</h3>

				<form id="fpagto" class="my-3">

					<div class="row">

						<input type="hidden" name="type" value="fpagto">
						<input type="hidden" name="method" value="insert">

						<div class="col-md-6">
							<input type="text" name="tipo" class="form-control">
						</div>
						<div class="col-md-4">
							<select name="vezes" class="form-control">
								<option value="1"> 1 vez </option>
								<?php for ($i=2; $i <= 12; $i++) { ?>

									<option value="<?=$i?>"> <?=$i?> vezes </option>

								<?php } ?>
							</select>
						</div>
						<div class="col-md-2">
							<div class="btn btn-success btn-save-fpagto w-100"> Cadastrar </div>
						</div>
					</div>

				</form>

				<h4> Cadastradas </h4>
				<table class="table table-striped table-fpagto text-center mt-3">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome da forma</th>
							<th>Quantidade de vezes</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>

			</div>

		</div>
	</div>

	<?php require 'assets/modal/modal-new-client.php'; ?>
	<?php require 'assets/modal/modal-new-vehicle.php'; ?>
	<?php require 'assets/modal/modal-os-table.php'; ?>
	<?php require 'shared/scripts.php'; ?>


</body>


</html>