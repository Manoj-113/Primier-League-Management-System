
import java.io.Serializable;  /*Importing Serializable*/
import java.util.Date;  /*Importing Date*/

public class UniversityFootballClub extends FootBallClub implements Serializable{    /*UniversityFootBallClub class inherit from FootBallClub class*/

    private String universityName;

    public UniversityFootballClub(String name, String location, int clubNo, int scoredGoalsCount, int receivedGoalCount, int pointCount, int playedMatchesCount, int winMatchesCount, int drawMatchesCount, Date matchDate, int defeatMatchesCount, String universityName) {
        super(name, location, clubNo, scoredGoalsCount, receivedGoalCount, pointCount, playedMatchesCount, winMatchesCount, drawMatchesCount, matchDate, defeatMatchesCount);
        this.universityName = universityName;
    }

    public String getUniversityName() {     //Getters for attributes
        return universityName;
    }



    public void setUniversityName(String universityName) {    //Setters for attributes
        this.universityName = universityName;
    }

}
