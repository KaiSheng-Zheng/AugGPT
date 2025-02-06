import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent implements Cloneable{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected ChessComponent[][] chessComponents;
    protected char name;

    void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent(){
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.getName());
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    public static List<ChessboardPoint> sort(List<ChessboardPoint> list){
        for (int i=1;i<list.size();i++){
            ChessboardPoint a;
            for (int j=0;j<list.size()-1;j++){
                if (list.get(j).getX()>list.get(i).getX()){
                    a=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,a);
                }
            }
        }
        for (int i=1;i<list.size();i++){
            ChessboardPoint a;
            for (int j=0;j<list.size()-1;j++){
                if (list.get(j).getX()==list.get(i).getX()&&list.get(j).getY()>list.get(i).getY()){
                    a=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,a);
                }
            }
        }
        return list;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
class EmptySlotComponent extends ChessComponent {
    ChessboardPoint source;
    private final ChessColor chessColor;
    protected char name;

    public EmptySlotComponent(int x,int y){
        source=new ChessboardPoint(x,y);
        chessColor=ChessColor.NONE;
        name='_';
    }
    public EmptySlotComponent(){
        chessColor=ChessColor.NONE;
        name='_';
    }

    @Override
    public char getName() {
        return name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public BishopChessComponent(int x,int y,ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=chessColor==ChessColor.BLACK?'B':'b';
    }
    public BishopChessComponent(){}

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for (int i=1;;i++){
            if (source.offset(i,i)==null){
                break;
            }
            if (chessComponents[x+i][y+i].getName()!='_'){
                if (chessComponents[x+i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(i,i));
                }
                break;
            }
            list1.add(source.offset(i,i));
        }
        for (int i=-1;;i--){
            if (source.offset(i,i)==null){
                break;
            }
            if (chessComponents[x+i][y+i].getName()!='_'){
                if (chessComponents[x+i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(i,i));
                }
                break;
            }
            list1.add(source.offset(i,i));
        }
        for (int i=1;;i++){
            if (source.offset(-i,i)==null){
                break;
            }
            if (chessComponents[x-i][y+i].getName()!='_'){
                if (chessComponents[x-i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(-i,i));
                }
                break;
            }
            list1.add(source.offset(-i,i));
        }
        for (int i=-1;;i--){
            if (source.offset(-i,i)==null){
                break;
            }
            if (chessComponents[x-i][y+i].getName()!='_'){
                if (chessComponents[x-i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(-i,i));
                }
                break;
            }
            list1.add(source.offset(-i,i));
        }
        return sort(list1);
    }
}
class KingChessComponent extends ChessComponent {
    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KingChessComponent(int x, int y, ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=chessColor==ChessColor.BLACK?'K':'k';
    }
    public KingChessComponent(){}
    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (source.offset(1,1)!=null&&(chessComponents[x+1][y+1].getChessColor()!=chessColor)){
            list1.add(source.offset(1,1));
        }
        if (source.offset(-1,1)!=null&&(chessComponents[x-1][y+1].getChessColor()!=chessColor)){
            list1.add(source.offset(-1,1));
        }
        if (source.offset(1,-1)!=null&&(chessComponents[x+1][y-1].getChessColor()!=chessColor)){
            list1.add(source.offset(1,-1));
        }
        if (source.offset(-1,-1)!=null&&(chessComponents[x-1][y-1].getChessColor()!=chessColor)){
            list1.add(source.offset(-1,-1));
        }
        if (source.offset(0,1)!=null&&(chessComponents[x][y+1].getChessColor()!=chessColor)){
            list1.add(source.offset(0,1));
        }
        if (source.offset(1,0)!=null&&(chessComponents[x+1][y].getChessColor()!=chessColor)){
            list1.add(source.offset(1,0));
        }
        if (source.offset(-1,0)!=null&&(chessComponents[x-1][y].getChessColor()!=chessColor)){
            list1.add(source.offset(-1,0));
        }
        if (source.offset(0,-1)!=null&&(chessComponents[x][y-1].getChessColor()!=chessColor)){
            list1.add(source.offset(0,-1));
        }
        return sort(list1);
    }
}
class KnightChessComponent extends ChessComponent {
    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KnightChessComponent(int x, int y, ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=(chessColor==ChessColor.BLACK)?'N':'n';
    }
    public KnightChessComponent(){}
    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (source.offset(2,1)!=null&&(chessComponents[x+2][y+1].getChessColor()!=chessColor)){
            list1.add(source.offset(2,1));
        }
        if (source.offset(-1,2)!=null&&(chessComponents[x-1][y+2].getChessColor()!=chessColor)){
            list1.add(source.offset(-1,2));
        }
        if (source.offset(2,-1)!=null&&(chessComponents[x+2][y-1].getChessColor()!=chessColor)){
            list1.add(source.offset(2,-1));
        }
        if (source.offset(-2,1)!=null&&(chessComponents[x-2][y+1].getChessColor()!=chessColor)){
            list1.add(source.offset(-2,1));
        }
        if (source.offset(-1,-2)!=null&&(chessComponents[x-1][y-2].getChessColor()!=chessColor)){
            list1.add(source.offset(-1,-2));
        }
        if (source.offset(1,2)!=null&&(chessComponents[x+1][y+2].getChessColor()!=chessColor)){
            list1.add(source.offset(1,2));
        }
        if (source.offset(1,-2)!=null&&(chessComponents[x+1][y-2].getChessColor()!=chessColor)){
            list1.add(source.offset(1,-2));
        }
        if (source.offset(-2,-1)!=null&&(chessComponents[x-2][y-1].getChessColor()!=chessColor)){
            list1.add(source.offset(-2,-1));
        }
        return sort(list1);
    }
}
class QueenChessComponent extends ChessComponent {
    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public QueenChessComponent(int x, int y, ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=chessColor==ChessColor.BLACK?'Q':'q';
    }
    public QueenChessComponent(){}
    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for (int i=1;;i++){
            if (source.offset(i,0)==null){
                break;
            }
            if (chessComponents[x+i][y].getName()!='_'){
                if (chessComponents[x+i][y].getChessColor()!=chessColor){
                    list1.add(source.offset(i,0));
                }
                break;
            }
            list1.add(source.offset(i,0));
        }
        for (int i=-1;;i--){
            if (source.offset(i,0)==null){
                break;
            }
            if (chessComponents[x+i][y].getName()!='_'){
                if (chessComponents[x+i][y].getChessColor()!=chessColor){
                    list1.add(source.offset(i,0));
                }
                break;
            }
            list1.add(source.offset(i,0));
        }
        for (int i=1;;i++){
            if (source.offset(0,i)==null){
                break;
            }
            if (chessComponents[x][y+i].getName()!='_'){
                if (chessComponents[x][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(0,i));
                }
                break;
            }
            list1.add(source.offset(0,i));
        }
        for (int i=-1;;i--){
            if (source.offset(0,i)==null){
                break;
            }
            if (chessComponents[x][y+i].getName()!='_'){
                if (chessComponents[x][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(0,i));
                }
                break;
            }
            list1.add(source.offset(0,i));
        }
        for (int i=1;;i++){
            if (source.offset(i,i)==null){
                break;
            }
            if (chessComponents[x+i][y+i].getName()!='_'){
                if (chessComponents[x+i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(i,i));
                }
                break;
            }
            list1.add(source.offset(i,i));
        }
        for (int i=-1;;i--){
            if (source.offset(i,i)==null){
                break;
            }
            if (chessComponents[x+i][y+i].getName()!='_'){
                if (chessComponents[x+i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(i,i));
                }
                break;
            }
            list1.add(source.offset(i,i));
        }
        for (int i=1;;i++){
            if (source.offset(-i,i)==null){
                break;
            }
            if (chessComponents[x-i][y+i].getName()!='_'){
                if (chessComponents[x-i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(-i,i));
                }
                break;
            }
            list1.add(source.offset(-i,i));
        }
        for (int i=-1;;i--){
            if (source.offset(-i,i)==null){
                break;
            }
            if (chessComponents[x-i][y+i].getName()!='_'){
                if (chessComponents[x-i][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(-i,i));
                }
                break;
            }
            list1.add(source.offset(-i,i));
        }
        return sort(list1);
    }
}
class PawnChessComponent extends ChessComponent {
    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name; // duplicate definition of name field.
    public PawnChessComponent(int x, int y, ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=chessColor==ChessColor.BLACK?'P':'p';
    }
    public PawnChessComponent(){}
    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (chessColor==ChessColor.BLACK){
            if (source.offset(1,0)!=null&&chessComponents[x+1][y].getName()=='_'){
                list1.add(source.offset(1,0));
                if (x==1&&chessComponents[x+2][y].getName()=='_'){
                    list1.add(source.offset(2,0));
                }
            }
            if (source.offset(1,1)!=null&&chessComponents[x+1][y+1].getName()!='_'){
                if (chessComponents[x+1][y+1].getChessColor()!=chessColor){
                    list1.add(source.offset(1,1));
                }
            }
            if (source.offset(1,-1)!=null&&chessComponents[x+1][y-1].getName()!='_'){
                if (chessComponents[x+1][y-1].getChessColor()!=chessColor){
                    list1.add(source.offset(1,-1));
                }
            }
        }
        if (chessColor==ChessColor.WHITE){
            if (source.offset(-1,0)!=null&&chessComponents[x-1][y].getName()=='_'){
                list1.add(source.offset(-1,0));
                if (x==6&&chessComponents[x-2][y].getName()=='_'){
                    list1.add(source.offset(-2,0));
                }
            }
            if (source.offset(-1,1)!=null&&chessComponents[x-1][y+1].getName()!='_'){
                if (chessComponents[x-1][y+1].getChessColor()!=chessColor){
                    list1.add(source.offset(-1,1));
                }
            }
            if (source.offset(-1,-1)!=null&&chessComponents[x-1][y-1].getName()!='_'){
                if (chessComponents[x-1][y-1].getChessColor()!=chessColor){
                    list1.add(source.offset(-1,-1));
                }
            }
        }
        return sort(list1);
    }
}
class RookChessComponent extends ChessComponent {
    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public RookChessComponent(int x, int y, ChessColor chessColor){
        source=new ChessboardPoint(x,y);
        this.chessColor=chessColor;
        name=chessColor==ChessColor.BLACK?'R':'r';
    }
    public RookChessComponent(){}
    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list1=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for (int i=1;;i++){
            if (source.offset(i,0)==null){
                break;
            }
            if (chessComponents[x+i][y].getName()!='_'){
                if (chessComponents[x+i][y].getChessColor()!=chessColor){
                    list1.add(source.offset(i,0));
                }
                break;
            }
            list1.add(source.offset(i,0));
        }
        for (int i=-1;;i--){
            if (source.offset(i,0)==null){
                break;
            }
            if (chessComponents[x+i][y].getName()!='_'){
                if (chessComponents[x+i][y].getChessColor()!=chessColor){
                    list1.add(source.offset(i,0));
                }
                break;
            }
            list1.add(source.offset(i,0));
        }
        for (int i=1;;i++){
            if (source.offset(0,i)==null){
                break;
            }
            if (chessComponents[x][y+i].getName()!='_'){
                if (chessComponents[x][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(0,i));
                }
                break;
            }
            list1.add(source.offset(0,i));
        }
        for (int i=-1;;i--){
            if (source.offset(0,i)==null){
                break;
            }
            if (chessComponents[x][y+i].getName()!='_'){
                if (chessComponents[x][y+i].getChessColor()!=chessColor){
                    list1.add(source.offset(0,i));
                }
                break;
            }
            list1.add(source.offset(0,i));
        }
        return sort(list1);
    }
}