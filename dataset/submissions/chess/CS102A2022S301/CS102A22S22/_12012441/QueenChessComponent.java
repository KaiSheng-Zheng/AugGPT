import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    private final ChessboardPoint source;
    private final ChessColor chessColor;

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x=this.source.getX();
        int y=this.source.getY();
        for(int i=1;i<8;i++) {
            int dy = y - i;
            if (dy >= 0 && dy <= 7) {
                if (this.chessboard[x][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(x, dy));
                }
                if (this.chessboard[x][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//left
        for(int i=1;i<8;i++){
            int dy=y+i;
            if(dy>=0 && dy<=7) {
                if (this.chessboard[x][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(x, dy));
                }
                if (this.chessboard[x][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//right
        for(int i=1;i<8;i++) {
            int dx = x-i;
            if (dx >= 0 && dx <= 7) {
                if (this.chessboard[dx][y].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, y));
                }
                if (this.chessboard[dx][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//up
        for(int i=1;i<8;i++) {
            int dx = x+i;
            if (dx >= 0 && dx <= 7) {
                if (this.chessboard[dx][y].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, y));
                }
                if (this.chessboard[dx][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//down
        for(int i=1;i<8;i++) {
            int dx = x-i;
            int dy = y-i;
            if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                if (this.chessboard[dx][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, dy));
                }
                if (this.chessboard[dx][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//left-up
        for(int i=1;i<8;i++) {
            int dx = x+i;
            int dy = y-i;
            if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                if (this.chessboard[dx][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, dy));
                }
                if (this.chessboard[dx][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//left-down
        for(int i=1;i<8;i++) {
            int dx = x-i;
            int dy = y+i;
            if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                if (this.chessboard[dx][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, dy));
                }
                if (this.chessboard[dx][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//right-up
        for(int i=1;i<8;i++) {
            int dx = x+i;
            int dy = y+i;
            if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                if (this.chessboard[dx][dy].getChessColor() != this.chessColor) {
                    canMovePoints.add(new ChessboardPoint(dx, dy));
                }
                if (this.chessboard[dx][dy].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }//right-down
        return canMovePoints;
    }
}