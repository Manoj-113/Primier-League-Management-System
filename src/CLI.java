

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;



public class CLI {

    private static PremierLeagueManager premierLeagueManager = new PremierLeagueManager(); /*Create object from PremierLeagueManager class*/
    private static List<FootBallClub> clubList = new ArrayList<>();    /*Make an array list to store club details*/
    private static List<MatchPlay> listOfMatches = new ArrayList<>();
    private static int clubCount = 0;
    private static String clubName;


    public static void main(String[] args)  {       /*Main class*/
        premierLeagueManager.readFileClubs();
        premierLeagueManager.readFileMatches();

        while(true){                  /*While true Loop*/
            try{                      /*try and catch exception*/

            Scanner input = new Scanner(System.in);      /*Make scanner named as input*/

                /*Premier League Menu*/

            System.out.println("**************************************************");
            System.out.println("|            Premier League Menu                 |");
            System.out.println("|------------------------------------------------|");
            System.out.println("|  Enter the number as the following choices     |");
            System.out.println("|                                                |");
            System.out.println("|  1 - For Create and Add new club               |");
            System.out.println("|  2 - For Delete Existing club from league      |");
            System.out.println("|  3 - For Display Statistics for club           |");
            System.out.println("|  4 - For Display premier league table          |");
            System.out.println("|  5 - For Add played match to club              |");
            System.out.println("|  6 - Save Information                          |");
            System.out.println("|  7 - Open Graphical User Interface             |");
            System.out.println("|  8 - Open Help View                            |");
            System.out.println("|  0 - Exit the Program                          |");
            System.out.println("|                                                |");
            System.out.println("**************************************************");
            System.out.println("    ");
            System.out.print("ENTER : ");

            int choice = input.nextInt();      /*Scanner define as a integer type variable*/

            switch (choice){
                case 1:                                        /*when user enter number 1*/
                    addClub();                                 /*call addClub method*/
                    break;                                     /*Break the session after the end of addClub method*/
                case 2:                                        /*when user enter number 2*/
                    deleteClub();                              /*call deleteClub method*/
                    break;                                     /*Break the session after the end of deleteClub method*/
                case 3:                                        /*when user enter number 3*/
                    displayStatistics(clubName);  /*call the PremierLeagueManager class displayStatistics method*/
                    break;                                     /*Break the session after the end of displayStatistics method*/
                case 4:                                        /*when user enter number 4*/
                    premierLeagueManager.displayLeagueTable(); /*call the PremierLeagueManager class displayLeagueTable method*/
                    break;                                     /*Break the session after the end of displayLeagueTable method*/
                case 5:                                        /*when user enter number 5*/
                    addStatistics();                           /*call addStatistics method*/
                    break;                                     /*Break the session after the end of addStatistics method*/
                case 6 :                                       /*when user enter number 6*/
                    premierLeagueManager.saveToFileClubs();/*call the PremierLeagueManager class saveToFile method*/
                    premierLeagueManager.saveToFileMatches();
                    break;                                     /*Break the session after the end of saveToFile method*/
                case 7 :                                       /*when user enter number 7*/
                    javafx.application.Application.launch(Gui.class);  /*Run GUI application code in Gui.class*/
                    break;                                     /*Break and again display Premier League Menu*/

                case 8:                                        /*when user enter number 8*/
                    helpLeague();                              /*Display Premier league manager guidelines*/
                    break;                                     /*Break the session*/
                case 0:                                        /*when user enter number 0*/
                    System.exit(1);                      /*Exit the program*/
                    break;                                     /*case break*/


                default:                                       /*when user input invalid inputs display below error massages*/
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("\t\tInvalid input !");
                    System.out.println("*****************************************");
                    System.out.println("");
            }
            }catch (InputMismatchException | IOException exception){          /*catch exception*/
                System.out.println("  ");
                System.out.println("*****************************************");
                System.out.println("\tUse only integers as shown !");
                System.out.println("*****************************************");
                System.out.println("  ");
            }
        }
    }

    private static void displayStatistics(String clubName) {    /*Ask the club name user want*/
        Scanner scanForStatistics = new Scanner(System.in);
        System.out.print("Enter Club Name : ");
        clubName = scanForStatistics.next();        /*Take user input to the variable*/
        boolean looking = premierLeagueManager.displayStatistics(clubName);

    }


    private static void helpLeague() {       /*helpLeague method for user guiding*/
        Scanner selection = new Scanner(System.in);

        System.out.println("Select The Guid Section Below");

        System.out.println("      1 - CLI Guidelines");
        System.out.println("      2 - GUI Guidelines");

        System.out.print("\nENTER SELECTION : ");

        int guideSelection = selection.nextInt();
        switch (guideSelection){
            case 1:          /*Case 1 for CLI guidelines*/

                System.out.println("CLI");

                break;       /*Break the session*/
            case 2:          /*Case 2 for GUI guidelines*/

                System.out.println("GUI");

                break;      /*Break the session*/
        }

    }


    private static void addStatistics() {     /*addStatistics method for add play match for user*/

        LocalDateTime dateTime = dateInput();   /*date user input*/
        Scanner input = new Scanner(System.in);   /*Define Scanner*/
        String playClub1;     /*Football Home club name variable */
        String playClub2;      /*Football Away club name variable*/
        int playClub1Goal;      /*Home football club score*/
        int playClub2Goal;      /*Away football club score*/

        try{            /*Try exception*/
            System.out.print("Enter Home Club Name : ");
            playClub1 = input.next();          /*User inputs take to the variable*/
            System.out.print("Enter Home Club Goal Count : ");
            playClub1Goal = input.nextInt();  /*User inputs take to the variable*/

            System.out.print("Enter Away Club Name : ");
            playClub2 = input.next();   /*User inputs take to the variable*/
            System.out.print("Enter Away Club Goal Count : ");
            playClub2Goal = input.nextInt();  /*User inputs take to the variable*/

            premierLeagueManager.addMatchStatistics(playClub1,playClub1Goal,playClub2,playClub2Goal,dateTime);  /*Variable values send to the addMatchStatistics method*/

        }catch (InputMismatchException inputMismatchExceptionOne){
            System.out.println("   ");
            System.out.println("*****************************************");
            System.out.println("\t\tError Input !");
            System.out.println("*****************************************");
            System.out.println("   ");
        }

    }

    private static LocalDateTime dateInput() {

        Scanner date = new Scanner(System.in);
        System.out.println("Input Match Date : FORMAT -->  MM/DD/YYYY");
        System.out.print("Date : ");
        String inputDate = date.next();

        return LocalDateTime.now();
    }


    private static void deleteClub() {
        Scanner deleteInput = new Scanner(System.in);
        try{           /*Try exception*/
            System.out.print("Enter The Club Number : ");
            Integer clubNo = deleteInput.nextInt();       /*Take user input to the variable*/
            boolean deleting = premierLeagueManager.deleteClub(clubNo); /**/
        }catch (InputMismatchException inputMismatchExceptionTwo){
            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("\t\tInvalid Entering !");
            System.out.println("*****************************************");
            System.out.println("");
        }
    }

    private static void addClub() {
        Scanner input = new Scanner(System.in);
        try  {           /*Try exception*/
            if (clubCount != 20) {
                try {           /*Try exception*/
                    System.out.print("Enter Club Number : ");
                    int clubNo = input.nextInt();      /*Take Inputs to the variable*/


                    System.out.print("Enter Club Location : ");
                    String clubLocation = input.next();   /*Take Inputs to the variable*/

                    System.out.print("Enter Club Name : ");
                    String clubName = input.next();      /*Take Inputs to the variable*/


                    System.out.println("Select the type of the club.");
                    System.out.println("      1 - For University Football Club.");
                    System.out.println("      2 - For School Football Club.");
                    System.out.println("");
                    System.out.print("SELECTION : ");
                    String selection = input.next();   /*Take Inputs to the variable*/

                    FootBallClub newClub = null;

                    switch (selection) {
                        case "1":
                            System.out.print("Enter University Name : ");
                            String universityName = input.next();    /*Take Inputs to the variable*/
                            newClub = new UniversityFootballClub(clubName, clubLocation, clubNo, 0, 0, 0, 0, 0, 0, null,0, universityName);

                            break;         /*Break the session*/

                        case "2":
                            System.out.print("Enter School Name : ");
                            String schoolName = input.next();      /*Take Inputs to the variable*/
                            newClub = new SchoolFootballClub(clubName, clubLocation, clubNo, 0, 0, 0, 0, 0, 0, null,0, schoolName);

                            break;        /*Break the session*/

                        default:
                            System.out.println("");
                            System.out.println("*****************************************");
                            System.out.println("\tInvalid Selection !");
                            System.out.println("*****************************************");
                            System.out.println("");
                    }
                    premierLeagueManager.addClub(newClub);

                } catch (InputMismatchException inputMismatchExceptionThree) {
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("\t\tInvalid Input !");
                    System.out.println("*****************************************");
                    System.out.println("");
                }
            } else {   /*else statement*/
                System.out.println("");
                System.out.println("*****************************************");
                System.out.println("\tLeague List is already full !");
                System.out.println("*****************************************");
                System.out.println("");
            }
        } catch (Exception exceptionOne) {
            exceptionOne.printStackTrace();
        }
    }

}
