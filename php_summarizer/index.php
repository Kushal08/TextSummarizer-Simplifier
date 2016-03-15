<?php

if ($_FILES["file"]["type"] == "text/plain" &&
    $_FILES["file"]["size"] < 6553600000000000)
{
  if ($_FILES["file"]["error"] > 0)
  {
    echo "Error: " . $_FILES["file"]["error"] . "<br>";
  }
  else
  {

if ($fh = fopen($_FILES["file"]["name"],'r'))
{
while ($line = fgets($fh)) {
  echo($line);
}
fclose($fh);

  }
}
}
?>



<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Text Summarizer</title>
        

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<script>
function validateForm() {
    var x = document.forms["myForm"]["text"].value;
    if (x == null || x == "") {
        alert("Please Enter Some Text to Summarize");
        return false;
    }
}
</script>

<script>
function eraseText() {
    document.getElementById("text").value = "";
}
</script>        
        
    </head>
    <body style="zoom: 1;">
        <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target="nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
<img style="float:left;width:50px;height:50px;    " src="logo.png" />
            <a class="brand" style="padding-left: 40px;"href="index.php">Text Summarizer & Simplifier</a>
            <div class="nav-collapse collapse" id="navbar-main">
              
            </div>
        </div>
    </div>
</div>
        <div style="height:60px"></div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                   
 



<div class="row-fluid">
    <div class="span8 offset2">
        <div class="hero-unit">
   <form action="text_summarizer.php" method="post" 
      enctype="multipart/form-data">
    <div style="display:none;"><input id="csrf_token" name="csrf_token" type="hidden" value="1457775018##79b6a2316694f526842bc2da5fbacc0a7034f96b"></div>
  <table>
  <h3>Upload Text File and Click on Upload Here.</h3>
            <input type="file" name="file" id="file"><br/><input class="btn btn-primary btn-small" type="submit" value="Upload Here">
            <td</td>
        </table>
</form>

	<center>	<b>--------------------------------------------------------------------------------------------------------------------</b> </center>

<form name="myForm" action="loader.php" onsubmit="return validateForm()" method="post" name="analyse">
    <div style="display:none;"><input id="csrf_token" name="csrf_token" type="hidden" value="1457775018##79b6a2316694f526842bc2da5fbacc0a7034f96b"></div>
    <h3>Copy and Paste the text you want to Summarize.</h3>
  <textarea id="text" maxlength="50000" name="text" size="5000" style="width:600px;height:250px"><?php 
	echo !empty($_POST['text'])?htmlspecialchars($_POST['text']):'';

if (isset ( $_FILES ['file'] )) {
if ($_FILES["file"]["type"] == "text/plain" && $_FILES["file"]["size"] < 65536)
{
  if ($_FILES["file"]["error"] > 0)
  {
    echo "Error: " . $_FILES["file"]["error"] . "<br>";
  }
  else
  {

$fh = fopen($_FILES["file"]["tmp_name"],'r');
while ($line = fgets($fh)) {
  echo($line);
}
fclose($fh);

  }
}
}
 
?></textarea><p></p><table>
        <tbody><tr>
             
        </tr>
        <tr>
            <td><input class="btn btn-primary btn-large" type="submit" value="Summarize Now">
 <input class="btn btn-primary btn-large" onclick="javascript:eraseText();" value="Clear"></td>
            <td></td>
        </tr>
    </tbody></table>
</form>

</div>
</div>
</div>

                </div>
            </div>
            <div style="height:10px"></div>
            <footer>
<p align="center">
<span id="mashape-button" data-api="text-summarization" data-name="textanalysis" data-light="1"></span><script src="./Text Summarizer - TextSummarization _ Text Summarization Online _ Text Summarization Demo _ Text Summarization API_files/button.js"></script>
<a href ="https://hackathon.guide> " > Hackathon</a>'16 @IIITV --- Team Fury</a>
</p>
</footer>
        </div>
        
</body></html>
