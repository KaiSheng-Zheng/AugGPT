import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public BishopChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackBishop = new ArrayList();
        ArrayList<ChessboardPoint> WhiteBishop = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'B') {
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
                    BlackBishop.add(new ChessboardPoint(x + i, y + i));
                }
                if (x + SouthEasternCount <= 7 && y + SouthEasternCount <= 7 && Chess[x + SouthEasternCount][y + SouthEasternCount].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x + SouthEasternCount, y + SouthEasternCount));
                }
            } else if (SouthEasternCount == 1) {
                if (Chess[x + 1][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x + 1, y + 1));
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
                    BlackBishop.add(new ChessboardPoint(x + i, y - i));
                }
                if (x + SouthWesternCount <= 7 && y - SouthWesternCount >= 0 && Chess[x + SouthWesternCount][y - SouthWesternCount].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x + SouthWesternCount, y - SouthWesternCount));
                }
            } else if (SouthWesternCount == 1) {
                if (Chess[x + 1][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x + 1, y - 1));
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
                    BlackBishop.add(new ChessboardPoint(x - i, y - i));
                }
                if (x - NorthWesternCount >= 0 && y - NorthWesternCount >= 0 && Chess[x - NorthWesternCount][y - NorthWesternCount].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x - NorthWesternCount, y - NorthWesternCount));
                }
            } else if (NorthWesternCount == 1) {
                if (Chess[x - 1][y - 1].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x - 1, y - 1));
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
                    BlackBishop.add(new ChessboardPoint(x - i, y + i));
                }
                if (x - NorthEasternCount >= 0 && y + NorthEasternCount <= 7 && Chess[x - NorthEasternCount][y + NorthEasternCount].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x - NorthEasternCount, y + NorthEasternCount));
                }
            } else if (NorthEasternCount == 1) {
                if (Chess[x - 1][y + 1].getChessColor() != ChessColor.BLACK) {
                    BlackBishop.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }

        if (name == 'b') {
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
                    WhiteBishop.add(new ChessboardPoint(x + i, y + i));
                }
                if (x + SouthEasternCount <= 7 && y + SouthEasternCount <= 7 && Chess[x + SouthEasternCount][y + SouthEasternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x + SouthEasternCount, y + SouthEasternCount));
                }
            } else if (SouthEasternCount == 1) {
                if (Chess[x + 1][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x + 1, y + 1));
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
                    WhiteBishop.add(new ChessboardPoint(x + i, y - i));
                }
                if (x + SouthWesternCount <= 7 && y - SouthWesternCount >= 0 && Chess[x + SouthWesternCount][y - SouthWesternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x + SouthWesternCount, y - SouthWesternCount));
                }
            } else if (SouthWesternCount == 1) {
                if (Chess[x + 1][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x + 1, y - 1));
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
                    WhiteBishop.add(new ChessboardPoint(x - i, y - i));
                }
                if (x - NorthWesternCount >= 0 && y - NorthWesternCount >= 0 && Chess[x - NorthWesternCount][y - NorthWesternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x - NorthWesternCount, y - NorthWesternCount));
                }
            } else if (NorthWesternCount == 1) {
                if (Chess[x - 1][y - 1].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x - 1, y - 1));
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
                    WhiteBishop.add(new ChessboardPoint(x - i, y + i));
                }
                if (x - NorthEasternCount >= 0 && y + NorthEasternCount <= 7 && Chess[x - NorthEasternCount][y + NorthEasternCount].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x - NorthEasternCount, y + NorthEasternCount));
                }
            } else if (NorthEasternCount == 1) {
                if (Chess[x - 1][y + 1].getChessColor() != ChessColor.WHITE) {
                    WhiteBishop.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }

        if (name == 'B') {
            return BlackBishop;
        } else if (name == 'b') {
            return WhiteBishop;
        } else {
            return new ArrayList<>();
        }
    }
}
