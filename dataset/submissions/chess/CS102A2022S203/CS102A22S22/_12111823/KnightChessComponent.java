import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(char name, int x, int y) {
        this.name = name;
        this.setSource(x, y);
        if (name == 'N') {
            this.setChessColor(ChessColor.BLACK);
        } else {
            this.setChessColor(ChessColor.WHITE);
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>(5);
        ChessboardPoint s = this.getSource();
        int x = s.getX();
        int y = s.getY();
//        if (x > 1 && x < 6 && y > 1 && y < 6) {
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y - 1));
//        }
//        if (x < 2 && y > 1 && y < 6) {
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
//        }
//        if (x < 5 && y > 1 && y < 6) {
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y + 2));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y - 1));
//        }
//        if (x > 1 && x < 6 && y < 2) {
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y - 1));
//        }
//        if (x > 1 && x < 6 && y > 5) {
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x - 2, y - 1));
//        }
//        if(x<2&&y<2){
//            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
//            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
//        }
        if (x + 2 <= 7 && y + 1 <= 7) {
            chessboardPointList.add(new ChessboardPoint(x + 2, y + 1));
        }
        if (x + 2 <= 7 && y - 1 >= 0) {
            chessboardPointList.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (x - 2 >= 0 && y + 1 <= 7) {
            chessboardPointList.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            chessboardPointList.add(new ChessboardPoint(x - 2, y - 1));
        }
        if (x - 1 >= 0 && y + 2 <= 7) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (x + 1 <= 7 && y + 2 <= 7) {
            chessboardPointList.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y - 2));
        }
        if (x + 1 >= 0 && y - 2 >= 0) {
            chessboardPointList.add(new ChessboardPoint(x + 1, y - 2));
        }
        return chessboardPointList;
    }

}
