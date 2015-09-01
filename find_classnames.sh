#!/bin/sh
echo $@ | sed -e "s|$PWD/src/||g" \
	-e 's|/|.|g' \
	-e 's|.java||g' \
	-e 's| |, |g'
