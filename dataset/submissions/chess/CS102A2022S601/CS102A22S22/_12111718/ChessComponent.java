import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getMovetime() {
        return movetime;
    }

    public void setMovetime(int movetime) {
        this.movetime = movetime;
    }

    protected char name;
    private int movetime=0;
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
//    public int[][][] kingsmove1=new int[2][2][2];
//
//    public void setKingsmove1(int[][][] kingsmove1) {
//        kingsmove1[0][0][0]=-1;
//        kingsmove1[1][0][0]=1;
//        kingsmove1[0][1][0]=-1;
//        kingsmove1[1][1][0]=1;
//        kingsmove1[0][0][1]=1;
//        kingsmove1[1][0][1]=1;
//        kingsmove1[0][1][1]=-1;
//        kingsmove1[1][1][1]=-1;
//        this.kingsmove1=kingsmove1;
//    }
//
//    public void setKingsmove2(int[][][] kingsmove2) {
//        kingsmove2[0][0][0]=-1;
//        kingsmove2[1][0][0]=0;
//        kingsmove2[0][1][0]=0;
//        kingsmove2[1][1][0]=1;
//        kingsmove2[0][0][1]=0;
//        kingsmove2[1][0][1]=1;
//        kingsmove2[0][1][1]=-1;
//        kingsmove2[1][1][1]=0;
//        this.kingsmove2=kingsmove2;
//    }
//
//    public int[][][] kingsmove2=new int[2][2][2];
    public int[][][][] kingsmove=new int[2][2][2][2];

    public void setKingsmove() {
        kingsmove[0][1][0][0]=-1;
        kingsmove[1][1][0][0]=1;
        kingsmove[0][0][0][0]=-1;
        kingsmove[1][0][0][0]=1;
        kingsmove[0][1][1][0]=1;
        kingsmove[1][1][1][0]=1;
        kingsmove[0][0][1][0]=-1;
        kingsmove[1][0][1][0]=-1;
        kingsmove[0][1][0][1]=-1;
        kingsmove[1][1][0][1]=0;
        kingsmove[0][0][0][1]=0;
        kingsmove[1][0][0][1]=1;
        kingsmove[0][1][1][1]=0;
        kingsmove[1][1][1][1]=1;
        kingsmove[0][0][1][1]=-1;
        kingsmove[1][0][1][1]=0;
    }
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'K':'k');
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        for (int i=0;i<2;i++){
            for (int m=0;m<2;m++){
                for (int n=0;n<2;n++){
                    if (getSource().offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i])!=null){
                    points.add(getSource().offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i]).realoffset(this));}
                }
            }
        }
        return points;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'Q':'q');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        int k=-1;
        for (int i=0;i<2;i++){
            for (int m=0;m<2;m++){
                for (int n=0;n<2;n++){
                    if (getSource().offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i])!=null){
                    points.add(getSource().offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i]).realoffset(this));
                    k++;
                    while (points.get(k)!=null&&points.get(k).eatormove(this)!=1){
                        if (points.get(k).offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i])!=null){
                        points.add(points.get(k).offset(kingsmove[m][n][0][i],kingsmove[m][n][1][i]).realoffset(this));
                        k++;}
                        else break;
                    }}
                }
            }
        }
        return points;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'R':'r');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        int k=-1;
        for (int m=0;m<2;m++){
                for (int n=0;n<2;n++){
                    if (getSource().offset(kingsmove[m][n][0][1],kingsmove[m][n][1][1])!=null){
                    points.add(getSource().offset(kingsmove[m][n][0][1],kingsmove[m][n][1][1]).realoffset(this));
                    k++;
                    while (points.get(k)!=null&&points.get(k).eatormove(this)!=1){
                        if (points.get(k).offset(kingsmove[m][n][0][1],kingsmove[m][n][1][1])!=null){
                        points.add(points.get(k).offset(kingsmove[m][n][0][1],kingsmove[m][n][1][1]).realoffset(this));
                        k++;}
                        else break;
                    }}
                }
            }

        return points;
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'B':'b');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        int k=-1;
        for (int m=0;m<2;m++){
                for (int n=0;n<2;n++){
                    if (getSource().offset(kingsmove[m][n][0][0],kingsmove[m][n][1][0])!=null){
                    points.add(getSource().offset(kingsmove[m][n][0][0],kingsmove[m][n][1][0]).realoffset(this));
                    k++;
                    while (points.get(k)!=null&&points.get(k).eatormove(this)!=1){
                        if (points.get(k).offset(kingsmove[m][n][0][0],kingsmove[m][n][1][0])!=null){
                        points.add(points.get(k).offset(kingsmove[m][n][0][0],kingsmove[m][n][1][0]).realoffset(this));
                            k++;}
                        else break;
                    }}
                }
            }

        return points;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'N':'n');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        for (int m=0;m<2;m++){
            for (int n=0;n<2;n++){
                for (int i=0;i<2;i++){
                    if (getSource().offset(kingsmove[m][n][0][0]+i*kingsmove[m][n][0][0],kingsmove[m][n][1][0]-(i-1)*kingsmove[m][n][1][0])!=null){
                    points.add(getSource().offset(kingsmove[m][n][0][0]+i*kingsmove[m][n][0][0],kingsmove[m][n][1][0]-(i-1)*kingsmove[m][n][1][0]).realoffset(this));}
                }
            }
        }
        return points;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor color,ChessComponent[][] chessComponents,ChessboardPoint point)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'P':'p');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        if (getMovetime()==0&&getSource().getX()==(getChessColor()==ChessColor.BLACK?1:6)){
            for (int i=0;i<2;i++){
                if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0])!=null){
                    if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0]).eatormove(this)==1){
                        points.add(getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0]).realoffset(this));}
                }
            }
            if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1])!=null) {
                if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1]).eatormove(this)==0){
                    points.add(getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1]).realoffset(this));
                    if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]+1),kingsmove[1][1][0][1])!=null) {
                if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]+1),kingsmove[1][1][0][1]).eatormove(this)==0){
                    points.add(getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]+1),kingsmove[1][1][0][1]).realoffset(this));}
            }}}
        }
        else {
            for (int i=0;i<2;i++){
                    if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0])!=null){
                       if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0]).eatormove(this)==1){
                        points.add(getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*kingsmove[i][1][1][0],kingsmove[i][1][0][0]).realoffset(this));}
                }
            }
            if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1])!=null) {
                if (getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1]).eatormove(this)==0){
                    points.add(getSource().offset((getChessColor()==ChessColor.BLACK?1:-1)*(kingsmove[1][1][1][1]),kingsmove[1][1][0][1]).realoffset(this));}
            }
        }
        return points;
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent()
    {
        setName('_');
        setChessColor(ChessColor.NONE);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        setKingsmove();
        return new ArrayList<>();
    }
}