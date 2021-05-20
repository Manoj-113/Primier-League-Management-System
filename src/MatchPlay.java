import java.io.Serializable; /*Importing Serializable*/
import java.time.LocalDateTime; /*Importing LocalDateTime*/

public class MatchPlay implements Serializable, Comparable<MatchPlay>{


    LocalDateTime dateOfMatch;       /*LocalDateTime instance variable date*/
    FootBallClub playClub1;    /*Instance variable for Home club name*/
    FootBallClub playClub2;    /*Instance variable for Away club name*/
    int goalsCountClub1;       /*Instance variable for Home club score goal count*/
    int goalsCountClub2;       /*Instance variable for Away club score goal count*/



    public void setDateOfMatch(LocalDateTime dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }
    public LocalDateTime getDateOfMatch(){
        return dateOfMatch;
    }

    public FootBallClub getPlayClub1() {
        return playClub1;
    }

    public void setPlayClub1(FootBallClub playClub1) {
        this.playClub1 = playClub1;
    }

    public FootBallClub getPlayClub2() {
        return playClub2;
    }

    public void setPlayClub2(FootBallClub playClub2) {
        this.playClub2 = playClub2;
    }

    public int getGoalsCountClub1() {
        return goalsCountClub1;
    }

    public void setGoalsCountClub1(int goalsCountClub1) {
        this.goalsCountClub1 = goalsCountClub1;
    }

    public int getGoalsCountClub2() {
        return goalsCountClub2;
    }

    public void setGoalsCountClub2(int goalsCountClub2) {
        this.goalsCountClub2 = goalsCountClub2;
    }


    public MatchPlay(LocalDateTime dateOfMatch, FootBallClub playClub1, FootBallClub playClub2, int goalsCountClub1, int goalsCountClub2) {
        this.dateOfMatch = dateOfMatch;
        this.playClub1 = playClub1;
        this.playClub2 = playClub2;
        this.goalsCountClub1 = goalsCountClub1;
        this.goalsCountClub2 = goalsCountClub2;
    }

    @Override
    public String toString() {    /*DateOfMatch toString*/
        return ""+dateOfMatch;
    }

    @Override
    public int compareTo(MatchPlay matchPlay) {

        if(this.dateOfMatch.getYear()==matchPlay.dateOfMatch.getYear()){
            if(this.dateOfMatch.getMonth()== dateOfMatch.getMonth()){
                if(matchPlay.dateOfMatch.getDayOfMonth()==this.dateOfMatch.getDayOfMonth()){
                    if (matchPlay.dateOfMatch.getHour()==this.dateOfMatch.getHour()){
                        if (matchPlay.dateOfMatch.getMinute() == this.dateOfMatch.getMinute()) {
                            return (matchPlay.dateOfMatch.getSecond()-this.dateOfMatch.getSecond());
                        }
                        return matchPlay.dateOfMatch.getMinute()-this.dateOfMatch.getMinute();
                    }
                    return (matchPlay.dateOfMatch.getHour()-this.dateOfMatch.getHour());
                }
                return (matchPlay.dateOfMatch.getDayOfMonth()-this.dateOfMatch.getDayOfMonth());
            }
            return (matchPlay.dateOfMatch.getMonthValue()-this.dateOfMatch.getMonthValue());
        }
        return (matchPlay.dateOfMatch.getYear()-this.dateOfMatch.getYear());
    }
}
