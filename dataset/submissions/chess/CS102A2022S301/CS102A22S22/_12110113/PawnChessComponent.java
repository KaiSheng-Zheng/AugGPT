import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, int i, int j,char name) {
        super (chessColor,i,j,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canList = new ArrayList<>();
            if (x==1&&this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[2][y].name == '_') {
                    canList.add(new ChessboardPoint(2,y));

                if (chessboard[3][y].name == '_') {
                    canList.add(new ChessboardPoint(3,y));
                }
                }
                if (y+1<8&&canEat(2, y + 1)) {
                    canList.add(new ChessboardPoint(2,y+1));
                }
                if (y-1>=0&&canEat(2, y - 1)) {
                    canList.add(new ChessboardPoint(2,y-1));
                }
            }
            else if (x==6&&this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[5][y].name == '_') {
                    canList.add(new ChessboardPoint(5, y));

                    if (chessboard[4][y].name == '_') {
                        canList.add(new ChessboardPoint(4, y));
                    }
                }
                    if (y + 1 < 8 && canEat(5, y + 1)) {
                        canList.add(new ChessboardPoint(5, y + 1));
                    }
                    if (y - 1 >= 0 && canEat(5, y - 1)) {
                        canList.add(new ChessboardPoint(5, y - 1));
                    }
                }

            else {
            if (this.getChessColor() == ChessColor.BLACK) {
                if (x + 1 < 8) {
                    if (chessboard[x + 1][y].name == '_') {
                        canList.add(new ChessboardPoint(x + 1, y));
                    }
                    if (y + 1 < 8 && canEat(x + 1, y + 1)) {
                        canList.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (y - 1 >= 0 && canEat(x + 1, y - 1)) {
                        canList.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
            }
                else {
                   if (x-1>=0){
                        if (chessboard[x - 1][y].name == '_') {
                            canList.add(new ChessboardPoint(x-1,y));
                        }
                        if (y+1<8&&canEat(x - 1, y + 1)) {
                            canList.add(new ChessboardPoint(x-1,y+1));
                        }
                        if (y-1>=0&&canEat(x - 1, y - 1)) {
                            canList.add(new ChessboardPoint(x-1,y-1));
                        }
                    }
                }
            }
        
                return canList;
            }


}

