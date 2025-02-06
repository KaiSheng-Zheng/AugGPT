import java.util.*;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private HashMap<Character, Integer> hashMap;
    char[] black_str = new char[] {'K', 'Q', 'R', 'B', 'N', 'P'};
    char[] white_str = new char[] {'k', 'q', 'r', 'b', 'n', 'p'};
    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        hashMap = new HashMap<>();
        hashMap.put('K', 0);
        hashMap.put('Q', 1);
        hashMap.put('R', 2);
        hashMap.put('B', 3);
        hashMap.put('N', 4);
        hashMap.put('P', 5);
        hashMap.put('k', 0);
        hashMap.put('q', 1);
        hashMap.put('r', 2);
        hashMap.put('b', 3);
        hashMap.put('n', 4);
        hashMap.put('p', 5);
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int x = 0; x < chessboard.size() - 1; x++) {
            String str = chessboard.get(x);
            for (int y = 0; y < str.length(); y++) {
                char c = str.charAt(y);
                ChessComponent chessComponent = null;
                if (c >= 'A' && c <= 'Z') {
                    if (c == 'R') chessComponent = new RookChessComponent();
                    if (c == 'N') chessComponent = new KnightChessComponent();
                    if (c == 'B') chessComponent = new BishopChessComponentz();
                    if (c == 'Q') chessComponent = new QueenChessComponent();
                    if (c == 'K') chessComponent = new KingChessComponent();
                    if (c == 'P') chessComponent = new PawnChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (c >= 'a' && c <= 'z') {
                    if (c == 'r') chessComponent = new RookChessComponent();
                    if (c == 'n') chessComponent = new KnightChessComponent();
                    if (c == 'b') chessComponent = new BishopChessComponentz();
                    if (c == 'q') chessComponent = new QueenChessComponent();
                    if (c == 'k') chessComponent = new KingChessComponent();
                    if (c == 'p') chessComponent = new PawnChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (c == '_'){
                    chessComponent = new EmptySlotComponent();
                    chessComponent.setChessColor(ChessColor.NONE);
                }
                chessComponent.setName(c);
                chessComponent.setSource(new ChessboardPoint(x, y));
                chessComponents[x][y] = chessComponent;
                chessComponents[x][y].setChessComponents(chessComponents);
            }
        }
        String str = chessboard.get(8);
        if (str.equals("w")) currentPlayer = ChessColor.WHITE;
        else currentPlayer = ChessColor.BLACK;
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
        String ans = "";
        for (int x = 0; x < chessComponents.length; x++) {
            for (int y = 0; y < chessComponents[x].length; y++) {
                ans += chessComponents[x][y].getName();
            }
            ans += "\n";
        }
        return ans;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] vis = new int[]{1, 1, 2, 2, 2, 8};

        for (int x = 0; x < chessComponents.length; x++) {
            for (int y = 0; y < chessComponents[x].length; y++) {
                char c = chessComponents[x][y].getName();

                if (c == '_')continue;;
                if (player.equals(ChessColor.WHITE) && c >= 'A' && c <= 'Z') continue;
                if (player.equals(ChessColor.BLACK) && c >= 'a' && c <= 'z') continue;
                int idx = hashMap.get(c);
                vis[idx]--;
            }

        }
        String ans = "";
        if (player.equals(ChessColor.BLACK)) {
            for (int i = 0; i < vis.length; i++) {
                if (vis[i] == 0) continue;
                ans += black_str[i] + " " + vis[i] + "\n";
            }
        } else {
            for (int i = 0; i < vis.length; i++) {
                if (vis[i] == 0) continue;
                ans += white_str[i] + " " + vis[i] + "\n";
            }
        }
        return ans;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> ans = new ArrayList<>();
        if (source.getY() >= 8 || source.getY() < 0) return ans;
        if (source.getX() >= 8 || source.getX() < 0) return ans;
        ChessComponent sourceChess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> chessboardPoints = sourceChess.canMoveTo();
        Collections.sort(chessboardPoints);
        return chessboardPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX >= 8 || sourceX < 0) return false;
        if (sourceY >= 8 || sourceY < 0) return false;
        if (targetX >= 8 || targetX < 0) return false;
        if (targetY >= 8 || targetY < 0) return false;


        ChessComponent sourceChess = this.getChess(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        if (!currentPlayer.name().equals(sourceChess.getChessColor().name())) return false;

        boolean ok = sourceChess.canMoveTo(target);
        if (!ok) return ok;

        EmptySlotComponent emptySlotComponent = new EmptySlotComponent();
        emptySlotComponent.setName('_');
        emptySlotComponent.setChessColor(ChessColor.NONE);
        emptySlotComponent.setChessComponents(chessComponents);
        emptySlotComponent.setSource(new ChessboardPoint(sourceX, sourceY));

        sourceChess.setSource(new ChessboardPoint(targetX, targetY));

        chessComponents[targetX][targetY] = sourceChess;
        chessComponents[sourceX][sourceY] = emptySlotComponent;


        if (currentPlayer.name().equals("WHITE")) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
        }
        return true;
    }
    public static void main(String[] args) {
        ConcreteChessGame concreteChessGame = new ConcreteChessGame();
        ArrayList<String> list = new ArrayList<>();
        list.add("RNBQKBNR");
        list.add("________");
        list.add("________");
        list.add("________");
        list.add("________");
        list.add("___q__n_");
        list.add("________");
//        list.add("pppppppp");
        list.add("r_b_kb_r");
        list.add("w");
        concreteChessGame.loadChessGame(list);
//        List<ChessboardPoint> list1 = concreteChessGame.getCanMovePoints(new ChessboardPoint(7, 4));
//        for (ChessboardPoint c: list1) {
//            System.out.println(c);
//        }
        concreteChessGame.moveChess(5, 6, 6, 4);
        concreteChessGame.moveChess(0, 0, 1, 0);
        concreteChessGame.moveChess(6, 4, 5, 6);
        concreteChessGame.getCanMovePoints(new ChessboardPoint(6, 4));
        concreteChessGame.getChessboardGraph();
    }
}
