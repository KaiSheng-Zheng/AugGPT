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

    public ConcreteChessGame (){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i =0;i<chessboard.size()-1;i++){
            for(int k=0;k<chessboard.get(i).length();k++){
                ChessboardPoint location = new ChessboardPoint(i,k);
                char store = chessboard.get(i).charAt(k);
                switch(store){
                    case '_':
                        chessComponents[i][k]=new EmptySlotComponent(location,ChessColor.NONE, '_');
                        break;
                    case 'p':
                        chessComponents[i][k]=new PawnChessComponent(location,ChessColor.WHITE,'p');
                        break;
                    case 'P':
                        chessComponents[i][k]=new PawnChessComponent(location,ChessColor.BLACK,'P');
                        break;
                    case 'r':
                        chessComponents[i][k]=new RookChessComponent(location,ChessColor.WHITE,'r');
                        break;
                    case 'R':
                        chessComponents[i][k]=new RookChessComponent(location,ChessColor.BLACK,'R');
                        break;
                    case 'n':
                        chessComponents[i][k]=new KnightChessComponent(location,ChessColor.WHITE,'n');
                        break;
                    case 'N':
                        chessComponents[i][k]=new KnightChessComponent(location,ChessColor.BLACK,'N');
                        break;
                    case 'b':
                        chessComponents[i][k]=new BishopChessComponent(location,ChessColor.WHITE,'b');
                        break;
                    case 'B':
                        chessComponents[i][k]=new BishopChessComponent(location,ChessColor.BLACK,'B');
                        break;
                    case 'q':
                        chessComponents[i][k]=new QueenChessComponent(location,ChessColor.WHITE,'q');
                        break;
                    case 'Q':
                        chessComponents[i][k]=new QueenChessComponent(location,ChessColor.BLACK,'Q');
                        break;
                    case 'k':
                        chessComponents[i][k]=new KingChessComponent(location,ChessColor.WHITE,'k');
                        break;
                    case 'K':
                        chessComponents[i][k]=new KingChessComponent(location,ChessColor.BLACK,'K');
                        break;
                }

                chessComponents[i][k].setChessboard(chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        else{
            currentPlayer=ChessColor.BLACK;
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
        String store="";
        for(int i =0;i<8;i++){
            for(int k=0; k<8;k++){
                store += chessComponents[i][k].toString();
            }
            store += String.format("\n");
        }

        return store;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String store="";

        int [][]a=new int [2][6];
        int [][]c={{1,1,2,2,2,8},{1,1,2,2,2,8}};
        for(int i =0;i<8;i++){
            for(int k=0;k<8;k++){
                switch(chessComponents[i][k].toString()){
                    case "p": a[0][5]++;break;
                    case "P": a[1][5]++;break;
                    case "q": a[0][1]++;break;
                    case "Q": a[1][1]++;break;
                    case "k": a[0][0]++;break;
                    case "K": a[1][0]++;break;
                    case "R": a[1][2]++;break;
                    case "r": a[0][2]++;break;
                    case "B": a[1][3]++;break;
                    case "b": a[0][3]++;break;
                    case "n": a[0][4]++;break;
                    case "N": a[1][4]++;break;

                }
            }
        }

        if(player==ChessColor.WHITE){
            String [] b= {"k","q","r","b","n","p"};
            for(int i=0;i<6;i++){
                if(a[0][i]!=c[0][i]){
                    int d=c[0][i]-a[0][i];
                    store+=String.format(b[i]+" "+d+"\n");
                }
            }
        }
        else{
            String [] b= {"K","Q","R","B","N","P"};
            for(int i=0;i<6;i++){
                if(a[1][i]!=c[1][i]){
                    int d=c[1][i]-a[1][i];
                    store+=String.format(b[i]+" "+d+"\n");
                }
            }
        }

        return store;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
// 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());
// 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
// 3.sort canMovePoints by x - y ascending order
        for(int i=0;i< canMovePoints.size()-1;i++){
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                if (canMovePoints.get(j).getX() > canMovePoints.get(j+ 1).getX()) {
                    ChessboardPoint that = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j + 1));
                    canMovePoints.set(j + 1, that);
                }
                if(canMovePoints.get(j).getX() == canMovePoints.get(j+ 1).getX()&&
                        canMovePoints.get(j).getY() > canMovePoints.get(j+ 1).getY()){
                    ChessboardPoint that = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j + 1));
                    canMovePoints.set(j + 1, that);
                }
            }
        }

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean judge =false;
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
            ChessboardPoint a = new ChessboardPoint(sourceX, sourceY);
            ChessboardPoint b = new ChessboardPoint(targetX, targetY);
            List<ChessboardPoint> store = getCanMovePoints(a);
            for (int i = 0; i < store.size(); i++) {
                if (store.get(i).toString().compareTo(b.toString()) == 0) {
                    judge = true;

                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }

                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setPoint(b);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(a, ChessColor.NONE, '_');
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 8; k++) {
                            chessComponents[j][k].setChessboard(chessComponents);
                        }
                    }
                }
            }
        }

        return judge;
    }
}
