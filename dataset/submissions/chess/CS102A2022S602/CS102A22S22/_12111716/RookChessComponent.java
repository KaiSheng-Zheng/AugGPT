import java.util.ArrayList;
import java.util.List;


public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;


    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX(),y=source.getY();
        List<ChessboardPoint> a=new ArrayList<>();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(x==i||y==j){
                    if(yes(x,y,i,j)){
                        a.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return a;
    }
    public ChessboardPoint getSource(){
        return source;
    }

    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean yes(int x,int y,int i,int j){
        if(chessComponents[x][y].getChessColor()!=chessComponents[i][j].getChessColor()){
            if(x==i&&y<j){
                y++;
                for(;y<j;y++){
                    if(chessComponents[x][y] instanceof EmptySlotComponent){
                        continue;
                    }else {
                        return false;
                    }
                }
            }
            if(x==i&&y>j){
                y--;
                for(;y>j;y--){
                    if(chessComponents[x][y] instanceof EmptySlotComponent){
                        continue;
                    }else {
                        return false;
                    }
                }
            }
            if(x>i&&y==j){
                x--;
                for(;x>i;x--){
                    if(chessComponents[x][y] instanceof EmptySlotComponent){
                        continue;
                    }else {
                        return false;
                    }
                }
            }
            if(x<i&&y==j){
                x++;
                for(;x<i;x++){
                    if(chessComponents[x][y] instanceof EmptySlotComponent){
                        continue;
                    }else {
                        return false;
                    }
                }

            }
        }else {
            return false;
        }
        return true;
    }

}
