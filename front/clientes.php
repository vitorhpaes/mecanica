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
					Clientes

					<div class="btn btn-success float-right mb-3" data-toggle="modal" data-target="#modal-new-client"> Adicionar Cliente
					</div>
				</h3>
				<table class="table table-striped table-clients text-center">
					<thead>
						<tr>
							<th>Id</th>
							<th>Cliente</th>
							<th>CPF</th>
							<th>Telefone</th>
							<th>Email</th>
							<th>Carros</th>
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