<?php 

require 'connection.php';

class pdoQuery {

	public function __construct($config = null) {

		$pdo = connection::connect($config);

	}

	public function fetchAll(){

		$params = $_GET;
		$sql = $params['sql'];

		$stmt = $pdo->prepare($sql);
		$data = $stmt->execute();
		$data = $stmt->fetchAll(PDO::FETCH_ASSOC);

		echo json_encode($data);
		return;

	}

}

?>