import java.util.*;
public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chessComponents;
    public ChessComponent() {}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
        setSource(point);
        setChessColor(color);
        setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('k');}
        else if (color==ChessColor.BLACK){setName('K');}
    }
    public List<ChessboardPoint> canMoveTo(){
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (Math.abs(i-x)<=1&&Math.abs(j-y)<=1){
                    ChessboardPoint point=new ChessboardPoint(i,j); points.add(point);}}}
        points.remove(new ChessboardPoint(x,y));
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
        return points;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
        setSource(point);
        setChessColor(color);
        setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('q');}
        else if (color==ChessColor.BLACK){setName('Q');}
    }
        @Override
        public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
            if (i==x||j==y||(Math.abs(x-i)==Math.abs(y-j)) ){
                ChessboardPoint point=new ChessboardPoint(i,j); points.add(point);}}}
        points.remove(new ChessboardPoint(x,y));
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
         return points;}
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
    setSource(point);
    setChessColor(color);
    setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('r');}
        else if (color==ChessColor.BLACK){setName('R');}
    }
    public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (i==x||j==y){
                    ChessboardPoint point=new ChessboardPoint(i,j);  points.add(point);}}}
        points.remove(new ChessboardPoint(x,y));
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
        return points;}
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
        setSource(point);
        setChessColor(color);
        setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('b');}
        else if (color==ChessColor.BLACK){setName('B');}
    }
    public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((Math.abs(x-i)==Math.abs(y-j)) ){
                    ChessboardPoint point=new ChessboardPoint(i,j);  points.add(point);}}}
        points.remove(new ChessboardPoint(x,y));
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
        return points;}
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
        setSource(point);
        setChessColor(color);
        setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('n');}
        else if (color==ChessColor.BLACK){setName('N');}
    }
    public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((Math.abs(i-x)==1&&Math.abs(j-y)==2)||Math.abs(i-x)==2&&Math.abs(j-y)==1){
                    ChessboardPoint point=new ChessboardPoint(i,j);points.add(point);}}}
        points.remove(new ChessboardPoint(x,y));
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
        return points;}
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents) {
        setSource(point);
        setChessColor(color);
        setChessComponents(chessComponents);
        if (color==ChessColor.WHITE){setName('p');}
        else if (color==ChessColor.BLACK){setName('P');}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();int y=getSource().getY();
        List<ChessboardPoint> points= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint point=new ChessboardPoint(i,j);
                if (getChessColor()==ChessColor.WHITE){
                    if (x==6&&i==4&&j==y){points.add(point);}
                    if (i==x-1&&Math.abs(j-y)<=1){points.add(point);}}
                if (getChessColor()==ChessColor.BLACK){
                    if (x==1&&i==3&&j==y){points.add(point);}
                    if(i==x+1&&Math.abs(j-y)<=1){points.add(point);}
                }}}
        if (!points.isEmpty()){ConcreteChessGame.move(getSource(),getChessComponents(),points);}
        return points;}
}
class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent() {
        setName('_');}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}