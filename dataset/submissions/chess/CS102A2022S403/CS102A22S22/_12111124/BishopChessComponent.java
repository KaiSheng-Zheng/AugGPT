import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){

    }

    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor currentColor = getChessColor();
        for(int i = 0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                int x1 = chessComponents[i][j].getSource().getX();
                int y1 = chessComponents[i][j].getSource().getY();
                if(x - x1 == y - y1){
                    if(x<x1){
                        int ymin = y+1;
                    for(int row = x+1; row<= 7 && ymin<=7; row++,ymin++){
                        if(chessComponents[row][ymin].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[row][ymin].getSource())){
                            canMoveTo.add(chessComponents[row][ymin].getSource());
                        }
                        else if(chessComponents[row][ymin].getChessColor() == currentColor){
                            break;
                        }
                        else {
                            if(!canMoveTo.contains(chessComponents[row][ymin].getSource()))
                            canMoveTo.add(chessComponents[row][ymin].getSource());
                            break;
                        }
                    }
                    }
                    else if(x > x1){
                        int ymax = y-1;
                        for(int row = x-1; row>= x1 && ymax>=0; row--,ymax--){
                            if(chessComponents[row][ymax].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[row][ymax].getSource())){
                                canMoveTo.add(chessComponents[row][ymax].getSource());
                            }
                            else if(chessComponents[row][ymax].getChessColor() == currentColor){
                                break;
                            }
                            else {
                                if(!canMoveTo.contains(chessComponents[row][ymax].getSource()))
                                    canMoveTo.add(chessComponents[row][ymax].getSource());
                                break;
                            }
                        }
                    }
                }
                else if(x - x1 == y1 - y){
                    if(x > x1){
                        int ymin = y+1;
                        for(int row = x-1; row >= x1 && ymin<=7; row--,ymin++){
                        if(chessComponents[row][ymin].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[row][ymin].getSource())){
                            canMoveTo.add(chessComponents[row][ymin].getSource());
                        }
                        else if(chessComponents[row][ymin].getChessColor() == currentColor ){
                            break;
                        }
                        else {
                            if(!canMoveTo.contains(chessComponents[row][ymin].getSource()))
                            canMoveTo.add(chessComponents[row][ymin].getSource());
                            break;
                        }
                    }
                    }
                    else if(x < x1){
                        int ymax = y-1;
                        for(int row = x+1; row <= 7 && ymax>=0; row++,ymax--){
                            if(chessComponents[row][ymax].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[row][ymax].getSource())){
                                canMoveTo.add(chessComponents[row][ymax].getSource());
                            }
                            else if(chessComponents[row][ymax].getChessColor() == currentColor){
                                break;
                            }
                            else {
                                if(!canMoveTo.contains(chessComponents[row][ymax].getSource()))
                                    canMoveTo.add(chessComponents[row][ymax].getSource());
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(canMoveTo.size() != 0){
            return canMoveTo;
        }
        else return new ArrayList<>();
    }
}
