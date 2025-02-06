import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessColor currentPlayer = ChessColor.WHITE;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<chessboard.size()-1;i++){
            for (int j=0;j<chessboard.get(i).length();j++){
                switch (chessboard.get(i).charAt(j)) {
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));break;
                }
            }

        }
        if(chessboard.get(chessboard.size()-1).equals("w"))
            currentPlayer = ChessColor.WHITE;
        else 
            currentPlayer = ChessColor.BLACK;
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
        StringBuilder result = new StringBuilder();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                result.append(chessComponents[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player == ChessColor.BLACK){
            StringBuilder stringBuilder = new StringBuilder();
            int P = 8,R=2,N=2,B=2,Q=1;
            for(int i=0;i<getChessboardGraph().length();i++){
                switch (getChessboardGraph().charAt(i)){
                    case 'P': P--;break;
                    case 'R': R--;break;
                    case 'N': N--;break;
                    case 'B': B--;break;
                    case 'Q': Q--;break;
                    default: break;
                }
            }
            if(Q>0)
                stringBuilder.append(String.format("Q %d\n",Q));
            if(R>0)
                stringBuilder.append(String.format("R %d\n",R));
            if(B>0)
                stringBuilder.append(String.format("B %d\n",B));
            if(N>0)
                stringBuilder.append(String.format("N %d\n",N));
            if(P>0)
                stringBuilder.append(String.format("P %d\n",P));
            return stringBuilder.toString();
        }
        if(player == ChessColor.WHITE){
            StringBuilder stringBuilder = new StringBuilder();
            int p= 8,r=2,n=2,b=2,q=1;
            for(int i=0;i<getChessboardGraph().length();i++){
                switch (getChessboardGraph().charAt(i)){
                    case 'P': p--;break;
                    case 'R': r--;break;
                    case 'N': n--;break;
                    case 'B': b--;break;
                    case 'Q': q--;break;
                    default: break;
                }
            }
            if(q>0)
                stringBuilder.append(String.format("q %d\n",q));
            if(r>0)
                stringBuilder.append(String.format("r %d\n",r));
            if(b>0)
                stringBuilder.append(String.format("b %d\n",b));
            if(n>0)
                stringBuilder.append(String.format("n %d\n",n));
            if(p>0)
                stringBuilder.append(String.format("p %d\n",p));
            return stringBuilder.toString();
        }
        return String.format("");
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
       ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(Comparator.naturalOrder());
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
            if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }
                else
                    currentPlayer = ChessColor.WHITE;
                return true;
            }
        }
        return false;

    }
}