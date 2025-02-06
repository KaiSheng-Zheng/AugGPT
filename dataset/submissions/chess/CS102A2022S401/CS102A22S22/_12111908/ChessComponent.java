
import javax.print.attribute.standard.Destination;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
class KingChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        int[] dx = {0,1,1,1,0,0,-1,-1,-1};
        int[] dy = {0,-1,0,+1,-1,+1,-1,0,+1};
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint Destination = getSource();
        int x = Destination.getX(),y = Destination.getY();
        for(int i = 1;i <= 8;i++){
            int DX = x + dx[i];
            int DY = y + dy[i];
            if(DX>=0 && DX <= 7 && DY >= 0 && DY <= 7){
                ans.add(new ChessboardPoint(DX,DY));
            }
        }
        return ans;
    }

    public KingChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class QueenChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint source = getSource();
        int x = getSource().getX(),y = getSource().getY();
        for(int i = 0;i <= 7;i++){
            if(i != y) ans.add(new ChessboardPoint(x,i));
            if(i != x)ans.add(new ChessboardPoint(i,y));
            if(i == 0) continue;

            if(source.offset(i,i) != null) ans.add(source.offset(i,i));
            if(source.offset(i,-i) != null) ans.add(source.offset(i,-i));
            if(source.offset(-i,i) != null) ans.add(source.offset(-i,i));
            if(source.offset(-i,-i) != null) ans.add(source.offset(-i,-i));
        }
        return ans;
    }
    public QueenChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class RookChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX(),y = getSource().getY();
        for(int i = 0;i <= 7;i++) {
            if (i != y) ans.add(new ChessboardPoint(x, i));
            if (i != x) ans.add(new ChessboardPoint(i, y));
        }
        return ans;
    }
    public RookChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint source = getSource();
        for(int i = 1;i <= 7;i++){
            if(source.offset(i,i) != null) ans.add(source.offset(i,i));
            if(source.offset(i,-i) != null) ans.add(source.offset(i,-i));
            if(source.offset(-i,i) != null) ans.add(source.offset(-i,i));
            if(source.offset(-i,-i) != null) ans.add(source.offset(-i,-i));
        }
        return ans;
    }
    public BishopChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class KnightChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint source = getSource();
        int dx[] = {1,-1,1,-1,-2,-2,+2,+2};
        int dy[] = {-2,-2,+2,+2,-1,1,-1,1};
        for(int i = 0;i <= 7 ;i++){
            ChessboardPoint tmp = source.offset(dx[i],dy[i]);
            if(tmp != null) ans.add(tmp);
        }
        return ans;
    }
    public KnightChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class PawnChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint source = getSource();
        if(getChessColor() == ChessColor.WHITE){
            ChessboardPoint tmp = source.offset(1,0);
            if(tmp != null) ans.add(tmp);
        }
        if(getChessColor() == ChessColor.BLACK){
            ChessboardPoint tmp = source.offset(-1,0);
            if(tmp != null) ans.add(tmp);
        }
        return ans;
    }
    public PawnChessComponent(int x,int y,ChessColor chessColor,char name) {
        super(new ChessboardPoint(x,y),chessColor,name);
    }
}
class EmptySlotComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
    public EmptySlotComponent(int x,int y) {
        super(new ChessboardPoint(x,y),ChessColor.NONE,'_');
    }
}