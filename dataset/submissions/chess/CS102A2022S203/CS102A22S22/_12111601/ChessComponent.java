import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected ChessComponent[][] chessComponents;
    public ChessComponent(){};
    public ChessColor getChessColor(){return chessColor;};
    public abstract List<ChessboardPoint> canMoveTo();
    public void setSource(ChessboardPoint source){};
    public void setChessComponents(ChessComponent[][] chessComponents){};

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public static boolean checkInbound(int x,int y){
        return (x>=0&&x<=7&&y>=0&&y<=7);
    }
}
class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int[] dx={1,1,-1,-1,0,0,1,-1};
        int[] dy={1,-1,1,-1,1,-1,0,0};
        for(int i=0;i<8;i++){
            int nowX=source.getX()+dx[i],nowY=source.getY()+dy[i];
            if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].getChessColor()!=chessColor){
                tmp.add(new ChessboardPoint(nowX,nowY));
            }
        }
        return tmp;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}
class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int[] dx={1,1,-1,-1,0,0,1,-1};
        int[] dy={1,-1,1,-1,1,-1,0,0};
        for(int i=0;i<8;i++){
            int nowX=source.getX(),nowY=source.getY();
            while(true) {
                nowX = nowX+ dx[i];nowY = nowY+ dy[i];
                if (checkInbound(nowX, nowY)) {
                    if(chessComponents[nowX][nowY].name=='_'){
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        continue;
                    }
                    else if(chessComponents[nowX][nowY].getChessColor()!=chessColor) {
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        break;
                    }
                    else break;
                }
                else break;
            }
        }
        return tmp;
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}
class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        for(int i=0;i<4;i++){
            int nowX=source.getX(),nowY=source.getY();
            while(true) {
                nowX = nowX+ dx[i];nowY = nowY+ dy[i];
                if (checkInbound(nowX, nowY)) {
                    if(chessComponents[nowX][nowY].name=='_'){
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        continue;
                    }
                    else if(chessComponents[nowX][nowY].getChessColor()!=chessColor) {
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        break;
                    }
                    else break;
                }
                else break;
            }
        }
        return tmp;
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}
class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int[] dx={1,1,-1,-1};
        int[] dy={1,-1,1,-1};
        for(int i=0;i<4;i++){
            int nowX=source.getX(),nowY=source.getY();
            while(true) {
                nowX = nowX+ dx[i];nowY = nowY+ dy[i];
                if (checkInbound(nowX, nowY)) {
                    if(chessComponents[nowX][nowY].name=='_'){
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        continue;
                    }
                    else if(chessComponents[nowX][nowY].getChessColor()!=chessColor) {
                        tmp.add(new ChessboardPoint(nowX, nowY));
                        break;
                    }
                    else break;
                }
                else break;
            }
        }
        return tmp;
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }
}

class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public ChessColor getChessColor() {
        return chessColor;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int[] dx={-1,1,-2,2,-2,2,-1,1};
        int[] dy={-2,-2,-1,-1,1,1,2,2};
        for(int i=0;i<8;i++){
                int nowX = source.getX() + dx[i], nowY = source.getY() + dy[i];
                if (checkInbound(nowX, nowY)&&chessComponents[nowX][nowY].getChessColor()!=chessColor) {
                    tmp.add(new ChessboardPoint(nowX, nowY));
                }
        }
        return tmp;
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}
class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> tmp=new ArrayList<>();
        int nowX= source.getX(),nowY=source.getY();
        if(this.chessColor==ChessColor.BLACK)nowX++;
        else nowX--;
        if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].name=='_')tmp.add(new ChessboardPoint(nowX,nowY));
        if(this.chessColor==ChessColor.BLACK&&nowX==2){
            nowX++;
            if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].name=='_'&&
                    chessComponents[nowX-1][nowY].name=='_')tmp.add(new ChessboardPoint(nowX,nowY));
            nowX--;
        }
        else if(this.chessColor==ChessColor.WHITE&&nowX==5){
            nowX--;
            if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].name=='_'&&
                    chessComponents[nowX+1][nowY].name=='_')tmp.add(new ChessboardPoint(nowX,nowY));
            nowX++;
        }
        nowY++;
        if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].getChessColor()!=this.chessColor
                &&chessComponents[nowX][nowY].name!='_')tmp.add(new ChessboardPoint(nowX,nowY));
        nowY-=2;
        if(checkInbound(nowX,nowY)&&chessComponents[nowX][nowY].getChessColor()!=this.chessColor
                &&chessComponents[nowX][nowY].name!='_')tmp.add(new ChessboardPoint(nowX,nowY));
        return tmp;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}
class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }


    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] tmp) {
        this.source = source;
        this.chessColor = chessColor;
        this.name=name;
        this.chessComponents=tmp;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source=source;
    }
    @Override
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }
}