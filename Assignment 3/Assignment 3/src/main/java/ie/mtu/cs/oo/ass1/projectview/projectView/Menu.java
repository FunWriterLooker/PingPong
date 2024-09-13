package ie.mtu.cs.oo.ass1.projectview.projectView;

import ie.mtu.cs.oo.ass1.controller.controller.MenuListener;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 * The Menu class represents the menu bar and its items for the game.
 */
public class Menu {
    private MenuBar menuBar;
    private javafx.scene.control.Menu menuFile;
    private javafx.scene.control.Menu menuHelp;
    private javafx.scene.control.Menu settings;
    private MenuItem menuItemExit;
    private MenuItem menuItemAbout;

    private MenuItem speed;
    private MenuItem racketDimensions;
    private MenuItem scoreLimit;
    private MenuItem playerNames;
    private MenuListener menuListener;

    public MenuListener getMenuListener() {
        return menuListener;
    }

    public void setMenuListener(MenuListener menuListener) {
        this.menuListener = menuListener;
    }

    /**
     * Constructs a Menu object with the specified MenuListener.
     *
     * @param menuListener The MenuListener for handling menu actions.
     */
    public Menu(MenuListener menuListener) {
        this.menuListener = menuListener;
        menuBar = new MenuBar();
        menuFile = new javafx.scene.control.Menu("File");
        menuHelp = new javafx.scene.control.Menu("Help");
        settings = new javafx.scene.control.Menu("Settings");
        menuItemExit = new MenuItem("Exit");
        menuItemAbout = new MenuItem("About");
        speed = new MenuItem("Speed");
        racketDimensions = new MenuItem("Racket Dimensions");
        scoreLimit = new MenuItem("Score Limit");
        playerNames = new MenuItem("Player Names");


        menuFile.getItems().add(menuItemExit);
        menuHelp.getItems().add(menuItemAbout);
        settings.getItems().addAll(speed, racketDimensions, scoreLimit, playerNames);
        menuBar.getMenus().addAll(menuFile, menuHelp, settings);

        handleClicking();
    }

    private void handleClicking() {

        menuItemExit.setOnAction(e -> menuListener.setExit());
        menuItemAbout.setOnAction(e -> menuListener.setAbout());
        speed.setOnAction(e -> menuListener.setGameLimit());
//         racketDimensions.setOnAction(e -> menuListener.setRacketDimensions());
//         scoreLimit.setOnAction(e -> menuListener.setScoreLimit());
//         playerNames.setOnAction(e -> menuListener.setPlayerNames());

    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public javafx.scene.control.Menu getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(javafx.scene.control.Menu menuFile) {
        this.menuFile = menuFile;
    }

    public javafx.scene.control.Menu getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelp(javafx.scene.control.Menu menuHelp) {
        this.menuHelp = menuHelp;
    }

    public void setSettings(javafx.scene.control.Menu settings) {
        this.settings = settings;
    }

    public void setMenuItemExit(MenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    public void setMenuItemAbout(MenuItem menuItemAbout) {
        this.menuItemAbout = menuItemAbout;
    }


    public void setSpeed(MenuItem speed) {
        this.speed = speed;
    }

    public void setRacketDimensions(MenuItem racketDimensions) {
        this.racketDimensions = racketDimensions;
    }

    public void setScoreLimit(MenuItem scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public void setPlayerNames(MenuItem playerNames) {
        this.playerNames = playerNames;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public MenuItem getMenuItemExit() {
        return menuItemExit;
    }

    public MenuItem getMenuItemAbout() {
        return menuItemAbout;
    }

    public MenuItem getSettings() {
        return settings;
    }

    public MenuItem getSpeed() {
        return speed;
    }

    public MenuItem getRacketDimensions() {
        return racketDimensions;
    }

    public MenuItem getScoreLimit() {
        return scoreLimit;
    }

    public MenuItem getPlayerNames() {
        return playerNames;
    }
}
