package lld.snakenladder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Game {

    private Board board;
    private Deque<Player> players;
    private Dice dice;

    public Game() {}

    public void initializeGame(int size, int players, int diceCount, int numOfSnake, int numOfLadder) {

        this.dice = new Dice(diceCount);
        this.board = new Board(size);
        this.players = new ArrayDeque<>();
        Cell[][] cell = this.board.getCells();

        for (int i = 1; i <= players; i++) {
            Player p = new Player("P" + i,0);
            this.players.add(p);
        }

        for (int i = 0; i < numOfLadder; i++) {
            Random random = new Random();
            int start = random.nextInt(size * size - 1);
            int end = random.nextInt(size * size - 1);

            while (start > end) {
                start = random.nextInt(size * size - 1);
                end = random.nextInt(size * size - 1);
            }

            Jump jump = new Jump(start, end);
            int row = start / size;
            int col = start % size;
            cell[row][col]= new Cell(jump);
        }

        for (int i = 0; i < numOfSnake; i++) {
            Random random = new Random();
            int start = random.nextInt(size * size - 1);
            int end = random.nextInt(size * size - 1);

            while (start < end) {
                start = random.nextInt(size * size - 1);
                end = random.nextInt(size * size - 1);
            }

            Jump jump = new Jump(start, end);
            int row = start / size;
            int col = start % size;
            cell[row][col]= new Cell(jump);
        }

    }

    public String startGame() {

        boolean noWinner = true;
        String winner = "";
        Cell [][] cells = board.getCells();

        while (noWinner) {

            Player currPlayer = players.getFirst();
            int nextPosition = currPlayer.currPosition+ dice.rollDice();

            int i = (nextPosition-1)/ board.getSize();
            int j = (nextPosition -1 )% board.getSize() ;
            if(nextPosition<= 100 && cells[i][j] != null /* && cells[i][j].getJump().getStart() == nextPosition */){
                if(cells[i][j].getJump().getStart() < cells[i][j].getJump().getEnd() ) System.out.println( "Ladder at "+nextPosition);
                else System.out.println("Snake at "+nextPosition);
                nextPosition = cells[i][j].getJump().getEnd();
            }
            System.out.println(currPlayer.getName()+" "+currPlayer.currPosition+" -> "+ nextPosition);
            currPlayer.currPosition = nextPosition;
            players.remove(currPlayer);
            players.addLast(currPlayer);
            if(nextPosition >= board.getSize()* board.getSize()-1){
                noWinner = false;
                winner = currPlayer.getName();
            }

        }

        return winner;
    }

}
