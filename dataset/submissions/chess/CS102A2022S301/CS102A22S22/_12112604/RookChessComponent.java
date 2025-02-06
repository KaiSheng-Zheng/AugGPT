import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent {
    private static int cntwhite = 0;
    private static int cntblack = 0;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessboard = ConcreteChessGame.cb;
        for(int i = x + 1; i < 8; i++){
            if(chessboard[i][y].getColor() == ChessColor.NONE){
                points.add(new ChessboardPoint(i,y));
            }else{
                if(chessboard[i][y].getColor() != super.getColor()){
                    points.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for(int i = x - 1; i >= 0; i--){
            if(chessboard[i][y].getColor() == ChessColor.NONE){
                points.add(new ChessboardPoint(i,y));
            }else{
                if(chessboard[i][y].getColor() != super.getColor()){
                    points.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for(int i = y + 1; i < 8; i++){
            if(chessboard[x][i].getColor() == ChessColor.NONE){
                points.add(new ChessboardPoint(x,i));
            }else{
                if(chessboard[x][i].getColor() != super.getColor()){
                    points.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        for(int i = y - 1; i >= 0; i--){
            if(chessboard[x][i].getColor() == ChessColor.NONE){
                points.add(new ChessboardPoint(x,i));
            }else{
                if(chessboard[x][i].getColor() != super.getColor()){
                    points.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        return points;
    }

    public RookChessComponent(ChessColor chessColor){
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
}
