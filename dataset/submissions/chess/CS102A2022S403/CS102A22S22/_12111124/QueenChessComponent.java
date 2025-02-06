import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(){

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
                else if((x == x1 | y == y1)){
                    if(x == x1 && y < y1){
                        for(int ymin = y+1 ;ymin <= 7;ymin++){
                            ChessColor color = chessComponents[x][ymin].getChessColor();
                            if(chessComponents[x][ymin].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[x][ymin].getSource())){
                                canMoveTo.add(chessComponents[x][ymin].getSource());
                            }
                            else if(currentColor == color){
                                break;
                            }
                            else {
                                if(!canMoveTo.contains(chessComponents[x][ymin].getSource()))
                                    canMoveTo.add(chessComponents[x][ymin].getSource());
                                break;
                            }
                        }
                    }
                    else if(x == x1 && y > y1){
                        for(int ymax = y-1 ;ymax >= y1;ymax--){
                            ChessColor color = chessComponents[x][ymax].getChessColor();
                            if(chessComponents[x][ymax].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[x][ymax].getSource())){
                                canMoveTo.add(chessComponents[x][ymax].getSource());
                            }
                            else if(currentColor == color){
                                break;
                            }
                            else {
                                if(!canMoveTo.contains(chessComponents[x][ymax].getSource()))
                                    canMoveTo.add(chessComponents[x][ymax].getSource());
                                break;
                            }
                        }
                    }
                    else if(y == y1 && x < x1){
                        for(int xmin = x+1 ;xmin <= 7;xmin++){
                            ChessColor color = chessComponents[xmin][y].getChessColor();
                            if(chessComponents[xmin][y].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[xmin][y].getSource())){
                                canMoveTo.add(chessComponents[xmin][y].getSource());
                            }
                            else if(currentColor == color){
                                break;
                            }
                            else {
                                if(!canMoveTo.contains(chessComponents[xmin][y].getSource())){
                                    canMoveTo.add(chessComponents[xmin][y].getSource());
                                break;}
                            }
                        }
                    }
                    else if (y == y1 && x > x1){
                        for(int xmax = x-1 ;xmax >= x1;xmax--){
                            ChessColor color = chessComponents[xmax][y].getChessColor();
                            if(chessComponents[xmax][y].getChessColor() == ChessColor.NONE && !canMoveTo.contains(chessComponents[xmax][y].getSource())){
                                canMoveTo.add(chessComponents[xmax][y].getSource());
                            }
                            else if(currentColor == color){
                                break;
                            }
                            else {
                                if (!canMoveTo.contains(chessComponents[xmax][y].getSource()))
                                    canMoveTo.add(chessComponents[xmax][y].getSource());
                                break;
                            }
                        }
                    }
                    else break;
                }
            }
        }


        if(canMoveTo.size() != 0){
            return canMoveTo;
        }
        else return new ArrayList<>();
    }
}
