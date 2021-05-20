import java.io.*;
import java.time.LocalDateTime;    /*Importing LocalDateTime*/
import java.util.*;  /*Importing all utils*/
import java.util.List;  /*Importing List*/

public class PremierLeagueManager implements LeagueManager {  /*PremierLeagueManager class implements by leagueManager interface class*/



    public static List<FootBallClub> clubList = new ArrayList<>();  /*Make arraylist for list of club*/

    public static List<MatchPlay>listOfMatches = new ArrayList<>();  /*Make arraylins for lis of matches*/



    private List<FootBallClub> fClubList = new ArrayList<FootBallClub>();    /*New Arraylist*/
    private static int winningPoints = 3;  /*Points for one winning match*/
    private static int drawingPoints = 1;  /*Points for one draw match*/

    public static List<FootBallClub> getClubList() {
        return clubList;
    }
    public List<MatchPlay> getListOfMatches(){
        return listOfMatches;
    }


    @Override
    public void addClub(SportsClub newClub) throws IOException, ClassNotFoundException {
        System.out.println("Already "+(clubList.size()+1)+" clubs are registered.");
        System.out.println("We can register more "+(20-(clubList.size()+1))+" clubs.");

        if(clubList.size()<=20){
            clubList.add((FootBallClub) newClub);


        }else{       /*else statement*/
            System.out.println("League manager is full !");
        }
    }







    @Override
    public boolean addMatchStatistics(String playClub1, int playClub1Goal, String playClub2, int playClub2Goal, LocalDateTime dateTime) {

        if(clubList.size()==0){
            System.out.println("No any registered club yet. Please register and try again !");
        }

        if (playClub1.equals(playClub2)){
            System.out.println("Invalid Enter. Please enter different club names!");
        }
        String club1Match;
        String club2Match;

        FootBallClub club1 = null;
        FootBallClub club2 = null;

        for (FootBallClub club : clubList){
            if(club.getName().equals(playClub1)){
                club1 = club;
                break;  /*break the session*/
            }
        }

        for (FootBallClub club : clubList){
            if(club.getName().equals(playClub2)){
                club2 = club; /**/
                break;  /*break the session*/
            }
        }

        if((club1==null)&&(club2==null)){
            System.out.println("Club names are not founded!");
        }else if((club1==null)||(club2==null)){
            System.out.println("Invalid Club name input !");
        }else {     /*else statement*/
            if(playClub1Goal > playClub2Goal){
                club1.setWinMatchesCount(club1.getWinMatchesCount()+1);
                club2.setDefeatMatchesCount(club2.getDefeatMatchesCount()+1);
                club1.setPointCount(winningPoints);


                club1Match = " CLUB WON THE MATCH !";
                club2Match = " CLUB WAS DEFEATED !";

            }else if(playClub1Goal==playClub2Goal){
                club1.setDrawMatchesCount(club1.getDrawMatchesCount()+1);
                club2.setDrawMatchesCount(club1.getDrawMatchesCount()+1);
                club1.setPointCount(drawingPoints);
                club2.setPointCount(drawingPoints);

                club1Match = " MATCH DRAW";
                club2Match = " MATCH DRAW";
            }else{   /*else statement*/
                club1.setDefeatMatchesCount(club1.getDefeatMatchesCount()+1);
                club2.setWinMatchesCount(club2.getWinMatchesCount()+1);
                club2.setPointCount(winningPoints);


                club1Match = " CLUB WAS DEFEATED !";
                club2Match = " CLUB WON THE MATCH !";
            }

            club1.setPlayedMatchesCount(club1.getPlayedMatchesCount()+1);
            club2.setPlayedMatchesCount(club2.getPlayedMatchesCount()+1);
            club1.setScoredGoalsCount(club1.getScoredGoalsCount()+playClub1Goal);
            club2.setScoredGoalsCount(club2.getScoredGoalsCount()+playClub2Goal);
            club1.setReceivedGoalCount(club1.getReceivedGoalCount()+playClub2Goal);
            club2.setReceivedGoalCount(club2.getReceivedGoalCount()+playClub1Goal);




            MatchPlay matchPlay = new MatchPlay(dateTime,club1,club2,playClub1Goal,playClub2Goal);
            listOfMatches.add(matchPlay);

            System.out.println("");
            System.out.println("------------------------------------------------------");
            System.out.println("---------------------SCORE RESULTS--------------------");
            System.out.println("------------------------------------------------------");
            System.out.println("       GOALS OF "+playClub1+" : "+playClub1Goal);
            System.out.println("       GOALS OF "+playClub2+" : "+playClub2Goal);
            System.out.println("");
            System.out.println("        "+playClub1+" --> "+ club1Match+"");
            System.out.println("        "+playClub2+" --> "+ club2Match+"");
            System.out.println("------------------------------------------------------");
            System.out.println("\n\n\n\n");

        }

        return true;  /*return values*/
    }

    @Override
    public boolean deleteClub(int clubNo) {
        boolean leagueFlag = false;
        for(SportsClub club : clubList){
            if(Objects.equals(club.getClubNo(), clubNo)){
                leagueFlag = true;
                clubList.remove(club);
                System.out.println(clubNo+" numbered "+(club.getName())+" Club was successfully removed..");
                break;   /*Break the session*/
            }
        }
        if(!leagueFlag){
            System.out.println("");
            System.out.println("**********************************************************************");
            System.out.println("   can't find that numbered club. please recheck your club number..");
            System.out.println("**********************************************************************");
            System.out.println("");
        }
        return leagueFlag;
    }

    @Override
    public boolean displayStatistics(String clubName)  {

        boolean myFlag = false;
        if(clubList.size()!=0) {

            for (SportsClub newClub : clubList) {

                if(newClub.getName().equals(clubName)){
                    if (newClub instanceof UniversityFootballClub) {
                        System.out.println("              UNIVERSITY FOOTBALL CLUB");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("     NAME OF THE UNIVERSITY : "+((UniversityFootballClub)newClub).getUniversityName());
                        System.out.println("     CLUB NAME              : "+newClub.getName());
                        System.out.println("*************************************************");
                        System.out.println("|        " + newClub.getName() + " CLUB STATISTICS....     ");
                        System.out.println("-------------------------------------------------");

                        System.out.println("|   Number of Matches Won : " + ((UniversityFootballClub) newClub).getWinMatchesCount());
                        System.out.println("|   Number of Defeated Matches : " + ((UniversityFootballClub) newClub).getDefeatMatchesCount());
                        System.out.println("|   Total Earned Points : " + ((UniversityFootballClub) newClub).getPointCount());
                        System.out.println("|   Total Played Matches : " + ((UniversityFootballClub) newClub).getPlayedMatchesCount());
                        System.out.println("|   Total Goals : " + ((UniversityFootballClub) newClub).getScoredGoalsCount());
                        System.out.println("|   Number Of Draw Matches : " + ((UniversityFootballClub) newClub).getDrawMatchesCount());
                        System.out.println("|   Number Of Received Goals : " + ((UniversityFootballClub) newClub).getReceivedGoalCount());
                        System.out.println("*************************************************\n\n\n");
                    }


                    if (newClub instanceof SchoolFootballClub){
                        System.out.println("              SCHOOL FOOTBALL CLUB");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("     NAME OF THE SCHOOL : "+((SchoolFootballClub)newClub).getSchoolName());
                        System.out.println("     CLUB NAME          : "+newClub.getName());
                        System.out.println("*************************************************");
                        System.out.println("|        " + newClub.getName() + " CLUB STATISTICS....     ");
                        System.out.println("-------------------------------------------------");

                        System.out.println("|   Number of Matches Won : " + ((SchoolFootballClub) newClub).getWinMatchesCount());
                        System.out.println("|   Number of Defeated Matches : " + ((SchoolFootballClub) newClub).getDefeatMatchesCount());
                        System.out.println("|   Total Earned Points : " + ((SchoolFootballClub) newClub).getPointCount());
                        System.out.println("|   Total Played Matches : " + ((SchoolFootballClub) newClub).getPlayedMatchesCount());
                        System.out.println("|   Total Goals : " + ((SchoolFootballClub) newClub).getScoredGoalsCount());
                        System.out.println("|   Number Of Draw Matches : " + ((SchoolFootballClub) newClub).getDrawMatchesCount());
                        System.out.println("|   Number Of Received Goals : " + ((SchoolFootballClub) newClub).getReceivedGoalCount());
                        System.out.println("*************************************************\n\n\n");
                    }


                }else {    /*else statement*/
                    System.out.println("");
                    System.out.println("*****************************************************");
                    System.out.println("        No Any Equivalent Club As Your Input");
                    System.out.println("*****************************************************");
                    System.out.println("");
                }

            }

        }else {   /*else statement*/
            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("\t No any registered club !");
            System.out.println("*****************************************");
            System.out.println("");
        }
        return myFlag;   /*return value*/
    }



    @Override
    public void displayLeagueTable() {

        Collections.sort(clubList, new ComparatorSort());

        if(clubList.size()==0){
            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("         No any club in league");
            System.out.println("*****************************************");
            System.out.println("");
        }else{   /*else statement*/

            int nameLetters = 0;

            for (FootBallClub club : clubList){
                if (club.getName().length()>nameLetters){
                    nameLetters = club.getName().length();
                }
            }
            if (!(nameLetters>18)){
                nameLetters = 18;
            }
            int addSpace = nameLetters - 18;
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("|                       .............PREMIER LEAGUE TABLE.............                               |");
            System.out.println("------------------------------------------------------------------------------------------------------");

            String columns = "| %2d. %-"+nameLetters+"s| %3d    | %5d    |%4d   |%8d     |%8d        |%10d       |%n";

            System.out.format("|----------------------------------------------------------------------------------------------------|%n");
            System.out.format("|  Club Name            | Points | Winnings | Draws | Score Goals | Received Goals | Goal Difference |%n");
            System.out.format("|----------------------------------------------------------------------------------------------------|%n");


            for(FootBallClub club : clubList){    /*consider about all club using for loop*/

                System.out.format(columns,
                        clubList.indexOf(club)+1,
                        club.getName(),
                        club.getPointCount(),
                        club.getWinMatchesCount(),
                        club.getDrawMatchesCount(),
                        club.getScoredGoalsCount(),
                        club.getReceivedGoalCount(),
                        club.getScoredGoalsCount()-club.getReceivedGoalCount()
                        );
            }
            System.out.format("|----------------------------------------------------------------------------------------------------|\n\n\n");

        }

    }





    @Override
    public void readFileClubs() {
        try{          /*Try exception*/
            FileInputStream fileInputStream = new FileInputStream("ClubListFile");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            clubList = (List<FootBallClub>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }catch (FileNotFoundException fileNotFoundExceptionOne){
            System.out.println("Not Found !");
        }catch (IOException ioExceptionOne){
            System.out.println("Error!");
        }catch (ClassNotFoundException classNotFoundExceptionOne){
            classNotFoundExceptionOne.printStackTrace();
        }
    }



    @Override
    public void readFileMatches() {

        try{          /*Try exception*/
            FileInputStream fileInputStream = new FileInputStream("MatchListFile");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listOfMatches = (List<MatchPlay>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }catch (FileNotFoundException fileNotFoundExceptionTwo){
            System.out.println("Not Found !");
        }catch (IOException ioExceptionTwo){
            System.out.println("Error!");
        }catch (ClassNotFoundException classNotFoundExceptionTwo){
            classNotFoundExceptionTwo.printStackTrace();
        }

    }

    @Override
    public void saveToFileMatches() throws IOException {

        try{           /*Try exception*/
            FileOutputStream fileOutputStream = new FileOutputStream(new File("MatchListFile"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfMatches);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("\t...SUCCESSFULLY SAVED...");
            System.out.println("*****************************************");
            System.out.println("");

        }catch (FileNotFoundException fileNotFoundEx){
            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("\t\t\tFile Not found !");
            System.out.println("*****************************************");
            System.out.println("");
        }catch (IOException ex){
            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("\t\t\tError!");
            System.out.println("*****************************************");
            System.out.println("");
        }

    }

    @Override
    public void saveToFileClubs(){

        try{           /*Try exception*/
            FileOutputStream fileOutputStream = new FileOutputStream(new File("ClubListFile"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clubList);
            objectOutputStream.close();
            fileOutputStream.close();



        }catch (FileNotFoundException fileNotFoundEx){
            System.out.println("");
        }catch (IOException ex){
            System.out.println("");
        }
    }

    /*Sorting comparators*/
    public Comparator<FootBallClub>sortingPoints(){
        return new Comparator<FootBallClub>() {        /*New comparator for sort by earned points*/
            @Override
            public int compare(FootBallClub footBallClubOne, FootBallClub footBallClubTwo) {
                return footBallClubTwo.getPointCount()-footBallClubOne.getPointCount();
            }
        };
    }
    public Comparator<FootBallClub>sortingWins(){
        return new Comparator<FootBallClub>() {       /*New comparator for sort by won matches*/
            @Override
            public int compare(FootBallClub footBallClubOne, FootBallClub footBallClubTwo) {
                return footBallClubTwo.getWinMatchesCount()-footBallClubOne.getWinMatchesCount();
            }
        };
    }
    public Comparator<FootBallClub>sortingScoredGoals(){
        return new Comparator<FootBallClub>() {      /*New comparator for sort by won matches*/
            @Override
            public int compare(FootBallClub footBallClubOne, FootBallClub footBallClubTwo) {
                return footBallClubTwo.getScoredGoalsCount()-footBallClubOne.getScoredGoalsCount();
            }
        };
    }

    public MatchPlay generateRandomMatch(){

        Random randomValue = new Random();    /*Create random*/

        int playClub1Goals = randomValue.nextInt(6);  /*Make random scores to club 1*/
        int playClub2Goals = randomValue.nextInt(6);  /*Make random scores to club 2*/
        int playClub1;    /*Make variable for take random values*/
        int playClub2;    /*Make variable for take random values*/

        do {        /*Do While loop*/
            playClub1 = randomValue.nextInt(clubList.size());
            playClub2 = randomValue.nextInt(clubList.size());
        }while (playClub1 == playClub2); /*This loop run while get same club random values*/

        FootBallClub playingClub1 = clubList.get(playClub1); /**/
        FootBallClub playingClub2 = clubList.get(playClub2); /**/

        addMatchStatistics(playingClub1.getName(),playClub1Goals,playingClub2.getName(),playClub2Goals,LocalDateTime.now());
        return new MatchPlay(LocalDateTime.now(),playingClub1,playingClub2,playClub1Goals,playClub2Goals);  /*Returning values*/

    }


}