import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name, ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.chessColor=chessColor;
        this.name=name;
        setSource(chessboardPoint);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        if (chessColor==ChessColor.BLACK){
            if (getSource().getX()==7)return chessboardPoints;
            else {
                if (getSource().getX()==1){
                    if (chessBoard[2][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(2,getSource().getY()));
                    if (chessBoard[3][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(3,getSource().getY()));
                }
                else {
                    if (chessBoard[getSource().getX()+1][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                }
                if (getSource().getY()<7){
                    if (chessBoard[getSource().getX()+1][getSource().getY()+1].chessColor==ChessColor.WHITE)chessboardPoints.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                }
                if (getSource().getY()>0){
                    if (chessBoard[getSource().getX()+1][getSource().getY()-1].chessColor==ChessColor.WHITE)chessboardPoints.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                }
            }
        }
        if (chessColor==ChessColor.WHITE){
            if (getSource().getX()==0)return chessboardPoints;
            else if (getSource().getX()==6){
                if (chessBoard[5][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(5,getSource().getY()));
                if (chessBoard[4][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(4,getSource().getY()));
            }
            else {
                if (chessBoard[getSource().getX()-1][getSource().getY()].chessColor==ChessColor.NONE)chessboardPoints.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
            }
            if (getSource().getY()<7){
                if (chessBoard[getSource().getX()-1][getSource().getY()+1].chessColor==ChessColor.BLACK)chessboardPoints.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if (getSource().getY()>0){
                if (chessBoard[getSource().getX()-1][getSource().getY()-1].chessColor==ChessColor.BLACK)chessboardPoints.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
        }
        Collections.sort(chessboardPoints,priSort);
        return chessboardPoints;
    }

}