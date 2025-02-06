import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint){
        setSource(chessboardPoint);
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (getSource().getX() + 2 <= 7 && getSource().getY() - 1 >= 0 && chessPieces[getSource().getX() + 2][getSource().getY() - 1].chessColor() != this.chessColor){
           chessboardPoints.add(new ChessboardPoint(getSource().getX() + 2,getSource().getY() - 1)) ;
        }
        if (getSource().getX() + 1 <= 7 && getSource().getY() - 2 >= 0 && chessPieces[getSource().getX() + 1][getSource().getY() - 2].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() - 2)) ;
        }
        if (getSource().getX() + 2 <= 7 && getSource().getY() + 1 <= 7 && chessPieces[getSource().getX() + 2][getSource().getY() + 1].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 2,getSource().getY() + 1)) ;
        }
        if (getSource().getX() + 1 <= 7 && getSource().getY() + 2 <= 7 && chessPieces[getSource().getX() + 1][getSource().getY() + 2].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() + 2)) ;
        }
        if (getSource().getX() -1 >= 0 && getSource().getY() + 2 <= 7 && chessPieces[getSource().getX() - 1][getSource().getY() + 2].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() + 2)) ;
        }
        if (getSource().getX() -2 >= 0 && getSource().getY() + 1 <= 7 && chessPieces[getSource().getX() - 2][getSource().getY() + 1].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 2,getSource().getY() + 1)) ;
        }
        if (getSource().getX() -2 >= 0 && getSource().getY() - 1 >= 0 && chessPieces[getSource().getX() - 2][getSource().getY() - 1].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 2,getSource().getY() - 1)) ;
        }
        if (getSource().getX() -1 >= 0 && getSource().getY() - 2 >= 0 && chessPieces[getSource().getX() - 1][getSource().getY() - 2].chessColor() != this.chessColor){
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() - 2)) ;
        }
        Collections.sort(chessboardPoints,presort);
        return chessboardPoints;
    }
}
