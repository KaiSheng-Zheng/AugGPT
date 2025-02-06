import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] wholeChessGame;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }
    public void setWholeChessGame(ChessComponent[][]chessComponents){
        wholeChessGame=chessComponents;
    }

    
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>preAnswer=new ArrayList<>();
        preAnswer.add(new ChessboardPoint(source.getX()-1,source.getY()-1));
        preAnswer.add(new ChessboardPoint(source.getX()-1,source.getY()));
        preAnswer.add(new ChessboardPoint(source.getX()-1,source.getY()+1));
        preAnswer.add(new ChessboardPoint(source.getX(),source.getY()-1));
        preAnswer.add(new ChessboardPoint(source.getX(),source.getY()+1));
        preAnswer.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
        preAnswer.add(new ChessboardPoint(source.getX()+1,source.getY()));
        preAnswer.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
        int k=0;
        while (k<preAnswer.size()){
            if(preAnswer.get(k).getX()<0||preAnswer.get(k).getX()>7||
                    preAnswer.get(k).getY()<0||preAnswer.get(k).getY()>7||
                    (wholeChessGame[preAnswer.get(k).getX()][preAnswer.get(k).getY()].getChessColor().equals(chessColor))){
                preAnswer.remove(k);
                k=0;
            }
            else {
                k++;
            }
        }
        return preAnswer;
    }

}
