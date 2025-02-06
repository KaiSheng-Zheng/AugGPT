import java.util.List;
import java.util.Objects;

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
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 82:{
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 114:{
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 80:{
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 112:{
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 78:{
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 110:{
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 81:{
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 113:{
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 75:{
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 107:{
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 66:{
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        break;
                    }
                    case 98:{
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        break;
                    }
                    case 95:{
                        this.chessComponents[i][j] = new EmptySlotChessComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                        break;
                    }
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer=ChessColor.WHITE;
        }else {
            this.currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void changeCurrentPlayer(){
        if (getCurrentPlayer() == ChessColor.WHITE){
            setCurrentPlayer(ChessColor.BLACK);
        }
        else {
            setCurrentPlayer(ChessColor.WHITE);
        }
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j].toString());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
        int k,q,r,b,n,p;
        String string = getChessboardGraph();
        if (player == ChessColor.BLACK){
            k=1-string.length()+string.replace("K","").length();
            q=1-string.length()+string.replace("Q","").length();
            r=2-string.length()+string.replace("R","").length();
            b=2-string.length()+string.replace("B","").length();
            n=2-string.length()+string.replace("N","").length();
            p=8-string.length()+string.replace("P","").length();
            if (k!=0)stringBuilder.append(String.format("K %d\n",k));
            if (q!=0)stringBuilder.append(String.format("Q %d\n",q));
            if (r!=0)stringBuilder.append(String.format("R %d\n",r));
            if (b!=0)stringBuilder.append(String.format("B %d\n",b));
            if (n!=0)stringBuilder.append(String.format("N %d\n",n));
            if (p!=0)stringBuilder.append(String.format("P %d\n",p));

        }
        else{
            k=1-string.length()+string.replace("k","").length();
            q=1-string.length()+string.replace("q","").length();
            r=2-string.length()+string.replace("r","").length();
            b=2-string.length()+string.replace("b","").length();
            n=2-string.length()+string.replace("n","").length();
            p=8-string.length()+string.replace("p","").length();
            if (k!=0)stringBuilder.append(String.format("k %d\n",k));
            if (q!=0)stringBuilder.append(String.format("q %d\n",q));
            if (r!=0)stringBuilder.append(String.format("r %d\n",r));
            if (b!=0)stringBuilder.append(String.format("b %d\n",b));
            if (n!=0)stringBuilder.append(String.format("n %d\n",n));
            if (p!=0)stringBuilder.append(String.format("p %d\n",p));

        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        chess.loadChessboard(chessComponents);
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()) {
            getChess(sourceX, sourceY).loadChessboard(chessComponents);
            boolean b = false;List<ChessboardPoint> move =getCanMovePoints(getChess(sourceX,sourceY).getSource());
            for (ChessboardPoint chessboardPoint : move){
                if (chessboardPoint.getX() == targetX &&  chessboardPoint.getY() == targetY ){
                    b = true;
                    break;
                }
            }
            if (b) {
                this.chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                this.chessComponents[sourceX][sourceY] = new EmptySlotChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                changeCurrentPlayer();
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
