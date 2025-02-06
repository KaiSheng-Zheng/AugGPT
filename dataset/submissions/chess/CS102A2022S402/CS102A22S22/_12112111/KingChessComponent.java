import java.util.ArrayList;
import java.util.List;

public  class  KingChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = -1; i <2 ; i++) {
            for (int j = -1; j < 2; j++) {
                if ( x+i>=0&&x+i<=7 && y+j>=0 &&y+j<=7){
                    if (i!=0 || j!=0 && getChessComponents()[x+i][y+j].getChessColor()!= getChessColor()
                    ){
                        if (getChessComponents()[x+i][y+j].getChessColor()!= getChessColor()){
                            canmoveto.add(new ChessboardPoint(x+i,y+j));
                        }

                    }
                }
            }
        }return canmoveto;
    }

}
