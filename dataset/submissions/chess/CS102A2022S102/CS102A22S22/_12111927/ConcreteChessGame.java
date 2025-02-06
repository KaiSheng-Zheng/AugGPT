import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame() {
        this.chessComponents=new ChessComponent[8][8];

    }
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='K'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setName('K');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='k'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setName('k');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='Q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setName('Q');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setName('q');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='R'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setName('R');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='r'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setName('r');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='P'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setName('P');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='p'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setName('p');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='N'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setName('N');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='n'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setName('n');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='B'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setName('B');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j)=='b'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setName('b');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j)=='_'){
                    this.chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setName('_');
                    ChessboardPoint s = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(s);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }else{
            this.currentPlayer = ChessColor.BLACK;
        }
    }



    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j]instanceof EmptySlotComponent){
                    a.append('_');
                }else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('B');
                }else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('b');
                }else if (chessComponents[i][j]instanceof KingChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('K');
                }else if (chessComponents[i][j]instanceof KingChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('k');
                }else if (chessComponents[i][j]instanceof KnightChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('N');
                }else if (chessComponents[i][j]instanceof KnightChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('n');
                }else if (chessComponents[i][j]instanceof PawnChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('P');
                }else if (chessComponents[i][j]instanceof PawnChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('p');
                }else if (chessComponents[i][j]instanceof QueenChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('Q');
                }else if (chessComponents[i][j]instanceof QueenChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('q');
                }else if (chessComponents[i][j]instanceof RookChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a.append('R');
                }else if (chessComponents[i][j]instanceof RookChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    a.append('r');
                }
            }
            a.append("\n");
        }


        return String.valueOf(a);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int f=0;
        int g=0;
        int h=0;
        int k=0;
        int l=0;
        int m=0;
        int n=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j]instanceof KingChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    a++;
                }else if (chessComponents[i][j]instanceof KingChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    b++;
                }else if (chessComponents[i][j]instanceof QueenChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    c++;
                }else if (chessComponents[i][j]instanceof QueenChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    d++;
                }else if (chessComponents[i][j]instanceof RookChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    e++;
                }else if (chessComponents[i][j]instanceof RookChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    f++;
                }else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    g++;
                }else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    h++;
                }else if (chessComponents[i][j]instanceof KnightChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    k++;
                }else if (chessComponents[i][j]instanceof KnightChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    l++;
                }else if (chessComponents[i][j]instanceof PawnChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    m++;
                }else if (chessComponents[i][j]instanceof PawnChessComponent &&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    n++;
                }
            }
        }
        StringBuilder hhh= new StringBuilder();
        if (player==ChessColor.BLACK){
            if (1-a==0){
                hhh.append("");
            }else {
                hhh.append("K 1\n");
            }if (1-c==0){
                hhh.append("");
            }else {
                hhh.append("Q 1\n");
            }if (2-e==0){
                hhh.append("");
            }else {
                int z = 2-e;
                hhh.append("R ").append(z).append("\n");
            }if (2-g==0){
                hhh.append("");
            }else {
                int y = 2-g;
                hhh.append("B ").append(y).append("\n");
            }if (2-k==0){
                hhh.append("");
            }else {
                int x = 2-k;
                hhh.append("N ").append(x).append("\n");
            }if (8-m==0){
                hhh.append("");
            }else {
                int v = 8-m;
                hhh.append("P ").append(v).append("\n");
            }
        }
        StringBuilder hh= new StringBuilder();
        if (player==ChessColor.WHITE){
            if (1-b==0){
                hh.append("");
            }else {
                hh.append("k 1\n");
            }if (1-d==0){
                hh.append("");
            }else {
                hh.append("q 1\n");
            }if (2-f==0){
                hh.append("");
            }else {
                int y = 2-f;
                hh.append("r ").append(y).append("\n");
            }if (2-h==0){
                hh.append("");
            }else {
                int y = 2-h;
                hh.append("b ").append(y).append("\n");
            }if (2-l==0){
                hh.append("");
            }else {
                int w = 2-l;
                hh.append("n ").append(w).append("\n");
            }if (8-n==0){
                hh.append("");
            }else {
                int u = 8-n;
                hh.append("p ").append(u).append("\n");
            }
        }
        StringBuilder hhhh;
        if (player==ChessColor.WHITE){
            hhhh = hh;
        }else {
            hhhh = hhh;
        }
        return String.valueOf(hhhh);
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> ChessCamMoveTo = getChess(source.getX(),source.getY()).canMoveTo();
        return Objects.requireNonNullElseGet(ChessCamMoveTo, ArrayList::new);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> ChessCamMoveTo = getChess(sourceX,sourceY).canMoveTo();
        ChessboardPoint point1 = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint point2 = new ChessboardPoint(targetX,targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent();
        chessComponents[sourceX][sourceY].setName('_');
        if (getCanMovePoints(point1).size()==0){
           return false;
        }else {
            ArrayList<ChessboardPoint> points = new ArrayList<>(getCanMovePoints(point1));
            if (point2.equals(point1)){

            }
        }
        if (currentPlayer==ChessColor.WHITE){
            currentPlayer=ChessColor.BLACK;
        }else if (currentPlayer==ChessColor.BLACK){
            currentPlayer=ChessColor.WHITE;
        }
        return false;
    }


}

