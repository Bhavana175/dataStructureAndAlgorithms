package lld.snakenladder;

import lombok.Getter;

@Getter
public class Cell {

    private final Jump jump;

    public Cell(Jump jump) {
        this.jump = jump;
    }
}
