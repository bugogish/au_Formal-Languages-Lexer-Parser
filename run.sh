#!/usr/bin/env bash
./gradlew build
args=""

for i in "$@"
do
    wrapped=\'$i\'", "
    args=$args$wrapped
done

./gradlew run -PappArgs="[$args]"
