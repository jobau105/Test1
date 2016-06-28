package minesweeper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Checker extends Application implements EventHandler<ActionEvent>{

	public  int fieldHeight;
	public  int fieldWidth;
	public  int numberOfSquaresY;
	public  int numberOfSquaresX;
	public  double chanceMine;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	static Pane pane = null;
	Pane paneMenu = null;
	Pane paneGame = null;
	Pane paneLeaderboard = null; 
	Pane paneWin;
	static int countAll;
	static Text textMinesLeft = new Text();
	static Text textMinesLeftTitle = new Text();
	static Text LeaderboardTextEasyName1 = new Text();
	static Text LeaderboardTextEasyTime1 = new Text();
	static Text LeaderboardTextEasyName2 = new Text();
	static Text LeaderboardTextEasyTime2 = new Text();
	static Text LeaderboardTextEasyName3 = new Text();
	static Text LeaderboardTextEasyTime3 = new Text();
	static Text LeaderboardTextEasyName4 = new Text();
	static Text LeaderboardTextEasyTime4 = new Text();
	static Text LeaderboardTextEasyName5 = new Text();
	static Text LeaderboardTextEasyTime5 = new Text();
	static Text LeaderboardTextMediumName1 = new Text();
	static Text LeaderboardTextMediumTime1 = new Text();
	static Text LeaderboardTextMediumName2 = new Text();
	static Text LeaderboardTextMediumTime2 = new Text();
	static Text LeaderboardTextMediumName3 = new Text();
	static Text LeaderboardTextMediumTime3 = new Text();
	static Text LeaderboardTextMediumName4 = new Text();
	static Text LeaderboardTextMediumTime4 = new Text();
	static Text LeaderboardTextMediumName5 = new Text();
	static Text LeaderboardTextMediumTime5 = new Text();
	static Text LeaderboardTextHardName1 = new Text();
	static Text LeaderboardTextHardTime1 = new Text();
	static Text LeaderboardTextHardName2 = new Text();
	static Text LeaderboardTextHardTime2 = new Text();
	static Text LeaderboardTextHardName3 = new Text();
	static Text LeaderboardTextHardTime3 = new Text();
	static Text LeaderboardTextHardName4 = new Text();
	static Text LeaderboardTextHardTime4 = new Text();
	static Text LeaderboardTextHardName5 = new Text();
	static Text LeaderboardTextHardTime5 = new Text();
	static Text LeaderboardTextName1 = new Text("Name:");
	static Text LeaderboardTextName2 = new Text("Name:");
	static Text LeaderboardTextName3 = new Text("Name:");
	static Text LeaderboardTextTime1 = new Text("Seconds:");
	static Text LeaderboardTextTime2 = new Text("Seconds:");
	static Text LeaderboardTextTime3 = new Text("Seconds:");
	static Text LeaderboardTextRank1 = new Text("1.");
	static Text LeaderboardTextRank2 = new Text("2.");
	static Text LeaderboardTextRank3 = new Text("3.");
	static Text LeaderboardTextRank4 = new Text("4.");
	static Text LeaderboardTextRank5 = new Text("5.");
	public static Text textLoser = new Text();
	public static Text textWinner = new Text();
	static Text textTime = new Text();
	Text stopwatch = new Text();
	Scene sceneGame;
	Scene sceneMenu;
	Scene sceneLeaderboard;
	static boolean tester = false;
	boolean checkWin = false;
	Square square = new Square(0,0,false,1,1);
	long tStart;
	static TextField nameField = new TextField();
	static String difficulty = "";
	static String nameInput = "";	
	
public void start(Stage stage) throws Exception{
		
		sceneMenu = showMainMenu();
		stage.setScene(sceneMenu);
		paneGame = setGame();
		paneLeaderboard = setLeaderboard();
		
		
		
		button8.setOnAction(e -> {stage.setScene(sceneMenu);});
		button7.setOnAction(e -> {stage.setScene(sceneMenu);
								button4.setVisible(false);});
		button4.setOnAction(e -> {stage.setScene(sceneGame);
								nameInput = nameField.getText();
								Square.tStart = System.currentTimeMillis();
								square.setFirstTry();
								square.revive();});
		button5.setOnAction(e -> {stage.setScene(sceneLeaderboard);});
		button6.setOnAction(e -> stage.close());
		sceneGame = new Scene(paneGame);
		sceneLeaderboard= new Scene(paneLeaderboard);
		
		stage.setTitle("MINESWEEPER");
		stage.show();
	}
@Override
public void handle(ActionEvent event) {
	if(event.getSource()==button1){
		difficulty = "Easy";
		fieldHeight = 250;
		fieldWidth = 320;
		numberOfSquaresX = (fieldWidth-70)/25;
		numberOfSquaresY = fieldHeight/25;
		chanceMine = 0.10;
		button4.setVisible(true);
		sceneGame = showGame();
	}
	if(event.getSource()==button2){
		difficulty = "Medium";
		fieldHeight = 375;
		fieldWidth = 445;
		numberOfSquaresX = (fieldWidth-70)/25;
		numberOfSquaresY = fieldHeight/25;
		chanceMine = 0.15;
		button4.setVisible(true);
		sceneGame = showGame();
	}
	if(event.getSource()==button3){
		difficulty = "Hard";
		fieldHeight = 500;
		fieldWidth = 570;
		numberOfSquaresX = (fieldWidth-70)/25;
		numberOfSquaresY = fieldHeight/25;
		chanceMine = 0.2;
		button4.setVisible(true);
		sceneGame = showGame();
	}
}
public Pane setMainMenu(){
	Pane paneMenu = new Pane();
	paneMenu.setPrefHeight(225);
	paneMenu.setPrefWidth(300);
	Label difficulty = new Label("Choose Difficulty:");
	Text minesweeperText = new Text("MINESWEEPER");
	button1 = new Button("Easy");
	button2 = new Button("Medium");
	button3 = new Button("Hard");
	button4 = new Button("Start Game!");
	button5 = new Button("Leaderboard");
	button6 = new Button("Exit");
	button7 = new Button("Back");
	nameField.setLayoutX(130);
	nameField.setLayoutY(90);
	nameField.setPromptText("Nickname");
	difficulty.setLayoutX(30);
	difficulty.setLayoutY(60);
	difficulty.setFont(Font.font("Terminal", 13));
	minesweeperText.setLayoutX(100);
	minesweeperText.setLayoutY(30);
	minesweeperText.setFill(Color.RED);
	Reflection reflection = new Reflection();
	reflection.setFraction(0.5f);
	minesweeperText.setEffect(reflection);
	minesweeperText.setFont(Font.font(null, FontWeight.BOLD, 15));
	button1.setLayoutX(30);
	button1.setLayoutY(90);
	button1.setOnAction(this);
	button2.setLayoutX(30);
	button2.setLayoutY(120);
	button2.setOnAction(this);
	button3.setLayoutX(30);
	button3.setLayoutY(150);
	button3.setOnAction(this);
	button4.setLayoutX(170);
	button4.setLayoutY(120);
	button4.setOnAction(this);
	button4.setVisible(false);
	button5.setLayoutX(170);
	button5.setLayoutY(150);
	button5.setOnAction(this);
	button6.setLayoutX(170);
	button6.setLayoutY(180);
	button6.setOnAction(this);
	button7.setLayoutX((fieldWidth-70)/2.2);
	button7.setLayoutY(fieldHeight+20);
	button7.setOnAction(this);
	button7.setVisible(false);

	paneMenu.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7,difficulty,minesweeperText,nameField);
	return paneMenu;
}
public Pane setLeaderboard(){
	
	Pane paneLeaderboard = new Pane();
	paneLeaderboard.setPrefHeight(600);
	paneLeaderboard.setPrefWidth(800);
	Text LeaderboardText = new Text("LEADERBOARD");
	LeaderboardText.setLayoutX(320);
	LeaderboardText.setLayoutY(30);
	LeaderboardText.setFill(Color.BLUE);
	Reflection reflection = new Reflection();
	reflection.setFraction(0.5f);
	LeaderboardText.setEffect(reflection);
	LeaderboardText.setFont(Font.font(null, FontWeight.BOLD, 20));
	Text LeaderboardTextEasy = new Text("Difficulty:Easy");
	LeaderboardTextEasy.setLayoutX(100);
	LeaderboardTextEasy.setLayoutY(80);
	Text LeaderboardTextMedium = new Text("Difficulty:Medium");
	LeaderboardTextMedium.setLayoutX(350);
	LeaderboardTextMedium.setLayoutY(80);
	Text LeaderboardTextHard = new Text("Difficulty:Hard");
	LeaderboardTextHard.setLayoutX(620);
	LeaderboardTextHard.setLayoutY(80);
	LeaderboardTextEasyName1.setLayoutX(85);
	LeaderboardTextEasyName1.setLayoutY(250);
	LeaderboardTextEasyTime1.setLayoutX(180);
	LeaderboardTextEasyTime1.setLayoutY(250);
	LeaderboardTextEasyName2.setLayoutX(85);
	LeaderboardTextEasyName2.setLayoutY(300);
	LeaderboardTextEasyTime2.setLayoutX(180);
	LeaderboardTextEasyTime2.setLayoutY(300);
	LeaderboardTextEasyName3.setLayoutX(85);
	LeaderboardTextEasyName3.setLayoutY(350);
	LeaderboardTextEasyTime3.setLayoutX(180);
	LeaderboardTextEasyTime3.setLayoutY(350);
	LeaderboardTextEasyName4.setLayoutX(85);
	LeaderboardTextEasyName4.setLayoutY(400);
	LeaderboardTextEasyTime4.setLayoutX(180);
	LeaderboardTextEasyTime4.setLayoutY(400);
	LeaderboardTextEasyName5.setLayoutX(85);
	LeaderboardTextEasyName5.setLayoutY(450);
	LeaderboardTextEasyTime5.setLayoutX(180);
	LeaderboardTextEasyTime5.setLayoutY(450);
	LeaderboardTextMediumName1.setLayoutX(355);
	LeaderboardTextMediumName1.setLayoutY(250);
	LeaderboardTextMediumTime1.setLayoutX(440);
	LeaderboardTextMediumTime1.setLayoutY(250);
	LeaderboardTextMediumName2.setLayoutX(355);
	LeaderboardTextMediumName2.setLayoutY(300);
	LeaderboardTextMediumTime2.setLayoutX(440);
	LeaderboardTextMediumTime2.setLayoutY(300);
	LeaderboardTextMediumName3.setLayoutX(355);
	LeaderboardTextMediumName3.setLayoutY(350);
	LeaderboardTextMediumTime3.setLayoutX(440);
	LeaderboardTextMediumTime3.setLayoutY(350);
	LeaderboardTextMediumName4.setLayoutX(355);
	LeaderboardTextMediumName4.setLayoutY(400);
	LeaderboardTextMediumTime4.setLayoutX(440);
	LeaderboardTextMediumTime4.setLayoutY(400);
	LeaderboardTextMediumName5.setLayoutX(355);
	LeaderboardTextMediumName5.setLayoutY(450);
	LeaderboardTextMediumTime5.setLayoutX(440);
	LeaderboardTextMediumTime5.setLayoutY(450);
	LeaderboardTextHardName1.setLayoutX(605);
	LeaderboardTextHardName1.setLayoutY(250);
	LeaderboardTextHardTime1.setLayoutX(700);
	LeaderboardTextHardTime1.setLayoutY(250);
	LeaderboardTextHardName2.setLayoutX(605);
	LeaderboardTextHardName2.setLayoutY(300);
	LeaderboardTextHardTime2.setLayoutX(700);
	LeaderboardTextHardTime2.setLayoutY(300);
	LeaderboardTextHardName3.setLayoutX(605);
	LeaderboardTextHardName3.setLayoutY(350);
	LeaderboardTextHardTime3.setLayoutX(700);
	LeaderboardTextHardTime3.setLayoutY(350);
	LeaderboardTextHardName4.setLayoutX(605);
	LeaderboardTextHardName4.setLayoutY(400);
	LeaderboardTextHardTime4.setLayoutX(700);
	LeaderboardTextHardTime4.setLayoutY(400);
	LeaderboardTextHardName5.setLayoutX(605);
	LeaderboardTextHardName5.setLayoutY(450);
	LeaderboardTextHardTime5.setLayoutX(700);
	LeaderboardTextHardTime5.setLayoutY(450);
	LeaderboardTextName1.setLayoutX(80);
	LeaderboardTextName1.setLayoutY(200);
	LeaderboardTextName2.setLayoutX(350);
	LeaderboardTextName2.setLayoutY(200);
	LeaderboardTextName3.setLayoutX(600);
	LeaderboardTextName3.setLayoutY(200);
	LeaderboardTextTime1.setLayoutX(180);
	LeaderboardTextTime1.setLayoutY(200);
	LeaderboardTextTime2.setLayoutX(440);
	LeaderboardTextTime2.setLayoutY(200);
	LeaderboardTextTime3.setLayoutX(700);
	LeaderboardTextTime3.setLayoutY(200);
	LeaderboardTextRank1.setLayoutX(50);
	LeaderboardTextRank1.setLayoutY(250);
	LeaderboardTextRank2.setLayoutX(50);
	LeaderboardTextRank2.setLayoutY(300);
	LeaderboardTextRank3.setLayoutX(50);
	LeaderboardTextRank3.setLayoutY(350);
	LeaderboardTextRank4.setLayoutX(50);
	LeaderboardTextRank4.setLayoutY(400);
	LeaderboardTextRank5.setLayoutX(50);
	LeaderboardTextRank5.setLayoutY(450);
	button8 = new Button("Back");
	button8.setLayoutX(365);
	button8.setLayoutY(500);
	button8.setOnAction(this);
	
	paneLeaderboard.getChildren().addAll(LeaderboardText, LeaderboardTextEasy, LeaderboardTextMedium, LeaderboardTextHard,button8,
			LeaderboardTextEasyName1,LeaderboardTextEasyTime1,LeaderboardTextEasyName2,LeaderboardTextEasyTime2,LeaderboardTextEasyName3,
			LeaderboardTextEasyTime3,LeaderboardTextEasyName4,LeaderboardTextEasyTime4,LeaderboardTextEasyName5,LeaderboardTextEasyTime5,
			LeaderboardTextMediumName1,LeaderboardTextMediumTime1,LeaderboardTextMediumName2,LeaderboardTextMediumTime2,LeaderboardTextMediumName3
			,LeaderboardTextMediumTime3,LeaderboardTextMediumName4,LeaderboardTextMediumTime4,LeaderboardTextMediumName5,LeaderboardTextMediumTime5,
			LeaderboardTextHardName1,LeaderboardTextHardTime1,LeaderboardTextHardName2,LeaderboardTextHardTime2,LeaderboardTextHardName3,
			LeaderboardTextHardTime3,LeaderboardTextHardName4,LeaderboardTextHardTime4,LeaderboardTextHardName5,LeaderboardTextHardTime5
			,LeaderboardTextName1,LeaderboardTextName2,LeaderboardTextName3,LeaderboardTextTime1,LeaderboardTextTime2,LeaderboardTextTime3,
			LeaderboardTextRank1,LeaderboardTextRank2,LeaderboardTextRank3,LeaderboardTextRank4,LeaderboardTextRank5);
	return paneLeaderboard;
}
public Scene showMainMenu(){
	Scene sceneMenu = new Scene(setMainMenu());	
	return sceneMenu;
}
public Pane setGame(){
	Pane paneGame = new Pane();
	SquareField field = new SquareField(numberOfSquaresX, numberOfSquaresY, chanceMine);
	paneGame = field.createField();
	paneGame.setPrefSize(fieldHeight,fieldWidth);
	button7.setLayoutX((fieldWidth-70)/2.2);
	button7.setLayoutY(fieldHeight+20);
	button7.setVisible(true);
	textTime.setText("time");
	textTime.setTranslateX(10);
	textTime.setTranslateY(numberOfSquaresY*25+50);
	textMinesLeft.setText(String.valueOf(countAll));
	textMinesLeft.setTranslateX(numberOfSquaresX*25-52);
	textMinesLeft.setTranslateY(numberOfSquaresY*25+40);
	textMinesLeftTitle.setText("Mines Left:");
	textMinesLeftTitle.setTranslateX(numberOfSquaresX*25-80);
	textMinesLeftTitle.setTranslateY(numberOfSquaresY*25+15);
	textLoser.setText("YOU LOSE");
	textLoser.setFont(Font.font(null, FontWeight.BOLD, 20));
	textLoser.setFill(Color.RED);
	textLoser.setVisible(false);
	textLoser.setTranslateX(10);
	textLoser.setTranslateY(numberOfSquaresY*25+27);
	textWinner.setText("YOU WIN");
	textWinner.setFont(Font.font(null, FontWeight.BOLD, 20));
	textWinner.setFill(Color.GREEN);
	textWinner.setVisible(false);
	textWinner.setTranslateX(10);
	textWinner.setTranslateY(numberOfSquaresY*25+27);
	Text textSec = new Text("sec");
	textSec.setTranslateX(60);
	textSec.setTranslateY(numberOfSquaresY*25+50);
	paneGame.getChildren().addAll(button7, textTime, textSec, textMinesLeft,textMinesLeftTitle,textWinner,textLoser);
	return paneGame;
}
public Scene showGame(){
	Scene sceneGame = new Scene(setGame());
	return sceneGame;
}
public static void main(String[] args) {

	Checker.launch(Checker.class);
}

}