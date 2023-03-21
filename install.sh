#! /usr/bin/env bash

mvn install:install-file -DgroupId=org.example -DartifactId=dependency_analysis_java -Dversion=1.0-SNAPSHOT  -Dpackaging=jar -Dfile=./lib/dependency_analysis_java-1.0-SNAPSHOT-jar-with-dependencies.jar -DgeneratePom=true
mvn install:install-file -DgroupId=org.example -DartifactId=intent_analysis -Dversion=1.1  -Dpackaging=jar -Dfile=./lib/ICCBot_1.1.jar -DgeneratePom=true
