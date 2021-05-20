import java.util.Comparator;  /*Importing Comparator*/

public class ComparatorSort implements Comparator<FootBallClub> {   /*Comparator sorting*/
    @Override
    public int compare(FootBallClub footballClub1, FootBallClub footballClub2) {
        if(footballClub1.getPointCount() > footballClub2.getPointCount())
            return -1;   /*returning*/
        else    /*else statement*/
            if(footballClub1.getPointCount() < footballClub2.getPointCount())
                return 1; /*returning*/
            else {   /*else statement*/
                int goalDifferent = footballClub1.getScoredGoalsCount()-footballClub1.getReceivedGoalCount();
                int goalDifferent1 = footballClub2.getScoredGoalsCount()-footballClub2.getReceivedGoalCount();
                if(goalDifferent>goalDifferent1)
                    return -1; /*returning*/
                else   /*else statement*/
                    if(goalDifferent<goalDifferent1)
                        return 1; /*returning*/
                    else  /*else statement*/
                        return 0; /*returning*/
            }
    }
}
