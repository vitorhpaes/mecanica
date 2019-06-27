<!DOCTYPE html>
<html>
<head>
	<title>Mecanica - Serviços</title>
</head>
<body>

	<?php require 'shared/styles.php'; ?>

	<div class="container">
		<div class="row">

			<?php require 'shared/menu.php'; ?>

			<div class="col-md-10 card-system">
				<h3 class="w-100 text-center">
					Serviços

					<div class="btn btn-success float-right mb-3 btn-open-modal"> 
						Adicionar Serviço
					</div>
				</h3>
				<table class="table table-striped table-servico text-center">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Horas</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>

			</div>

		</div>
	</div>

	<?php require 'assets/modal/modal-new-services.php'; ?>
	<?php require 'shared/scripts.php'; ?>


</body>


</html>