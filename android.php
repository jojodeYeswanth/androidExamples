<?php 
	require_once 'config.php';

	$stmt = $db->prepare("SELECT id, title, body, contributor FROM news;");

	$stmt->execute();
	
	$stmt->bind_result($id, $title, $body, $contributor);
	
	$news = array(); 
	 
	while($stmt->fetch()){
		$temp = array();
		$temp['id'] = $id; 
		$temp['title'] = $title; 
		$temp['body'] = $body;
		$temp['contrib'] = $contributor; 
		array_push($news, $temp);
	}
	echo json_encode($news);