#!/bin/sh

touch classnames

echo $@ >> classnames

user=$(whoami)
home="\/home\/$user\/workspace-java\/LibcryptosecJava-compile-fix\/src\/"


sed -i "s/$home//g" classnames
sed -i "s/\//./g" classnames
sed -i "s/.java//g" classnames
sed -i "s/ /, /g" classnames

less classnames
rm classnames