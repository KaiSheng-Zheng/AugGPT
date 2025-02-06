import java.util.ArrayList;
import java.util.List;

class KnightChessComponent extends ChessComponent {
    ArrayList<ChessboardPoint>ff=new ArrayList();
    public KnightChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return ff;
    }
    public List<ChessboardPoint> CanMoveTo() {
        ArrayList<ChessboardPoint> f=new ArrayList<>();
        int U,u,D,d,l,L,R,r;
        U=getSource().getY()-2;
        u=getSource().getY()-1;
        D=getSource().getY()+2;
        d=getSource().getY()+1;
        R=getSource().getX()+2;
        r=getSource().getX()+1;
        L=getSource().getX()-2;
        l=getSource().getX()-1;
        if(U>=0){
            if(r<8){
                f.add(new ChessboardPoint(r,U));
            }
            if(l>=0){
                f.add(new ChessboardPoint(l,U));
            }

        }
        if(u>=0){
            if(R<8){
                f.add(new ChessboardPoint(R,u));
            }
            if(L>=0){
                f.add(new ChessboardPoint(L,u));
            }

        }
        if(D<8){
            if(r<8){
                f.add(new ChessboardPoint(r,D));
            }
            if(l>=0){
                f.add(new ChessboardPoint(l,D));
            }

        }
        if(u<8){
            if(R<8){
                f.add(new ChessboardPoint(R,d));
            }
            if(L>=0){
                f.add(new ChessboardPoint(L,d));
            }

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