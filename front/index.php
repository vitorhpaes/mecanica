<!DOCTYPE html>
<html>
<head>
	<title>Mecanica - Home</title>
</head>
<body>

	<?php require 'shared/styles.php'; ?>

	<div class="container">
		<div class="row">

			<?php require 'shared/menu.php'; ?>

			<div class="col-md-10 card-system">
				<h3 class="w-100 text-center">
					Ordens de serviço

					<div class="btn btn-success float-right mb-3" data-toggle="modal" data-target="#modal-new-os"> Adicionar OS
					</div>
				</h3>
				<table class="table table-striped table-os">
					<thead>
						<tr>
							<th>Id</th>
							<th>Cliente</th>
							<th>Carro</th>
							<th>Data Prevista</th>
							<th>Valor</th>
							<th>Status</th>
						</tr>
					</thead>
				</table>

				<hr>
				
				<h3 class="w-100 text-center">
					Ordens encerradas
				</h3>
				<table class="table table-striped table-os-closed">
					<thead>
						<tr>
							<th>Id</th>
							<th>Cliente</th>
							<th>Carro</th>
							<th>Data Prevista</th>
							<th>Valor</th>
							<th>Status</th>
						</tr>
					</thead>
				</table>

			</div>

		</div>
	</div>

	<?php require 'assets/modal/modal-new-os.php'; ?>
	<?php require 'assets/modal/modal-services.php'; ?>
	<?php require 'shared/scripts.php'; ?>


</body>


</html>