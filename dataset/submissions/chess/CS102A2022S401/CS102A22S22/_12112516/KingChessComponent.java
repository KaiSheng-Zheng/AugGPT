import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destinations = new ArrayList<>();
        ChessboardPoint source = this.getSource();

        int X1 = source.getX() - 1, X2 = source.getX() + 1, Y1 = source.getY() - 1, Y2 = source.getY() + 1;
        for(int j = X1; j <= X2; j++){
            if(j >= 0 && j <= 7){
                if(Y1 >= 0 && Y2 <= 7){
                    for(int i = Y1; i <= Y2; i++){
                        if(chessComponents[j][i].getChessColor() != this.getChessColor()){
                            destinations.add(new ChessboardPoint(j, i));
                        }
                    }
                }
                if(Y1 < 0){
                    for(int i = source.getY(); i <= Y2; i++){
                        if(chessComponents[j][i].getChessColor() != this.getChessColor()){
                            destinations.add(new ChessboardPoint(j, i));
                        }
                    }
                }
                if(Y2 > 7){
                    for(int i = Y1; i <= source.getY(); i++){
                        if(chessComponents[j][i].getChessColor() != this.getChessColor()){
                            destinations.add(new ChessboardPoint(j, i));
                        }
                    }
                }
            }
        }

        return destinations;
    }
}
