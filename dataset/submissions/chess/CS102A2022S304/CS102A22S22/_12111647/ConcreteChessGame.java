import java.util.*;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

/**
 * @author root
 * @version 1.0
 */
public class ConcreteChessGame implements ChessGame {

    /**
     * A 2-dimension array to store all the chess components<br>
     * should be initialized in your construct method.<br>
     * i.e. = new ChessComponent[8][8]<br>
     */
    private ChessComponent[][] chessComponents;

    /**
     * What's the current player's color, black or white?<br>
     * should be initialized in your construct method.<br>
     * by default, set the color to white.<br>
     */
    private ChessColor currentPlayer;

    private static final Map<String, Long> CHESS_TOTAL = new LinkedHashMap();

    /**
     * Constructor
     */
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        CHESS_TOTAL.put("k", 1L);
        CHESS_TOTAL.put("q", 1L);
        CHESS_TOTAL.put("r", 2L);
        CHESS_TOTAL.put("b", 2L);
        CHESS_TOTAL.put("n", 2L);
        CHESS_TOTAL.put("p", 8L);
    }


    @Override
    public void loadChessGame(List<String> chessboard) {

        var color = chessboard.get(chessboard.size() - 1);
        this.currentPlayer = ChessColor.productionColor(color);
        var chessmanFactory = new ChessmanFactory();
        for (var i = 0; i < chessComponents.length; i++) {
            var row = chessboard.get(i);
            var ches = row.toCharArray();
            for (var j = 0; j < chessComponents.length; j++) {
                chessComponents[i][j] = chessmanFactory.productionChessman(ches[j], new ChessboardPoint(i, j)).setChessComponents(chessComponents);
            }
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

        return Arrays.stream(chessComponents)
                .map(s-> Arrays.stream(s)
                        .map(ChessComponent::toString)
                        .collect(joining()))
                .collect(joining("\n"));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        Stream<ChessComponent> chessComponentStream = Arrays.stream(chessComponents).flatMap(Arrays::stream);
        Map<String, Long> collect = chessComponentStream
                                    .filter(chess -> chess.getChessColor().equals(player))
                                    .collect(groupingBy(ChessComponent::toString, counting()));

        Iterator<Map.Entry<String, Long>> iterator = CHESS_TOTAL.entrySet().iterator();
        LinkedHashMap<String, Long> sortChess = new LinkedHashMap<>();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> next = iterator.next();
            String key;
            if (collect.containsKey(next.getKey())) {
                key = next.getKey();
            } else {
                key = next.getKey().toUpperCase(Locale.ROOT);
                if (!collect.containsKey(key)) {
                    sortChess.put(next.getKey(), next.getValue());
                    continue;
                }
            }
            if (next.getValue() - collect.get(key) > 0) {
                sortChess.put(key, next.getValue() - collect.get(key));
            }
        }
        return sortChess
                .entrySet()
                .stream()
                .map(chess -> (ChessColor.WHITE.equals(player)?chess.getKey():chess.getKey().toUpperCase(Locale.ROOT))+" "+chess.getValue())
                .collect(joining("\n"));
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (source.getX() < 0 || source.getY() < 0
            || source.getX() >= this.chessComponents.length || source.getY() >= this.chessComponents.length) {
            return new ArrayList<>();
        }
        // 1. find chess according to source
        var chess = chessComponents[source.getX()][source.getY()]
                                    .setChessComponents(this.chessComponents);
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceY < 0 || targetX < 0 || targetY < 0
            || sourceX >= this.chessComponents.length || sourceY >= this.chessComponents.length
            || targetX >= this.chessComponents.length || targetY >= this.chessComponents.length) {
            return false;
        }

        var chessComponent = chessComponents[sourceX][sourceY];
        if (!this.currentPlayer.equals(chessComponent.getChessColor())) {
            return false;
        }
        if (chessComponent.moveChess(sourceX, sourceY, targetX, targetY, this.chessComponents)) {

            chessComponents[targetX][targetY] = chessComponent.setSource(new ChessboardPoint(targetX, targetY)).setChessColor(chessComponents[sourceX][sourceY].getChessColor()).setName(chessComponents[sourceX][sourceY].getName());
            chessComponents[sourceX][sourceY] = new EmptySlotComponent().setSource(new ChessboardPoint(sourceX, sourceY)).setChessColor(ChessColor.NONE).setName('_');
            if (ChessColor.WHITE.equals(this.currentPlayer)) {
                this.currentPlayer = ChessColor.BLACK;
            } else {
                this.currentPlayer = ChessColor.WHITE;
            }
            return true;
        }
        return false;
    }


}

interface ChessGame {

    /**
     * This abstract method loads chess game from given chessboard
     * @param chessboard chessboard
     */
    public void loadChessGame(List<String> chessboard);

    /**
     * @return This abstract method returns the current player
     */
    public ChessColor getCurrentPlayer();

    /**
     * @param x x
     * @param y y
     * @return This abstract method returns the ChessComponent object in the given position
     */
    public ChessComponent getChess(int x, int y);

    /**
     * @return This abstract method returns the chessboard status.
     */
    public String getChessboardGraph();

    /**
     * @param player player
     * @return This abstract method returns all the chess pieces that are already captured.
     */
    public String getCapturedChess(ChessColor player);


    /**
     * @param source x y
     * @return This abstract method returns all the points that chess piece at "source" point can move to
     */
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    /**
     * This abstract method returns whether a chess piece at source can move to target.
     * Detailed method is shown as follows
     * @param sourceX x
     * @param sourceY y
     * @param targetX x
     * @param targetY y
     * @return This abstract method returns whether a chess piece at source can move to target.
     * Detailed method is shown as follows
     */
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) throws NoSuchMethodException;

}

enum ChessColor {
    /***/
    BLACK,
    /***/
    WHITE,
    /***/
    NONE;

    /**
     * @param color color abbr
     * @return the ChessColor based on the color abbreviation
     */
    public static ChessColor productionColor(String color) {
        switch (color.toLowerCase(Locale.ROOT)) {
            case "b": return BLACK;
            case "w": return WHITE;
            default: return NONE;
        }
    }

    /**
     * @param name name
     * @return color by name
     */
    public static ChessColor productionColor(char name) {
        if (name == '_') {
            return ChessColor.NONE;
        } else if (Character.isUpperCase(name)) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.WHITE;
        }
    }

}


