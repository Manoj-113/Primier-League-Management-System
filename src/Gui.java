import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Gui extends Application{


    static Stage myWindow;
    static Scene sceneTable, sceneStart, sceneMatchesTable;
    static Label labelGenerateRandomMatch, labelSaveRandomMatch;

    public static TableView<FootBallClub> tableClubs;    /*Table view for clubs from FootBallClub class*/
    public static TableView<MatchPlay> tableMatches;    /*Table view for clubs from MatchPlay class*/
    public static PremierLeagueManager premierLeagueManagerGUI = new PremierLeagueManager();  /*PremierLeagueManager object*/

    private double blurring = 1;


    @Override
    public void start(Stage primaryStage) throws Exception {   /*Application start with throws exception*/

        myWindow = primaryStage;
        myWindow.setTitle("Premier League");
        Image windowIcon = new Image("pics/myWindowIcon.png");
        myWindow.getIcons().add(windowIcon);

        tableClubs = new TableView<>();    /*table for the show clubs and statistics*/

        TableColumn<FootBallClub, Integer> column1=new TableColumn<>("Club No");   /*Table column for club number*/
        column1.setMinWidth(50);  /*Setup column width*/
        column1.setCellValueFactory(new PropertyValueFactory<>("clubNo"));

        TableColumn<FootBallClub,String> column2= new TableColumn<>("Name");   /*Table column for Club name*/
        column2.setMinWidth(200);  /*Setup column width*/
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<FootBallClub,String> column3= new TableColumn<>("Location");  /*Table column for Club Location*/
        column3.setMinWidth(200);   /*Setup column width*/
        column3.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<FootBallClub,Integer> column4=new TableColumn<>("Scored Goals");   /*Table column for Socored goals*/
        column4.setMinWidth(150);  /*Setup column width*/
        column4.setCellValueFactory(new PropertyValueFactory<>("scoredGoalsCount"));

        TableColumn<FootBallClub,Integer> column5=new TableColumn<>("Received Goals");   /*Table column for Received goal count*/
        column5.setMinWidth(150);  /*Setup column width*/
        column5.setCellValueFactory(new PropertyValueFactory<>("receivedGoalCount"));

        TableColumn<FootBallClub,Integer> column6=new TableColumn<>("Points");   /*Table column for Earned point count*/
        column6.setMinWidth(50);  /*Setup column width*/
        column6.setCellValueFactory(new PropertyValueFactory<>("pointCount"));

        TableColumn<FootBallClub,Integer> column7=new TableColumn<>("Played Matches");   /*Table column for Played matches count*/
        column7.setMinWidth(150);   /*Setup column width*/
        column7.setCellValueFactory(new PropertyValueFactory<>("playedMatchesCount"));

        TableColumn<FootBallClub,Integer> column8=new TableColumn<>("Wins");   /*Table column for won matches count*/
        column8.setMinWidth(60);  /*Setup column width*/
        column8.setCellValueFactory(new PropertyValueFactory<>("winMatchesCount"));

        TableColumn<FootBallClub,Integer> column9=new TableColumn<>("Draw Matches");  /*Table column for Draw matches count*/
        column9.setMinWidth(150);   /*Setup column width*/
        column9.setCellValueFactory(new PropertyValueFactory<>("drawMatchesCount"));

        TableColumn<FootBallClub,Integer> column10=new TableColumn<>("Defeated");  /*Table column for Defeated matches count*/
        column10.setMinWidth(50);  /*Setup column width*/
        column10.setCellValueFactory(new PropertyValueFactory<>("defeatMatchesCount"));

        TableColumn<FootBallClub, Date> column11=new TableColumn<>("Date");  /*Table column for date of match*/
        column11.setMinWidth(75);
        column11.setCellValueFactory(new PropertyValueFactory<>("matchDate"));

        tableClubs.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10,column11);

        ArrayList<FootBallClub> footBallClubArrayList= (ArrayList<FootBallClub>)premierLeagueManagerGUI.getClubList();  /*Call for the club list array*/
        System.out.println(footBallClubArrayList);     /*Print arraylist*/

        for (FootBallClub footBallClub: footBallClubArrayList){  /*for loop for consider about all of club list includes items*/
            tableClubs.getItems().add(footBallClub);
        }


        /*Buttons*/

        /*Start Window Buttons*/

        Pane paneStart = new Pane();  /*Pane for the start window*/

        Button buttonTableView = new Button("Go To Table");
        buttonTableView.setId("ButtonGoToTable");
        buttonTableView.setCursor(Cursor.HAND);
        buttonTableView.setLayoutX(80);
        buttonTableView.setLayoutY(700);
        buttonTableView.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;;-fx-font-family: cambria;-fx-font-weight: bold;-fx-font-size: 150%" );
        buttonTableView.setOnAction(event -> {

                    myWindow.setScene(sceneTable);
                }
                );

        Button buttonBackToStart1 = new Button("Back To Start");
        buttonBackToStart1.setId("ButtonBackToStart");
        buttonBackToStart1.setStyle("-fx-background-color: red;"+"  -fx-text-fill: white;-fx-border-color: black;-fx-border-width: 2 2 2 2;");
        buttonBackToStart1.setCursor(Cursor.HAND);
        buttonBackToStart1.setLayoutX(500);
        buttonBackToStart1.setLayoutY(600);
        buttonBackToStart1.setOnAction(event -> myWindow.setScene(sceneStart));

        Button buttonBackToStart2 = new Button("Back To Start");
        buttonBackToStart2.setId("ButtonBackToStart");
        buttonBackToStart2.setStyle("-fx-background-color: red;"+"  -fx-text-fill: white;-fx-border-color: black;-fx-border-width: 2 2 2 2;");
        buttonBackToStart2.setCursor(Cursor.HAND);
        buttonBackToStart2.setLayoutX(500);
        buttonBackToStart2.setLayoutY(600);
        buttonBackToStart2.setOnAction(event -> myWindow.setScene(sceneStart));



        tableMatches = new TableView<>();    /*Table for the show matches*/

        TableColumn<MatchPlay,String>columnClub1Name = new TableColumn<>("Home Club Name");
        columnClub1Name.setMinWidth(200);
        columnClub1Name.setCellValueFactory(new PropertyValueFactory<>("playClub1"));

        TableColumn<MatchPlay,String>columnClub2Name = new TableColumn<>("Away Club Name");
        columnClub2Name.setMinWidth(200);
        columnClub2Name.setCellValueFactory(new PropertyValueFactory<>("playClub2"));

        TableColumn<MatchPlay,Integer>columnClub1SoredGoals = new TableColumn<>("Home Score");
        columnClub1SoredGoals.setMinWidth(200);
        columnClub1SoredGoals.setCellValueFactory(new PropertyValueFactory<>("goalsCountClub1"));

        TableColumn<MatchPlay,Integer>columnClub2SoredGoals = new TableColumn<>("Away Score");
        columnClub2SoredGoals.setMinWidth(200);
        columnClub2SoredGoals.setCellValueFactory(new PropertyValueFactory<>("goalsCountClub2"));

        TableColumn<MatchPlay, LocalDateTime>columnMatchesDate = new TableColumn<>("Date");
        columnMatchesDate.setMinWidth(200);
        columnMatchesDate.setCellValueFactory(new PropertyValueFactory<>("dateOfMatch"));


        tableMatches.getColumns().addAll(columnClub1Name,columnClub1SoredGoals,columnClub2Name,columnClub2SoredGoals,columnMatchesDate);

        ArrayList <MatchPlay> matchPlayedList = (ArrayList<MatchPlay>)premierLeagueManagerGUI.getListOfMatches();  /*Call for the played matches array*/
        System.out.println(matchPlayedList);   /*Print the matches arraylist*/

        for (MatchPlay matches : matchPlayedList){ /*for loop*/
            tableMatches.getItems().add(matches); /*add items to matches of table*/
        }


        Pane paneMatchesTable = new Pane();
        paneMatchesTable.getChildren().addAll(tableMatches, buttonBackToStart2);

        Pane paneMatches = new Pane();
        paneMatches.getChildren().addAll(paneMatchesTable);

        sceneMatchesTable = new Scene(paneMatches,1300,820);



        Button buttonDisplayPlayedMatches = new Button("Played Matches");
        buttonDisplayPlayedMatches.setCursor(Cursor.HAND);
        buttonDisplayPlayedMatches.setLayoutX(880);
        buttonDisplayPlayedMatches.setLayoutY(700);
        buttonDisplayPlayedMatches.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;-fx-font-family: cambria;-fx-font-weight: bold;-fx-font-size: 150%" );
        buttonDisplayPlayedMatches.setOnAction(event -> myWindow.setScene(sceneMatchesTable));



        labelGenerateRandomMatch = new Label("              MATCH HAS BEEN GENERATED SUCCESSFULLY.......");
        labelGenerateRandomMatch.setLayoutY(60);
        labelGenerateRandomMatch.setLayoutX(40);
        labelGenerateRandomMatch.setPrefSize(1160,40);
        labelGenerateRandomMatch.setStyle("-fx-text-fill: #0099ff;-fx-font-weight: bold; -fx-font-size: 150%; -fx-font-family: cambria; -fx-background-color: #7fffd4; -fx-text-fill: #a9a9a9");
        labelGenerateRandomMatch.setVisible(false);


        Button buttonGenerateGame = new Button("Generate Game");
        buttonGenerateGame.setId("ButtonGenerateGame");
        buttonGenerateGame.setCursor(Cursor.HAND);
        buttonGenerateGame.setLayoutY(700);
        buttonGenerateGame.setLayoutX(460);
        buttonGenerateGame.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;-fx-font-family: cambria;-fx-font-weight: bold;-fx-font-size: 150%" );
        buttonGenerateGame.setOnAction(event ->{ premierLeagueManagerGUI.generateRandomMatch();
        labelGenerateRandomMatch.setVisible(true);

            blurring =5;
            AnimationTimer labelGenerateShowing = new showTimer1();
            labelGenerateShowing.start();
        });


        labelSaveRandomMatch = new Label("              UPDATES SAVED SUCCESSFULLY.......");
        labelSaveRandomMatch.setLayoutY(60);
        labelSaveRandomMatch.setLayoutX(40);
        labelSaveRandomMatch.setPrefSize(1160,40);
        labelSaveRandomMatch.setStyle("-fx-text-fill: #0099ff;-fx-font-weight: bold; -fx-font-size: 150%; -fx-font-family: cambria; -fx-background-color: #7fffd4; -fx-text-fill: #a9a9a9");
        labelSaveRandomMatch.setVisible(false);

        Button buttonSaveGeneratedMatches = new Button("Save");
        buttonSaveGeneratedMatches.setCursor(Cursor.HAND);
        buttonSaveGeneratedMatches.setLayoutY(760);
        buttonSaveGeneratedMatches.setLayoutX(510);
        buttonSaveGeneratedMatches.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;-fx-font-family: cambria;-fx-font-weight: bold;-fx-font-size: 150%");
        buttonSaveGeneratedMatches.setOnAction(event ->{ premierLeagueManagerGUI.saveToFileClubs();
            try {
                premierLeagueManagerGUI.saveToFileMatches();
            } catch (IOException e) {
                System.out.println("");
            }
            labelSaveRandomMatch.setVisible(true);

            blurring =5;
            AnimationTimer labelSaveShowing = new showTimer2();  /*Animation timer for the label*/
            labelSaveShowing.start();
        });


        ImageView imageViewStartPage = new ImageView("pics/startWindowPic.jpg");
        imageViewStartPage.setLayoutX(0);
        imageViewStartPage.setLayoutY(0);
        imageViewStartPage.setFitHeight(820);
        imageViewStartPage.setFitWidth(1300);


        paneStart.getChildren().addAll(imageViewStartPage,buttonDisplayPlayedMatches,buttonTableView,buttonGenerateGame,buttonSaveGeneratedMatches,labelGenerateRandomMatch,labelSaveRandomMatch);


        Pane pane1 = new Pane();   /*Pane1 creation*/

        sceneStart = new Scene(pane1,1300,820);

        pane1.getChildren().addAll(paneStart);  /*add paneStart to the pane1 as children*/

        /*Start Window Buttons End*/

        /*Table Window Buttons*/
        Pane paneClubsTable = new Pane();   /*Pane creation*/


        Button buttonSortingPoints = new Button("Sort By Points");
        buttonSortingPoints.setId("ButtonSortByPoints");
        buttonSortingPoints.setCursor(Cursor.HAND);
        buttonSortingPoints.setLayoutX(650);
        buttonSortingPoints.setLayoutY(600);
        buttonSortingPoints.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;");
        buttonSortingPoints.setOnAction(event -> sortingMethod(3));

        Button buttonSortingWins = new Button("Sort By Wins");
        buttonSortingWins.setId("ButtonSortByWins");
        buttonSortingWins.setCursor(Cursor.HAND);
        buttonSortingWins.setLayoutX(800);
        buttonSortingWins.setLayoutY(600);
        buttonSortingWins.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;");
        buttonSortingWins.setOnAction(event -> sortingMethod(1));

        Button buttonSortingScoredGoals = new Button("Sort By Goals");
        buttonSortingScoredGoals.setId("ButtonSortByGoals");
        buttonSortingScoredGoals.setCursor(Cursor.HAND);
        buttonSortingScoredGoals.setLayoutX(950);
        buttonSortingScoredGoals.setLayoutY(600);
        buttonSortingScoredGoals.setStyle("-fx-border-color: black;-fx-border-width: 2 2 2 2;");
        buttonSortingScoredGoals.setOnAction(event -> sortingMethod(2));

        ImageView imageViewTablePage = new ImageView("pics/tableWindowPic.jpg");
        imageViewTablePage.setLayoutX(0);
        imageViewTablePage.setLayoutY(400);
        imageViewTablePage.setFitHeight(820);
        imageViewTablePage.setFitWidth(1300);
        imageViewTablePage.setOpacity(0.8);


        paneClubsTable.getChildren().addAll(imageViewTablePage, tableClubs,buttonBackToStart1,buttonSortingPoints,buttonSortingWins,buttonSortingScoredGoals);/*table as a vBox children*/

        Pane pane2 = new Pane();  /*pane2 creation*/
        pane2.getChildren().addAll(paneClubsTable);    /*paneClubsTable as a pane children*/

        sceneTable = new Scene(pane2,1300,820);
        /*Table Window Buttons End*/


        myWindow.setScene(sceneStart);
        myWindow.show();   /*start show window*/

    }

    /*AnimationTimer for Randomly generate match label*/
    public class showTimer1 extends AnimationTimer {
        @Override
        public void handle(long now) {
            doingHandle();
        }
        private void doingHandle() {
            blurring -= 0.07;
            labelGenerateRandomMatch.opacityProperty().set(blurring);

            if (blurring <= 0) {
                stop();   /*stop showing label*/
            }
        }
    }

    private class showTimer2 extends AnimationTimer {
        @Override
        public void handle(long now) {
            doingHandle();
        }

        private void doingHandle() {
            blurring -= 0.07;
            labelSaveRandomMatch.opacityProperty().set(blurring);
            if (blurring <= 0) {
                stop();   /*Stop showing label*/
            }
        }
    }

    /*Call Sorting method in PremierLeagueManager class*/
    public static void sortingMethod(int sortMethod){

        ArrayList<FootBallClub>clubArrayList = (ArrayList<FootBallClub>) PremierLeagueManager.getClubList();

        for (int x = 0; x< tableClubs.getItems().size(); x++){
            tableClubs.getItems().clear();
        }
        if (sortMethod == 3){          /*set 3 for sorting points*/
            clubArrayList.sort(premierLeagueManagerGUI.sortingPoints());
        }else if (sortMethod == 1){     /*set 1 for sorting winnings*/
            clubArrayList.sort(premierLeagueManagerGUI.sortingWins());

        }else if (sortMethod ==2){     /*set 2 for sorting scored goal count*/
            clubArrayList.sort(premierLeagueManagerGUI.sortingScoredGoals());
        }

        for (FootBallClub clubs : clubArrayList){
            tableClubs.getItems().add(clubs);
        }

    }

}