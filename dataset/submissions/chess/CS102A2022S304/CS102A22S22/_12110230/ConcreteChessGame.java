import java.util.Collections;
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

   public ConcreteChessGame()
   {
       this.chessComponents=new ChessComponent[8][8];
       this.currentPlayer=ChessColor.WHITE;
   }

    public ChessComponent[][] getChessComponents() {return chessComponents;}

    @Override
    public void loadChessGame(List<String> chessboard)
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j)=='K') {chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='k') {chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='B') {chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='b') {chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='P') {chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='p') {chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='N') {chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='n') {chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='Q') {chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='q') {chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='R') {chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='r') {chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='_') {chessComponents[i][j]=new EmptySlotComponent(i,j,chessboard.get(i).charAt(j));}
            }
        }
        if(chessboard.get(8).charAt(0)=='b')
        {
            this.currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph()
    {
        StringBuilder output=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                output.append(chessComponents[i][j].name);
            }
            output.append("\n");
        }
    return output.toString();
   }

    @Override
    public String getCapturedChess(ChessColor player)
    {
        StringBuilder output =new StringBuilder();
        String boardGraph=getChessboardGraph();
        int countK=1;
        int countN=2;
        int countP=8;
        int countR=2;
        int countB=2;
        int countQ=1;
        if(player==ChessColor.BLACK)
        {
            for (int i = 0; i < boardGraph.length(); i++) {
                if (boardGraph.charAt(i) == 'K') {
                    countK--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'Q') {
                    countQ--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'R') {
                    countR--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'B') {
                    countB--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'N') {
                    countN--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'P') {
                    countP--;
                    continue;
                }
            }
            if(countK!=0){output.append("K "+countK+"\n");}
            if(countQ!=0){output.append("Q "+countQ+"\n");}
            if(countR!=0){output.append("R "+countR+"\n");}
            if(countB!=0){output.append("B "+countB+"\n");}
            if(countN!=0){output.append("N "+countN+"\n");}
            if(countP!=0){output.append("P "+countP+"\n");}
        }
        if(player==ChessColor.WHITE)
        {
            for (int i = 0; i < boardGraph.length(); i++) {
                if (boardGraph.charAt(i) == 'k') {
                    countK--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'q') {
                    countQ--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'r') {
                    countR--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'b') {
                    countB--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'n') {
                    countN--;
                    continue;
                }
                if (boardGraph.charAt(i) == 'p') {
                    countP--;
                    continue;
                }
            }
            if(countK!=0){output.append("k "+countK+"\n");}
            if(countQ!=0){output.append("q "+countQ+"\n");}
            if(countR!=0){output.append("r "+countR+"\n");}
            if(countB!=0){output.append("b "+countB+"\n");}
            if(countN!=0){output.append("n "+countN+"\n");}
            if(countP!=0){output.append("p "+countP+"\n");}
        }
        return output.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)
    {
        getChess(source.getX(),source.getY()).setChessboard(getChessComponents());
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> CanMoveTo=chess.canMoveTo();
        Collections.sort(CanMoveTo);
        return CanMoveTo;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
    {
        ChessComponent source=getChess(sourceX,sourceY);
        source.setChessboard(getChessComponents());
        if(source.getChessColor()!=getCurrentPlayer()) {return false;}
        List<ChessboardPoint> output=chessComponents[sourceX][sourceY].canMoveTo();
        ChessComponent target =getChess(targetX,targetY);
        for (ChessboardPoint canMovePoints:output)
        {
            if(canMovePoints.getX()==targetX && canMovePoints.getY()==targetY)
            {
                source.setSource(targetX,targetY);
                chessComponents[targetX][targetY]=source;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,'_');
                if(source.getChessColor()==ChessColor.BLACK){this.currentPlayer=ChessColor.WHITE;}
                if(source.getChessColor()==ChessColor.WHITE){this.currentPlayer=ChessColor.BLACK;}
                return true;
            }
        }
        return false;
    }

}