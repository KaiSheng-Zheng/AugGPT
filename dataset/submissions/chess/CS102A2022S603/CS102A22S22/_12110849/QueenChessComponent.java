import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] c = super.getChessComponents();
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();

        int row = super.getSource().getX();
        int col = super.getSource().getY();

        if (c[row][col].getChessColor()==ChessColor.BLACK){
            if (row>0){
                for (int i=row-1;i>=0;i--){
                    if (c[i][col].name == '_')  chessboardPoints.add(new ChessboardPoint(i,col));
                    if (c[i][col].name != '_'){
                        if (c[i][col].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,col));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row<7){
                for (int i=row+1;i<8;i++){
                    if (c[i][col].name == '_')  chessboardPoints.add(new ChessboardPoint(i,col));
                    if (c[i][col].name != '_'){
                        if (c[i][col].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,col));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col>0){
                for (int i=col-1;i>=0;i--){
                    if (c[row][i].name == '_')  chessboardPoints.add(new ChessboardPoint(row,i));
                    if (c[row][i].name != '_'){
                        if (c[row][i].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(row,i));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col<7){
                for (int i=col+1;i<8;i++){
                    if (c[row][i].name == '_')  chessboardPoints.add(new ChessboardPoint(row,i));
                    if (c[row][i].name != '_'){
                        if (c[row][i].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(row,i));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row>0&&col>0){
                for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row<7&&col>0){
                for (int i=row+1,j=col-1;i<8&&j>=0;i++,j--){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row>0&&col<7){
                for (int i=row-1,j=col+1;i>=0&&j<8;i--,j++){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col<7&&row<7){
                for (int i=row+1,j=col+1;i<8&&j<8;i++,j++){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
        }
        else if (c[row][col].getChessColor()==ChessColor.WHITE){
            if (row>0){
                for (int i=row-1;i>=0;i--){
                    if (c[i][col].name == '_')  chessboardPoints.add(new ChessboardPoint(i,col));
                    if (c[i][col].name != '_'){
                        if (c[i][col].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,col));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row<7){
                for (int i=row+1;i<8;i++){
                    if (c[i][col].name == '_')  chessboardPoints.add(new ChessboardPoint(i,col));
                    if (c[i][col].name != '_'){
                        if (c[i][col].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,col));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col>0){
                for (int i=col-1;i>=0;i--){
                    if (c[row][i].name == '_')  chessboardPoints.add(new ChessboardPoint(row,i));
                    if (c[row][i].name != '_'){
                        if (c[row][i].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(row,i));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col<7){
                for (int i=col+1;i<8;i++){
                    if (c[row][i].name == '_')  chessboardPoints.add(new ChessboardPoint(row,i));
                    if (c[row][i].name != '_'){
                        if (c[row][i].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(row,i));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row>0&&col>0){
                for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row<7&&col>0){
                for (int i=row+1,j=col-1;i<8&&j>=0;i++,j--){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (row>0&&col<7){
                for (int i=row-1,j=col+1;i>=0&&j<8;i--,j++){
                    if (c[i][j].name == '_')  chessboardPoints.add(new ChessboardPoint(i,j));
                    if (c[i][j].name != '_'){
                        if (c[i][j].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,j));
                            break;
                        }
                        else break;
                    }
                }
            }
            if (col<7&&row<7){
                for (int i=col+1,j=row+1;i<8&&j<8;i++,j++){
                    if (c[j][i].name == '_')  chessboardPoints.add(new ChessboardPoint(j,i));
                    if (c[j][i].name != '_'){
                        if (c[j][i].getChessColor()==ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(j,i));
                            break;
                        }
                        else break;
                    }
                }
            }
        }
        return chessboardPoints;
    }
//    @Override
//    public String toString() {
//        if (getChessColor()==ChessColor.BLACK)  return "Q";
//        else return "q";
//    }
}
