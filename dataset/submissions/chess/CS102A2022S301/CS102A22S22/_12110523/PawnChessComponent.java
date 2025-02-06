import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;


    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = source;
        this.chessColor = chessColor;
    }

    public PawnChessComponent() {
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l=new ArrayList<>() ;
        int x=source.getX();
        int y=source.getY();
        if (chessColor==ChessColor.BLACK){
            if (x==1){
                if (chessboard[2][y].getChessColor()==ChessColor.NONE){
                    ChessboardPoint p1=new ChessboardPoint(2,y);
                    l.add(p1);
                    if (chessboard[3][y].getChessColor()==ChessColor.NONE){
                        ChessboardPoint p2=new ChessboardPoint(3,y);
                        l.add(p2);
                    }
                }
            }
            if (x<7){
                if (y>0){
                    if (chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE){
                        ChessboardPoint p3=new ChessboardPoint(x+1,y-1);
                        l.add(p3);
                    }
                }
                if (y<7){
                    if (chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                        ChessboardPoint p4=new ChessboardPoint(x+1,y+1);
                        l.add(p4);
                    }
                }
                if (chessboard[x+1][y].getChessColor()==ChessColor.NONE&&x!=1){
                    ChessboardPoint p5=new ChessboardPoint(x+1,y);
                    l.add(p5);
                }
            }

        }



        if (chessColor==ChessColor.WHITE){
            if (x==6){
                if (chessboard[5][y].getChessColor()==ChessColor.NONE){
                    ChessboardPoint p1=new ChessboardPoint(5,y);
                    l.add(p1);
                    if (chessboard[4][y].getChessColor()==ChessColor.NONE){
                        ChessboardPoint p2=new ChessboardPoint(4,y);
                        l.add(p2);
                    }
                }


            }
            if (x>0){
                if (y>0){
                    if (chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
                        ChessboardPoint p3=new ChessboardPoint(x-1,y-1);
                        l.add(p3);
                    }
                }
                if (y<7){
                    if (chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK){
                        ChessboardPoint p4=new ChessboardPoint(x-1,y+1);
                        l.add(p4);
                    }
                }
                if (chessboard[x-1][y].getChessColor()==ChessColor.NONE&&x!=6){
                    ChessboardPoint p5=new ChessboardPoint(x-1,y);
                    l.add(p5);
                }
            }

        }

        return l;

    }

}
