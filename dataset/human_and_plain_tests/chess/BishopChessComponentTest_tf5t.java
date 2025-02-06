import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class BishopChessComponentTest_tf5t {
    private ChessComponent[][] chessboard;
    private BishopChessComponent bishop;

    @BeforeEach
    public void setUp() {
        chessboard = new ChessComponent[8][8];
        bishop = new BishopChessComponent();
        bishop.setChessColor(ChessColor.WHITE);
        bishop.setSource(new ChessboardPoint(4, 4)); // Place bishop at (4, 4)
        bishop.setChessComponents(chessboard);
    }

    //@Test
    public void testCanMoveToEmptyBoard() {
        List<ChessboardPoint> expectedMoves = List.of(
                new ChessboardPoint(5, 5),
                new ChessboardPoint(6, 6),
                new ChessboardPoint(7, 7),
                new ChessboardPoint(3, 5),
                new ChessboardPoint(2, 6),
                new ChessboardPoint(1, 7),
                new ChessboardPoint(5, 3),
                new ChessboardPoint(6, 2),
                new ChessboardPoint(7, 1),
                new ChessboardPoint(3, 3),
                new ChessboardPoint(2, 2),
                new ChessboardPoint(1, 1),
                new ChessboardPoint(3, 5),
                new ChessboardPoint(2, 6),
                new ChessboardPoint(1, 7)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testCanMoveToBlockedBySameColor() {
        chessboard[5][5] = new BishopChessComponent();
        chessboard[5][5].setChessColor(ChessColor.WHITE); // Block with same color piece
        bishop.setChessComponents(chessboard);

        List<ChessboardPoint> expectedMoves = List.of(
                new ChessboardPoint(3, 5),
                new ChessboardPoint(2, 6),
                new ChessboardPoint(1, 7),
                new ChessboardPoint(5, 3),
                new ChessboardPoint(6, 2),
                new ChessboardPoint(7, 1)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testCanMoveToBlockedByDifferentColor() {
        chessboard[5][5] = new BishopChessComponent();
        chessboard[5][5].setChessColor(ChessColor.BLACK); // Block with different color piece
        bishop.setChessComponents(chessboard);

        List<ChessboardPoint> expectedMoves = List.of(
                new ChessboardPoint(5, 5), // Can capture this piece
                new ChessboardPoint(3, 5),
                new ChessboardPoint(2, 6),
                new ChessboardPoint(1, 7),
                new ChessboardPoint(5, 3),
                new ChessboardPoint(6, 2),
                new ChessboardPoint(7, 1)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testCanMoveToEdgeOfBoard() {
        bishop.setSource(new ChessboardPoint(0, 0)); // Place bishop at (0, 0)
        List<ChessboardPoint> expectedMoves = List.of(
                new ChessboardPoint(1, 1)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testCanMoveToCornerOfBoard() {
        bishop.setSource(new ChessboardPoint(7, 7)); // Place bishop at (7, 7)
        List<ChessboardPoint> expectedMoves = List.of(
                new ChessboardPoint(6, 6)
        );

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }
}
