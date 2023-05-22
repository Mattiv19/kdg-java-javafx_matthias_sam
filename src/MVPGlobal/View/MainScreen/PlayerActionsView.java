package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerActionsView extends VBox  {

    private UISettings uiSettings;
    private Button buttonHit;
    private Button buttonDouble;
    private Button buttonStand;
    private Button buttonDeal;




    public PlayerActionsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.buttonHit = new Button("HIT");
        this.buttonDouble = new Button("DOUBLE");
        this.buttonStand = new Button("STAND");
        this.buttonDeal = new Button("DEAL");


    }

    private void layoutNodes() {
        //ButtonsRight
        this.setAlignment(Pos.CENTER);
        this.setSpacing(uiSettings.getSpacing()*5);
        this.setPadding(new Insets(uiSettings.getInsetsMargin()));

        this.getChildren().addAll(buttonDeal,buttonHit, buttonDouble, buttonStand);

        this.buttonHit.setVisible(false);
        this.buttonDouble.setVisible(false);
        this.buttonStand.setVisible(false);
    }

    // Getters

    Button getButtonDeal() {return buttonDeal;}

    Button getButtonHit() {return buttonHit;}

    Button getButtonStand() {return buttonStand;}

    Button getButtonDouble() {return buttonDouble;}

}
