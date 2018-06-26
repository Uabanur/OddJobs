#!/bin/sh

#Remember to run: export CLASSPATH=".:lib/antlr-3.5.2-complete.jar:$CLASSPATH";
#in the terminal before running this file

java -jar /usr/local/lib/antlr-3.5.2-complete.jar modelchecker/parserTS/*.g;

javac modelchecker/astTS/*java;
javac modelchecker/parserTS/*java;
javac modelchecker/ModelChecker.java;