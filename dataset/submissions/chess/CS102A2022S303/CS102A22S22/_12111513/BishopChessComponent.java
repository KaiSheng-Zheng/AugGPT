import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent() {
    }

    public boolean canMoveTo(ChessboardPoint start, ChessboardPoint destination) {

        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(getChessboard()[destination.getX()][destination.getY()].getChessColor())) {
            return false;
        }


        ChessboardPoint source = start;

        int startX=source.getY();
        int startY=source.getX();
        int toX=destination.getY();
        int toY=destination.getX();

        
        try{if (toX==startX){
            return false;
        }else {

            if (Math.abs(toY-startY)!=Math.abs(toX-startX)){
                return false;
            }
        }
        }catch (Exception e){
            return false;
        }

       
        int dx =(toX-startX>0)? 1:-1;
        int dy =(toY-startY>0)? 1:-1;

        int currentX =startX;
        int currentY =startY;
        for(int i=1;i<=Math.abs(toX-startX)-1;i++){
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


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                 if (  canMoveTo( this.getSource() , getChessboard()[i][j].getSource() )){
                     value.add(getChessboard()[i][j].getSource());}
            }
        }

        return value;
    }
}
