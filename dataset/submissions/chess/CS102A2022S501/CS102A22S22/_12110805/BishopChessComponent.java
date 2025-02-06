import java.util.ArrayList;
import java.util.List;

class BishopChessComponent extends ChessComponent {
    ArrayList<ChessboardPoint>ff=new ArrayList();

    public BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }


    public List<ChessboardPoint> CanMoveTo() {
        ArrayList<ChessboardPoint> f=new ArrayList<>();
        int a,b,c,d;
        for(int i=1;i<8;i++){
            a= getSource().getX()-i;
            b=getSource().getX()+i;
            c=getSource().getY()-i;
            d=getSource().getY()+i;
            if(a>=0&&c>=0){
                f.add(new ChessboardPoint(a,c));
            }
            if(b<8&&c>=0){
                f.add(new ChessboardPoint(b,c));
            }
            if(a>=0&&d<8){
                f.add(new ChessboardPoint(a,d));
            }
            if(b<8&&d<8){
                f.add(new ChessboardPoint(b,d));
            }
        }
return f;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return ff;
    }
    public boolean whether(ChessboardPoint target){
        if(board[target.getX()][target.getY()].getChessColor()==board[source.getX()][source.getY()].getChessColor()){
            return false;
        }else{
            int minus=Math.max(source.getX(),target.getX())-Math.min(source.getX(),target.getX());
            int minusX=target.getX()-source.getX();
            int dx=minusX/minus;
            int minusY=target.getY()-source.getY();
            int dy=minusY/minus;
            for(int i=1;i<minus;i++){
                if(board[source.getX()+dx*i][source.getY()+dy*i].getChessColor()!=ChessColor.NONE){
                    return false;
                }

            }
            return true;
        }

    }
    public List<ChessboardPoint>realMove(){
        List<ChessboardPoint> originalList=CanMoveTo();
        ArrayList<ChessboardPoint> RealList=new ArrayList();

        for(int i=0;i<originalList.size();i++){
            if(whether(originalList.get(i))){
                RealList.add(originalList.get(i));
            }
        }
        ArrayList<ChessboardPoint>f=new ArrayList();
        int minY=10;
        int minX=10;
        int[][] newBoard= new int[8][8];
        for(int i=0;i<RealList.size();i++){
            newBoard[RealList.get(i).getX()][RealList.get(i).getY()]=1;
        }
        for(int j=0;j<8;j++){
            for(int k=0;k<8;k++){
                if(newBoard[j][k]==1){
                    f.add(new ChessboardPoint(j,k));
                }
            }
        }
        ff=f;
        return f;

    }
    private ChessComponent[][] board=new ChessComponent[8][8];
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.board = chessComponents;
    }
    private ChessboardPoint source=getSource();

}
