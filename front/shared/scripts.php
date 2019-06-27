<?php 

$url = $_SERVER['REQUEST_URI'];

$url = explode('/', $url);

?>

<script>
	var Helpers = {};
</script>

<script
src="https://code.jquery.com/jquery-3.4.1.min.js"
integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
crossorigin="anonymous">
</script>
<script type="text/javascript" src="assets/libs/jquery-mask/jquery.mask.min.js"></script>
<script type="text/javascript" src="assets/libs/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/libs/fontawesome/js/all.min.js"></script>

<script type="text/javascript" src="assets/libs/sweetalert2/dist/sweetalert2.min.js"></script>

<?php if(end($url) == '' || end($url) == 'index.php') { ?>
	<script type="text/javascript" src="assets/js/home.js"></script>
<?php } else if(end($url) == 'clientes.php') { ?>
	<script type="text/javascript" src="assets/js/client.js"></script>
<?php } else if(end($url) == 'pecas.php') { ?>
	<script type="text/javascript" src="assets/js/piece.js"></script>
<?php } else if(end($url) == 'servicos.php') { ?>
	<script type="text/javascript" src="assets/js/service.js"></script>
<?php } else if(end($url) == 'funcionarios.php') { ?>
	<script type="text/javascript" src="assets/js/func.js"></script>
<?php } else if(end($url) == 'fpagto.php') { ?>
	<script type="text/javascript" src="assets/js/fpagto.js"></script>
	<?php 
} ?>