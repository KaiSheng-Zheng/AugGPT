import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(getChessColor()==ChessColor.WHITE){
            this.name='q';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='Q';
        }
    }

    public QueenChessComponent(ChessboardPoint source) {
        super(source);
        if(getChessColor()==ChessColor.WHITE){
            this.name='q';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='Q';
        }
    }

    public QueenChessComponent() {
        if(getChessColor()==ChessColor.WHITE){
            this.name='q';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='Q';
        }
    }

    public QueenChessComponent(ChessComponent[][] chessboard) {
        super(chessboard);
        if(getChessColor()==ChessColor.WHITE){
            this.name='q';
        }
        if(getChessColor()==ChessColor.BLACK){
            this.name='Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        ArrayList<ChessboardPoint> b=new ArrayList<>();
        a: for(int i=0;i<8;i++){
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
        return b;
        }

    @Override
    public String toString() {
        if(super.getChessColor()==ChessColor.WHITE){
            return "q";
        }
        else{
            return"Q";
        }
    }
}
