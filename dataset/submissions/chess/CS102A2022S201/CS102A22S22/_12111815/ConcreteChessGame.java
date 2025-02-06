import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0;i < 8;i++){
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        break;
                }
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].setChessGame(ConcreteChessGame.this);
            }
        }
        if (chessboard.get(8).charAt(0) == 'b'){
            this.currentPlayer = ChessColor.BLACK;
        }else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < 8;i++) {
            for (int j = 0;j < 8;j++){
                builder.append(chessComponents[i][j].getName());
                if (i != 7 && j == 7){
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        if (player == ChessColor.BLACK){
            hashMap.put('K',1);
            hashMap.put('Q',1);
            hashMap.put('R',2);
            hashMap.put('B',2);
            hashMap.put('N',2);
            hashMap.put('P',8);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        hashMap.replace(chessComponents[i][j].name,hashMap.get(chessComponents[i][j].name) - 1);
                    }
                }
            }
            if (hashMap.get('K') != 0){
                builder.append("K ").append(hashMap.get('K')).append("\n");
            }
            if (hashMap.get('Q') != 0){
                builder.append("Q ").append(hashMap.get('Q')).append("\n");
            }
            if (hashMap.get('R') != 0){
                builder.append("R ").append(hashMap.get('R')).append("\n");
            }
            if (hashMap.get('B') != 0){
                builder.append("B ").append(hashMap.get('B')).append("\n");
            }
            if (hashMap.get('N') != 0){
                builder.append("N ").append(hashMap.get('N')).append("\n");
            }
            if (hashMap.get('P') != 0){
                builder.append("P ").append(hashMap.get('P')).append("\n");
            }
        }else {
            hashMap.put('k',1);
            hashMap.put('q',1);
            hashMap.put('r',2);
            hashMap.put('b',2);
            hashMap.put('n',2);
            hashMap.put('p',8);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                        hashMap.replace(chessComponents[i][j].name,hashMap.get(chessComponents[i][j].name) - 1);
                    }
                }
            }
            if (hashMap.get('k') != 0){
                builder.append("k ").append(hashMap.get('k')).append("\n");
            }
            if (hashMap.get('q') != 0){
                builder.append("q ").append(hashMap.get('q')).append("\n");
            }
            if (hashMap.get('r') != 0){
                builder.append("r ").append(hashMap.get('r')).append("\n");
            }
            if (hashMap.get('b') != 0){
                builder.append("b ").append(hashMap.get('b')).append("\n");
            }
            if (hashMap.get('n') != 0){
                builder.append("n ").append(hashMap.get('n')).append("\n");
            }
            if (hashMap.get('p') != 0){
                builder.append("p ").append(hashMap.get('p')).append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> list = getChess(source.getX(),source.getY()).canMoveTo();
        list.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint point1, ChessboardPoint point2) {
                return point1.getX() == point2.getX() ? Integer.compare(point1.getY(),point2.getY()) : Integer.compare(point1.getX(),point2.getX());
            }
        });
        return list;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            List<ChessboardPoint> list = chessComponents[sourceX][sourceY].canMoveTo();
            for (ChessboardPoint point : list){
                if (targetX == point.getX() && targetY == point.getY()){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    setCurrentPlayer(currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK);
                    return true;
                }
            }
        }
        return false;
    }
}