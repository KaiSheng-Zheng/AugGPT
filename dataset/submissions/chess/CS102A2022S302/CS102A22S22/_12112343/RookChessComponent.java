import java.util.*;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        if(col != 0) {
            for (int i = col - 1; i >= 0; i--) {
                if (chessComponents[row][i].getChessColor() != this.getChessColor()) {
                    if (chessComponents[row][i].getChessColor() == ChessColor.NONE) {
                        result.add(new ChessboardPoint(row, i));
                    } else {
                        result.add(new ChessboardPoint(row, i));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if(col != 7) {
            for (int i = col + 1; i <= 7; i++) {
                if (chessComponents[row][i].getChessColor() != this.getChessColor()) {
                    if (chessComponents[row][i].getChessColor() == ChessColor.NONE) {
                        result.add(new ChessboardPoint(row, i));
                    } else {
                        result.add(new ChessboardPoint(row, i));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if(row != 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (chessComponents[i][col].getChessColor() != this.getChessColor()) {
                    if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                        result.add(new ChessboardPoint(i, col));
                    } else {
                        result.add(new ChessboardPoint(i, col));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if(row != 7) {
            for (int i = row + 1; i <= 7; i++) {
                if (chessComponents[i][col].getChessColor() != this.getChessColor()) {
                    if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                        result.add(new ChessboardPoint(i, col));
                    } else {
                        result.add(new ChessboardPoint(i, col));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
