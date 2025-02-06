

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessColor knight_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public KnightChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'n'){
           knight_color = ChessColor.WHITE;
        }
    }




    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
        canmove1 = new ArrayList<>();
        for (int i = -2;i<3;i++){
            for (int j = -2; j<3;j++) {
                if (getSource().offset(i,j)!=null&&(i!=0&j!=0)&&(Math.abs(i)+Math.abs(j)==3)){
                    if (knight_color==ChessColor.BLACK&chessboard.get(i + getSource().getX()).charAt(j + getSource().getY())>'a'
                |knight_color==ChessColor.WHITE&chessboard.get(i + getSource().getX()).charAt(j + getSource().getY())<'Z'
                    |chessboard.get(i + getSource().getX()).charAt(j + getSource().getY())=='_') {
                        canmove1.add(new ChessboardPoint(i + getSource().getX(), j + getSource().getY()));
                    }
                }
            }
        }
        Collections.sort(canmove1);
        return canmove1;
    }

}
