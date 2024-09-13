//package ie.mtu.cs.oo.ass1.Database;
//
//import ie.mtu.cs.oo.ass1.model.Game;
//import ie.mtu.cs.oo.ass1.model.Player;
//
//public class GameBuilder {
//    private String player1Name;
//    private String player2Name;
//    private int player1Score;
//    private int player2Score;
//    private String name;
//    private int target;
//    public Game build() {
//        Game game = new Game("Player 1", "Player 2", 1, 1, 1, 5, 1000, 600, 5);
//        Player player1= new Player("Player 1");
//        Player player2= new Player("Player 2");
//        player1.setScore(player1Score);
//        player2.setScore(player2Score);
//        game.setTarget(target);
//        game.setPlayer1(player1);
//        game.setPlayer2(player2);
//        return game;
//    }
//    public GameBuilder withName(String name) {
//        this.name=name;
//        return this;
//    }
//    public GameBuilder withPlayer1Name(String p1Name) {
//        this.player1Name=p1Name;
//        return this;
//    }
//    public GameBuilder withPlayer2Name(String p2Name) {
//        this.player2Name=p2Name;
//        return this;
//    }
//    public GameBuilder withPlayer1Score(int score) {
//        this.player1Score=score;
//        return this;
//    }
//    public GameBuilder withPlayer2Score(int score) {
//        this.player2Score=score;
//        return this;
//    }
//    public GameBuilder withTarget(int t) {
//        this.target=t;
//        return this;
//    }
//}