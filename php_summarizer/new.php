

<?php 
exec("/usr/bin/javac WordClass.java");
$add=  exec("/usr/bin/java WordClass ");
echo $add."\n";
?>
