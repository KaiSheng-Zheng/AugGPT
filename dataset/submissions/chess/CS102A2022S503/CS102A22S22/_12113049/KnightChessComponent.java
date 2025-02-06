import java.util.LinkedList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color
//    protected char name = 'N';// What's the name

    public KnightChessComponent(){}

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            this.name = 'N';
        }
        if(chessColor == ChessColor.WHITE){
            this.name = 'n';
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

       
        if(x+2<8 && y+1<8){
            int x0 = x+2;
            int y0 = y+1;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

        
        if(x+1<8 && y+2<8){
            int x0 = x+1;
            int y0 = y+2;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

      
        if(x+2<8 && y-1>=0){
            int x0 = x+2;
            int y0 = y-1;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

        
        if(x+1<8 && y-2>=0){
            int x0 = x+1;
            int y0 = y-2;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

        
        if(x-2>=0 && y+1<8){
            int x0 = x-2;
            int y0 = y+1;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

      
        if(x-1>=0 && y+2<8){
            int x0 = x-1;
            int y0 = y+2;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

        
        if(x-2>=0 && y-1>=0){
            int x0 = x-2;
            int y0 = y-1;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

       
        if(x-1>=0 && y-2>=0){
            int x0 = x-1;
            int y0 = y-2;
            if(chessboard[x0][y0] instanceof EmptySlotComponent || !chessboard[x0][y0].getChessColor().equals(this.chessColor)){
                ChessboardPoint p1 = new ChessboardPoint(x0,y0);
                chessboardPoints.add(p1);
            }
        }

        return chessboardPoints;
    }
}