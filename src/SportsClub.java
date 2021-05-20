


import java.io.Serializable;   /*Importing serializable*/
import java.util.Objects;   /*Importing Objects*/

public class SportsClub implements Serializable{
    private String name;    /*club name variable*/

    @Override
    public boolean equals(Object objectOne) {   /*equals method*/
        if (this == objectOne) return true;
        if (!(objectOne instanceof SportsClub)) return false;
        SportsClub club = (SportsClub) objectOne;
        return Objects.equals(name, club.name);  /*Returning values*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);  /*Returning values*/
    }

    @Override
    public String toString() {
        return "" + name ;   /*Returning values*/
    }

    private String location;
    private int clubNo;
    private boolean done = false;


    public SportsClub(String name, String location, int clubNo) {
        this.name = name;
        this.location = location;
        this.clubNo = clubNo;
    }


    public String getName(){  /*Get club name*/
        return name;  /*Returning values*/
    }             //Getters for attributes
    public String getLocation(){   /*Get Club location*/
        return location;  /*Returning values*/
    }
    public int getClubNo() {    /*Get club number*/
        return clubNo;  /*Returning values*/
    }

    public void setName(String name){   /*Set club name*/
        this.name = name; /**/
    }                   //setters for attributes
    public void setLocation(String location){
        this.location = location; /**/
    }
    public void setClubNo(int clubNo) { /*Set club number*/
        this.clubNo = clubNo;/**/
    }


    public boolean isDone() {
        return done;   /*Returning values*/
    }
}
