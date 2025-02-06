import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent() {
    }
    public boolean canMoveTo(ChessboardPoint start, ChessboardPoint destination) {
        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(getChessboard()[destination.getX()][destination.getY()].getChessColor())) {
            return false;
        }


            ChessboardPoint source = start;
            int toX = destination.getY();
            int toY = destination.getX();
            int startX = source.getY();
            int startY = source.getX();

            
            if((toY-startY)!=0 && (toX-startX)!=0){
                if(Math.abs(toY-startY)!=Math.abs(toX-startX) )return false;
            }

            int dy= (toY>startY)? 1:-1 ;
            if(toY==startY)dy=0;
            int dx= (toX>startX)? 1:-1 ;
            if(toX==startX)dx=0;

            int currentX=startX;
            int currentY=startY;
            for(int i=1;i<=Math.abs((toX==startX)? toY-startY : toX-startX)-1;i++ ){
                currentX+=dx;
                currentY+=dy;
                if (!(getChessboard()[currentY][currentX] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> value = new ArrayList<>();
        int startX=this.getSource().getX();
        int startY=this.getSource().getY();
        int toX;
        int toY;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(this.getSource(),getChessboard()[i][j].getSource())){
                    value.add(getChessboard()[i][j].getSource());
                }

            }

        }
        return value;
    }
}
