import java.util.ArrayList;
import java.util.List;


public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
        this.chessComponents=chessComponents;
        this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        int x= source.getX();
        int y= source.getY();
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        if (chessboardPoint.offset(-2,-1)!=null){
        if (chessComponents[x-2][y-1]instanceof EmptySlotComponent){
            chessboardPointList.add(chessboardPoint.offset(-2,-1));
        }else {
            if (chessComponents[x-2][y-1].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-2,y-1));
            }
        }
        }
        if (chessboardPoint.offset(-1,-2)!=null){
        if (chessComponents[x-1][y-2]instanceof EmptySlotComponent){
            chessboardPointList.add(chessboardPoint.offset(-1,-2));
        }else {
            if (chessComponents[x-1][y-2].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-1,y-2));
            }
        }}
        if (chessboardPoint.offset(1,-2)!=null){
        if (chessComponents[x+1][y-2]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x+1,y-2));
        }else {
            if (chessComponents[x+1][y-2].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+1,y-2));
            }
        }}
        if (chessboardPoint.offset(2,-1)!=null){
        if (chessComponents[x+2][y-1]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x+2,y-1));
        }else {
            if (chessComponents[x+2][y-1].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+2,y-1));
            }
        }}
        if (chessboardPoint.offset(-2,1)!=null){
        if (chessComponents[x-2][y+1]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x-2,y+1));
        }else {
            if (chessComponents[x-2][y+1].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-2,y+1));
            }
        }}
        if (chessboardPoint.offset(-1,2)!=null){
        if (chessComponents[x-1][y+2]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x-1,y+2));
        }else {
            if (chessComponents[x-1][y+2].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-1,y+2));
            }
        }}
        if (chessboardPoint.offset(1,2)!=null){
        if (chessComponents[x+1][y+2]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x+1,y+2));
        }else {
            if (chessComponents[x+1][y+2].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+1,y+2));
            }
        }}
        if (chessboardPoint.offset(2,1)!=null){
        if (chessComponents[x+2][y+1]instanceof EmptySlotComponent){
            chessboardPointList.add(new ChessboardPoint(x+2,y+1));
        }else {
            if (chessComponents[x+2][y+1].getChessColor()!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+2,y+1));
            }
        }}

        return chessboardPointList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
