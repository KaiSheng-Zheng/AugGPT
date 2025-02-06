import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++){
            String temps = chessboard.get(i);
            for (int j = 0; j < 8; j++){
                switch (temps.charAt(j)){
                    case '_' -> {
                        chessComponents[i][j] = new EmptySlotComponent(i,j);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'K' ->{
                        chessComponents[i][j] = new KingChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'Q' -> {
                        chessComponents[i][j] = new QueenChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'R' -> {
                        chessComponents[i][j] = new RookChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'B' -> {
                        chessComponents[i][j] = new BishopChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'N' -> {
                        chessComponents[i][j] = new KnightChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'P' -> {
                        chessComponents[i][j] = new PawnChessComponent(i,j,false);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'k' -> {
                        chessComponents[i][j] = new KingChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'q' -> {
                        chessComponents[i][j] = new QueenChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'r' -> {
                        chessComponents[i][j] = new RookChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'b' -> {
                        chessComponents[i][j] = new BishopChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'n' -> {
                        chessComponents[i][j] = new KnightChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    case 'p' -> {
                        chessComponents[i][j] = new PawnChessComponent(i,j,true);
                        LocalData.setChess(i,j,chessComponents[i][j]);
                    }
                    default -> {}
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) currentPlayer = ChessColor.WHITE;
        else if (Objects.equals(chessboard.get(8), "b")) currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        chessComponents[x][y] = LocalData.getChess(x,y);
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ans.append(getChess(i,j).toString());
            }
            ans.append("\n");
        }
        return ans.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] cnt = new int[13];
        int[] tot = {0,1,1,2,2,2,8,1,1,2,2,2,8};
        char[] name = {'_','k','q','r','b','n','p','K','Q','R','B','N','P'};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) cnt[getChess(i,j).getId()]++;
        if (player.equals(ChessColor.WHITE)){
            for (int i = 1; i < 7; i++)
                if (tot[i] - cnt[i] > 0) ans.append(name[i]).append(" ").append(tot[i] - cnt[i]).append("\n");
        }
        else if (player.equals(ChessColor.BLACK)){
            for (int i = 7; i < 13; i++)
                if (tot[i] - cnt[i] > 0) ans.append(name[i]).append(" ").append(tot[i] - cnt[i]).append("\n");
        }
        return ans.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMoveTo = getChess(source.getX(),source.getY()).canMoveTo();
        int n = canMoveTo.size();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] number = new int[n];
        int temp;
        for (int i = 0; i < n; i++){
            number[i] = i;
            x[i] = canMoveTo.get(i).getX();
            y[i] = canMoveTo.get(i).getY();
        }
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (x[i] > x[j] || x[i] == x[j] && y[i] > y[j]){
                    temp = number[i]; number[i] = number[j]; number[j] = temp;
                }
            }
        }
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ans.add(canMoveTo.get(number[i]));
        }
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX,sourceY).getChessColor().equals(currentPlayer)){
            boolean found = false;
            List<ChessboardPoint> canMoveto = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
            for (int i = 0; i < canMoveto.size(); i++){
                if (canMoveto.get(i).getX() == targetX && canMoveto.get(i).getY() == targetY) found = true;
            }
            if (found){
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
                LocalData.setChess(sourceX,sourceY,chessComponents[sourceX][sourceY]);
                chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                getChess(sourceX,sourceY).setSource(new ChessboardPoint(targetX,targetY));
                LocalData.setChess(targetX,targetY,chessComponents[targetX][targetY]);
                currentPlayer = (currentPlayer.equals(ChessColor.BLACK)?ChessColor.WHITE:ChessColor.BLACK);
                return true;
            }
        }
        return false;
    }
}
