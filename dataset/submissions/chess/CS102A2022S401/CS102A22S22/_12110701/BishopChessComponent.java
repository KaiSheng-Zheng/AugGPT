import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
private ChessComponent[][] chessComponents=new ChessComponent[8][8];


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
        if (getChessColor()==ChessColor.BLACK) {
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y+j<=7){
                    if (checkColor(x+i,y+j)){
                        break;
                    }else if (p[x+i][y+j].getChessColor()==ChessColor.WHITE){
                        if (offset(i,j)!=null) {
                            chessboardPointList.add(offset(i,j));
                        }
                        break;
                    }else if (offset(i,j)!=null) {
                        chessboardPointList.add(offset(i,j));
                    }
                }
            }
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y-j>=0){
                    if (checkColor(x+i,y-j)){
                        break;
                    }else if (p[x+i][y-j].getChessColor()==ChessColor.WHITE){
                        if (offset(i,-j)!=null) {
                            chessboardPointList.add(offset(i,-j));
                        }
                        break;
                    }else if (offset(i,-j)!=null) {
                        chessboardPointList.add(offset(i,-j));
                    }
                }
            }
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y+j<=7){
                    if (checkColor(x-i,y+j)){
                        break;
                    }else if (p[x-i][y+j].getChessColor()==ChessColor.WHITE){
                        if (offset(-i,j)!=null) {
                            chessboardPointList.add(offset(-i,j));
                        }
                        break;
                    }else if (offset(-i,j)!=null) {
                        chessboardPointList.add(offset(-i,j));
                    }
                }
            }
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y-j>=0){
                    if (checkColor(x-i,y-j)){
                        break;
                    }else if (p[x-i][y-j].getChessColor()==ChessColor.WHITE){
                        if (offset(-i,-j)!=null) {
                            chessboardPointList.add(offset(-i,-j));
                        }
                        break;
                    }else if (offset(-i,-j)!=null) {
                        chessboardPointList.add(offset(-i,-j));
                    }
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE) {
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y+j<=7){
                    if (checkColor(x+i,y+j)){
                        break;
                    }else if (p[x+i][y+j].getChessColor()==ChessColor.BLACK){
                        if (offset(i,j)!=null) {
                            chessboardPointList.add(offset(i,j));
                        }
                        break;
                    }else if (offset(i,j)!=null) {
                        chessboardPointList.add(offset(i,j));
                    }
                }
            }
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y-j>=0){
                    if (checkColor(x+i,y-j)){
                        break;
                    }else if (p[x+i][y-j].getChessColor()==ChessColor.BLACK){
                        if (offset(i,-j)!=null) {
                            chessboardPointList.add(offset(i,-j));
                        }
                        break;
                    }else if (offset(i,-j)!=null) {
                        chessboardPointList.add(offset(i,-j));
                    }
                }
            }
            for (int i = 1, j =1; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y+j<=7){
                    if (checkColor(x-i,y+j)){
                        break;
                    }else if (p[x-i][y+j].getChessColor()==ChessColor.BLACK){
                        if (offset(-i,j)!=null) {
                            chessboardPointList.add(offset(-i,j));
                        }
                        break;
                    }else if (offset(-i,j)!=null) {
                        chessboardPointList.add(offset(-i,j));
                    }
                }
            }
            for (int i = 1, j = 1; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y-j>=0){
                    if (checkColor(x-i,y-j)){
                        break;
                    }else if (p[x-i][y-j].getChessColor()==ChessColor.BLACK){
                        if (offset(-i,-j)!=null) {
                            chessboardPointList.add(offset(-i,-j));
                        }
                        break;
                    }else if (offset(-i,-j)!=null) {
                        chessboardPointList.add(offset(-i,-j));
                    }
                }
            }
        }
        return chessboardPointList;
    }
    public ChessboardPoint offset(int dx, int dy) {
        if (getSource().getX() + dx >= 0 && getSource().getX() + dx <= 7 && getSource().getY() + dy >= 0 && getSource().getY() + dy <= 7) {
            return new ChessboardPoint(getSource().getX() + dx, getSource().getY() + dy);
        } else return null;
    }

    public boolean checkColor(int x,int y){
        return p[x][y].getChessColor()== getChessColor();
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}