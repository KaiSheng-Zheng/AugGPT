import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent [][]chessComponents;
    public char getName() {
        return name;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public KingChessComponent(ChessboardPoint source,ChessColor color,ChessComponent [][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
        if(chessColor.equals(ChessColor.BLACK)){
            this.name='K';
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            this.name='k';
        }
    }

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        int fromX=source.getX();int fromY=source.getY();
        int i=fromX-1;int j=fromY-1;
        if(i>=0&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX-1;j=fromY;
        if(i>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX-1;j=fromY+1;
        if(i>=0&&j<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX;j=fromY-1;
        if(j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX;j=fromY+1;
        if(j<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX+1;j=fromY+1;
        if(i<8&&j<8) {
            if (!chessComponents[i][j].getChessColor().equals(chessColor)) {
                chessboardPointList.add(new ChessboardPoint(i, j));
            }
        }
        i=fromX+1;j=fromY;
        if(i<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX+1;j=fromY-1;
        if(i<8&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        return chessboardPointList;
    }
}
