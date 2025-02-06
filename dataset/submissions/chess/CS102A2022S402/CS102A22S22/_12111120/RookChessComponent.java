import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public ChessComponent[][] chessComponents;
    public RookChessComponent() {
        chessComponents = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                chessComponents[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                this.chessComponents[i][j] = chessComponents[i][j];
            }
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean b = true;
                if (chessComponents[i][j].getChessColor() == chessComponents[x][y].getChessColor()) {
                    b = false;
                } else {
                    if (x == i && y != j) {
                        for (int col = Math.min(y, j) + 1;
                             col < Math.max(y, j); col++) {
                            if (!(chessComponents[x][col] instanceof EmptySlotComponent)) {
                                b = false;
                                break;
                            }
                        }
                    } else if (y == j && x != i) {
                        for (int row = Math.min(x, i) + 1;
                             row < Math.max(x, i); row++) {
                            if (!(chessComponents[row][y] instanceof EmptySlotComponent)) {
                                b = false;
                                break;
                            }
                        }
                    }else {
                        b = false;
                    }
                }

                if (b){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }
}