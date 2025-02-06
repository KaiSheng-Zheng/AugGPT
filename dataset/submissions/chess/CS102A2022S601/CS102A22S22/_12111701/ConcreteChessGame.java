import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = ChessComponent.chessComponents;
        this.currentPlayer = getCurrentPlayer();
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents.length; j++) {
                char type = chessboard.get(i).charAt(j);
                switch (type){
                    case 'R':{
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case 'N':{
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case 'B':{
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case 'Q':{
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case 'K':{
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case 'r':{
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'n':{
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'b':{
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'q':{
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'k':{
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'p':{
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,type);
                        break;
                    }
                    case 'P':{
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,type);
                        break;
                    }
                    case '_':{
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,type);
                        break;
                    }
                }
            }
        }
        String borw = chessboard.get(8);
        if (borw.equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else if(borw.equals("b")){
            currentPlayer = ChessColor.BLACK;
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
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents.length; j++) {
                str.append(chessComponents[i][j].getName());
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player == ChessColor.NONE){
            return null;
        }else{
            StringBuilder lost = new StringBuilder();
            char[] w = {'k','q','r','b','n','p'};
            char[] b = {'K','Q','R','B','N','P'};
            int[] total = {1,1,2,2,2,8};
            char[] test = new char[6];
            if(player == ChessColor.WHITE){
                test = w;
            } else if (player == ChessColor.BLACK) {
                test = b;
            }
            for (int k = 0; k < test.length; k++) {
                int num = 0;
                for (ChessComponent[] chessComponent : chessComponents) {
                    for (int j = 0; j < chessComponents.length; j++) {
                        if (chessComponent[j].getChessColor().equals(player) && chessComponent[j].getName() == test[k]) {
                            num++;
                        }
                    }
                }
                if (num == total[k]) {
                    continue;
                }
                lost.append(test[k]).append(" ").append(total[k] - num).append("\n");
            }
            return lost.toString();
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> points = getChess(source.getX(), source.getY()).canMoveTo();
        return points;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

}

