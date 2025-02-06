import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> temp = new ArrayList<ChessboardPoint>();
        int tempX=this.getSource().getX();
        int tempY=this.getSource().getY();


        if (newChessboard[tempX][tempY].getChessColor()==ChessColor.BLACK){
            if (tempX>0&&tempX<7){
                for (int i=tempX+1;i<=7;i++){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempX-1;i>=0;i--){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }

            if (tempX==0){
                for (int i=tempX+1;i<=7;i++){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }

            if (tempX==7){
                for (int i=tempX-1;i>=0;i--){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }

            if (tempY>0&&tempY<7){
                for (int i=tempY+1;i<=7;i++){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempY-1;i>=0;i--){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }

            if (tempY==0){
                for (int i=tempY+1;i<=7;i++){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }

            if (tempY==7){
                for (int i=tempY-1;i>=0;i--){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
        }

        else if (newChessboard[tempX][tempY].getChessColor()==ChessColor.WHITE){
            if (tempX>0&&tempX<7){
                for (int i=tempX+1;i<=7;i++){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempX-1;i>=0;i--){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

            if (tempX==0){
                for (int i=tempX+1;i<=7;i++){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

            if (tempX==7){
                for (int i=tempX-1;i>=0;i--){
                    if (newChessboard[i][tempY].name=='_'){
                        temp.add(new ChessboardPoint(i,tempY));
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,tempY));
                        break;
                    }
                    else if (newChessboard[i][tempY].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

            if (tempY>0&&tempY<7){
                for (int i=tempY+1;i<=7;i++){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempY-1;i>=0;i--){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

            if (tempY==0){
                for (int i=tempY+1;i<=7;i++){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

            if (tempY==7){
                for (int i=tempY-1;i>=0;i--){
                    if (newChessboard[tempX][i].name=='_'){
                        temp.add(new ChessboardPoint(tempX,i));
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(tempX,i));
                        break;
                    }
                    else if (newChessboard[tempX][i].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
        }

        return temp;
    }
}
