import java.util.ArrayList;
import java.util.List;

class PawnChessComponent extends ChessComponent {
    ArrayList<ChessboardPoint>ff=new ArrayList();
    private int time=0;

    public void setTime() {
        time++;
    }

    public PawnChessComponent(char name, ChessColor chessColor, ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return ff;
    }
    public List<ChessboardPoint> CanMoveTo() {
        ArrayList<ChessboardPoint> f=new ArrayList<>();
        if(getChessColor()==ChessColor.WHITE){
            if(time ==0){
                f.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                f.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));

            }else f.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
        }else {
            if(time ==0){
                f.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                f.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));

            }else f.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));

        }


    return f;
    }
    public List<ChessboardPoint>realMove(){
        List<ChessboardPoint> s=CanMoveTo();
        if(s.size()==0){
            return new ArrayList<>();
        }
        List<ChessboardPoint> f=new ArrayList<>();
            if(board[s.get(0).getX()][s.get(0).getY()].getChessColor()!=board[source.getX()][source.getY()].getChessColor()){
                f.add(new ChessboardPoint(s.get(0).getX(),s.get(0).getY()));}
        if(s.size()==2){
            if(board[s.get(1).getX()][s.get(1).getY()].getChessColor()!=board[source.getX()][source.getY()].getChessColor()&&board[s.get(1).getX()-1][s.get(1).getY()].getChessColor()==ChessColor.NONE){
                f.add(new ChessboardPoint(s.get(1).getX(),s.get(1).getY()));}

        }
        if(source.getY()-1>-1&&board[s.get(1).getX()][s.get(1).getY()-1].getChessColor()!=board[source.getX()][source.getY()].getChessColor()){
            f.add(new ChessboardPoint(s.get(0).getX(),s.get(0).getY()-1));
        }
        if(source.getY()-1>-1&&board[s.get(1).getX()][s.get(1).getY()+1].getChessColor()!=board[source.getX()][source.getY()].getChessColor()){
            f.add(new ChessboardPoint(s.get(0).getX(),s.get(0).getY()+1));
        }
        ArrayList<ChessboardPoint>f3=new ArrayList();

        int[][] newBoard= new int[8][8];
        for(int i=0;i<f.size();i++){
            newBoard[f.get(i).getX()][f.get(i).getY()]=1;
        }
        for(int j=0;j<8;j++){
            for(int k=0;k<8;k++){
                if(newBoard[j][k]==1){
                    f3.add(new ChessboardPoint(j,k));
                }
            }
        }
        ff=f3;
        return f3;





    }
    private ChessComponent[][] board=new ChessComponent[8][8];
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.board = chessComponents;
    }
    private ChessboardPoint source=getSource();




}
