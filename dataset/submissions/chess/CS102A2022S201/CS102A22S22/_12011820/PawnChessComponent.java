import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    private char name;            // What's the name
    int count = 0;
    ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();

        if (chessColor.equals(ChessColor.BLACK)) {
            if (source.getX()==1) {
                if (moveTest(source.getX(), source.getY(), 1)) {
                    result.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                }

                if (moveTest(source.getX(), source.getY(), 2)) {
                    result.add(new ChessboardPoint(source.getX() + 2, source.getY()));
                }
                if(source.getX() + 1>=0&&source.getX()+1<=7&&source.getY() - 1>=0&&source.getY()-1<=7) {
                    if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor().equals(this.counterColor())) {
                        result.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                    }
                }
                if(source.getX() + 1>=0&&source.getX()+1<=7&&source.getY() - 1>=0&&source.getY()-1<=7) {
                    if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor().equals(this.counterColor())) {
                        result.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                    }
                }

            } else {
                if (moveTest(source.getX(), source.getY(), 1)) {
                    result.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                }if(source.getX() + 1>=0&&source.getX()+1<=7&&source.getY() + 1>=0&&source.getY()+1<=7) {
                    if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor().equals(this.counterColor())) {
                        result.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                    }
                }
                if(source.getX() + 1>=0&&source.getX()+1<=7&&source.getY() - 1>=0&&source.getY()-1<=7) {
                    if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor().equals(this.counterColor())) {
                        result.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                    }
                }
            }
        }
        if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (source.getX()==6 ) {
                if (moveTest(source.getX(), source.getY(), -1)) {
                    result.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                }

                if (moveTest(source.getX(), source.getY(), -2)) {
                    result.add(new ChessboardPoint(source.getX() - 2, source.getY()));
                }
                if(chessComponents[source.getX()-1][source.getY()+1].getChessColor().equals(this.counterColor())){
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
                }
                if(chessComponents[source.getX()-1][source.getY()-1].getChessColor().equals(this.counterColor())){
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
                }
            } else {
                if (moveTest(source.getX(), source.getY(), -1)) {
                    result.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                }
                if(chessComponents[source.getX()-1][source.getY()+1].getChessColor().equals(this.counterColor())){
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
                }
                if(chessComponents[source.getX()-1][source.getY()-1].getChessColor().equals(this.counterColor())){
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
                }
            }
        }
        sort(result);
        return result;
    }
    public void sort(List<ChessboardPoint> com){
        int size = com.size();
        for(int i = 0;i<size;i++){
            for(int k = 0;k<size-1 ;k++){
                ChessboardPoint com1 = com.get(k);
                ChessboardPoint com2 = com.get(k+1);
                if(com1.getX()>com2.getX()) {
                    com.set(k+1,com1);
                    com.set(k,com2);
                }
                else if(com1.getX()== com2.getX()&& com1.getY()>com2.getY()){
                    com.set(k+1,com1);
                    com.set(k,com2);
                }
            }
        }
    }

    private ChessColor counterColor(){
        return getChessColor().equals(ChessColor.WHITE)? ChessColor.BLACK:ChessColor.WHITE;
    }
    private boolean moveTest(int x, int y, int dx) {
        if (dx == 1 || dx == -1) {
            if (!chessComponents[x + dx][y].getChessColor().equals(ChessColor.NONE)) return false;
            else return true;
        } else if (dx == 2 || dx == -2) {
            int dx_ = dx / 2;
            if (chessComponents[x + dx][y].getChessColor().equals(ChessColor.NONE)&&chessComponents[x + dx_][y].getChessColor().equals(ChessColor.NONE)) return true;
            else return false;
        } else return false;
    }

    public void setCount() {
        count++;
    }

    public PawnChessComponent(char name, ChessColor a, ChessboardPoint b, ChessComponent[][] chessComponents) {
        this.name = name;
        chessColor = a;
        source = b;
        this.chessComponents = chessComponents;
    }

    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }
    public int getCount(){
        return count;
    }

    public void printAllCanMoveTo(){
        List<ChessboardPoint> com = this.canMoveTo();
        for(ChessboardPoint a: com){
            System.out.println("("+a.getX()+","+a.getY()+")");
        }
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}
    