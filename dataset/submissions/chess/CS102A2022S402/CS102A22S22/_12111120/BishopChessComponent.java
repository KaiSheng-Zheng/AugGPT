import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public ChessComponent[][] chessComponents;
    public BishopChessComponent() {
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
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean b = true;
                if (chessComponents[i][j].getChessColor() == chessComponents[x][y].getChessColor()) {
                    b = false;
                }else {
                    if (Math.abs(x - i) == Math.abs(y - j)){
                        for (int k = 1; k < Math.abs(y-j); k++) {
                            if (i > x && j > y){
                                if (!(chessComponents[x+k][y+k]  instanceof EmptySlotComponent)){
                                    b =  false;
                                }
                            }else if (i < x && j > y){
                                if (!(chessComponents[x-k][y+k]  instanceof EmptySlotComponent)){
                                    b =  false;
                                }
                            }else if (i > x && j < y){
                                if (!(chessComponents[x+k][y-k]  instanceof EmptySlotComponent)){
                                    b =  false;
                                }
                            }else {
                                if (!(chessComponents[x-k][y-k]  instanceof EmptySlotComponent)){
                                    b =  false;
                                }
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