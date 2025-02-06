import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    //private ChessboardPoint source;
    //private ChessColor chessColor;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame board){
//        this.name = name;
//        this.setSource(source);
//        this.setChessColor(chessColor);
//        this.board = board;
        super(source,chessColor,name,board);
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (canStep(getSource().offset(-1,-1)) != null){
            list.add(getSource().offset(-1,-1));
        }
        if (canStep(getSource().offset(-1,0)) != null){
            list.add(getSource().offset(-1,0));
        }
        if (canStep(getSource().offset(-1,1)) != null){
            list.add(getSource().offset(-1,1));
        }
        if (canStep(getSource().offset(0,-1)) != null){
            list.add(getSource().offset(0,-1));
        }
        if (canStep(getSource().offset(0,1)) != null){
            list.add(getSource().offset(0,1));
        }
        if (canStep(getSource().offset(1,-1)) != null){
            list.add(getSource().offset(1,-1));
        }
        if (canStep(getSource().offset(1,0)) != null){
            list.add(getSource().offset(1,0));
        }
        if (canStep(getSource().offset(1,1)) != null){
            list.add(getSource().offset(1,1));
        }
        return list;
    }
}