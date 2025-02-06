import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        if (chessColor==ChessColor.WHITE){
            name='r';
        }else {
            name='R';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Rook = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7) {
                if (getChessComponents()[getSource().getX() + i ][getSource().getY()].getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY());
                    Rook.add(n);
                }
                else if (getChessComponents()[getSource().getX() + i ][getSource().getY()].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX() + i ][getSource().getY()].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY());
                    Rook.add(n);
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY()-i>=0) {
                if (getChessComponents()[getSource().getX()][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() ,getSource().getY()-i);
                    Rook.add(n);
                }
                else if (getChessComponents()[getSource().getX()][getSource().getY()-i].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX()][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX(),getSource().getY()-i);
                    Rook.add(n);
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() -i >=0) {
                if (getChessComponents()[getSource().getX() - i ][getSource().getY()] .getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY());
                    Rook.add(n);
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX() - i ][getSource().getY()].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY());
                    Rook.add(n);
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY()+i<=7) {
                if (getChessComponents()[getSource().getX() ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX() ,getSource().getY()+i);
                    Rook.add(n);
                }
                else if (getChessComponents()[getSource().getX() ][getSource().getY()+i].getChessColor()==this.getChessColor()){
                    break;
                }
                else if (getChessComponents()[getSource().getX()  ][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(getSource().getX()  ,getSource().getY()+i);
                    Rook.add(n);
                    break;
                }
            }
        }
        return Rook;
    }
}
