package MVPGlobal.View.beginScreen;

import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;

public class BeginScreenView extends BorderPane  {

    private UISettings uiSettings;
    private MainScreenView mainScreenView;
    private ImageView centralImage;

    private Button moreInfoBtn;

    private Button loadGameBtn;

    private Button startGameBtn;

    private Label welcomeText;
    private Label instructions;

    // private AudioClip blackjackStartSound;


    public BeginScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.centralImage = new ImageView();
        this.mainScreenView = new MainScreenView(uiSettings);
        moreInfoBtn = new Button("MORE INFO");
        loadGameBtn = new Button("LOAD GAME");
        startGameBtn = new Button("START GAME");
        welcomeText = new Label("Welcome to Knights Of The Future - Blackjack!");
        instructions = new Label("Make your choice below");

        //String soundFile = "resources/music/BlackjackStartTest.mp3";
        // this.blackjackStartSound = new AudioClip(new File(soundFile).toURI().toString());

    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
        }
        catch (MalformedURLException ex){
        }

        //music
        //blackjackStartSound.play();

        //Css
        moreInfoBtn.getStyleClass().add("beginButtons");
        loadGameBtn.getStyleClass().add("beginButtons");
        startGameBtn.getStyleClass().add("beginButtons");
        welcomeText.getStyleClass().add("heading1");
        instructions.getStyleClass().add("heading2");



        int ImageSize = uiSettings.getLowestRes()/5;


           try {
                centralImage = new ImageView(new Image(uiSettings.getStartScreenImagePath().toUri().toURL().toString()));
                centralImage.setPreserveRatio(true);
                centralImage.setFitHeight(ImageSize*2.5*1.10);
                centralImage.setFitWidth(ImageSize*2.5*1.10);
                centralImage.setSmooth(true);
            }
            catch (MalformedURLException ex) {
                // do nothing, if toURL-conversion fails, program can continue
            }


        //VBox
        VBox splash = new VBox();
        splash.setAlignment(Pos.CENTER);
        splash.setSpacing(30);
        splash.setPadding(new Insets(50));

        splash.getChildren().addAll(centralImage,welcomeText, instructions);
        this.setCenter(splash);

        //HBox
        HBox btnsBegin = new HBox(moreInfoBtn, loadGameBtn, startGameBtn);
        btnsBegin.setAlignment(Pos.CENTER);
        btnsBegin.setSpacing(150);
        btnsBegin.setPadding(new Insets(50, 50,90, 50));

        this.setBottom(btnsBegin);
    }

    public Button getMoreInfoBtn() {
        return moreInfoBtn;
    }

    public Button getLoadGameBtn() {
        return loadGameBtn;
    }

    public Button getStartGameBtn() {
        return startGameBtn;
    }
}