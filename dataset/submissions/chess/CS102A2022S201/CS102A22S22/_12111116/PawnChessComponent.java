import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessColor currentPlayer;
    public int moveTimes;

    public PawnChessComponent(int x, int y, ChessColor a) {
        super();
        this.x=x;
        this.y=y;
        getSource().setX(x);
        getSource().setY(y);
        this.currentPlayer=a;
        if ((a == ChessColor.BLACK && x == 1) || (a== ChessColor.WHITE && x == 6)) moveTimes = 0;
        else moveTimes=1;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        x = getSource().getX();
        y = getSource().getY();
        List<ChessboardPoint> chessboardPoint = new ArrayList<>();
        ChessboardPoint c = new ChessboardPoint(this.x, this.y);
        if (currentPlayer==ChessColor.WHITE){
            if (c.offset(-1,0)!=null){
                if (getChess(this.x-1,this.y).getChessColor() ==ChessColor.NONE){
                    chessboardPoint.add(c.offset(-1,0));
                }
            }
            if (c.offset(-1,1)!=null){
                if (getChess(this.x-1,this.y+1).getChessColor() ==ChessColor.BLACK){
                    chessboardPoint.add(c.offset(-1,1));
                }
            }if (c.offset(-1,-1)!=null){
                if (getChess(this.x-1,this.y-1).getChessColor() ==ChessColor.BLACK){
                    chessboardPoint.add(c.offset(-1,-1));
                }
            }
        }
        if (currentPlayer==ChessColor.BLACK){
            if (c.offset(1,0)!=null){
                if (getChess(this.x+1,this.y).getChessColor() ==ChessColor.NONE){
                    chessboardPoint.add(c.offset(1,0));
                }
            }
            if (c.offset(1,1)!=null){
                if (getChess(this.x+1,this.y+1).getChessColor() ==ChessColor.WHITE){
                    chessboardPoint.add(c.offset(1,1));
                }
            }if (c.offset(1,-1)!=null){
                if (getChess(this.x+1,this.y-1).getChessColor() ==ChessColor.WHITE){
                    chessboardPoint.add(c.offset(1,-1));
                }
            }
        }
        if (moveTimes==0){
            if (currentPlayer==ChessColor.WHITE){
                if (c.offset(-2,0)!=null){
                    if (getChess(this.x-2,this.y).getChessColor() ==ChessColor.NONE){
                        chessboardPoint.add(c.offset(-2,0));
                    }
                }
            }
            if (currentPlayer==ChessColor.BLACK){
                if (c.offset(2,0)!=null){
                    if (getChess(this.x+2,this.y).getChessColor() ==ChessColor.NONE){
                        chessboardPoint.add(c.offset(2,0));
                    }
                }
            }
        }
        return chessboardPoint;
    }

}
