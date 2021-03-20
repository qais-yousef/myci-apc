#!/bin/sh
set -eu

OUTPUT=$1

echo "timestamp,current" > $OUTPUT
while true
do
	echo "$(date +%s),$(cat /sys/class/power_supply/battery/current_avg)" >> $OUTPUT
	usleep 100000
done
