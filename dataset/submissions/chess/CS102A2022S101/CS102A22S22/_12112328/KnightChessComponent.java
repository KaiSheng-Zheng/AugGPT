import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private int x;
    private int y;
    private char f;

    public KnightChessComponent(int x, int y,char f) {
        this.x = x;
        this.y = y;
        this.f=f;
    }

    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
    private int[] dx={-2,-2,-1,-1,1,1,2,2};
    private int[] dy={-1,1,-2,2,-2,2,-1,1};

    ChessboardPoint boo=new ChessboardPoint(x,y);


    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);
        int xx,yy;
        if (f=='N'){
        for (int i=0;i<=dy.length-1;i++){
            if (boo.offset(dx[i],dy[i])!=null){
                ass.add(boo.offset(dx[i],dy[i]));}
            else{
                xx=x+dx[i];
                yy=y+dy[i];
                if(xx<0||xx>7||yy<0||yy>7||(!(('a'<ConcreteChessGame.board[xx][yy].name)&&(ConcreteChessGame.board[xx][yy].name<'z')))) continue;
                else {
                    ass.add(new ChessboardPoint(xx,yy));

                }
            }
        }
        }
        if (f=='n'){
            for (int i=0;i<=dy.length-1;i++){
                if (boo.offset(dx[i],dy[i])!=null){
                    ass.add(boo.offset(dx[i],dy[i]));}
                else{
                    xx=x+dx[i];
                    yy=y+dy[i];
                    if(xx<0||xx>7||yy<0||yy>7||(!(('A'<ConcreteChessGame.board[xx][yy].name)&&(ConcreteChessGame.board[xx][yy].name<'Z')))) continue;
                    else {
                        ass.add(new ChessboardPoint(xx,yy));

                    }
                }
            }
        }

        return ass;
    }
}
