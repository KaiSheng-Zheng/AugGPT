import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        ChessComponent[][] game=new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name=chessboard.get(i).charAt(j);
                if (name=='R'){
                    ChessComponent chess=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='r'){
                    ChessComponent chess=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='N'){
                    ChessComponent chess=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='n'){
                    ChessComponent chess=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='B'){
                    ChessComponent chess=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='b'){
                    ChessComponent chess=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='K'){
                    ChessComponent chess=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='k'){
                    ChessComponent chess=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='Q'){
                    ChessComponent chess=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='q'){
                    ChessComponent chess=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='P'){
                    ChessComponent chess=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    game[i][j]=chess;
                }
                if (name=='p'){
                    ChessComponent chess=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    game[i][j]=chess;
                }
                if (name=='_'){
                    ChessComponent chess=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                    game[i][j]=chess;
                }
            }
            this.chessComponents=game;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }

        }

        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            this.currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String graph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph=graph.concat(String.valueOf(chessComponents[i][j].name));
            }
            graph=graph.concat("\n");
        }
    return graph;
    }

    public String getCapturedChess(ChessColor player){
        int Queen=0;int King=0;int Pawn=0;int Bishop=0;int Knight=0;int Rook=0;
        String CapturedChess="";
        if (player == ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("q")){Queen++;}
                    if (chessComponents[i][j].toString().equals("k")){King++;}
                    if (chessComponents[i][j].toString().equals("n")){Knight++;}
                    if (chessComponents[i][j].toString().equals("b")){Bishop++;}
                    if (chessComponents[i][j].toString().equals("r")){Rook++;}
                    if (chessComponents[i][j].toString().equals("p")){Pawn++;}
                }
            }
            if (King!=1){
                String chess=String.format("k %d\n",1-King);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Queen!=1){
                String chess=String.format("q %d\n",1-Queen);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Rook!=2){
                String chess=String.format("r %d\n",2-Rook);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Bishop!=2){
                String chess=String.format("b %d\n",2-Bishop);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Knight!=2){
                String chess=String.format("n %d\n",2-Knight);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Pawn!=8){
                String chess=String.format("p %d\n",8-Pawn);
                CapturedChess=CapturedChess.concat(chess);
            }
        }
        if (player == ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("Q")){Queen++;}
                    if (chessComponents[i][j].toString().equals("K")){King++;}
                    if (chessComponents[i][j].toString().equals("N")){Knight++;}
                    if (chessComponents[i][j].toString().equals("B")){Bishop++;}
                    if (chessComponents[i][j].toString().equals("R")){Rook++;}
                    if (chessComponents[i][j].toString().equals("P")){Pawn++;}
                }
            }
            if (King!=1){
                String chess=String.format("K %d\n",1-King);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Queen!=1){
                String chess=String.format("Q %d\n",1-Queen);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Rook!=2){
                String chess=String.format("R %d\n",2-Rook);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Bishop!=2){
                String chess=String.format("B %d\n",2-Bishop);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Knight!=2){
                String chess=String.format("N %d\n",2-Knight);
                CapturedChess=CapturedChess.concat(chess);
            }
            if (Pawn!=8){
                String chess=String.format("P %d\n",8-Pawn);
                CapturedChess=CapturedChess.concat(chess);
            }
        }

        return CapturedChess;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        List<ChessboardPoint> canMovePoints1 =new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point=new ChessboardPoint(i,j);
                if (canMovePoints.contains(point)){
                    canMovePoints1.add(point);
                }
            }
        }
        return canMovePoints1;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent SourceChess=this.chessComponents[sourceX][sourceY];
        if (getCurrentPlayer()!=SourceChess.getChessColor()){
            return false;
        }
        ChessboardPoint Source=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint Target=new ChessboardPoint(targetX,targetY);
        if (SourceChess.canMoveTo().contains(Target)){
            SourceChess.setSource(Target);
            this.chessComponents[targetX][targetY]=SourceChess;
            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(Source,ChessColor.NONE);
            if (getCurrentPlayer()==ChessColor.WHITE){
                this.currentPlayer=ChessColor.BLACK;
            }
            else {
                this.currentPlayer=ChessColor.WHITE;
            }
            return true;
        }
        return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
