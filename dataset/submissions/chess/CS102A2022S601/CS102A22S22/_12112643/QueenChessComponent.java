import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
  //  private ChessboardPoint source;
   // private ChessColor chessColor;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame board){
//        this.name = name;
//        this.setSource(source);
//        this.setChessColor(chessColor);
//        this.board = board;
        super(source,chessColor,name,board);
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        for (int i=1; i<= 7- getSource().getX(); i++){
            if(getSource().offset(i,0) != null){
                list.add(getSource().offset(i,0));
            }
        }
        for (int i=1; getSource().getX()-i>=0; i++){
            if (getSource().offset(-i, 0) != null){
                list.add(getSource().offset(-i, 0));
            }
        }
        for (int i=1; i<= 7- getSource().getY(); i++){
            if(getSource().offset(0,i) != null){
                list.add(getSource().offset(0,i));
            }
        }
        for (int i=1; getSource().getY()-i>=0; i++){
            if (getSource().offset(0, -i) != null){
                list.add(getSource().offset(0, -i));
            }
        }
        for (int i=1; i<= 7- getSource().getX(); i++){
            if(getSource().offset(i,i) != null){
                list.add(getSource().offset(i,i));
            }
        }
        for (int i=1; getSource().getX()-i>=0; i++){
            if (getSource().offset(-i, -i) != null){
                list.add(getSource().offset(-i, -i));
            }
        }
        for (int i=1; i<= 7- getSource().getX(); i++){
            if(getSource().offset(i,-i) != null){
                list.add(getSource().offset(i,-i));
            }
        }
        for (int i=1; getSource().getX()-i>=0; i++){
            if (getSource().offset(-i, i) != null){
                list.add(getSource().offset(-i, i));
            }
        }
        return null;
    }
}
