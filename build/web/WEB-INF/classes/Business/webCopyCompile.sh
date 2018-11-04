#!/bin/bash

usage() {
   # echo "Usage: ./compile.sh <name of grammar>"
   echo  "Usage: ./compile.sh"
   exit 1
}
#java -jar .:/usr/local/lib/antlr-4.7.1-complete.jar simpl.g4
#java -jar antlr-4.7.1-complete.jar simpl.g4
java -jar .:/usr/local/lib/antlr-4.7.1-complete.jar simpl.g4 #"$1"
javac -cp .:antlr-4.7.1-complete.jar simpl*.java
