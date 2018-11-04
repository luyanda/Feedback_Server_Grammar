#!/bin/bash
usage() {
    echo "Usage: ./webgenerate.sh"
   exit 1
}

java -jar /usr/local/lib/antlr-4.7.1-complete.jar /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/simpl.g4
chmod +x /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/webcompile.sh 
/home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/./webcompile.sh 
