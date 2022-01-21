FROM openjdk:11-oraclelinux8

ARG JAR_FILE

RUN microdnf install nc && microdnf clean all

RUN mkdir -p /apps
COPY ./target/${JAR_FILE} /apps/app.jar
COPY ./entrypoint.sh /apps/entrypoint.sh
COPY ./wait-for-service.sh /apps/wait-for-service.sh
RUN chmod +x /apps/entrypoint.sh
RUN chmod +x /apps/wait-for-service.sh

CMD ["/apps/entrypoint.sh"]
