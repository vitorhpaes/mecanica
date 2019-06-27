<?php 

$serverName = $_SERVER['SERVER_NAME'];

if($serverName == '127.0.0.1' or $serverName == 'localhost') {

	$env = 'dev';
	$dbName = 'mecanica';

} else {

	$env = 'test';
	$dbName = 'id9317610_mecanica';

}

$serverName = 'localhost';

define('ENV', $env);
define('dbName', $dbName);

?>