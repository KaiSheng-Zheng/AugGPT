import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getSource().getX()+1<8) {
            if (ChessComponent.chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() != getChessColor()) {
                points.add(new ChessboardPoint((getSource().getX() + 1), getSource().getY()));
            }
        }
        if(getSource().getX()-1>=0) {
            if (ChessComponent.chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() != getChessColor()) {
                points.add(new ChessboardPoint((getSource().getX() - 1), getSource().getY()));
            }
        }
        if(getSource().getY()+1<8) {
            if (ChessComponent.chessComponents[getSource().getX()][getSource().getY() + 1].getChessColor() != getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX(), (getSource().getY() + 1)));
            }
        }
        if(getSource().getY()-1>=0){
            if (ChessComponent.chessComponents[getSource().getX()][getSource().getY() - 1].getChessColor() != getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX(), (getSource().getY() - 1)));
            }
        }
        if(getSource().getX()+1<8&&getSource().getY()+1<8){
            if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()!=getChessColor()){
                points.add(new ChessboardPoint((getSource().getX() + 1), (getSource().getY() + 1)));
            }
        }
        if(getSource().getX()+1<8&&getSource().getY()-1>=0){
            if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()!=getChessColor()){
                points.add(new ChessboardPoint((getSource().getX() + 1), (getSource().getY() - 1)));
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()+1<8){
            if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()!=getChessColor()){
                points.add(new ChessboardPoint((getSource().getX() - 1), (getSource().getY() + 1)));
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()-1>=0){
            if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()!=getChessColor()){
                points.add(new ChessboardPoint((getSource().getX() - 1), (getSource().getY() - 1)));
            }
        }
        return points;
    }
}
