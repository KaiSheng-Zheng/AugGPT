import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessColor color,ChessboardPoint cp,char name){
        this.chessColor = color;
        this.source = cp;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == source.getX() && j != source.getY()){
                    boolean canMove = true;
                    int smaller = Math.min(source.getY(), j);
                    int bigger = Math.max(source.getY(),j);
                    for (int k = smaller + 1; k < bigger ; k++) {
                        if (chessComponent[source.getX()][k].getChessColor() != ChessColor.NONE){
                            canMove = false;
                        }
                    }
                    if (chessComponent[i][j].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor() & canMove == true) {
                        a.add(new ChessboardPoint(i, j));
                    }
                }
                if (i != source.getX() && j == source.getY()){
                    boolean canMove = true;
                    int smaller = Math.min(source.getX(),i);
                    int bigger = Math.max(source.getX(),i);
                    for (int k = smaller + 1; k < bigger ; k++) {
                        if (chessComponent[k][source.getY()].getChessColor() != ChessColor.NONE){
                            canMove = false;
                        }
                    }
                    if (chessComponent[i][j].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor() & canMove == true) {
                        a.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }

        return a;
    }
}
