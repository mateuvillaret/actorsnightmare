# Actors Nightmare
playing with sbt intellij akka SF4J dependencies


To setup the Scala command line development environment follow:
[HOWTO_setup_scala_development_environment.md](https://github.com/mateuvillaret/actorsnightmare/blob/main/HOWTO_setup_scala_development%20environment.md)

To start with this project clone it using git in your local machine:

```
$ git clone https://github.com/mateuvillaret/actorsnightmare.git
$ cd actorsnightmare
```

To run the project:
```
$ cd actorsnightmare
$ sbt
sbt:scala-actors-example> run
[info] compiling 1 Scala source to /home/oriol/IdeaProjects/actorsnightmare/target/scala-2.13/classes ...
[info] Non-compiled module 'compiler-bridge_2.13' for Scala 2.13.3. Compiling..
[info]   Compilation completed in 32.101s.
[warn] 1 deprecation (since 2.13.0)
[warn] 2 deprecations (since 2.13.3)
[warn] 3 deprecations in total; re-run with -deprecation for details
[warn] three warnings found
[info] running Main 
0 [sistema-akka.actor.default-dispatcher-4] INFO akka.event.slf4j.Slf4jLogger - Slf4jLogger started
tot enviat, esperant... a veure si triga en PACO
Hi ha 664579 primers
S'ha trigat: 18.851755749 segons
```
To create a hello world project from scratch and get more details of the structure of a Scala project and learn some examples of the REPL please refer to [HOWTO_hello_world_scala_project.md](https://github.com/mateuvillaret/actorsnightmare/blob/main/HOWTO_hello_world_scala_project.md)

To generate a stand alone binary executable please refer to [HOWTO_deploy_standalone_executable.md](https://github.com/mateuvillaret/actorsnightmare/blob/main/HOWTO_deploy_standalone_executable.md)

To develop it using IntelliJ IDE (TO BE COMPLETED).
