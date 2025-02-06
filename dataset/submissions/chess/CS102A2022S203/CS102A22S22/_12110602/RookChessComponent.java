import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public RookChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackRook = new ArrayList();
        ArrayList<ChessboardPoint> WhiteRook = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'R') {
            int NorthCount = 0;
            int EastCount = 0;
            int SouthCount = 0;
            int WestCount = 0;

            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && Chess[x + i][y].name == '_') {
                    SouthCount++;
                }
                if (x + i <= 7 && Chess[x + i][y].name != '_') {
                    SouthCount = i;
                    break;
                }
            }
            if (SouthCount >= 2) {
                for (int i = 1; i < SouthCount; i++) {
                    BlackRook.add(new ChessboardPoint(x + i, y));
                }
                if (x + SouthCount <= 7 && Chess[x + SouthCount][y].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x + SouthCount, y));
                }
            } else if (SouthCount == 1) {
                if (Chess[x + 1][y].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x + 1, y));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (y + i <= 7 && Chess[x][y + 1].name == '_') {
                    EastCount++;
                }
                if (y + i <= 7 && Chess[x][y + i].name != '_') {
                    EastCount = i;
                    break;
                }
            }
            if (EastCount >= 2) {
                for (int i = 1; i < EastCount; i++) {
                    BlackRook.add(new ChessboardPoint(x, y + i));
                }
                if (y + EastCount <= 7 && Chess[x][y + EastCount].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x, y + EastCount));
                }
            } else if (EastCount == 1) {
                if (Chess[x][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x, y + 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && Chess[x - i][y].name == '_') {
                    NorthCount++;
                }
                if (x - i >= 0 && Chess[x - i][y].name != '_') {
                    NorthCount = i;
                    break;
                }
            }

            if (NorthCount >= 2) {
                for (int i = 1; i < NorthCount; i++) {
                    BlackRook.add(new ChessboardPoint(x - i, y));
                }
                if (x - NorthCount >= 0 && Chess[x - NorthCount][y].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x - NorthCount, y));
                }
            } else if (NorthCount == 1) {
                if (Chess[x - 1][y].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x - 1, y));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (y - i >= 0 && Chess[x][y - i].name == '_') {
                    WestCount++;
                }
                if (y - i >= 0 && Chess[x][y - i].name != '_') {
                    WestCount = i;
                    break;
                }
            }
            if (WestCount >= 2) {
                for (int i = 1; i < WestCount; i++) {
                    BlackRook.add(new ChessboardPoint(x, y - i));
                }
                if (y - WestCount >= 0 && Chess[x][y - WestCount].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x, y - WestCount));
                }
            } else if (WestCount == 1) {
                if (Chess[x][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackRook.add(new ChessboardPoint(x, y - 1));
                }
            }
        }

        if (name == 'r') {
            int NorthCount = 0;
            int EastCount = 0;
            int SouthCount = 0;
            int WestCount = 0;

            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && Chess[x + i][y].name == '_') {
                    SouthCount++;
                }
                if (x + i <= 7 && Chess[x + i][y].name != '_') {
                    SouthCount = i;
                    break;
                }
            }
            if (SouthCount >= 2) {
                for (int i = 1; i < SouthCount; i++) {
                    WhiteRook.add(new ChessboardPoint(x + i, y));
                }
                if (x + SouthCount <= 7 && Chess[x + SouthCount][y].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x + SouthCount, y));
                }
            } else if (SouthCount == 1) {
                if (Chess[x + 1][y].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x + 1, y));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (y + i <= 7 && Chess[x][y + i].name == '_') {
                    EastCount++;
                }
                if (y + i <= 7 && Chess[x][y + i].name != '_') {
                    EastCount = i;
                    break;
                }
            }
            if (EastCount >= 2) {
                for (int i = 1; i < EastCount; i++) {
                    WhiteRook.add(new ChessboardPoint(x, y + i));
                }
                if (y + EastCount <= 7 && Chess[x][y + EastCount].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x, y + EastCount));
                }
            } else if (EastCount == 1) {
                if (Chess[x][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x, y + 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && Chess[x - i][y].name == '_') {
                    NorthCount++;
                }
                if (x - i >= 0 && Chess[x - i][y].name != '_') {
                    NorthCount = i;
                    break;
                }
            }
            if (NorthCount >= 2) {
                for (int i = 1; i < NorthCount; i++) {
                    WhiteRook.add(new ChessboardPoint(x - i, y));
                }
                if (x - NorthCount >= 0 && Chess[x - NorthCount][y].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x - WestCount, y));
                }
            } else if (NorthCount == 1) {
                if (Chess[x - 1][y].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x - 1, y));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (y - i >= 0 && Chess[x][y - i].name == '_') {
                    WestCount++;
                }
                if (y - i >= 0 && Chess[x][y - i].name != '_') {
                    WestCount = i;
                    break;
                }
            }
            if (WestCount >= 2) {
                for (int i = 1; i < WestCount; i++) {
                    WhiteRook.add(new ChessboardPoint(x, y - i));
                }
                if (y - WestCount >= 0 && Chess[x][y - WestCount].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x, y - WestCount));
                }
            } else if (WestCount == 1) {
                if (Chess[x][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteRook.add(new ChessboardPoint(x, y - 1));
                }
            }
        }


        if (name == 'R') {
            return BlackRook;
        } else if (name == 'r') {
            return WhiteRook;
        } else {
            return new ArrayList<>();
        }
    }
}
