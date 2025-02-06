import java.util.*;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer= ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',chessComponents);
                        break;
                    }
            }
        }
        if( chessboard.get(8).charAt(0) == 'b' )
            currentPlayer = ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder a0 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a0.append(chessComponents[0][i].toString());
        }
        StringBuilder a1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a1.append(chessComponents[1][i].toString());
        }
        StringBuilder a2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a2.append(chessComponents[2][i].toString());
        }
        StringBuilder a3 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a3.append(chessComponents[3][i].toString());
        }
        StringBuilder a4 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a4.append(chessComponents[4][i].toString());
        }
        StringBuilder a5 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a5.append(chessComponents[5][i].toString());
        }
        StringBuilder a6 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a6.append(chessComponents[6][i].toString());
        }
        StringBuilder a7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            a7.append(chessComponents[7][i].toString());
        }
        return a0+"\n"+a1+"\n"+a2+"\n"+a3+"\n"+a4+"\n"+a5+"\n"+a6+"\n"+a7;
    }

    public String getCapturedChess(ChessColor player){
        int R=0,N=0,B=0,Q=0,K=0,P=0,r=0,n=0,b=0,q=0,k=0,p=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].name=='R')
                    R++;
                if(chessComponents[i][j].name=='N')
                    N++;
                if(chessComponents[i][j].name=='B')
                    B++;
                if(chessComponents[i][j].name=='Q')
                    Q++;
                if(chessComponents[i][j].name=='K')
                    K++;
                if(chessComponents[i][j].name=='P')
                    P++;
                if(chessComponents[i][j].name=='r')
                    r++;
                if(chessComponents[i][j].name=='n')
                    n++;
                if(chessComponents[i][j].name=='b')
                    b++;
                if(chessComponents[i][j].name=='q')
                    q++;
                if(chessComponents[i][j].name=='k')
                    k++;
                if(chessComponents[i][j].name=='p')
                    p++;
            }
        }

        StringBuilder result = new StringBuilder();

        if(player == ChessColor.BLACK){
            if( K < 1 ){
                result.append("K 1\n");
            }
            if( Q < 1 ){
                result.append("Q 1\n");
            }
            if( R < 2 ){
                if( R == 1 )
                    result.append("R 1\n");
                if( R == 0 )
                    result.append("R 2\n");
            }
            if( B < 2 ){
                if( B == 1 )
                    result.append("B 1\n");
                if( B == 0 )
                    result.append("B 2\n");
            }
            if( N < 2 ){
                if( N == 1 )
                    result.append("N 1\n");
                if( N == 0 )
                    result.append("N 2\n");
            }
            if( P < 8 ){
                if( P == 7 )
                    result.append("P 1\n");
                if( P == 6 )
                    result.append("P 2\n");
                if( P == 5 )
                    result.append("P 3\n");
                if( P == 4 )
                    result.append("P 4\n");
                if( P == 3 )
                    result.append("P 5\n");
                if( P == 2 )
                    result.append("P 6\n");
                if( P == 1 )
                    result.append("P 7\n");
                if( P == 0 )
                    result.append("P 8\n");
            }
        }

        if(player == ChessColor.WHITE){
            if( k < 1 ){
                result.append("k 1\n");
            }
            if( q < 1 ){
                result.append("q 1\n");
            }
            if( r < 2 ){
                if( r == 1 )
                    result.append("r 1\n");
                if( r == 0 )
                    result.append("r 2\n");
            }
            if( b < 2 ){
                if( b == 1 )
                    result.append("b 1\n");
                if( b == 0 )
                    result.append("b 2\n");
            }
            if( n < 2 ){
                if( n == 1 )
                    result.append("n 1\n");
                if( n == 0 )
                    result.append("n 2\n");
            }
            if( p < 8 ){
                if( p == 7 )
                    result.append("p 1\n");
                if( p == 6 )
                    result.append("p 2\n");
                if( p == 5 )
                    result.append("p 3\n");
                if( p == 4 )
                    result.append("p 4\n");
                if( p == 3 )
                    result.append("p 5\n");
                if( p == 2 )
                    result.append("p 6\n");
                if( p == 1 )
                    result.append("p 7\n");
                if( p == 0 )
                    result.append("p 8\n");
            }
        }

        return result+"";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                ChessboardPoint t;
                if( canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX() ){
                    t = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,t);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                ChessboardPoint t;
                if( canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()
                        && canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY() ) {
                    t = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,t);
                }
            }
        }

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean result = false;
        if( 0 <= sourceX && sourceX < 8 && 0 <= sourceY && sourceY < 8 && 0 <= targetX && targetX < 8 && 0 <= targetY && targetY < 8 ) {
            List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
            boolean ok = false;
            ChessComponent sourceChess = getChess(sourceX, sourceY);
            ChessComponent targetChess = getChess(targetX,targetY);

            if (move.size() != 0) {
                for (ChessboardPoint chessboardPoint : move) {
                    if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                        ok = true;
                        break;
                    }
                }
                if( ok ) {
                    if (currentPlayer == ChessColor.BLACK && sourceChess.name < 91 && targetChess.name >= 91) {
                    chessComponents[targetX][targetY] = sourceChess;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
                    currentPlayer = ChessColor.WHITE;
                    result = true;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                switch (chessComponents[i][j].name) {
                                    case 'R':
                                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',chessComponents);
                                        break;
                                    case 'N':
                                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',chessComponents);
                                        break;
                                    case 'B':
                                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',chessComponents);
                                        break;
                                    case 'Q':
                                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',chessComponents);
                                        break;
                                    case 'K':
                                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',chessComponents);
                                        break;
                                    case 'P':
                                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',chessComponents);
                                        break;
                                    case '_':
                                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',chessComponents);
                                        break;
                                    case 'r':
                                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',chessComponents);
                                        break;
                                    case 'n':
                                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',chessComponents);
                                        break;
                                    case 'b':
                                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',chessComponents);
                                        break;
                                    case 'q':
                                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',chessComponents);
                                        break;
                                    case 'k':
                                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',chessComponents);
                                        break;
                                    case 'p':
                                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',chessComponents);
                                        break;
                                }
                            }
                        }
                }
                    else if (currentPlayer == ChessColor.WHITE && sourceChess.name > 97 && targetChess.name <= 97) {
                    chessComponents[targetX][targetY] = sourceChess;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
                    currentPlayer = ChessColor.BLACK;
                    result = true;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                switch (chessComponents[i][j].name) {
                                    case 'R':
                                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',chessComponents);
                                        break;
                                    case 'N':
                                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',chessComponents);
                                        break;
                                    case 'B':
                                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',chessComponents);
                                        break;
                                    case 'Q':
                                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',chessComponents);
                                        break;
                                    case 'K':
                                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',chessComponents);
                                        break;
                                    case 'P':
                                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',chessComponents);
                                        break;
                                    case '_':
                                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',chessComponents);
                                        break;
                                    case 'r':
                                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',chessComponents);
                                        break;
                                    case 'n':
                                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',chessComponents);
                                        break;
                                    case 'b':
                                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',chessComponents);
                                        break;
                                    case 'q':
                                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',chessComponents);
                                        break;
                                    case 'k':
                                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',chessComponents);
                                        break;
                                    case 'p':
                                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',chessComponents);
                                        break;
                                }
                            }
                        }
                }
                    else result = false;
                }
            }

            return result;

        }
        else return false;

    }


    public ChessComponent getChess(int x, int y){
        if( (x>=0 && x<8) && (y>=0 && y<8) )
            return chessComponents[x][y];
        else
            return null;
    }

}
