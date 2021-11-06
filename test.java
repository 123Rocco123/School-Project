// Program Name: Monopoly Game
// Author: Rocco Petruccio
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;


class test {
  // The function below is used to ask the user the question.
     // Depending on the size of the Hashtable containing the questions, a random number will be generated which will be used to print out a random question.
  public static String questionToAsk(ArrayList<String> QuestionArray, ArrayList<String> AnswersArray) {
    // The variable "randomNumber" below is used to select the index value of the ArrayList to ask the user that question.
       // Since "Math.random" will output a double, we have to use the "(int)" to change the variable to an integer.
    int randomNumber = (int)(Math.random() * QuestionArray.size());

    // The call below is used to give the "AnswersToQuestions" function the answer to the question.
    AnswersToQuestions(AnswersArray.get(randomNumber));

    // The "return" statement below is used to return the random question.
    return QuestionArray.get(randomNumber);
  }

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

    // For loop will add all of the keyValues of the dictionary to the ArrayList.
    for (String i : questionsDictionary.keySet()) {
      keyValuesDic.add(i);
    }

    // For loop will add all of the Values of the dictionary to the ArrayList.
    for (String i : questionsDictionary.values()) {
      AnswersValuesDic.add(i);
    }

    // The return statement below will print out the returned statement (question) that the user has to answer in the game.
       // This is so that we can return it back to the "gameAlgorithm" function.
    return questionToAsk(keyValuesDic, AnswersValuesDic);
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

    Scanner input = new Scanner(System.in);

    // The argument "playersInGame" is saved here for it to be used later in the for loop.
    int playerCount = playersInGame;

    boolean gameOver = false;

    while (gameOver == false) {
      for (int i = 0; i < playerCount; i++) {
        System.out.println("You rolled a: " + randomNumberFunc());

        System.out.println(questions());

        String UserAnswer = input.nextLine();
        // if (userAnswer.equals(questions))
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
