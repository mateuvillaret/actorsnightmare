import akka.actor._
// Non working example
// it seems actors used this way is not supported by
// Scala Worksheet
class Summer extends Actor {
  var sum = 0
  def receive = {
    case ints: Array[Int] =>
      sum += ints.reduceLeft((a, b) => (a+b) % 7)
    case "print" => println("Sum:" + sum)
  }
}

val system = ActorSystem("SummerSystem")
val summer = system.actorOf(Props[Summer], name = "summer")

summer ! (1 to 20).toArray

println("ja enviat")

summer ! "print"