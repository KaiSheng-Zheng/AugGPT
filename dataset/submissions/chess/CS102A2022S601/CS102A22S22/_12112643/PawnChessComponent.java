import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
   // private ChessboardPoint source;
   // private ChessColor chessColor;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame board){
//        this.name = name;
//        this.setSource(source);
//        this.setChessColor(chessColor);
//        this.board = board;
        super(source,chessColor,name,board);
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        if (getChessColor() == ChessColor.BLACK && getSource().getY() == 1){
            list.add(getSource().offset(0,2));
        }
        if (getChessColor() == ChessColor.WHITE && getSource().getY() == 6){
            list.add(getSource().offset(0,-2));
        }
        if (getChessColor() == ChessColor.BLACK && getSource().getY() < 7){
            list.add(getSource().offset(0,1));
        }
        if (getChessColor() == ChessColor.WHITE && getSource().getY() > 0){
            list.add(getSource().offset(0,-1));
        }
        return list;
    }
}