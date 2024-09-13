package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Ball;
import ie.mtu.cs.oo.ass1.model.Racket;
import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.model.Player;

/**
 * The MainController class initializes and manages the main components of the game.
 */
public class MainController {
    private Game game;

    /**
     * Constructs a new MainController object.
     * Initializes players, ball, rackets, and game settings.
     */
    public MainController() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Ball ball = new Ball(350, 300, 20, 2.5, 2.5);
        Racket racket1 = new Racket(20, 300, 20, 100, 0, 600);
        racket1.setMinY(50);
        racket1.setMaxY(450);

        Racket racket2 = new Racket(650, 300, 20, 100, 0, 600);
        racket2.setMinY(50);
        racket2.setMaxY(450);

        int target = 1;
        double dimensionX = 700;
        double dimensionY = 600;

        game = new Game(player1, player2, ball, racket1, racket2, target, dimensionX, dimensionY, 5);
    }

    /**
     * Retrieves the current game instance.
     *
     * @return The current game instance.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the current game instance.
     *
     * @param game The game instance to set.
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
