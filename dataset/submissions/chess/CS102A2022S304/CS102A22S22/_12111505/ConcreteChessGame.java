import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j]=chessComponents[i][j];
                this.chessComponents[i][j].setGame(this);
            }

        }
        this.currentPlayer=ChessColor.WHITE;
    }
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer) {
        this(chessComponents);
        this.currentPlayer=currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j)=='R'){
                    RookChessComponent rookChessComponent=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=rookChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    KnightChessComponent knightChessComponent=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=knightChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    BishopChessComponent bishopChessComponent=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=bishopChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    QueenChessComponent queenChessComponent=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=queenChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    KingChessComponent kingChessComponent=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=kingChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    PawnChessComponent pawnChessComponent=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j]=pawnChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    RookChessComponent rookChessComponent=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=rookChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    KnightChessComponent knightChessComponent=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=knightChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    BishopChessComponent bishopChessComponent=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=bishopChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    QueenChessComponent queenChessComponent=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=queenChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    KingChessComponent kingChessComponent=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=kingChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    PawnChessComponent pawnChessComponent=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j]=pawnChessComponent;
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    EmptySlotComponent emptySlotComponent=new EmptySlotComponent(new ChessboardPoint(i,j));
                    chessComponents[i][j]=emptySlotComponent;
                }
                chessComponents[i][j].setGame(this);
            }
            if(chessboard.get(8).charAt(0)=='w'){
                currentPlayer=ChessColor.WHITE;
            }else {
                currentPlayer=ChessColor.BLACK;
            }

        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        StringBuilder s=new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a=1;
                if(chessComponents[i][j]instanceof BishopChessComponent){
                    a='B';
                }
                if(chessComponents[i][j]instanceof KnightChessComponent){
                    a='N';
                }
                if(chessComponents[i][j]instanceof RookChessComponent){
                    a='R';
                }
                if(chessComponents[i][j]instanceof KingChessComponent){
                    a='K';
                }
                if(chessComponents[i][j]instanceof PawnChessComponent){
                    a='P';
                }
                if(chessComponents[i][j]instanceof QueenChessComponent){
                    a='Q';
                }
                if(chessComponents[i][j]instanceof EmptySlotComponent){
                    a='_';
                }
                if(chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                    a= (char) (a+32);
                }
                s.append(a);
            }s.append("\n");

        }return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder s=new StringBuilder();
        int numk=1;int numq=1;int numr=2;int numb=2;int numn=2;int nump=8;
        if(player==ChessColor.WHITE){
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if(getChessboardGraph().charAt(i)=='k'){
                    numk-=1;
                }
                if(getChessboardGraph().charAt(i)=='q'){
                    numq-=1;
                }
                if(getChessboardGraph().charAt(i)=='r'){
                    numr-=1;
                }
                if(getChessboardGraph().charAt(i)=='b'){
                    numb-=1;
                }
                if(getChessboardGraph().charAt(i)=='n'){
                    numn-=1;
                }
                if(getChessboardGraph().charAt(i)=='p'){
                    nump-=1;
                }}
                if(numk!=0){
                    s.append("k"+" "+"1"+"\n");
                }
                if(numq!=0){
                    s.append("q"+" "+"1"+"\n");
                }
                if(numr!=0){
                    s.append("r"+" "+(numr)+"\n");
                }
                if(numb!=0){
                    s.append("b"+" "+(numb)+"\n");
                }
                if(numn!=0){
                    s.append("n"+" "+(numn)+"\n");
                }
                if(nump!=0){
                    s.append("p"+" "+(nump)+"\n");
                }
            }

        if(player==ChessColor.BLACK){
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if(getChessboardGraph().charAt(i)=='K'){
                    numk-=1;
                }
                if(getChessboardGraph().charAt(i)=='Q'){
                    numq-=1;
                }
                if(getChessboardGraph().charAt(i)=='R'){
                    numr-=1;
                }
                if(getChessboardGraph().charAt(i)=='B'){
                    numb-=1;
                }
                if(getChessboardGraph().charAt(i)=='N'){
                    numn-=1;
                }
                if(getChessboardGraph().charAt(i)=='P'){
                    nump-=1;
                }
            }


                if(numk!=0){
                    s.append("K"+" "+"1"+"\n");
                }
                if(numq!=0){
                    s.append("Q"+" "+"1"+"\n");
                }
                if(numr!=0){
                    s.append("R"+" "+numr+"\n");
                }
                if(numb!=0){
                    s.append("B"+" "+(numb)+"\n");
                }
                if(numn!=0){
                    s.append("N"+" "+(numn)+"\n");
                }
                if(nump!=0){
                    s.append("P"+" "+(nump)+"\n");
                }
            }
        return s.toString();

        }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        ArrayList<ChessboardPoint> f = (ArrayList<ChessboardPoint>) chess.canMoveTo();
        Comparator<ChessboardPoint> X = new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX()-o2.getX();
            }
        };
        Comparator<ChessboardPoint> Y = new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getY()-o2.getY();
            }
        };
        f.sort(X.thenComparing(Y));
        return f;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint targetPoint = new ChessboardPoint(targetX,targetY);
        ChessboardPoint sourcePoint = new ChessboardPoint(sourceX,sourceY);
        boolean flag1 = getCurrentPlayer().equals(this.getChess(sourceX,sourceY).getChessColor());
        boolean flag2 = false;
        for (ChessboardPoint p : this.getCanMovePoints(sourcePoint)) {
            if (p.getX() == targetX && p.getY() == targetY) {
                flag2=true;
            }
        }
        if (flag2 && flag1){
            this.chessComponents[targetX][targetY] = this.getChess(sourceX,sourceY);
            this.chessComponents[targetX][targetY].setSource(targetPoint);
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourcePoint);
            switchPlayer();
            return true;
        }
        else {
            return false;
        }
    }

    public void switchPlayer() {
        if (this.currentPlayer.equals(ChessColor.WHITE)) {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }
}
