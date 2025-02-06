import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
   public KingChessComponent(char a,ChessColor c,int x,int y,ConcreteChessGame l){
        name=a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g=l;

    }
    @Override

    public List<ChessboardPoint> canMoveTo(){
       ChessColor lo=getChessColor();
        List<ChessboardPoint> c=new ArrayList<>();
        for(int n=-1;n<=1;n++) {
            if (n != 0) {
                if(getSource().offset(n, n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()+n].getChessColor()!=lo){c.add(getSource().offset(n, n));}
                if(getSource().offset(n, -n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()-n].getChessColor()!=lo){c.add(getSource().offset(n, -n));}
                if(getSource().offset(n,0)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()].getChessColor()!=lo){c.add(getSource().offset(n,0));}
                if(getSource().offset(0,n)!=null&&g.getChessComponents()[getSource().getX()][getSource().getY()+n].getChessColor()!=lo){c.add(getSource().offset(0,n));}
            }
        }

        return c;


    }


}
class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char a,ChessColor c,int x,int y,ConcreteChessGame l){
        name=a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g=l;

    }



    @Override

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c=new ArrayList<>();
        ChessColor or=getChessColor();
        for(int n=-7;n<=7;n++) {
            if (n != 0) {
                if(getSource().offset(n, 0)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()].getChessColor()!=or){
                    boolean is=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY()].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                    else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                        if(g.getChessComponents()[getSource().getX()+ppp][getSource().getY()].getChessColor()!=ChessColor.NONE){
                            is=false;
                            break;
                        }
                    }
                    }
                    if(is){c.add(getSource().offset(n, 0));}
                }
                if(getSource().offset(0, n)!=null&&g.getChessComponents()[getSource().getX()][getSource().getY()+n].getChessColor()!=or){
                    boolean is2=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() ][getSource().getY()+ppp].getChessColor() != ChessColor.NONE) {
                                is2 = false;
                                break;
                            }
                        }
                    }
                    else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                        if(g.getChessComponents()[getSource().getX()][getSource().getY()+ppp].getChessColor()!=ChessColor.NONE){
                            is2=false;
                            break;
                        }
                    }
                    }

                    if(is2){c.add(getSource().offset(0, n));}
                }
                if(getSource().offset(n, n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()+n].getChessColor()!=or){
                    boolean is=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY()+ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                    else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                        if(g.getChessComponents()[getSource().getX()+ppp][getSource().getY()+ppp].getChessColor()!=ChessColor.NONE){
                            is=false;
                            break;
                        }
                    }
                    }
                    if(is){c.add(getSource().offset(n, n));}
                }
                if(getSource().offset(n, -n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()-n].getChessColor()!=or){
                    boolean is=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY()-ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                    else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                        if(g.getChessComponents()[getSource().getX()+ppp][getSource().getY()-ppp].getChessColor()!=ChessColor.NONE){
                            is=false;
                            break;
                        }
                    }
                    }
                    if(is){c.add(getSource().offset(n, -n));}
                }
            }

        }
        return c;


    }
}








class RookChessComponent extends  ChessComponent{
    public RookChessComponent(char a,ChessColor c,int x,int y,ConcreteChessGame l){
        name=a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g=l;

    }
    @Override

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> c=new ArrayList<>();
        ChessColor or=getChessColor();

        for(int n=-7;n<=7;n++) {
            if (n != 0) {
                if(getSource().offset(n, 0)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()].getChessColor()!=or){
                    boolean is=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY()].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                        else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                            if(g.getChessComponents()[getSource().getX()+ppp][getSource().getY()].getChessColor()!=ChessColor.NONE){
                                is=false;
                                break;
                            }
                        }
                    }
                    if(is){c.add(getSource().offset(n, 0));}
                }
                if(getSource().offset(0, n)!=null&&g.getChessComponents()[getSource().getX()][getSource().getY()+n].getChessColor()!=or){
                    boolean is2=true;
                    if(n>0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() ][getSource().getY()+ppp].getChessColor() != ChessColor.NONE) {
                                is2 = false;
                                break;
                            }
                        }
                    }
                    else if(n<0){for(int ppp=-1;ppp>n;ppp--){
                        if(g.getChessComponents()[getSource().getX()][getSource().getY()+ppp].getChessColor()!=ChessColor.NONE){
                            is2=false;
                            break;
                        }
                    }
                    }

                    if(is2){c.add(getSource().offset(0, n));}
                }
            }
        }
        return c;


    }
}
class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char a, ChessColor c, int x, int y, ConcreteChessGame l) {
        name = a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g = l;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c = new ArrayList<>();
        ChessColor or = getChessColor();
        for (int n = -7; n <= 7; n++) {
            if (n != 0) {
                if (getSource().offset(n, n) != null && g.getChessComponents()[getSource().getX() + n][getSource().getY() + n].getChessColor() != or) {
                    boolean is = true;
                    if (n > 0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY() + ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    } else if (n < 0) {
                        for (int ppp = -1; ppp > n; ppp--) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY() + ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                    if (is) {
                        c.add(getSource().offset(n, n));
                    }
                }
                if (getSource().offset(n, -n) != null && g.getChessComponents()[getSource().getX() + n][getSource().getY() - n].getChessColor() != or) {
                    boolean is = true;
                    if (n > 0) {
                        for (int ppp = 1; ppp < n; ppp++) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY() - ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    } else if (n < 0) {
                        for (int ppp = -1; ppp > n; ppp--) {
                            if (g.getChessComponents()[getSource().getX() + ppp][getSource().getY() - ppp].getChessColor() != ChessColor.NONE) {
                                is = false;
                                break;
                            }
                        }
                    }
                    if (is) {
                        c.add(getSource().offset(n, -n));
                    }
                }
            }

        }
        return c;


    }

}








class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char a,ChessColor c,int x,int y,ConcreteChessGame l){
        name=a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g=l;

    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c = new ArrayList<>();
        ChessColor lo=getChessColor();
        for (int n = -1; n <= 1; n++) {
            if (n != 0) {
                if(getSource().offset(n, 2*n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()+2*n].getChessColor()!=lo)
                {c.add(getSource().offset(n, 2*n));}
                if(getSource().offset(n, -2*n)!=null&&g.getChessComponents()[getSource().getX()+n][getSource().getY()-2*n].getChessColor()!=lo)
                    c.add(getSource().offset(n, -2*n));
                if(getSource().offset(2*n, n)!=null&&g.getChessComponents()[getSource().getX()+2*n][getSource().getY()+n].getChessColor()!=lo)
                {c.add(getSource().offset(2*n, n));}
                if(getSource().offset(-2*n, n)!=null&&g.getChessComponents()[getSource().getX()-2*n][getSource().getY()+n].getChessColor()!=lo)
                {c.add(getSource().offset(-2*n, n));}

            }
        }

        return c;

    }
    public List<ChessboardPoint> canMoveTo(ChessComponent[][] chessComponents) {
        List<ChessboardPoint> c = new ArrayList<>();
        for (int n = -1; n <= 1; n++) {
            if (n != 0) {
                if(getSource().offset(n, 2*n)!=null)
                {c.add(getSource().offset(n, 2*n));}
                if(getSource().offset(n, -2*n)!=null)
                    c.add(getSource().offset(n, -2*n));

            }
        }

        return c;

    }

}
class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(char a,ChessColor c,int x,int y,ConcreteChessGame l){
        name=a;
        setChessColor(c);
        getSource().setX(x);
        getSource().setY(y);
        g=l;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c = new ArrayList<>();

        if(getChessColor()==ChessColor.BLACK) {
            if (getSource().getX()==1&&getSource().offset(2, 0) != null && g.getChessComponents()[getSource().getX() + 2][getSource().getY()].getChessColor() == ChessColor.NONE) {
                c.add(getSource().offset(2, 0));

            }
            if (getSource().offset(1, 0) != null && g.getChessComponents()[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.NONE) {
                c.add(getSource().offset(1, 0));
            }
            if (getSource().offset(1, -1) != null && g.getChessComponents()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                c.add(getSource().offset(1, -1));
            }
            if (getSource().offset(1, 1) != null && g.getChessComponents()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                c.add(getSource().offset(1, 1));
            }
        }
        else {
            if(getSource().offset(-1, 0)!=null&&g.getChessComponents()[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE)
            {c.add(getSource().offset(-1, 0));}
            if (getSource().getX()==6&&getSource().offset(-2, 0) != null && g.getChessComponents()[getSource().getX() - 2][getSource().getY()].getChessColor() == ChessColor.NONE) {
                c.add(getSource().offset(-2, 0));

            }
            if(getSource().offset(-1, 1)!=null&&g.getChessComponents()[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK)
            {c.add(getSource().offset(-1, 1));}
            if(getSource().offset(-1, -1)!=null&&g.getChessComponents()[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK)
                c.add(getSource().offset(-1, -1));}





        return c;

    }
}
class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(char a,int x,int y,ConcreteChessGame l){
        name='_';
        getSource().setX(x);
        getSource().setY(y);
        g=l;

    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c = new ArrayList<>();







        return c;

    }
    public List<ChessboardPoint> canMoveTo(ChessComponent[][] chessComponents) {
        List<ChessboardPoint> c = new ArrayList<>();







        return c;

    }

}
