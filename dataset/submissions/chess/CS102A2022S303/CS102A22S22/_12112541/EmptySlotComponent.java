



import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessColor color;
    private ChessboardPoint chessboardPoint;
    private char name='_';
    public EmptySlotComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        this.color=color;
        this.chessboardPoint=chessboardPoint;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        chessboardPoints.add(new ChessboardPoint(0,0));
        return chessboardPoints;

    }
    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }
    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    @Override
    public void setItsConcreteGame(ConcreteChessGame concreteChessGame) {
        itsConcreteGame=concreteChessGame;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    @Override
    public ChessColor getColor() {
        return color;
    }
}
