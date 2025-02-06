import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    ArrayList<ChessboardPoint>ff=new ArrayList();
    public KingChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return ff;
    }
    public List<ChessboardPoint> CanMoveTo() {

        ArrayList<ChessboardPoint> f=new ArrayList<>();
        int a,b,c,d;
        int i=1;
            a= getSource().getX()-i;
            b=getSource().getX()+i;
            c=getSource().getY()-i;
            d=getSource().getY()+i;
            if(a>=0){
                f.add(new ChessboardPoint(a, getSource().getY()));
            }
            if(b<8){
                f.add(new ChessboardPoint(b, getSource().getY()));
            }
            if(c>=0){
                f.add(new ChessboardPoint(getSource().getX(),c));
            }
            if(d<8){
                f.add(new ChessboardPoint(getSource().getX(),d));
            }
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

        return f;
    }
    public List<ChessboardPoint>realMove(){
        List<ChessboardPoint> s=CanMoveTo();
        ArrayList<ChessboardPoint> f=new ArrayList<>();
        for(int i=0;i<s.size();i++){
            if(board[s.get(i).getX()][s.get(i).getY()].getChessColor()!=board[source.getX()][source.getY()].getChessColor()){
                f.add(new ChessboardPoint(s.get(i).getX(),s.get(i).getY()));
            }
        }
        ArrayList<ChessboardPoint>f3=new ArrayList();
        int minY=10;
        int minX=10;
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
