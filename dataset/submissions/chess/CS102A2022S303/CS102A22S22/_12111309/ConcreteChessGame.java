import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;


    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'K':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                        chessComponents[i][j].setChessboard(chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='b') this.currentPlayer=ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String returnValue = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                returnValue += chessComponents[i][j].getName();
            }
            returnValue += "\n";
        }
        return returnValue;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String chessGraph = getChessboardGraph();
        char[] blackwhite = {'K','Q','R','B','N','P','k','q','r','b','n','p'};
        String resultfinal = "";
        int color = 0;
        int[] result = {1,1,2,2,2,8};
        if (player==ChessColor.BLACK){
            color = 0;
        }
        else if (player==ChessColor.WHITE){
            color = 6;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < chessGraph.length(); j++) {
                if (blackwhite[color+i]==chessGraph.charAt(j)){
                    result[i]--;
                }
                else continue;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (result[i]>0){
                resultfinal = resultfinal.concat(blackwhite[i+color]+" "+result[i]+"\n");
            }
            else continue;
        }
        return resultfinal;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)  {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()) return false;
        ArrayList<ChessboardPoint> movepoints = new ArrayList<>(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)));
        boolean result = false;
        for (int i = 0; i < movepoints.size(); i++) {
            int x = movepoints.get(i).getX();
            int y = movepoints.get(i).getY();
            if (x==targetX&&y==targetY){
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                result = true;
                if (currentPlayer==ChessColor.BLACK){
                    currentPlayer = ChessColor.WHITE;
                }
                else currentPlayer = ChessColor.BLACK;
                break;
            }
        }
        return result;
    }


}
