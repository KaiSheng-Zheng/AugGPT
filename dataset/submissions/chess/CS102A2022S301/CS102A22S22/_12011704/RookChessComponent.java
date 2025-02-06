import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<ChessboardPoint>();
        ChessboardPoint des=super.getSource();
        int x=des.getX();int y=des.getY();

        for (int i = 0; i < 8; i++) {
            if(x+i>=0&&x+i<=7&&i!=0){
                if(chessboard[x+i][y] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x+i,y));
                }
                else if(chessboard[x+i][y].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x+i,y));
                    break;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if(x-i>=0&&x-i<=7&&i!=0){
                if(chessboard[x-i][y] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x-i,y));
                }
                else if(chessboard[x-i][y].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x-i,y));
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if(y-i>=0&&y-i<=7&&i!=0){
                if(chessboard[x][y-i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x,y-i));
                }
                else if(chessboard[x][y-i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x,y-i));
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if(y+i>=0&&y+i<=7&&i!=0){
                if(chessboard[x][y+i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x,y+i));
                }
                else if(chessboard[x][y+i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x,y+i));
                    break;
                }
            }
        }
        return point;
    }
}
