import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
        chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);
        if(chessColor == ChessColor.BLACK){
            name = 'R';
        }else if(chessColor == ChessColor.WHITE){
            name = 'r';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        for(int x = getSource().getX(); x < 8; x++){
            if(!(getChessComponents(x, getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x, getSource().getY()));
            }else if(getChessComponents(x, getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x, getSource().getY()).getChessColor()){
                answer.add(new ChessboardPoint(x, getSource().getY()));
                break;
            }else {break;}
        }for(int x = getSource().getX(); x >=0; x--) {
            if (!(getChessComponents(x, getSource().getY()) instanceof HasChessComponent)) {
                answer.add(new ChessboardPoint(x, getSource().getY()));
            } else if (getChessComponents(x, getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x, getSource().getY()).getChessColor()) {
                answer.add(new ChessboardPoint(x, getSource().getY()));
                break;
            } else {
                break;
            }
        }for(int y = getSource().getY(); y < 8; y++){
            if(!(getChessComponents(getSource().getX(), y) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX(), y));
            }else if(getChessComponents(getSource().getX(), y) instanceof HasChessComponent && getChessColor() != getChessComponents(getSource().getX(), y).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX(), y));
                break;
            }else {break;}
        }for(int y = getSource().getY(); y >=0; y--){
            if(!(getChessComponents(getSource().getX(), y) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX(), y));
            }else if(getChessComponents(getSource().getX(), y) instanceof HasChessComponent && getChessColor() != getChessComponents(getSource().getX(), y).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX(), y));
                break;
            }else {break;}
        }
        return answer;
    }
}
