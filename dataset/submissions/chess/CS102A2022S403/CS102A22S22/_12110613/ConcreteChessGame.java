import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void setEmpty(int i,int j){
        this.chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if(chessboard.get(i).charAt(j)=='k') {
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,'k');
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }else if(chessboard.get(8).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder chessboard= new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessboard.append(chessComponents[i][j].name);
            }
            if(i<7){
                chessboard.append("\n");
            }
        }
        return chessboard.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K=0,Q=0,R=0,B=0,N=0,P=0;
        StringBuilder capture=new StringBuilder();
        if(player==ChessColor.BLACK){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name=='K'){
                        K++;
                    }
                    if(chessComponents[i][j].name=='Q'){
                        Q++;
                    }
                    if(chessComponents[i][j].name=='R'){
                        R++;
                    }
                    if(chessComponents[i][j].name=='B'){
                        B++;
                    }
                    if(chessComponents[i][j].name=='N'){
                        N++;
                    }
                    if(chessComponents[i][j].name=='P'){
                        P++;
                    }
                }
            }
            int capturedK=1-K,capturedQ=1-Q,capturedR=2-R,capturedB=2-B,capturedN=2-N,capturedP=8-P;
            if(capturedK!=0){
                capture.append(String.format("K %d\n",capturedK));
            }
            if(capturedQ!=0){
                capture.append(String.format("Q %d\n",capturedQ));
            }
            if(capturedR!=0){
                capture.append(String.format("R %d\n",capturedR));
            }
            if(capturedB!=0){
                capture.append(String.format("B %d\n",capturedB));
            }
            if(capturedN!=0){
                capture.append(String.format("N %d\n",capturedN));
            }
            if(capturedP!=0){
                capture.append(String.format("P %d\n",capturedP));
            }
        }else if(player==ChessColor.WHITE){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name=='k'){
                        K++;
                    }
                    if(chessComponents[i][j].name=='q'){
                        Q++;
                    }
                    if(chessComponents[i][j].name=='r'){
                        R++;
                    }
                    if(chessComponents[i][j].name=='b'){
                        B++;
                    }
                    if(chessComponents[i][j].name=='n'){
                        N++;
                    }
                    if(chessComponents[i][j].name=='p'){
                        P++;
                    }
                }
            }
            int capturedK=1-K,capturedQ=1-Q,capturedR=2-R,capturedB=2-B,capturedN=2-N,capturedP=8-P;
            if(capturedK!=0){
                capture.append(String.format("k %d\n",capturedK));
            }
            if(capturedQ!=0){
                capture.append(String.format("q %d\n",capturedQ));
            }
            if(capturedR!=0){
                capture.append(String.format("r %d\n",capturedR));
            }
            if(capturedB!=0){
                capture.append(String.format("b %d\n",capturedB));
            }
            if(capturedN!=0){
                capture.append(String.format("n %d\n",capturedN));
            }
            if(capturedP!=0){
                capture.append(String.format("p %d\n",capturedP));
            }
        }
        return capture.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        getChess(source.getX(),source.getY()).setChessboard(getChessComponents());
        List<ChessboardPoint> canMovePoints= getChess(source.getX(),source.getY()).canMoveTo();
        List<ChessboardPoint> realCanMove=new ArrayList<>();
        int[][] chessboard=new int[8][8];
        for (ChessboardPoint canMovePoint : canMovePoints) {
            chessboard[canMovePoint.getX()][canMovePoint.getY()] = 1;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard[i][j]==1){
                    realCanMove.add(new ChessboardPoint(i,j));
                }
            }
        }
        return realCanMove;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
        List<ChessboardPoint> canMove=getCanMovePoints(source);
        ChessComponent initial=getChess(sourceX,sourceY);
        if(initial.getChessColor()!=getCurrentPlayer()){
            return false;
        }else{
            boolean contains=false;
            for (ChessboardPoint chessboardPoint : canMove) {
                if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()) {
                    contains = true;
                    break;
                }
            }
            if(contains){
                if(initial instanceof BishopChessComponent){
                    chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                if(initial instanceof KingChessComponent){
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                if(initial instanceof KnightChessComponent){
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                if(initial instanceof PawnChessComponent){
                    chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                if(initial instanceof QueenChessComponent){
                    chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                if(initial instanceof RookChessComponent){
                    chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),initial.getChessColor(), initial.name);
                }
                setEmpty(sourceX,sourceY);
                if(getCurrentPlayer()==ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }else{
                    setCurrentPlayer(ChessColor.WHITE);
                }
                return true;
            }else
                return false;
        }

    }
}
