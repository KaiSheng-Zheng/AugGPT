import java.util.ArrayList;
import java.util.List;

class PawnChessComponent extends ChessComponent {
    private static int cntwhite = 0;
    private static int cntblack = 0;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessboard = ConcreteChessGame.cb;
        if (super.getColor() == ChessColor.BLACK){
            if (x == 1){
                if (chessboard[2][y].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(2,y));
                    if (chessboard[3][y].getColor() == ChessColor.NONE){
                        points.add(new ChessboardPoint(3,y));
                    }
                }if (isValid(y-1) && chessboard[2][y - 1].getColor() == ChessColor.WHITE){
                    points.add(new ChessboardPoint(2,y - 1));
                }if (isValid(y+1) && chessboard[2][y + 1].getColor() == ChessColor.WHITE){
                    points.add(new ChessboardPoint(2,y + 1));
                }
            }else{
                if (chessboard[x + 1][y].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x + 1,y));}
                if (isValid(y-1) && chessboard[x+1][y - 1].getColor() == ChessColor.WHITE){
                    points.add(new ChessboardPoint(x+1,y - 1));
                }if (isValid(y+1) && chessboard[x+1][y + 1].getColor() == ChessColor.WHITE){
                    points.add(new ChessboardPoint(x+1,y + 1));
                }
            }

        }
        if (super.getColor() == ChessColor.WHITE){
            if (x == 6){
                if (chessboard[5][y].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(5,y));
                }if (chessboard[4][y].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(4,y));
                }if (isValid(y-1) && chessboard[5][y - 1].getColor() == ChessColor.BLACK){
                    points.add(new ChessboardPoint(5,y - 1));
                }if (isValid(y+1) && chessboard[5][y + 1].getColor() == ChessColor.BLACK){
                    points.add(new ChessboardPoint(5,y + 1));
                }
            }else{
                if (chessboard[x - 1][y].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x - 1,y));
                }if (isValid(y-1) && chessboard[x-1][y - 1].getColor() == ChessColor.BLACK){
                    points.add(new ChessboardPoint(x-1,y - 1));
                }if (isValid(y+1) && chessboard[x-1][y + 1].getColor() == ChessColor.BLACK){
                    points.add(new ChessboardPoint(x+1,y + 1));
                }
            }
        }
        return points;
    }
    public PawnChessComponent(ChessColor chessColor){
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

    @Override
    public void cleanup() {
        cntwhite = 0;
        cntblack = 0;
    }
    @Override
    public void beEaten() {
        if (super.getColor() == ChessColor.BLACK){
            cntblack--;
        }else{
            cntwhite--;
        }
    }
}
