
import java.io.Serializable; /*Importing Serializable*/
import java.util.Date;  /*Importing Date*/

public class SchoolFootballClub extends FootBallClub implements Serializable{  /*SchoolFootballClub class inherit from FootBallClub class*/

    private String schoolName;

    public SchoolFootballClub(String name, String location, int clubNo, int scoredGoalsCount, int receivedGoalCount, int pointCount, int playedMatchesCount, int winMatchesCount, int drawMatchesCount, Date matchDate, int defeatMatchesCount, String schoolName) {
        super(name, location, clubNo, scoredGoalsCount, receivedGoalCount, pointCount, playedMatchesCount, winMatchesCount, drawMatchesCount, matchDate, defeatMatchesCount);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {             //Getters for attributes
        return schoolName;
    }


    public void setSchoolName(String schoolName) {         //Setters for attributes
        this.schoolName = schoolName;
    }
}
