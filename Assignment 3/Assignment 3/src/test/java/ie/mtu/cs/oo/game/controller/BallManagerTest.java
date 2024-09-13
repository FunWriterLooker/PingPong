package ie.mtu.cs.oo.game.controller;

import static org.junit.Assert.*;

import ie.mtu.cs.oo.ass1.controller.controller.BallManager;
import ie.mtu.cs.oo.ass1.model.Ball;
import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.model.Player;
import ie.mtu.cs.oo.ass1.model.Racket;
import ie.mtu.cs.oo.ass1.projectview.projectView.Canvas;
import org.junit.Before;
import org.junit.Test;


public class BallManagerTest {
    Game game;
    Canvas canvas;
    BallManager manager;

    @Before
    public void initialise() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Ball ball = new Ball(350, 300, 20, 2.5, 2.5);
        Racket racket1 = new Racket(20, 300, 20, 100, 0, 600);
        racket1.setMinY(50);
        racket1.setMaxY(450);

        Racket racket2 = new Racket(650, 300, 20, 100, 0, 600);
        racket2.setMinY(50);
        racket2.setMaxY(450);

        game = new Game(player1, player2, ball, racket1, racket2, 10, 600, 600, 5);
        canvas = new Canvas(600, 600);
        manager = new BallManager(game, canvas, 50, 550);
    }


    @Test
    public void testRacketCollision() {
        Ball ball = game.getBall();
        ball.setPosX(40);
        ball.setPosY(350);
        ball.setStepX(2.5);
        ball.setStepY(0);
        manager.checkRacketCollision(ball);
        assertEquals(-2.5, ball.getStepX(), 0.01);
    }

    @Test
    public void testEndOfGame() {
        game.getPlayer1().setScore(4);
        game.getPlayer2().setScore(3);
        assertTrue(manager.checkEndOfGame(game));
        game.getPlayer2().setScore(1);
        assertFalse(manager.checkEndOfGame(game));
    }

    @Test
    public void testGoalPlayer2() {
        game.getBall().setPosX(1);
        manager.run();
        assertEquals(5, game.getPlayer2().getScore());

        game.getBall().setPosX(100);
        manager.run();
        assertEquals(5, game.getPlayer2().getScore());
    }


    @Test
    public void testEndOfGameAndWinner() {

        game.getPlayer1().setScore(5);
        game.getPlayer2().setScore(3);

        assertTrue(manager.checkEndOfGame(game));
        assertEquals(game.getPlayer1(), manager.getWinner());
    }
}
