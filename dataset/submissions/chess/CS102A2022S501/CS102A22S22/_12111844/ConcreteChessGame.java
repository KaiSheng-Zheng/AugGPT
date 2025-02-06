import java.util.List;
import java.util.*;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    //Initialize
    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard){
        ChessComponent[][] chessComponent = new ChessComponent[8][8];
        if(Objects.equals(chessboard.get(8),"w")){
            currentPlayer = ChessColor.WHITE;
        }else if (Objects.equals(chessboard.get(8),"b")){
            currentPlayer = ChessColor.BLACK;
        }
        for(int i=0; i<8; i++){
            for(int j=0; j<8 ; j++){
                char name = chessboard.get(i).charAt(j);
                if(Objects.equals(name,'R')){
                    chessComponent[i][j] = new RookChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'N')) {
                    chessComponent[i][j] = new KnightChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'B')) {
                    chessComponent[i][j] = new BishopChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'Q')) {
                    chessComponent[i][j] = new QueenChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'K')) {
                    chessComponent[i][j] = new KingChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'P')) {
                    chessComponent[i][j] = new PawnChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.BLACK);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'r')) {
                    chessComponent[i][j] = new RookChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'n')) {
                    chessComponent[i][j] = new KnightChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'b')) {
                    chessComponent[i][j] = new BishopChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'q')) {
                    chessComponent[i][j] = new QueenChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if ( Objects.equals(name,'k')) {
                    chessComponent[i][j] = new KingChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if ( Objects.equals(name,'p')) {
                    chessComponent[i][j] = new PawnChessComponent();
                    chessComponent[i][j].setChessColor(ChessColor.WHITE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                } else if (Objects.equals(name,'_')){
                    chessComponent[i][j] = new EmptySlotComponent();
                    chessComponent[i][j].setChessColor(ChessColor.NONE);
                    chessComponent[i][j].setName(name);
                    chessComponent[i][j].setSource(new ChessboardPoint(i,j));
                }
            }
        }
        this.chessComponents = chessComponent;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder board = new StringBuilder();
        for(int i=0; i<7; i++){
            StringBuilder eachLine = new StringBuilder();
            for(int j=0; j<=7; j++){
                eachLine.append((chessComponents[i][j]).name);
            }
            board.append(eachLine).append("\n");
        }
        for(int j=0; j<=7; j++){
            board.append((chessComponents[7][j]).name);
        }
        return board.toString();
    }
//    public String getCapturedChess(ChessColor player){
//        int r=0; int n=0; int b=0; int q=0; int k=0; int p=0;
//        int R=0; int N=0; int B=0; int Q=0; int K=0; int P=0;
//        StringBuilder string = new StringBuilder();
//        for(int i=0; i<=7; i++){
//            for(int j=0; j<=7; j++){
//                if(player == ChessColor.WHITE){
//                    if(chessComponents[i][j].getName()=='r')
//                        r++;
//                    if(chessComponents[i][j].getName()=='n')
//                        n++;
//                    if(chessComponents[i][j].getName()=='b')
//                        b++;
//                    if(chessComponents[i][j].getName()=='q')
//                        q++;
//                    if(chessComponents[i][j].getName()=='k')
//                        k++;
//                    if(chessComponents[i][j].getName()=='p')
//                        p++;
//                }
//                if(player == ChessColor.BLACK){
//                    if(chessComponents[i][j].getName()=='R')
//                        R++;
//                    if(chessComponents[i][j].getName()=='N')
//                        N++;
//                    if(chessComponents[i][j].getName()=='B')
//                        B++;
//                    if(chessComponents[i][j].getName()=='Q')
//                        Q++;
//                    if(chessComponents[i][j].getName()=='K')
//                        K++;
//                    if(chessComponents[i][j].getName()=='P')
//                        P++;
//                }
//            }
//        }
//        if(player == ChessColor.WHITE) {
//            if(k<1){
//                string.append("k ").append(1-k).append("\n");
//            }
//            if(q<1){
//                string.append("q ").append(1-q).append("\n");
//            }
//            if(r<2){
//                string.append("r ").append(2-r).append("\n");
//            }
//            if(b<2){
//                string.append("b ").append(2-b).append("\n");
//            }
//            if(n<2){
//                string.append("n ").append(2-n).append("\n");
//            }
//            if(p<8){
//                string.append("p ").append(8-p).append("\n");
//            }
//        }else if(player == ChessColor.BLACK) {
//            if(K<1){
//                string.append("K ").append(1-K).append("\n");
//            }
//            if(Q<1){
//                string.append("Q ").append(1-Q).append("\n");
//            }
//            if(R<2){
//                string.append("R ").append(2-R).append("\n");
//            }
//            if(B<2){
//                string.append("B ").append(2-B).append("\n");
//            }
//            if(N<2){
//                string.append("N ").append(2-N).append("\n");
//            }
//            if(P<8){
//                string.append("P ").append(8-P).append("\n");
//            }
//        }
//        return string.toString();
//    }

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder longString = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<=7;i++){
            for(int j=0; j<=7;j++){
                longString.append(chessComponents[i][j].getName());
            }
        }
        if(player == ChessColor.WHITE){
            int r=0; int n=0; int b=0; int q=0; int k=0; int p=0;
            for(int i=0; i<longString.length();i++){
                char a = longString.charAt(i);
                switch (a) {
                    case 'r' -> r++;
                    case 'n' -> n++;
                    case 'b' -> b++;
                    case 'q' -> q++;
                    case 'k' -> k++;
                    case 'p' -> p++;
                }
            }
            if(k!=1) answer.append("k 1\n");
            if(q!=1) answer.append("q 1\n");
            if(r!=2) answer.append("r ").append(2-r).append("\n");
            if(b!=2) answer.append("b ").append(2-b).append("\n");
            if(n!=2) answer.append("n ").append(2-n).append("\n");
            if(p!=8) answer.append("p ").append(8-p).append("\n");
        }else if(player == ChessColor.BLACK){
            int R=0; int N=0; int B=0; int Q=0; int K=0; int P=0;
            for(int i=0; i<longString.length();i++){
                char a = longString.charAt(i);
                switch (a) {
                    case 'R' -> R++;
                    case 'N' -> N++;
                    case 'B' -> B++;
                    case 'Q' -> Q++;
                    case 'K' -> K++;
                    case 'P' -> P++;
                }
            }
            if(K!=1) answer.append("K 1\n");
            if(Q!=1) answer.append("Q 1\n");
            if(R!=2) answer.append("R ").append(2-R).append("\n");
            if(B!=2) answer.append("B ").append(2-B).append("\n");
            if(N!=2) answer.append("N ").append(2-N).append("\n");
            if(P!=8) answer.append("P ").append(8-P).append("\n");
        }
        return answer.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        //Find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        chess.chessboard = chessComponents;
        //As below statement
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for(int i=0; i<canMovePoints.size();i++){
            for(int j=1; j<canMovePoints.size();j++){
                if(canMovePoints.get(j-1).getX()>canMovePoints.get(j).getX()){
                    Collections.swap(canMovePoints,j-1,j);
                }else if(canMovePoints.get(j-1).getX()==canMovePoints.get(j).getX() && canMovePoints.get(j-1).getY()>canMovePoints.get(j).getY()){
                    Collections.swap(canMovePoints,j-1,j);
                }
            }
        }
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chess = chessComponents[sourceX][sourceY];
        chess.chessboard = chessComponents;
        chessComponents[targetX][targetY].chessboard = chessComponents;
        List<ChessboardPoint> can= chess.canMoveTo();
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        if (Objects.equals(currentPlayer, chess.getChessColor())) {
            for (ChessboardPoint point : can) {
                if (targetX==point.getX() && targetY==point.getY()) {
                    chessComponents[sourceX][sourceY].setSource(target);
                    chessComponents[targetX][targetY] =  chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(source);
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setName('_');
                    if (currentPlayer == ChessColor.BLACK)
                        currentPlayer = ChessColor.WHITE;
                    else if(currentPlayer ==ChessColor.WHITE)
                        currentPlayer = ChessColor.BLACK;
                    return true;
                }
            }
        }
        return false;
    }
}
