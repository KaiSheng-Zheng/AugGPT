import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int x = getSource().getX();int y = getSource().getY();
        ChessColor chessColor = getChessColor();
        int i = 1;

        if (chessColor == ChessColor.WHITE) {
            while (x + i < 8 && y + i < 8) {
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                    break;
                } else if (chessboard[x + i][y + i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x - i > -1 && y - i > -1) {
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y - i));
                    break;
                } else if (chessboard[x - i][y - i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y - i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x + i < 8 && y - i > -1) {
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y - i));
                    break;
                } else if (chessboard[x + i][y - i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y - i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x - i > -1 && y + i < 8) {
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y + i));
                    break;
                } else if (chessboard[x - i][y + i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y + i));
                    i++;
                } else {
                    break;
                }
            }
        }
        else {
            while (x + i < 8 && y + i < 8) {
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.WHITE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                    break;
                } else if (chessboard[x + i][y + i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x - i > -1 && y - i > -1) {
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.WHITE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y - i));
                    break;
                } else if (chessboard[x - i][y - i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y - i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x + i < 8 && y - i > -1) {
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.WHITE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y - i));
                    break;
                } else if (chessboard[x + i][y - i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y - i));
                    i++;
                } else {
                    break;
                }
            }
            i = 1;
            while (x - i > -1 && y + i < 8) {
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.WHITE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y + i));
                    break;
                } else if (chessboard[x - i][y + i].getChessColor() == ChessColor.NONE) {
                    chessboardPointList.add(new ChessboardPoint(x - i, y + i));
                    i++;
                } else {
                    break;
                }
            }
        }
        chessboardPointList.sort(new SortByXY());
        return chessboardPointList;
    }

    public String toString(){
        if (getChessColor()==ChessColor.WHITE)return "b";
        else return "B";
    }
}
