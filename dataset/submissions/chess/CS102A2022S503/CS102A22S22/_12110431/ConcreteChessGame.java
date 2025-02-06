import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")){currentPlayer=ChessColor.WHITE;}else {currentPlayer=ChessColor.BLACK;}
        for (int x=0;x<8;x++){
            String line=chessboard.get(x);
            for (int y=0;y<8;y++){
                switch (line.charAt(y)){
                    case 'K':chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'K',chessComponents);break;
                    case 'k':chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'k',chessComponents);break;
                    case 'Q':chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'Q',chessComponents);break;
                    case 'q':chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'q',chessComponents);break;
                    case 'R':chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'R',chessComponents);break;
                    case 'r':chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'r',chessComponents);break;
                    case 'N':chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'N',chessComponents);break;
                    case 'n':chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'n',chessComponents);break;
                    case 'P':chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'P',chessComponents);break;
                    case 'p':chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'p',chessComponents);break;
                    case 'B':chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'B',chessComponents);break;
                    case 'b':chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'b',chessComponents);break;
                    default:chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y),ChessColor.NONE,'_',chessComponents);break;
                }
            }
        }
        System.out.println(getChessboardGraph());
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder Graph=new StringBuilder();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                Graph.append(chessComponents[x][y].name);
            }Graph.append("\n");
        }
        return Graph.toString();
    }

    public String getCapturedChess(ChessColor player){
        int K=1;
        int k=1;
        int Q=1;
        int q=1;
        int R=2;
        int r=2;
        int B=2;
        int b=2;
        int N=2;
        int n=2;
        int P=8;
        int p=8;

        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                switch (chessComponents[x][y].name){
                    case 'K':K=K-1;break;
                    case 'k':k=k-1;break;
                    case 'Q':Q=Q-1;break;
                    case 'q':q=q-1;break;
                    case 'R':R=R-1;break;
                    case 'r':r=r-1;break;
                    case 'B':B=B-1;break;
                    case 'b':b=b-1;break;
                    case 'N':N=N-1;break;
                    case 'n':n=n-1;break;
                    case 'P':P=P-1;break;
                    case 'p':p=p-1;break;
                }
            }
            }
        StringBuilder lose=new StringBuilder();
        if (player==ChessColor.BLACK){
            if (K!=0){lose.append("K ").append(K).append("\n");}
            if (Q!=0){lose.append("Q ").append(Q).append("\n");}
            if (R!=0){lose.append("R ").append(R).append("\n");}
            if (B!=0){lose.append("B ").append(B).append("\n");}
            if (N!=0){lose.append("N ").append(N).append("\n");}
            if (P!=0){lose.append("P ").append(P).append("\n");}
        }else {
            if (k!=0){lose.append("k ").append(k).append("\n");}
            if (q!=0){lose.append("q ").append(q).append("\n");}
            if (r!=0){lose.append("r ").append(r).append("\n");}
            if (b!=0){lose.append("b ").append(b).append("\n");}
            if (n!=0){lose.append("n ").append(n).append("\n");}
            if (p!=0){lose.append("p ").append(p).append("\n");}
        }
        return lose.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(),source.getY());
        List<ChessboardPoint> target=chess.canMoveTo();
        for (ChessboardPoint i: target){System.out.println(i);}

        List<ChessboardPoint> Target=new ArrayList<>();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                for(int i = 0; i < target.size(); i++){
                    ChessboardPoint j = target.get(i);
                    if (j.getY()==y&&j.getX()==x){
                        Target.add(new ChessboardPoint(x,y));
                    }
                }
            }
        }
        return Target;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> target = getChess(sourceX, sourceY).canMoveTo();
        if (getChess(sourceX,sourceY).getChessColor()!=currentPlayer){return false;}
        for (int i = 0; i < target.size(); i++) {
            ChessboardPoint j = target.get(i);
            boolean b = j.getX() == targetX && j.getY() == targetY;
            if (b) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
                break;
            }
        }
        if (chessComponents[sourceX][sourceY].name=='_') {
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
        }
        return chessComponents[sourceX][sourceY].name=='_';
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("_N_QK_NR");
        strings.add("P__P___P");
        strings.add("_______B");
        strings.add("______P_");
        strings.add("________");
        strings.add("_______p");
        strings.add("pp_pppp_");
        strings.add("r_b_k___");
        strings.add("w");

        ConcreteChessGame chessGame=new ConcreteChessGame();
        chessGame.loadChessGame(strings);


        List<ChessboardPoint> a = chessGame.getCanMovePoints(chessGame.chessComponents[0][1].getSource());
        for (ChessboardPoint i: a){System.out.println(i);}

    }
}
