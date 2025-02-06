import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {
    

    @Test
    public void testTreasureCreationAndScoreRetrieval_yznv() throws Exception {
        // Create a Position for the treasure
        Position treasurePosition = new Position(0, 1);
        // Create a Treasure with a score of 10 at the given position
        Treasure treasure = new Treasure(10, treasurePosition);

        // Verify that the score is correctly retrieved
        Assertions.assertEquals(10, invokePrivateMethod_fwd5(treasure, "getScore"));
        // Verify that the position is correctly retrieved
        Assertions.assertTrue(treasurePosition.equals(invokePrivateMethod_fwd5(treasure, "getPosition")));
    }

    @Test
    public void testMapInitializationAndTreasureRetrieval_tjj7() throws Exception {
        // Create treasures
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2))
        };
        // Create a Map with specified rows and columns
        Map map = new Map(3, 5, treasures);

        // Check for treasure at a specific position
        Assertions.assertEquals(10, invokePrivateMethod_fwd5(map, "hasTreasure", new Position(0, 2)));
        Assertions.assertEquals(0, invokePrivateMethod_fwd5(map, "hasTreasure", new Position(1, 1))); // No treasure here
    }

    @Test
    public void testPlayerMovementAndScoreAccumulation_me1x() throws Exception {
        // Create treasures
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2))
        };
        // Create a Map
        Map map = new Map(3, 5, treasures);
        // Create a Player at initial position (0, 0)
        Player player = new Player(map, new Position(0, 0));

        // Move the player right to collect the first treasure
        player.move(Direction.RIGHT, 1); // Should collect the treasure at (0, 1)
        // Move the player right again to collect the second treasure
        player.move(Direction.RIGHT, 1); // Should collect the treasure at (0, 2)

        // Verify player's score and steps
        Assertions.assertEquals(15, invokePrivateMethod_fwd5(player, "getScore")); // 5 + 10
        Assertions.assertEquals(2, invokePrivateMethod_fwd5(player, "getSteps")); // 2 steps taken
    }

    @Test
    public void testGameWinnerDetermination_lbs3() throws Exception {
        GameSystem game = new GameSystem();
        // Create treasures
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2))
        };
        // Create a Map
        Map map = game.newGame(3, 5, treasures);
        // Create Players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 3));
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Move players
        player1.move(Direction.RIGHT, 2); // Collects treasures
        player2.move(Direction.LEFT, 1); // No treasure, just moves

        // Check for winner
        Player winner = game.getWinner();
        Assertions.assertTrue(winner.equals(player1)); // player1 should be the winner with higher score
    }

    // Helper method to invoke private methods using reflection
    private Object invokePrivateMethod_fwd5(Object obj, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    //@Test
    public void testPlayerMovementAndTreasureCollection_9czo() throws Exception {
        // Create a GameSystem and a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        Map map = game.newGame(3, 5, treasures);

        // Initialize players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 4), 4);
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player 1 moves to collect treasures
        player1.move(Direction.RIGHT, 2); // Should collect the treasure at (0, 1)
        player1.move(Direction.UP, 1); // Should hit boundary, moving only 1 step up
        player1.move(Direction.LEFT, 1); // Should collect the treasure at (0, 2)

        // Assert player1's state after movements
        assertEquals(2, player1.getSteps());
        assertEquals(15, player1.getScore()); // 5 + 10 from collected treasures
        assertEquals(new Position(0, 2), player1.getPosition());

        // Player 2 attempts to move
        player2.move(Direction.LEFT, 2); // Should not collect any treasure
        player2.move(Direction.UP, 1); // Should hit boundary
        assertEquals(2, player2.getSteps()); // Only 2 steps taken
        assertEquals(new Position(1, 2), player2.getPosition()); // Position after movements

        // Check if the game identifies the winner correctly
        Player winner = game.getWinner();
        assertTrue(winner.equals(player1)); // player1 should be the winner
    }

    //@Test
    public void testPlayerMaxStepLimit_fgsx() throws Exception {
        // Create a GameSystem and a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        Map map = game.newGame(3, 5, treasures);

        // Initialize a player with max steps
        Player player1 = new Player(map, new Position(0, 0), 3);
        game.addPlayer(player1);

        // Player moves towards treasures
        assertTrue(player1.move(Direction.RIGHT, 2)); // Moves to (0, 2), collects treasure
        assertFalse(player1.move(Direction.RIGHT, 2)); // Can't move to (0, 3) due to max steps
        assertEquals(5, player1.getScore()); // Only treasure at (0, 1) collected
        assertEquals(new Position(0, 2), player1.getPosition()); // Position after movement
        assertEquals(2, player1.getSteps()); // Steps taken
    }

    @Test
    public void testInactiveMapAndPlayerMovement_q9e3() throws Exception {
        // Create a GameSystem and a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        Map map = game.newGame(3, 5, treasures);

        // Initialize players
        Player player1 = new Player(map, new Position(0, 0));
        game.addPlayer(player1);

        // Player moves to collect treasures
        player1.move(Direction.RIGHT, 2); // Collects both treasures
        player1.move(Direction.UP, 1); // Hits boundary

        // Assert map is inactive after treasures collected
        Method isActiveMethod = Map.class.getDeclaredMethod("isActive");
        isActiveMethod.setAccessible(true);
        assertFalse((Boolean) isActiveMethod.invoke(map)); // Map should be inactive now

        // Player tries to move on inactive map
        assertFalse(player1.move(Direction.DOWN, 1)); // Should not move, map is inactive
    }

    @Test
    public void testPositionEqualsMethod_5q29() throws Exception {
        // Create two positions
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        Position pos3 = new Position(2, 3);

        // Test equals method
        assertTrue(pos1.equals(pos2)); // Should be equal
        assertFalse(pos1.equals(pos3)); // Should not be equal
        assertFalse(pos1.equals(null)); // Should not be null
    }

    @Test
    public void testPlayerMovementAndTreasureCollection_3gwl() throws Exception {
        // Create a GameSystem instance and set up a map with treasures.
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player and add it to the game.
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player to collect the first treasure.
        player.move(Direction.RIGHT, 1); // Move to (0, 1) and collect the first treasure.
        player.move(Direction.DOWN, 1);   // Move to (1, 1) and collect the second treasure.

        // Assert player's score after collecting treasures.
        Assertions.assertEquals(15, player.getScore()); // Total score should be 15.
        Assertions.assertEquals(2, player.getSteps());  // Total steps taken should be 2.
    }

    @Test
    public void testPlayerMovementBoundary_fdl4() throws Exception {
        // Create a GameSystem instance and set up a map with treasures.
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player and add it to the game.
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player to the right until hitting the boundary.
        player.move(Direction.RIGHT, 2); // Move to (0, 1) then attempt to move to (0, 2).

        // Assert player's position and steps after hitting the boundary.
        Assertions.assertEquals(1, player.getSteps()); // Should only be able to move to (0, 1).
        Assertions.assertTrue(player.getPosition().equals(new Position(0, 1))); // Player should be at (0, 1).
    }

    //@Test
    public void testMapInactiveAfterAllTreasuresFound_ecdn() throws Exception {
        // Create a GameSystem instance and set up a map with treasures.
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 0));
        Map map = game.newGame(2, 2, treasures);

        // Create a player and add it to the game.
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move to collect both treasures.
        player.move(Direction.RIGHT, 1); // Collect first treasure at (0, 1).
        player.move(Direction.DOWN, 1);   // Collect second treasure at (1, 0).

        // Assert that the map is inactive after all treasures have been found.
        Method isActiveMethod = Map.class.getDeclaredMethod("isActive");
        isActiveMethod.setAccessible(true);
        boolean isActive = (boolean) isActiveMethod.invoke(map);
        Assertions.assertFalse(isActive); // Map should be inactive.
    }

    //@Test
    public void testGetWinnerWithSameScoreDifferentSteps_omqa() throws Exception {
        // Create a GameSystem instance and set up a map with treasures.
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 0));
        Map map = game.newGame(2, 2, treasures);

        // Create players and add them to the game.
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 0));
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player 1 collects one treasure.
        player1.move(Direction.RIGHT, 1); // Collect treasure at (0, 1).
        // Player 2 does not collect any treasure.
        player2.move(Direction.DOWN, 1);   // Move to (1, 0) but no treasure there.

        // Player 1's score is 5, Player 2's score is 0.
        Assertions.assertEquals(player1.getScore(), 5);
        Assertions.assertEquals(player2.getScore(), 0);

        // Get the winner of the game.
        Player winner = game.getWinner();
        Assertions.assertEquals(winner, player1); // Player 1 should be the winner.
    }

    @Test
    public void testPlayerMovementAndTreasureCollection_13di() throws Exception {
        // Create a new GameSystem instance
        GameSystem game = new GameSystem();

        // Define treasures and their positions
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(10, new Position(0, 1));
        treasures[1] = new Treasure(5, new Position(1, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player starting at (0,0)
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player right to collect the first treasure
        Assertions.assertTrue(player.move(Direction.RIGHT, 1)); // Move to (0,1)
        Assertions.assertEquals(10, player.getScore()); // Player should have collected 10 points

        // Move down to collect the second treasure
        Assertions.assertTrue(player.move(Direction.DOWN, 1)); // Move to (1,1)
        Assertions.assertEquals(15, player.getScore()); // Player should have total score of 15

        // Check if the map is inactive after collecting all treasures
        Assertions.assertFalse(map.isActive()); // Map should be inactive
    }

    //@Test
    public void testPlayerBoundaryAndMaxSteps_e5xs() throws Exception {
        // Create a new GameSystem instance
        GameSystem game = new GameSystem();

        // Define treasures and their positions
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player with a maximum of 2 steps
        Player player = new Player(map, new Position(0, 0), 2);
        game.addPlayer(player);

        // Attempt to move the player down, which should be successful
        Assertions.assertTrue(player.move(Direction.DOWN, 1)); // Move to (1,0)

        // Attempt to move the player down again, which should fail due to max steps
        Assertions.assertFalse(player.move(Direction.DOWN, 1)); // Player cannot move to (2,0)

        // Check player's current position and steps
        Assertions.assertEquals(1, player.getSteps()); // Player should have taken 1 step
        Assertions.assertEquals(0, player.getPosition().getRow()); // Player should still be in row 1
    }

    //@Test
    public void testPlayerEqualsMethod_9qgc() throws Exception {
        // Create a new GameSystem instance
        GameSystem game = new GameSystem();

        // Define treasures and their positions
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create two players with the same ID
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 0));

        // Use reflection to set the same ID for both players
        Method setIdMethod = Player.class.getDeclaredMethod("setId", int.class);
        setIdMethod.setAccessible(true);
        setIdMethod.invoke(player1, 1);
        setIdMethod.invoke(player2, 1);

        // Check if both players are equal
        Assertions.assertTrue(player1.equals(player2)); // Should be true as IDs are the same
    }

    @Test
    public void testMapHasTreasureMethod_79gr() throws Exception {
        // Create a new GameSystem instance
        GameSystem game = new GameSystem();

        // Define treasures and their positions
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(20, new Position(0, 0));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player
        Player player = new Player(map, new Position(1, 1));
        game.addPlayer(player);

        // Check if the map reports the treasure at (0,0)
        Assertions.assertEquals(20, map.hasTreasure(new Position(0, 0))); // Should return the score of the treasure
        Assertions.assertEquals(0, map.hasTreasure(new Position(1, 1))); // Should return 0 as there's no treasure at (1,1)
    }

    //@Test
    public void testPlayerMovementAndScoreUpdate_olvk() throws Exception {
        // Initialize the game system and create treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(10, new Position(0, 1));
        treasures[1] = new Treasure(5, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player and add to the game
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player to acquire the first treasure
        player.move(Direction.RIGHT, 1); // Move to (0, 1)
        player.move(Direction.DOWN, 1); // Move to (1, 1)

        // Verify player's score and steps after movement
        assertEquals(15, player.getScore()); // Score should be 10 + 5
        assertEquals(2, player.getSteps()); // Steps should be 2
        assertTrue(map.isActive()); // Map should still be active

        // Now move to a position without treasure
        player.move(Direction.LEFT, 1); // Move back to (1, 0)
        assertEquals(2, player.getSteps()); // Steps should remain 2
    }

    @Test
    public void testPlayerMaxStepsAndBoundaryCheck_w3e1() throws Exception {
        // Initialize the game system with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 0));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player with max steps
        Player player = new Player(map, new Position(0, 0), 2);
        game.addPlayer(player);

        // Attempt to move beyond the map's boundary
        boolean moved = player.move(Direction.UP, 3); // Attempt to move up 3 steps
        assertTrue(!moved); // Should not be able to move

        // Verify player position and steps
        assertEquals(0, player.getSteps()); // Steps should still be 0
        assertTrue(player.getPosition().equals(new Position(0, 0))); // Should remain at (0, 0)
    }

    @Test
    public void testGameWinnerLogic_jfey() throws Exception {
        // Initialize game system and treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[3];
        treasures[0] = new Treasure(20, new Position(0, 0));
        treasures[1] = new Treasure(15, new Position(0, 1));
        treasures[2] = new Treasure(10, new Position(1, 0));
        Map map = game.newGame(2, 2, treasures);

        // Create players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 1), 3);
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player 1 moves to acquire treasures
        player1.move(Direction.RIGHT, 1); // Move to (0, 1)
        player1.move(Direction.DOWN, 1); // Move to (1, 1) - should not acquire
        player1.move(Direction.LEFT, 1); // Move back to (1, 0)

        // Player 2 moves
        player2.move(Direction.UP, 1); // Move to (0, 1)

        // Determine the winner
        Player winner = game.getWinner();
        assertTrue(winner.equals(player1)); // Player 1 should be the winner
    }

    //@Test
    public void testMapInactiveAfterAllTreasuresFound_92cd() throws Exception {
        // Initialize game and treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 0));
        Map map = game.newGame(1, 1, treasures);

        // Create player
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Player acquires the treasure
        player.move(Direction.RIGHT, 1); // Should not be able to move
        assertEquals(5, player.getScore()); // Score should be 5
        assertTrue(!map.isActive()); // Map should be inactive after treasure is found
    }

    @Test
    public void testPlayerMovementAndTreasureAcquisition_t5dv() throws Exception {
        // Create a GameSystem instance and set up a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player and add them to the game
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player down and right to acquire the first treasure
        player.move(Direction.DOWN, 1); // Moves to (1,0)
        player.move(Direction.RIGHT, 1); // Moves to (1,1) and acquires the treasure

        // Validate the player's score and position
        assertEquals(10, player.getScore());
        assertEquals(2, player.getSteps());
        assertTrue(player.getPosition().equals(new Position(1, 1)));

        // Move the player to acquire the second treasure
        player.move(Direction.UP, 1); // Moves to (0,1) and acquires the treasure

        // Validate the player's updated score and position
        assertEquals(15, player.getScore());
        assertEquals(3, player.getSteps());
        assertTrue(player.getPosition().equals(new Position(0, 1)));
    }

    //@Test
    public void testPlayerBoundaryAndInactiveMap_fjk5() throws Exception {
        // Set up a new game and map
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player with maximum steps allowed
        Player player = new Player(map, new Position(0, 0), 2);
        game.addPlayer(player);

        // Move the player to acquire the treasure
        player.move(Direction.DOWN, 1); // Moves to (1,0)
        player.move(Direction.RIGHT, 1); // Moves to (1,1) and acquires the treasure

        // Validate that the map is inactive after acquiring all treasures
        assertFalse(map.isActive());

        // Attempt to move the player while the map is inactive
        boolean result = player.move(Direction.UP, 1); // Should return false

        // Validate that the player did not move and remains in the same position
        assertFalse(result);
        assertTrue(player.getPosition().equals(new Position(1, 1)));
    }

    @Test
    public void testPlayerEqualsMethod_4plz() throws Exception {
        // Set up a new game and map
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create two players with different IDs
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 1));

        // Validate that players are not equal based on different IDs
        assertFalse(player1.equals(player2));

        // Use reflection to set player1's ID to be the same as player2's
        Field idField = Player.class.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(player1, idField.get(player2));

        // Validate that players are now equal
        assertTrue(player1.equals(player2));
    }

    @Test
    public void testGameSystemWinnerSelection_zqnv() throws Exception {
        // Set up a new game and map
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create players with different scores and steps
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 1));
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Simulate movements to acquire treasures
        player1.move(Direction.DOWN, 1); // Moves to (1,0) and acquires no treasure
        player1.move(Direction.RIGHT, 1); // Moves to (1,1) and acquires the treasure

        player2.move(Direction.DOWN, 1); // Moves to (1,1) but can't acquire it
        player2.move(Direction.RIGHT, 1); // Moves out of bounds

        // Validate the winner selection
        Player winner = game.getWinner();
        assertTrue(winner.equals(player1)); // player1 should be the winner
    }

    //@Test
    public void testPlayerMovementAndTreasureCollection_9336() throws Exception {
        // Initialize GameSystem and Map with Treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        treasures[2] = new Treasure(2, new Position(0, 4));
        treasures[3] = new Treasure(15, new Position(1, 3));
        Map map = game.newGame(3, 5, treasures);

        // Create Players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 4), 4);
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Move Player1 to collect treasures
        player1.move(Direction.DOWN, 2); // Move down to (2,0)
        player1.move(Direction.RIGHT, 2); // Move right to (2,2) -> No treasure
        player1.move(Direction.UP, 4); // Move up to (0,2) -> Collect treasure 10

        // Assert Player1's score and position
        assertEquals(10, player1.getScore()); // Score should be 10 after collecting
        assertTrue(player1.getPosition().equals(new Position(0, 2))); // Position should be (0,2)

        // Move Player2 to attempt collecting treasures
        player2.move(Direction.LEFT, 2); // Move left to (1,2) -> No treasure
        player2.move(Direction.UP, 1); // Move up to (0,2) -> Already collected by Player1

        // Assert Player2's score and position
        assertEquals(0, player2.getScore()); // Score should remain 0
        assertTrue(player2.getPosition().equals(new Position(1, 2))); // Position should be (1,2)
    }

    @Test
    public void testPlayerMovementBoundaryAndInactiveMap_yv30() throws Exception {
        // Initialize GameSystem and Map with Treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 0));
        Map map = game.newGame(2, 2, treasures);

        // Create Players
        Player player1 = new Player(map, new Position(0, 0));
        game.addPlayer(player1);

        // Move Player1 to collect first treasure
        player1.move(Direction.RIGHT, 1); // Move right to (0,1) -> Collect treasure 5
        player1.move(Direction.DOWN, 1); // Move down to (1,1) -> No treasure

        // Assert Player1's score and position
        assertEquals(5, player1.getScore()); // Score should be 5
        assertTrue(player1.getPosition().equals(new Position(1, 1))); // Position should be (1,1)

        // Move Player1 to inactive map
        player1.move(Direction.LEFT, 1); // Move left to (1,0) -> Collect treasure 10
        player1.move(Direction.DOWN, 1); // Move down out of bounds -> Should stop moving

        // Assert Player1's final state
        assertEquals(15, player1.getScore()); // Score should be 15
        assertTrue(player1.getPosition().equals(new Position(1, 0))); // Position should be (1,0)

        // Attempt to move after all treasures collected
        assertFalse(player1.move(Direction.UP, 1)); // Map is inactive, should not move
    }

    @Test
    public void testPlayerEqualityAndId_1tiy() throws Exception {
        // Initialize GameSystem and Map
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));
        Map map = game.newGame(1, 2, treasures);

        // Create Players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 0));

        // Assert equality based on ID
        Method getIdMethod = Player.class.getDeclaredMethod("getId");
        getIdMethod.setAccessible(true);
        int id1 = (int) getIdMethod.invoke(player1);
        int id2 = (int) getIdMethod.invoke(player2);

        assertNotEquals(id1, id2); // IDs should be different

        // Assert equals method
        assertFalse(player1.equals(player2)); // Should not be equal based on different IDs
    }

    @Test
    public void testWinnerDetermination_nwjf() throws Exception {
        // Initialize GameSystem and Map with Treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[3];
        treasures[0] = new Treasure(10, new Position(0, 0));
        treasures[1] = new Treasure(20, new Position(0, 1));
        treasures[2] = new Treasure(15, new Position(1, 0));
        Map map = game.newGame(2, 2, treasures);

        // Create Players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 1));
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player1 collects all treasures
        player1.move(Direction.RIGHT, 1); // Move to (0,1) -> Collect 20
        player1.move(Direction.DOWN, 1); // Move to (1,1) -> No treasure
        player1.move(Direction.LEFT, 1); // Move to (1,0) -> Collect 15

        // Player2 attempts to move
        player2.move(Direction.LEFT, 1); // Move to (1,0) -> Already collected

        // Determine winner
        Player winner = game.getWinner();
        assertTrue(winner.equals(player1)); // Player1 should be the winner with highest score
    }

    @Test
    public void testPlayerMovementAndTreasureCollection_xwvc() throws Exception {
        // Initialize the game system and create treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));

        // Start a new game with a map
        Map map = game.newGame(3, 5, treasures);

        // Create a player and add to the game
        Player player1 = new Player(map, new Position(0, 0));
        game.addPlayer(player1);

        // Move player1 to collect treasures
        player1.move(Direction.RIGHT, 1); // Move to (0,1), collect treasure of score 5
        player1.move(Direction.RIGHT, 1); // Move to (0,2), collect treasure of score 10

        // Check player score after collecting treasures
        assertEquals(15, player1.getScore());
        assertEquals(2, player1.getSteps()); // Total steps taken

        // Ensure that the position is updated correctly
        assertTrue(player1.getPosition().equals(new Position(0, 2)));
    }

    @Test
    public void testPlayerMovementBoundary_jol9() throws Exception {
        // Initialize the game system and create treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(1, 1));
        treasures[1] = new Treasure(10, new Position(1, 2));

        // Start a new game with a map
        Map map = game.newGame(3, 3, treasures);

        // Create a player and add to the game
        Player player2 = new Player(map, new Position(2, 2), 3); // Max steps allowed = 3
        game.addPlayer(player2);

        // Move player2 towards the boundary
        player2.move(Direction.DOWN, 1); // Can't move, at boundary
        player2.move(Direction.LEFT, 1); // Move to (2,1)
        player2.move(Direction.LEFT, 1); // Move to (2,0)

        // Check that player2 is at the correct position and has not collected any treasures
        assertTrue(player2.getPosition().equals(new Position(2, 0)));
        assertEquals(0, player2.getScore());
        assertEquals(2, player2.getSteps()); // Total steps taken
    }

    @Test
    public void testInactiveMapAfterAllTreasuresCollected_qzxs() throws Exception {
        // Initialize the game system and create treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[3];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        treasures[2] = new Treasure(15, new Position(1, 0));

        // Start a new game with a map
        Map map = game.newGame(3, 3, treasures);

        // Create players and add to the game
        Player player3 = new Player(map, new Position(0, 0));
        game.addPlayer(player3);

        // Collect all treasures
        player3.move(Direction.RIGHT, 1); // Collect (0,1)
        player3.move(Direction.RIGHT, 1); // Collect (0,2)
        player3.move(Direction.DOWN, 1); // Collect (1,2) (no treasure here)
        player3.move(Direction.LEFT, 1); // Collect (1,1) (no treasure here)
        player3.move(Direction.LEFT, 1); // Move to (1,0) and collect treasure of score 15

        // Check if the map is inactive after collecting all treasures
        assertTrue(!map.isActive());
        assertEquals(30, player3.getScore()); // Total score after collecting all treasures
    }

    //@Test
    public void testGetWinnerWithEqualScores_sbpe() throws Exception {
        // Initialize the game system and create treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));

        // Start a new game with a map
        Map map = game.newGame(3, 5, treasures);

        // Create players and add to the game
        Player player4 = new Player(map, new Position(0, 0));
        Player player5 = new Player(map, new Position(1, 0));
        game.addPlayer(player4);
        game.addPlayer(player5);

        // Move both players to collect treasures
        player4.move(Direction.RIGHT, 2); // Collects 5 and 10
        player5.move(Direction.RIGHT, 2); // Also collects 5 and 10

        // Check the scores of both players
        assertEquals(15, player4.getScore());
        assertEquals(15, player5.getScore());

        // Get the winner
        Player winner = game.getWinner();
        assertTrue(winner.equals(player4) || winner.equals(player5)); // Both have same score, but the winner will be the first player added
    }

    //@Test
    public void testPlayerMovementAndTreasureCollection_zkjw() throws Exception {
        // Create a new game system and initialize the treasures and map
        GameSystem game = new GameSystem();
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2)),
                new Treasure(2, new Position(0, 4)),
                new Treasure(15, new Position(1, 3))
        };
        Map map = game.newGame(3, 5, treasures);

        // Create players and add them to the game
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 4), 4);
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player 1 moves down and right to collect treasures
        player1.move(Direction.DOWN, 2); // Moves to (2, 0)
        player1.move(Direction.RIGHT, 2); // Moves to (2, 2) - no treasure
        player1.move(Direction.UP, 4); // Can only move up 2 to (0, 2) and collects treasure

        // Player 2 moves left and attempts to collect a treasure
        player2.move(Direction.LEFT, 2); // Moves to (1, 2) - no treasure
        player2.move(Direction.UP, 1); // Moves to (0, 2) - already collected by player1

        // Assert the final positions and scores
        Assertions.assertEquals(2, player1.getSteps());
        Assertions.assertEquals(15, player1.getScore());
        Assertions.assertEquals(2, player2.getSteps());
        Assertions.assertEquals(0, player2.getScore());

        // Check if the map is still active
        Assertions.assertTrue(map.isActive());
    }

    //@Test
    public void testPlayerMaxStepsAndBoundaryConditions_e1f4() throws Exception {
        // Initialize game system and treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2)),
                new Treasure(2, new Position(0, 4)),
                new Treasure(15, new Position(1, 3))
        };
        Map map = game.newGame(3, 5, treasures);

        // Create a player with a max step allowed
        Player player = new Player(map, new Position(0, 0), 3);
        game.addPlayer(player);

        // Player attempts to move beyond map boundaries
        player.move(Direction.RIGHT, 5); // Should only move 4 to (0, 4)
        player.move(Direction.DOWN, 1); // Should move to (1, 4) - no treasure

        // Assert player position and steps
        Assertions.assertEquals(5, player.getSteps());
        Assertions.assertEquals(0, player.getScore());
        Assertions.assertEquals(new Position(1, 4), player.getPosition());

        // Attempt to move again after max steps
        boolean canMove = player.move(Direction.LEFT, 1); // Should not move
        Assertions.assertFalse(canMove);
    }

    @Test
    public void testGameWinnerLogic_ih5j() throws Exception {
        // Initialize game system and treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2)),
                new Treasure(2, new Position(0, 4)),
                new Treasure(15, new Position(1, 3))
        };
        Map map = game.newGame(3, 5, treasures);

        // Create players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 4), 4);
        Player player3 = new Player(map, new Position(0, 3));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        // Simulate movements
        player1.move(Direction.DOWN, 2); // Collects treasures
        player1.move(Direction.RIGHT, 2);
        player1.move(Direction.UP, 4);
        player2.move(Direction.LEFT, 2);
        player2.move(Direction.UP, 1);
        player1.move(Direction.LEFT, 3);
        player2.move(Direction.RIGHT, 2);
        player3.move(Direction.RIGHT, 1);
        player3.move(Direction.DOWN, 2); // Should not move as map is inactive

        // Determine the winner
        Player winner = game.getWinner();

        // Assert the winner is the correct player based on score and steps
        Assertions.assertEquals(player2, winner);
    }

    @Test
    public void testPositionEquality_ecf1() throws Exception {
        // Create two positions and assert equality
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        Position pos3 = new Position(2, 1);

        // Test equality method
        Assertions.assertTrue(pos1.equals(pos2)); // Should be equal
        Assertions.assertFalse(pos1.equals(pos3)); // Should not be equal
    }

    @Test
    public void testPlayerMovementAndTreasureCollection_65k0() throws Exception {
        // Create a new GameSystem
        GameSystem game = new GameSystem();

        // Create treasures
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player at (0, 0)
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player down and right to collect treasures
        player.move(Direction.DOWN, 1); // Move to (1, 0)
        player.move(Direction.RIGHT, 1); // Move to (1, 1), collect treasure of score 10

        // Verify player score and position
        assertEquals(10, getPrivateField_wafr(player, "score"));
        assertEquals(new Position(1, 1), player.getPosition());

        // Move player up to (0, 1) to collect another treasure
        player.move(Direction.UP, 1); // Move to (0, 1), collect treasure of score 5

        // Verify updated score and position
        assertEquals(15, getPrivateField_wafr(player, "score"));
        assertEquals(new Position(0, 1), player.getPosition());
    }

    @Test
    public void testPlayerMovementBoundary_cgj7() throws Exception {
        // Create a new GameSystem
        GameSystem game = new GameSystem();

        // Create treasures
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player at (0, 0)
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Attempt to move the player beyond the boundary
        player.move(Direction.UP, 1); // Should not move, out of bounds
        player.move(Direction.LEFT, 1); // Should not move, out of bounds

        // Verify position remains unchanged
        assertEquals(new Position(0, 0), player.getPosition());
        assertEquals(0, getPrivateField_wafr(player, "steps")); // Steps should still be 0
    }

    //@Test
    public void testMaxStepsMovement_rjjs() throws Exception {
        // Create a new GameSystem
        GameSystem game = new GameSystem();

        // Create treasures
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(5, new Position(0, 1));

        // Start a new game with a map of size 2x2
        Map map = game.newGame(2, 2, treasures);

        // Create a player at (0, 0) with max 2 steps
        Player player = new Player(map, new Position(0, 0), 2);
        game.addPlayer(player);

        // Move the player right and down
        player.move(Direction.RIGHT, 1); // Move to (0, 1), collect treasure of score 5
        player.move(Direction.DOWN, 1); // Move to (1, 1)

        // Verify player score and steps taken
        assertEquals(5, getPrivateField_wafr(player, "score"));
        assertEquals(2, getPrivateField_wafr(player, "steps")); // Should equal max steps
    }

    @Test
    public void testPositionEquality_kl37() throws Exception {
        // Create positions for testing
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 0);
        Position pos3 = new Position(1, 1);

        // Check equality using the equals method
        assertTrue(pos1.equals(pos2)); // Should be equal
        assertFalse(pos1.equals(pos3)); // Should not be equal
    }

    // Helper method to get private field values
    private Object getPrivateField_wafr(Object obj, String fieldName) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    // Helper method to set private field values
    private void setPrivateField_h6t0(Object obj, String fieldName, Object value) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    // Helper method to invoke the equals method
    private boolean invokeEquals_w1k8(Player player1, Object player2) throws Exception {
        Method equalsMethod = player1.getClass().getDeclaredMethod("equals", Object.class);
        equalsMethod.setAccessible(true);
        return (boolean) equalsMethod.invoke(player1, player2);
    }

    @Test
    public void testPlayerMovementAndScore_mfbv() throws Exception {
        // Create a new GameSystem
        GameSystem game = new GameSystem();

        // Create treasures and initialize a map
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(0, 2));
        Map map = game.newGame(2, 3, treasures);

        // Create a player at position (0,0)
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move player to the right to collect the first treasure
        player.move(Direction.RIGHT, 1); // Collects treasure at (0,1)
        player.move(Direction.RIGHT, 1); // Moves to (0,2) and collects the second treasure

        // Verify the player's score and position
        assertEquals(15, player.getScore());
        assertEquals(new Position(0, 2), player.getPosition());
        assertEquals(2, player.getSteps());
    }

    //@Test
    public void testPlayerMaxStepsAndBoundary_22h6() throws Exception {
        // Create a new GameSystem and map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(3, 3, treasures);

        // Create a player with a maximum step limit
        Player player = new Player(map, new Position(0, 0), 3);
        game.addPlayer(player);

        // Move the player beyond the map boundaries
        player.move(Direction.DOWN, 5); // Attempt to move down 5 steps


        // Verify the player's steps and position
        assertEquals(3, player.getSteps()); // Should only move 3 steps
        assertEquals(new Position(2, 0), player.getPosition()); // Should be at (2,0)
    }

    //@Test
    public void testGameWinnerLogic_eowb() throws Exception {
        // Create a new GameSystem
        GameSystem game = new GameSystem();

        // Create treasures and initialize a map
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(5, new Position(0, 1));
        treasures[1] = new Treasure(10, new Position(1, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create two players
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(1, 0));
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Player 1 collects a treasure
        player1.move(Direction.RIGHT, 1); // Collects treasure at (0,1)
        // Player 2 collects a treasure
        player2.move(Direction.UP, 1); // Collects treasure at (1,1)


        // Verify player scores and steps
        assertEquals(5, player1.getScore());
        assertEquals(10, player2.getScore());
        assertEquals(1, player1.getSteps());
        assertEquals(1, player2.getSteps());

        // Determine the winner
        Player winner = game.getWinner();
        assertTrue(winner.equals(player2)); // Player 2 should win due to higher score
    }

    //@Test
    public void testPlayerEquality_lhv1() throws Exception {
        // Create players
        Player player1 = new Player(new Map(2, 2, new Treasure[0]), new Position(0, 0));
        Player player2 = new Player(new Map(2, 2, new Treasure[0]), new Position(0, 0));
        Player player3 = new Player(new Map(2, 2, new Treasure[0]), new Position(0, 0));

        // Use reflection to access private id field
        Field idField = Player.class.getDeclaredField("id");
        idField.setAccessible(true);
        idField.setInt(player2, 1); // Set player2 id to 1
        idField.setInt(player3, 2); // Set player3 id to 2

        // Verify equality
        assertTrue(player1.equals(player2)); // Should be equal (same ID)
        assertFalse(player1.equals(player3)); // Should not be equal (different ID)
    }

    @Test
    public void testPlayerMovementAndTreasureCollection_9u59() throws Exception {
        // Create a new game system and initialize a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[2];
        treasures[0] = new Treasure(10, new Position(1, 1));
        treasures[1] = new Treasure(5, new Position(1, 2));
        Map map = game.newGame(2, 3, treasures);

        // Create a player and add to the game
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Move the player down and right to collect treasures
        player.move(Direction.DOWN, 1); // Move to (1, 0)
        player.move(Direction.RIGHT, 1); // Move to (1, 1), collects treasure of score 10
        player.move(Direction.RIGHT, 1); // Move to (1, 2), collects treasure of score 5

        // Assert the player's score and position
        assertEquals(15, invokeGetter_fnaz(player, "score")); // Expect score to be 15
        assertTrue(invokeGetter_fnaz(player, "position").equals(new Position(1, 2))); // Expect position to be (1, 2)
    }

    @Test
    public void testPlayerMovementWithBoundaryCheck_ilty() throws Exception {
        // Create a new game system and initialize a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(20, new Position(0, 1));
        Map map = game.newGame(2, 2, treasures);

        // Create a player with maximum steps allowed
        Player player = new Player(map, new Position(0, 0), 2);
        game.addPlayer(player);

        // Move the player down and then try to move out of bounds
        player.move(Direction.DOWN, 1); // Move to (1, 0)
        boolean canMoveOut = player.move(Direction.DOWN, 1); // Attempt to move out of bounds

        // Assert that the player could not move out of bounds
        assertEquals(1, invokeGetter_fnaz(player, "steps")); // Expect steps to be 1
        assertTrue(!canMoveOut); // Expect the move to be unsuccessful
    }

    @Test
    public void testPlayerWithMaxSteps_tt8x() throws Exception {
        // Create a new game system and initialize a map with treasures
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[1];
        treasures[0] = new Treasure(30, new Position(0, 1));
        Map map = game.newGame(1, 2, treasures);

        // Create a player with limited steps
        Player player = new Player(map, new Position(0, 0), 1);
        game.addPlayer(player);

        // Move the player to collect the treasure
        player.move(Direction.RIGHT, 1); // Move to (0, 1) and collect treasure

        // Assert the player's score and steps
        assertEquals(30, player.getScore()); // Expect score to be 30
        assertEquals(1, player.getSteps()); // Expect steps to be 1
    }

    @Test
    public void testPlayerBoundaryMovement_9f5g() throws Exception {
        // Setup GameSystem and initialize a map
        GameSystem game = new GameSystem();
        Treasure[] treasures = {
                new Treasure(5, new Position(0, 1)),
                new Treasure(10, new Position(0, 2))
        };
        Map map = game.newGame(3, 3, treasures);

        // Create a player starting at the top left corner
        Player player = new Player(map, new Position(0, 0));
        game.addPlayer(player);

        // Attempt to move outside the map boundaries
        boolean moved = player.move(Direction.UP, 1); // Attempt to move up
        assertEquals(false, moved, "Player should not move up out of bounds.");

        moved = player.move(Direction.LEFT, 1); // Attempt to move left
        assertEquals(false, moved, "Player should not move left out of bounds.");

        // Now move down and right within the bounds
        moved = player.move(Direction.DOWN, 2); // Move down to (2,0)
        assertEquals(true, moved, "Player should successfully move down.");

        moved = player.move(Direction.RIGHT, 2); // Move right to (2,2)
        assertEquals(true, moved, "Player should successfully move right.");

        // Verify final position
        assertEquals(new Position(2, 2), player.getPosition(), "Player should be at position (2,2).");
    }

    // Helper method to access private fields using reflection
    private Object invokeGetter_fnaz(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }


}
