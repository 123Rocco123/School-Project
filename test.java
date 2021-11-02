// Program Name: Monopoly Game
// Author: Rocco Petruccio
import java.util.Scanner;


class test {
  public static void game(boolean start) {
    Scanner input = new Scanner(System.in);
    int dice = (int)((Math.random() * 6) + 1);

    boolean startingConditions = start;

    if (startingConditions == true) {
      System.out.println("How many players are playing the game? ");
      int numberOfPlayers = input.nextInt();

      startingConditions = false;
    }
  }

  // The function below is used to start the game or not.
  public static void startGame(boolean start) {
    // The scanner object is used to get the user input.
    Scanner input = new Scanner(System.in);

    // The "start" variable is used for the while loop below, and to start the game.
    boolean start = false;

    // The condition of the loop below is dependent on the previous variable, "start".
    while (start == false) {
      System.out.println("Write \"start\" to start the game: ").toLowerCase();
      String userInput = input.nextLine();

      /* The if else block below is used to see if the user has written "start".
         If they did, then the loop will be broken (condition will be true) and the "game" function will be called. */
      if (userInput == "start") {
        start = true;
        game(start);
      } else {
        System.out.println("Input not accepted.");
      }
    }
  }


  public static void main(String[] args) {
    startGame();
  }
}
