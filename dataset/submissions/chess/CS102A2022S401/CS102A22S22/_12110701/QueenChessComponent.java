import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
//    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame concreteChessGame) {
//        this.name=name;
//        setSource(source);
//        setChessColor(chessColor);
//        this.concreteChessGame=concreteChessGame;
//    }
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
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y+j<=7){
                    if (checkColor(x+i,y+j)){
                        break;
                    }else if (p[x+i][y+j].getChessColor()==ChessColor.WHITE){
                        chessboardPointList.add(chessboardPoint.offset(i,j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(i,j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y-j>=0){
                    if (checkColor(x+i,y-j)){
                        break;
                    }else if (p[x+i][y-j].getChessColor()==ChessColor.WHITE){
                        chessboardPointList.add(chessboardPoint.offset(i,-j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(i,-j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y+j<=7){
                    if (checkColor(x-i,y+j)){
                        break;
                    }else if (p[x-i][y+j].getChessColor()==ChessColor.WHITE){
                        chessboardPointList.add(chessboardPoint.offset(-i,j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(-i,j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y-j>=0){
                    if (checkColor(x-i,y-j)){
                        break;
                    }else if (p[x-i][y-j].getChessColor()==ChessColor.WHITE){
                        chessboardPointList.add(chessboardPoint.offset(-i,-j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(-i,-j));
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE) {
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y+j<=7){
                    if (checkColor(x+i,y+j)){
                        break;
                    }else if (p[x+i][y+j].getChessColor()==ChessColor.BLACK){
                        chessboardPointList.add(chessboardPoint.offset(i,j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(i,j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x+i<=7&&y-j>=0){
                    if (checkColor(x+i,y-j)){
                        break;
                    }else if (p[x+i][y-j].getChessColor()==ChessColor.BLACK){
                        chessboardPointList.add(chessboardPoint.offset(i,-j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(i,-j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y+j<=7){
                    if (checkColor(x-i,y+j)){
                        break;
                    }else if (p[x-i][y+j].getChessColor()==ChessColor.BLACK){
                        chessboardPointList.add(chessboardPoint.offset(-i,j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(-i,j));
                }
            }
            for (int i = 0, j = 0; i < 8 && j < 8; i++, j++) {
                if (x-i>=0&&y-j>=0){
                    if (checkColor(x-i,y-j)){
                        break;
                    }else if (p[x-i][y-j].getChessColor()==ChessColor.BLACK){
                        chessboardPointList.add(chessboardPoint.offset(-i,-j));
                        break;
                    }else chessboardPointList.add(chessboardPoint.offset(-i,-j));
                }
            }
        }
        if (getChessColor()==ChessColor.BLACK) {
            for (int i = 0; i < 7 - x; i++) {
                if (checkColor(x + i + 1, y)) {
                    break;
                } else if (p[x+i+1][y].getChessColor()==ChessColor.WHITE){
                    chessboardPointList.add(chessboardPoint.offset(i+1,0));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(i + 1, 0));
            }
            for (int i = 0; i < 7 - y; i++) {
                if (checkColor(x, y + i + 1)) {
                    break;
                } else if (p[x][y+i+1].getChessColor()==ChessColor.WHITE) {
                    chessboardPointList.add(chessboardPoint.offset(0, i + 1));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(0, i + 1));
            }
            for (int i = 0; i > -x; i--) {
                if (checkColor(x + i - 1, y)) {
                    break;
                }else if (p[x+i-1][y].getChessColor()==ChessColor.WHITE) {
                    chessboardPointList.add(chessboardPoint.offset(i-1, 0));
                    break;
                } else chessboardPointList.add(chessboardPoint.offset(i - 1, 0));
            }
            for (int i = 0; i > -y; i--) {
                if (checkColor(x, y + i - 1)) {
                    break;
                } else if (p[x][y+i-1].getChessColor()==ChessColor.WHITE) {
                    chessboardPointList.add(chessboardPoint.offset(0, i - 1));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(0, i - 1));
            }
        }
        if (getChessColor()==ChessColor.WHITE){
            for (int i = 0; i < 7 - x; i++) {
                if (checkColor(x + i + 1, y)) {
                    break;
                } else if (p[x+i+1][y].getChessColor()==ChessColor.BLACK){
                    chessboardPointList.add(chessboardPoint.offset(i+1,0));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(i + 1, 0));
            }
            for (int i = 0; i < 7 - y; i++) {
                if (checkColor(x, y + i + 1)) {
                    break;
                } else if (p[x][y+i+1].getChessColor()==ChessColor.BLACK) {
                    chessboardPointList.add(chessboardPoint.offset(0, i + 1));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(0, i + 1));
            }
            for (int i = 0; i > -x; i--) {
                if (checkColor(x + i - 1, y)) {
                    break;
                }else if (p[x+i-1][y].getChessColor()==ChessColor.BLACK) {
                    chessboardPointList.add(chessboardPoint.offset(i-1, 0));
                    break;
                } else chessboardPointList.add(chessboardPoint.offset(i - 1, 0));
            }
            for (int i = 0; i > -y; i--) {
                if (checkColor(x, y + i - 1)) {
                    break;
                } else if (p[x][y+i-1].getChessColor()==ChessColor.BLACK) {
                    chessboardPointList.add(chessboardPoint.offset(0, i - 1));
                    break;
                }else chessboardPointList.add(chessboardPoint.offset(0, i - 1));
            }
        }
        return chessboardPointList;
    }

    public boolean checkColor(int x,int y){
        return p[x][y].getChessColor()== getChessColor();
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}