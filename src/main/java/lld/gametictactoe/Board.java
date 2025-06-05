package lld.gametictactoe;

public class Board {

    int size;
    PieceType [][] playerBoard;

    public Board(int size) {
        this.size = size;
        this.playerBoard = new PieceType[size][size];
    }


}
