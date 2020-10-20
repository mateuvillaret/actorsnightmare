//package main


object Main extends App {
  val max = 10000000
  def isPrime(n: Int): Boolean = new java.math.BigInteger("" + n).isProbablePrime(20)

  println(s"Anem a comptar primers, de 2 a $max")
  val temps = System.nanoTime
  val answer = (2 to max).count(isPrime)

  println(s"Hi ha $answer primers")
  println("S'ha trigat: " + (System.nanoTime - temps) / 1e9d + " segons")
}




