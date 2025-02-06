import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char theName,ChessComponent[][] chessComponents){
        super(source,chessColor,theName,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints=new ArrayList<>();
        int row=this.getSource().getX();
        int col=this.getSource().getY();

        int[][] points=new int[8][2];
        points[0]=new int[]{row+2, col+1};
        points[1]=new int[]{row+1, col+2};
        points[2]=new int[]{row-1, col+2};
        points[3]=new int[]{row-2, col+1};
        points[4]=new int[]{row-2, col-1};
        points[5]=new int[]{row-1, col-2};
        points[6]=new int[]{row+1, col-2};
        points[7]=new int[]{row+2, col-1};

        for(int i=0;i<8;i++){
            if(points[i][0]>=0&&points[i][0]<8&&points[i][1]>=0&&points[i][1]<8&&chessboard[points[i][0]][points[i][1]].getChessColor()!=this.getChessColor()){
                movablePoints.add(chessboard[points[i][0]][points[i][1]].getSource());
            }
        }
        return movablePoints;
    }
}
