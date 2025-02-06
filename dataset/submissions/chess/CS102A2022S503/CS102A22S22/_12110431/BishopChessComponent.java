import java.util.ArrayList;
import java.util.List;


public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        super(source, color, name, chessComponents);
    }

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

        return target;
        }
    }

    