import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private  ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size()-1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char s=chessboard.get(i).charAt(j);
                if(s=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                } else if (s=='Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                }else if (s=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                }else if (s=='N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                }else if (s=='B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                }else if (s=='P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, s);
                }else if (s=='r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, s);
                }else if (s=='n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, s);
                }else if (s=='p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, s);
                }else if (s=='b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,s);
                }else if (s=='q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, s);
                }else if (s=='k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, s);
                }else if (s=='_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE, s);
                }
                }
            }
        if (chessboard.get(8).charAt(0)=='w') {
            currentPlayer = ChessColor.WHITE;
        } else{
            currentPlayer = ChessColor.BLACK;
        }
    }
    public ConcreteChessGame(){
        this.chessComponents=ChessComponent.chessComponents;
        this.currentPlayer=getCurrentPlayer();
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph() {
        StringBuilder s=new StringBuilder();
        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].getName());
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];

    }

    public String getCapturedChess(ChessColor player) {
        if(player==ChessColor.BLACK){
        int K=1;
        int Q=1;
        int R=2;
        int B=2;
        int N=2;
        int P=8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j] instanceof KingChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    K--;
                }
                else if(chessComponents[i][j]instanceof QueenChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    Q--;
                }
                else if(chessComponents[i][j]instanceof RookChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    R--;
                }
                else if(chessComponents[i][j]instanceof BishopChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    B--;
                }
                else if(chessComponents[i][j]instanceof KnightChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    N--;
                }
                else if(chessComponents[i][j]instanceof PawnChessComponent&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    P--;
                }
            }
        }
            StringBuilder a=new StringBuilder();
        if(K!=0){
            String b=String.format("K %d"+"\n",K);
            a.append(b);
        }
            if(Q!=0){
                String b=String.format("Q %d"+"\n",Q);
                a.append(b);
            }
            if(R!=0){
                String b=String.format("R %d"+"\n",R);
                a.append(b);
            }
            if(B!=0){
                String b=String.format("B %d"+"\n",B);
                a.append(b);
            }
            if(N!=0){
                String b=String.format("N %d"+"\n",N);
                a.append(b);
            }
            if(P!=0){
                String b=String.format("P %d"+"\n",P);
                a.append(b);
            }
        return a.toString();
    }else {
            int k=1;
            int q=1;
            int r=2;
            int b=2;
            int n=2;
            int p=8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        k--;
                    }
                    if (chessComponents[i][j]instanceof QueenChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        q--;
                    }
                    if (chessComponents[i][j]instanceof RookChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        r--;
                    }
                    if (chessComponents[i][j]instanceof BishopChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        b--;
                    }
                    if (chessComponents[i][j]instanceof KnightChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        n--;
                    }
                    if (chessComponents[i][j]instanceof PawnChessComponent&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        p--;
                    }
                }
            }
                StringBuilder a=new StringBuilder();
                if(k!=0){
                    String c=String.format("k %d"+"\n",k);
                    a.append(c);
                }
                if(q!=0){
                    String c=String.format("q %d"+"\n",q);
                    a.append(c);
                }
                if(r!=0){
                    String c=String.format("r %d"+"\n",r);
                    a.append(c);
                }
                if(b!=0){
                    String c=String.format("b %d"+"\n",b);
                    a.append(c);
                }
                if(n!=0){
                    String c=String.format("n %d"+"\n",n);
                    a.append(c);
                }
                if(p!=0){
                    String c=String.format("p %d"+"\n",p);
                    a.append(c);
                }
                return a.toString();
            }

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chessboardPoint = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint point = new ChessboardPoint(targetX, targetY);
        if (getCurrentPlayer() == chessComponents[sourceX][sourceY].getChessColor()) {
            for (int i = 0; i < getCanMovePoints(chessboardPoint).size(); i++) {
                if (targetX == getCanMovePoints(chessboardPoint).get(i).getX() && targetY == getCanMovePoints(chessboardPoint).get(i).getY()) {
                    ChessComponent chessComponent = getChess(sourceX, sourceY);
                    chessComponent.setSource(point);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    chessComponents[targetX][targetY] = chessComponent;
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(),source.getY()).canMoveTo();
    }


}


