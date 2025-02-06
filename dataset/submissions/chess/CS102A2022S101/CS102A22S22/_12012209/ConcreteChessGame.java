import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {

    public static ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents= new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                if(chessComponents[i][j]==null){
                    chessComponents[i][j]=new Instance();
                }
                chessComponents[i][j].name=chessboard.get(i).charAt(j);
            }
        }
        if(Objects.equals(chessboard.get(8), "b"))
            currentPlayer=ChessColor.BLACK;
        else if(Objects.equals(chessboard.get(8), "w"))
            currentPlayer=ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder g=new StringBuilder();
        for(int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                g.append(chessComponents[i][j].name);
            }
            g.append("\n");
        }
        return g.toString();
    }

    public String getCapturedChess(ChessColor player){
        int K=0,Q=0,R=0,B=0,N=0,P=0;
        int k=0,q=0,r=0,b=0,n=0,p=0;
        for(int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                switch (chessComponents[i][j].name)
                {
                    case 'K':{K++;break;}
                    case 'Q':{Q++;break;}
                    case 'R':{R++;break;}
                    case 'B':{B++;break;}
                    case 'N':{N++;break;}
                    case 'P':{P++;break;}
                    case 'k':{k++;break;}
                    case 'q':{q++;break;}
                    case 'r':{r++;break;}
                    case 'b':{b++;break;}
                    case 'n':{n++;break;}
                    case 'p':{p++;break;}
                }
            }
        }
        StringBuilder S=new StringBuilder();
        if(player==ChessColor.BLACK)
        {
            if(K==0)
               S.append("K 1\n");
            if(Q==0)
                S.append("Q 1\n");
            if(R!=2)
                S.append("R ").append(2-R).append("\n");
            if(B!=2)
                S.append("B ").append(2-B).append("\n");
            if(N!=2)
                S.append("N ").append(2-N).append("\n");
            if(P!=8)
                S.append("P ").append(8-P);
        }
        else if(player==ChessColor.WHITE)
        {
            if(k==0)
                S.append("k 1\n");
            if(q==0)
                S.append("q 1\n");
            if(r!=2)
                S.append("r ").append(2-r).append("\n");
            if(b!=2)
                S.append("b ").append(2-b).append("\n");
            if(n!=2)
                S.append("n ").append(2-n).append("\n");
            if(p!=8)
                S.append("p ").append(8-p);
        }
        return S.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent=chessComponents[source.getX()][source.getY()];
        return chessComponent.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint src=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint tgt=new ChessboardPoint(targetX,targetY);
        boolean canMove=false;
        for(ChessboardPoint target:getCanMovePoints(src))
        {
            if (tgt.equals(target)) {
                canMove = true;
                break;
            }
        }
        return getCanMovePoints(src) != null && canMove;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
