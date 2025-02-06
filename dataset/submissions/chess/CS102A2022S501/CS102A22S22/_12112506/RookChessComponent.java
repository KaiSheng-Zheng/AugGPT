import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent [][]chessComponents;
    protected char name;
    public char getName() {
        return name;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public RookChessComponent(ChessboardPoint source,ChessColor color,ChessComponent [][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
        if(chessColor.equals(ChessColor.BLACK)){
            this.name='R';
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            this.name='r';
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
        int i=fromX+1;int j=fromY;
        if(i<8){
            while(i<8){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    ++i;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        i=fromX-1;
        if(i>=0){
            while(i>=0){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    --i;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        i=fromX;j=fromY-1;
        if(j>=0){
            while(j>=0){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    --j;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        j=fromY+1;
        if(j<8){
            while(j<8){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    ++j;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        return chessboardPointList;
    }
}
