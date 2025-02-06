import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private int x;
    private int y;
    private char f;


    public QueenChessComponent(int x, int y, char f) {
        this.x = x;
        this.y = y;
        this.f=f;
    }
    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
    //private int[] dx={-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-3,-2,-2,-2,-1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7};
    //private int[] dy={-7,0,7,-6,0,6,-5,0,5,-4,0,4,-3,0,3,-2,0,2,-1,0,1,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,-1,0,1,-2,0,2,-3,0,3,-4,0,4,-5,0,5,-6,0,6,-7,0,7};
    ChessboardPoint boo=new ChessboardPoint(x,y);
    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);
       // for (int i=0;i<=dy.length-1;i++){
        //    //if (dx[i]<0&&dx[])
       //     if (boo.offset(dx[i],dy[i])!=null)
       //         ass.add(boo.offset(dx[i],dy[i]));
      //  }
        if (f=='Q'){
        int i=0;
            for (i=-1;i>=-7;i--){
                if (boo.offset(0,i)==null) break;
                else    ass.add(boo.offset(0,i));
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x][y+i].name)&&(ConcreteChessGame.board[x][y+i].name<'z')){
                ass.add(new ChessboardPoint(x,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(0,i)==null) break;
                else    ass.add(boo.offset(0,i));
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.board[x][y+i].name)&&(ConcreteChessGame.board[x][y+i].name<'z')){
                ass.add(new ChessboardPoint(x,y+i));
            }
            for (i=-1;i>=-7;i--){
                if (boo.offset(i,0)==null) break;
                else    ass.add(boo.offset(i,0));
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('a'<ConcreteChessGame.board[x+i][y].name)&&(ConcreteChessGame.board[x+i][y].name<'z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(i,0)==null) break;
                else    ass.add(boo.offset(i,0));
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('a'<ConcreteChessGame.board[x+i][y].name)&&(ConcreteChessGame.board[x+i][y].name<'z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
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
        if (f=='q'){
            int i=0;
            for (i=-1;i>=-7;i--){
                if (boo.offset(0,i)==null) break;
                else    ass.add(boo.offset(0,i));
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x][y+i].name)&&(ConcreteChessGame.board[x][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x,y+i));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(0,i)==null) break;
                else    ass.add(boo.offset(0,i));
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.board[x][y+i].name)&&(ConcreteChessGame.board[x][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x,y+i));
            }
            for (i=-1;i>=-7;i--){
                if (boo.offset(i,0)==null) break;
                else    ass.add(boo.offset(i,0));
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('A'<ConcreteChessGame.board[x+i][y].name)&&(ConcreteChessGame.board[x+i][y].name<'Z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
            for (i=1;i<=7;i++){
                if (boo.offset(i,0)==null) break;
                else    ass.add(boo.offset(i,0));
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('A'<ConcreteChessGame.board[x+i][y].name)&&(ConcreteChessGame.board[x+i][y].name<'Z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
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

