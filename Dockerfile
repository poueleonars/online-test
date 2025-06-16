# 基础镜像
FROM openjdk:8-jre-slim
# 作者
MAINTAINER leonard1643
# 配置
ENV PARAMS=""
# 时区
EXPOSE 21090
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 添加应用
ADD target/online-test-api-1.0-SNAPSHOT.jar /online-test-api-1.0-SNAPSHOT.jar
## 在镜像运行为容器后执行的命令
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /online-test-api-1.0-SNAPSHOT.jar $PARAMS"]


