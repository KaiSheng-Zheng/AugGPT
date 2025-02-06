import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public KingChessComponent() {
        super();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = source;
        ChessComponent[][] situation = chessComponents;
        ChessColor color = chessColor;
        int Y = location.getX(); int X = location.getY();
        List<ChessboardPoint> a = new ArrayList<>();
        ChessboardPoint b;

        if(X*Y==0||X==7||Y==7){
            if(X==0 && Y==0){
                if(situation[0][1] instanceof EmptySlotComponent || (!(situation[0][1] instanceof EmptySlotComponent)&&!(color.equals(situation[0][1].getChessColor())))){
                    b=new ChessboardPoint(1,0);
                    a.add(b);
                }
                if(situation[1][0] instanceof EmptySlotComponent || (!(situation[1][0] instanceof EmptySlotComponent)&&!(color.equals(situation[1][0].getChessColor())))) {
                    b = new ChessboardPoint(0,1);
                    a.add(b);
                }
                if(situation[1][1] instanceof EmptySlotComponent || (!(situation[1][1] instanceof EmptySlotComponent)&&!(color.equals(situation[1][1].getChessColor())))) {
                    b = new ChessboardPoint(1,1);
                    a.add(b);
                }
            }
            if(X==7 && Y==0){
                if(situation[6][0] instanceof EmptySlotComponent || (!(situation[6][0] instanceof EmptySlotComponent)&&!(color.equals(situation[6][0].getChessColor())))){
                    b=new ChessboardPoint(6,0);
                    a.add(b);
                }
                if(situation[7][1] instanceof EmptySlotComponent || (!(situation[7][1] instanceof EmptySlotComponent)&&!(color.equals(situation[7][1].getChessColor())))) {
                    b = new ChessboardPoint(7,1);
                    a.add(b);
                }
                if(situation[6][1] instanceof EmptySlotComponent || (!(situation[6][1] instanceof EmptySlotComponent)&&!(color.equals(situation[6][1].getChessColor())))) {
                    b = new ChessboardPoint(6,1);
                    a.add(b);
                }
            }
            if(X==7 && Y==7){
                if(situation[7][6] instanceof EmptySlotComponent || (!(situation[7][6] instanceof EmptySlotComponent)&&!(color.equals(situation[7][6].getChessColor())))){
                    b=new ChessboardPoint(7,6);
                    a.add(b);
                }
                if(situation[6][7] instanceof EmptySlotComponent || (!(situation[6][7] instanceof EmptySlotComponent)&&!(color.equals(situation[6][7].getChessColor())))) {
                    b = new ChessboardPoint(6,7);
                    a.add(b);
                }
                if(situation[6][6] instanceof EmptySlotComponent || (!(situation[6][6] instanceof EmptySlotComponent)&&!(color.equals(situation[6][6].getChessColor())))) {
                    b = new ChessboardPoint(6,6);
                    a.add(b);
                }
            }
            if(X==0 && Y==7){
                if(situation[0][6] instanceof EmptySlotComponent || (!(situation[0][6] instanceof EmptySlotComponent)&&!(color.equals(situation[0][6].getChessColor())))){
                    b=new ChessboardPoint(0,6);
                    a.add(b);
                }
                if(situation[1][7] instanceof EmptySlotComponent || (!(situation[1][7] instanceof EmptySlotComponent)&&!(color.equals(situation[1][7].getChessColor())))) {
                    b = new ChessboardPoint(1,7);
                    a.add(b);
                }
                if(situation[1][6] instanceof EmptySlotComponent || (!(situation[1][6] instanceof EmptySlotComponent)&&!(color.equals(situation[1][6].getChessColor())))) {
                    b = new ChessboardPoint(1,6);
                    a.add(b);
                }
            }

            if(X==0 && Y>0 && Y<7){
                if(situation[0][Y+1] instanceof EmptySlotComponent || (!(situation[0][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[0][Y+1].getChessColor())))){
                    b=new ChessboardPoint(0,Y+1);
                    a.add(b);
                }
                if(situation[0][Y-1] instanceof EmptySlotComponent || (!(situation[0][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[0][Y-1].getChessColor())))) {
                    b = new ChessboardPoint(0,Y-1);
                    a.add(b);
                }
                if(situation[1][Y+1] instanceof EmptySlotComponent || (!(situation[1][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[1][Y+1].getChessColor())))) {
                    b = new ChessboardPoint(1,Y+1);
                    a.add(b);
                }
                if(situation[1][Y] instanceof EmptySlotComponent || (!(situation[1][Y] instanceof EmptySlotComponent)&&!(color.equals(situation[1][Y].getChessColor())))) {
                    b = new ChessboardPoint(1,Y);
                    a.add(b);
                }
                if(situation[1][Y-1] instanceof EmptySlotComponent || (!(situation[1][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[1][Y-1].getChessColor())))) {
                    b = new ChessboardPoint(1,Y-1);
                    a.add(b);
                }
            }
            if(X==7 && Y>0 && Y<7){
                if(situation[7][Y+1] instanceof EmptySlotComponent || (!(situation[7][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[7][Y+1].getChessColor())))){
                    b=new ChessboardPoint(7,Y+1);
                    a.add(b);
                }
                if(situation[7][Y-1] instanceof EmptySlotComponent || (!(situation[7][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[7][Y-1].getChessColor())))) {
                    b = new ChessboardPoint(7,Y-1);
                    a.add(b);
                }
                if(situation[6][Y+1] instanceof EmptySlotComponent || (!(situation[6][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[6][Y+1].getChessColor())))) {
                    b = new ChessboardPoint(6,Y+1);
                    a.add(b);
                }
                if(situation[6][Y] instanceof EmptySlotComponent || (!(situation[6][Y] instanceof EmptySlotComponent)&&!(color.equals(situation[6][Y].getChessColor())))) {
                    b = new ChessboardPoint(6,Y);
                    a.add(b);
                }
                if(situation[6][Y-1] instanceof EmptySlotComponent || (!(situation[6][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[6][Y-1].getChessColor())))) {
                    b = new ChessboardPoint(6,Y-1);
                    a.add(b);
                }
            }
            if(Y==0 && X>0 && X<7){
                if(situation[X-1][0] instanceof EmptySlotComponent || (!(situation[X-1][0] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][0].getChessColor())))){
                    b=new ChessboardPoint(X-1,0);
                    a.add(b);
                }
                if(situation[X+1][0] instanceof EmptySlotComponent || (!(situation[X+1][0] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][0].getChessColor())))) {
                    b = new ChessboardPoint(X+1,0);
                    a.add(b);
                }
                if(situation[X-1][1] instanceof EmptySlotComponent || (!(situation[X-1][1] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][1].getChessColor())))) {
                    b = new ChessboardPoint(X-1,1);
                    a.add(b);
                }
                if(situation[X][1] instanceof EmptySlotComponent || (!(situation[X][1] instanceof EmptySlotComponent)&&!(color.equals(situation[X][1].getChessColor())))) {
                    b = new ChessboardPoint(X,1);
                    a.add(b);
                }
                if(situation[X+1][1] instanceof EmptySlotComponent || (!(situation[X+1][1] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][1].getChessColor())))) {
                    b = new ChessboardPoint(X+1,1);
                    a.add(b);
                }
            }
            if(Y==7 && X>0 && X<7){
                if(situation[X-1][7] instanceof EmptySlotComponent || (!(situation[X-1][7] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][7].getChessColor())))){
                    b=new ChessboardPoint(X-1,7);
                    a.add(b);
                }
                if(situation[X+1][7] instanceof EmptySlotComponent || (!(situation[X+1][7] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][7].getChessColor())))) {
                    b = new ChessboardPoint(X+1,7);
                    a.add(b);
                }
                if(situation[X-1][6] instanceof EmptySlotComponent || (!(situation[X-1][6] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][6].getChessColor())))) {
                    b = new ChessboardPoint(X-1,6);
                    a.add(b);
                }
                if(situation[X][6] instanceof EmptySlotComponent || (!(situation[X][6] instanceof EmptySlotComponent)&&!(color.equals(situation[X][6].getChessColor())))) {
                    b = new ChessboardPoint(X,6);
                    a.add(b);
                }
                if(situation[X+1][6] instanceof EmptySlotComponent || (!(situation[X+1][6] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][6].getChessColor())))) {
                    b = new ChessboardPoint(X+1,6);
                    a.add(b);
                }
            }
        }

        else{
            if(situation[X-1][Y] instanceof EmptySlotComponent || (!(situation[X-1][Y] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][Y].getChessColor())))){
                b=new ChessboardPoint(X-1,Y);
                a.add(b);
            }
            if(situation[X-1][Y-1] instanceof EmptySlotComponent || (!(situation[X-1][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][Y-1].getChessColor())))) {
                b = new ChessboardPoint(X - 1, Y - 1);
                a.add(b);
            }
            if(situation[X-1][Y+1] instanceof EmptySlotComponent || (!(situation[X-1][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[X-1][Y+1].getChessColor())))) {
                b = new ChessboardPoint(X - 1, Y + 1);
                a.add(b);
            }
            if(situation[X][Y+1] instanceof EmptySlotComponent || (!(situation[X][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[X][Y+1].getChessColor())))) {
                b = new ChessboardPoint(X , Y + 1);
                a.add(b);
            }
            if(situation[X][Y-1] instanceof EmptySlotComponent || (!(situation[X][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[X][Y-1].getChessColor())))) {
                b = new ChessboardPoint(X , Y - 1);
                a.add(b);
            }
            if(situation[X+1][Y+1] instanceof EmptySlotComponent || (!(situation[X+1][Y+1] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][Y+1].getChessColor())))) {
                b = new ChessboardPoint(X + 1, Y + 1);
                a.add(b);
            }
            if(situation[X+1][Y] instanceof EmptySlotComponent || (!(situation[X+1][Y] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][Y].getChessColor())))) {
                b = new ChessboardPoint(X + 1, Y );
                a.add(b);
            }
            if(situation[X+1][Y-1] instanceof EmptySlotComponent || (!(situation[X+1][Y-1] instanceof EmptySlotComponent)&&!(color.equals(situation[X+1][Y-1].getChessColor())))) {
                b = new ChessboardPoint(X + 1, Y - 1);
                a.add(b);
            }
        }
        return a;
    }
}

