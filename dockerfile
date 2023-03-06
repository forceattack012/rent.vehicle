FROM openjdk:17

RUN date
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Bangkok /etc/localtime
RUN date

WORKDIR /app
COPY target/rent.vehicle.jar rent.vehicle.jar

CMD ["java", "-jar", "rent.vehicle.jar"]



