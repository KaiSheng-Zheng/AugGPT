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

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
            if(chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            boolean temp = false;
            List<ChessboardPoint> com = chessComponents[sourceX][sourceY].canMoveTo();
            for(ChessboardPoint a : com){
                if(a.getX()==targetX&&targetY==a.getY()) {
                    temp = true;
                    break;
                }
            }
            if(temp){
                if(!chessComponents[targetX][targetY].getChessColor().equals(currentPlayer)){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                    chessComponents[targetX][targetY].setCount();
                    currentPlayer = currentPlayer.equals(ChessColor.BLACK)? ChessColor.WHITE:ChessColor.BLACK;
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).equals("w") ) this.currentPlayer = ChessColor.WHITE;
        else this.currentPlayer = ChessColor.BLACK;

        chessComponents = new ChessComponent[8][8];
        int count = 8 ;

        for(int i = 0;i<8;i++ ){

            String a = chessboard.get(i);

            for(int j = 0;j<8;j++) {
                String com = a.substring(j,j+1);
                chessComponents[i][j] = exchange(com,i,j);
            }
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint){
        // 1. find chess according to source
        ChessComponent chess = this.getChess(chessboardPoint.getX(),chessboardPoint.getY());

        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
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
        StringBuilder com = new StringBuilder();

        for(int x =0;x<8; x++){
            for(int y = 0;y<8;y++){
                com.append(chessComponents[x][y].getName());
            }
            if(x!=7) com.append("\n");
        }
        String result = com.toString();
        return result;
    }

    @Override
     public String getCapturedChess(ChessColor player) {
        int King =1,Queen =  1, Rooks = 2, Bishops = 2,Knights = 2,Pawns= 8;
        StringBuilder com = new StringBuilder();
        String result = com.toString();
        if(player.equals(ChessColor.BLACK)) {
            for (ChessComponent[] a : chessComponents) {
                for (ChessComponent b : a) {
                    if (b.getName()=='K') King--;
                    else if(b.getName()=='Q') Queen--;
                    else if(b.getName()=='R') Rooks--;
                    else if(b.getName()=='B') Bishops--;
                    else if(b.getName()=='N') Knights--;
                    else if(b.getName()=='P') Pawns--;
                }
            }

            if(King>0) com.append("K "+King+"\n");
            if(Queen>0) com.append("Q "+Queen+"\n");
            if(Rooks>0) com.append("R "+Rooks+"\n");
            if(Bishops>0) com.append("B "+Bishops+"\n");
            if(Knights>0) com.append("N "+Knights+"\n");
            if(Pawns>0) com.append("P "+Pawns+"\n");

        }else {
            for (ChessComponent[] a : chessComponents) {
                for (ChessComponent b : a) {
                    if (b.getName()=='k') King--;
                    else if(b.getName()=='q') Queen--;
                    else if(b.getName()=='r') Rooks--;
                    else if(b.getName()=='b') Bishops--;
                    else if(b.getName()=='n') Knights--;
                    else if(b.getName()=='p') Pawns--;
                }
            }
            if(King>0) com.append("k "+King+"\n");
            if(Queen>0) com.append("q "+Queen+"\n");
            if(Rooks>0) com.append("r "+Rooks+"\n");
            if(Bishops>0) com.append("b "+Bishops+"\n");
            if(Knights>0) com.append("n "+Knights+"\n");
            if(Pawns>0) com.append("p "+Pawns+"\n");
        }
        result = com.toString();
        return result;
    }


    private  ChessComponent exchange(String a ,int x,int y){
        ChessComponent result = null;
        ChessboardPoint point = new ChessboardPoint(x,y);
        char name = a.charAt(0);
        //char name , ChessColor a, ChessboardPoint b
        if(a.equals("_")) result = new EmptySlotComponent( point);
        if(a.equals("R")) result = new RookChessComponent(name, ChessColor.BLACK,point,chessComponents);
        if(a.equals("N")) result = new KnightChessComponent(name, ChessColor.BLACK,point,chessComponents);
        if(a.equals("B")) result = new BishopChessComponent(name, ChessColor.BLACK,point,chessComponents);
        if(a.equals("Q")) result = new QueenChessComponent(name, ChessColor.BLACK,point,chessComponents);
        if(a.equals("K")) result = new KingChessComponent(name, ChessColor.BLACK,point,chessComponents);
        if(a.equals("P")) result = new PawnChessComponent(name, ChessColor.BLACK,point,chessComponents);

        if(a.equals("r")) result = new RookChessComponent(name, ChessColor.WHITE,point,chessComponents);
        if(a.equals("n")) result = new KnightChessComponent(name, ChessColor.WHITE,point,chessComponents);
        if(a.equals("b")) result = new BishopChessComponent(name, ChessColor.WHITE,point,chessComponents);
        if(a.equals("q")) result = new QueenChessComponent(name, ChessColor.WHITE,point,chessComponents);
        if(a.equals("k")) result = new KingChessComponent(name, ChessColor.WHITE,point,chessComponents);
        if(a.equals("p")) result = new PawnChessComponent(name, ChessColor.WHITE,point,chessComponents);

        return result;
    }

}
