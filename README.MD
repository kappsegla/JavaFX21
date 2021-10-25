Compile the project:

```
mvn compile
```

Run the project:

```
mvn clean javafx:run -f UI
```
Create and run custom image

```
mvn javafx:jlink -f UI

UI/target/image/bin/java -m se.iths.java21.javafx/se.iths.java21.javafx.HelloApplication
```