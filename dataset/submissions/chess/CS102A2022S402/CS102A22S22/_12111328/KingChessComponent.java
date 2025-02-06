import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x >= -1 && x < 7 && y >= 0 && y < 8) {
            if (ConcreteChessGame.getChessComponents1()[x + 1][y].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x + 1, y));
            }
        }
        if (x >= 1 && x < 9 && y >= 0 && y < 8) {
            if (ConcreteChessGame.getChessComponents1()[x - 1][y].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x - 1, y));
            }
        }
        if (x >= 0 && x < 8 && y > -1 && y < 7) {
            if (ConcreteChessGame.getChessComponents1()[x][y + 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (x >= 0 && x < 8 && y >= 1 && y < 9) {
            if (ConcreteChessGame.getChessComponents1()[x][y - 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x, y - 1));
            }
        }
        if (x >= -1 && x < 7 && y >= -1 && y < 7) {
            if (ConcreteChessGame.getChessComponents1()[x + 1][y + 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x + 1, y + 1));
            }
        }
        if (x > -1 && x < 7 && y >= 1 && y < 9){
            if (ConcreteChessGame.getChessComponents1()[x + 1][y - 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x + 1, y - 1));
            }
    }
        if(x>=1&&x<9&&y>=-1&&y<7) {
            if (ConcreteChessGame.getChessComponents1()[x - 1][y + 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        if(x>=1&&x<9&&y>=1&&y<9) {
            if (ConcreteChessGame.getChessComponents1()[x - 1][y - 1].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        return chess;
    }


    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}