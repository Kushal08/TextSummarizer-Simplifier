#!/bin/bash
cd /var/www/html/semantics/src
javac USAGE.java
java USAGE /var/www/html/php_summarizer/output.txt /var/www/html/php_summarizer/input.txt >sem.txt
javac Getresult.java 
java Getresult sem.txt >num.txt
echo "Hello World!"
