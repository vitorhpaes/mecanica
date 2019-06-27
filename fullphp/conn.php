<?php

require 'env.php';

class conn {

	public function connect($config = null){

		if($config == null) {
			$config['dsn'] = 'mysql:dbname='.dbName.';host=localhost';
			if(ENV == 'dev') {

				$config['username'] = 'remoto';
				$config['password'] = '';

			} else if(ENV == 'test'){

				$config['username'] = 'id9317610_vitor';
				$config['password'] = '123456';

			}
		}


		$object = new PDO($config['dsn'], $config['username'], $config['password'], array(
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES UTF8',
			PDO::ATTR_ERRMODE 			 => PDO::ERRMODE_EXCEPTION
		));

		return $object;

	}


}

?>