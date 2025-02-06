import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent [][]chessComponents;
    public char getName() {
        return name;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public KnightChessComponent(ChessboardPoint source,ChessColor color,ChessComponent [][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
        if(chessColor.equals(ChessColor.BLACK)){
            this.name='N';
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            this.name='n';
        }
    }

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        int fromX=source.getX();int fromY=source.getY();
        int i=fromX-2;int j=fromY-1;
        if(i>=0&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX-1;j=fromY-2;
        if(i>=0&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX-1;j=fromY+2;
        if(i>=0&&j<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX-2;j=fromY+1;
        if(i>=0&&j<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX+2;j=fromY+1;
        if(i<8&&j<8){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX+1;j=fromY+2;
        if(i<8&&j<8) {
            if (!chessComponents[i][j].getChessColor().equals(chessColor)) {
                chessboardPointList.add(new ChessboardPoint(i, j));
            }
        }
        i=fromX+1;j=fromY-2;
        if(i<8&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        i=fromX+2;j=fromY-1;
        if(i<8&&j>=0){
            if(!chessComponents[i][j].getChessColor().equals(chessColor)){
                chessboardPointList.add(new ChessboardPoint(i,j));
            }
        }
        return chessboardPointList;
    }
}
