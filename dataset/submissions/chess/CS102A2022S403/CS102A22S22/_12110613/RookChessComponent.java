import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> answer=new ArrayList<>();
        for(int j=y+1;j<8;j++){
            if(chessboard[x][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(x,j));
            }
            else if(chessboard[x][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[x][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(x,j));
                break;
            }else{
                break;
            }
        }
        for(int i=x-1;i>=0;i--){
            if(chessboard[i][y] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,y));
            }
            else if(chessboard[i][y].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][y].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,y));
                break;
            }else{
                break;
            }
        }
        for(int j=y-1;j>=0;j--){
            if(chessboard[x][j] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(x,j));
            }
            else if(chessboard[x][j].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[x][j].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(x,j));
                break;
            }else{
                break;
            }
        }
        for(int i=x+1;i<8;i++){
            if(chessboard[i][y] instanceof EmptySlotComponent){
                answer.add(new ChessboardPoint(i,y));
            }
            else if(chessboard[i][y].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK||chessboard[i][y].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(i,y));
                break;
            }else{
                break;
            }
        }
        return answer;
    }
}
