import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private int x;
    private int y;
    private char f;

    public PawnChessComponent(int x, int y, char f) {
        this.x = x;
        this.y = y;
        this.f=f;
    }
    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
    private int[] dx={-2,-1,2,1,-1,1,1,1};
    private int[] dy={0,0,0,0,-1,-1,-1,1};
    ChessboardPoint boo=new ChessboardPoint(x,y);
    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);
        //System.out.println(x);
        if (f=='p'){
        if (x==1||x==6){

            if (boo.offset(dx[1],dy[1])!=null)
            { ass.add(boo.offset(dx[1],dy[1]));
                if (boo.offset(dx[0],dy[0])!=null){
                ass.add(boo.offset(dx[0],dy[0]));}}
        }
        else{
            if (boo.offset(dx[1],dy[1])!=null)
                ass.add(boo.offset(dx[1],dy[1]));
        }

            int xx,yy;
        for (int i=4;i<=5;i++){
            xx=x+dx[i];
            yy=y+dy[i];
            //System.out.println(new ChessboardPoint(xx,yy));
            if(xx<0||xx>7||yy<0||yy>7||(!(('A'<ConcreteChessGame.board[xx][yy].name)&&(ConcreteChessGame.board[xx][yy].name<'Z')))) continue;
            else {
                ass.add(new ChessboardPoint(xx,yy));

            }
        }
        }
        if (f=='P'){
            if (x==1||x==6){

                if (boo.offset(dx[3],dy[3])!=null){
                    ass.add(boo.offset(dx[3],dy[3]));
                    if (boo.offset(dx[2],dy[2])!=null)
                    {ass.add(boo.offset(dx[2],dy[2]));}
                }
            }
            else{
                if (boo.offset(dx[3],dy[3])!=null)
                    ass.add(boo.offset(dx[3],dy[3]));
            }

            int xx,yy;
            for (int i=6;i<=7;i++){
                xx=x+dx[i];
                yy=y+dy[i];
                //System.out.println(new ChessboardPoint(xx,yy));
                if(xx<0||xx>7||yy<0||yy>7||(!(('a'<ConcreteChessGame.board[xx][yy].name)&&(ConcreteChessGame.board[xx][yy].name<'z')))) continue;
                else {
                    ass.add(new ChessboardPoint(xx,yy));

                }
            }
        }
        return ass;
    }
}
