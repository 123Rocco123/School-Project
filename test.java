// Program Name: Monopoly Game
// Author: Rocco Petruccio
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;


class test {
  public static String questions() {
    // Dictionary containing all of the questions required for the game.
    Hashtable<String, String> questionsDictionary = new Hashtable<String, String>();

    // Adding keys and values (Question, Answer)

    questionsDictionary.put("Did the Lakers win the 2000 NBA Finals? ", "yes");
    questionsDictionary.put("Did the Celtics ever win 3 championships with Larry Bird? ", "no");
    questionsDictionary.put("Who won the most Premier Team titles? ", "Manchester United");
    questionsDictionary.put("Where was the 2006 World Cup hosted? ", "Germany");
    questionsDictionary.put("What team has the most NBA championships? ", "Celtics and Lakers");
    questionsDictionary.put("When did the Bulls lose in the finals? ", "never");

    int indexValue = (int)(Math.random() * questionsDictionary.size());

    System.out.println((questionsDictionary.keySet()).get(indexValue));
    return questionsDictionary.get(indexValue);
  }

  public static void gameAlgorithm(int playersInGame) {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> playerRolls = new ArrayList<Integer>();
    ArrayList<Integer> hotSpots = new ArrayList<Integer>();

    /* The for loop is used to roll the dice for each player in the game.
       Once the dice has been rolled once, it'll be added to the ArrayList defined above. */
    for (int i = 0; i < playersInGame; i++) {
      // The Math.random object is used to represent the die that the user throws for the game.
      int dice = (int)((Math.random() * 6) + 1);

      // This is used to keep the
      int hotSpot = (int)(Math.random() * 3);

      // This will add the rolls that the player rolled in the "playerRolls" arraylist.
      playerRolls.add(dice);
      hotSpots.add(hotSpot);

      if (hotSpots.get(i) == 0) {
        // Normal Question
        questionAnswer = questions();

        String answer = input.nextLine();
        if (answer.equals(questionAnswer)) {
          System.out.println("You're correct!");
        } else {
          System.out.println("Wrong");
          playerRolls.get(i) -= 1;

          if (playerRolls.get(i) < 0) {
            playerRolls.get(i) = 0;
          }
        }
      } else if (hotSpots.get(i) == 1) {
        // Secret Passage
        questionAnswer = questions();

        String answer = input.nextLine();
        if (answer.equals(questionAnswer)) {
          System.out.println("You're correct!");

          int randomNum = (int)((Math.random() * 3) + 1);
          playerRolls.get(i) += randomNum;
        } else {
          System.out.println("Wrong");
          playerRolls.get(i) -= 1;

          if (playerRolls.get(i) < 0) {
            playerRolls.get(i) = 0;
          }
        }
      } else if (hotSpots.get(i) == 2) {
        // Trap
        questionAnswer = questions();

        String answer = input.nextLine();
        if (answer.equals(questionAnswer)) {
          System.out.println("You're correct!");
        } else {
          System.out.println("Wrong");

          int randomNum = (int)((Math.random() * 3) + 1);
          playerRolls.get(i) -= randomNum;

          if (playerRolls.get(i) < 0) {
            playerRolls.get(i) = 0;
          }
        }
      }
    }
  }

  // This function is used to determine the conditions of the game.
  public static void game(boolean start) {
    // The Scanner object below is used to allow for user input
    Scanner input = new Scanner(System.in);

    // The "startingCondtions" variable is used to store the boolean argument of the function.
      // It's inted purpose is that of seeing if this is a new game or not.
    boolean startingConditions = start;

    // The purpose of the "end" boolean is to determine if the game has ended or not.
    boolean end = false;

    // The if condition is used to see if this is a new game.
      // If it is then the code within the if statement is executed.
    if (startingConditions == true) {
      System.out.println("How many players are playing the game? ");
      int numberOfPlayers = input.nextInt();

      startingConditions = false;
      gameAlgorithm(numberOfPlayers);
    }
  }

  // The function below is used to start the game or not.
  public static void startGame() {
    // The scanner object is used to get the user input.
    Scanner input = new Scanner(System.in);

    // The "start" variable is used for the while loop below, and to start the game.
    boolean startCondition = false;

    // The condition of the loop below is dependent on the previous variable, "start".
    while (startCondition == false) {
      System.out.println("Write \"start\" to start the game: ");
      String userInput = input.nextLine();
      userInput.toLowerCase();

      /* The if else block below is used to see if the user has written "start".
         If they did, then the loop will be broken (condition will be true) and the "game" function will be called. */
      if (userInput.equals("start")) {
        startCondition = true;
        game(startCondition);
      } else {
        System.out.println("Input not accepted.");
      }
    }
  }

  public static void main(String[] args) {
    startGame();
  }
}
