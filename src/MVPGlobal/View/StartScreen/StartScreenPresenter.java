package MVPGlobal.View.StartScreen;

import MVPGlobal.Model.*;
import MVPGlobal.View.*;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.MainScreen.MainScreenPresenter;
import MVPGlobal.View.beginScreen.BeginScreenPresenter;
import MVPGlobal.View.beginScreen.BeginScreenView;
import javafx.event.*;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;

public class StartScreenPresenter {

    private BlackJackGame blackJackGame;
    private StartScreenView view;
    private MainScreenPresenter mainScreenPresenter;
    private UISettings uiSettings;


    public StartScreenPresenter(BlackJackGame blackJackGame, StartScreenView view, UISettings uiSettings) {
        this.blackJackGame = blackJackGame;
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        EventHandlers();
    }

    private void updateView() {
    }

    private void EventHandlers() {
        view.getTransition().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BeginScreenView beginView = new BeginScreenView(uiSettings);
                BeginScreenPresenter bsPresenter = new BeginScreenPresenter(blackJackGame, beginView, uiSettings);
                view.getScene().setRoot(beginView);
                beginView.getScene().getWindow().sizeToScene();
                beginView.getScene().getWindow().setHeight(uiSettings.getResY()/1.1);
                beginView.getScene().getWindow().setWidth(uiSettings.getResX()/1.1);

                bsPresenter.windowsHandler();
            }
        });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
             @Override
             public void handle(WindowEvent event) {
                 AlertBlackjack stopWindow = new AlertBlackjack(Alert.AlertType.ERROR,"Error" ,"You can not yet close the application.", "Try again after the program has started","OK");
                 stopWindow.showAndWait();
                 event.consume(); } });
    }
}
