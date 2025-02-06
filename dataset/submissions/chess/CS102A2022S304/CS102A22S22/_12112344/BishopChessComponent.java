import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int col = BishopChessComponent.super.source.getY();
        int row = BishopChessComponent.super.source.getX();
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();

        if (BishopChessComponent.super.chessColor==ChessColor.BLACK){
            int a=Math.min(source.getY(),source.getX())+1;
            for (int i=1;i<a;i++){
                ChessboardPoint destination1=BishopChessComponent.super.source.offset(-i, -i);
                if (SourcePoints.get(row-i).charAt(col-i)=='_'){
                    canmoveto.add(destination1);
                }else if ((int)SourcePoints.get(row-i).charAt(col-i)>95){
                    canmoveto.add(destination1);
                    break;
                }else {
                    break;
                }
            }
            int b=Math.min(7-source.getY(),source.getX())+1;
            if (source.getY()!=7) {
                for (int i = 1; i < b; i++) {
                    ChessboardPoint destination2 = BishopChessComponent.super.source.offset(-i, i);
                    if (SourcePoints.get(row - i).charAt(col + i) == '_') {
                        canmoveto.add(destination2);
                    } else if ((int) SourcePoints.get(row - i).charAt(col + i) > 95) {
                        canmoveto.add(destination2);
                        break;
                    } else {
                        break;
                    }
                }
            }
            int c=Math.min(source.getY(),7-source.getX())+1;
            if (c > 1) {
                for (int i = 1; i < c; i++) {
                    ChessboardPoint destination3 = BishopChessComponent.super.source.offset(i, -i);
                    if (SourcePoints.get(row + i).charAt(col - i) == '_') {
                        canmoveto.add(destination3);
                    } else if ((int) SourcePoints.get(row + i).charAt(col - i) > 95) {
                        canmoveto.add(destination3);
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (c == 1){
                ChessboardPoint destination3 = BishopChessComponent.super.source.offset(1, -6);
                if (SourcePoints.get(row + 1).charAt(col - 6) == '_') {
                    canmoveto.add(destination3);
                } else if ((int) SourcePoints.get(row + 1).charAt(col - 6) > 95) {
                    canmoveto.add(destination3);
                }
            }
            int d=Math.min(7-source.getX(),7-source.getY())+1;
            for (int i=1;i<d;i++){
                ChessboardPoint destination4=BishopChessComponent.super.source.offset(i, i);
                if (SourcePoints.get(row+i).charAt(col+i)=='_'){
                    canmoveto.add(destination4);
                }else if ((int)SourcePoints.get(row+i).charAt(col+i)>95){
                    canmoveto.add(destination4);
                    break;
                }else {
                    break;
                }
            }
        }else {
            int a=Math.min(source.getY(),source.getX())+1;
            for (int i=1;i<a;i++){
                ChessboardPoint destination1=BishopChessComponent.super.source.offset(-i, -i);
                if (SourcePoints.get(row-i).charAt(col-i)=='_'){
                    canmoveto.add(destination1);
                }else if ((int)SourcePoints.get(row-i).charAt(col-i)<95){
                    canmoveto.add(destination1);
                    break;
                }else {
                    break;
                }
            }
            int b=Math.min(7-source.getY(),source.getX())+1;
            for (int i=1;i<b;i++){
                ChessboardPoint destination2=BishopChessComponent.super.source.offset(-i, i);
                if (SourcePoints.get(row-i).charAt(col+i)=='_'){
                    canmoveto.add(destination2);
                }else if ((int)SourcePoints.get(row-i).charAt(col+i)<95){
                    canmoveto.add(destination2);
                    break;
                }else {
                    break;
                }
            }
            int c=Math.min(source.getY(),7-source.getX())+1;
            for (int i=1;i<c;i++){
                ChessboardPoint destination3=BishopChessComponent.super.source.offset(i, -i);
                if (SourcePoints.get(row+i).charAt(col-i)=='_'){
                    canmoveto.add(destination3);
                }else if ((int)SourcePoints.get(row+i).charAt(col-i)<95){
                    canmoveto.add(destination3);
                    break;
                }else {
                    break;
                }
            }
            int d=Math.min(7-source.getX(),7-source.getY())+1;
            for (int i=1;i<d;i++){
                ChessboardPoint destination4=BishopChessComponent.super.source.offset(i, i);
                if (SourcePoints.get(row+i).charAt(col+i)=='_'){
                    canmoveto.add(destination4);
                }else if ((int)SourcePoints.get(row+i).charAt(col+i)<95){
                    canmoveto.add(destination4);
                    break;
                }else {
                    break;
                }
            }
        }

        for (int k=0;k<canmoveto.size();k++){
            for (int l=k+1;l<canmoveto.size();l++){
                if (canmoveto.get(k).getX()>canmoveto.get(l).getX()){
                    Collections.swap(canmoveto,k,l);
                }else if (canmoveto.get(k).getX()==canmoveto.get(l).getX()&&canmoveto.get(k).getY()>canmoveto.get(l).getY()){
                    Collections.swap(canmoveto,k,l);
                }
            }
        }
        return canmoveto;
    }
}

