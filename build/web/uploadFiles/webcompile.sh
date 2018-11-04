#!/bin/bash

usage() {
    echo "Usage: ./webcompile.sh"
   exit 1
}
 
javac -cp .:/usr/local/lib/antlr-4.7.1-complete.jar /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/*.java
chmod +x /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/removeFiles.sh
/home/epsilon/Documents/Varsity/Project/src/java/WebOperation/./removeFiles.sh
cp /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/* /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/
