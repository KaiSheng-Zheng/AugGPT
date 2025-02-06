import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        setSource(source);
        setChessColor(chessColor);
        setName(name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> potentialMove= new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if (x+1<8&&x+1>=0&&y+1<8&&y+1>=0&&!findSame(getChessColor(),getChessComponents()[x+1][y+1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x + 1, y + 1));
        }
        if (x+1<8&&x+1>=0&&y<8&&y>=0&&!findSame(getChessColor(),getChessComponents()[x+1][y].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x + 1, y));
        }
        if (x+1<8&&x+1>=0&&y-1<8&&y-1>=0&&!findSame(getChessColor(),getChessComponents()[x+1][y-1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x<8&&x>=0&&y+1<8&&y+1>=0&&!findSame(getChessColor(),getChessComponents()[x][y+1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x, y + 1));
        }
        if (x<8&&x>=0&&y-1<8&&y-1>=0&&!findSame(getChessColor(),getChessComponents()[x][y-1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x, y - 1));
        }
        if (x-1<8&&x-1>=0&&y+1<8&&y+1>=0&&!findSame(getChessColor(),getChessComponents()[x-1][y+1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (x-1<8&&x-1>=0&&y<8&&y>=0&&!findSame(getChessColor(),getChessComponents()[x-1][y].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x - 1, y));
        }
        if (x-1<8&&x-1>=0&&y-1<8&&y-1>=0&&!findSame(getChessColor(),getChessComponents()[x-1][y-1].getChessColor())) {
            potentialMove.add(new ChessboardPoint(x - 1, y - 1));
        }

        Collections.sort(potentialMove, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() == o2.getX()){
                    return o1.getY()-o2.getY();
                }
                return o1.getX()-o2.getX();
            }
        });{
        }
        return potentialMove;
    }
}
