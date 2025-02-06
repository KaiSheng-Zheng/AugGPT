import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    int x=this.getSource().getX();
    int y=this.getSource().getY();

    public RookChessComponent(int indexOf, int i, ChessColor black, char b) {
        super(indexOf, i, black, b);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i==x&&j!=y)||(j==y&&i!=x)){
                    boolean isBarrier=false;
                    int isEat=0;

                    if (chessboard[i][j].getChessColor()!=this.getChessColor()){
                        if(x<i&&y==j){
                            isEat=0;
                            for (int k = x+1; k <i+1 ; k++) {
                                 if (chessboard[k][y].getChessColor() == this.getChessColor()) {
                                            isBarrier = true;
                                            break;
                                 }
                                 if (chessboard[k][y].getChessColor()!=this.getChessColor()&&chessboard[k][y].getChessColor()!=ChessColor.NONE){
                                     isEat++;
                                 }




                            }
                        }

                        if(x>i&&y==j){
                            isEat=0;
                            for (int k = x-1; k >i-1 ; k--) {
                                 if(chessboard[k][y].getChessColor()==this.getChessColor()){
                                            isBarrier=true;
                                            break;
                                 }
                                if (chessboard[k][y].getChessColor()!=this.getChessColor()&&chessboard[k][y].getChessColor()!=ChessColor.NONE){
                                    isEat++;
                                }
                            }
                        }

                        if(x==i&&y>j){
                          isEat=0;
                                for (int l = y-1; l >j-1 ; l--) {
                                      if (chessboard[x][l].getChessColor() == this.getChessColor()) {
                                            isBarrier = true;
                                            break;
                                        }
                                    if (chessboard[x][l].getChessColor()!=this.getChessColor()&&chessboard[x][l].getChessColor()!=ChessColor.NONE){
                                        isEat++;
                                    }

                                }


                        }

                        if(x==i&&y<j){
                            isEat=0;
                                for (int l = y+1; l <j+1 ; l++) {
                                        if (chessboard[x][l].getChessColor() == this.getChessColor()) {
                                            isBarrier = true;
                                            break;
                                        }
                                    if (chessboard[x][l].getChessColor()!=this.getChessColor()&&chessboard[x][l].getChessColor()!=ChessColor.NONE){
                                        isEat++;
                                    }

                                }


                        }

                        if (!isBarrier&&isEat<=1){
                            point.add(new ChessboardPoint(i,j));
                        }
                    }
                    }

                }

            }


        return point;
    }
}