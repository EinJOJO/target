## Contributing

### To compile...

#### On Windows

1. Shift + right-click the folder with the directory’s files and click "Open command prompt".
2. `gradlew clean build`

#### On Linux, BSD, or Mac OS X

1. In your terminal, navigate to the folder with directory’s files (cd /folder/of/buildsystem/files)
2. `./gradlew clean build`

### Then you will find...

* the **BuildSystem** plugin jar `BuildSystem-<identifier>` in **buildsystem-core/build/libs**

### Other commands

* `gradlew idea` will generate an [IntelliJ IDEA](https://www.jetbrains.com/idea/) module for each folder.
* `gradlew eclipse` will generate an [Eclipse](https://www.eclipse.org/downloads/) project for each folder. _(Possibly
  broken!)_
