import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {

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

            if (tempX>0&&tempX<7&&tempY>0&&tempY<7){
                for (int i=tempX+1,j=tempY+1;;i++,j++){ 
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }

                for (int i=tempX-1,j=tempY-1;;i--,j--){   
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }

                for (int i=tempX-1,j=tempY+1;;i--,j++){  
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }

                for (int i=tempX+1,j=tempY-1;;i++,j--){  
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }  
            if (tempX==0&&tempY==0){
                for (int i=tempX+1,j=tempY+1;;i++,j++){ 
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempX==0&&tempY==7){
                for (int i=tempX+1,j=tempY-1;;i++,j--){ 
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY==0){
                for (int i=tempX-1,j=tempY+1;;i--,j++){ 
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY==7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){  
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempX==0&&tempY!=0&&tempY!=7){
                for (int i=tempX+1,j=tempY-1;;i++,j--){ 
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY+1;;i++,j++){ 
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY!=0&&tempY!=7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){   
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempX-1,j=tempY+1;;i--,j++){  
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempY==0&&tempX!=0&&tempX!=7){
                for (int i=tempX-1,j=tempY+1;;i--,j++){  
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY+1;;i++,j++){ 
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
            }
            if (tempY==7&&tempX!=0&&tempX!=7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){ 
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY-1;;i++,j--){   
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
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

            if (tempX>0&&tempX<7&&tempY>0&&tempY<7){
                for (int i=tempX+1,j=tempY+1;;i++,j++){  
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }

                for (int i=tempX-1,j=tempY-1;;i--,j--){ 
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }

                for (int i=tempX-1,j=tempY+1;;i--,j++){  
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }

                for (int i=tempX+1,j=tempY-1;;i++,j--){  
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==0&&tempY==0){
                for (int i=tempX+1,j=tempY+1;;i++,j++){  
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==0&&tempY==7){
                for (int i=tempX+1,j=tempY-1;;i++,j--){  
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY==0){
                for (int i=tempX-1,j=tempY+1;;i--,j++){  
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY==7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){ 
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==0&&tempY!=0&&tempY!=7){
                for (int i=tempX+1,j=tempY-1;;i++,j--){  
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY+1;;i++,j++){ 
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempX==7&&tempY!=0&&tempY!=7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){  
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempX-1,j=tempY+1;;i--,j++){ 
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempY==0&&tempX!=0&&tempX!=7){
                for (int i=tempX-1,j=tempY+1;;i--,j++){ 
                    if (i<0||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY+1;;i++,j++){  
                    if (i>7||j>7){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }
            if (tempY==7&&tempX!=0&&tempX!=7){
                for (int i=tempX-1,j=tempY-1;;i--,j--){  
                    if (i<0||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
                for (int i=tempX+1,j=tempY-1;;i++,j--){ 
                    if (i>7||j<0){
                        break;
                    }
                    if (newChessboard[i][j].name=='_'){
                        temp.add(new ChessboardPoint(i,j));
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.BLACK){
                        temp.add(new ChessboardPoint(i,j));
                        break;
                    }
                    else if (newChessboard[i][j].getChessColor()==ChessColor.WHITE){
                        break;
                    }
                }
            }

        }

        return temp;
    }
}