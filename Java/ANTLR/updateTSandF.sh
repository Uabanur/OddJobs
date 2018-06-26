#!/bin/sh

#Remember to run: export CLASSPATH=".:lib/antlr-3.5.2-complete.jar:$CLASSPATH";
#in the terminal before running this file

java -jar lib/antlr-3.5.2-complete.jar modelchecker/parserF/*.g;
java -jar lib/antlr-3.5.2-complete.jar modelchecker/parserTS/*.g;

javac modelchecker/astF/*java;
javac modelchecker/parserF/*java;

javac modelchecker/astTS/*java;
javac modelchecker/parserTS/*java;

javac modelchecker/TSandFChecker.java

