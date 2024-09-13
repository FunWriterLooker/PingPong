package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Game;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

/**
 * The MenuListener class provides event handling for menu actions.
 */
public class MenuListener {
    private Game game;

    /**
     * Constructs a new MenuListener object.
     *
     * @param game The game instance to associate with the menu actions.
     */
    public MenuListener(Game game) {
        this.game = game;
    }

    /**
     * Handles the exit action by terminating the application.
     */
    public void setExit() {
        System.out.println("EXIT");
        Platform.exit();
    }

    /**
     * Handles the "about" action by displaying information about the application.
     */
    public void setAbout() {
        System.out.println("ABOUT");
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights reserved");
        alert.showAndWait().ifPresent((btnType) -> {
        });
    }

    /**
     * Handles setting the game limit action by prompting the user for input.
     */
    public void setGameLimit() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Title");
    }
}
