import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        boolean canMove = true;
        int j = source.getY() - source.getX();
        int k = source.getX() + source.getY();//x+y = k
        List<ChessboardPoint> can = new ArrayList<>();
        for (int i = source.getX()-1; i >=0 ; i--) {
            canMove = true;
            if (k-i>=0&&k-i<8){
                ChessboardPoint destination = new ChessboardPoint(i, k-i);
                for (int l = source.getX()-1; l>=0; l--) {
                    if (k-l>=0&&k-l<8){
                        if (!(chessboard[l][k-l] instanceof EmptySlotComponent)){
                            canMove = false;
                        }
                    }
                }
                if (canMove&&chessboard[i][k-i].chessColor==getChessColor()){
                    canMove=false;
                }

            if (canMove==true){
                can.add(destination);
            }
        }
        }
        for (int i = source.getX()+1; i <8 ; i++) {
            canMove = true;
            if (k-i<8&&k-i>=0){
                ChessboardPoint destination = new ChessboardPoint(i, k-i);
                for (int l = source.getX()+1; l<8; l++) {
                    if (k-l<8&&k-l>=0){
                        if (!(chessboard[l][k-l] instanceof EmptySlotComponent)){
                            canMove = false;
                        }
                    }
                }
                if (canMove&&chessboard[i][k-i].chessColor==getChessColor()){
                    canMove=false;
                }

                if (canMove==true){
                    can.add(destination);
                }
            }
        }
        //y-x=j
        for (int i = source.getX()-1; i >=0 ; i--) {
            canMove = true;
            if (i+j<8&&i+j>=0){
                ChessboardPoint destination = new ChessboardPoint(i, i+j);
                for (int l = source.getX()-1; l>=0; l--) {
                    if (l+j<8&&l+j>=0){
                        if (!(chessboard[l][j+l] instanceof EmptySlotComponent)){
                            canMove = false;
                        }
                    }
                }
                if (canMove&&chessboard[i][i+j].chessColor==getChessColor()){
                    canMove=false;
                }

                if (canMove==true){
                    can.add(destination);
                }
            }
        }
        for (int i = source.getX()+1; i <8 ; i++) {
            canMove = true;
            if (i+j>=0&&i+j<8){
                ChessboardPoint destination = new ChessboardPoint(i, i+j);
                for (int l = source.getX()+1; l>8; l++) {
                    if (l+j>=0&&i+j<8){
                        if (!(chessboard[l][j+l] instanceof EmptySlotComponent)){
                            canMove = false;
                        }
                    }
                }
                if (canMove&&chessboard[i][i+j].chessColor==getChessColor()){
                    canMove=false;
                }

                if (canMove==true){
                    can.add(destination);
                }
            }
        }
        if (can != null) {
            return can;
        } else {
            return new ArrayList<>();
        }
    }

}
