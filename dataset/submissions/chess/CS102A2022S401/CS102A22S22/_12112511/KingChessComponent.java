import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name) {
        super(name);
    }

    public KingChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = getSource().getX();
        int col = getSource().getY();
        ArrayList<ChessboardPoint> kingDest = new ArrayList<>();
        for (int x = 0;x<=7;x++){
            for (int y = 0;y<=7;y++){
                if (Math.abs(x-row)<=1 && Math.abs(y-col)<=1 && getChessBoard()[x][y].getName()=='_'){
                    kingDest.add(new ChessboardPoint(x,y));
                }else if (Math.abs(x-row)<=1 && Math.abs(y-col)<=1 && !getChessBoard()[x][y].getChessColor().equals(getChessColor())){
                    kingDest.add(new ChessboardPoint(x,y));
                }
            }
        }
        return kingDest;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
