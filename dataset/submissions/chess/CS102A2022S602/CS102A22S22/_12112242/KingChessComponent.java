import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
        this.chessComponents=chessComponents;
        this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= source.getX();
        int y= source.getY();
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
                if (chessboardPoint.offset(-1,-1)!=null){
            if(chessComponents[x-1][y-1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-1,y-1));
            }}
                if (chessboardPoint.offset(-1,0)!=null){
            if (chessComponents[x-1][y].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-1,y));
            }}
                if (chessboardPoint.offset(-1,1)!=null){
            if (chessComponents[x-1][y+1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x-1,y+1));
            }}
                if (chessboardPoint.offset(0,-1)!=null){
            if (chessComponents[x][y-1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x,y-1));
            }}
                if (chessboardPoint.offset(0,1)!=null){
            if (chessComponents[x][y+1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x,y+1));
            }}
                if (chessboardPoint.offset(1,-1)!=null){
            if (chessComponents[x+1][y-1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+1,y-1));
            }}
                if (chessboardPoint.offset(1,0)!=null){
            if (chessComponents[x+1][y].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+1,y));
            }}
        if (chessboardPoint.offset(1,1)!=null){
            if (chessComponents[x+1][y+1].chessColor!=this.chessColor){
                chessboardPointList.add(new ChessboardPoint(x+1,y+1));
            }}

        return chessboardPointList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
