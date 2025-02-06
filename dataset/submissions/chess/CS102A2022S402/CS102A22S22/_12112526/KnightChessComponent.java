import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public KnightChessComponent(ChessboardPoint source) {
        super(source);
    }

    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessComponent[][] chessboard) {
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
                if(chessboard[i][j].getChessColor()!=this.getChessColor()){
                    if (i-row==1&&j-col==2){a.add(destination);}
                    else if(i-row==1&&j-col==-2){a.add(destination);}
                    else if(i-row==2&&j-col==-1){a.add(destination);}
                    else if(i-row==2&&j-col==1){a.add(destination);}
                    else if(i-row==-1&&j-col==2){a.add(destination);}
                    else if(i-row==-1&&j-col==-2){a.add(destination);}
                    else if(i-row==-2&&j-col==1){a.add(destination);}
                    else if(i-row==-2&&j-col==-1){a.add(destination);}
                }
            }
        }
        return a;
    }
    @Override
    public String toString() {
        if(super.getChessColor()==ChessColor.WHITE){
            return "n";
        }
        else{
            return"N";
        }
    }
}
