import java.util.ArrayList;
import java.util.List;

public  class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
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
            if(Math.abs ((toY-startY)/(toX-startX))!=1  )return false;
            
            if(Math.abs((toY-startY)*(toX-startX))!=1)return false;
            
        }else {
            
            if(!(   (Math.abs(toX-startX)==1 && toY==startY)
                    ||(Math.abs(toY-startY)==1 && toX==startX)) ) return false;
        }
        return true;

    }

    public KingChessComponent() {
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
