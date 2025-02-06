

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessboardPoint chessboardPoint;
    private char name;
    public QueenChessComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        if(color==ChessColor.BLACK){
            setName('Q');
        }
        else{
            setName('q');
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        chessboardPoints.add(new ChessboardPoint(0,0));
        return chessboardPoints;

    }
    @Override
    public String toString(){return String.valueOf(this.name);
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

    }

    @Override
    public ChessColor getColor() {
        return color;
    }
}
