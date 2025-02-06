import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public ChessComponent[][] chessComponents;
    public KnightChessComponent() {
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
                if (i == x || j == y){
                    b = false;
                }else {
                    if (chessComponents[i][j].getChessColor() == chessComponents[x][y].getChessColor()) {
                        b = false;
                    } else {
                        int sum = Math.abs(i - x) + Math.abs(j - y);
                        if (sum != 3) {
                            b = false;
                        }
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