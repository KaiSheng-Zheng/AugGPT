import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint c,ChessColor b,char a) {
        super.setSource(c); 
        super.setChessColor(b);
        name = a;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        for (int i = 1; i <= 8; i++) {
            if (x-i<0) break;
            if (chessboard[x-i][y] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(x-i,y));
            }
            else {
                if (chessboard[x-i][y].getChessColor()!=super.getChessColor()){
                    points.add(new ChessboardPoint(x-i,y));
                }
                break;
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (y-i<0) break;
            if (chessboard[x][y-i] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(x,y-i));
            }
            else {
                if (chessboard[x][y-i].getChessColor()!=super.getChessColor()){
                    points.add(new ChessboardPoint(x,y-i));
                }
                break;
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (x+i>7) break;
            if (chessboard[x+i][y] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(x+i,y));
            }
            else {
                if (chessboard[x+i][y].getChessColor()!=super.getChessColor()){
                    points.add(new ChessboardPoint(x+i,y));
                }
                break;
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (y+i>7) break;
            if (chessboard[x][y+i] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(x,y+i));
            }
            else {
                if (chessboard[x][y+i].getChessColor()!=super.getChessColor()){
                    points.add(new ChessboardPoint(x,y+i));
                }
                break;
            }
        }
        for (int i = 0; i < points.size()-1; i++) {
            for (int j = 0; j < points.size()-1-i; j++) {
                if (points.get(j).getX()>points.get(j+1).getX()){
                    ChessboardPoint ne = points.get(j);
                    points.set(j,points.get(j+1));
                    points.set(j+1,ne);
                }
            }
        }
        for (int i = 0; i < points.size()-1; i++) {
            if (points.get(i).getX()==points.get(i+1).getX()){
                if (points.get(i).getY()>points.get(i+1).getY()){
                    ChessboardPoint ne = points.get(i);
                    points.set(i,points.get(i+1));
                    points.set(i+1,ne);
                }
            }
        }
        return points;
    }
    @Override
    public char getName() {
        return name;
    }
}
