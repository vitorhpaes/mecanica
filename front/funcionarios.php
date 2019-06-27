<!DOCTYPE html>
<html>
<head>
	<title>Mecanica - peças</title>
</head>
<body>

	<?php require 'shared/styles.php'; ?>

	<div class="container">
		<div class="row">

			<?php require 'shared/menu.php'; ?>

			<div class="col-md-10 card-system">
				<h3 class="w-100 text-center">
					Funcionarios

					<div class="btn btn-success float-right mb-3" data-toggle="modal" data-target="#modal-new-func"> 
						Adicionar funcionario
					</div>
				</h3>
				<table class="table table-striped table-func text-center">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Setor</th>
							<th>Data de admissão</th>
							<th>Salario</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>

			</div>

		</div>
	</div>

	<?php require 'assets/modal/modal-new-func.php'; ?>
	<?php require 'shared/scripts.php'; ?>


</body>


</html>