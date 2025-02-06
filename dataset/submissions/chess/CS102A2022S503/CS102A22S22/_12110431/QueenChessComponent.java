import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        super(source, color, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<ChessboardPoint>();
        for (int d=1;d+getSource().getX()<8&&d+ getSource().getY()<8;d++){
            if (chessComponents[d+getSource().getX()][d+getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(d+ getSource().getX(), d+ getSource().getY()));
            }else if (chessComponents[d+getSource().getX()][d+getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(d+ getSource().getX(), d+getSource().getY()));
                break;
            }
        }
        for (int d=-1;d+getSource().getX()>=0&&d+ getSource().getY()>=0;d--){
            if (chessComponents[d+getSource().getX()][d+getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(d+ getSource().getX(), d+ getSource().getY()));
            }else if (chessComponents[d+getSource().getX()][d+getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(d+ getSource().getX(), d+getSource().getY()));
                break;
            }
        }
        for (int d=1;d+getSource().getX()<8&&getSource().getY()-d>=0;d++){
            if (chessComponents[d+getSource().getX()][getSource().getY()-d].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(d+ getSource().getX(), getSource().getY()-d));
            }else if (chessComponents[d+getSource().getX()][getSource().getY()-d].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(d+ getSource().getX(), getSource().getY()-d));
                break;
            }
        }
        for (int d=1;getSource().getX()-d>=0&&d+getSource().getY()<8;d++){
            if (chessComponents[getSource().getX()-d][d+getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint( getSource().getX()-d, d+ getSource().getY()));
            }else if (chessComponents[getSource().getX()-d][d+getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(getSource().getX()-d, d+getSource().getY()));
                break;
            }
        }
        for (int dx=1;dx+getSource().getX()<8;dx++){
            if (chessComponents[dx+getSource().getX()][getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(dx+ getSource().getX(), getSource().getY()));
            }else if (chessComponents[dx+getSource().getX()][getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(dx+ getSource().getX(), getSource().getY()));
                break;
            }
        }
        for (int dx=-1;dx+getSource().getX()>=0;dx--){
            if (chessComponents[dx+getSource().getX()][getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(dx+ getSource().getX(), getSource().getY()));
            }else if (chessComponents[dx+getSource().getX()][getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(dx+ getSource().getX(), getSource().getY()));
                break;
            }
        }
        for (int dy=1;dy+getSource().getY()<8;dy++){
            if (chessComponents[getSource().getX()][dy+getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(getSource().getX(), dy+getSource().getY()));
            }else if (chessComponents[getSource().getX()][dy+ getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(getSource().getX(), dy+getSource().getY()));
                break;
            }
        }
        for (int dy=-1;dy+getSource().getY()>=0;dy--){
            if (chessComponents[getSource().getX()][dy+getSource().getY()].getChessColor()==ChessColor.NONE){
                target.add(new ChessboardPoint(getSource().getX(), dy+getSource().getY()));
            }else if (chessComponents[getSource().getX()][dy+ getSource().getY()].getChessColor()==getChessColor()){
                break;
            }else {
                target.add(new ChessboardPoint(getSource().getX(), dy+getSource().getY()));
                break;
            }
        }
        return target;
    }
}