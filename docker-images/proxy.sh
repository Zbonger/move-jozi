#!/bin/sh

if ping -c 1 ix.de ; then
    echo "direct internet doing nothing"
else
    echo "proxy environment detected setting proxy"
    export http_proxy=http://user:password@proxy:8080
fi
