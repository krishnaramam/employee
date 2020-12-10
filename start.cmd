set SPRING_PROFILES_ACTIVE=local
mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=8090"