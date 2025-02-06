import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                }
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].setChessGame(ConcreteChessGame.this);
            }
        }
        if (chessboard.get(8).charAt(0) == 'b'){
            this.currentPlayer = ChessColor.BLACK;
        }else if(chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }else {this.currentPlayer = ChessColor.NONE;}
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
        StringBuilder s = new StringBuilder();
        for (int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                s.append(chessComponents[i][j].getName());
            }
            if(i < 7){
                s.append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder sb = new StringBuilder();
        int R = 0;int N = 0;int B = 0;int Q = 0;int K = 0;int P = 0;
        int r = 0;int n = 0;int b = 0;int q = 0;int k = 0;int p = 0;
        for (int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                if(chessComponents[i][j].getName() == 'R'){
                    R++;
                }else if(chessComponents[i][j].getName() == 'N'){
                    N++;
                }else if(chessComponents[i][j].getName() == 'B'){
                    B++;
                }else if(chessComponents[i][j].getName() == 'Q'){
                    Q++;
                }else if(chessComponents[i][j].getName() == 'K'){
                    K++;
                }else if(chessComponents[i][j].getName() == 'P'){
                    P++;
                }else if(chessComponents[i][j].getName() == 'r'){
                    r++;
                }else if(chessComponents[i][j].getName() == 'n'){
                    n++;
                }else if(chessComponents[i][j].getName() == 'b'){
                    b++;
                }else if(chessComponents[i][j].getName() == 'q'){
                    q++;
                }else if(chessComponents[i][j].getName() == 'k'){
                    k++;
                }else if(chessComponents[i][j].getName() == 'p'){
                    p++;
                }
            }
        }
        if(player == ChessColor.BLACK) {
            if (K < 1) {
                sb.append("K ").append(1 - K).append("\n");
            }
            if (Q < 1) {
                sb.append("Q ").append(1 - Q).append("\n");
            }
            if (R < 2) {
                sb.append("R ").append(2 - R).append("\n");
            }
            if (B < 2) {
                sb.append("B ").append(2 - B).append("\n");
            }
            if (N < 2) {
                sb.append("N ").append(2 - N).append("\n");
            }
            if (P < 8) {
                sb.append("P ").append(8 - P).append("\n");
            }
        }else if(player == ChessColor.WHITE) {
            if (k < 1) {
                sb.append("k ").append(1 - k).append("\n");
            }
            if (q < 1) {
                sb.append("q ").append(1 - q).append("\n");
            }
            if (r < 2) {
                sb.append("r ").append(2 - r).append("\n");
            }
            if (b < 2) {
                sb.append("b ").append(2 - b).append("\n");
            }
            if (n < 2) {
                sb.append("n ").append(2 - n).append("\n");
            }
            if (p < 8) {
                sb.append("p ").append(8 - p).append("\n");
            }
        }
        return sb.toString();
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
            List<ChessboardPoint> moveChess = chessComponents[sourceX][sourceY].canMoveTo();
            for (ChessboardPoint point : moveChess){
                if (targetX == point.getX() && targetY == point.getY()){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                     ChessboardPoint c = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY].setSource(c);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    ChessboardPoint d = new ChessboardPoint(sourceX,sourceY);
                    chessComponents[sourceX][sourceY].setSource(d);
                   if(currentPlayer == ChessColor.BLACK){
                       this.currentPlayer = ChessColor.WHITE;
                   }else {
                       this.currentPlayer = ChessColor.BLACK;
                   }
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

}
