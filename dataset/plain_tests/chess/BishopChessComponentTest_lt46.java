import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class BishopChessComponentTest_lt46 {

    private ChessComponent[][] chessComponents;
    private BishopChessComponent bishop;

    @BeforeEach
    public void setUp() {
        chessComponents = new ChessComponent[8][8];
        bishop = new BishopChessComponent();
        bishop.setChessColor(ChessColor.WHITE);
        bishop.setSource(new ChessboardPoint(4, 4)); // Placing bishop in the center of the board
        bishop.setChessComponents(chessComponents);
    }

    //@Test
    public void testCanMoveToEmptyBoard() {
        List<ChessboardPoint> expectedMoves = List.of(
            new ChessboardPoint(5, 5), new ChessboardPoint(6, 6), new ChessboardPoint(7, 7),
            new ChessboardPoint(3, 5), new ChessboardPoint(2, 6), new ChessboardPoint(1, 7),
            new ChessboardPoint(5, 3), new ChessboardPoint(6, 2), new ChessboardPoint(7, 1),
            new ChessboardPoint(3, 3), new ChessboardPoint(2, 2), new ChessboardPoint(1, 1),
            new ChessboardPoint(3, 5), new ChessboardPoint(2, 6), new ChessboardPoint(1, 7)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves.size(), actualMoves.size(), "The number of possible moves should match.");
        assertTrue(actualMoves.containsAll(expectedMoves), "All expected moves should be present.");
    }

    //@Test
    public void testCanMoveToBlockedBySameColor() {
        chessComponents[5][5] = new BishopChessComponent();
        chessComponents[5][5].setChessColor(ChessColor.WHITE);
        chessComponents[5][5].setSource(new ChessboardPoint(5, 5));
        chessComponents[5][5].setChessComponents(chessComponents);

        List<ChessboardPoint> expectedMoves = List.of(
            new ChessboardPoint(3, 5), new ChessboardPoint(5, 3),
            new ChessboardPoint(6, 2), new ChessboardPoint(7, 1),
            new ChessboardPoint(3, 3), new ChessboardPoint(2, 2), new ChessboardPoint(1, 1)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves.size(), actualMoves.size(), "The number of possible moves should match.");
        assertTrue(actualMoves.containsAll(expectedMoves), "All expected moves should be present.");
    }

    //@Test
    public void testCanMoveToBlockedByDifferentColor() {
        chessComponents[5][5] = new BishopChessComponent();
        chessComponents[5][5].setChessColor(ChessColor.BLACK);
        chessComponents[5][5].setSource(new ChessboardPoint(5, 5));
        chessComponents[5][5].setChessComponents(chessComponents);

        List<ChessboardPoint> expectedMoves = List.of(
            new ChessboardPoint(5, 5), new ChessboardPoint(6, 6), new ChessboardPoint(7, 7),
            new ChessboardPoint(3, 5), new ChessboardPoint(2, 6), new ChessboardPoint(1, 7),
            new ChessboardPoint(5, 3), new ChessboardPoint(6, 2), new ChessboardPoint(7, 1),
            new ChessboardPoint(3, 3), new ChessboardPoint(2, 2), new ChessboardPoint(1, 1)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves.size(), actualMoves.size(), "The number of possible moves should match.");
        assertTrue(actualMoves.containsAll(expectedMoves), "All expected moves should be present.");
    }

    //@Test
    public void testCanMoveToEdgeOfBoard() {
        bishop.setSource(new ChessboardPoint(0, 0)); // Move bishop to corner of the board
        List<ChessboardPoint> expectedMoves = List.of(
            new ChessboardPoint(1, 1), new ChessboardPoint(2, 2), new ChessboardPoint(3, 3),
            new ChessboardPoint(4, 4), new ChessboardPoint(5, 5), new ChessboardPoint(6, 6),
            new ChessboardPoint(7, 7)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves.size(), actualMoves.size(), "The number of possible moves should match.");
        assertTrue(actualMoves.containsAll(expectedMoves), "All expected moves should be present.");
    }
}
