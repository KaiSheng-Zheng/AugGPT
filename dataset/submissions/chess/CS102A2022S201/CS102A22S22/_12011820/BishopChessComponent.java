import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    private char name;			// What's the name
    ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = source.getX();
        int y = source.getY();
        /***for(int dx = 1 ;dx>-2;dx-=2) {
            for (int dy = 1; dy > -2; dy -= 2) {
                for (int i = 0; i < 8; i++) {
                    int x_ = x + dx * i;
                    int y_ = y + dy * i;
                    if (x + dx * i > -1 && x + dx * i < 8 && y + dy * i > -1 && y + dy * i < 8){
                        if((!chessComponents[x_][y_].getChessColor().equals(chessColor))&&emptyTest(x,y,x_,y_)){
                            result.add(new ChessboardPoint(x + dx * i, y + dy * i));
                        }
                    }
                }
            }
        }***/
        int dx ,dy;

        dx = 1;dy = 1;
        for(int i= 1 ;i<8;i++){
            int x_ = x + dx * i;
            int y_ = y + dy * i;

            if(x_>-1&&x_<8&&y_>-1&&y_<8) {
                if (emptyTest(x, y, x_, y_)) {
                    result.add(new ChessboardPoint(x_, y_));
                }
            }
        }

        dx = -1;dy = 1;
        for(int i= 1 ;i<8;i++){
            int x_ = x + dx * i;
            int y_ = y + dy * i;

            if(x_>-1&&x_<8&&y_>-1&&y_<8) {
                if (emptyTest(x, y, x_, y_)) {
                    result.add(new ChessboardPoint(x_, y_));
                }
            }
        }

        dx = -1;dy = -1;
        for(int i= 1 ;i<8;i++){
            int x_ = x + dx * i;
            int y_ = y + dy * i;
            if(x_>-1&&x_<8&&y_>-1&&y_<8) {
                if (emptyTest(x, y, x_, y_)) {
                    result.add(new ChessboardPoint(x_, y_));
                }
            }
        }

        dx = 1;dy = -1;
        for(int i= 1 ;i<8;i++){
            int x_ = x + dx * i;
            int y_ = y + dy * i;
            if(x_>-1&&x_<8&&y_>-1&&y_<8) {
                if (emptyTest(x, y, x_, y_)) {
                    result.add(new ChessboardPoint(x_, y_));
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

    private boolean emptyTest(int x ,int y,int x_,int y_){
        int X = x>x_ ? -1:1;
        int Y = y>y_ ? -1:1;
        int count = Math.max(x,x_) - Math.min(x,x_);
        if(count==1){
            if(!chessComponents[x_][y_].getChessColor().equals(this.getChessColor())) return true;
        }
        for(int i = 1 ;i<count ;i++){
            if(!chessComponents[x+X*i][y+Y*i].getChessColor().equals(ChessColor.NONE)) return false;
        }
        if(chessComponents[x_][y_].getChessColor().equals(this.getChessColor())){
            return false;
        }
        return true;
    }

    public void printAllCanMoveTo(){
        List<ChessboardPoint> com = this.canMoveTo();
        for(ChessboardPoint a: com){
            System.out.println("("+a.getX()+","+a.getY()+")");
        }
    }

    public  BishopChessComponent(char name , ChessColor a, ChessboardPoint b,ChessComponent[][] chessComponents){
        this.name = name ;
        chessColor = a;
        source = b;
        this.chessComponents = chessComponents;
    }
    public char getName(){
        return this.name;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}
