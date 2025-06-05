package lld.snakenladder;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.initializeGame(10,2,1,5,5);
        System.out.println("Winner is Player : " +game.startGame());

    }
}
