import java.util.LinkedList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color
//    protected char name = 'P';// What's the name
    boolean isFirstStep = true;

    public PawnChessComponent(){}

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            this.name = 'P';
        }
        if(chessColor == ChessColor.WHITE){
            this.name = 'p';
        }
    }

    public ChessboardPoint getChessboardPoint() {return source;}

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {this.source = chessboardPoint;}

    public ChessColor getChessColor() {return chessColor;}



    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getChessboardPoint();
        List<ChessboardPoint> chessboardPoints = new LinkedList<>();

       
        int x = source.getX();
        int y = source.getY();
        if(isFirstStep){
            
            if(y+1<8){
                int x0 = x;
                int y0 = y+1;
                if(chessboard[x0][y0]!=null && getComponentColor(chessboard[x0][y0].toString().charAt(0)) !=chessColor ){
                    ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                    chessboardPoints.add(p1);
                }
            }

            
            if(y+2<8){
                int x0 = x;
                int y0 = y+2;
                if(chessboard[x0][y0]!=null && getComponentColor(chessboard[x0][y0].toString().charAt(0)) !=chessColor){
                    ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                    chessboardPoints.add(p1);
                }
            }
            isFirstStep = false;
        } else{
            
            if(y+1<8){
                int x0 = x;
                int y0 = y+1;
                if(chessboard[x0][y0]!=null && getComponentColor(chessboard[x0][y0].toString().charAt(0)) !=chessColor ){
                    ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                    chessboardPoints.add(p1);
                }
            }
        }

        return chessboardPoints;
    }

}
