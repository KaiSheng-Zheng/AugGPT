import java.util.List;

public class QueenChessComponent extends ChessComponent {
    boolean killed;
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='q';
        else if(chessColor==ChessColor.BLACK)
            super.name='Q';
    }
    public List<ChessboardPoint> canMoveTo()
    {
        return null;
    }
    public void setKilled(){
        killed=true;
        if(chessColor==ChessColor.WHITE)
            nokoru[1][1]--;
        else if(chessColor==ChessColor.BLACK)
            nokoru[0][1]--;
    }
    public String toString() {
        if(chessColor==ChessColor.WHITE)
            return "q";
        else if(chessColor==ChessColor.BLACK)
            return "Q";
        else
            return "_";
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination,ChessboardPoint source){
        if(source.getX()==destination.getX()&&source.getY()==destination.getY())
            return false;
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
        if (Math.abs(source.getX() - destination.getX())==Math.abs(source.getY() - destination.getY())) {
            int k=(source.getX()-destination.getX())/(source.getY()-destination.getY());
            //int delta=Math.abs(source.getX() - destination.getX());
            if(k==1){
                if(source.getX()>destination.getX());
                int y_x=source.getY()-source.getX();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(chessComponents[row][row+y_x] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
            else{
                int y_x=source.getY()+source.getX();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(chessComponents[row][-row+y_x] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
        }
        else if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
