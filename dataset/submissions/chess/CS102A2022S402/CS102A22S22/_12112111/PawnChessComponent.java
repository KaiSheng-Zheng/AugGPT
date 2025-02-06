import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();

            if ( getChessComponents()[x][y].getChessColor()==ChessColor.BLACK){
                if (x+1<=7){
                    if (getChessComponents()[x+1][y] instanceof EmptySlotComponent  ){
                        if (x+2<=7 ){
                            if (getChessComponents()[x+1][y] instanceof EmptySlotComponent
                                    && getChessComponents()[x+2][y] instanceof EmptySlotComponent && x==1){
                                canmoveto.add(new ChessboardPoint(x+1,y));
                                canmoveto.add(new ChessboardPoint(x+2,y));
                            }else if (getChessComponents()[x+1][y] instanceof EmptySlotComponent  ){
                                canmoveto.add(new ChessboardPoint(x+1,y));
                            }
                        }
                    }
                    if (y-1>=0 ){
                        if (getChessComponents()[x+1][y-1].getChessColor()==ChessColor.WHITE &&!(getChessComponents()[x+1][y-1] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x+1,y-1));
                        }
                    }
                    if (y+1<=7){
                        if (getChessComponents()[x+1][y+1].getChessColor()==ChessColor.WHITE &&!(getChessComponents()[x+1][y+1] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x+1,y+1));
                        }
                    }

                }

            }



            if (getChessComponents()[x][y].getChessColor()==ChessColor.WHITE){
                if (x-1>=0){
                    if (getChessComponents()[x-1][y] instanceof EmptySlotComponent){
                        if ( x-2>=0 ){
                            if (getChessComponents()[x-1][y] instanceof EmptySlotComponent
                                    && getChessComponents()[x-2][y] instanceof EmptySlotComponent && x==6){
                                canmoveto.add(new ChessboardPoint(x-2,y));
                                canmoveto.add(new ChessboardPoint(x-1,y));
                            }else if (getChessComponents()[x-1][y] instanceof EmptySlotComponent){
                                canmoveto.add(new ChessboardPoint(x-1,y));
                            }
                        }
                    }
                    if (y-1>=0 ){
                        if (getChessComponents()[x-1][y-1].getChessColor()==ChessColor.BLACK  &&!(getChessComponents()[x-1][y-1] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x-1,y-1));
                        }
                    }
                    if (y+1<=7){
                        if (getChessComponents()[x-1][y+1].getChessColor()==ChessColor.BLACK && !(getChessComponents()[x-1][y+1] instanceof EmptySlotComponent)){
                            canmoveto.add(new ChessboardPoint(x-1,y+1));
                        }
                    }


                }
                }




        return canmoveto;
    }
}
