import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name) {
        super(name);
    }

    public KnightChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        //find points on the ChessBoard, and add them to the List
        ArrayList<ChessboardPoint> knightDest = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (Math.abs(x-row)==1 && Math.abs(y-col)==2 && getChessBoard()[x][y].getName()=='_'){
                    knightDest.add(new ChessboardPoint(x,y));
                }else if (Math.abs(x-row)==2 && Math.abs(y-col)==1 && getChessBoard()[x][y].getName()=='_'){
                    knightDest.add(new ChessboardPoint(x,y));
                }else if (Math.abs(x-row)==1 && Math.abs(y-col)==2 && !getChessBoard()[x][y].getChessColor().equals(getChessColor())){
                    knightDest.add(new ChessboardPoint(x,y));
                }else if (Math.abs(x-row)==2 && Math.abs(y-col)==1 && !getChessBoard()[x][y].getChessColor().equals(getChessColor())){
                    knightDest.add(new ChessboardPoint(x,y));
                }
            }
        }
        return knightDest;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
