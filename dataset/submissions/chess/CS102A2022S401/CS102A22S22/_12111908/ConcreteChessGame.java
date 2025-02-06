
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder tmp = new StringBuilder();
        for(int i = 0;i <= 7;i++){
            for(int j = 0;j<= 7;j++){
                tmp.append(chessComponents[i][j].name);
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder ans = new StringBuilder();
        Map<Character,Integer> ExistChess = new HashMap<>();
        for(int i = 0;i <= 7;i++){
            for(int j = 0;j<= 7;j++){
                if(chessComponents[i][j].getChessColor() == player) {
                    if(ExistChess.containsKey(chessComponents[i][j].name)) ExistChess.replace(chessComponents[i][j].name,ExistChess.get(chessComponents[i][j].getName())+1);
                    else ExistChess.put(chessComponents[i][j].name,1);
                }
            }
        }
        if(player == ChessColor.BLACK){
            if(ExistChess.getOrDefault('K',0) != 1){
                ans.append('K');ans.append(' ');ans.append(1-ExistChess.getOrDefault('K',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('Q',0) != 1){
                ans.append('Q');ans.append(' ');ans.append(1-ExistChess.getOrDefault('Q',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('R',0) != 2){
                ans.append('R');ans.append(' ');ans.append(2-ExistChess.getOrDefault('R',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('B',0) != 2){
                ans.append('B');ans.append(' ');ans.append(2-ExistChess.getOrDefault('B',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('N',0) != 2){
                ans.append('N');ans.append(' ');ans.append(2-ExistChess.getOrDefault('N',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('P',0) != 8){
                ans.append('P');ans.append(' ');ans.append(8-ExistChess.getOrDefault('P',0));ans.append('\n');
            }
        }else {
            if(ExistChess.getOrDefault('k',0) != 1){
                ans.append('k');ans.append(' ');ans.append(1-ExistChess.getOrDefault('k',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('q',0) != 1){
                ans.append('q');ans.append(' ');ans.append(1-ExistChess.getOrDefault('q',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('r',0) != 2){
                ans.append('r');ans.append(' ');ans.append(2-ExistChess.getOrDefault('r',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('b',0) != 2){
                ans.append('b');ans.append(' ');ans.append(2-ExistChess.getOrDefault('b',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('n',0) != 2){
                ans.append('n');ans.append(' ');ans.append(2-ExistChess.getOrDefault('n',0));ans.append('\n');
            }
            if(ExistChess.getOrDefault('p',0) != 8){
                ans.append('p');ans.append(' ');ans.append(8-ExistChess.getOrDefault('p',0));ans.append('\n');
            }
        }
        return ans.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(),source.getY()).canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ArrayList<ChessboardPoint> PointCanMove = (ArrayList<ChessboardPoint>) getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        ChessboardPoint canMove = null;
        for(int i = 0;i <= PointCanMove.size();i++){
            int x = PointCanMove.get(i).getX(),y = PointCanMove.get(i).getY();
            if(x == targetX && y == targetY){
                canMove = PointCanMove.get(i);
                break;
            }
        }
        if(canMove != null){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(canMove);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
            return true;
        }else return false;
    }

    public void loadChessGame(List<String> chessboard){
        for(int i = 0;i <= 7;i++){
            char[] tmp = chessboard.get(i).toCharArray();
            for(int j = 0;j <= 7;j++){
                switch (tmp[j]){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(i,j,ChessColor.BLACK,tmp[j]);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(i,j,ChessColor.WHITE,tmp[j]);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(i,j);
                        break;
                }
            }

        }
        if(chessboard.get(8).equals("w")) currentPlayer = ChessColor.WHITE;
        else if(chessboard.get(8).equals("b")) currentPlayer = ChessColor.BLACK;
    }
}
