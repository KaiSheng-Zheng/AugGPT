import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint start = getSource();
        ChessComponent source = chessComponents[start.getX()][start.getY()];
        ChessColor chessColor = source.getChessColor();
        List<ChessboardPoint> result = new ArrayList<>();
        if (getSource().getX()+2<8 && getSource().getY()+1<8){
            result.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()+1));
        }
        if (getSource().getX()+2<8 && getSource().getY()-1>=0){
            result.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()-1));
        }
        if (getSource().getX()-2>=0 && getSource().getY()+1<8){
            result.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()+1));
        }
        if (getSource().getX()-2>=0 && getSource().getY()-1>=0){
            result.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()-1));
        }
        if (getSource().getX()+1<8 && getSource().getY()+2<8){
            result.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+2));
        }
        if (getSource().getX()-1>=0 && getSource().getY()+2<8){
            result.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+2));
        }
        if (getSource().getX()+1<8 && getSource().getY()-2>=0){
            result.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-2));
        }
        if (getSource().getX()-1>=0 && getSource().getY()-2>=0){
            result.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-2));
        }
        result.removeIf(P -> chessComponents[P.getX()][P.getY()].getChessColor() == chessColor);
        return result;
    }
}
