import java.util.ArrayList;
import java.util.List;

public  class  RookChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();

        for (int i = 1; i <8 ; i++) {
            if (x-i>=0){
                if ( x-i>=0 &&getChessComponents()[x-i][y].getChessColor()== this.getChessColor()){
                    break;
                }else if (x-i>=0 && getChessComponents()[x-i][y].getChessColor()!= this.getChessColor() &&
                        !(getChessComponents()[x-i][y] instanceof EmptySlotComponent)){
                    canmoveto.add(new ChessboardPoint(x-i,y));
                    break;
                }else if (x-i>=0 && getChessComponents()[x-i][y]instanceof EmptySlotComponent){
                    canmoveto.add(new ChessboardPoint(x-i,y));
                }
            }
        }
        for (int i = 1; i <8 ; i++) {
            if (x+i<=7){
                if (x+i<=7&&getChessComponents()[x+i][y].getChessColor()== getChessColor()){
                    break;
                }else if (x+i<=7&& getChessComponents()[x+i][y].getChessColor()!= this.getChessColor() &&
                        !(getChessComponents()[x+i][y] instanceof EmptySlotComponent)){
                    canmoveto.add(new ChessboardPoint(x+i,y));
                    break;
                }else if (x+i<=7&& getChessComponents()[x+i][y]instanceof EmptySlotComponent){

                    canmoveto.add(new ChessboardPoint(x+i,y));
                }
            }
        }
        for (int i = -1; i >-8 ; i--) {
            if (y+i>=0){
                if (getChessComponents()[x][y+i].getChessColor()== getChessColor()){
                    break;
                }else if (getChessComponents()[x][y+i].getChessColor()!= getChessColor() &&
                        !(getChessComponents()[x][y+i] instanceof EmptySlotComponent)){
                    canmoveto.add(new ChessboardPoint(x,y+i));
                    break;
                }
                else if (getChessComponents()[x][y+i]instanceof EmptySlotComponent){
                    canmoveto.add(new ChessboardPoint(x,y+i));
                }
            }

        }
        for (int i = 1; i <8 ; i++) {
            if (y+i<=7){
                if (getChessComponents()[x][y+i].getChessColor()== getChessColor()){
                    break;
                }else if (getChessComponents()[x][y+i].getChessColor()!= getChessColor()
                && !(getChessComponents()[x][y+i] instanceof EmptySlotComponent)){
                    canmoveto.add(new ChessboardPoint(x,y+i));
                    break;
                }else if (getChessComponents()[x][y+i]instanceof EmptySlotComponent){
                    canmoveto.add(new ChessboardPoint(x,y+i));
                }
            }
        }



        return canmoveto;
    }


}
