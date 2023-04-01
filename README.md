# ICC: extracting ICC dependencies as [ENRE-JAVA](github.com/xjtu-enre/enre-java) data model format for android apks

### Build && Installation

`icc` depends on `enre-java` and `iccbot`, so you need to install their libraries before build the jar.

```shell
./install.sh
```

or (in case on the windows platform):

```bat
install.bat
```

After installed the required libraries, you can build the jar file by using:

```shell
mvn clean package assembly:single
```

### Usage

```shell
java -jar target/newICC-1.0-SNAPSHOT-jar-with-dependencies.jar \
  -p sources/com.spdroid.c \
  -n com.spdroid.c \
  -i com.sproid.c-enre-out/com.spdroid.c-out.json \
  -outputDir iccout \
  -path $HOME/apks \
  -name com.spdroid.c.apk
```
