// Program Name: Monopoly Game
// Author: Rocco Petruccio
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;


class test {
  // The following function is used to store the answer for the question that is outputted to the screen.
  public static void AnswersToQuestions(String Answer) {
    String questionAnswer = Answer;

    System.out.print(questionAnswer + " ");
  }

  // This function has the purpose of containing the questions and answers.
     // It's just i salso that of checking if the answers are correct or not.
  public static String questions() {
    // Dictionary containing all of the questions required for the game.
    Hashtable<String, String> questionsDictionary = new Hashtable<String, String>();

    // ArrayList that'll be used to store the key values of the dictionary.
       // ArrayList below stores the values.
    ArrayList<String> keyValuesDic = new ArrayList<String>();
    ArrayList<String> AnswersValuesDic = new ArrayList<String>();

    // Adding keys and values (Question, Answer)

    questionsDictionary.put("Did the Lakers win the 2000 NBA Finals? ", "yes");
    questionsDictionary.put("Did the Celtics ever win 3 championships with Larry Bird? ", "no");
    questionsDictionary.put("Who won the most Premier Team titles? ", "Manchester United");
    questionsDictionary.put("Where was the 2006 World Cup hosted? ", "Germany");
    questionsDictionary.put("What team has the most NBA championships? ", "Celtics and Lakers");
    questionsDictionary.put("When did the Bulls lose in the finals? ", "never");

    int randomIndex = (int)(Math.random() * questionsDictionary.size());

    // For loop will add all of the keyValues of the dictionary to the ArrayList.
    for (String i : questionsDictionary.keySet()) {
      keyValuesDic.add(i);
    }

    // For loop will add all of the Values of the dictionary to the ArrayList.
    for (String i : questionsDictionary.values()) {
      AnswersValuesDic.add(i);
    }

    // These are the questions and answer combos that the players are asked.
    String question = keyValuesDic.get(randomIndex);
    String answer = AnswersValuesDic.get(randomIndex);

    // While the answer is returned so that it can be stored and compared to the user input, the question is printed out to the terminal.
    System.out.println(question);
    return answer;
  }

  // The functions purpose is that of constantly generating a new random number that can be used.
  public static int randomNumberFunc() {
    int diceThrow = (int)((Math.random() * 6) + 1);

    return diceThrow;
  }

  // The function below is used to store the Algorithm for the game.
  public static void gameAlgorithm(int playersInGame) {
    // The ArrayList below is used to store the positions of the players.
    ArrayList<Integer> PlayerPositions = new ArrayList<Integer>();

    PlayerPositions.add(0);
    PlayerPositions.add(0);
    PlayerPositions.add(0);

    Scanner input = new Scanner(System.in);

    // The argument "playersInGame" is saved here for it to be used later in the for loop.
    int playerCount = playersInGame;

    boolean gameOver = false;

    while (gameOver == false) {
      for (int i = 0; i < playerCount; i++) {
        System.out.println("\nPlayer " + (i + 1) + ", you rolled a: " + randomNumberFunc() + "\n");

        String answer = questions();
        String userAnswer = input.nextLine();

        if (userAnswer.equals(answer)) {
          System.out.println("You're correct");
        } else {
          System.out.println("You're incorrect");

          // If the user is incorrect, then they'll have to move back by one space.
          int newPos = PlayerPositions.get(i);
          PlayerPositions.set(i, (newPos - 1));
        }
      }
      break;
    }
  }

  // This function is used to determine the conditions of the game.
  public static void game(boolean start) {
    // The Scanner object below is used to allow for user input
    Scanner input = new Scanner(System.in);

    // The "startingCondtions" variable is used to store the boolean argument of the function.
      // It's inted purpose is that of seeing if this is a new game or not.
    boolean startingConditions = start;

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
