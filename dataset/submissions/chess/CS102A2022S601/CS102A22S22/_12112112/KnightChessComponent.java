import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    ArrayList<String> a;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        a= (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> k=new ArrayList<>();
        int x=super.getSource().getX();
        int y=super.getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK) {
            if (x - 2 >= 0 && y - 1 >= 0) {
                if (a.get(x - 2).charAt(y - 1) > 90) {
                    k.add(new ChessboardPoint(x - 2, y - 1));
                }
            }
            if (x - 2 >= 0 && y + 1 < 8) {
                if (a.get(x - 2).charAt(y + 1) > 90) {
                    k.add(new ChessboardPoint(x - 2, y + 1));
                }
            }
            if (x - 1 >= 0 && y - 2 >= 0) {
                if (a.get(x - 1).charAt(y-2) > 90) {
                    k.add(new ChessboardPoint(x - 1, y - 2));
                }
            }
            if (x - 1 >= 0 && y + 2 < 8) {
                if (a.get(x - 1).charAt(y + 2) > 90) {
                    k.add(new ChessboardPoint(x - 1, y + 2));
                }
            }


            if (x + 1 < 8 && y - 2 >= 0) {
                if (a.get(x + 1).charAt(y - 2) > 90){
                    k.add(new ChessboardPoint(x + 1, y - 2));
                }
            }

            if (x + 1 < 8 && y + 2 < 8  ) {
                if (a.get(x + 1).charAt(y + 2) > 90) {
                    k.add(new ChessboardPoint(x + 1, y + 2));
                }
            }
            if (x + 2 < 8 && y - 1 >= 0) {
                if (a.get(x + 2).charAt(y - 1) > 90) {

                    k.add(new ChessboardPoint(x + 2, y - 1));
                }
            }
            if (x + 2 < 8 && y + 1 < 8) {
                if (a.get(x + 2).charAt(y + 1) > 90) {
                    k.add(new ChessboardPoint(x + 2, y + 1));
                }
            }


        }else if (super.getChessColor()==ChessColor.WHITE){
            if (x - 2 >= 0 && y - 1 >= 0) {
                if (a.get(x - 2).charAt(y - 1) < 97) {
                    k.add(new ChessboardPoint(x - 2, y - 1));
                }
            }
            if (x - 2 >= 0 && y + 1 < 8) {
                if (a.get(x - 2).charAt(y + 1) < 97) {
                    k.add(new ChessboardPoint(x - 2, y + 1));
                }
            }
            if (x - 1 >= 0 && y - 2 >= 0) {
                if (a.get(x - 1).charAt(y-2) < 97) {
                    k.add(new ChessboardPoint(x - 1, y - 2));
                }
            }
            if (x - 1 >= 0 && y + 2 < 8) {
                if (a.get(x - 1).charAt(y + 2) < 97) {
                    k.add(new ChessboardPoint(x - 1, y + 2));
                }
            }


            if (x + 1 < 8 && y - 2 >= 0) {
                if (a.get(x + 1).charAt(y - 2) < 97){
                    k.add(new ChessboardPoint(x + 1, y - 2));
                }
            }

            if (x + 1 < 8 && y + 2 < 8  ) {
                if (a.get(x + 1).charAt(y + 2) < 97) {
                    k.add(new ChessboardPoint(x + 1, y + 2));
                }
            }
            if (x + 2 < 8 && y - 1 >= 0) {
                if (a.get(x + 2).charAt(y - 1) < 97) {

                    k.add(new ChessboardPoint(x + 2, y - 1));
                }
            }
            if (x + 2 < 8 && y + 1 < 8) {
                if (a.get(x + 2).charAt(y + 1) < 97) {
                    k.add(new ChessboardPoint(x + 2, y + 1));
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
