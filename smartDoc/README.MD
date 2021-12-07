镜像已上传到dockerhub，可以按以下方式部署：

下载公共镜像

docker pull tanghc2020/torna:latest

导入数据库，执行mysql.sql

复制server/boot/src/main/resources/application.properties文件到/opt/torna/config下，修改数据库连接配置

执行docker run --name torna -p 7700:7700 -v /opt/torna/config:/torna/config -d <镜像ID>

浏览器访问http://ip:7700/