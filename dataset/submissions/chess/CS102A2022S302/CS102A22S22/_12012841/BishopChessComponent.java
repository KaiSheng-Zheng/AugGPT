import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {



    int x=this.getSource().getX();
    int y=this.getSource().getY();

    public BishopChessComponent(int indexOf, int i, ChessColor black, char b) {
                super(indexOf, i, black, b);}

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new ArrayList<>();

         for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (Math.abs(x-i)==Math.abs(y-j)&&y!=j){
                boolean isBarrier=false;
                    int isEat=0;
                  if (chessboard[i][j].getChessColor()!=this.getChessColor()) {
                      if(x<i&&y<j){
                          for (int k = x+1; k <i+1 ; k++) {
                              for (int l = y+1; l <j+1 ; l++) {
                                  if (Math.abs(x-k)==Math.abs(y-l)){
                                  if(chessboard[k][l].getChessColor()==this.getChessColor()){
                                      isBarrier=true;
                                      break;
                                  }
                                  if (chessboard[k][l].getChessColor()!=this.getChessColor()&&chessboard[k][l].getChessColor()!=ChessColor.NONE){
                                          isEat++;
                                  }

                              }}

                          }
                      }

                      if(x>i&&y>j){
                          for (int k = x-1; k >i-1 ; k--) {
                              for (int l = y-1; l >j-1 ; l--) {
                                  if (Math.abs(x-k)==Math.abs(y-l)){
                                  if(chessboard[k][l].getChessColor()==this.getChessColor()){
                                      isBarrier=true;
                                      break;
                                  }
                                  if (chessboard[k][l].getChessColor()!=this.getChessColor()&&chessboard[k][l].getChessColor()!=ChessColor.NONE) {
                                      isEat++;
                                  }

                              }
                              }

                          }
                      }

                      if(x<i&&y>j){
                          for (int k = x+1; k <i+1 ; k++) {
                              for (int l = y-1; l >j-1 ; l--) {
                                  if (Math.abs(x-k)==Math.abs(y-l)){
                                  if (chessboard[k][l].getChessColor() == this.getChessColor()) {
                                      isBarrier = true;
                                      break;
                                  }
                                  if (chessboard[k][l].getChessColor()!=this.getChessColor()&&chessboard[k][l].getChessColor()!=ChessColor.NONE){
                                          isEat++;
                                  }
                                  }

                              }

                          }
                      }

                      if(x>i&&y<j){
                          for (int k = x-1; k >i-1 ; k--) {
                              for (int l = y+1; l <j+1 ; l++) {
                                  if (Math.abs(x-k)==Math.abs(y-l)) {
                                      if (chessboard[k][l].getChessColor() == this.getChessColor()) {
                                          isBarrier = true;
                                          break;
                                      }
                                      if (chessboard[k][l].getChessColor()!=this.getChessColor()&&chessboard[k][l].getChessColor()!=ChessColor.NONE){
                                          isEat++;
                                      }
                                  }
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
