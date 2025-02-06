import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] wholeChessGame;


    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    public void setWholeChessGame(ChessComponent[][]chessComponents){
        wholeChessGame=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>preanswer=new ArrayList<>();
        int friend=0;
        int enemy=0;
        //to right up
        for(int i=source.getX()-1,j=source.getY()+1;i>=0&&j<=7;i--,j++){
            if(friend==0&&enemy==0){
                if(wholeChessGame[i][j] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(i,j));
                }
                else{
                    if(wholeChessGame[i][j].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        friend=0;enemy=0;
        //to left down
        for(int i=source.getX()+1,j=source.getY()-1;i<=7&&j>=0;i++,j--){
            if(friend==0&&enemy==0){
                if(wholeChessGame[i][j] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(i,j));
                }
                else{
                    if(wholeChessGame[i][j].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        friend=0;enemy=0;
        //to left up
        for(int i=source.getX()-1,j=source.getY()-1;i>=0&&j>=0;i--,j--){
            if(friend==0&&enemy==0){
                if(wholeChessGame[i][j] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(i,j));
                }
                else{
                    if(wholeChessGame[i][j].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        friend=0;enemy=0;
        for(int i=source.getX()+1,j=source.getY()+1;i<=7&&j<=7;i++,j++){
            if(friend==0&&enemy==0){
                if(wholeChessGame[i][j] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(i,j));
                }
                else{
                    if(wholeChessGame[i][j].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return preanswer;
    }
}
