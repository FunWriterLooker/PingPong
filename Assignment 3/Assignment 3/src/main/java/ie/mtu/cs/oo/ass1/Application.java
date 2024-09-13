package ie.mtu.cs.oo.ass1;

import ie.mtu.cs.oo.ass1.controller.controller.BallManager;
import ie.mtu.cs.oo.ass1.controller.controller.KeyboardListener;
import ie.mtu.cs.oo.ass1.controller.controller.MainController;
import ie.mtu.cs.oo.ass1.controller.controller.MenuListener;
import ie.mtu.cs.oo.ass1.projectview.projectView.Canvas;
import ie.mtu.cs.oo.ass1.projectview.projectView.Menu;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The Application class represents the main application entry point for the Pong game.
 */
public class Application extends javafx.application.Application {
    private MainController mainController = new MainController();
    private MenuListener menuListener = new MenuListener(mainController.getGame());
    private Menu myMenu = new Menu(menuListener);

    /**
     * The main method.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the application.
     *
     * @param primaryStage The primary stage of the application.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pong");
        BorderPane root = new BorderPane();
        root.setTop(myMenu.getMenuBar());
        primaryStage.setScene(new Scene(root, 1000, 600));
        Canvas canvas = new Canvas(1000, 600);
        root.setCenter(canvas);

        canvas.drawGame(mainController.getGame());

        primaryStage.widthProperty().addListener(observable -> {
            double factor = primaryStage.getWidth() / mainController.getGame().getDimensionX();
            System.out.println("Width changed " + primaryStage.getWidth() + " " + factor);
            mainController.getGame().setDimensionX(primaryStage.getWidth());
            mainController.getGame().resizeX(factor);
            canvas.drawGame(mainController.getGame());
        });
        primaryStage.heightProperty().addListener(observable -> {
            double factor = primaryStage.getHeight() / mainController.getGame().getDimensionY();
            System.out.println("Height changed " + primaryStage.getHeight() + " " + factor);
            mainController.getGame().setDimensionY(primaryStage.getHeight());
            mainController.getGame().resizeY(factor);
            canvas.drawGame(mainController.getGame());
        });

        double minYValue = 50;
        double maxYValue = 550;
        BallManager ballManager = new BallManager(mainController.getGame(), canvas, minYValue, maxYValue);
        Thread thread = new Thread(ballManager);
        thread.start();
        Thread.yield();


        KeyboardListener keyboardListener = new KeyboardListener(mainController.getGame(), canvas);
        canvas.setOnKeyPressed(keyboardListener);
        canvas.setOnKeyTyped(keyboardListener);
        canvas.setFocusTraversable(true);

        primaryStage.show();
    }
}
