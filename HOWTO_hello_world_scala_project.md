# Hello world Scala project

[Reference sbt site](https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html)

Create a hello world project. From an empty folder:

```
$ sbt new scala/hello-world.g8
[info] welcome to sbt 1.4.0 (Amazon.com Inc. Java 1.8.0_265)
[info] set current project to emptyfolder (in build file:)
[info] set current project to emptyfolder (in build file:)

A template to demonstrate a minimal Scala application 

name [Hello World template]: 
Template applied in emptyfolder/./hello-world-template

$ cd hello-world-template/
```

Inspect the source code generated in the hello-world-template folder.

The file hello-world-template/build.sbt contains the build definition such as the Scala version and the project dependencies.
The folder hello-wold-template/src contains the source code of the project. In this case a single file with a single object:
```
object Main extends App {
  println("Hello, World!")
}
```

The hello world example simply has a Main object that prints a message through the console.

The previous command generates a project from a template stored in Github. 
Some official templates are located in: [SBT template resolver](https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html#Template+Resolver)
You can find more community maintained templates in the following site: [giter8 templates](https://github.com/foundweekends/giter8/wiki/giter8-templates)

You can find for example Akka templates, Play Framework templates or Spark templates

# Running hello world template

From the folder of the project first start SBT:
```
    $ cd hello-world-template
    $ sbt
```

To run the project type "run" in the SBT console.
This command triggers the downloading of dependencies of the project, the compilation and then executes the code by finding an object with a main method defined.
In this example this is accomplished by defining an object Main that extends App trait.

```
   sbt> run
   [info] Compiling 1 Scala source to hello-world-template/target/scala-2.13/classes ...
   [info] running Main 
   Hello, World!
   [success] Total time: 12 s, completed 18-oct-2020 18:10:19
   sbt:hello-world> 
```

Quitting SBT and returning to the operating system prompt:
```
sbt:hello-world> exit
[info] shutting down sbt server
$ 
```

# SBT REPL

In SBT you can also invoke the REPL (Read Evaluation Print Loop) tool by using "console" command:

```
    $ cd hello-world-template
    $ sbt
    sbt> console
```

From the REPL you can evaluate and execute any object or method defined in the project for example:
```
 sbt:hello-world> console
 [info] Starting scala interpreter...
 Welcome to Scala 2.13.1 (OpenJDK 64-Bit Server VM, Java 1.8.0_265).
 Type in expressions for evaluation. Or try :help.
 scala> Main.main(Array())
 Hello, World!
```

In this previous command you run the main method of the singleton object Main with an empty list of Strings as argument.
This empty list mimics the list arguments entered by command line as in argv/argc used by the C programming language for example.
It has the same effect as running the command "run" from SBT console (explained before)

From the REPL you can get the type of an expression by using the :type command:
```
scala> :type Main
Main.type
```

Obtaining the type of the main method of the Main singleton object:
```
scala> :type Main.main(_)
Array[String] => Unit
```
(Note the use of "_" to transform the method main in a function) 

Other examples:
```
scala> :type 1
Int

scala> :type 1.0
Double

scala> :type "Y combinator"
String
```

Quitting REPL and returning to the SBT console:
```
scala> :quit

[success] Total time: 1436 s (23:56), completed 18-oct-2020 18:38:28
[...]
[warn] Automatically reload the build when source changes are detected by setting `Global / onChangedBuildSource := ReloadOnSourceChanges`.
[warn] Disable this warning by setting `Global / onChangedBuildSource := IgnoreSourceChanges`.
sbt:hello-world> 
```
# Add dependencies to the project

To add dependencies to the project (additional libraries to use in the project) you have to modify the hello-world-template/build.sbt (ongoing example) and add the line below.
in this example we add akka typed actors library: 
```
...
libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor-typed" % "2.6.9")
...
```
You can find more published libraries on [Scaladex](https://index.scala-lang.org/), the Scala library index, where you can also copy the above dependency information for pasting into your build.sbt file.