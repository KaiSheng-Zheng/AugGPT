import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint){
        setSource(chessboardPoint);
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 1; getSource().getX()+i<=7 && chessPieces[getSource().getX()+i][getSource().getY()].chessColor!=this.chessColor; i++) {
            if (chessPieces[getSource().getX() + i][getSource().getY()].chessColor() == ChessColor.NONE ){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                continue;
            }
            if (chessPieces[getSource().getX() + i][getSource().getY()].chessColor() != ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                break;
            }
        }
        for (int i = 1; getSource().getX()-i>=0 && chessPieces[getSource().getX()-i][getSource().getY()].chessColor!=this.chessColor; i++) {
            if (chessPieces[getSource().getX() - i][getSource().getY()].chessColor() == ChessColor.NONE ){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                continue;
            }
            if (chessPieces[getSource().getX() - i][getSource().getY()].chessColor() != ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                break;
            }
        }
        for (int i = 1; getSource().getY()-i>=0 && chessPieces[getSource().getX()][getSource().getY()-i].chessColor!=this.chessColor; i++) {
            if (chessPieces[getSource().getX()][getSource().getY()-i].chessColor() == ChessColor.NONE ){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                continue;
            }
            if (chessPieces[getSource().getX()][getSource().getY()-i].chessColor() != ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                break;
            }
        }
        for (int i = 1; getSource().getY()+i<=7 && chessPieces[getSource().getX()][getSource().getY()+i].chessColor!=this.chessColor; i++) {
            if (chessPieces[getSource().getX()][getSource().getY()+i].chessColor() == ChessColor.NONE ){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                continue;
            }
            if (chessPieces[getSource().getX()][getSource().getY()+i].chessColor() != ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                break;
            }
        }
        Collections.sort(chessboardPoints,presort);
        return chessboardPoints;
    }
}
