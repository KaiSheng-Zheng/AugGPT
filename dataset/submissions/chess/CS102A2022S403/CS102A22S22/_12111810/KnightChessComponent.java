import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getSource().getX()+1<8&&getSource().getY()+2<8){
        if(ChessComponent.chessComponents[getSource().getX() + 1][getSource().getY()+2].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()+1), (getSource().getY())+2));
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()+2<8){
            if(ChessComponent.chessComponents[getSource().getX() - 1][getSource().getY()+2].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()-1), (getSource().getY())+2));
            }
        }
        if(getSource().getX()+1<8&&getSource().getY()-2>=0){
            if(ChessComponent.chessComponents[getSource().getX() + 1][getSource().getY()-2].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()+1),(getSource().getY())-2));
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()-2>=0){
            if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()-2].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()-1), (getSource().getY()-2)));
            }
        }
        if(getSource().getX()+2<8&&getSource().getY()+1<8){
            if(ChessComponent.chessComponents[getSource().getX()+2][getSource().getY()+1].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()+2), (getSource().getY()+1)));
            }
        }
        if(getSource().getX()+2<8&&getSource().getY()-1>=0){
            if(ChessComponent.chessComponents[getSource().getX() +2][getSource().getY()-1].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()+2), (getSource().getY()-1)));
            }
        }
        if(getSource().getX()-2>=0&&getSource().getY()+1<8){
            if(ChessComponent.chessComponents[getSource().getX() -2][getSource().getY()+1].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()-2), (getSource().getY()+1)));
            }
        }
        if(getSource().getX()-2>=0&&getSource().getY()-1>=0){
            if(ChessComponent.chessComponents[getSource().getX() -2][getSource().getY()-1].getChessColor() != getChessColor()){
                points.add(new ChessboardPoint((getSource().getX()-2), (getSource().getY()-1)));
            }
        }
        return points;
    }
}
