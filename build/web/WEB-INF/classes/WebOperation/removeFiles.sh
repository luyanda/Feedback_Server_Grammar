#!/bin/bash

usage() {
    echo "Usage: ./removeFiles.sh"
   exit 1
}
 
#javac -cp .:/usr/local/lib/antlr-4.7.1-complete.jar /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/*.java
#cp /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/* /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/
rm -f /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/simpl*
rm -f /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/web*.sh
