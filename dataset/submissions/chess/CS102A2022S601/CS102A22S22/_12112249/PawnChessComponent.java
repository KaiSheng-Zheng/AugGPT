import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source) {
        this.setChessColor(chessColor);
        this.setSource(source);
        if (chessColor == ChessColor.BLACK) {
            name = 'P';
        }
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int chushiX = getSource().getX();
        int chushiY = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getChessColor() == ChessColor.BLACK) {
                    if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                        if (chushiX == 1 && chushiY == j) {
                            if (i == chushiX + 2 && chessboard[i - 1][chushiY].name=='_' && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                            if (i == chushiX + 1 && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                        }
                        if (chushiX != 1 && chushiY == j) {
                            if (i == chushiX + 1 && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                        }
                        if (i == chushiX+ 1 && Math.abs(chushiY - j) == 1 && chessboard[i][j].getChessColor() == ChessColor.WHITE) {
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                }
                if (this.getChessColor() == ChessColor.WHITE) {
                    if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                        if (chushiX == 6 && chushiY == j) {
                            if (i == chushiX - 2 && chessboard[i + 1][chushiY].name=='_' && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                            if (i == chushiX - 1 && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                        }
                        if (chushiX != 6 && chushiY == j) {
                            if (i == chushiX - 1 && chessboard[i][chushiY].name=='_') {
                                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                                chessboardPoints.add(chessboardPoint);
                            }
                        }
                        if (i == chushiX - 1 && Math.abs(chushiY - j) == 1 && chessboard[i][j].getChessColor() == ChessColor.BLACK) {
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                }
            }
        }
        return chessboardPoints;
    }

}
