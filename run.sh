#!/usr/bin/env bash
./gradlew build
a=\'
if [ $# -gt 1 ]; then
    FILE=$1
    if [ "$2" == "-filter" ] || [ "$2" == "-f" ] || [ "$2" == "--filter" ]; then
        FILTER="-filter"
        ./gradlew run -PappArgs="[$a$FILE$a, $a$FILTER$a]"
    fi
else
    FILE=$1
    ./gradlew run -PappArgs="[$a$FILE$a]"
fi
