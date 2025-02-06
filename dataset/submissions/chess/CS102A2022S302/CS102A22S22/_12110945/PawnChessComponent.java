import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetP = super.getTarget();

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name,target);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> PawnCanMoveTo =new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK) {
            if (x == 1) {
                PawnCanMoveTo.add(new ChessboardPoint(x + 1, y));
                if(targetP[x+1][y].getChessColor()!=ChessColor.NONE){
                    PawnCanMoveTo.remove(new ChessboardPoint(x + 1, y));
                }
                PawnCanMoveTo.add(new ChessboardPoint(x + 2, y));
                if(targetP[x+1][y].getChessColor()!=ChessColor.NONE||targetP[x+2][y].getChessColor()!=ChessColor.NONE){
                    PawnCanMoveTo.remove(new ChessboardPoint(x + 2, y));
                }
            }
            if (x != 1) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        int a = i - x;
                        if (a == 1 && y == j) {
                            PawnCanMoveTo.add(new ChessboardPoint(i, j));
                            if (targetP[i][j].getChessColor() != ChessColor.NONE) {
                                PawnCanMoveTo.remove(new ChessboardPoint(i, j));
                            }
                        }
                        if (targetP[i][j].getChessColor() != super.getChessColor() && targetP[i][j].getChessColor() != ChessColor.NONE && i == x + 1 && Math.abs(y - j) == 1) {
                            PawnCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        if (super.getChessColor()==ChessColor.WHITE){
            if (x == 6) {
                PawnCanMoveTo.add(new ChessboardPoint(x -1, y));
                if(targetP[x-1][y].getChessColor()!=ChessColor.NONE){
                    PawnCanMoveTo.remove(new ChessboardPoint(x - 1, y));
                }
                PawnCanMoveTo.add(new ChessboardPoint(x -2, y));
                if(targetP[x-1][y].getChessColor()!=ChessColor.NONE||targetP[x-2][y].getChessColor()!=ChessColor.NONE){
                    PawnCanMoveTo.remove(new ChessboardPoint(x - 2, y));
                }
            }
            if (x != 6) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        int a = x-i;
                        if (a == 1 && y == j) {
                            PawnCanMoveTo.add(new ChessboardPoint(i, j));
                            if (targetP[i][j].getChessColor() != ChessColor.NONE) {
                                PawnCanMoveTo.remove(new ChessboardPoint(i, j));
                            }
                        }
                        if (targetP[i][j].getChessColor() != super.getChessColor() && targetP[i][j].getChessColor() != ChessColor.NONE && i == x - 1 && Math.abs(y - j) == 1) {
                            PawnCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return PawnCanMoveTo;
    }
}

