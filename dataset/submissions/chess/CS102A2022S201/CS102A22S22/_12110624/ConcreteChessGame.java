import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                ChessboardPoint p = new ChessboardPoint(i, j);
                switch(chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(p, ChessColor.BLACK, 'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(p, ChessColor.WHITE, 'r');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(p, ChessColor.BLACK, 'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(p, ChessColor.WHITE, 'n');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(p, ChessColor.BLACK, 'B');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(p, ChessColor.WHITE, 'b');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(p, ChessColor.BLACK, 'Q');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(p, ChessColor.WHITE, 'q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(p, ChessColor.BLACK, 'K');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(p, ChessColor.WHITE, 'k');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(p, ChessColor.BLACK, 'P');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(p, ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(p, ChessColor.NONE, '_');
                        break;
                }
            }
        }
        for(ChessComponent[] a : chessComponents){
            for(ChessComponent b : a){
                b.setChessboard(this);
            }
        }
        currentPlayer = (chessboard.get(8).equals("b"))? ChessColor.BLACK : ChessColor.WHITE;
    }
    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for(ChessComponent[] c : chessComponents){
                str.append(c[0].toString()).append(c[1].toString()).append(c[2].toString()).append(c[3].toString())
                        .append(c[4].toString()).append(c[5].toString()).append(c[6].toString()).append(c[7].toString())
                        .append("\n");
        }
        return str.toString();
    }
    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getChessColor() == player){
                    str.append(chessComponents[i][j].toString().toLowerCase());
                }
            }
        }
        int[] counter = {1, 1, 2, 2, 2, 8};
        String[] chess = {"k", "q", "r", "b", "n", "p"};
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < 6; i++){
            while(str.indexOf(chess[i])!=-1){
                counter[i]--;
                str.deleteCharAt(str.indexOf(chess[i]));
            }
            if(counter[i] > 0){
                if(player == ChessColor.BLACK)
                    out.append(chess[i].toUpperCase()).append(" ").append(String.valueOf(counter[i])).append("\n");
                else
                    out.append(chess[i]).append(" ").append(String.valueOf(counter[i])).append("\n");
            }
        }
        return out.toString();
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint p = new ChessboardPoint(targetX, targetY);//System.out.println(getChess(sourceX, sourceY).canMoveTo());
        if(getChess(sourceX, sourceY).getChessColor() == currentPlayer && haveMovePoint(getChess(sourceX, sourceY).canMoveTo(), p)){
            ChessComponent chess1 = getChess(sourceX, sourceY), chess2 = getChess(targetX,targetY);
            //System.out.println(chess1);System.out.println(chess2);
            chess1.changePoint(targetX,targetY);
            chessComponents[targetX][targetY] = chess1;
            if(chess2.getChessColor() != ChessColor.NONE){
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),
                        ChessColor.NONE, '_');
            }
            else{
                chess2.changePoint(sourceX,sourceY);
                chessComponents[sourceX][sourceY] = chess2;
            }
            currentPlayer = (currentPlayer == ChessColor.BLACK)? ChessColor.WHITE : ChessColor.BLACK;
            return true;
        }else
            return false;

    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = new ArrayList<>(getChess(source.getX(), source.getY()).canMoveTo());
        for(int i = canMovePoints.size()-1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    ChessboardPoint p = canMovePoints.get(j+1);
                    canMovePoints.set(j+1,canMovePoints.get(j));
                    canMovePoints.set(j, p);
                }
                else if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()){
                    if(canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                        ChessboardPoint p = canMovePoints.get(j+1);
                        canMovePoints.set(j+1,canMovePoints.get(j));
                        canMovePoints.set(j, p);
                    }
                }
            }
        }
        return canMovePoints;
    }

    public boolean haveMovePoint(List<ChessboardPoint> chessboardPoints, ChessboardPoint p){
        for(ChessboardPoint c : chessboardPoints){
            if(c.getX() == p.getX() && c.getY() == p.getY()){
                return true;
            }
        }
        return false;
    }
}
