import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor color,char name) {
        this.source=chessboardPoint;
        this.chessColor=color;
        this.name=name;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public ChessColor getChessColor(){return chessColor;}

    public char getName(){return name;}

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
