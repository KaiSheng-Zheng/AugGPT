import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
public KnightChessComponent(){}

    public boolean move(int sourceX, int sourceY, int targetX, int targetY) {
        if((sourceX<8&&sourceX>=0&&sourceY<8&&sourceY>=0&&targetX>=0&&targetX<8&&targetY>=0&&targetY<8)){
            return false;
        }
        int row = Math.abs(targetX - sourceX);
        int column = Math.abs(targetY - sourceY);
        return ((row == 1 && column == 2) || (row == 2 && column == 1));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source= getSource();
        List<ChessboardPoint> Move = new ArrayList<>();
        int sourceX = source.getX();
        int sourceY = source.getY();
        ChessColor player =this.getChessColor();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(move(sourceX,sourceY,i,j)){
                    if(!(comChessColor(chessComponents[i][j].toString().charAt(0)).equals(player))){
                        Move.add(new ChessboardPoint(i,j));
                    }
                }

            }

        }
        return Move;
    }

   
}
