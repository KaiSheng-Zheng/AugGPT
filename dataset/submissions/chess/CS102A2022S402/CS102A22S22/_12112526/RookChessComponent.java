
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(getChessColor()==ChessColor.WHITE){
            this.name='r';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='R';
        }
    }

    public RookChessComponent(ChessboardPoint source) {
        super(source);
        if(getChessColor()==ChessColor.WHITE){
            this.name='r';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='R';
        }
    }

    public RookChessComponent() {
        if(getChessColor()==ChessColor.WHITE){
            this.name='r';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='R';
        }
    }

    public RookChessComponent(ChessComponent[][] chessboard) {
        super(chessboard);
        if(getChessColor()==ChessColor.WHITE){
            this.name='r';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='R';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        ArrayList<ChessboardPoint> b=new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        if(row<7){
        for(int i=row+1;i<8;i++){
            if(chessboard[i][col]instanceof EmptySlotComponent){
                a.add(chessboard[i][col].getSource());
            }
            else if(chessboard[i][col].getChessColor()!=this.getChessColor()){
                a.add(chessboard[i][col].getSource());
                break;
            }
            else{
                break;
            }
        }}
        if(row>0){
        for(int i=row-1;i>=0;i--){
            if(chessboard[i][col]instanceof EmptySlotComponent){
                a.add(chessboard[i][col].getSource());
            }
            else if(chessboard[i][col].getChessColor()!=this.getChessColor()){
                a.add(chessboard[i][col].getSource());
                break;
            }
            else{
                break;
            }
        }}
        if(col<7){
        for(int i=col+1;i<8;i++){
            if(chessboard[row][i]instanceof EmptySlotComponent){
                a.add(chessboard[row][i].getSource());
            }
            else if(chessboard[row][i].getChessColor()!=this.getChessColor()){
                a.add(chessboard[row][i].getSource());
                break;
            }
            else{
                break;
            }
        }}
        if(col>0){
        for(int i=col-1;i>=0;i--){
            if(chessboard[row][i]instanceof EmptySlotComponent){
                a.add(chessboard[row][i].getSource());
            }
            else if(chessboard[row][i].getChessColor()!=this.getChessColor()){
                a.add(chessboard[row][i].getSource());
                break;
            }
            else{
                break;
            }
        }}
           for(int i=0;i<8;i++){
               for(int j=0;j<8;j++){
                   for(int m=0;m<a.size();m++){
                       if(a.get(m).getX()==i&&a.get(m).getY()==j){
                           b.add(a.get(m));
                       }
                   }
               }
           }

        return  b;
    }
    @Override
    public String toString() {
        if(super.getChessColor()==ChessColor.WHITE){
            return "r";
        }
        else{
            return"R";
        }
    }


}
