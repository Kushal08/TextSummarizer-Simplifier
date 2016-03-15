<?php
shell_exec("/usr/bin/javac WordClass.java");
$add = shell_exec("/usr/bin/java WordClass <input.txt >output.txt ");
?>
