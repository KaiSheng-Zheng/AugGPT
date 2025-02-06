import java.util.ArrayList;
import java.util.List;
//maybe competely done
public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }
    public PawnChessComponent(char name) {
        super(name);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if (name=='p'){
              if (x > 0&&x!=6) {
                if (chessComponents[x - 1][y].name == '_') {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x - 1][y - 1].name <='Z') {
                        move.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x - 1][y + 1].name <='Z') {
                        move.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
            } else if (x == 6) {
                if (chessComponents[5][y].name == '_') {
                    move.add(new ChessboardPoint(5, y));
                    if (chessComponents[4][y].name == '_') {
                        move.add(new ChessboardPoint(4, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[5][y - 1].name <='Z') {
                        move.add(new ChessboardPoint(5, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[5][y + 1].name <='Z') {
                        move.add(new ChessboardPoint(5, y + 1));
                    }
                }
            }
        }
        if (name == 'P') {
            if (x < 7&&x!=1) {
                if (chessComponents[x + 1][y].name == '_') {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x + 1][y - 1].name >= 'a') {
                        move.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x + 1][y + 1].name >= 'a') {
                        move.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            } else if (x == 1){
                if (chessComponents[2][y].name == '_') {
                    move.add(new ChessboardPoint(2, y));
                    if (chessComponents[3][y].name == '_') {
                        move.add(new ChessboardPoint(3, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[2][y - 1].name >= 'a') {
                        move.add(new ChessboardPoint(2, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[2][y + 1].name >= 'a') {
                        move.add(new ChessboardPoint(2, y + 1));
                    }
                }
            }
        }
        return move;
    }
}