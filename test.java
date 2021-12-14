// Program Name: Chutes and Ladder Game
// Author: Rocco Petruccio
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;

// The class above is used as a constructor.
class roundCalculator {
  int currentRound = 0;

  // The argument "playersInGame" is saved here for it to be used later in the for loop.
  int playerCount;

  // The variable is used to determine if this is the first game or not.
     // This is used to determine if we have to add new starting positions to the "PlayerPositions" ArrayList.
  boolean newGame;

  // The "gameOver" variable is used to determine when the game has finished.
  boolean gameOver;

  // The ArrayList below is used to store the positions of the players.
  ArrayList<String> playerPieces = new ArrayList<String>();
}

class test {
  // The following function is used to store the answer for the question that is outputted to the screen.
  public static void AnswersToQuestions(String Answer) {
    String questionAnswer = Answer;

    System.out.print(questionAnswer + " ");
  }

  // This function has the purpose of containing the questions and answers.
     // It's just is also that of checking if the answers are correct or not.
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
    // Generates an integer number from 0 to 5.
       // The 1 is used to make the number go from 1 to 6.
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
        return 1;
    }
  }

  // The "board" function has the role of outputting the board that the players are playing on.
  public static void board(ArrayList<String> players, ArrayList<Integer> playerPosition) {
    ArrayList<String> strList = new ArrayList<String>();
    ArrayList<String> playersPlaying = players;
    ArrayList<Integer> playersPlayingIndex = playerPosition;

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
      // The if conditions below determine how many indexes have to change, and how they have to change depending on the amount of players that are currently in game.
    if (playersPlaying.size() == 1) {
      // The "strList.set" below is used to change the index of the board to include the positon that the player is currently at.
      strList.set(playersPlayingIndex.get(0), "|" + playersPlaying.get(0) + "|");

      // If two players are playing the game, then the else if statement below will be used.
    } else if (playersPlaying.size() == 2) {
      // If the two players have the same index, i.e. they're on the same tile, then the if statement below will be used.
      if (playersPlayingIndex.get(0) == playersPlayingIndex.get(1)) {
          // The "newIndex" string variable is used to combine the two players into one index so that they can be placed on the board together.
          newIndex += (playersPlaying.get(0)+playersPlaying.get(1)+"|");

          strList.set(playersPlayingIndex.get(0), newIndex);
      }
      // If the two players don't have the same then, the else statement below is used, and the indexes are simply changed as such.
      else {
        strList.set(playersPlayingIndex.get(0), ("|" + playersPlaying.get(0) + "|"));
        strList.set(playersPlayingIndex.get(1), ("|" + playersPlaying.get(1) + "|"));
      }
      // Below the else if statement is used if there are 3 players in the game.
    } else if (playersPlaying.size() == 3) {
      // The if statement below is used to see if all three players have the same index.
      if (playersPlayingIndex.get(0) == playersPlayingIndex.get(1) && playersPlayingIndex.get(2) == playersPlayingIndex.get(1)) {
          newIndex += (playersPlaying.get(0) + playersPlaying.get(1) + playersPlaying.get(2));

          strList.set(playersPlayingIndex.get(0), newIndex);
      } else if (playersPlayingIndex.get(0) == playersPlayingIndex.get(1)) {
        newIndex += playersPlaying.get(0) + playersPlaying.get(1) + "|";

        strList.set(playersPlayingIndex.get(0), (newIndex));
        strList.set(playersPlayingIndex.get(2), ("|" + playersPlaying.get(2) + "|"));
      } else if (playersPlayingIndex.get(0) == playersPlayingIndex.get(2)) {
        newIndex += playersPlaying.get(0) + playersPlaying.get(2) + "|";

        strList.set(playersPlayingIndex.get(0), (newIndex));
        strList.set(playersPlayingIndex.get(1), ("|" + playersPlaying.get(1) + "|"));
      } else if (playersPlayingIndex.get(1) == playersPlayingIndex.get(2)) {
        newIndex += playersPlaying.get(1) + playersPlaying.get(2) + "|";

        strList.set(playersPlayingIndex.get(1), (newIndex));
        strList.set(playersPlayingIndex.get(0), ("|" + playersPlaying.get(0) + "|"));
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

  // Accessor function for class object.
     // Used to keep track of the round in the game.
  public static void immediateRound(roundCalculator objectName, int round) {
    objectName.currentRound += round;
  }

  // The function is used to check if someone is a winner or not.
  public static boolean winner(ArrayList<Integer> playerPositions, roundCalculator objectName) {
    ArrayList<Integer> Podium = playerPositions;

    int placeholder = 0;

    // The for loop below is the sort algorithm which sorts the positions that the players were in when one of them wins from highest to lowest.
       // It's sorting it in terms of the podium positions (1st, 2nd, and 3rd).
    for (int i = Podium.size() - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (Podium.get(j) < Podium.get(j+1)) {
          placeholder = Podium.get(j);

          Podium.set(j, Podium.get(j+1));
          Podium.set(j+1, placeholder);
        }
      }
    }

    // The for loop below is then used to check which player has won, and then outputs it to the terminal.
       // It also uses another for loop inside of the if condition to print out the podium for the rest of the players.
    for (int x = 0; x < playerPositions.size(); x++) {
      if (playerPositions.get(x) >= 100) {
        System.out.println("Congratulations Player " + (x + 1) + ", you've won!");
        System.out.println("\nPodium:\n");
        for (int y = 0; y < Podium.size(); y++) {
          if (playerPositions.get(x) >= 100) {
            System.out.println((y+1) + ": 100");
          } else {
            System.out.println((y+1) + ": " + Podium.get(y));
          }
        }
        objectName.gameOver = true;
        return true;
      }
    }

    return false;
  }

  // The function is used to keep track of the amount of players that are currently playing in the game.
  public static void playersPlayingGame(roundCalculator objectName, int playersInGame) {
    objectName.playerCount = playersInGame;
  }

  // The function below is used to store the Algorithm for the game.
  public static void gameAlgorithm(int playersInGame) {
    Scanner input = new Scanner(System.in);

    // The class object below is used to keep track of the round that the players are playing in.
       // This is done by creating the object, and then initalizing the instance variable "currentRound".
    roundCalculator currentRound1 = new roundCalculator();

    // The assignments below are used to assing values to the instance variables inside of the constructor class.
       // They are then used in the algorithm below.
    currentRound1.newGame = true;
    currentRound1.gameOver = false;
    currentRound1.playerPieces = pieceSelection(playersInGame);

    // The function calls are used to store the values of the amount of players in the game into the instance variable of the class object, and the round that the player is playing.
    playersPlayingGame(currentRound1, playersInGame);
    immediateRound(currentRound1, 1);

    // The ArrayList below is used to store the positions of the players.
    ArrayList<Integer> PlayerPositions = new ArrayList<Integer>();

    // Depending on the amount of players that are going to play the game game, the for loop will repeat that many times.
       // This means that depending on the amount of players, more or less starting positions will be added to the "PlayerPositions" ArrayList.
    if (currentRound1.newGame == true) {
      for (int i = 0; i < currentRound1.playerCount; i++) {
        PlayerPositions.add(0);
      }
      currentRound1.newGame = false;
    }

    // The while loop is used to combine all of the questions, postions of the player, and etc to create the game itself.
    while (currentRound1.gameOver == false) {
      //System.out.println(PlayerPositions);
      System.out.println("Round: " + currentRound1.currentRound);

      // The for loop below is used to ask the players different questions.
         // The amount of times that it will repeat in a single round depends on the number of players playing the game.
      for (int i = 0; i < currentRound1.playerCount; i++) {
        /* The int variables below are used for:
           Getting a random number between 0 and 7 (1 and 6), which is used as the dice throw.
           The current position of the player which will be updated this round.
           If the player landed on a ladder or chute or a normal spot. */
        int diceThrow = randomNumberFunc();
        int oldValue = PlayerPositions.get(i);
        int normalOrSpecial = (int)(Math.random() * 6);

        //System.out.println(diceThrow +" "+ oldValue +" "+ normalOrSpecial);

        // The currentPositionOnBoard variable when having calling the "playerPositions" function.
           // Called only when the player lands on a chute or ladder.
        int currentPositionOnBoard = PlayerPositions.get(i);
        System.out.println("\nPlayer " + (i + 1) + ", you rolled a: " + diceThrow + "\n");

        // "answer" is used to store the answer of the question that the player is being asked to answer.
        String answer = questions();
        // "userAnswer" is then used to store the answer that the user wrote to then check if its correct or not.
        String userAnswer = input.nextLine();

        // The series of if, else, and else if statements below are used to check if the answer that the user wrote is correct.
           // If its correct, then they'll be told so, and then depending on where they landed their position on the board can change by minimum the side that the dice was.
        if (userAnswer.equals(answer)) {
          System.out.println("You're correct");

          // If the value is less than 5, then the value that the dice was is added to the current players position.
             // This is to show that the player landed on a normal spot, and not a ladder.
             // If the value is 5, then the "playerPositions" function will be called, and they'll move extra spaces.
          if (normalOrSpecial <= 4) {
            PlayerPositions.set(i, (oldValue + diceThrow));
          } else if (normalOrSpecial == 5) {
            int rightAndLadder = playerPositions(currentPositionOnBoard, "ladder");
            PlayerPositions.set(i, rightAndLadder);
          }
        } else if (!userAnswer.equals(answer) && PlayerPositions.get(i) == 0) {
          // The else if statement is only used when the player is at the very first index.
          System.out.println("You're incorrect");
        } else {
          // The else statement works the same as the if statement, with the difference being that instead of increasing the spaces, they're decreased.
          System.out.println("You're incorrect");

          // If the user is incorrect, then they'll have to move back.
             // The amount that they move back is based on how long the ladder is.
          if (normalOrSpecial <= 4) {
            PlayerPositions.set(i, (oldValue - 1));
          } else if (normalOrSpecial == 5) {
            int wrongAndChute = playerPositions(currentPositionOnBoard, "chute");

            // The reason that an if-else block is to avoid an error where the "PlayerPositions.set(i, wrongAndChute)" is less than 0 (index out of bounds error).
               // Therefore, if the position of the player is greater than 0, and the chute makes it so that the new position would be less than 0, then the if statement is executed making the new position 0 and avoiding the out of bounds error.
            if (wrongAndChute < 0) {
              PlayerPositions.set(i, 0);
            } else {
              PlayerPositions.set(i, wrongAndChute);
            }
          }
        }
      }
      //System.out.println(PlayerPositions);

      // The if statement below is used to check if a player has gotten 100 points or not.
         // If they have then they've won the game, and the loop is broken.
         // The reason that it has to be broken is because below the conditional statement is the "board" function call, and if we don't break it when the value is greater than 100, then we'll get an "index out of bounds" error.
      if (winner(PlayerPositions, currentRound1) == true) {
        break;
      }

      // The board is then printed out with the new positions, and the round is incresed by 1.
      board(currentRound1.playerPieces, PlayerPositions);

      immediateRound(currentRound1, 1);
    }
  }

  // This function is used to ask the player what piece they want to use to play the game.
  public static ArrayList<String> pieceSelection(int numberOfPlayers) {
    Scanner input = new Scanner(System.in);
    ArrayList<String> playerPieces = new ArrayList<String>();
    ArrayList<Integer> playerIndexValues = new ArrayList<Integer>();

    // The for loop below is used to ask the player / players what pieces they want to use to play the game.
    for (int i = 0; i < numberOfPlayers; i++) {
      System.out.println("Choose your piece out of: x, y, z");
      playerIndexValues.add(0);

      String chosenPieceIs = input.nextLine();
      if (chosenPieceIs.equals("x") || chosenPieceIs.equals("y") || chosenPieceIs.equals("z")) {
        playerPieces.add(chosenPieceIs);
      } else {
        System.out.println("Invalid piece chosen");
        pieceSelection(numberOfPlayers);
      }
    }

    board(playerPieces, playerIndexValues);
    return playerPieces;
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
