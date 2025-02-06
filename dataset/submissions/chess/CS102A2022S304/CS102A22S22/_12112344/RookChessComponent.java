import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    ArrayList<String> SourcePoints;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, List<String> chessboard) {
        super(source, chessColor, name, chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int col = RookChessComponent.super.source.getY();
        int row = RookChessComponent.super.source.getX();
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK) {
            int a=source.getY()+1;
            for (int i=1;i<a;i++){
                ChessboardPoint destination1=RookChessComponent.super.source.offset(0, -i);
                if (SourcePoints.get(row).charAt(col-i)=='_'){
                    canmoveto.add(destination1);
                }else if ((int)SourcePoints.get(row).charAt(col-i)>95){
                    canmoveto.add(destination1);
                    break;
                }else {
                    break;
                }
            }
            int b=8-source.getY();
            for (int i=1;i<b;i++){
                ChessboardPoint destination2=RookChessComponent.super.source.offset(0, i);
                if (SourcePoints.get(row).charAt(col+i)=='_'){
                    canmoveto.add(destination2);
                }else if ((int)SourcePoints.get(row).charAt(col+i)>95){
                    canmoveto.add(destination2);
                    break;
                }else {
                    break;
                }
            }
            int c=source.getX()+1;
            for (int i=1;i<c;i++){
                ChessboardPoint destination3=RookChessComponent.super.source.offset(-i, 0);
                if (SourcePoints.get(row-i).charAt(col)=='_'){
                    canmoveto.add(destination3);
                }else if ((int)SourcePoints.get(row-i).charAt(col)>95){
                    canmoveto.add(destination3);
                    break;
                }else {
                    break;
                }
            }
            int d=8-source.getX();
            for (int i=1;i<d;i++){
                ChessboardPoint destination4=RookChessComponent.super.source.offset(i, 0);
                if (SourcePoints.get(row+i).charAt(col)=='_'){
                    canmoveto.add(destination4);
                }else if ((int)SourcePoints.get(row+i).charAt(col)>95){
                    canmoveto.add(destination4);
                    break;
                }else {
                    break;
                }
            }
        }else {
            int a=source.getY()+1;
            for (int i=1;i<a;i++){
                ChessboardPoint destination1=RookChessComponent.super.source.offset(0, -i);
                if (SourcePoints.get(row).charAt(col-i)=='_'){
                    canmoveto.add(destination1);
                }else if ((int)SourcePoints.get(row).charAt(col-i)<95){
                    canmoveto.add(destination1);
                    break;
                }else {
                    break;
                }
            }
            int b=8-source.getY();
            for (int i=1;i<b;i++){
                ChessboardPoint destination2=RookChessComponent.super.source.offset(0, i);
                if (SourcePoints.get(row).charAt(col+i)=='_'){
                    canmoveto.add(destination2);
                }else if ((int)SourcePoints.get(row).charAt(col+i)<95){
                    canmoveto.add(destination2);
                    break;
                }else {
                    break;
                }
            }
            int c=source.getX()+1;
            for (int i=1;i<c;i++){
                ChessboardPoint destination3=RookChessComponent.super.source.offset(-i, 0);
                if (SourcePoints.get(row-i).charAt(col)=='_'){
                    canmoveto.add(destination3);
                }else if ((int)SourcePoints.get(row-i).charAt(col)<95){
                    canmoveto.add(destination3);
                    break;
                }else {
                    break;
                }
            }
            int d=8-source.getX();
            for (int i=1;i<d;i++){
                ChessboardPoint destination4=RookChessComponent.super.source.offset(i, 0);
                if (SourcePoints.get(row+i).charAt(col)=='_'){
                    canmoveto.add(destination4);
                }else if ((int)SourcePoints.get(row+i).charAt(col)<95){
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


