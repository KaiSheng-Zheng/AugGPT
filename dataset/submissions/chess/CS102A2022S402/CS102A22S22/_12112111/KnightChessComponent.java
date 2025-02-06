import java.util.ArrayList;
import java.util.List;

public   class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> canmoveto = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
    /*    for (int i = -2; i < 3; i++) {
            for (int j = -2; j <3 ; j++) {
                if ( x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7 && i!=0||j!=0){
                    if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7 &&Math.abs(i)== 1&& Math.abs(j)==2 && getChessComponents()[x+i][y+j].getChessColor()!=this.getChessColor()
                    ){
                        canmoveto.add(new ChessboardPoint(x+i,y+j));
                    }
                    if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7  && Math.abs(i)== 2 && Math.abs(j)==1 && getChessComponents()[x+i][y+j].getChessColor()!=this.getChessColor()
                    ){
                        canmoveto.add(new ChessboardPoint(x+i,y+j));
                    }

                }

            }
        }*/
        if (x + 1 <= 7 && y + 2 <= 7) {
            if (x + 1 <= 7 && y + 2 <= 7 && getChessComponents()[x + 1][y + 2].getChessColor()!= this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
        if (x - 1 >= 0 && y + 2 <= 7) {
            if (x - 1 >= 0 && y + 2 <= 7 && getChessComponents()[x - 1][y + 2].getChessColor() != this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
            if (x + 1 <= 7 && y - 2 >= 0) {
                if (x + 1 <= 7 && y - 2 >= 0 && getChessComponents()[x + 1][y -2].getChessColor() != this.getChessColor()) {
                    canmoveto.add(new ChessboardPoint(x + 1, y - 2));
                }
            }
                if (x - 1 >=0 && y - 2 >=0) {
                    if (x - 1 >=0 && y - 2 >=0 && getChessComponents()[x - 1][y - 2].getChessColor() != this.getChessColor()) {
                        canmoveto.add(new ChessboardPoint(x - 1, y - 2));
                    }
                }

        if (x - 2 >=0 && y - 1 >=0) {
            if (x - 2 >=0 && y - 1 >=0 && getChessComponents()[x -2][y -1].getChessColor() != this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if (x - 2 >=0 && y +1 <=7) {
            if (x - 2 >=0 && y +1 <=7  && getChessComponents()[x -2][y + 1].getChessColor() != this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x - 2, y +1));
            }
        }
        if (x + 2 <=7 && y +1 <=7) {
            if (x +2 <=7 && y +1 <=7  && getChessComponents()[x + 2][y + 1].getChessColor() != this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x + 2, y +1));
            }
        }
        if (x + 2 <=7 && y -1 >=0) {
            if (x +2<=7 && y -1>=0 && getChessComponents()[x + 2][y -1].getChessColor() != this.getChessColor()) {
                canmoveto.add(new ChessboardPoint(x + 2, y -1));
            }
        }

        return canmoveto;
            }



        }

