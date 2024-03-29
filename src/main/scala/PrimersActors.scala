//package main

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case class Compute(data: Seq[Int], cont: ActorRef)
case class Count(n: Int, t:Long)
case class Done(count: Int)

class PrimeCounter extends Actor {
  def isPrime(n: Int): Boolean = new java.math.BigInteger("" + n).isProbablePrime(20)

  def receive: Receive = {
        case Compute(data,c) =>
          val answer = data.count(isPrime)
          c ! Done(answer)
  }
}


class Summarizer extends Actor {
  var total = 0
  var count = 0
  var temps:Long =0

  def updateCount(n: Int) {
    count += n
    if (count == 0) {
      println("Hi ha " + total + " primers")
      println("S'ha trigat: " + (System.nanoTime - temps) / 1e9d + " segons")
    }
  }

  def receive: Receive = {
        case Count(n,t) =>
          updateCount(n)
          temps = t
        case Done(np) =>
          total += np
          updateCount(-1)
  }
}

object PrimersActors extends App {
  val max = 10000000
  // try with 1000000 or 10000000 if you have more patience
  val nactors = 10
  val groupSize = max / nactors / 10


  val systema = ActorSystem("sistema")

  val primeCounters = for (i <- 0 until nactors) yield systema.actorOf(Props[PrimeCounter], "cutre"+i)


//  val primeCounters = for (i <- 0 until nactors) yield new PrimeCounter
//  for (a <- primeCounters) a.start()

  val s = systema.actorOf(Props[Summarizer], "suma")

    val groups = (2 to max).grouped(groupSize).zipWithIndex.toSeq

  val t1 = System.nanoTime //marca de temps inici de computs

  s ! Count(groups.length, t1)


    for ((g, i) <- groups)  {
      val a = primeCounters(i % primeCounters.length)
      a ! Compute(g,s)
    }

    println("tot enviat, esperant... a veure si triga en PACO")

}




/*
 * This program demonstrates communication between actors.
 * The program uses actors to count how many primes there are in
 * a given range of integers.
 *
 * The PrimeCounter sends messages to a continuation actor that
 * is passed in the Compute method.
 *
 * The Summarizer actor is constructed with an actor argument. It
 * sends messages to that actor.


import scala.actors.Actor
import scala.actors.Actor._

case class Compute(data: Seq[Int], result: Actor)
case class Count(n: Int)
case class Done(count: Int)

class PrimeCounter extends Actor {
  def isPrime(n: Int) = new java.math.BigInteger("" + n).isProbablePrime(20)

  def act() {
    while (true) {
      receive {
        case Compute(data, continuation) => {
          val answer = data.count(isPrime)
          continuation ! Done(answer)
        }
      }
    }
  }
}

class Summarizer(completion: Actor) extends Actor {
  var total = 0
  var count = 0

  def updateCount(n: Int) {
    count += n
    if (count == 0) completion ! Done(total)
  }

  def act() {
    while (true) {
      receive {
        case Count(n) => updateCount(n)
        case Done(t) => {
          total += t
          updateCount(-1)
        }
      }
    }
  }
}

object Main extends App {
  val max = 100000
  // try with 1000000 or 10000000 if you have more patience
  val nactors = 10
  val groupSize = max / nactors / 10

  val primeCounters = for (i <- 0 until nactors) yield new PrimeCounter
  for (a <- primeCounters) a.start()

  actor {
    val s = new Summarizer(self)
    s.start

    val groups = (2 to max).grouped(groupSize).zipWithIndex.toSeq
    s ! Count(groups.length)
    for ((g, i) <- groups)  {
      val a = primeCounters(i % primeCounters.length)
      a ! Compute(g, s)
    }

    receive {
      case Done(c) => {
        println(c + " primes")
        System.exit(0)
      }
    }
  }
}
*/

