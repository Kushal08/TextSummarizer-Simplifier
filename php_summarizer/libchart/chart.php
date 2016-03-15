<?php
	include "libchart/classes/libchart.php";

	header("Content-type: image/png");

	$chart = new PieChart(500, 260);

	$dataSet = new XYDataSet();
	$dataSet->addPoint(new Point("Matching ", 80));
	$dataSet->addPoint(new Point("Not Matching", 75));
	$chart->setDataSet($dataSet);

	$chart->setTitle("Summarised Text vs Simplified Text");
	$chart->render();
?>
