import HandSymbol.HandSymbol
import Result.Result

object Main {


  def chooseHandSymbol: HandSymbol = {
    val rnd = new scala.util.Random()
    HandSymbol(rnd.nextInt(3))
  }

  def gameResult(left: HandSymbol, right: HandSymbol): Result = {
    if (left == right) {
      Result.Draw
    } else if (left == HandSymbol.Rock) {
      if (right == HandSymbol.Scissors) Result.Win else Result.Lose
    } else if (left == HandSymbol.Paper) {
      if (right == HandSymbol.Rock) Result.Win else Result.Lose
    } else if (right == HandSymbol.Paper) Result.Win else Result.Lose
  }


  def main(args: Array[String]) {

    var result = Result.Draw
    do {
      val left = chooseHandSymbol
      val right = chooseHandSymbol
      result = gameResult(left, right)
      println("Left,Right,Result=" + left +right+result)
    } while (result == Result.Draw)

  }
}