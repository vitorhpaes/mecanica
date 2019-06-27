<?php 

require 'conn.php';

class pdoQuery {

	private $pdo;

	public function __construct($config = null) {

		$this->pdo = conn::connect($config);

	}

	public function fetchAll($sql){

		$stmt = $this->pdo->prepare($sql);
		$data = $stmt->execute();
		$data = $stmt->fetchAll(PDO::FETCH_ASSOC);

		return $data;

	}

	public function fetch($sql){

		$stmt = $this->pdo->prepare($sql);
		$data = $stmt->execute();
		$data = $stmt->fetch(PDO::FETCH_ASSOC);

		return $data;

	}

}

?>