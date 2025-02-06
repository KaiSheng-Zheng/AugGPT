import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;            // What's the name


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        super.name = name;
        this.chessColor = chessColor;
        this.source = source;
        super.chessColor1=chessColor;

    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> i = new ArrayList<>();
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {

                if (canMoveTo1(chessboardPoints[x][y])) {
                    i.add(chessboardPoints[x][y]);
                }
            }

        }
        return i;


    }

    public boolean canMoveTo1(ChessboardPoint destination) {
        int dx = destination.getX() - source.getX();
        int dy = destination.getY() - source.getY();
int dx1=0;
int dy1=0;

        if(ConcreteChessGame.chessComponents11[destination.getX()][destination.getY()].getChessColor().equals(chessColor)){
            return false;
        }
        if (dy == 0 && dx == 0) {
            return false;
        } else if (Math.abs( dy)!=Math.abs(dx)) {
            return false;
        } else {
            if(dx<0){dx1=-1;}
            else if(dx==0){dx1=0;}
            else {dx1=1;}
            if(dy<0){dy1=-1;}
            else if(dy==0){dy1=0;}
            else {dy1=1;}



            for (int n = 1; n < Math.max(Math.abs(dx), Math.abs(dy)); n++) {
                try {
                    if (ConcreteChessGame.chessComponents11[source.getX() + n * dx1][source.getY() + n * dy1] instanceof EmptySlotComponent) {
                        ;
                    } else {
                        return false;
                    }} catch (RuntimeException i) {

                    }
                }
            }



        return true;
    }
    public void changeSource(int x,int y){
        source=new ChessboardPoint(x,y);
    }
}
