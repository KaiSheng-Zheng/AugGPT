import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class BishopChessComponentTest_0tlh {

    private BishopChessComponent bishop;
    private ChessComponent[][] chessboard;

    @BeforeEach
    public void setUp() {
        chessboard = new ChessComponent[8][8];
        bishop = new BishopChessComponent();
        bishop.setChessComponents(chessboard);
    }

    //@Test
    public void testBishopCanMoveToEmptyBoard() {
        bishop.setSource(new ChessboardPoint(4, 4)); // Center of the board
        List<ChessboardPoint> expectedMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (4 + i < 8 && 4 + i < 8) expectedMoves.add(new ChessboardPoint(4 + i, 4 + i));
            if (4 + i < 8 && 4 - i >= 0) expectedMoves.add(new ChessboardPoint(4 + i, 4 - i));
            if (4 - i >= 0 && 4 + i < 8) expectedMoves.add(new ChessboardPoint(4 - i, 4 + i));
            if (4 - i >= 0 && 4 - i >= 0) expectedMoves.add(new ChessboardPoint(4 - i, 4 - i));
        }

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testBishopBlockedByOwnPieces() {
        bishop.setSource(new ChessboardPoint(4, 4));
        chessboard[5][5] = new BishopChessComponent(); // Own piece blocking
        chessboard[3][3] = new BishopChessComponent(); // Own piece blocking
        bishop.setChessComponents(chessboard);

        List<ChessboardPoint> expectedMoves = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (4 + i < 8 && 4 + i < 8) expectedMoves.add(new ChessboardPoint(4 + i, 4 + i));
            if (4 - i >= 0 && 4 - i >= 0) expectedMoves.add(new ChessboardPoint(4 - i, 4 - i));
        }

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testBishopCapturingOpponentPieces() {
        bishop.setSource(new ChessboardPoint(4, 4));
        chessboard[5][5] = new RookChessComponent(); // Opponent piece
        chessboard[3][3] = new RookChessComponent(); // Own piece blocking
        bishop.setChessComponents(chessboard);

        List<ChessboardPoint> expectedMoves = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (4 + i < 8 && 4 + i < 8) expectedMoves.add(new ChessboardPoint(4 + i, 4 + i));
            if (4 - i >= 0 && 4 - i >= 0) expectedMoves.add(new ChessboardPoint(4 - i, 4 - i));
        }
        expectedMoves.add(new ChessboardPoint(5, 5)); // Can capture opponent piece

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testBishopAtEdges() {
        bishop.setSource(new ChessboardPoint(0, 0)); // Top-left corner
        List<ChessboardPoint> expectedMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (i < 8 && i < 8) expectedMoves.add(new ChessboardPoint(i, i)); // Can only move down-right
        }

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }

    //@Test
    public void testBishopAtBottomEdge() {
        bishop.setSource(new ChessboardPoint(7, 7)); // Bottom-right corner
        List<ChessboardPoint> expectedMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (7 - i >= 0 && 7 - i >= 0) expectedMoves.add(new ChessboardPoint(7 - i, 7 - i)); // Can only move up-left
        }

        List<ChessboardPoint> actualMoves = bishop.canMoveTo();
        assertEquals(expectedMoves, actualMoves);
    }
}
