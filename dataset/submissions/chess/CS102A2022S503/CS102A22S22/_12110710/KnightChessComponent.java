import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public char name;
    protected ChessComponent[][] wholeChessGame;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }


    public void setWholeChessGame(ChessComponent[][] chessComponents){
        wholeChessGame=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>preanswer=new ArrayList<>();
        preanswer.add(new ChessboardPoint(source.getX()-1,source.getX()-2));
        preanswer.add(new ChessboardPoint(source.getX()-1,source.getX()+2));
        preanswer.add(new ChessboardPoint(source.getX()+1,source.getX()-2));
        preanswer.add(new ChessboardPoint(source.getX()+1,source.getX()+2));
        preanswer.add(new ChessboardPoint(source.getX()-2,source.getY()-1));
        preanswer.add(new ChessboardPoint(source.getX()-2,source.getY()+1));
        preanswer.add(new ChessboardPoint(source.getX()+2,source.getY()-1));
        preanswer.add(new ChessboardPoint(source.getX()+2,source.getY()+1));
        int k=0;
        while (k<preanswer.size()){
            if(preanswer.get(k).getX()<0||preanswer.get(k).getX()>7||
                    preanswer.get(k).getY()<0||preanswer.get(k).getY()>7||
            wholeChessGame[preanswer.get(k).getX()][preanswer.get(k).getY()].getChessColor().equals(chessColor)){
                preanswer.remove(k);
                k=0;
            }
            else {
                k++;
            }
        }

        return preanswer;
    }
}
