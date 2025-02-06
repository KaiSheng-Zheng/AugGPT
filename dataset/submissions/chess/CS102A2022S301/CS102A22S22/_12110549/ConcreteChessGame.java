import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    protected ChessComponent[][] chessboard;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='P'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new PawnChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new PawnChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new QueenChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new QueenChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new KingChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new KingChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new KnightChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new KnightChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new RookChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new RookChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new BishopChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new BishopChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    ChessboardPoint source =new ChessboardPoint(i,j);
                    chessComponents[i][j]=new EmptySlotComponent(source,ChessColor.NONE,chessboard.get(i).charAt(j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setChessComponents(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public String getChessboardGraph() {
        StringBuilder string =new StringBuilder();
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                string.append(chessComponents[i][j].toString());
            }
            if (i != 7) {
                string.append('\n');
            }
        }
        return string.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int B=0;
        int Q=0;
        int K=0;
        int P=0;
        int R=0;
        int N=0;
        StringBuilder value=new StringBuilder();
        if (player==ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().charAt(0)=='P'){
                        P++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='B'){
                        B++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='Q'){
                        Q++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='K'){
                        K++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='R'){
                        R++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='N'){
                        N++;
                    }
                }
            }
            if (K!=1){
                value.append("K 1\n");
            }
            if (Q!=1){
                value.append("Q 1\n");
            }
            if (2-R!=0){
                value.append("R ").append(2-R).append("\n");
            }
            if (2-B!=0){
                value.append("B ").append(2-B).append("\n");
            }
            if (2-N!=0){
                value.append("N ").append(2-N).append("\n");
            }
            if (8-P!=0){
                value.append("P ").append(8-P).append("\n");
            }
        }else if (player==ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().charAt(0)=='p'){
                        P++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='b'){
                        B++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='q'){
                        Q++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='k'){
                        K++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='r'){
                        R++;
                    }
                    if (chessComponents[i][j].toString().charAt(0)=='n'){
                        N++;
                    }
                }
            }
            if (K!=1){
                value.append("k 1\n");
            }
            if (Q!=1){
                value.append("q 1\n");
            }
            if (2-R!=0){
                value.append("r ").append(2-R).append("\n");
            }
            if (2-B!=0){
                value.append("b ").append(2-B).append("\n");
            }
            if (2-N!=0){
                value.append("n ").append(2-N).append("\n");
            }
            if (8-P!=0){
                value.append("p ").append(8-P).append("\n");
            }
        }
        return value.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        canMovePoints.sort(new Sort());
        return canMovePoints;
    }
    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            if (p1.getX()!=p2.getX()){
                return p1.getX()-p2.getX();
            }else
                return p1.getY()-p2.getY();
        }
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=this.getChess(sourceX,sourceY);
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chess.canMoveTo();
        boolean moveChess=true;
        if(currentPlayer!=chess.getChessColor()){
            moveChess= false;
        }
        if(!moveTo.contains(new ChessboardPoint(targetX, targetY))){
            moveChess= false;
        }
        if (moveChess){
            chessComponents[targetX][targetY]=chess;
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='P'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new PawnChessComponent(source,ChessColor.BLACK,'P');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='p'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new PawnChessComponent(source,ChessColor.WHITE,'p');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='Q'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new QueenChessComponent(source,ChessColor.BLACK,'Q');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='q'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new QueenChessComponent(source,ChessColor.WHITE,'q');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='K'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KingChessComponent(source,ChessColor.BLACK,'K');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='k'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KingChessComponent(source,ChessColor.WHITE,'k');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='N'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KnightChessComponent(source,ChessColor.BLACK,'N');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='n'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KnightChessComponent(source,ChessColor.WHITE,'n');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='R'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new RookChessComponent(source,ChessColor.BLACK,'R');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='r'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new RookChessComponent(source,ChessColor.WHITE,'r');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='B'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new BishopChessComponent(source,ChessColor.BLACK,'B');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='b'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new BishopChessComponent(source,ChessColor.WHITE,'b');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessComponents[i][j].name=='_'){
                        ChessboardPoint source =new ChessboardPoint(i,j);
                        chessComponents[i][j]=new EmptySlotComponent(source,ChessColor.NONE,'_');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                }
            }
            return true;
        }else {
        return false;}
    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

}