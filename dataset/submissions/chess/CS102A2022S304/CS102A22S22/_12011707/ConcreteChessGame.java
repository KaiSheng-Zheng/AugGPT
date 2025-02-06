import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents =new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j]= new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j]= new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setChessBoard(chessComponents);
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sc=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sc.append(chessComponents[i][j].getName());
            }
            if(i!=7){
                sc.append("\n");
            }
        }
        return sc.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K=1;
        int k=1;
        int Q=1;
        int q=1;
        int R=2;
        int r=2;
        int N=2;
        int n=2;
        int B=2;
        int b=2;
        int P=8;
        int p=8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getName() == 'K'){
                    K-=1;
                }if(chessComponents[i][j].getName() == 'Q'){
                    Q-=1;
                }if(chessComponents[i][j].getName() == 'R'){
                    R-=1;
                }if(chessComponents[i][j].getName() == 'N'){
                    N-=1;
                }if(chessComponents[i][j].getName() == 'B'){
                    B-=1;
                }if(chessComponents[i][j].getName() == 'P'){
                    P-=1;
                }if(chessComponents[i][j].getName() == 'k'){
                    k-=1;
                }if(chessComponents[i][j].getName() == 'q'){
                    q-=1;
                }if(chessComponents[i][j].getName() == 'r'){
                    r-=1;
                }if(chessComponents[i][j].getName() == 'n'){
                    n-=1;
                }if(chessComponents[i][j].getName() == 'b'){
                    b-=1;
                }if(chessComponents[i][j].getName() == 'p'){
                    p-=1;
                }
            }
        }
        StringBuilder sc=new StringBuilder();
        if(player==ChessColor.WHITE){
            if(k>0){
                sc.append("k ");
                sc.append(k);
                sc.append("\n");
            }if(q>0){
                sc.append("q ");
                sc.append(q);
                sc.append("\n");
            }if(r>0){
                sc.append("r ");
                sc.append(r);
                sc.append("\n");
            }if(b>0){
                sc.append("b ");
                sc.append(b);
                sc.append("\n");
            }if(n>0){
                sc.append("n ");
                sc.append(n);
                sc.append("\n");
            }if(p>0){
                sc.append("p ");
                sc.append(p);
                sc.append("\n");
            }
        }else {
            if(K>0){
                sc.append("K ");
                sc.append(K);
                sc.append("\n");
            }if(Q>0){
                sc.append("Q ");
                sc.append(Q);
                sc.append("\n");
            }if(R>0){
                sc.append("R ");
                sc.append(R);
                sc.append("\n");
            }if(B>0){
                sc.append("B ");
                sc.append(B);
                sc.append("\n");
            }if(N>0){
                sc.append("N ");
                sc.append(N);
                sc.append("\n");
            }if(P>0){
                sc.append("P ");
                sc.append(P);
                sc.append("\n");
            }
        }
        return sc.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(), source.getY());
        List<ChessboardPoint> sc = chess.canMoveTo();
        for (int i = 0; i < sc.size()-1; i++) {
            for (int j = 0; j < sc.size()-i-1; j++) {
                if(sc.get(j).getX()>sc.get(j+1).getX()){
                    ChessboardPoint t=sc.get(j);
                    sc.set(j,sc.get(j+1));
                    sc.set(j+1,t);
                }else if(sc.get(j).getX()==sc.get(j+1).getX()){
                    if(sc.get(j).getY()>sc.get(j+1).getY()){
                        ChessboardPoint s=sc.get(j);
                        sc.set(j,sc.get(j+1));
                        sc.set(j+1,s);
                    }
                }
            }
        }
        return sc;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        boolean a=false;
        boolean b= this.currentPlayer == chessComponents[sourceX][sourceY].getChessColor();
        for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if(chessComponents[sourceX][sourceY].canMoveTo().get(i).equals(target)){
                a=true;
            }
        }
        if(a&b){
            if(chessComponents[sourceX][sourceY] instanceof KingChessComponent){
                chessComponents[targetX][targetY]=new KingChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }else if(chessComponents[sourceX][sourceY] instanceof QueenChessComponent){
                chessComponents[targetX][targetY]=new QueenChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }else if(chessComponents[sourceX][sourceY] instanceof KnightChessComponent){
                chessComponents[targetX][targetY]=new KnightChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }else if(chessComponents[sourceX][sourceY] instanceof RookChessComponent){
                chessComponents[targetX][targetY]=new RookChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }else if(chessComponents[sourceX][sourceY] instanceof BishopChessComponent){
                chessComponents[targetX][targetY]=new BishopChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }else if(chessComponents[sourceX][sourceY] instanceof PawnChessComponent){
                chessComponents[targetX][targetY]=new PawnChessComponent();
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
            }
            chessComponents[sourceX][sourceY]=new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            chessComponents[sourceX][sourceY].setName('_');
            if (this.currentPlayer==ChessColor.WHITE){
                this.currentPlayer=ChessColor.BLACK;
            }else{
                this.currentPlayer=ChessColor.WHITE;
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessBoard(chessComponents);
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
