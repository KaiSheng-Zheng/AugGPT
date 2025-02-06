import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;
    private int i;
    private static ChessComponent[][] a;

    public static ChessComponent[][] getA() {
        a=getChessComponents();
        return a;
    }

    public static ChessComponent[][] getChessComponents() {
        return a;
    }



    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                char chess=chessboard.get(x).charAt(y);
                ChessComponent Chess;
                switch (chess){
                    case 'r':
                        Chess=new RookChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'R':
                        Chess=new RookChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'n':
                        Chess=new KnightChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'N':
                        Chess=new KnightChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'b':
                        Chess=new BishopChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'B':
                        Chess=new BishopChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'q':
                        Chess=new QueenChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'Q':
                        Chess=new QueenChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'k':
                        Chess=new KingChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'K':
                        Chess=new KingChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'p':
                        Chess=new PawnChessComponent(x,y,ChessColor.WHITE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case 'P':
                        Chess=new PawnChessComponent(x,y,ChessColor.BLACK,chess);
                        chessComponents[x][y]=Chess;
                        break;
                    case '_':
                        Chess=new EmptySlotComponent(x,y,ChessColor.NONE,chess);
                        chessComponents[x][y]=Chess;
                        break;
                }
            }
        }
        char color=chessboard.get(8).charAt(0);
        if(color=='b'){
            currentPlayer=ChessColor.BLACK;
            i=1;
        }
        if (color=='w'){
            currentPlayer=ChessColor.WHITE;
            i=2;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        if (i==2){
            currentPlayer=ChessColor.WHITE;
        }else {
            currentPlayer=ChessColor.BLACK;
        }
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder=new StringBuilder();
        for (int x=0;x<8;i++){
            for (int y=0;y<8;y++){
                stringBuilder.insert((y+x*9),chessComponents[x][y].toString());
            }
            stringBuilder.insert(stringBuilder.length(),"\n");
        }
        stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
        String s=stringBuilder.toString();
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int king = 0;int queen = 0;int pawn = 0;int knight = 0;int bishop = 0;int rook = 0;
        StringBuilder stringBuilder=new StringBuilder();
        if(player==ChessColor.WHITE){
            for (ChessComponent[] a:chessComponents){
                for (ChessComponent b:a){
                    if (b.toString().equals("k")){
                        king=king+1;
                    }
                    if (b.toString().equals("q")){
                        queen=queen+1;
                    }
                    if (b.toString().equals("p")){
                        pawn=pawn+1;
                    }
                    if (b.toString().equals("n")){
                        knight=knight+1;
                    }
                    if (b.toString().equals("b")){
                        bishop=bishop+1;
                    }
                    if (b.toString().equals("r")){
                        rook=rook+1;
                    }
                }
            }
            if(1-king!=0){
                String use = String.format("k %s\n",1-king);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(1-queen!=0){
                String use = String.format("q %s\n",1-queen);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-rook!=0){
                String use = String.format("r %s\n",2-rook);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-bishop!=0){
                String use = String.format("b %s\n",2-bishop);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-knight!=0){
                String use = String.format("n %s\n",2-knight);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(8-pawn!=0){
                String use = String.format("p %s\n",8-pawn);
                stringBuilder.insert(stringBuilder.length(),use);
            }
        }
        if (player==ChessColor.BLACK){
            for (ChessComponent[] a:chessComponents) {
                for (ChessComponent b : a) {
                    if (b.toString().equals("K")){
                        king=king+1;
                    }
                    if (b.toString().equals("Q")){
                        queen=queen+1;
                    }
                    if (b.toString().equals("P")){
                        pawn=pawn+1;
                    }
                    if (b.toString().equals("N")){
                        knight=knight+1;
                    }
                    if (b.toString().equals("B")){
                        bishop=bishop+1;
                    }
                    if (b.toString().equals("R")){
                        rook=rook+1;
                    }
                }
            }
            if(1-king!=0){
                String use = String.format("k %s\n",1-king);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(1-queen!=0){
                String use = String.format("q %s\n",1-queen);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-rook!=0){
                String use = String.format("r %s\n",2-rook);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-bishop!=0){
                String use = String.format("b %s\n",2-bishop);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(2-knight!=0){
                String use = String.format("n %s\n",2-knight);
                stringBuilder.insert(stringBuilder.length(),use);
            }
            if(8-pawn!=0){
                String use = String.format("p %s\n",8-pawn);
                stringBuilder.insert(stringBuilder.length(),use);
            }
        }
        if (player==ChessColor.NONE){
            stringBuilder.append("");
        }
        String s=stringBuilder.toString();
        return s;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent CanMovePoints=getChess(source.getX(),source.getY());
        return CanMovePoints.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent Source=getChess(sourceX,sourceY);
        ChessboardPoint Target=new ChessboardPoint(targetX,targetY);
        if (currentPlayer==Source.getChessColor()){
            if (Source.canMoveTo().contains(Target)){
                ChessComponent Empty=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                chessComponents[sourceX][sourceY]=Empty;
                Source.setSource(targetX,targetY);
                chessComponents[targetX][targetY]=Source;
                i=i+1;
                return true;
            }else return false;
        }else return false;
    }

}
