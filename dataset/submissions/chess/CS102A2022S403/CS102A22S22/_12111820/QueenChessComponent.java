import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor color, ChessboardPoint cp, char name) {
        this.chessColor = color;
        this.source = cp;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = source.getX() - 1; Math.abs(i - source.getX()) < 8 && i >= 0; i--) {
            if (chessComponent[i][source.getY()].getChessColor() == getChessColor()) {
                break;
            }
            if (chessComponent[i][source.getY()].getChessColor() != getChessColor() && chessComponent[i][source.getY()].getChessColor() != ChessColor.NONE) {
                a.add(new ChessboardPoint(i, source.getY()));
                break;
            }
            if (chessComponent[i][source.getY()].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(i, source.getY()));
            }
        }
        for (int i = source.getX() + 1; Math.abs(i - source.getX()) >= 0 && i < 8; i++) {
            if (chessComponent[i][source.getY()].getChessColor() == getChessColor()) {
                break;
            }
            if (chessComponent[i][source.getY()].getChessColor() != getChessColor() && chessComponent[i][source.getY()].getChessColor() != ChessColor.NONE) {
                a.add(new ChessboardPoint(i, source.getY()));
                break;
            }
            if (chessComponent[i][source.getY()].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(i, source.getY()));
            }
        }
        for (int j = source.getY() - 1; j >= 0; j--) {
            if (chessComponent[source.getX()][j].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(source.getX(), j));
            } else {
                if (chessComponent[source.getX()][j].getChessColor() == getChessColor()) {
                    break;
                }
                if (chessComponent[source.getX()][j].getChessColor() != getChessColor()) {
                    a.add(new ChessboardPoint(source.getX(), j));
                    break;
                }
            }
        }
        for (int j = source.getY() + 1; j < 8; j++) {
            if (chessComponent[source.getX()][j].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(source.getX(), j));
            } else {
                if (chessComponent[source.getX()][j].getChessColor() == getChessColor()) {
                    break;
                }
                if (chessComponent[source.getX()][j].getChessColor() != getChessColor()) {
                    a.add(new ChessboardPoint(source.getX(), j));
                    break;
                }
            }
        }

        boolean can1 = true;
        for (int i = source.getX() - 1; source.getX() - i >= 0 && i >= 0; i--) {
            if (can1 == true){
                for (int j = source.getY() + 1; j - source.getY() < 8 && j < 8; j++) {
                    if (Math.abs(source.getX() - i) == Math.abs(source.getY() - j)) {
                        if (chessComponent[i][j].getChessColor() == getChessColor()) {
                            can1 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() != getChessColor() && chessComponent[i][j].getChessColor() != ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                            can1 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() == ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }

        
        boolean can2 = true;
        for (int i = source.getX() + 1; i - source.getX() < 8 && i < 8; i++) {
            if (can2 == true){
                for (int j = source.getY() + 1; j - source.getY() < 8 && j < 8; j++) {
                    if (Math.abs(source.getX() - i) == Math.abs(source.getY() - j)) {
                        if (chessComponent[i][j].getChessColor() == getChessColor()) {
                            can2 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() != getChessColor() && chessComponent[i][j].getChessColor() != ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                            can2 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() == ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
       
        boolean can3 = true;
        for (int i = source.getX() - 1; source.getX() - i >= 0 && i >= 0; i--) {
            if (can3 == true){
                for (int j = source.getY() - 1; source.getY() - j >= 0 && j >= 0; j--) {
                    if (Math.abs(source.getX() - i) == Math.abs(source.getY() - j)) {
                        if (chessComponent[i][j].getChessColor() == getChessColor()) {
                            can3 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() != getChessColor() && chessComponent[i][j].getChessColor() != ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                            can3 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() == ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }

        
        boolean can4 = true;
        for (int i = source.getX() + 1; i - source.getX() < 8 && i < 8; i++) {
            if (can4 == true){
                for (int j = source.getY() - 1; source.getY() - j >= 0 && j >= 0; j--) {
                    if (Math.abs(source.getX() - i) == Math.abs(source.getY() - j)) {
                        if (chessComponent[i][j].getChessColor() == getChessColor()) {
                            can4 = false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() != getChessColor() && chessComponent[i][j].getChessColor() != ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                            can4 =false;
                            break;
                        }
                        if (chessComponent[i][j].getChessColor() == ChessColor.NONE) {
                            a.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }



        return a;
    }
}
