import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    ArrayList<String> a;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        a= (ArrayList<String>) chessboard;
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> k=new ArrayList<>();
        int x=super.getSource().getX();
        int y=super.getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK){
            if (x<7) {
                if (a.get(x+1).charAt(y) =='_') {
                    k.add(new ChessboardPoint(x+1, y ));
                }
            }
            if (x==1 && a.get(x+1).charAt(y)=='_'&&a.get(x+2).charAt(y)=='_'){
                k.add(new ChessboardPoint(x+2,y ));
            }
            if (y>0 && x<7) {
                if (a.get(x + 1).charAt(y - 1) >= 97) {
                    k.add(new ChessboardPoint(x+1,y-1 ));
                }
            }
            if (y<7 && x<7) {
                if (a.get(x + 1).charAt(y + 1) >= 97) {
                    k.add(new ChessboardPoint(x+1,y+1 ));
                }
            }
        }else if (super.getChessColor()==ChessColor.WHITE){
            if (x>0) {
                if (a.get(x-1).charAt(y) =='_') {
                    k.add(new ChessboardPoint(x-1, y ));
                }
            }
            if (x==6 && a.get(x-1).charAt(y)=='_'&&a.get(x-2).charAt(y)=='_'){
                k.add(new ChessboardPoint(x-2,y ));
            }
            if (y>0 && x>0) {
                if (a.get(x - 1).charAt(y - 1) <= 90) {
                    k.add(new ChessboardPoint(x-1,y-1 ));
                }
            }
            if (y<7 && x>0) {
                if (a.get(x - 1).charAt(y + 1) <= 90) {
                    k.add(new ChessboardPoint(x-1,y+1 ));
                }
            }
        }
        Collections.sort(k);

        return k;
    }
    public void setName(char a) {
        super.setName(a);
    }

    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
    }

    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

}
