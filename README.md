# Catalog

# Prerequisites
The project requires mysql running on port 3306 on the host with password `2788`.

## Run pre-built project
Run:
```bash
java -jar builds/Catalog-0.0.1-SNAPSHOT.jar
```

Then open http://localhost:8080/index.html

## Building jar
To build run:
```bash
./mvnw clean package
```

Then run:
```bash
java -jar target/*.jar
```

Then open http://localhost:8080/index.html
