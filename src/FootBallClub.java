
import java.io.Serializable;  /*Importing Serializable*/
import java.util.Date;  /*Importing Date*/


public class FootBallClub extends SportsClub implements Serializable{   /*FootBallClub class inherited from SportsClu*/

    private int defeatMatchesCount;
    private int scoredGoalsCount;
    private int receivedGoalCount;
    private int pointCount;
    private int playedMatchesCount;
    private int winMatchesCount;
    private int drawMatchesCount;
    private Date matchDate;

    public FootBallClub(String name, String location, int clubNo, int scoredGoalsCount, int receivedGoalCount, int pointCount, int playedMatchesCount, int winMatchesCount, int drawMatchesCount, Date matchDate, int defeatMatchesCount) {
        super(name, location, clubNo);
        this.scoredGoalsCount = scoredGoalsCount;
        this.receivedGoalCount = receivedGoalCount;
        this.pointCount = pointCount;
        this.playedMatchesCount = playedMatchesCount;
        this.winMatchesCount = winMatchesCount;
        this.drawMatchesCount = drawMatchesCount;
        this.matchDate = matchDate;
        this.defeatMatchesCount = defeatMatchesCount;
    }

    //Getters for attributes
    public Date getMatchDate(){
            return matchDate;
    }
    public int getWinMatchesCount() {
        return winMatchesCount;
    }
    public int getDrawMatchesCount() {
        return drawMatchesCount;
    }
    public int getDefeatMatchesCount() {
        return defeatMatchesCount;
    }
    public int getScoredGoalsCount() {
        return scoredGoalsCount;
    }
    public int getReceivedGoalCount() {
        return receivedGoalCount;
    }
    public int getPointCount() {
        return pointCount;
    }
    public int getPlayedMatchesCount() {
        return playedMatchesCount;
    }


    //Setters for attributes

    public void setMatchDate(Date matchDate){
        this.matchDate = matchDate;
    }
    public void setWinMatchesCount(int winMatchesCount) {
        this.winMatchesCount = winMatchesCount;
    }
    public void setDrawMatchesCount(int drawMatchesCount) {
        this.drawMatchesCount = drawMatchesCount;
    }
    public void setDefeatMatchesCount(int defeatMatchesCount) {
        this.defeatMatchesCount = defeatMatchesCount;
    }
    public void setScoredGoalsCount(int scoredGoalsCount) {
        this.scoredGoalsCount = scoredGoalsCount;
    }
    public void setReceivedGoalCount(int receivedGoalCount) {
        this.receivedGoalCount = receivedGoalCount;
    }
    public void setPlayedMatchesCount(int playedMatchesCount) {
        this.playedMatchesCount = playedMatchesCount;
    }
    public void setPointCount(int pointType) {
        this.pointCount = (pointCount+pointType);
    }


}