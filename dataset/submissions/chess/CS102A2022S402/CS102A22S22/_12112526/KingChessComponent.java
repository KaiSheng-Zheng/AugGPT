import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public KingChessComponent(ChessboardPoint source) {
        super(source);
    }

    public KingChessComponent() {
    }

    public KingChessComponent(ChessComponent[][] chessboard) {
        super(chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a=new ArrayList<>();
        int row= this.getSource().getX();
        int col=this.getSource().getY();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint destination=chessboard[i][j].getSource();
                if(chessboard[i][j].getChessColor()!=this.getChessColor()) {
                    if (i == row && j == col - 1) {a.add(destination);}
                    else if(i==row&&j==col+1){a.add(destination);}
                    else if(i==row-1&&j==col-1){a.add(destination);}
                    else if(i==row-1&&j==col){a.add(destination);}
                    else if(i==row-1&&j==col+1){a.add(destination);}
                    else if(i==row+1&&j==col-1){a.add(destination);}
                    else if(i==row+1&&j==col){a.add(destination);}
                    else if(i==row+1&&j==col+1){a.add(destination);}
            }
        }
    }
        return a;
    }
    @Override
    public String toString() {
        if(super.getChessColor()==ChessColor.WHITE){
            return "k";
        }
        else{
            return"K";
        }
    }
}
