FROM eclipse-temurin:17-jdk-jammy
WORKDIR .

COPY rinha-lrlucena.jar /
CMD java -jar rinha-lrlucena.jar /var/rinha/source.rinha
