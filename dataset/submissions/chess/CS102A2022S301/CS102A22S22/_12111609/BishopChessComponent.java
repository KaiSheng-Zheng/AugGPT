import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        setSource(source);
        setChessColor(chessColor);
        setName(name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> potentialMove= new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        int minor=x-y;
        int addition=x+y;
        for (int i = x; i < 8; i++) {
            if (i!=x && addition-i>=0&&addition-i<8){
                if (findNone(getChessColor(),getChessComponents()[i][addition-i].getChessColor())) {
                    potentialMove.add(new ChessboardPoint(i, addition-i));
                } else if (findOpposite(getChessColor(),getChessComponents()[i][addition-i].getChessColor())){
                    potentialMove.add(new ChessboardPoint(i, addition-i));
                    break;
                } else if (findSame(getChessColor(),getChessComponents()[i][addition-i].getChessColor())) {
                    break;
                }
            }
        }
        for (int i = x; i >=0; i--) {
            if (i!=x && addition-i>=0&&addition-i<8){
                if (findNone(getChessColor(),getChessComponents()[i][addition-i].getChessColor())) {
                    potentialMove.add(new ChessboardPoint(i, addition-i));
                } else if (findOpposite(getChessColor(),getChessComponents()[i][addition-i].getChessColor())){
                    potentialMove.add(new ChessboardPoint(i, addition-i));
                    break;
                } else if (findSame(getChessColor(),getChessComponents()[i][addition-i].getChessColor())) {
                    break;
                }
            }
        }
        for (int i = x; i < 8; i++) {
            if (i!=x && i-minor>=0&& i-minor<8){
                if (findNone(getChessColor(),getChessComponents()[i][i-minor].getChessColor())) {
                    potentialMove.add(new ChessboardPoint(i, i-minor));
                } else if (findOpposite(getChessColor(),getChessComponents()[i][i-minor].getChessColor())){
                    potentialMove.add(new ChessboardPoint(i, i-minor));
                    break;
                } else if (findSame(getChessColor(),getChessComponents()[i][i-minor].getChessColor())) {
                    break;
                }
            }
        }
        for (int i = x; i >=0; i--) {
            if (i!=x && i-minor>=0&& i-minor<8){
                if (findNone(getChessColor(),getChessComponents()[i][i-minor].getChessColor())) {
                    potentialMove.add(new ChessboardPoint(i, i-minor));
                } else if (findOpposite(getChessColor(),getChessComponents()[i][i-minor].getChessColor())){
                    potentialMove.add(new ChessboardPoint(i, i-minor));
                    break;
                } else if (findSame(getChessColor(),getChessComponents()[i][i-minor].getChessColor())) {
                    break;
                }
            }
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