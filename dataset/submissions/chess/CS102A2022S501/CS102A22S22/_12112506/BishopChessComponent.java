import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
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
    public BishopChessComponent(ChessboardPoint source,
                                ChessColor color, ChessComponent[][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
        if(chessColor.equals(ChessColor.BLACK)){
            this.name='B';
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            this.name='b';
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
        int i=fromX+1;int j=fromY+1;
        if(i<8&&j<8){
            while(i<8&&j<8){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    ++i;++j;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        i=fromX-1;j=fromY-1;
        if(i>=0&&j>=0){
            while(i>=0&&j>=0){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    --i;--j;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        i=fromX+1;j=fromY-1;
        if(i<8&&j>=0){
            while(i<8&&j>=0){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    ++i;--j;continue;
                }
                if(!this.chessColor.equals(current.getChessColor())){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
                break;
            }
        }
        i=fromX-1;j=fromY+1;
        if(i>=0&&j<8){
            while(i>=0&&j<8){
                ChessComponent current=chessComponents[i][j];
                if(current instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                    --i;++j;continue;
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
