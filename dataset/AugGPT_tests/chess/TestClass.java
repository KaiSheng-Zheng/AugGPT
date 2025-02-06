import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.math.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {

    @Test
    public void testChessboardPointOffset_25gq() throws Exception {
        // Create a ChessboardPoint at (4, 4)
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Call offset with dx=1 and dy=1 to move to (5, 5)
        ChessboardPoint newPoint = (ChessboardPoint) point.getClass().getDeclaredMethod("offset", int.class, int.class).invoke(point, 1, 1);

        // Assert that the new point is (5, 5)
        Assertions.assertEquals("(5,5)", newPoint.toString());

        // Call offset with dx=4 and dy=4 to move out of bounds
        ChessboardPoint outOfBoundsPoint = (ChessboardPoint) point.getClass().getDeclaredMethod("offset", int.class, int.class).invoke(point, 4, 4);

        // Assert that outOfBoundsPoint is null
        Assertions.assertNull(outOfBoundsPoint);
    }

    //@Test
    public void testRookChessComponentCanMoveTo_hnxb() throws Exception {
        // Create a RookChessComponent at position (0, 0) and set its source and chess color
        RookChessComponent rook = new RookChessComponent();
        Field sourceField = rook.getClass().getSuperclass().getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(rook, new ChessboardPoint(0, 0));

        Field colorField = rook.getClass().getSuperclass().getDeclaredField("chessColor");
        colorField.setAccessible(true);
        colorField.set(rook, ChessColor.BLACK);

        // Create an empty chess component grid
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        Field chessComponentsField = rook.getClass().getSuperclass().getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        chessComponentsField.set(rook, chessComponents);

        // Test canMoveTo() for rook
        //mis
        List<ChessboardPoint> movePoints = rook.canMoveTo();

        // Assert that the rook can move vertically and horizontally from (0, 0)
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(1, 0)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(0, 1)));
    }

    @Test
    public void testChessboardPointOffset_bldx() throws Exception {
        // Create a ChessboardPoint at (4, 4)
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Move the point using offset and assert the new position
        ChessboardPoint newPoint = point.offset(1, 1);
        Assertions.assertNotNull(newPoint);
        Assertions.assertEquals(5, newPoint.getX());
        Assertions.assertEquals(5, newPoint.getY());

        // Move the point outside the chessboard
        newPoint = point.offset(5, 5);
        Assertions.assertNull(newPoint);
    }

    @Test
    public void testEmptySlotComponent_ruyg() throws Exception {
        // Create an instance of EmptySlotComponent
        EmptySlotComponent emptySlot = new EmptySlotComponent();

        // Get the possible move points for an empty slot and assert
        List<ChessboardPoint> canMovePoints = emptySlot.canMoveTo();
        Assertions.assertTrue(canMovePoints.isEmpty());

        // Set the source of the empty slot to a ChessboardPoint
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(emptySlot, new ChessboardPoint(3, 3));

        // Assert that the source was set correctly
        ChessboardPoint source = (ChessboardPoint) sourceField.get(emptySlot);
        Assertions.assertEquals(3, source.getX());
        Assertions.assertEquals(3, source.getY());
    }

    private Object getPrivateField_sw6v(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    //@Test
    public void testBishopCanMoveTo_ldv2() throws Exception {
        // Create a chessboard with a Bishop piece
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> initialBoard = new ArrayList<>();
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("____B___"); // Bishop at (3,4)
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("w");
        chessGame.loadChessGame(initialBoard);

        // Get the Bishop component and invoke canMoveTo method
        ChessComponent bishop = chessGame.getChess(3, 4);
        Field chessComponentsField = ChessComponent.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(bishop);

        // Set the source for Bishop
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(bishop, new ChessboardPoint(3, 4));

        // Call canMoveTo method and assert the expected result
        List<ChessboardPoint> moves = bishop.canMoveTo();
        //logic err
        Assertions.assertEquals(7, moves.size()); // Bishop can move to 7 positions diagonally
    }

    @Test
    public void testQueenCanMoveTo_iyl0() throws Exception {
        // Create a chessboard with a Queen piece
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> initialBoard = new ArrayList<>();
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("___Q____"); // Queen at (2,3)
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("w");
        chessGame.loadChessGame(initialBoard);

        // Get the Queen component and invoke canMoveTo method
        ChessComponent queen = chessGame.getChess(2, 3);
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(queen, new ChessboardPoint(2, 3));

        // Call canMoveTo method and assert the expected result
        List<ChessboardPoint> moves = queen.canMoveTo();
        Assertions.assertTrue(moves.size() > 0); // Queen should have possible moves
    }

    @Test
    public void testKnightCanMoveTo_gr78() throws Exception {
        // Create a chessboard with a Knight piece
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> initialBoard = new ArrayList<>();
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("____N___"); // Knight at (2,4)
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("w");
        chessGame.loadChessGame(initialBoard);

        // Get the Knight component and invoke canMoveTo method
        ChessComponent knight = chessGame.getChess(2, 4);
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(knight, new ChessboardPoint(2, 4));

        // Call canMoveTo method and assert the expected result
        List<ChessboardPoint> moves = knight.canMoveTo();
        Assertions.assertEquals(8, moves.size()); // Knight should have 8 possible moves
    }

    //@Test
    public void testMoveChess_a2sx() throws Exception {
        // Create a chessboard and load initial positions
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> initialBoard = new ArrayList<>();
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("R_______"); // Rook at (3,0)
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("________");
        initialBoard.add("w");
        chessGame.loadChessGame(initialBoard);

        // Move Rook from (3,0) to (3,4)
        boolean moved = chessGame.moveChess(3, 0, 3, 4);
        //logic err
        Assertions.assertTrue(moved); // Move should be successful

        // Assert the new position of the Rook
        ChessComponent movedRook = chessGame.getChess(3, 4);
        Assertions.assertNotNull(movedRook); // Rook should now be at (3,4)
    }
    //@Test
    public void testRookChessComponentCanMoveTo_1bj2() throws Exception {
        // Create a RookChessComponent and set its position
        RookChessComponent rook = new RookChessComponent();
        //mis
        setField_0xxm(rook, "source", new ChessboardPoint(4, 4));
        setField_0xxm(rook, "chessColor", ChessColor.BLACK);
        setField_0xxm(rook, "chessComponents", new ChessComponent[8][8]);

        // Simulate an empty board around the rook
        ChessComponent[][] chessComponents = (ChessComponent[][]) getField_ebch(rook, "chessComponents");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 && j == 4) {
                    chessComponents[i][j] = rook; // Place the rook at its position
                } else {
                    chessComponents[i][j] = new EmptySlotComponent();
                }
            }
        }

        // Test the canMoveTo method
        List<ChessboardPoint> movePoints = rook.canMoveTo();

        // Verify the expected moves (horizontal and vertical)
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(5, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(6, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 5)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 6)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(3, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(2, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 3)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 2)));
    }

    //@Test
    public void testKnightChessComponentCanMoveTo_k8xc() throws Exception {
        // Create a KnightChessComponent and set its position
        KnightChessComponent knight = new KnightChessComponent();
        //mis
        setField_0xxm(knight, "source", new ChessboardPoint(3, 3));
        setField_0xxm(knight, "chessColor", ChessColor.WHITE);
        setField_0xxm(knight, "chessComponents", new ChessComponent[8][8]);

        // Simulate an empty board around the knight
        ChessComponent[][] chessComponents = (ChessComponent[][]) getField_ebch(knight, "chessComponents");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = new EmptySlotComponent(); // Empty board
            }
        }
        chessComponents[3][3] = knight; // Place the knight at its position

        // Test the canMoveTo method
        List<ChessboardPoint> movePoints = knight.canMoveTo();

        // Verify the expected moves (L-shape)
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(5, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(5, 2)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(1, 4)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(1, 2)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 5)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(4, 1)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(2, 5)));
        Assertions.assertTrue(movePoints.contains(new ChessboardPoint(2, 1)));
    }

    @Test
    public void testChessboardPointOffset_eo2o() throws Exception {
        // Create a ChessboardPoint at position (4, 4)
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Test offset method for valid moves
        ChessboardPoint newPoint = point.offset(1, 0); // Move right
        Assertions.assertNotNull(newPoint);
        Assertions.assertEquals(5, newPoint.getX());
        Assertions.assertEquals(4, newPoint.getY());

        newPoint = point.offset(0, -1); // Move down
        Assertions.assertNotNull(newPoint);
        Assertions.assertEquals(4, newPoint.getX());
        Assertions.assertEquals(3, newPoint.getY());

        // Test offset method for invalid moves (out of bounds)
        newPoint = point.offset(5, 0); // Move out of bounds
        Assertions.assertNull(newPoint);
    }


    private void setField_0xxm(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getField_ebch(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    //@Test
    public void testRookMovement_miqs() throws Exception {
        // Setup a chess game with a rook at position (0,0) and a pawn at (0,1)
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("R_______");
        chessboard.add("P_______");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        chessGame.loadChessGame(chessboard);

        // Access the RookChessComponent at (0,0)
        Field field = ConcreteChessGame.class.getDeclaredField("chessComponents");
        field.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) field.get(chessGame);
        RookChessComponent rook = (RookChessComponent) chessComponents[0][0];

        // Check the possible moves for the rook
        List<ChessboardPoint> possibleMoves = rook.canMoveTo();

        // Assert that the rook can move to (0,2) but not (0,1) because of the pawn
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(0, 2)));
        //logic err
        Assertions.assertFalse(possibleMoves.contains(new ChessboardPoint(0, 1)));
    }

    @Test
    public void testKnightMovement_8o7p() throws Exception {
        // Setup a chess game with a knight at position (1,0)
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("N_______");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        chessGame.loadChessGame(chessboard);

        // Access the KnightChessComponent at (1,0)
        Field field = ConcreteChessGame.class.getDeclaredField("chessComponents");
        field.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) field.get(chessGame);
        KnightChessComponent knight = (KnightChessComponent) chessComponents[1][0];

        // Check the possible moves for the knight
        List<ChessboardPoint> possibleMoves = knight.canMoveTo();

        // Assert that the knight can move to (3,1) and (2,2)
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 2)));
        // Assert that it cannot move to (0,0)
        Assertions.assertFalse(possibleMoves.contains(new ChessboardPoint(0, 0)));
    }

    @Test
    public void testConcreteChessGameMove_cj7y() throws Exception {
        // Setup a chess game with a white rook at (0,0) and a black pawn at (0,1)
        ConcreteChessGame chessGame = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("R_______");
        chessboard.add("p_______");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        chessGame.loadChessGame(chessboard);

        // Move the rook from (0,0) to (0,1) where the pawn is located
        boolean moveResult = chessGame.moveChess(0, 0, 0, 1);

        // Assert that the move was unsuccessful due to the pawn blocking the rook
        Assertions.assertFalse(moveResult);
    }

    @Test
    public void testChessboardPointOffset_cqy0() throws Exception {
        // Create a ChessboardPoint at (4,4)
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Move the point by (1,1) to (5,5)
        ChessboardPoint newPoint = point.offset(1, 1);

        // Assert that the new point is correctly updated to (5,5)
        Assertions.assertEquals(5, newPoint.getX());
        Assertions.assertEquals(5, newPoint.getY());

        // Move the point by (4,4) which should be out of bounds
        ChessboardPoint outOfBoundsPoint = point.offset(4, 4);

        // Assert that moving out of bounds returns null
        Assertions.assertNull(outOfBoundsPoint);
    }


    //@Test
    public void testBishopChessComponentCanMoveTo_9zqw() throws Exception {
        // Create a ChessboardPoint at (3, 3) for the Bishop
        ChessboardPoint bishopPosition = new ChessboardPoint(3, 3);

        // Create an instance of BishopChessComponent and set its source
        BishopChessComponent bishop = new BishopChessComponent();
        //mis
        setPrivateField_8nls(bishop, "source", bishopPosition);
        setPrivateField_8nls(bishop, "chessColor", ChessColor.WHITE);

        // Create an empty chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[4][4] = new EmptySlotComponent(); // Diagonal move
        chessComponents[5][5] = new EmptySlotComponent(); // Diagonal move
        chessComponents[6][6] = new RookChessComponent(); // Blocked move
        setPrivateField_8nls(bishop, "chessComponents", chessComponents);

        // Call the canMoveTo method to get possible moves
        List<ChessboardPoint> moves = bishop.canMoveTo();

        // Assert that the Bishop can move to (4, 4) and (5, 5), but not (6, 6)
        Assertions.assertTrue(moves.contains(new ChessboardPoint(4, 4)));
        Assertions.assertTrue(moves.contains(new ChessboardPoint(5, 5)));
        Assertions.assertFalse(moves.contains(new ChessboardPoint(6, 6)));
    }

    //@Test
    public void testQueenChessComponentCanMoveTo_lcqz() throws Exception {
        // Create a ChessboardPoint at (3, 3) for the Queen
        ChessboardPoint queenPosition = new ChessboardPoint(3, 3);

        // Create an instance of QueenChessComponent and set its source
        QueenChessComponent queen = new QueenChessComponent();
        //mis
        setPrivateField_8nls(queen, "source", queenPosition);
        setPrivateField_8nls(queen, "chessColor", ChessColor.BLACK);

        // Create an empty chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[3][4] = new EmptySlotComponent(); // Horizontal move
        chessComponents[3][5] = new EmptySlotComponent(); // Horizontal move
        chessComponents[4][3] = new RookChessComponent(); // Blocked move
        setPrivateField_8nls(queen, "chessComponents", chessComponents);

        // Call the canMoveTo method to get possible moves
        List<ChessboardPoint> moves = queen.canMoveTo();

        // Assert that the Queen can move to (3, 4) and (3, 5), but not (4, 3)
        Assertions.assertTrue(moves.contains(new ChessboardPoint(3, 4)));
        Assertions.assertTrue(moves.contains(new ChessboardPoint(3, 5)));
        Assertions.assertFalse(moves.contains(new ChessboardPoint(4, 3)));
    }


    //@Test
    public void testKnightChessComponentCanMoveTo_03e4() throws Exception {
        // Create a ChessboardPoint at (3, 3) for the Knight
        ChessboardPoint knightPosition = new ChessboardPoint(3, 3);

        // Create an instance of KnightChessComponent and set its source
        KnightChessComponent knight = new KnightChessComponent();
        //mis
        setPrivateField_8nls(knight, "source", knightPosition);
        setPrivateField_8nls(knight, "chessColor", ChessColor.WHITE);

        // Create an empty chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[5][4] = new EmptySlotComponent(); // Valid move
        chessComponents[5][2] = new EmptySlotComponent(); // Valid move
        chessComponents[4][5] = new RookChessComponent(); // Blocked move
        setPrivateField_8nls(knight, "chessComponents", chessComponents);

        // Call the canMoveTo method to get possible moves
        List<ChessboardPoint> moves = knight.canMoveTo();

        // Assert that the Knight can move to (5, 4) and (5, 2), but not (4, 5)
        Assertions.assertTrue(moves.contains(new ChessboardPoint(5, 4)));
        Assertions.assertTrue(moves.contains(new ChessboardPoint(5, 2)));
        Assertions.assertFalse(moves.contains(new ChessboardPoint(4, 5)));
    }

    // Helper method to set private fields using reflection
    private void setPrivateField_8nls(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    //@Test
    public void testBishopCanMoveTo_z7mr() throws Exception {
        // Create a chessboard and place a Bishop on it
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___B____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Use reflection to access the Bishop's canMoveTo method
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        BishopChessComponent bishop = (BishopChessComponent) chessComponents[4][3];

        // Call the canMoveTo method and assert the expected positions
        List<ChessboardPoint> possibleMoves = bishop.canMoveTo();
        //logic err
        Assertions.assertEquals(7, possibleMoves.size()); // Bishop can move diagonally
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(6, 5)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(7, 6)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 5)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(1, 6)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(0, 7)));
    }

    @Test
    public void testQueenCanMoveTo_ju62() throws Exception {
        // Create a chessboard and place a Queen on it
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___Q____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Use reflection to access the Queen's canMoveTo method
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        QueenChessComponent queen = (QueenChessComponent) chessComponents[3][3];

        // Call the canMoveTo method and assert the expected positions
        List<ChessboardPoint> possibleMoves = queen.canMoveTo();
        Assertions.assertTrue(possibleMoves.size() > 0); // Queen can move in multiple directions
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 4))); // Horizontal move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 3))); // Vertical move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 5))); // Diagonal move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 2))); // Diagonal move
    }

    //@Test
    public void testPawnCanMoveTo_8ovk() throws Exception {
        // Create a chessboard and place a Pawn on it
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___P____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Use reflection to access the Pawn's canMoveTo method
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        PawnChessComponent pawn = (PawnChessComponent) chessComponents[4][3];

        // Call the canMoveTo method and assert the expected positions
        List<ChessboardPoint> possibleMoves = pawn.canMoveTo();
        //logic err
        Assertions.assertEquals(2, possibleMoves.size()); // Pawn can move forward two squares
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 3))); // Move one square forward
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(6, 3))); // Move two squares forward
    }

    @Test
    public void testMoveChess_xad8() throws Exception {
        // Create a chessboard and place pieces on it
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Move a pawn from (6, 4) to (5, 4)
        boolean moveSuccess = game.moveChess(6, 4, 5, 4);
        Assertions.assertTrue(moveSuccess); // Move should be successful

        // Verify the state of the chessboard after the move
        ChessComponent movedPawn = game.getChess(5, 4);
        Assertions.assertNotNull(movedPawn);
        Assertions.assertEquals('p', movedPawn.getName());

        // Verify the original position is now empty
        ChessComponent originalPosition = game.getChess(6, 4);
        Assertions.assertTrue(originalPosition instanceof EmptySlotComponent);
    }

    //@Test
    public void testBishopMovement_5w90() throws Exception {
        // Initialize a chessboard with a Bishop at (3, 3)
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___B____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Bishop's canMoveTo method to get possible moves
        ChessComponent bishop = game.getChess(3, 3);
        List<ChessboardPoint> possibleMoves = bishop.canMoveTo();

        // Assert the expected moves for a Bishop
        //logic err
        Assertions.assertEquals(7, possibleMoves.size()); // Bishop can move diagonally
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 2)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 5)));
    }

    //@Test
    public void testQueenMovement_zilk() throws Exception {
        // Initialize a chessboard with a Queen at (4, 4)
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___Q____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Queen's canMoveTo method to get possible moves
        ChessComponent queen = game.getChess(4, 4);
        List<ChessboardPoint> possibleMoves = queen.canMoveTo();

        // Assert the expected moves for a Queen
        //logic err
        Assertions.assertEquals(27, possibleMoves.size()); // Queen can move in multiple directions
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 5))); // Horizontal move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 5))); // Diagonal move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 3))); // Diagonal move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 0))); // Vertical move
    }

    @Test
    public void testKingMovement_vp60() throws Exception {
        // Initialize a chessboard with a King at (0, 0)
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("K_______");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the King's canMoveTo method to get possible moves
        ChessComponent king = game.getChess(0, 0);
        List<ChessboardPoint> possibleMoves = king.canMoveTo();

        // Assert the expected moves for a King
        Assertions.assertEquals(3, possibleMoves.size()); // King can move one step in any direction
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(1, 0))); // Move down
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(0, 1))); // Move right
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(1, 1))); // Move diagonally
    }

    @Test
    public void testPawnMovement_zveh() throws Exception {
        // Initialize a chessboard with a Pawn at (1, 1)
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("_P______");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Pawn's canMoveTo method to get possible moves
        ChessComponent pawn = game.getChess(1, 1);
        List<ChessboardPoint> possibleMoves = pawn.canMoveTo();

        // Assert the expected moves for a Pawn
        Assertions.assertEquals(2, possibleMoves.size()); // Pawn can move one or two steps forward
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 1))); // Move one step down
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1))); // Move two steps down
    }

    //@Test
    public void testBishopChessComponentCanMoveTo_ip11() throws Exception {
        // Create a BishopChessComponent and set its source to (4, 4)
        BishopChessComponent bishop = new BishopChessComponent();
        //mis
        setField_qf1s(bishop, "source", new ChessboardPoint(4, 4));
        setField_qf1s(bishop, "chessColor", ChessColor.WHITE);

        // Create a chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[5][5] = new EmptySlotComponent();
        chessComponents[3][3] = new RookChessComponent(); // Block the path
        chessComponents[2][2] = new EmptySlotComponent();
        setField_qf1s(bishop, "chessComponents", chessComponents);

        // Call canMoveTo() and check the result
        List<ChessboardPoint> canMoveTo = bishop.canMoveTo();
        Assertions.assertEquals(2, canMoveTo.size()); // Bishop can move to (2,2) and (5,5)
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(2, 2)));
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(5, 5)));
    }

    //@Test
    public void testQueenChessComponentCanMoveTo_1x5q() throws Exception {
        // Create a QueenChessComponent and set its source to (3, 3)
        QueenChessComponent queen = new QueenChessComponent();
        //mis
        setField_qf1s(queen, "source", new ChessboardPoint(3, 3));
        setField_qf1s(queen, "chessColor", ChessColor.BLACK);

        // Create a chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[5][5] = new RookChessComponent(); // Block the diagonal
        chessComponents[3][6] = new EmptySlotComponent(); // Allow horizontal move
        chessComponents[1][3] = new EmptySlotComponent(); // Allow vertical move
        setField_qf1s(queen, "chessComponents", chessComponents);

        // Call canMoveTo() and check the result
        List<ChessboardPoint> canMoveTo = queen.canMoveTo();
        Assertions.assertEquals(4, canMoveTo.size()); // Queen can move to (1,3), (3,6), (5,5)
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(1, 3)));
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(3, 6)));
        Assertions.assertFalse(canMoveTo.contains(new ChessboardPoint(5, 5))); // Blocked
    }


    //@Test
    public void testKnightChessComponentCanMoveTo_6oj4() throws Exception {
        // Create a KnightChessComponent and set its source to (4, 4)
        KnightChessComponent knight = new KnightChessComponent();
        //mis
        setField_qf1s(knight, "source", new ChessboardPoint(4, 4));
        setField_qf1s(knight, "chessColor", ChessColor.WHITE);

        // Create a chessboard with some pieces
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        chessComponents[5][6] = new RookChessComponent(); // Block one move
        chessComponents[3][5] = new EmptySlotComponent(); // Allow one move
        chessComponents[2][6] = new EmptySlotComponent(); // Allow one move
        setField_qf1s(knight, "chessComponents", chessComponents);

        // Call canMoveTo() and check the result
        List<ChessboardPoint> canMoveTo = knight.canMoveTo();
        Assertions.assertEquals(4, canMoveTo.size()); // Knight can move to (3, 5), (2, 6), (6, 5), (5, 2)
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(3, 5)));
        Assertions.assertTrue(canMoveTo.contains(new ChessboardPoint(2, 6)));
        Assertions.assertFalse(canMoveTo.contains(new ChessboardPoint(5, 6))); // Blocked
    }

    // Helper method to set private fields using reflection
    private void setField_qf1s(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    public void testRookMovement_hi8t() throws Exception {
        // Initialize a new ChessGame with a rook
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___R____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the rook component
        Field field = ConcreteChessGame.class.getDeclaredField("chessComponents");
        field.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) field.get(game);
        RookChessComponent rook = (RookChessComponent) chessComponents[3][3];

        // Check the possible moves for the rook
        List<ChessboardPoint> possibleMoves = rook.canMoveTo();

        // Assertions based on rook's movement rules
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(0, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(1, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(6, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 0)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 2)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 5)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 6)));
    }

    //@Test
    public void testChessGameMove_o89j() throws Exception {
        // Initialize a new ChessGame
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___P____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Move the pawn
        boolean moveResult = game.moveChess(3, 3, 4, 3);

        // Check if the move was successful
        //logic err
        Assertions.assertTrue(moveResult);

        // Access the pawn after the move
        Field field = ConcreteChessGame.class.getDeclaredField("chessComponents");
        field.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) field.get(game);

        // Verify that the pawn has moved
        Assertions.assertTrue(chessComponents[4][3] instanceof PawnChessComponent);
        Assertions.assertTrue(chessComponents[3][3] instanceof EmptySlotComponent);
    }

    @Test
    public void testChessboardPointOffset_fams() throws Exception {
        // Create a ChessboardPoint instance
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Test the offset method with valid moves
        ChessboardPoint newPoint1 = point.offset(1, 1);
        ChessboardPoint newPoint2 = point.offset(-1, -1);
        ChessboardPoint outOfBounds = point.offset(8, 8); // This should return null

        // Assertions for valid moves
        Assertions.assertNotNull(newPoint1);
        Assertions.assertEquals(5, newPoint1.getX());
        Assertions.assertEquals(5, newPoint1.getY());

        Assertions.assertNotNull(newPoint2);
        Assertions.assertEquals(3, newPoint2.getX());
        Assertions.assertEquals(3, newPoint2.getY());

        // Assertions for out of bounds
        Assertions.assertNull(outOfBounds);
    }


    //@Test
    public void testRookMovement_g7yq() throws Exception {
        // Create a new ConcreteChessGame instance
        ConcreteChessGame game = new ConcreteChessGame();

        // Load the chessboard setup
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Rook at (0, 0) and check its movement
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);

        // Ensure Rook can move vertically and horizontally
        List<ChessboardPoint> canMovePoints = chessComponents[0][0].canMoveTo();
        //logic err
        Assertions.assertEquals(14, canMovePoints.size()); // 14 possible moves for Rook

        // Check if Rook can move to (0, 1)
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(0, 1)));
    }

    @Test
    public void testKnightMovement_4pk9() throws Exception {
        // Create a new ConcreteChessGame instance
        ConcreteChessGame game = new ConcreteChessGame();

        // Load the chessboard setup
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Knight at (0, 1) and check its movement
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);

        // Ensure Knight can move to 2 different squares
        List<ChessboardPoint> canMovePoints = chessComponents[0][1].canMoveTo();
        Assertions.assertEquals(2, canMovePoints.size()); // Knight should have 2 possible moves

        // Check if Knight can move to (2, 0)
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(2, 0)));
        // Check if Knight can move to (2, 2)
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(2, 2)));
    }

    @Test
    public void testPawnMovement_w5h3() throws Exception {
        // Create a new ConcreteChessGame instance
        ConcreteChessGame game = new ConcreteChessGame();

        // Load the chessboard setup
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the Pawn at (1, 0) and check its movement
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);

        // Ensure Pawn can move forward
        List<ChessboardPoint> canMovePoints = chessComponents[1][0].canMoveTo();
        Assertions.assertEquals(2, canMovePoints.size()); // Pawn should have 2 possible moves (1 forward, 2 forward)

        // Check if Pawn can move to (2, 0) and (3, 0)
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(2, 0)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(3, 0)));
    }

    //@Test
    public void testKingMovement_53k7() throws Exception {
        // Create a new ConcreteChessGame instance
        ConcreteChessGame game = new ConcreteChessGame();

        // Load the chessboard setup
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");
        game.loadChessGame(chessboard);

        // Access the King at (0, 4) and check its movement
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);

        // Ensure King can move to adjacent squares
        List<ChessboardPoint> canMovePoints = chessComponents[0][4].canMoveTo();
        //logic err
        Assertions.assertEquals(8, canMovePoints.size()); // King should have 8 possible moves

        // Check if King can move to (1, 4) and (0, 5)
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(1, 4)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(0, 5)));
    }

    //@Test
    public void testRookCanMoveTo_ubp7() throws Exception {
        // Initialize a chessboard and a RookChessComponent
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        RookChessComponent rook = new RookChessComponent();

        // Set the source position of the rook to (0, 0)
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(rook, new ChessboardPoint(0, 0));

        // Set the chess color to BLACK
        Field colorField = ChessComponent.class.getDeclaredField("chessColor");
        colorField.setAccessible(true);
        colorField.set(rook, ChessColor.BLACK);

        // Place the rook on the board
        chessComponents[0][0] = rook;

        // Add some empty slots to the right and a white piece to block the rook's path
        chessComponents[0][1] = new EmptySlotComponent();
        chessComponents[0][2] = new RookChessComponent(); // Blocking piece
        chessComponents[0][3] = new EmptySlotComponent();

        // Set the chessComponents field in the rook to the chessboard
        Field componentsField = ChessComponent.class.getDeclaredField("chessComponents");
        componentsField.setAccessible(true);
        componentsField.set(rook, chessComponents);

        // Invoke canMoveTo method and check possible moves
        //mis
        List<ChessboardPoint> canMovePoints = rook.canMoveTo();

        // Validate the moves (it can only move to (0, 1) and (0, 3))
        Assertions.assertEquals(2, canMovePoints.size());
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(0, 1)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(0, 3)));
    }

    //@Test
    public void testKnightCanMoveTo_wze4() throws Exception {
        // Initialize a chessboard and a KnightChessComponent
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        KnightChessComponent knight = new KnightChessComponent();

        // Set the source position of the knight to (4, 4)
        Field sourceField = ChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(knight, new ChessboardPoint(4, 4));

        // Set the chess color to WHITE
        Field colorField = ChessComponent.class.getDeclaredField("chessColor");
        colorField.setAccessible(true);
        colorField.set(knight, ChessColor.WHITE);

        // Place the knight on the board
        chessComponents[4][4] = knight;

        // Add some empty slots and a black piece to the board
        chessComponents[5][6] = new EmptySlotComponent(); // Valid move
        chessComponents[3][6] = new EmptySlotComponent(); // Valid move
        chessComponents[5][5] = new RookChessComponent(); // Blocking piece
        chessComponents[2][3] = new EmptySlotComponent(); // Valid move
        chessComponents[2][5] = new EmptySlotComponent(); // Valid move

        // Set the chessComponents field in the knight to the chessboard
        Field componentsField = ChessComponent.class.getDeclaredField("chessComponents");
        componentsField.setAccessible(true);
        componentsField.set(knight, chessComponents);

        // Invoke canMoveTo method and check possible moves
        //mis
        List<ChessboardPoint> canMovePoints = knight.canMoveTo();

        // Validate the moves (it can move to (5, 6), (3, 6), (2, 3), (2, 5))
        Assertions.assertEquals(4, canMovePoints.size());
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(5, 6)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(3, 6)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(2, 3)));
        Assertions.assertTrue(canMovePoints.contains(new ChessboardPoint(2, 5)));
    }

    @Test
    public void testConcreteChessGameGetCapturedChess_mcrz() throws Exception {
        // Initialize a ConcreteChessGame and set up the chessboard
        ConcreteChessGame game = new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();
        chessboard.add("RNBQKBNR");
        chessboard.add("PPPPPPPP");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("pppppppp");
        chessboard.add("rnbqkbnr");
        chessboard.add("w");

        // Load the chess game with the initial configuration
        game.loadChessGame(chessboard);

        // Simulate capturing some pieces
        Field componentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        componentsField.setAccessible(true);
        ChessComponent[][] components = (ChessComponent[][]) componentsField.get(game);

        // Simulate capturing a white pawn
        components[6][0] = new EmptySlotComponent(); // Simulate capture

        // Invoke getCapturedChess method and validate the result
        String capturedChess = game.getCapturedChess(ChessColor.WHITE);
        Assertions.assertTrue(capturedChess.contains("p 1"));
    }

    @Test
    public void testChessboardPointOffset_s3or() throws Exception {
        // Create a ChessboardPoint at (4, 4)
        ChessboardPoint point = new ChessboardPoint(4, 4);

        // Invoke offset method with valid parameters
        ChessboardPoint newPoint = point.offset(1, 0); // Move down
        Assertions.assertNotNull(newPoint);
        Assertions.assertEquals(5, newPoint.getX());
        Assertions.assertEquals(4, newPoint.getY());

        // Invoke offset method with invalid parameters (out of bounds)
        ChessboardPoint outOfBoundsPoint = point.offset(-5, -5); // Move out of bounds
        Assertions.assertNull(outOfBoundsPoint);
    }


    //@Test
    public void testBishopMovement_fob4() throws Exception {
        // Initialize the chessboard with a Bishop at position (3, 3)
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(List.of(
                "________",
                "________",
                "________",
                "____B___", // B represents Bishop
                "________",
                "________",
                "________",
                "________",
                "w" // Current player is white
        ));

        // Retrieve the Bishop component
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        //logic err
        BishopChessComponent bishop = (BishopChessComponent) chessComponents[3][3];

        // Call canMoveTo() to get possible movements for the Bishop
        List<ChessboardPoint> possibleMoves = bishop.canMoveTo();

        // Check that the Bishop can move diagonally to (4, 4) and (2, 2)
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 2)));
    }

    //@Test
    public void testQueenMovement_bb41() throws Exception {
        // Initialize the chessboard with a Queen at position (3, 3)
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(List.of(
                "________",
                "________",
                "________",
                "____Q___", // Q represents Queen
                "________",
                "________",
                "________",
                "________",
                "w" // Current player is white
        ));

        // Retrieve the Queen component
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        //logic err
        QueenChessComponent queen = (QueenChessComponent) chessComponents[3][3];

        // Call canMoveTo() to get possible movements for the Queen
        List<ChessboardPoint> possibleMoves = queen.canMoveTo();

        // Check that the Queen can move to multiple positions including (4, 3), (3, 4), (3, 2), etc.
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 4)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 2)));
    }

    //@Test
    public void testPawnMovement_h68h() throws Exception {
        // Initialize the chessboard with a Pawn at position (1, 1)
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(List.of(
                "________",
                "__P_____",
                "________",
                "________",
                "________",
                "________",
                "________",
                "________",
                "w" // Current player is white
        ));

        // Retrieve the Pawn component
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        //logic err
        PawnChessComponent pawn = (PawnChessComponent) chessComponents[1][1];

        // Call canMoveTo() to get possible movements for the Pawn
        List<ChessboardPoint> possibleMoves = pawn.canMoveTo();

        // Check that the Pawn can move to (2, 1) and (3, 1) for its first move
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 1)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1)));
    }

    @Test
    public void testKingMovement_7dg0() throws Exception {
        // Initialize the chessboard with a King at position (0, 4)
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(List.of(
                "________",
                "________",
                "________",
                "________",
                "__K_____",
                "________",
                "________",
                "________",
                "w" // Current player is white
        ));

        // Retrieve the King component
        Field chessComponentsField = ConcreteChessGame.class.getDeclaredField("chessComponents");
        chessComponentsField.setAccessible(true);
        ChessComponent[][] chessComponents = (ChessComponent[][]) chessComponentsField.get(game);
        KingChessComponent king = (KingChessComponent) chessComponents[4][2];

        // Call canMoveTo() to get possible movements for the King
        List<ChessboardPoint> possibleMoves = king.canMoveTo();

        // Check that the King can move to (3, 3), (3, 2), (3, 1), etc.
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 3)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 2)));
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1)));
    }

    //@Test
    public void testBishopChessComponentCanMoveTo_g1j3() throws Exception {
        // Create a new BishopChessComponent at position (3,3)
        BishopChessComponent bishop = new BishopChessComponent();
        //mis
        Field sourceField = BishopChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(bishop, new ChessboardPoint(3, 3));

        // Set the chess components array to simulate a chessboard
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        bishop.setChessComponents(chessComponents); // Using reflection to set private field
        chessComponents[3][3] = bishop;

        // Add some pieces around the bishop to test movement
        chessComponents[4][4] = new RookChessComponent(); // Another piece in diagonal path
        chessComponents[5][5] = new EmptySlotComponent(); // Empty space
        chessComponents[6][6] = new KingChessComponent(); // Friendly piece
        chessComponents[2][2] = new PawnChessComponent(); // Enemy piece

        // Call canMoveTo() and check possible moves
        List<ChessboardPoint> possibleMoves = bishop.canMoveTo();
        Assertions.assertEquals(2, possibleMoves.size(), "Bishop should have 2 valid moves to (4,4) and (5,5)");

        // Check the specific positions
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 4)), "Bishop can move to (4,4)");
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 5)), "Bishop can move to (5,5)");
    }

    //@Test
    public void testQueenChessComponentCanMoveTo_du64() throws Exception {
        // Create a new QueenChessComponent at position (3,3)
        QueenChessComponent queen = new QueenChessComponent();
        //mis
        Field sourceField = QueenChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(queen, new ChessboardPoint(3, 3));

        // Set the chess components array to simulate a chessboard
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        queen.setChessComponents(chessComponents); // Using reflection to set private field
        chessComponents[3][3] = queen;

        // Add pieces around the queen
        chessComponents[3][5] = new RookChessComponent(); // Block in horizontal path
        chessComponents[3][1] = new EmptySlotComponent(); // Empty space
        chessComponents[0][3] = new KingChessComponent(); // Friendly piece
        chessComponents[4][4] = new PawnChessComponent(); // Enemy piece

        // Call canMoveTo() and check possible moves
        List<ChessboardPoint> possibleMoves = queen.canMoveTo();
        Assertions.assertEquals(4, possibleMoves.size(), "Queen should have 4 valid moves in various directions");

        // Check specific positions
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(3, 1)), "Queen can move to (3,1)");
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 4)), "Queen can move to (4,4)");
    }

    @Test
    public void testConcreteChessGameLoadChessGame_izi6() throws Exception {
        // Create a new ConcreteChessGame
        ConcreteChessGame chessGame = new ConcreteChessGame();

        // Create a chessboard representation
        List<String> chessboard = List.of(
                "RNBQKBNR",
                "PPPPPPPP",
                "________",
                "________",
                "________",
                "________",
                "pppppppp",
                "rnbqkbnr",
                "w"
        );

        // Load the chess game from the representation
        chessGame.loadChessGame(chessboard);

        // Check if the current player is set correctly
        Assertions.assertEquals(ChessColor.WHITE, chessGame.getCurrentPlayer(), "Current player should be WHITE after loading");

        // Check if pieces are placed correctly
        Assertions.assertTrue(chessGame.getChess(0, 0) instanceof RookChessComponent, "Top left should have a Rook");
        Assertions.assertTrue(chessGame.getChess(1, 0) instanceof PawnChessComponent, "Second row should have a Pawn");
    }

    //@Test
    public void testKnightChessComponentCanMoveTo_t816() throws Exception {
        // Create a new KnightChessComponent at position (3,3)
        KnightChessComponent knight = new KnightChessComponent();
        //mis
        Field sourceField = KnightChessComponent.class.getDeclaredField("source");
        sourceField.setAccessible(true);
        sourceField.set(knight, new ChessboardPoint(3, 3));

        // Set the chess components array to simulate a chessboard
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        knight.setChessComponents(chessComponents); // Using reflection to set private field
        chessComponents[3][3] = knight;

        // Add pieces around the knight
        chessComponents[4][5] = new EmptySlotComponent(); // Valid move
        chessComponents[5][4] = new EmptySlotComponent(); // Valid move
        chessComponents[2][1] = new KingChessComponent(); // Blocked move

        // Call canMoveTo() and check possible moves
        List<ChessboardPoint> possibleMoves = knight.canMoveTo();
        Assertions.assertEquals(4, possibleMoves.size(), "Knight should have 4 valid moves from (3,3)");

        // Check specific positions
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(4, 5)), "Knight can move to (4,5)");
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(5, 4)), "Knight can move to (5,4)");
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(2, 1)), "Knight can move to (2,1)");
        Assertions.assertTrue(possibleMoves.contains(new ChessboardPoint(1, 2)), "Knight can move to (1,2)");
    }


}
