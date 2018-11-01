echo "Compiling and packaging.."
mvn package && echo "Running.." && java -jar target/my-app-1.0-SNAPSHOT.jar