FROM mysql:latest
LABEL authors="Zylevich_A"
RUN rm -rf /docker-entrypoint-initdb.d
COPY ./src/main/resources/sql/tables.sql /docker-entrypoint-initdb.d/
