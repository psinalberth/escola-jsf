mkdir -p target/wildfly-10.1.0.Final/modules/system/layers/base/com/mysql/main
cp src/main/resources/configuration/standalone.xml target/wildfly-10.1.0.Final/standalone/configuration/
cp src/main/resources/configuration/module.xml target/wildfly-10.1.0.Final/modules/system/layers/base/com/mysql/main/
cp src/main/resources/drivers/mysql-connector-java-5.1.39.jar target/wildfly-10.1.0.Final/modules/system/layers/base/com/mysql/main/
