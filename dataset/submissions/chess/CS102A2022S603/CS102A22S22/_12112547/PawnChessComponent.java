import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private static int num = 0;
    public PawnChessComponent(){}

    public  PawnChessComponent(char n){
        this.name = n;
    }

    public PawnChessComponent(char name, ChessColor c, ChessboardPoint s) {
        super(name,c,s);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessBoardPoint().getX();
        int y = this.getChessBoardPoint().getY();
        List<ChessboardPoint> t = new ArrayList<>();

        if(this.getChessColor() == ChessColor.BLACK){
            if(x == 1 ){
                if(chessComponentsNew[x+1][y].getChessColor() == ChessColor.NONE){
                    t.add(new ChessboardPoint(x+1,y));
                }
                if(chessComponentsNew[x+2][y].getChessColor() == ChessColor.NONE){
                    t.add(new ChessboardPoint(x+2,y));
                }
            }else if(x < 7 && chessComponentsNew[x+1][y].getChessColor() == ChessColor.NONE){
                        t.add(new ChessboardPoint(x+1,y));
            }
            if( (y+1) < 8 && (y+1) >= 0 && x < 7 && chessComponentsNew[x+1][y+1].getChessColor() == ChessColor.WHITE){
                t.add(new ChessboardPoint(x+1,y+1));
            }
            if((y-1) < 8 && (y-1) >= 0 && x < 7 && chessComponentsNew[x+1][y-1].getChessColor() == ChessColor.WHITE){
                t.add(new ChessboardPoint(x+1,y-1));
            }
        }


        if(this.getChessColor() == ChessColor.WHITE){
            if(x == 6){
                if(chessComponentsNew[x-1][y].getChessColor() == ChessColor.NONE){
                    t.add(new ChessboardPoint(x-1,y));
                }
                if(chessComponentsNew[x-2][y].getChessColor() == ChessColor.NONE){
                    t.add(new ChessboardPoint(x-2,y));
                }
            }else if(x > 0 && chessComponentsNew[x-1][y].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(x-1,y));
            }
            if( y < 7 && x > 0 && chessComponentsNew[x-1][y+1].getChessColor() == ChessColor.BLACK){
                t.add(new ChessboardPoint(x+1,y-1));
            }
            if(y > 0 && x > 0 && chessComponentsNew[x-1][y-1].getChessColor() == ChessColor.BLACK){
                t.add(new ChessboardPoint(x-1,y-1));
            }

        }

        return t;
    }

    public char getName(){
        return this.name;
    }
}
