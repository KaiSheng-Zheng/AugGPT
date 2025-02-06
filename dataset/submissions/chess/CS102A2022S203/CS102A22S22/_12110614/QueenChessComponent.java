import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public QueenChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackQueen = new ArrayList();
        ArrayList<ChessboardPoint> WhiteQueen = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'Q') {
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
                    BlackQueen.add(new ChessboardPoint(x + i, y));
                }
                if (x + SouthCount <= 7 && Chess[x + SouthCount][y].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + SouthCount, y));
                }
            } else if (SouthCount == 1) {
                if (Chess[x + 1][y].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + 1, y));
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
                    BlackQueen.add(new ChessboardPoint(x, y + i));
                }
                if (y + EastCount <= 7 && Chess[x][y + EastCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x, y + EastCount));
                }
            } else if (EastCount == 1) {
                if (Chess[x][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x, y + 1));
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
                    BlackQueen.add(new ChessboardPoint(x - i, y));
                }
                if (x - NorthCount >= 0 && Chess[x - NorthCount][y].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - NorthCount, y));
                }
            } else if (NorthCount == 1) {
                if (Chess[x - 1][y].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - 1, y));
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
                    BlackQueen.add(new ChessboardPoint(x, y - i));
                }
                if (y - WestCount >= 0 && Chess[x][y - WestCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x, y - WestCount));
                }
            } else if (WestCount == 1) {
                if (Chess[x][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x, y - 1));
                }
            }

            int NorthEasternCount = 0;
            int SouthEasternCount = 0;
            int SouthWesternCount = 0;
            int NorthWesternCount = 0;

            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && y + i <= 7 && Chess[x + i][y + i].name == '_') {
                    SouthEasternCount++;
                }
                if (x + i <= 7 && y + i <= 7 && Chess[x + i][y + i].name != '_') {
                    SouthEasternCount = i;
                    break;
                }
            }
            if (SouthEasternCount >= 2) {
                for (int i = 1; i < SouthEasternCount; i++) {
                    BlackQueen.add(new ChessboardPoint(x + i, y + i));
                }
                if (x + SouthEasternCount <= 7 && y + SouthEasternCount <= 7 && Chess[x + SouthEasternCount][y + SouthEasternCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + SouthEasternCount, y + SouthEasternCount));
                }
            } else if (SouthEasternCount == 1) {
                if (Chess[x + 1][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + 1, y + 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && y - i >= 0 && Chess[x + i][y - i].name == '_') {
                    SouthWesternCount++;
                }
                if (x + i <= 7 && y - i >= 0 && Chess[x + i][y - i].name != '_') {
                    SouthWesternCount = i;
                    break;
                }
            }
            if (SouthWesternCount >= 2) {
                for (int i = 1; i < SouthWesternCount; i++) {
                    BlackQueen.add(new ChessboardPoint(x + i, y - i));
                }
                if (x + SouthWesternCount <= 7 && y - SouthWesternCount >= 0 && Chess[x + SouthWesternCount][y - SouthWesternCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + SouthWesternCount, y - SouthWesternCount));
                }
            } else if (SouthWesternCount == 1) {
                if (Chess[x + 1][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x + 1, y - 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && y - i >= 0 && Chess[x - i][y - i].name == '_') {
                    NorthWesternCount++;
                }
                if (x - i >= 0 && y - i >= 0 && Chess[x - i][y - i].name != '_') {
                    NorthWesternCount = i;
                    break;
                }
            }
            if (NorthWesternCount >= 2) {
                for (int i = 1; i < NorthWesternCount; i++) {
                    BlackQueen.add(new ChessboardPoint(x - i, y - i));
                }
                if (x - NorthWesternCount >= 0 && y - NorthWesternCount >= 0 && Chess[x - NorthWesternCount][y - NorthWesternCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - NorthWesternCount, y - NorthWesternCount));
                }
            } else if (NorthWesternCount == 1) {
                if (Chess[x - 1][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - 1, y - 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && y + i <= 7 && Chess[x - i][y + i].name == '_') {
                    NorthEasternCount++;
                }
                if (x - i >= 0 && y + i <= 7 && Chess[x - i][y + i].name != '_') {
                    NorthEasternCount = i;
                    break;
                }
            }
            if (NorthEasternCount >= 2) {
                for (int i = 1; i < NorthEasternCount; i++) {
                    BlackQueen.add(new ChessboardPoint(x - i, y + i));
                }
                if (x - NorthEasternCount >= 0 && y + NorthEasternCount <= 7 && Chess[x - NorthEasternCount][y + NorthEasternCount].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - NorthEasternCount, y + NorthEasternCount));
                }
            } else if (NorthEasternCount == 1) {
                if (Chess[x - 1][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackQueen.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }

        if (name == 'q') {
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
                    WhiteQueen.add(new ChessboardPoint(x + i, y));
                }
                if (x + SouthCount <= 7 && Chess[x + SouthCount][y].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + SouthCount, y));
                }
            } else if (SouthCount == 1) {
                if (Chess[x + 1][y].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + 1, y));
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
                    WhiteQueen.add(new ChessboardPoint(x, y + i));
                }
                if (y + EastCount <= 7 && Chess[x][y + EastCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x, y + EastCount));
                }
            } else if (EastCount == 1) {
                if (Chess[x][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x, y + 1));
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
                    WhiteQueen.add(new ChessboardPoint(x - i, y));
                }
                if (x - NorthCount >= 0 && Chess[x - NorthCount][y].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - WestCount, y));
                }
            } else if (NorthCount == 1) {
                if (Chess[x - 1][y].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - 1, y));
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
                    WhiteQueen.add(new ChessboardPoint(x, y - i));
                }
                if (y - WestCount >= 0 && Chess[x][y - WestCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x, y - WestCount));
                }
            } else if (WestCount == 1) {
                if (Chess[x][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x, y - 1));
                }
            }


            int NorthEasternCount = 0;
            int SouthEasternCount = 0;
            int SouthWesternCount = 0;
            int NorthWesternCount = 0;

            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && y + i <= 7 && Chess[x + i][y + i].name == '_') {
                    SouthEasternCount++;
                }
                if (x + i <= 7 && y + i <= 7 && Chess[x + i][y + i].name != '_') {
                    SouthEasternCount = i;
                    break;
                }
            }
            if (SouthEasternCount >= 2) {
                for (int i = 1; i < SouthEasternCount; i++) {
                    WhiteQueen.add(new ChessboardPoint(x + i, y + i));
                }
                if (x + SouthEasternCount <= 7 && y + SouthEasternCount <= 7 && Chess[x + SouthEasternCount][y + SouthEasternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + SouthEasternCount, y + SouthEasternCount));
                }
            } else if (SouthEasternCount == 1) {
                if (Chess[x + 1][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + 1, y + 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x + i <= 7 && y - i >= 0 && Chess[x + i][y - i].name == '_') {
                    SouthWesternCount++;
                }
                if (x + i <= 7 && y - i >= 0 && Chess[x + i][y - i].name != '_') {
                    SouthWesternCount = i;
                    break;
                }
            }
            if (SouthWesternCount >= 2) {
                for (int i = 1; i < SouthWesternCount; i++) {
                    WhiteQueen.add(new ChessboardPoint(x + i, y - i));
                }
                if (x + SouthWesternCount <= 7 && y - SouthWesternCount >= 0 && Chess[x + SouthWesternCount][y - SouthWesternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + SouthWesternCount, y - SouthWesternCount));
                }
            } else if (SouthWesternCount == 1) {
                if (Chess[x + 1][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x + 1, y - 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && y - i >= 0 && Chess[x - i][y - i].name == '_') {
                    NorthWesternCount++;
                }
                if (x - i >= 0 && y - i >= 0 && Chess[x - i][y - i].name != '_') {
                    NorthWesternCount = i;
                    break;
                }
            }
            if (NorthWesternCount >= 2) {
                for (int i = 1; i < NorthWesternCount; i++) {
                    WhiteQueen.add(new ChessboardPoint(x - i, y - i));
                }
                if (x - NorthWesternCount >= 0 && y - NorthWesternCount >= 0 && Chess[x - NorthWesternCount][y - NorthWesternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - NorthWesternCount, y - NorthWesternCount));
                }
            } else if (NorthWesternCount == 1) {
                if (Chess[x - 1][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - 1, y - 1));
                }
            }


            for (int i = 1; i <= 7; i++) {
                if (x - i >= 0 && y + i <= 7 && Chess[x - i][y + i].name == '_') {
                    NorthEasternCount++;
                }
                if (x - i >= 0 && y + i <= 7 && Chess[x - i][y + i].name != '_') {
                    NorthEasternCount = i;
                    break;
                }
            }
            if (NorthEasternCount >= 2) {
                for (int i = 1; i < NorthEasternCount; i++) {
                    WhiteQueen.add(new ChessboardPoint(x - i, y + i));
                }
                if (x - NorthEasternCount >= 0 && y + NorthEasternCount <= 7 && Chess[x - NorthEasternCount][y + NorthEasternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - NorthEasternCount, y + NorthEasternCount));
                }
            } else if (NorthEasternCount == 1) {
                if (Chess[x - 1][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteQueen.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }



        if (name == 'Q') {
            return BlackQueen;
        } else if (name == 'q') {

            return WhiteQueen;
        } else {
            return new ArrayList<>();
        }
    }
}
