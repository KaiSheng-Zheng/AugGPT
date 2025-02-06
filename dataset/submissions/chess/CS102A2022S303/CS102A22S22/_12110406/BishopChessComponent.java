
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointArrayList = new ArrayList<>();
        int X = this.getSource().getX();
        int Y = this.getSource().getY();
        for (int i = 1; i + X < 8 && i + Y < 8; i++) {
            if (chessComponents[X + i][Y + i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X + i, Y + i));
            }
            else if (chessComponents[X + i][Y + i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X + i][Y + i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X + i, Y + i));
                break;
            }
        }
        for (int i = 1; X - i >= 0 && Y - i >= 0; i++) {
            if (chessComponents[X - i][Y - i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X - i, Y - i));
            }
            else if (chessComponents[X - i][Y - i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X - i][Y - i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X - i, Y - i));
                break;
            }
        }
        for (int i = 1; X - i >= 0 && Y + i < 8; i++) {
            if (chessComponents[X - i][Y + i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X - i, Y + i));
            }
            else if (chessComponents[X - i][Y + i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X - i][Y + i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X - i, Y + i));
                break;
            }
        }
        for (int i = 1; X + i < 8 && Y - i >= 0; i++) {
            if (chessComponents[X + i][Y - i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X + i, Y - i));
            }
            else if (chessComponents[X + i][Y - i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X + i][Y - i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X + i, Y - i));
                break;
            }
        }
//        if (chessboardPointArrayList.size() == 0) {
//            return chessboardPointArrayList;
//        }
//        else if (chessboardPointArrayList.size() == 1) {
//            return chessboardPointArrayList;
//        } else {
//            int k;
//            for (int i = 0; i < chessboardPointArrayList.size() - 1; i++) {
//                k = i;
//                for (int j = i + 1; j < chessboardPointArrayList.size(); j++) {
//                    if (chessboardPointArrayList.get(j).getX() < chessboardPointArrayList.get(k).getX()) {
//                        k = j;
//                        ChessboardPoint C = chessboardPointArrayList.get(k);
//                        if (k != i) {
//                            chessboardPointArrayList.set(k, chessboardPointArrayList.get(i));
//                            chessboardPointArrayList.set(i, C);
//                        }
//                    }
//                    if (chessboardPointArrayList.get(j).getX() == chessboardPointArrayList.get(k).getX()) {
//                        if (chessboardPointArrayList.get(j).getY() < chessboardPointArrayList.get(k).getY()) {
//                            k = j;
//                            ChessboardPoint C = chessboardPointArrayList.get(k);
//                            if (k != i) {
//                                chessboardPointArrayList.set(k, chessboardPointArrayList.get(i));
//                                chessboardPointArrayList.set(i, C);
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return chessboardPointArrayList;
    }
}
