import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private int x;
    private int y;
    private char f;

    public BishopChessComponent(int x, int y,char f) {
        this.x = x;
        this.y = y;
        this.f=f;
    }
    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
   // private int[] dx={-7,-7,-6,-6,-5,-5,-4,-4,-3,-3,-2,-2,-1,-1,1,1,2,2,3,3,4,4,5,5,6,6,7,7};
    //private int[] dy={-7,7,-6,6,-5,5,-4,4,-3,3,-2,2,-1,1,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7};
    ChessboardPoint boo=new ChessboardPoint(x,y);
    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);
        //for (int i=0;i<=dy.length-1;i++){
        //    if (boo.offset(dx[i],dy[i])!=null)
        //        ass.add(boo.offset(dx[i],dy[i]));
        //}
        if (f=='B'){
            int i=0;

            for (i=-1;i>=-7;i--){
                if (boo.offset(i,i)==null) break;
                else    ass.add(boo.offset(i,i));
            }
            if (x+i>=0&&x+i<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x+i][y+i].name)&&(ConcreteChessGame.board[x+i][y+i].name<'z')){
                ass.add(new ChessboardPoint(x+i,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(-i,i)==null) break;
                else    ass.add(boo.offset(-i,i));
            }
            if (x-i>=0&&x-i<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x-i][y+i].name)&&(ConcreteChessGame.board[x-i][y+i].name<'z')){
                ass.add(new ChessboardPoint(x-i,y+i));
            }
            for (i=-1;i>=-7;i--){
                if (boo.offset(-i,i)==null) break;
                else    ass.add(boo.offset(-i,i));
            }
            if (x-i>=0&&x-i<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x-i][y+i].name)&&(ConcreteChessGame.board[x-i][y+i].name<'z')){
                ass.add(new ChessboardPoint(x-i,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(i,i)==null) break;
                else    ass.add(boo.offset(i,i));
            }
            if (x+i>=0&&x+i<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x+i][y+i].name)&&(ConcreteChessGame.board[x+i][y+i].name<'z')){
                ass.add(new ChessboardPoint(x+i,y+i));
            }
        }
        if (f=='b'){
            int i=0;

            for (i=-1;i>=-7;i--){
                if (boo.offset(i,i)==null) break;
                else    ass.add(boo.offset(i,i));
            }
            if (x+i>=0&&x+i<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x+i][y+i].name)&&(ConcreteChessGame.board[x+i][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x+i,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(-i,i)==null) break;
                else    ass.add(boo.offset(-i,i));
            }
            if (x-i>=0&&x-i<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x-i][y+i].name)&&(ConcreteChessGame.board[x-i][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x-i,y+i));
            }
            for (i=-1;i>=-7;i--){
                if (boo.offset(-i,i)==null) break;
                else    ass.add(boo.offset(-i,i));
            }
            if (x-i>=0&&x-i<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x-i][y+i].name)&&(ConcreteChessGame.board[x-i][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x-i,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(i,i)==null) break;
                else    ass.add(boo.offset(i,i));
            }
            if (x+i>=0&&x+i<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x+i][y+i].name)&&(ConcreteChessGame.board[x+i][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x+i,y+i));
            }
        }
        return ass;
    }
}
