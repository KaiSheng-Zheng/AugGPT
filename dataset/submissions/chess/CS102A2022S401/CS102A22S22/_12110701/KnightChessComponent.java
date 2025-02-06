import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
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
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        if(x+1<=7&&y+2<=7&&checkColor(x+1,y+2)){
            if (offset(1,2)!=null) {
                chessboardPointList.add(offset(1,2));
            }
        }
        if(x+2<=7&&y+1<=7&&checkColor(x+2,y+1)){
            if (offset(2,1)!=null) {
                chessboardPointList.add(offset(2,1));
            }
        }
        if(x+1<=7&&y-2>=0&&checkColor(x+1,y-2)){
            if (offset(1,-2)!=null) {
                chessboardPointList.add(offset(1,-2));
            }
        }
        if(x-1>=0&&y+2<=7&&checkColor(x-1,y+2)){
            if (offset(-1,2)!=null) {
                chessboardPointList.add(offset(-1,2));
            }
        }
        if(x-2>=0&&y+1<=7&&checkColor(x-2,y+1)){
            if (offset(-2,1)!=null) {
                chessboardPointList.add(offset(-2,1));
            }
        }
        if(x-1>=0&&y-2>=0&&checkColor(x-1,y-2)){
            if (offset(-1,-2)!=null) {
                chessboardPointList.add(offset(-1,-2));
            }
        }
        if(x-2>=0&&y-1>=0&&checkColor(x-2,y-1)){
            if (offset(-2,-1)!=null) {
                chessboardPointList.add(offset(-2,-1));
            }
        }
        if(x+2<=7&&y-1>=0&&checkColor(x+2,y-1)){
            if (offset(2,-1)!=null) {
                chessboardPointList.add(offset(2,-1));
            }
        }
        return chessboardPointList;
    }

    public boolean checkColor(int x,int y){
        return p[x][y].getChessColor() != getChessColor();
    }
    public ChessboardPoint offset(int dx, int dy) {
        if (getSource().getX() + dx >= 0 && getSource().getX() + dx <= 7 && getSource().getY() + dy >= 0 && getSource().getY() + dy <= 7) {
            return new ChessboardPoint(getSource().getX() + dx, getSource().getY() + dy);
        } else return null;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}