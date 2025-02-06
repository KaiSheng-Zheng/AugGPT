import java.util.ArrayList;
import java.util.List;

public  class BishopChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
    one:   for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)){
                    if (i!=0 || j!=0 ){
                        if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)
                                && getChessComponents()[x+i][y+j].getChessColor()!= getChessColor() &&
                                !(getChessComponents()[x+i][y+j] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x+i,y+j));
                            break one;
                        }else if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7&& Math.abs(i)==Math.abs(j)
                                && getChessComponents()[x+i][y+j].getChessColor()== getChessColor()){
                            break one;
                        }else if (x+i>=0 && x+i<=7 && y+j>=0 &&y+j<=7&& Math.abs(i)==Math.abs(j)
                                && getChessComponents()[x+i][y+j] instanceof EmptySlotComponent){
                            canmoveto.add(new ChessboardPoint(x+i,y+j));
                        }
                    }
                }

            }
        }

    two:    for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8; j++) {
                if (x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)){
                    if (i!=0 || j!=0   ){
                        if (x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)
                                && getChessComponents()[x+i][y-j].getChessColor()!= getChessColor()
                        && !(getChessComponents()[x+i][y-j] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x+i,y-j));
                            break two;
                        }else if (x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)
                                &&x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 &&getChessComponents()[x+i][y-j].getChessColor()== getChessColor()){
                            break two;
                        }else if (x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)
                                &&x+i>=0&&x+i<=7 && y-j>=0 &&y-j<=7 &&getChessComponents()[x+i][y-j] instanceof EmptySlotComponent){
                            canmoveto.add(new ChessboardPoint(x+i,y-j));
                        }
                    }
                }

            }
        }

    three:    for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x-i>=0&&x-i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)){
                    if (i!=0 || j!=0 ){
                        if (x-i>=0&&x-i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)
                                &&getChessComponents()[x-i][y+j].getChessColor()!= getChessColor()
                                && !(getChessComponents()[x-i][y+j] instanceof EmptySlotComponent)    ){
                            canmoveto.add(new ChessboardPoint(x-i,y+j));
                            break three;
                        }else if (x-i>=0&&x-i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)
                                &&getChessComponents()[x-i][y+j].getChessColor()== getChessColor()){
                            break three;
                        }else if (x-i>=0&&x-i<=7 && y+j>=0 &&y+j<=7 && Math.abs(i)==Math.abs(j)
                                &&getChessComponents()[x-i][y+j] instanceof EmptySlotComponent){
                            canmoveto.add(new ChessboardPoint(x-i,y+j));
                        }
                    }
                }

            }
        }

    four:    for (int i = 0;i <8;i++) {
            for (int j = 0;j <8; j++) {
                if (x-i>=0&&x-i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)){
                    if (i!=0 || j!=0 ){
                        if (x-i>=0&&x-i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)&&
                                getChessComponents()[x-i][y-j].getChessColor()!= getChessColor()
                                && !(getChessComponents()[x-i][y-j] instanceof EmptySlotComponent)
                        ){
                            canmoveto.add(new ChessboardPoint(x-i,y-j));
                            break four;
                        }else if (x-i>=0&&x-i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)&&
                                getChessComponents()[x-i][y-j].getChessColor()== getChessColor()){
                            break four;
                        }else if (x-i>=0&&x-i<=7 && y-j>=0 &&y-j<=7 && Math.abs(i)==Math.abs(j)&&
                                getChessComponents()[x-i][y-j] instanceof EmptySlotComponent){
                            canmoveto.add(new ChessboardPoint(x-i,y-j));
                        }
                    }
                }

            }
        }

        return canmoveto;
    }
}
