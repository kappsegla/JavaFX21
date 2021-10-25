Compile the project:

```
mvn compile
```
Build plugin for pom.xml

            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>se.iths.java21.javafx/se.iths.java21.javafx.HelloApplication</mainClass>
                </configuration>
            </plugin>

Run the project:

```
mvn clean javafx:run -f UI
```

Create and run custom image

```
mvn javafx:jlink -f UI

UI/target/image/bin/java -m se.iths.java21.javafx/se.iths.java21.javafx.HelloApplication
```

With the following configuration:

- `stripDebug`: Strips debug information out. Values: false (default) or true
- `stripJavaDebugAttributes`: Strip Java debug attributes out (since Java 13), Values: false (default) or true
- `compress`: Compression level of the resources being used. Values: 0 (default), 1, 2.
- `noHeaderFiles`: Removes the `includes` directory in the resulting runtime image. Values: false (default) or true
- `noManPages`: Removes the `man` directory in the resulting runtime image. Values: false (default) or true
- `bindServices`: Adds the option to bind services. Values: false (default) or true
- `ignoreSigningInformation`: Adds the option to ignore signing information. Values: false (default) or true
- `jlinkVerbose`: Adds the verbose option. Values: false (default) or true
- `launcher`: Adds a launcher script with the given name.
    - If `options` are defined, these will be passed to the launcher script as vm options.
    - If `commandLineArgs` are defined, these will be passed to the launcher script as command line arguments.
- `jlinkImageName`: The name of the folder with the resulting runtime image
- `jlinkZipName`: When set, creates a zip of the resulting runtime image
- `jlinkExecutable`: The `jlink` executable. It can be a full path or the name of the executable, if it is in the PATH.
- `jmodsPath`: When using a local JavaFX SDK, sets the path to the local JavaFX jmods

```
<plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>
    <configuration>
        <stripDebug>true</stripDebug>
        <compress>2</compress>
        <noHeaderFiles>true</noHeaderFiles>
        <noManPages>true</noManPages>
        <launcher>hellofx</launcher>
        <jlinkImageName>hello</jlinkImageName>
        <jlinkZipName>hellozip</jlinkZipName>
        <mainClass>se.iths.java21.javafx/se.iths.java21.javafx.HelloApplication</mainClass>
    </configuration>
</plugin>
```

A custom image can be created and run as:

```
mvn clean javafx:jlink -f UI

UI/target/hello/bin/hellofx
```