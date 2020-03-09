#./proxy.sh

#Docker file uses ubuntu image
FROM ubuntu:18.04

#ENV http_proxy 'http://qxz0hv8:zb0ngerBMWgermany4@proxy.w9:80'
#ENV https_proxy 'http://qxz0hv8:zb0ngerBMWgermany4@proxy.w9:80'

# Install dependencies
RUN apt-get update && \
 apt-get -y install apache2

# Install apache and write hello world message
RUN echo 'Hello World!' > /var/www/html/index.html

# Configure apache
RUN echo '. /etc/apache2/envvars' > /root/run_apache.sh && \
 echo 'mkdir -p /var/run/apache2' >> /root/run_apache.sh && \
 echo 'mkdir -p /var/lock/apache2' >> /root/run_apache.sh && \ 
 echo '/usr/sbin/apache2 -D FOREGROUND' >> /root/run_apache.sh && \ 
 chmod 755 /root/run_apache.sh

EXPOSE 80

CMD /root/run_apache.sh
