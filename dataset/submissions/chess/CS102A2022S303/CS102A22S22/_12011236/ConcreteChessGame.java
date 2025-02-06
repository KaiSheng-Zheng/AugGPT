import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    private static ChessComponent[][] chessBoard;

    public ConcreteChessGame() {
        currentPlayer = ChessColor.WHITE;
        chessComponents = new ChessComponent[8][8];
        chessBoard = chessComponents;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
        chessBoard = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, 'R');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, 'N');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, 'B');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, 'Q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, 'K');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, 'P');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, 'r');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, 'n');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, 'b');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, 'q');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, 'k');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, '_');
                        break;
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
            if (chessboard.get(chessboard.size() - 1).charAt(0) == 'b') {
                currentPlayer = ChessColor.BLACK;
            }
        }
        chessBoard = chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char chess = chessComponents[i][j].name;
                stringBuilder.append(chess);
            }
        }
        String chessboardGraph = stringBuilder.toString();
       return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",chessboardGraph.substring(0,8),chessboardGraph.substring(8,16),chessboardGraph.substring(16,24),chessboardGraph.substring(24,32),chessboardGraph.substring(32,40),chessboardGraph.substring(40,48),chessboardGraph.substring(48,56),chessboardGraph.substring(56,64));
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String number = "";
        switch (player){
            case WHITE:
                if (!Objects.equals(getNumberOfChess('k', 0, numberOfChess('k')), "")){
                    number =number+ getNumberOfChess('k', 0, numberOfChess('k')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('q', 1, numberOfChess('q')), "")){
                    number =number+ getNumberOfChess('q', 1, numberOfChess('q')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('r', 2, numberOfChess('r')), "")){
                    number =number+ getNumberOfChess('r', 2, numberOfChess('r')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('b', 3, numberOfChess('b')), "")){
                    number =number+ getNumberOfChess('b', 3, numberOfChess('b')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('n', 4, numberOfChess('n')), "")){
                    number =number+ getNumberOfChess('n', 4, numberOfChess('n')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('p', 5, numberOfChess('p')), "")){
                    number =number+ getNumberOfChess('p', 5, numberOfChess('p')) + "\n";
                }
                break;
            case BLACK:
                if (!Objects.equals(getNumberOfChess('K', 0, numberOfChess('K')), "")){
                    number =number+ getNumberOfChess('K', 0, numberOfChess('K')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('Q', 1, numberOfChess('Q')), "")){
                    number =number+ getNumberOfChess('Q', 1, numberOfChess('Q')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('R', 2, numberOfChess('R')), "")){
                    number =number+ getNumberOfChess('R', 2, numberOfChess('R')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('B', 3, numberOfChess('B')), "")){
                    number =number+ getNumberOfChess('B', 3, numberOfChess('B')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('N', 4, numberOfChess('N')), "")){
                    number =number+ getNumberOfChess('N', 4, numberOfChess('N')) + "\n";
                }
                if (!Objects.equals(getNumberOfChess('P', 5, numberOfChess('P')), "")){
                    number =number+ getNumberOfChess('P', 5, numberOfChess('P')) + "\n";
                }
                break;
        }
        return number;
    }

    private int numberOfChess(char requestChess){
        int number = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name==requestChess){
                    number++;
                }
            }
        }
        return number;
    }

    private String getNumberOfChess(char chess, int index,int numberOfChess){
        int totalNumberOfChess=0;
        if (!(index>=0&&index<=5)){
            return "";
        }
        if (index<2){
            totalNumberOfChess=1;
        }
        if (index>=2&&index<=4){
            totalNumberOfChess=2;
        }
        if (index==5){
            totalNumberOfChess=8;
        }
        if (totalNumberOfChess-numberOfChess!=0){
            return String.format("%s %d",chess,totalNumberOfChess-numberOfChess);
        }else {
            return "";
        }
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if (canMovePoints!=null){
            Collections.sort(canMovePoints);
        }
        return canMovePoints;
    }

    public  void printCanMovePoints(List<ChessboardPoint> list){
        for (ChessboardPoint p:list) {
            System.out.println("[" + p.getX()+","+p.getY()+"]");
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        if (chess.getChessColor()!=currentPlayer){
            return false;
        }
        if (chess.canMoveTo().size()==0){
            return false;
        }
        if (!isContain(target, chess.canMoveTo())){
            return false;
        }
        chess.updateIsMoved();
        chessComponents[targetX][targetY] = chess;
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,'_');
        chess.setSource(new ChessboardPoint(targetX,targetY));
        currentPlayer = currentPlayer==ChessColor.WHITE? ChessColor.BLACK:ChessColor.WHITE;
        chessBoard = chessComponents;
        return true;
    }

    public static boolean isContain(ChessboardPoint point, List<ChessboardPoint> list){
        for (ChessboardPoint p:list) {
            if (point.getX() == p.getX()&&point.getY()==p.getY()){
                return true;
            }
        }
        return false;
    }

    public static ChessComponent[][] getChessBoard() {
        return chessBoard;
    }
}
