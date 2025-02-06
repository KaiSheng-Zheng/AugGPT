import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    private List<String> currentchessboard;
    private ChessComponent[][] chessComponents;
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        currentchessboard=chessboard;
        for (int i = 0;i < chessboard.size()-1;i++){
            for (int j = 0;j < 8;j++){
                if (Character.isUpperCase(chessboard.get(i).charAt(j))){
                    switch (chessboard.get(i).charAt(j)) {
                        case 'R' -> {
                            chessComponents[i][j] = new RookChessComponent(this);
                            chessComponents[i][j].setName('R');
                        }
                        case 'N' -> {
                            chessComponents[i][j] = new KnightChessComponent(this);
                            chessComponents[i][j].setName('N');
                        }
                        case 'B' -> {
                            chessComponents[i][j] = new BishopChessComponent(this);
                            chessComponents[i][j].setName('B');
                        }
                        case 'Q' -> {
                            chessComponents[i][j] = new QueenChessComponent(this);
                            chessComponents[i][j].setName('Q');
                        }
                        case 'K' -> {
                            chessComponents[i][j] = new KingChessComponent(this);
                            chessComponents[i][j].setName('K');
                        }
                        case 'P' -> {
                            chessComponents[i][j] = new PawnChessComponent(this);
                            chessComponents[i][j].setName('P');
                        }
                    }
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (Character.isLowerCase(chessboard.get(i).charAt(j))){
                    switch (chessboard.get(i).charAt(j)) {
                        case 'r' -> {
                            chessComponents[i][j] = new RookChessComponent(this);
                            chessComponents[i][j].setName('r');
                        }
                        case 'n' -> {
                            chessComponents[i][j] = new KnightChessComponent(this);
                            chessComponents[i][j].setName('n');
                        }
                        case 'b' -> {
                            chessComponents[i][j] = new BishopChessComponent(this);
                            chessComponents[i][j].setName('b');
                        }
                        case 'q' -> {
                            chessComponents[i][j] = new QueenChessComponent(this);
                            chessComponents[i][j].setName('q');
                        }
                        case 'k' -> {
                            chessComponents[i][j] = new KingChessComponent(this);
                            chessComponents[i][j].setName('k');
                        }
                        case 'p' -> {
                            chessComponents[i][j] = new PawnChessComponent(this);
                            chessComponents[i][j].setName('p');
                        }
                    }
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else {chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                chessComponents[i][j].setName('_');}
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
        }
        if (chessboard.get(8).equals("w") | chessboard.get(8).equals("W")){
            currentPlayer=ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b") | chessboard.get(8).equals("B")){
            currentPlayer=ChessColor.BLACK;
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
        StringBuilder out =new StringBuilder();
        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++){
                out.append(chessComponents[i][j].name);
            }
            out.append("\n");
        }
        return out.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        List<String> timedBoard =new ArrayList<>();
        for (int i=0;i<8;i++){
            StringBuilder sb =new StringBuilder();
            for (int j=0;j<8;j++){
                sb.append(chessComponents[i][j].name);
            }
            timedBoard.add(sb.toString());
        }

        String board = timedBoard.toString();
        char[] blackside = {'K', 'Q', 'R', 'B', 'N', 'P'};
        char[] whiteside = {'k', 'q', 'r', 'b', 'n', 'p'};
        int[] chessNum = new int[6];
        int[] chessNumShould = {1, 1, 2, 2, 2, 8};
        if (player == ChessColor.BLACK) {{
            for (int i = 0; i < board.length(); i++) {
                switch (board.charAt(i)) {
                    case 'K' -> chessNum[0]++;
                    case 'Q' -> chessNum[1]++;
                    case 'R' -> chessNum[2]++;
                    case 'B' -> chessNum[3]++;
                    case 'N' -> chessNum[4]++;
                    case 'P' -> chessNum[5]++;
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < chessNum.length; i++) {
            if (chessNum[i] != chessNumShould[i]) {
                out.append(blackside[i] + " ");
                out.append(chessNumShould[i] - chessNum[i]);
                out.append("\n");
            }
        }
        return out.toString();}


        else {
            if (player == ChessColor.WHITE){
                for (int i = 0;i < board.length();i++){
                    switch (board.charAt(i)) {
                        case 'k' -> chessNum[0]++;
                        case 'q' -> chessNum[1]++;
                        case 'r' -> chessNum[2]++;
                        case 'b' -> chessNum[3]++;
                        case 'n' -> chessNum[4]++;
                        case 'p' -> chessNum[5]++;
                    }
                }}
                StringBuilder out = new StringBuilder();
                for (int i =0;i<chessNum.length;i++) {
                    if (chessNum[i] != chessNumShould[i]) {
                        out.append(whiteside[i] + " ");
                        out.append(chessNumShould[i] - chessNum[i]);
                        out.append("\n");
                    }
                }
                return out.toString();}

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean canMove=false;
           boolean ok =false;
           for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
               if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX
               && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY){
                   ok=true;
               }
           }
           if (chessComponents[sourceX][sourceY].chessColor != currentPlayer){
               ok = false;
           }
            if (ok){
                canMove=true;
                char ininame = chessComponents[sourceX][sourceY].name;
                ChessColor ini = chessComponents[sourceX][sourceY].chessColor;

                if (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }
                if (chessComponents[sourceX][sourceY].chessColor == ChessColor.BLACK){
                    currentPlayer = ChessColor.WHITE;
                }

                switch (chessComponents[sourceX][sourceY].name) {
                    case 'R', 'r' -> chessComponents[targetX][targetY] = new RookChessComponent(this);
                    case 'B', 'b' -> chessComponents[targetX][targetY] = new BishopChessComponent(this);
                    case 'K', 'k' -> chessComponents[targetX][targetY] = new KingChessComponent(this);
                    case 'N', 'n' -> chessComponents[targetX][targetY] = new KnightChessComponent(this);
                    case 'P', 'p' -> chessComponents[targetX][targetY] = new PawnChessComponent(this);
                    case 'Q', 'q' -> chessComponents[targetX][targetY] = new QueenChessComponent(this);
                }

//                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();

                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));

                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY].setChessColor(ini);
                chessComponents[targetX][targetY].setName(ininame);

                StringBuilder newlineSource = new StringBuilder(currentchessboard.get(sourceX));
                newlineSource.replace(sourceY,sourceY,"_");
                currentchessboard.set(sourceX, newlineSource.toString());

                StringBuilder newlineTarget = new StringBuilder(currentchessboard.get(targetX));
                newlineTarget.replace(targetX,targetX,String.valueOf(ininame));
                currentchessboard.set(targetX,newlineTarget.toString());
            }

        return canMove;
    }

    public List<String> getCurrentchessboard() {
        return currentchessboard;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}
