#!/bin/sh

folder=$(pwd)/$1 
target_folders=$(ls src/br/ufsc/labsec/libcryptosec/)

for target in $target_folders
do
	if [ ! -d "$folder/$target" ]; then
		mkdir $folder/$target
	fi
	find $folder -type f -name "*$target*" | xargs mv -t $folder/$target
done