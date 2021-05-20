import java.io.IOException;  /*Importing IOException*/
import java.time.LocalDateTime;  /*Importing LocalDateTime*/


public interface LeagueManager{    /*LeagueManager interface Class*/


    void addClub(SportsClub club) throws IOException, ClassNotFoundException;      /*Adding Football Club*/
    boolean addMatchStatistics(String playClub1, int playClub1Goal, String playClub2, int playClub2Goal, LocalDateTime dateTime); /*Adding Matching Statistics*/
    boolean deleteClub(int clubNo);     /*Deleting clubs*/
    boolean displayStatistics(String clubName);   /*Display Statistics to the user*/
    void displayLeagueTable();        /*Display clubs with table*/
    void saveToFileClubs() throws IOException;  /*Clublist save to the file*/
    void readFileClubs();    /*Load which club list saved file*/
    void saveToFileMatches() throws IOException;  /*Match list save to the file*/
    void readFileMatches();  /*Load which match list saved file*/



}
