import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected ChessComponent[][]wholeChessGame;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    public void setWholeChessGame(ChessComponent[][] wholeChessGame){
        this.wholeChessGame=wholeChessGame;
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
        friend=0;enemy=0;
        //up
        for(int k=source.getX()-1;k>=0;k--){
            if(friend==0&&enemy==0){
                if(wholeChessGame[k][source.getY()] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(k,source.getY()));
                }
                else{
                    if(wholeChessGame[k][source.getY()].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(k,source.getY()));
                    }
                }
            }
        }
        friend=0;enemy=0;
        //down
        for(int k=source.getX()+1;k<=7;k++){
            if(friend==0&&enemy==0){
                if(wholeChessGame[k][source.getY()] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(k,source.getY()));
                }
                else{
                    if(wholeChessGame[k][source.getY()].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(k,source.getY()));
                    }
                }
            }
        }
        friend=0;enemy=0;
        //left
        for(int k=source.getY()-1;k>=0;k--){
            if(friend==0&&enemy==0){
                if(wholeChessGame[source.getX()][k] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(source.getX(),k));
                }
                else{
                    if(wholeChessGame[source.getX()][k].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(source.getX(),k));
                    }
                }
            }
        }
        friend=0;enemy=0;
        for (int k=source.getY()+1;k<=7;k++){
            if(friend==0&&enemy==0){
                if(wholeChessGame[source.getX()][k] instanceof EmptySlotComponent){
                    preanswer.add(new ChessboardPoint(source.getX(),k));
                }
                else{
                    if(wholeChessGame[source.getX()][k].getChessColor().equals(chessColor)){//friend
                        friend++;
                    }
                    else {
                        enemy++;
                        preanswer.add(new ChessboardPoint(source.getX(),k));
                    }
                }
            }
        }
        return preanswer;
    }
}
