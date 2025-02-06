import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint){
        setSource(chessboardPoint);
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (this.chessColor == ChessColor.BLACK){
            if (getSource().getX()==7){
                return chessboardPoints;
            }else {
               if (getSource().getY() != 0&&getSource().getY() != 7){
                   if (chessPieces[getSource().getX()+1][getSource().getY()-1].chessColor == ChessColor.WHITE){
                       chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
                   }
                   if (chessPieces[getSource().getX()+1][getSource().getY()+1].chessColor == ChessColor.WHITE){
                       chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
                   }
               }
                if (getSource().getY() == 0){
                    if (chessPieces[getSource().getX()+1][getSource().getY()+1].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
                    }
                }
                if (getSource().getY() == 7){
                    if (chessPieces[getSource().getX()+1][getSource().getY()-1].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
                    }
                }
                if (getSource().getX()==1){
                    if (chessPieces[getSource().getX()+1][getSource().getY()].chessColor != ChessColor.NONE){
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else if (chessPieces[getSource().getX()+2][getSource().getY()].chessColor != ChessColor.NONE){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }

                }
                else {
                    if (chessPieces[getSource().getX()+1][getSource().getY()].chessColor != ChessColor.NONE){
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }
                }
            }

        }else if (this.chessColor == ChessColor.WHITE){
            if (getSource().getX()==0){
                return chessboardPoints;
            }else {
                if (getSource().getY() != 0&&getSource().getY() != 7){
                    if (chessPieces[getSource().getX()-1][getSource().getY()-1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
                    }
                    if (chessPieces[getSource().getX()-1][getSource().getY()+1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
                    }
                }
                if (getSource().getY() == 0){
                    if (chessPieces[getSource().getX()-1][getSource().getY()+1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
                     }
                }
                if (getSource().getY() == 7){
                    if (chessPieces[getSource().getX()-1][getSource().getY()-1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
                    }
                }
                if (getSource().getX()==6){
                    if (chessPieces[getSource().getX()-1][getSource().getY()].chessColor != ChessColor.NONE){
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else if (chessPieces[getSource().getX()-2][getSource().getY()].chessColor != ChessColor.NONE){
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }

                }
                else {
                    if (chessPieces[getSource().getX()-1][getSource().getY()].chessColor != ChessColor.NONE){
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }else {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                        Collections.sort(chessboardPoints,super.presort);
                        return chessboardPoints;
                    }
                }
            }
        }
        Collections.sort(chessboardPoints,presort);
        return chessboardPoints;
    }
}
