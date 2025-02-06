import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent[][] array = getArray();
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = source.getX()+1; i < 8; i++){
            if (array[i][source.getY()].getChessColor().equals(getChessColor())){
                break;
            }
            if (array[i][source.getY()].getChessColor().equals(ChessColor.NONE)){
                list.add(array[i][source.getY()].getSource());
            }else {
                list.add(array[i][source.getY()].getSource());
                break;
            }
        }
        for (int i = source.getX()-1; i >= 0; i--){
            if (array[i][source.getY()].getChessColor().equals(getChessColor())){
                break;
            }
            if (array[i][source.getY()].getChessColor().equals(ChessColor.NONE)){
                list.add(array[i][source.getY()].getSource());
            }else {
                list.add(array[i][source.getY()].getSource());
                break;
            }
        }
        for (int i = source.getY()+1; i < 8; i++){
            if (array[source.getX()][i].getChessColor().equals(getChessColor())){
                break;
            }
            if (array[source.getX()][i].getChessColor().equals(ChessColor.NONE)){
                list.add(array[source.getX()][i].getSource());
            }else {
                list.add(array[source.getX()][i].getSource());
                break;
            }
        }
        for (int i = source.getY()-1; i >= 0; i--){
            if (array[source.getX()][i].getChessColor().equals(getChessColor())){
                break;
            }
            if (array[source.getX()][i].getChessColor().equals(ChessColor.NONE)){
                list.add(array[source.getX()][i].getSource());
            }else {
                list.add(array[source.getX()][i].getSource());
                break;
            }
        }
        return list;
    }
}
