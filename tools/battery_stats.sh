#!/bin/sh
set -eu

OUTPUT=$1

echo "count,current" > $OUTPUT
i=0
while true
do
	echo "$i,$(cat /sys/class/power_supply/battery/current_avg)" >> $OUTPUT
	i=$(($i + 1))
	usleep 100000
done
