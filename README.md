# javaBrains

pull promethues docker image

run below command

docker run -d --name=prometheus -p 9090:9090 -v C:\Users\shanu\sprinboot_apps\app\src\main\resources\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml

configure grafana using the below reference link

FYI: 192.168.1.35 ued in the app.prop is network ip

reference link : https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/