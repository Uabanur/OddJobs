#!/bin/sh

#Remember to run: export CLASSPATH=".:lib/antlr-3.5.2-complete.jar:$CLASSPATH";
#in the terminal before running this file


java -jar /usr/local/lib/antlr-3.5.2-complete.jar while_language/parsing/*.g;

javac while_language/ast/*java;
javac while_language/parsing/*java;
javac while_language/*java;