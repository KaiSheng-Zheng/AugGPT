

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class KingChessComponent extends ChessComponent {
    private ChessColor king_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public KingChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'k'){
            king_color = ChessColor.WHITE;
        }
    }//source,name,chessboard,color



    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
        canmove1 = new ArrayList<>();
        for (int i = -1;i<2;i++){
            for (int j = -1; j<2;j++) {
                if (getSource().offset(i,j)!=null&&(i!=0|j!=0)){
                    if (king_color==ChessColor.BLACK&chessboard.get(i+getSource().getX()).charAt(j+getSource().getY())>'a'
                    |king_color==ChessColor.WHITE&chessboard.get(i+getSource().getX()).charAt(j+getSource().getY())<'Z'|
                            chessboard.get(i+getSource().getX()).charAt(j+getSource().getY())=='_') {
                        canmove1.add(new ChessboardPoint(i + getSource().getX(), j + getSource().getY()));
                    }
                }
            }
        }
        Collections.sort(canmove1);
        return canmove1;
    }


}
