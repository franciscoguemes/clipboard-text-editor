CTE (Clipboard Text Editor)
=======================================

This project is a fully functional clipboard text editor that allows to easily edit the text that is currently in 
the clipboard of the OS (Operating System) through specific predetermined actions.


# Requirements
For developing this project I used:
 - Java 21 from Termurin
 - Maven 3.9.7

If you use sdkman you can configure your `.sdkmanrc` file as follows:
```shell
java=21.0.3-tem
maven=3.9.7
```

# Running the application

You can use maven to run the application
```shell
mvn exec:java
```

Alternatively you can use the JVM to run the application
```shell
java -jar ./target/clipboard-text-editor-1.0-SNAPSHOT.jar
```