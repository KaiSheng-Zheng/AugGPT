import java.util.ArrayList;
import java.util.List;

class KnightChessComponent extends ChessComponent {
    private static int cntwhite = 0;
    private static int cntblack = 0;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessboard = ConcreteChessGame.cb;
        for (int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if(i != x || j != y){
                    if (isValid(i) && isValid(j)){
                        if (chessboard[i][j].getColor() != super.getColor() && Math.abs(i - x) * Math.abs(j - y) == 2){
                            points.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return points;
    }

    @Override
    public void beEaten() {
        if (super.getColor() == ChessColor.BLACK){
            cntblack--;
        }else{
            cntwhite--;
        }
    }

    @Override
    public void cleanup() {
        cntwhite = 0;
        cntblack = 0;
    }

    public KnightChessComponent(ChessColor chessColor){
        super(chessColor);
        if(chessColor == ChessColor.BLACK)
            cntblack++;
        if (chessColor == ChessColor.WHITE)
            cntwhite++;
    }

    public static int getCntblack() {
        return cntblack;
    }
    public static int getCntwhite() {
        return cntwhite;
    }
}
