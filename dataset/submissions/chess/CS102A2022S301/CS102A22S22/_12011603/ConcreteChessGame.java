import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[chessboard.size()-1][chessboard.get(0).length()];
        if (chessboard.get(chessboard.size()-1).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < chessboard.size()-1; i++){
            for (int j = 0; j < chessboard.get(i).length(); j++){
                char c = chessboard.get(i).charAt(j);
                if (c == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j));
                }else if (Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                    if (c == 'p'){
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }
                    else if (c == 'r'){
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }else if (c == 'n'){
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }else if (c == 'b'){
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }else if (c == 'k'){
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }else if (c == 'q'){
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                    }
                }else {
                    if (c == 'p'){
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }
                    else if (c == 'r'){
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }else if (c == 'n'){
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }else if (c == 'b'){
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }else if (c == 'k'){
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }else if (c == 'q'){
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                    }
                }
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
                chessComponents[i][j].setArray(chessComponents);
            }
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++){
            if (i != 0){
                stringBuilder.append("\n");
            }
            for (int j = 0; j < chessComponents[i].length; j++){
                stringBuilder.append(chessComponents[i][j].name);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK){
            int []cnt = {1,1,2,2,2,8};
            char []name = {'K', 'Q', 'R', 'B', 'N', 'P'};
            for (int i = 0; i < chessComponents.length; i++){
                for (int j = 0; j < chessComponents[i].length; j++){
                    for (int k = 0; k < cnt.length; k++){
                        if (name[k] == chessComponents[i][j].name){
                            cnt[k] -= 1;
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cnt.length; i++){
                if (cnt[i] != 0){
                    stringBuilder.append(name[i]+" " + cnt[i] + "\n");
                }
            }
            return stringBuilder.toString();
        }else {
            int []cnt = {1,1,2,2,2,8};
            char []name = {'k', 'q', 'r', 'b', 'n', 'p'};
            for (int i = 0; i < chessComponents.length; i++){
                for (int j = 0; j < chessComponents[i].length; j++){
                    for (int k = 0; k < cnt.length; k++){
                        if (name[k] == chessComponents[i][j].name){
                            cnt[k] -= 1;
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cnt.length; i++){
                if (cnt[i] != 0){
                    stringBuilder.append(name[i]+" " + cnt[i] + "\n");
                }
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            return false;
        }
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        for (ChessboardPoint point:chessboardPoints){
            if (point.getX() == targetX && point.getY() == targetY){
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].name = chessComponents[sourceX][sourceY].name;
                chessComponents[sourceX][sourceY].name = '_';
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                if (currentPlayer == ChessColor.BLACK){
                    currentPlayer = ChessColor.WHITE;
                }else {
                    currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> canMovePoints = chessComponents[x][y].canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }
}
