import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    
    //should design
    private ChessboardPoint source;  
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessboard;

    public void loadChessboard(ChessComponent[][] chessComponents){
        this.chessboard = chessComponents;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public int getSource_x(){
        return source.getX();
    }

    public int getSource_y(){
        return source.getY();
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public boolean isEmpty(ChessboardPoint point){
        if (point.getX()<8 & point.getX()>=0 & point.getY()<8 & point.getY()>=0){
            if (chessboard[point.getX()][point.getY()].getChessColor()!=this.getChessColor())
            return true;
        }
        return false;
    }

     public boolean isAnotherColor(ChessboardPoint point){
        if (point.getX()<8 & point.getX()>=0 & point.getY()<8 & point.getY()>=0){
            if (chessboard[point.getX()][point.getY()].getChessColor() != this.getChessColor() & chessboard[point.getX()][point.getY()].getChessColor() != ChessColor.NONE)
                return true;
        }
        return false;
    }
    
    public List<ChessboardPoint> goN(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_y()+i < 8; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x(),this.getSource_y()+i))){
                can.add(new ChessboardPoint(this.getSource_x(),this.getSource_y()+i));
                if (chessboard[this.getSource_x()][this.getSource_y()+i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goS(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_y()-i >= 0; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x(),this.getSource_y()-i))){
                can.add(new ChessboardPoint(this.getSource_x(),this.getSource_y()-i));
                if (chessboard[this.getSource_x()][this.getSource_y()-i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goW(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()-i >= 0; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()))){
                can.add(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()));
                if (chessboard[this.getSource_x()-i][this.getSource_y()].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goE(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()+i < 8; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()))){
                can.add(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()));
                if (chessboard[this.getSource_x()+i][this.getSource_y()].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goNW(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()-i >= 0 & this.getSource_y()-i >= 0; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()-i))){
                can.add(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()-i));
                if (chessboard[this.getSource_x()-i][this.getSource_y()-i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goNE(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()+i < 8 & this.getSource_y()-i >= 0; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()-i))){
                can.add(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()-i));
                if (chessboard[this.getSource_x()+i][this.getSource_y()+i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goSW(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()-i >= 0 & this.getSource_y()+i < 8; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()+i))){
                can.add(new ChessboardPoint(this.getSource_x()-i,this.getSource_y()+i));
                if (chessboard[this.getSource_x()-i][this.getSource_y()+i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }

    public List<ChessboardPoint> goSE(){
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 1; this.getSource_x()+i < 8 & this.getSource_y()+i < 8; i++) {
            if (this.isEmpty(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()+i))){
                can.add(new ChessboardPoint(this.getSource_x()+i,this.getSource_y()+i));
                if (chessboard[this.getSource_x()+i][this.getSource_y()+i].getChessColor() != ChessColor.NONE) break;
            }
            else break;
        }
        return can;
    }
}
