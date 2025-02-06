import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
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
        if (getChessColor()==ChessColor.BLACK) {
            for (int i = 0; i < 7 - x; i++) {
                if (checkColor(x + i + 1, y)) {
                    break;
                } else if (p[x+i+1][y].getChessColor()==ChessColor.WHITE){
                    if (offset(i+1,0)!=null) {
                        chessboardPointList.add(offset(i+1,0));
                    }
                    break;
                }else {
                    if (offset(i+1,0)!=null) {
                        chessboardPointList.add(offset(i+1,0));
                    }
                }
            }
            for (int i = 0; i < 7 - y; i++) {
                if (checkColor(x, y + i + 1)) {
                    break;
                } else if (p[x][y+i+1].getChessColor()==ChessColor.WHITE) {
                    if (offset(0,i+1)!=null) {
                        chessboardPointList.add(offset(0,i+1));
                    }
                    break;
                }else {
                    if (offset(0,i+1)!=null) {
                        chessboardPointList.add(offset(0,i+1));
                    }
                }
            }
            
            for (int i = 0; i > -x; i--) {
                if (checkColor(x + i - 1, y)) {
                    break;
                }else if (p[x+i-1][y].getChessColor()==ChessColor.WHITE) {
                    if (offset(i-1,0)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                    break;
                } else {
                    if (offset(i-1,0)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                }
            }
            for (int i = 0; i > -y; i--) {
                if (checkColor(x, y + i - 1)) {
                    break;
                } else if (p[x][y+i-1].getChessColor()==ChessColor.WHITE) {
                    if (offset(0,i-1)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                    break;
                }else {
                    if (offset(0,i-1)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE){
            for (int i = 0; i < 7 - x; i++) {
                if (checkColor(x + i + 1, y)) {
                    break;
                } else if (p[x+i+1][y].getChessColor()==ChessColor.BLACK){
                    if (offset(i+1,0)!=null) {
                        chessboardPointList.add(offset(i+1,0));
                    }
                    break;
                }else {
                    if (offset(i+1,0)!=null) {
                        chessboardPointList.add(offset(i+1,0));
                    }
                }
            }
            for (int i = 0; i < 7 - y; i++) {
                if (checkColor(x, y + i + 1)) {
                    break;
                } else if (p[x][y+i+1].getChessColor()==ChessColor.BLACK) {
                    if (offset(0,i+1)!=null) {
                        chessboardPointList.add(offset(0,i+1));
                    }
                    break;
                }else {
                    if (offset(0,i+1)!=null) {
                        chessboardPointList.add(offset(0,i+1));
                    }
                }
            }
            for (int i = 0; i > -x; i--) {
                if (checkColor(x + i - 1, y)) {
                    break;
                }else if (p[x+i-1][y].getChessColor()==ChessColor.BLACK) {
                    if (offset(i-1,0)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                    break;
                } else {
                    if (offset(i-1,0)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                }
            }
            for (int i = 0; i > -y; i--) {
                if (checkColor(x, y + i - 1)) {
                    break;
                } else if (p[x][y+i-1].getChessColor()==ChessColor.BLACK) {
                    if (offset(0,i-1)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                    break;
                }else {
                    if (offset(0,i-1)!=null) {
                        chessboardPointList.add(offset(i-1,0));
                    }
                }
            }
        }
        return chessboardPointList;
    }

    public boolean checkColor(int x,int y){
        return p[x][y].getChessColor() == getChessColor();
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
