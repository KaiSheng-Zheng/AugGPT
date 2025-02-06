import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destinations = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int sumXY = source.getX() + source.getY();
        if(sumXY <= 7){
            for(int i = source.getX()-1; i >= 0 ; i--){
                if(chessComponents[i][sumXY - i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, sumXY - i));
                    if(chessComponents[i][sumXY - i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                }else break;
            }
            for(int i = source.getX()+1; i<= sumXY; i++){
                if(chessComponents[i][sumXY - i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, sumXY - i));
                    if(chessComponents[i][sumXY - i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                }else break;
            }
        }else{
            for(int i = source.getX() - 1; i >= sumXY - 7 ; i--){
                if(chessComponents[i][sumXY - i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, sumXY - i));
                    if(chessComponents[i][sumXY - i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                }else break;
            }
            for(int i = source.getX() + 1; i <= 7; i++){
                if(chessComponents[i][sumXY - i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, sumXY - i));
                    if(chessComponents[i][sumXY - i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                }else break;
            }
        }



        int differenceX = 7 - source.getX();
        int differenceY = 7 - source.getY();
        if(differenceX >= differenceY){
            int j = source.getX() + 1;
            for(int i = source.getY() + 1; i <= 7; i++){
                if(chessComponents[j][i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(j, i));
                    if(chessComponents[j][i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                    j = j + 1;
                }else break;
            }

            int k = source.getY() - 1;
            for(int i = source.getX() - 1; i >= 0; i--){
                if(chessComponents[i][k].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, k));
                    if(chessComponents[i][k].getChessColor() != ChessColor.NONE){
                        break;
                    }
                    k = k - 1;
                }else break;
            }
        }
        else{
            int j = source.getY() + 1;
            for(int i = source.getX() + 1; i <= 7; i++){
                if(chessComponents[i][j].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(i, j));
                    if(chessComponents[i][j].getChessColor() != ChessColor.NONE){
                        break;
                    }
                    j = j + 1;
                }else break;
            }

            int k = source.getX() - 1;
            for(int i = source.getY() - 1; i >= 0; i--){
                if(chessComponents[k][i].getChessColor() != this.getChessColor()){
                    destinations.add(new ChessboardPoint(k, i));
                    if(chessComponents[k][i].getChessColor() != ChessColor.NONE){
                        break;
                    }
                    k = k - 1;
                }else break;

            }
        }

        return destinations;
    }
}
