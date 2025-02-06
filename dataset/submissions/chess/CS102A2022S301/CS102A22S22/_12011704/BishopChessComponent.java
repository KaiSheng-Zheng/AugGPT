import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<ChessboardPoint>();
        ChessboardPoint des=super.getSource();
        int x=des.getX();int y=des.getY();

        for (int i = 1; i < 8; i++) {
            if(x+i>=0 && x+i<=7 && y+i>=0 && y+i<=7){
                if(chessboard[x+i][y+i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x+i,y+i));
                }
                else if(chessboard[x+i][y+i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x+i,y+i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(x+i>=0 && x+i<=7 && y-i>=0 && y-i<=7){
                if(chessboard[x+i][y-i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x+i,y-i));
                }
                else if(chessboard[x+i][y-i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x+i,y-i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(x-i>=0 && x-i<=7 && y+i>=0 && y+i<=7){
                if(chessboard[x-i][y+i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x-i,y+i));
                }
                else if(chessboard[x-i][y+i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x-i,y+i));
                    break;
                }
            }
        }
        for (int i = -1; i >-8; i--) {
            if(x+i>=0 && x+i<=7 && y+i>=0 && y+i<=7){
                if(chessboard[x+i][y+i] .getChessColor()==ChessColor.NONE)
                {
                    point.add(new ChessboardPoint(x+i,y+i));
                }
                else if(chessboard[x+i][y+i].getChessColor()==chessboard[x][y].getChessColor()){
                    break;
                }
                else {
                    point.add(new ChessboardPoint(x+i,y+i));
                    break;
                }
            }
        }

        return point;
    }

}