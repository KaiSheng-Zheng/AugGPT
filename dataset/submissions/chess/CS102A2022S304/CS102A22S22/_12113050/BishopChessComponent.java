import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        if (chessColor==ChessColor.WHITE){
            name='b';
        }else {
            name='B';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Bishop = new ArrayList<>();
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() + i <= 7&&getSource().getY()+i<=7) {
                    if (getChessComponents()[getSource().getX() + i ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()+i);
                        Bishop.add(n);
                    }
                   else if (getChessComponents()[getSource().getX() + i ][getSource().getY()+i].getChessColor()==this.getChessColor()){
                        break;
                    }
                   else if (getChessComponents()[getSource().getX() + i ][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()+i);
                        Bishop.add(n);
                        break;
                    }
                }
                }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7&&getSource().getY()-i>=0) {
                if (getChessComponents()[getSource().getX() + i ][getSource().getY()-i] .getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()-i);
                    Bishop.add(n);
                }
                else if (getChessComponents()[getSource().getX() + i ][getSource().getY()-i].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX() + i ][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()-i);
                    Bishop.add(n);
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() -i >=0&&getSource().getY()-i>=0) {
                if (getChessComponents()[getSource().getX() - i ][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()-i);
                    Bishop.add(n);
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()-i].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()-i);
                    Bishop.add(n);
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() - i >= 0&&getSource().getY()+i<=7) {
                if (getChessComponents()[getSource().getX() - i ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()+i);
                    Bishop.add(n);
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()+i].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()+i);
                    Bishop.add(n);
                    break;
                }
            }
        }
        return Bishop;
                }
    }


