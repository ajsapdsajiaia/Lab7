package edu.cscc;
import java.util.Random;

/**
 * @author Michael Lin
 * Computer randomly generates either rock, paper, scissors, lizard, or spock from a switch statement and sees if it
 * satisfies a win condition. Also verfies that "pick" is valid.
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /** tests to see if "pick" is equal to null, then checks to see if it is equal to one of the rpsls. If it is
     * equal to one of the rpsls returns true, otherwise returns false.
     * @param pick variable for storing RPSLS and verifying input is valid
     * @return true or false
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }
    /** first sets local variable "pick" to null, then randomly chooses a case which contains one RPSLS
     * @return pick, which is set to be one of RPSLS
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /** Documents all the Computer win cases. If it wins it will return true. If it loses it will return false
     * @param c_pick what the computer picks
     * @param h_pick what the user inputs
     * @return true if the computer wins and false if it loses
     */

    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}