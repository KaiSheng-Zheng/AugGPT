import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;

   // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents =new  ChessComponent[8][8];
         this.currentPlayer=ChessColor.WHITE;
    }

    /**
       * @param chessboard
     */

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=(new KingChessComponent(ChessColor.BLACK));
                }else if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=(new KingChessComponent(ChessColor.WHITE));
                }else if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=(new QueenChessComponent(ChessColor.BLACK));
                }else if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=(new QueenChessComponent(ChessColor.WHITE));
                }else if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=(new KnightChessComponent(ChessColor.BLACK));
                }else if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=(new KnightChessComponent(ChessColor.WHITE));
                }else if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=(new BishopChessComponent(ChessColor.BLACK));
                }else if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=(new BishopChessComponent(ChessColor.WHITE));
                }else if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=(new RookChessComponent(ChessColor.BLACK));
                }else if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=(new RookChessComponent(ChessColor.WHITE));
                }else if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=(new EmptySlotComponent(ChessColor.NONE));
                }
            }
            if(chessboard.get(8).equals("w")){
                currentPlayer=ChessColor.WHITE;
            }else currentPlayer=ChessColor.BLACK;
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
//        return null;
        if((x>=0&&x<8)&&(y>=0&&y<8)){
            return this.chessComponents[x][y];
        }else return null;
    }

    /**
     * @return
     */
    @Override
    public String getChessboardGraph() {
       StringBuilder chess= new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j = 0; j < 8; j++) {
//
                if (chessComponents[i][j].getName().equals("bking")){
                    chess.append("K");
                }else if (chessComponents[i][j].getName().equals("wking")){
                    chess.append("k");
                }else if (chessComponents[i][j].getName().equals("bqueen")){
                    chess.append("Q");
                }else if (chessComponents[i][j].getName().equals("wqueen")){
                    chess.append("q");
                }else if (chessComponents[i][j].getName().equals("bbishop")){
                    chess.append("B");
                }else if (chessComponents[i][j].getName().equals("wbishop")){
                    chess.append("b");
                }else if (chessComponents[i][j].getName().equals("brook")){
                    chess.append("R");
                }else if (chessComponents[i][j].getName().equals("wrook")){
                    chess.append("r");
                }else if (chessComponents[i][j].getName().equals("bknight")){
                    chess.append("N");
                }else if (chessComponents[i][j].getName().equals("wknight")){
                    chess.append("n");
                }else if (chessComponents[i][j].getName().equals("empty")){
                    chess.append("_");
                }else if (chessComponents[i][j].getName().equals("bpawn")){
                    chess.append("P");
                }else if(chessComponents[i][j].getName().equals("wpawn")){
                    chess.append("p");
                }
            }
            chess.append("\n");
        }
        return chess.substring(0,chess.length()-1);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k=0,q=0,n=0,r=0,b=0,p=0;
        int K=0,Q=0,N=0,R=0,B=0,P=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName().equals("wking")){
                    k++;
                }else if (chessComponents[i][j].getName().equals("wqueen")){
                    q++;
                }else if (chessComponents[i][j].getName().equals("wbishop")){
                    b++;
                }else if (chessComponents[i][j].getName().equals("wrook")){
                    r++;
                }else if (chessComponents[i][j].getName().equals("wpawn")){
                    p++;
                }else if (chessComponents[i][j].getName().equals("wknight")){
                    n++;
                }else if(chessComponents[i][j].getName().equals("bking")){
                    K++;
                }else if (chessComponents[i][j].getName().equals("bqueen")){
                    Q++;
                }else if (chessComponents[i][j].getName().equals("bbishop")){
                    B++;
                }else if (chessComponents[i][j].getName().equals("brook")){
                    R++;
                }else if (chessComponents[i][j].getName().equals("bpawn")){
                    P++;
                }else if (chessComponents[i][j].getName().equals("bknight")){
                    N++;}
            }
        }
        int lk=1-k,lq=1-q,ln=2-n,lb=2-b,lr=2-r,lp=8-p;
        int lK=1-K,lQ=1-Q,lN=2-N,lB=2-B,lR=2-R,lP=8-P;
        String left="";
        int[] wlose= {lk,lq,lr,lb,ln,lp};
        String[] wlosechess={"k","q","r","b","n","p"};
        int[] blose={lK,lQ,lR,lB,lN,lP};
        String[] blosechess={"K","Q","R","B","N","P"};


        if(player.equals(ChessColor.WHITE)){
            for (int i=0;i<wlose.length;i++){
                if(wlose[i]!=0){
                    left+=(wlosechess[i]+" "+wlose[i]+"\n");
                }
            }
//            return String.format("K %s\nQ %s\nR %s\nB %s\nN %s\nP %s",lK,lQ,lR,lB,lN,lP);
        }else if (player.equals(ChessColor.BLACK)){
            for (int i=0;i<blose.length;i++){
                if (blose[i]!=0){
                    left+=(blosechess[i]+" "+blose[i]+"\n");
                }
            }
        }
//        return String.format("k %s\nq %s\nr %s\nb %s\nn %s\n p %s",lk,lq,lr,lb,ln,lp);
        return left;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess =this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
