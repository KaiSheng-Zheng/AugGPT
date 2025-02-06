

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessboardPoint chessboardPoint;
    private char name;
    public PawnChessComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        if(color==ChessColor.BLACK){
            setName('P');
        }
        else{
            setName('p');
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (itsConcreteGame.moveChess(chessboardPoint.getX(),chessboardPoint.getY(),chessComponents[i][j].getChessboardPoint().getX(),chessComponents[i][j].getChessboardPoint().getY())){
                    chessboardPoints.add(chessComponents[i][j].getChessboardPoint());
                }
            }
        }

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
    public ChessColor getColor() {
        return color;
    }
}
