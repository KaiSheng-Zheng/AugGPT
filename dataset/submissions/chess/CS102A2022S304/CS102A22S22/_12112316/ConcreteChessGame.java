import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R': case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case 'Q': case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case 'N': case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case 'B': case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case 'K': case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case 'P': case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                        break;
                }
            }
        }
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buffer.append(chessComponents[i][j].getName());
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
    public String getCapturedChess(ChessColor player){
        int[] cap = new int[]{1, 1, 2, 2, 2, 8};
        String str = "KQRBNP";
        if(player.equals(ChessColor.WHITE)){
            str = str.toLowerCase();
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 6; k++){
                    if(chessComponents[i][j].getName() == str.charAt(k)){
                        cap[k]--;
                    }
                }
            }
        }
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i< 6; i++){
            if(cap[i] != 0){
                buffer.append(str.charAt(i));
                buffer.append(' ');
                buffer.append(cap[i]);
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        chess.setChessboard(chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor().equals(getCurrentPlayer())){
            List<ChessboardPoint> canMovePoints = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
            for (int i = 0; i < canMovePoints.size(); i++) {
                if(canMovePoints.get(i).getX() == targetX && canMovePoints.get(i).getY() == targetY){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY), '_');
                    if(getCurrentPlayer().equals(ChessColor.WHITE)){
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}