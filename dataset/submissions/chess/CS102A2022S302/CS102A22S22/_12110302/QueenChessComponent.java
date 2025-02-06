import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name, ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.chessColor=chessColor;
        this.name=name;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for (int i=1;getSource().getX()+i<=7&&chessBoard[getSource().getX()+i][getSource().getY()].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()+i][getSource().getY()].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                continue;
            }
            if (chessBoard[getSource().getX()+i][getSource().getY()].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                break;
            }
        }
        for (int i=1;getSource().getY()+i<=7&&chessBoard[getSource().getX()][getSource().getY()+i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()][getSource().getY()+i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                continue;
            }
            if (chessBoard[getSource().getX()][getSource().getY()+i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                break;
            }
        }
        for (int i=1;getSource().getY()-i>=0&&chessBoard[getSource().getX()][getSource().getY()-i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()][getSource().getY()-i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                continue;
            }
            if (chessBoard[getSource().getX()][getSource().getY()-i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                break;
            }
        }
        for (int i=1;getSource().getX()-i>=0&&chessBoard[getSource().getX()-i][getSource().getY()].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()-i][getSource().getY()].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                continue;
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                break;
            }
        }
        for (int i=1;getSource().getX()+i<=7&&getSource().getY()+i<=7&&chessBoard[getSource().getX()+i][getSource().getY()+i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()+i][getSource().getY()+i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                continue;
            }
            if (chessBoard[getSource().getX()+i][getSource().getY()+i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                break;
            }
        }
        for (int i=1;getSource().getY()-i>=0&&getSource().getX()+i<=7&&chessBoard[getSource().getX()+i][getSource().getY()-i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()+i][getSource().getY()-i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-i));
                continue;
            }
            if (chessBoard[getSource().getX()+1][getSource().getY()-i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-i));
                break;
            }
        }
        for (int i=1;getSource().getY()-i>=0&&getSource().getX()-i>=0&&chessBoard[getSource().getX()-i][getSource().getY()-i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()-i][getSource().getY()-i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                continue;
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()-i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                break;
            }
        }
        for (int i=1;getSource().getX()-i>=0&&getSource().getY()+i<=7&&chessBoard[getSource().getX()-i][getSource().getY()+i].chessColor!=this.chessColor;i++){
            if (chessBoard[getSource().getX()-i][getSource().getY()+i].chessColor==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                continue;
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()+i].chessColor!=ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                break;
            }
        }
        Collections.sort(chessboardPoints,priSort);
        return chessboardPoints;
    }

}
