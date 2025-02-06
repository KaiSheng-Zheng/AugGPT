import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ChessColor getChessColor() {
        return super.getChessColor();
    }
    public ChessboardPoint getSource() {
        return super.getSource();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  chessboardPointList=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if(x+1<=7&&p[x+1][y].getChessColor() != getChessColor()){
            if (offset(1,0)!=null) {
                chessboardPointList.add(offset(1,0));
            }
        }
        if(x+1<=7&&y+1<=7&&p[x+1][y+1].getChessColor() != getChessColor()){
            if (offset(1,1)!=null) {
                chessboardPointList.add(offset(1,1));
            }
        }
        if(x+1<=7&&y-1>=0&&p[x+1][y-1].getChessColor() != getChessColor()){
            if (offset(1,-1)!=null) {
                chessboardPointList.add(offset(1,-1));
            }
        }
        if(x-1>=0&&p[x-1][y].getChessColor() !=getChessColor()){
            if (offset(-1,0)!=null) {
                chessboardPointList.add(offset(-1,0));
            }
        }
        if(y+1<=7&&p[x][y+1].getChessColor() != getChessColor()){
            if (offset(0,1)!=null) {
                chessboardPointList.add(offset(0,1));
            }
        }
        if(x-1>=0&&y-1>=0&&p[x-1][y-1].getChessColor() != getChessColor()){
            if (offset(-1,-1)!=null) {
                chessboardPointList.add(offset(-1,-1));
            }
        }
        if(y-1>=0&&p[x][y-1].getChessColor() != getChessColor()){
            if (offset(0,-1)!=null) {
                chessboardPointList.add(offset(0,-1));
            }
        }
        if(x-1>=0&&y+1<=7&&p[x-1][y+1].getChessColor() != getChessColor()){
            if (offset(-1,1)!=null) {
                chessboardPointList.add(offset(-1,1));
            }
        }
        return chessboardPointList;
    }
    public ChessboardPoint offset(int dx, int dy) {
        if (getSource().getX() + dx >= 0 && getSource().getX() + dx <= 7 && getSource().getY() + dy >= 0 && getSource().getY() + dy <= 7) {
            return new ChessboardPoint(getSource().getX() + dx, getSource().getY() + dy);
        }
        else return null;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}