import java.util.ArrayList;
import java.util.List;

class BishopChessComponent extends ChessComponent {
    private static int cntwhite = 0;
    private static int cntblack = 0;
    @Override
    public void cleanup() {
        cntwhite = 0;
        cntblack = 0;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessboard = ConcreteChessGame.cb;
        for (int i = 1; i < 8;i++){
            if(isValid(x + i) && isValid(y + i)){
                if(chessboard[x+i][y+i].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x+i,y+i));
                }else{
                    if(chessboard[x+i][y+i].getColor() != super.getColor()){
                        points.add(new ChessboardPoint(x+i,y+i));
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < 8;i++){
            if(isValid(x + i) && isValid(y - i)){
                if(chessboard[x+i][y-i].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x+i,y-i));
                }else{
                    if(chessboard[x+i][y-i].getColor() != super.getColor()){
                        points.add(new ChessboardPoint(x+i,y-i));
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < 8;i++){
            if(isValid(x - i) && isValid(y + i)){
                if(chessboard[x-i][y+i].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x-i,y+i));
                }else{
                    if(chessboard[x-i][y+i].getColor() != super.getColor()){
                        points.add(new ChessboardPoint(x-i,y+i));
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < 8;i++){
            if(isValid(x - i) && isValid(y - i)){
                if(chessboard[x-i][y-i].getColor() == ChessColor.NONE){
                    points.add(new ChessboardPoint(x-i,y-i));
                }else{
                    if(chessboard[x-i][y-i].getColor() != super.getColor()){
                        points.add(new ChessboardPoint(x-i,y-i));
                    }
                    break;
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

    public BishopChessComponent(ChessColor chessColor){
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
