import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source) {
        super(source);
    }

    public BishopChessComponent(ChessComponent[][] chessboard) {
        super(chessboard);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a=new ArrayList<>();
        int row= this.getSource().getX();
        int col=this.getSource().getY();
        a:for(int i=0;i<8;i++){
            b:for(int j=0;j<8;j++){
                ChessboardPoint destination=chessboard[i][j].getSource();
                if(row - destination.getX() + col - destination.getY() == 0 || row - destination.getX() - col + destination.getY() == 0){
                    if(chessboard[i][j].getChessColor()!=this.getChessColor()&&chessboard[i][j].getSource()!=this.getSource()){
                        if(row - destination.getX() - col + destination.getY() == 0&&row<destination.getX()){
                            int n=col+1;
                            for(int m=row+1;m<destination.getX();m++){
                                if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                                   continue b;
                                }
                                n++;
                            }
                            a.add(destination);
                        }
                        else if(row - destination.getX() - col + destination.getY() == 0&&row>destination.getX()){
                            int n=col-1;
                            for(int m=row-1;m>destination.getX();m--){
                                if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                                    continue  b;
                                }
                                n--;
                            }
                            a.add(destination);
                        }
                        else if(row - destination.getX() + col - destination.getY() == 0&&row<destination.getX()){
                            int n=col-1;
                            for(int m=row+1;m<destination.getX();m++){
                                if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                                   continue b;
                                }
                                n--;
                            }
                            a.add(destination);
                        }
                        else if(row - destination.getX() + col - destination.getY() == 0&&row>destination.getX()){
                            int n=col+1;
                            for(int m=row-1;m>destination.getX();m--){
                                if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                                    continue b;
                                }
                                n++;
                            }
                            a.add(destination);
                        }

                    }
                }
            }
        }
        return a;
    }

    @Override
    public String toString() {
       if(super.getChessColor()==ChessColor.WHITE){
           return "b";
       }
       else{
           return"B";
       }
    }
}
