import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class QueenChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int col = QueenChessComponent.super.source.getY();
        int row = QueenChessComponent.super.source.getX();
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();

        int a = Math.min(source.getY(), source.getX()) + 1;
        if (QueenChessComponent.super.chessColor == ChessColor.BLACK) {
            for (int i = 1; i < a; i++) {
                ChessboardPoint destination1 = QueenChessComponent.super.source.offset(-i, -i);
                if (SourcePoints.get(row - i).charAt(col - i) == '_') {
                    canmoveto.add(destination1);
                } else if ((int) SourcePoints.get(row - i).charAt(col - i) > 95) {
                    canmoveto.add(destination1);
                    break;
                } else {
                    break;
                }
            }
            int b = Math.min(7 - source.getY(), source.getX()) + 1;
            for (int i = 1; i < b; i++) {
                ChessboardPoint destination2 = QueenChessComponent.super.source.offset(-i, i);
                if (SourcePoints.get(row - i).charAt(col + i) == '_') {
                    canmoveto.add(destination2);
                } else if ((int) SourcePoints.get(row - i).charAt(col + i) > 95) {
                    canmoveto.add(destination2);
                    break;
                } else {
                    break;
                }
            }
            int c = Math.min(source.getY(), 7 - source.getX()) + 1;
            for (int i = 1; i < c; i++) {
                ChessboardPoint destination3 = QueenChessComponent.super.source.offset(i, -i);
                if (SourcePoints.get(row + i).charAt(col - i) == '_') {
                    canmoveto.add(destination3);
                } else if ((int) SourcePoints.get(row + i).charAt(col - i) > 95) {
                    canmoveto.add(destination3);
                    break;
                } else {
                    break;
                }
            }
            int d = Math.min(7 - source.getX(), 7 - source.getY()) + 1;
            for (int i = 1; i < d; i++) {
                ChessboardPoint destination4 = QueenChessComponent.super.source.offset(i, i);
                if (SourcePoints.get(row + i).charAt(col + i) == '_') {
                    canmoveto.add(destination4);
                } else if ((int) SourcePoints.get(row + i).charAt(col + i) > 95) {
                    canmoveto.add(destination4);
                    break;
                } else {
                    break;
                }
            }
            int e = source.getY() + 1;
            for (int i = 1; i < e; i++) {
                ChessboardPoint destination5 = QueenChessComponent.super.source.offset(0, -i);
                if (SourcePoints.get(row).charAt(col - i) == '_') {
                    canmoveto.add(destination5);
                } else if ((int) SourcePoints.get(row).charAt(col - i) > 95) {
                    canmoveto.add(destination5);
                    break;
                } else {
                    break;
                }
            }
            int f = 8 - source.getY();
            for (int i = 1; i < f; i++) {
                ChessboardPoint destination6 = QueenChessComponent.super.source.offset(0, i);
                if (SourcePoints.get(row).charAt(col + i) == '_') {
                    canmoveto.add(destination6);
                } else if ((int) SourcePoints.get(row).charAt(col + i) > 95) {
                    canmoveto.add(destination6);
                    break;
                } else {
                    break;
                }
            }
            int g = source.getX() + 1;
            for (int i = 1; i < g; i++) {
                ChessboardPoint destination7 = QueenChessComponent.super.source.offset(-i, 0);
                if (SourcePoints.get(row - i).charAt(col) == '_') {
                    canmoveto.add(destination7);
                } else if ((int) SourcePoints.get(row - i).charAt(col) > 95) {
                    canmoveto.add(destination7);
                    break;
                } else {
                    break;
                }
            }
            int h = 8 - source.getX();
            for (int i = 1; i < h; i++) {
                ChessboardPoint destination8 = QueenChessComponent.super.source.offset(i, 0);
                if (SourcePoints.get(row + i).charAt(col) == '_') {
                    canmoveto.add(destination8);
                } else if ((int) SourcePoints.get(row + i).charAt(col) > 95) {
                    canmoveto.add(destination8);
                    break;
                } else {
                    break;
                }
            }
        } else {
            for (int i = 1; i < a; i++) {
                ChessboardPoint destination1 = QueenChessComponent.super.source.offset(-i, -i);
                if (SourcePoints.get(row - i).charAt(col - i) == '_') {
                    canmoveto.add(destination1);
                } else if ((int) SourcePoints.get(row - i).charAt(col - i) < 95) {
                    canmoveto.add(destination1);
                    break;
                } else {
                    break;
                }
            }
            int b = Math.min(7 - source.getY(), source.getX()) + 1;
            for (int i = 1; i < b; i++) {
                ChessboardPoint destination2 = QueenChessComponent.super.source.offset(-i, i);
                if (SourcePoints.get(row - i).charAt(col + i) == '_') {
                    canmoveto.add(destination2);
                } else if ((int) SourcePoints.get(row - i).charAt(col + i) < 95) {
                    canmoveto.add(destination2);
                    break;
                } else {
                    break;
                }
            }
            int c = Math.min(source.getY(), 7 - source.getX()) + 1;
            for (int i = 1; i < c; i++) {
                ChessboardPoint destination3 = QueenChessComponent.super.source.offset(i, -i);
                if (SourcePoints.get(row + i).charAt(col - i) == '_') {
                    canmoveto.add(destination3);
                } else if ((int) SourcePoints.get(row + i).charAt(col - i) < 95) {
                    canmoveto.add(destination3);
                    break;
                } else {
                    break;
                }
            }
            int d = Math.min(7 - source.getX(), 7 - source.getY()) + 1;
            for (int i = 1; i < d; i++) {
                ChessboardPoint destination4 = QueenChessComponent.super.source.offset(i, i);
                if (SourcePoints.get(row + i).charAt(col + i) == '_') {
                    canmoveto.add(destination4);
                } else if ((int) SourcePoints.get(row + i).charAt(col + i) < 95) {
                    canmoveto.add(destination4);
                    break;
                } else {
                    break;
                }
            }
            int e = source.getY() + 1;
            for (int i = 1; i < e; i++) {
                ChessboardPoint destination5 = QueenChessComponent.super.source.offset(0, -i);
                if (SourcePoints.get(row).charAt(col - i) == '_') {
                    canmoveto.add(destination5);
                } else if ((int) SourcePoints.get(row).charAt(col - i) < 95) {
                    canmoveto.add(destination5);
                    break;
                } else {
                    break;
                }
            }
            int f = 8 - source.getY();
            for (int i = 1; i < f; i++) {
                ChessboardPoint destination6 = QueenChessComponent.super.source.offset(0, i);
                if (SourcePoints.get(row).charAt(col + i) == '_') {
                    canmoveto.add(destination6);
                } else if ((int) SourcePoints.get(row).charAt(col + i) < 95) {
                    canmoveto.add(destination6);
                    break;
                } else {
                    break;
                }
            }
            int g = source.getX() + 1;
            for (int i = 1; i < g; i++) {
                ChessboardPoint destination7 = QueenChessComponent.super.source.offset(-i, 0);
                if (SourcePoints.get(row - i).charAt(col) == '_') {
                    canmoveto.add(destination7);
                } else if ((int) SourcePoints.get(row - i).charAt(col) < 95) {
                    canmoveto.add(destination7);
                    break;
                } else {
                    break;
                }
            }
            int h = 8 - source.getX();
            for (int i = 1; i < h; i++) {
                ChessboardPoint destination8 = QueenChessComponent.super.source.offset(i, 0);
                if (SourcePoints.get(row + i).charAt(col) == '_') {
                    canmoveto.add(destination8);
                } else if ((int) SourcePoints.get(row + i).charAt(col) < 95) {
                    canmoveto.add(destination8);
                    break;
                } else {
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


