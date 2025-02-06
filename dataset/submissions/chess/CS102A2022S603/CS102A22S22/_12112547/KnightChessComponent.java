import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent (char name,ChessColor c,ChessboardPoint s){
        super(name,c,s);
    }

    public KnightChessComponent(char n){
        super(n);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessBoardPoint().getX();
        int y = this.getChessBoardPoint().getY();
        List<ChessboardPoint> t = new ArrayList<>();
        ChessboardPoint s = this.getChessBoardPoint();
        ChessboardPoint s1 = s.offset(1,2);
        ChessboardPoint s5 = s.offset(2,1);
        ChessboardPoint s3 = s.offset(-1,2);
        ChessboardPoint s6 = s.offset(2,-1);
        ChessboardPoint s2 = s.offset(1,-2);
        ChessboardPoint s7 = s.offset(-2,1);
        ChessboardPoint s4 = s.offset(-1,-2);
        ChessboardPoint s8 = s.offset(-2,-1);

//        List<ChessboardPoint> t1 = new ArrayList<>();
//
//        if(((x == 0 || x == 1) && (y == 1||y == 0))  ){
//            t.add(new ChessboardPoint(x+1,y+2));
//            t.add(new ChessboardPoint(x+2,y+1));
//        }else if(((x == 7 || x == 6)&& (y == 6||y == 7))){
//            t.add(new ChessboardPoint(x-2,y-1));
//            t.add(new ChessboardPoint(x-1,y-2));
//        }else if( (x == 0 || x == 1) && (y == 6 ||y == 7)){
//            t.add(new ChessboardPoint(x+2,y-1));
//            t.add(new ChessboardPoint(x+1,y-2));
//        }else if( (x == 7 || x == 6) && (y == 1 || y == 0)){
//            t.add(new ChessboardPoint(x-1,y+2));
//            t.add(new ChessboardPoint(x-2,y+1));
//
//        }else if( x == 0  ){
//            t.add(new ChessboardPoint(x+2,y-1));
//            t.add(new ChessboardPoint(x+2,y+1));
//            t.add(new ChessboardPoint(x+1,y+2));
//            t.add(new ChessboardPoint(x+1,y-2));
//
//        }else if( y == 7 ){
//            t.add(new ChessboardPoint(x+2,y-1));
//            t.add(new ChessboardPoint(x-2,y-1));
//            t.add(new ChessboardPoint(x+1,y-2));
//            t.add(new ChessboardPoint(x-1,y-2));
//        }else if(y == 0 ){
//            t.add(new ChessboardPoint(x+1,y+2));
//            t.add(new ChessboardPoint(x-1,y+2));
//            t.add(new ChessboardPoint(x+2,y+1));
//            t.add(new ChessboardPoint(x-2,y+1));
//        }else  if(x == 7 ){
//            t.add(new ChessboardPoint(x-1,y+2));
//            t.add(new ChessboardPoint(x-1,y-2));
//            t.add(new ChessboardPoint(x-2,y-1));
//            t.add(new ChessboardPoint(x-2,y+1));
//        } else if((x > 1 && x < 6) && (y > 1 && y < 6)){
//
//            t.add(new ChessboardPoint(x+2,y+1));
//            t.add(new ChessboardPoint(x+2,y-1));
//            t.add(new ChessboardPoint(x-2,y-1));
//            t.add(new ChessboardPoint(x-2,y+1));
//            t.add(new ChessboardPoint(x+1,y+2));
//            t.add(new ChessboardPoint(x+1,y-2));
//            t.add(new ChessboardPoint(x-1,y+2));
//            t.add(new ChessboardPoint(x-1,y-2));
//        }
//        t.removeIf(b -> chessComponentsNew[b.getX()][b.getY()].getChessColor() != this.getChessColor());
//
//        t1.addAll(t);
//        t1.removeAll(t);

        if(s1 != null ){//&&
            if(chessComponentsNew[s1.getX()][s1.getY()].getChessColor() != this.getChessColor()){
                t.add(s1);
            }

        }
        if(s2 != null ){//&&
           if(chessComponentsNew[s2.getX()][s2.getY()].getChessColor() != this.getChessColor()){
               t.add(s2);
           }

        }
        if(s3 != null ){//&&
            if(chessComponentsNew[s3.getX()][s3.getY()].getChessColor() != this.getChessColor()){
                t.add(s3);
            }

        }
        if(s4 != null ){//&&
            if(chessComponentsNew[s4.getX()][s4.getY()].getChessColor() != this.getChessColor()) {
                t.add(s4);
            }
        }
        if(s5 != null ){//&&
           if(chessComponentsNew[s5.getX()][s5.getY()].getChessColor() != this.getChessColor()){
               t.add(s5);
           }

        }
        if(s6 != null ){//&&
            if(chessComponentsNew[s6.getX()][s6.getY()].getChessColor() != this.getChessColor()){
                t.add(s6);
            }

        }
        if(s7 != null){// &&
            if(chessComponentsNew[s7.getX()][s7.getY()].getChessColor() != this.getChessColor()){
                t.add(s7);
            }

        }
        if(s8 != null ){//&&
            if(chessComponentsNew[s8.getX()][s8.getY()].getChessColor() != this.getChessColor()){
                t.add(s8);
            }

        }
        t.removeIf(b -> chessComponentsNew[b.getX()][b.getY()].getChessColor() == this.getChessColor());

        //t.removeIf(b -> chessComponentsNew[b.getX()][b.getY()].getChessColor() == this.getChessColor() );
        return t;
    }

    public char getName(){
        return this.name;
    }
}
