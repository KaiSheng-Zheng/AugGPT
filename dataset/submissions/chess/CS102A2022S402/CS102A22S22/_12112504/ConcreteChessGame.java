import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard) {
        ChessboardPoint point;
        for(int i = 0 ; i < 8 ; i++){
            for(int t = 0 ; t < 8 ; t++){
                point = new ChessboardPoint(i,t);
                switch (chessboard.get(i).charAt(t)){
                    case 'R':
                        chessComponents[i][t] = new RookChessComponent(point,ChessColor.BLACK,'R');
                        break;
                    case 'r':
                        chessComponents[i][t] = new RookChessComponent(point,ChessColor.WHITE,'r');
                        break;
                    case 'N':
                        chessComponents[i][t] = new KnightChessComponent(point,ChessColor.BLACK,'N');
                        break;
                    case 'n':
                        chessComponents[i][t] = new KnightChessComponent(point,ChessColor.WHITE,'n');
                        break;
                    case 'B':
                        chessComponents[i][t] = new BishopChessComponent(point,ChessColor.BLACK,'B');
                        break;
                    case 'b':
                        chessComponents[i][t] = new BishopChessComponent(point,ChessColor.WHITE,'b');
                        break;
                    case 'Q':
                        chessComponents[i][t] = new QueenChessComponent(point,ChessColor.BLACK,'Q');
                        break;
                    case 'q':
                        chessComponents[i][t] = new QueenChessComponent(point,ChessColor.WHITE,'q');
                        break;
                    case 'K':
                        chessComponents[i][t] = new KingChessComponent(point,ChessColor.BLACK,'K');
                        break;
                    case 'k':
                        chessComponents[i][t] = new KingChessComponent(point,ChessColor.WHITE,'k');
                        break;
                    case 'P':
                        chessComponents[i][t] = new PawnChessComponent(point,ChessColor.BLACK,'P');
                        break;
                    case 'p':
                        chessComponents[i][t] = new PawnChessComponent(point,ChessColor.WHITE,'p');
                        break;
                    case '_':
                        chessComponents[i][t] = new EmptySlotComponent(point,null,'_');
                        break;
                    default:
                        chessComponents[i][t] = new EmptySlotComponent(point,null,'_');
                        break;
                }
            }
        }

        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer = ChessColor.WHITE;
        }
        else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < 8 ; i++){
            for(int t = 0 ; t < 8 ; t++){
                if(chessComponents[i][t] instanceof EmptySlotComponent){
                    str.append('_');
                }
                else{
                    if(chessComponents[i][t].getChessColor() == ChessColor.WHITE){
                        if(chessComponents[i][t] instanceof RookChessComponent){
                            str.append('r');
                        }
                        else if(chessComponents[i][t] instanceof BishopChessComponent){
                            str.append('b');
                        }
                        else if(chessComponents[i][t] instanceof KnightChessComponent){
                            str.append('n');
                        }
                        else if(chessComponents[i][t] instanceof KingChessComponent){
                            str.append('k');
                        }
                        else if(chessComponents[i][t] instanceof QueenChessComponent){
                            str.append('q');
                        }
                        else if(chessComponents[i][t] instanceof PawnChessComponent){
                            str.append('p');
                        }
                    }
                    else{
                        if(chessComponents[i][t] instanceof RookChessComponent){
                            str.append('R');
                        }
                        else if(chessComponents[i][t] instanceof BishopChessComponent){
                            str.append('B');
                        }
                        else if(chessComponents[i][t] instanceof KnightChessComponent){
                            str.append('N');
                        }
                        else if(chessComponents[i][t] instanceof KingChessComponent){
                            str.append('K');
                        }
                        else if(chessComponents[i][t] instanceof QueenChessComponent){
                            str.append('Q');
                        }
                        else if(chessComponents[i][t] instanceof PawnChessComponent){
                            str.append('P');
                        }
                    }
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        for(int i = 0 ; i < 8 ; i++){
            for(int t = 0 ; t < 8 ; t++){
                if(chessComponents[i][t] instanceof EmptySlotComponent){
                    //
                }
                else{
                    if(chessComponents[i][t].getChessColor()==player){
                        if(chessComponents[i][t] instanceof KingChessComponent){
                            king--;
                        }
                        else if(chessComponents[i][t] instanceof QueenChessComponent){
                            queen--;
                        }
                        else if(chessComponents[i][t] instanceof RookChessComponent){
                            rook--;
                        }
                        else if(chessComponents[i][t] instanceof BishopChessComponent){
                            bishop--;
                        }
                        else if(chessComponents[i][t] instanceof KnightChessComponent){
                            knight--;
                        }
                        else if(chessComponents[i][t] instanceof PawnChessComponent){
                            pawn--;
                        }
                    }
                }
            }
        }
        if(player==ChessColor.WHITE){
            if(king!=0){
                str.append(String.format("k %d\n",king));
            }
            if(queen!=0){
                str.append(String.format("q %d\n",queen));
            }
            if(rook!=0){
                str.append(String.format("r %d\n",rook));
            }
            if(bishop!=0){
                str.append(String.format("b %d\n",bishop));
            }
            if(knight!=0){
                str.append(String.format("n %d\n",knight));
            }
            if(pawn!=0){
                str.append(String.format("p %d\n",pawn));
            }
        }
        else{
            if(king!=0){
                str.append(String.format("K %d\n",king));
            }
            if(queen!=0){
                str.append(String.format("Q %d\n",queen));
            }
            if(rook!=0){
                str.append(String.format("R %d\n",rook));
            }
            if(bishop!=0){
                str.append(String.format("B %d\n",bishop));
            }
            if(knight!=0){
                str.append(String.format("N %d\n",knight));
            }
            if(pawn!=0){
                str.append(String.format("P %d\n",pawn));
            }
        }
        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if((targetX<0)||
                (targetX>7)||
                (targetY<0)||
                (targetY>7)){
            return false;
        }
        chessComponents[sourceX][sourceY].setChessComponents(this.chessComponents);
        chessComponents[targetX][targetY].setChessComponents(this.chessComponents);
        if(chessComponents[sourceX][sourceY] instanceof EmptySlotComponent){
            return false;
        }
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        if((sourceX==targetX)&&(sourceY==targetY)){
            return false;
        }

        for(int i = 0 ; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i ++){
            if((chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX)&&
            ((chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY))){
                chessComponents[sourceX][sourceY].changetopoint(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),null,'_');
                if(currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                else{
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }
}
