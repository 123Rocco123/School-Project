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

    // The record type below is used to store the answer and question combo.
    record Answer(String AnswertoQuestion, String Question) {}

    // We then assign questions and answers here by creating a new instance of the answerMatch record type.
    Answer answerMatch = new Answer(AnswersValuesDic.get(randomIndex), keyValuesDic.get(randomIndex));

    // While the answer is returned so that it can be stored and compared to the user input, the question is printed out to the terminal.
    System.out.println(answerMatch.Question);
    return answerMatch.AnswertoQuestion;
  }

  // The functions purpose is that of constantly generating a new random number that can be used.
  public static int randomNumberFunc() {
    int diceThrow = (int)((Math.random() * 6) + 1);

    return diceThrow;
  }

  // The function is used to determine the position of the player after they've made a mistake or if they've landed on a ladder.
  public static int playerPositions(int currentIndex, String LadderOrChute) {
    int chuteOrLadder = (int)((Math.random() * 21) + 10);

    /* The if else statements below are used to determine the new positions of the players depending on if they landed on a ladder, chute, or if they just got the answer wrong, and have to move one step back.
          The if statements are based off of the arguments that are passed on into it by the function. */
      if (LadderOrChute.equals("chute")) {
        return currentIndex - chuteOrLadder;
    } else if (LadderOrChute.equals("ladder")) {
        return currentIndex + chuteOrLadder;
    } else {
        return 0;
    }
  }

  // The "board" function has the role of outputting the board that the players are playing on.
  public static void board(ArrayList players, int playerPosition) {
    ArrayList<String> strList = new ArrayList<String>();
    ArrayList<String> playersPlaying = new ArrayList<String>();
    playersPlaying = players;

    // The for loop is used to apped new board pieces to the ArrayList "strlist" above.
       // The goal of this being that we're able to re-create the chutes and ladders board with pieces representing the players.
    for (int x = 0; x < 10; x++) {
      // The inner for loop is used to create the rows of the board, while the outer for loop will repeat the process 10 times, as there are 10 rows on the board.
      for (int i = 0; i < 10; i++) {
        strList.add("|_|");
      }
    }

    String newIndex = "";

    // Depending on the position that the player is at, then they'll appear at different places on the board.
       // The set dot notation is used to change the current index with the player "piece".
    if (playersPlaying.size() == 1) {
      for (int i = 0; i < playersPlaying.size(); i++) {
        String newPosition = "|" + playersPlaying.get(i) + "|";

        strList.set(playerPosition, newPosition);
      }
    } else if (playersPlaying.size() == 2) {
      for (int i = 0; i < playersPlaying.size(); i++) {
        newIndex += (playersPlaying.get(i));

        strList.set(playerPosition, newIndex);
      }
      newIndex += "|";
      strList.set(playerPosition, newIndex);
    } else if (playersPlaying.size() == 3) {
      for (int i = 0; i < playersPlaying.size(); i++) {
        newIndex += (playersPlaying.get(i));

        strList.set(playerPosition, newIndex);
      }
    }

    // The index below is used to determine when to stop printing the board.
       // Depending on the index.
    int index = 0;

    // The for loop below is used in a similar way as the one above.
       // The key difference being that instead of appending something to the ArrayList, we're just printing it out based on the index.
    for(int x = 0; x < 10; x++) {
      for(int i = 0; i < 10; i++) {
        System.out.print(strList.get(index));
        index += 1;
      }
      System.out.println("");
    }
  }

  // The function below is used to store the Algorithm for the game.
  public static void gameAlgorithm(int playersInGame) {
    Scanner input = new Scanner(System.in);

    // The variable is used to determine if this is the first game or not.
       // This is used to determine if we have to add new starting positions to the "PlayerPositions" ArrayList.
    boolean newGame = true;

    // The ArrayList below is used to store the positions of the players.
    ArrayList<Integer> PlayerPositions = new ArrayList<Integer>();

    // The argument "playersInGame" is saved here for it to be used later in the for loop.
    int playerCount = playersInGame;

    // Depending on the amount of players that are going to play the game game, the for loop will repeat that many times.
       // This means that depending on the amount of players, more or less starting positions will be added to the "PlayerPositions" ArrayList.
    if (newGame == true) {
      for (int i = 0; i < playerCount; i++) {
        PlayerPositions.add(0);
      }
      newGame = false;
    }

    System.out.println(PlayerPositions);

    // The "gameOver" function is used to determine when the game has finished.
    boolean gameOver = false;

    // The while loop is used to combine all of the questions, postions of the player, and etc to create the game itself.
    while (gameOver == false) {
      //
      for (int i = 0; i < playerCount; i++) {
        int diceThrow = randomNumberFunc();
        int oldValue = PlayerPositions.get(i);
        int normalOrSpecial = (int)(Math.random() * 6);

        System.out.println(diceThrow +" "+ oldValue +" "+ normalOrSpecial);

        int currentPositionOnBoard = PlayerPositions.get(i);
        System.out.println("\nPlayer " + (i + 1) + ", you rolled a: " + diceThrow + "\n");

        String answer = questions();
        String userAnswer = input.nextLine();

        if (userAnswer.equals(answer)) {
          System.out.println("You're correct");

          if (normalOrSpecial < 4) {
            PlayerPositions.set(i, (oldValue + diceThrow));
          } else if (normalOrSpecial == 5) {
            int rightAndLadder = playerPositions(currentPositionOnBoard, "ladder");
            PlayerPositions.set(i, rightAndLadder);
          }
        } else {
          System.out.println("You're incorrect");

          // If the user is incorrect, then they'll have to move back.
             // The amount that they move back is based on how long the ladder is.
          if (normalOrSpecial < 4) {
            PlayerPositions.set(i, (oldValue - 1));
          } else if (normalOrSpecial == 5) {
            int wrongAndChute = playerPositions(currentPositionOnBoard, "chute");
            PlayerPositions.set(i, wrongAndChute);
          }
        }
      }
      System.out.println(PlayerPositions);
      break;
    }
  }

  public static void pieceSelection(int numberOfPlayers) {
    Scanner input = new Scanner(System.in);
    ArrayList<String> playerPieces = new ArrayList<String>();

    // The for loop below is used to ask the player / players what pieces they want to use to play the game.
    for (int i = 0; i < numberOfPlayers; i++) {
      System.out.println("Choose your piece out of: x, y, z");

      String chosenPieceIs = input.nextLine();
      if (chosenPieceIs.equals("x") || chosenPieceIs.equals("y") || chosenPieceIs.equals("z")) {
        playerPieces.add(chosenPieceIs);
      } else {
        System.out.println("Invalid piece chosen");
        pieceSelection(numberOfPlayers);
      }
    }

    board(playerPieces, 0);
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

      pieceSelection(numberOfPlayers);
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
