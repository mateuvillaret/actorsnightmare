To compile and deploy Scala (2.13.x) projects you need:

# JDK

JDK is the runtime and developement kit for Java. 
Scala compiles to Java bytecode that runs on the JVM.
A JDK version 1.8 should be installed on your system.
There are several implementations available. For example:

[Amazon JDK Corretto](https://aws.amazon.com/es/corretto/)

[Oracle JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

After installation verify that the version of the java executable is 1.8.xxx (other versions of JDK are not guaranteed to work):

```
$ java -version
openjdk version "1.8.0_265"
OpenJDK Runtime Environment Corretto-8.265.01.1 (build 1.8.0_265-b01)
OpenJDK 64-Bit Server VM Corretto-8.265.01.1 (build 25.265-b01, mixed mode)
```

# SBT

SBT is the standard build tool for Scala projects.

It allows creating, compiling, debugging, testing and deploying Scala projects.
It also contains a Scala REPL.

To install SBT follow the instructions in:

[SBT download and install instructions](https://www.scala-sbt.org/download.html)

For example in debian based Linux (Ubuntu, etc):
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt
```

If you are not sudoer you can install it in any folder of the system by downloading the zip file from the same web page.
