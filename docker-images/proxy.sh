#!/bin/sh

if ping -c 1 ix.de ; then
    echo "direct internet doing nothing"
else
    echo "proxy environment detected setting proxy"
    export http_proxy=http://qxz0hv8:zb0ngerBMWgermany4@proxy.w9:80
fi
