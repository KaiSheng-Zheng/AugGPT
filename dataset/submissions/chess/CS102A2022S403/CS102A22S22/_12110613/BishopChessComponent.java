import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> answer=new ArrayList<>();
        for(int i=x+1,j=y+1;i<8&&j<8;i++,j++){
            if(chessboard[i][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,j));
            }
            else if(chessboard[i][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,j));
                break;
            }else{
                break;
            }
        }
        for(int i=x-1,j=y+1;i>=0&&j<8;i--,j++){
            if(chessboard[i][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,j));
            }
            else if(chessboard[i][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,j));
                break;
            }else{
                break;
            }
        }
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){
            if(chessboard[i][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,j));
            }
            else if(chessboard[i][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,j));
                break;
            }else{
                break;
            }
        }
        for(int i=x+1,j=y-1;i<8&&j>=0;i++,j--){
            if(chessboard[i][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,j));
            }
            else if(chessboard[i][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,j));
                break;
            }else{
                break;
            }
        }
        return answer;
    }
}
