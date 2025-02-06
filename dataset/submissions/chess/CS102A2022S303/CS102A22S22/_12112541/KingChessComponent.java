

import java.util.ArrayList;
import java.util.List;

public class    KingChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessboardPoint chessboardPoint;
    private char name;
    public KingChessComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        if(color==ChessColor.BLACK){
            setName('K');
        }
        else{
            setName('k');
        }
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

    }
    @Override
    public String toString(){return String.valueOf(this.name);
    }


    @Override
    public ChessColor getColor() {
        return color;
    }
}
