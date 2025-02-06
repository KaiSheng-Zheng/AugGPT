import java.util.ArrayList;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;
    public static void main(String[] args) {
//        ChessboardPoint p1=new ChessboardPoint(1,2);
//        System.out.println(p1.toString());
/*        List<String> a = new ArrayList<>();
        a.add("RN__KB_R");
        a.add("PPPPP___");
        a.add("________");
        a.add("________");
        a.add("________");
        a.add("________");
        a.add("pppppppp");
        a.add("rnbqkbnr");
        a.add("b");
        ChessGame b =new ConcreteChessGame();
        b.loadChessGame(a);
        b.moveChess(0,5,2,7);
        System.out.printf(b.getChessboardGraph());*/
    }
    public ChessboardPoint(int x,int y){
        if(x>=0&&x<=7){
            this.x=x;
        }
        if(y>=0&&y<=7){
            this.y=y;
        }
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        String s="("+x+","+y+")";
        return s;
    }
    public ChessboardPoint offset(int dx, int dy){
        int x1=dx+this.x;
        int y1=dy+this.y;
        if(x1>=0&&x1<=7&&y1>=0&&y1<=7){
            ChessboardPoint p1=new ChessboardPoint(x1,y1);
            return p1;
        }else return null;
    }
}
