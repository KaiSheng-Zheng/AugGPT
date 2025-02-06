import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name,ChessColor c,ChessboardPoint s){
        super(name,c,s);
    };

    public KingChessComponent(char n){
        super(n);

    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessBoardPoint().getX();
        int y = this.getChessBoardPoint().getY();
        List<ChessboardPoint> t = new ArrayList<>();

        if((x == 0 && y == 0)  ){
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x,y+1));
            t.add(new ChessboardPoint(x+1,y+1));
        }else if((x == 7 && y == 7)){
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x-1,y-1));
        }else if( (x == 0 && y == 7)){
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x+1,y-1));
        }else if( (x == 7 && y == 0)){
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x,y+1));
            t.add(new ChessboardPoint(x-1,y+1));
        }else if( x == 0 && (y > 0 || y < 7) ){
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x,y+1));
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x+1,y+1));
            t.add(new ChessboardPoint(x+1,y-1));

        }else if( y == 7 &&  (x < 7||x > 0)){
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x+1,y-1));
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x-1,y-1));
        }else if(y == 0 && (x > 0|| x < 7 )){
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x+1,y+1));
            t.add(new ChessboardPoint(x,y+1));
            t.add(new ChessboardPoint(x-1,y+1));
        }else  if(x == 7 && (y > 0 ||y < 7)){
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x-1,y+1));
            t.add(new ChessboardPoint(x-1,y-1));
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x,y+1));
        } else if((x >= 1 && x <= 6) && (y >= 1 && y<= 6)){
            t.add(new ChessboardPoint(x+1,y));
            t.add(new ChessboardPoint(x+1,y+1));
            t.add(new ChessboardPoint(x+1,y-1));
            t.add(new ChessboardPoint(x,y-1));
            t.add(new ChessboardPoint(x,y+1));
            t.add(new ChessboardPoint(x-1,y));
            t.add(new ChessboardPoint(x-1,y+1));
            t.add(new ChessboardPoint(x-1,y-1));
        }
        t.removeIf(b -> chessComponentsNew[b.getX()][b.getY()].getChessColor() == this.getChessColor());

        return t;
    }

    public char getName(){
        return this.name;
    }
}
