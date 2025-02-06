import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessComponents[i][j] = new EmptySlotComponent('_');
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                char name1 = chessboard.get(i).charAt(j);
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
                if (chessComponents[i][j].name == 'q' || chessComponents[i][j].name == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(name1);
                }else if (chessComponents[i][j].name == 'R' || chessComponents[i][j].name == 'r'){
                    chessComponents[i][j] = new RookChessComponent(name1);
                }else if (chessComponents[i][j].name == 'B' || chessComponents[i][j].name == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(name1);
                }else if (chessComponents[i][j].name == 'N' || chessComponents[i][j].name == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(name1);
                }else if (chessComponents[i][j].name == 'P' || chessComponents[i][j].name == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(name1);
                }else if (chessComponents[i][j].name == 'K' || chessComponents[i][j].name == 'k'){
                    chessComponents[i][j] = new KingChessComponent(name1);
                }else {
                    chessComponents[i][j] = new EmptySlotComponent(name1);
                }
                chessComponents[i][j].setSource(i, j);
                chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        currentPlayer = (chessboard.get(8).charAt(0) == 'w') ? ChessColor.WHITE : ChessColor.BLACK;
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
    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                graph.append(chessComponents[i][j]);
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int king = 1, queen = 1, rooks = 2, bishops = 2, knights = 2, pawns = 8;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (chessComponents[i][j].getChessColor() == player){
                    if (chessComponents[i][j] instanceof QueenChessComponent){
                        queen--;
                    }else if (chessComponents[i][j] instanceof RookChessComponent){
                        rooks--;
                    }else if (chessComponents[i][j] instanceof BishopChessComponent){
                        bishops--;
                    }else if (chessComponents[i][j] instanceof KnightChessComponent){
                        knights--;
                    }else if (chessComponents[i][j] instanceof PawnChessComponent){
                        pawns--;
                    }else if (chessComponents[i][j] instanceof KingChessComponent){
                        king--;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        char chess;
        if (king != 0){
            chess = (player == ChessColor.BLACK) ? 'K' : 'k';
            stringBuilder.append(chess).append(" ").append(king).append("\n");
        }
        if (queen != 0){
            chess = (player == ChessColor.BLACK) ? 'Q' : 'q';
            stringBuilder.append(chess).append(" ").append(queen).append("\n");
        }
        if (rooks != 0){
            chess = (player == ChessColor.BLACK) ? 'R' : 'r';
            stringBuilder.append(chess).append(" ").append(rooks).append("\n");
        }
        if (bishops != 0){
            chess = (player == ChessColor.BLACK) ? 'B' : 'b';
            stringBuilder.append(chess).append(" ").append(bishops).append("\n");
        }
        if (knights != 0){
            chess = (player == ChessColor.BLACK) ? 'N' : 'n';
            stringBuilder.append(chess).append(" ").append(knights).append("\n");
        }
        if (pawns != 0){
            chess = (player == ChessColor.BLACK) ? 'P' : 'p';
            stringBuilder.append(chess).append(" ").append(pawns).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent = chessComponents[source.getX()][source.getY()];
        return chessComponent.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean result = false;
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            List<ChessboardPoint> movable;
            movable = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));

            for (ChessboardPoint i : movable){
                if (i.getX() == targetX && i.getY() == targetY){
                    result = true;
                    currentPlayer = (currentPlayer == ChessColor.BLACK) ? ChessColor.WHITE : ChessColor.BLACK;
                    swapLocation(chessComponents[sourceX][sourceY], chessComponents[targetX][targetY]);
                    swapChessComponent(chessComponents[sourceX][sourceY], chessComponents[targetX][targetY]);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public void swapLocation(ChessComponent source, ChessComponent target) {
        ChessboardPoint chessboardPoint1 = source.getSource();
        ChessboardPoint chessboardPoint2 = target.getSource();
        source.setSource(chessboardPoint2.getX(), chessboardPoint2.getY());
        target.setSource(chessboardPoint1.getX(), chessboardPoint1.getY());
    }

    @Override
    public void swapChessComponent(ChessComponent chess1, ChessComponent chess2) {
        int row1 = chess1.getSource().getX(), col1 = chess1.getSource().getY();
        chessComponents[row1][col1] = chess1;
        int row2 = chess2.getSource().getX(), col2 = chess2.getSource().getY();
        chessComponents[row2][col2] = new EmptySlotComponent('_');
    }
}



