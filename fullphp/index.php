<?php 

header('Access-Control-Allow-Origin: *');
header('content-type: text/html; charset-utf-8');

require 'pdoQuery.php';
$pdoQuery = new pdoQuery;

$gets = $_GET;
$post = $_POST;

$sql = isset($gets['sql']) ? $gets['sql'] : null;
$action = isset($gets['action']) ? $gets['action'] : null;

$data = null;

switch ($action) {
	case 'searchAll':
	$data = $pdoQuery->fetchAll($sql);
	break;
	case 'search':
	$data = $pdoQuery->fetch($sql);
	break;
}

echo json_encode($data);

?>