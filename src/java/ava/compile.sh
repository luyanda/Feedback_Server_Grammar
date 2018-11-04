#!/bin/bash

usage() {
    echo "Usage: ./compile.sh"
   exit 1
}

rm simpl*.java simpl*.class *tokens *interp
java -jar antlr-4.7.1-complete.jar simpl.g4 #"$1"
javac -cp .:antlr-4.7.1-complete.jar simpl*.java
