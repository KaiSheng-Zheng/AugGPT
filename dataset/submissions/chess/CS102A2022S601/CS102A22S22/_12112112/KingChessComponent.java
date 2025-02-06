import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    ArrayList<String> a;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard ){
        super(source,chessColor,name,chessboard);
        a= (ArrayList<String>) chessboard;
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> k=new ArrayList<>();
        int x=super.getSource().getX();
        int y=super.getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK) {
            if (super.getSource().getX() != 0 && a.get(x-1).charAt(y)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
            }
            if (super.getSource().getY() != 0&& a.get(x).charAt(y-1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() - 1));
            }
            if (super.getSource().getY() != 7&& a.get(x).charAt(y+1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() + 1));
            }
            if (super.getSource().getX() != 7 && a.get(x+1).charAt(y)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
            }

            if (super.getSource().getX() != 0 && y!=0 && a.get(x-1).charAt(y-1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()-1));
            }
            if (x != 0 && y!=7 && a.get(x-1).charAt(y+1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()+1));
            }
            if (super.getSource().getX() != 7 && y!=0 && a.get(x+1).charAt(y-1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()-1));
            }
            if (x != 7 && y!=7 && a.get(x+1).charAt(y+1)>90) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()+1));
            }


        }else if (super.getChessColor()==ChessColor.WHITE){
            if (super.getSource().getX() != 0 && a.get(x-1).charAt(y)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
            }

            if (super.getSource().getY() != 0 && a.get(x).charAt(y-1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() - 1));
            }
            if (super.getSource().getY() != 7 && a.get(x).charAt(y+1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() + 1));
            }
            if (super.getSource().getX() != 7 && a.get(x+1).charAt(y)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
            }

            if (super.getSource().getX() != 0 && y!=0 && a.get(x-1).charAt(y-1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()-1));
            }
            if (x != 0 && y!=7 && a.get(x-1).charAt(y+1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()+1));
            }
            if (super.getSource().getX() != 7 && y!=0 && a.get(x+1).charAt(y-1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()-1));
            }
            if (x != 7 && y!=7 && a.get(x+1).charAt(y+1)<97) {
                k.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()+1));
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
