import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.math.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {




    @Test
    public void testTreasureCreationAndScoreRetrieval_nan1() throws Exception {
        // Step 1: Create a Position object to store the position of the Treasure
        Position position = new Position(5, 5);

        // Step 2: Create a Treasure object with a score of 10 and the created position
        Treasure treasure = new Treasure(10, position);

        // Step 3: Use reflection to access the private field 'score' and validate its value
        Field scoreField = Treasure.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        int score = (int) scoreField.get(treasure);
        Assertions.assertEquals(10, score, "Expected score to be 10");

        // Step 4: Call the method to get score and validate again
        Assertions.assertEquals(10, treasure.getScore(), "Expected score to be 10 from method call");

        // Step 5: Check the position of the Treasure
        Assertions.assertEquals(position, treasure.getPosition(), "Expected position to match the one assigned");
    }

    @Test
    public void testPlayerMovementAndScoreUpdate_7hbd() throws Exception {
        // Step 1: Create a Map with dimensions and a Treasure
        Position treasurePosition = new Position(1, 1);
        Treasure treasure = new Treasure(20, treasurePosition);
// ERROR: incompatible types: Treasure cannot be converted to Treasure[]
//         Map map = new Map(3, 3, treasure);

        // Step 2: Create a Player and set its initial position
        Position initialPosition = new Position(0, 0);
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player = new Player(map, initialPosition);

        // Step 3: Move the player right into the treasure and check score updates
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.RIGHT, 2);

        // Step 4: Check the player's score after picking up the treasure
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         int currentScore = (int) scoreField.get(player);
// ERROR: cannot find symbol
//  symbol:   variable currentScore
//  location: class TestClass
//         Assertions.assertEquals(20, currentScore, "Expected score to be 20 after taking the treasure");

        // Step 5: Check the player's position to ensure it moved correctly
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         Assertions.assertEquals(0, player.getPosition().getRow(), "Expected player row to be the same after boundaries");
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         Assertions.assertEquals(2, player.getPosition().getCol(), "Expected player column to be 2 after moving right");
    }

    //@Test
    public void testGameSystemWinnerIdentification_ep2o() throws Exception {
        // Step 1: Create a Map and Treasures
        Position treasurePosition1 = new Position(2, 2);
        Treasure treasure1 = new Treasure(15, treasurePosition1);
        Position treasurePosition2 = new Position(1, 1);
        Treasure treasure2 = new Treasure(25, treasurePosition2);
// ERROR: constructor Map in class Map cannot be applied to given types;
//  required: int,int,Treasure[]
//  found:    int,int,Treasure,Treasure
//  reason: actual and formal argument lists differ in length
//         Map map = new Map(5, 5, treasure1, treasure2);

        // Step 2: Create two Players with different scores
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player1 = new Player(map, new Position(0, 0));
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player2 = new Player(map, new Position(0, 0));

        // Step 3: Make the first player move to get a treasure, increasing their score
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.RIGHT, 2); // move to (0, 2)

        // Step 4: Make the second player move, but they don't grab any treasure
// ERROR: cannot find symbol
//  symbol:   variable player2
//  location: class TestClass
//         player2.move(Direction.RIGHT, 1); // move to (0, 1)

        // Step 5: Create a GameSystem and add players
        GameSystem gameSystem = new GameSystem();
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         gameSystem.addPlayer(player1);
// ERROR: cannot find symbol
//  symbol:   variable player2
//  location: class TestClass
//         gameSystem.addPlayer(player2);

        // Step 6: Identify the winner of the game
        Player winner = gameSystem.getWinner();

        // Step 7: Assert that player1 is the winner due to their higher score
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         Assertions.assertEquals(player1, winner, "Expected player1 to be the winner due to higher score");
    }

    @Test
    public void testPositionBoundariesAndValidity_41w7() throws Exception {
        // Step 1: Create a Map with size 3x3
// ERROR: incompatible types: Treasure cannot be converted to Treasure[]
//         Map map = new Map(3, 3, new Treasure(10, new Position(1, 1)));

        // Step 2: Create a Player at the boundary position
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player = new Player(map, new Position(0, 0));

        // Step 3: Move Player DOWN out of bounds
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         boolean movedDown = player.move(Direction.DOWN, 1); // trying to move to (1, 0)

        // Step 4: Validate that the move was successful and score should remain 0 for now
// ERROR: cannot find symbol
//  symbol:   variable movedDown
//  location: class TestClass
//         Assertions.assertTrue(movedDown, "Expected player to move DOWN successfully");
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         Assertions.assertEquals(0, player.getScore(), "Expected player score to remain 0 after first move");

        // Step 5: Attempt to move DOWN out of bounds again (to (2, 0))
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         movedDown = player.move(Direction.DOWN, 2); // trying to move to (2, 0) which should not change valid state

        // Step 6: Validate that the player is still in the same position and cannot move out of bounds
// ERROR: cannot find symbol
//  symbol:   variable movedDown
//  location: class TestClass
//         Assertions.assertFalse(movedDown, "Expected player to fail moving DOWN out of bounds");
    }





    //@Test
    public void testPlayerMovementWithTreasureCollection_j8lm() throws Exception {
        // Create a map with dimensions and no treasures
        Map map = new Map(5, 5, new Treasure[0]);
        
        // Create a position and player
        Position playerPosition = new Position(0, 0);
        Player player = new Player(map, playerPosition);
        
        // Add the player to the GameSystem
        GameSystem gameSystem = new GameSystem();
        gameSystem.addPlayer(player);
        
        // Define treasures in a new map and make the player move
        Treasure treasure = new Treasure(10, new Position(1, 1)); // Score 10 at (1, 1)
        Map mapWithTreasure = new Map(5, 5, new Treasure[]{treasure});
        
        // Use reflection to update the map in Player
        Field mapField = Player.class.getDeclaredField("map");
        mapField.setAccessible(true);
        mapField.set(player, mapWithTreasure);
        
        // Move the player to the treasure's position
        player.move(Direction.DOWN, 1); // Should collect the treasure

        // Use reflection to access score field of Player and assert
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        int score = (int) scoreField.get(player);
        
        Assertions.assertEquals(10, score); // Score should be 10 after collection
    }

    @Test
    public void testPlayerMovementWithBoundsChecking_wskb() throws Exception {
        // Create a map and player
        Map map = new Map(3, 3, new Treasure[0]);
        Position playerPosition = new Position(1, 1);
        Player player = new Player(map, playerPosition);

        // Move the player beyond the bounds
        player.move(Direction.UP, 5); // Should stay within the coordinate limits

        // Check player's position
        Field positionField = Player.class.getDeclaredField("position");
        positionField.setAccessible(true);
        Position position = (Position) positionField.get(player);

        Assertions.assertEquals(0, position.getRow()); // Y should be 0 (top boundary)
        Assertions.assertEquals(1, position.getCol()); // X should be 1
    }

    @Test
    public void testWinnerSelectionWithMultiplePlayers_qpkv() throws Exception {
        // Create a Game System and players
        GameSystem gameSystem = new GameSystem();
        Map map = new Map(5, 5, new Treasure[0]);
        
        Player player1 = new Player(map, new Position(0, 0));
        Field scoreField1 = Player.class.getDeclaredField("score");
        scoreField1.setAccessible(true);
        scoreField1.set(player1, 50); // Set score of player1 to 50

        Player player2 = new Player(map, new Position(1, 1));
        Field scoreField2 = Player.class.getDeclaredField("score");
        scoreField2.setAccessible(true);
        scoreField2.set(player2, 30); // Set score of player2 to 30

        // Add players to the game system
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        // Selecting the winner
        Player winner = gameSystem.getWinner();

        Assertions.assertEquals(player1, winner); // Player 1 is the winner
    }

    @Test
    public void testPositionEquality_6jh4() throws Exception {
        // Create two positions
        Position position1 = new Position(2, 3);
        Position position2 = new Position(2, 3);
        Position position3 = new Position(1, 2);

        // Use reflection to access equals method
        Field posField = Position.class.getDeclaredField("row");
        posField.setAccessible(true);
        boolean isEqual = position1.equals(position2);
        boolean isNotEqual = position1.equals(position3);

        Assertions.assertTrue(isEqual); // position1 should equal position2
        Assertions.assertFalse(isNotEqual); // position1 should not equal position3
    }





    @Test
    public void testPlayerConstructorAndScoreUpdate_6j9i() throws Exception {
        // Create a Position at (0,0)
        Position position = new Position(0, 0);

        // Create a Treasure at the same Position with a score of 10
        Treasure treasure = new Treasure(10, position);

        // Create a Map with 1 row, 1 column, and the Treasure
// ERROR: incompatible types: Treasure cannot be converted to Treasure[]
//         Map map = new Map(1, 1, treasure);

        // Create a Player with max steps allowed as 5 positioned at (0,0)
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player = new Player(map, position, 5);

        // The player moves RIGHT, which should not affect its position since it's a single column.
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.RIGHT, 1);

        // Check if score updates correctly after moving onto the treasure
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         int score = (int) scoreField.get(player);
// ERROR: cannot find symbol
//  symbol:   variable score
//  location: class TestClass
//         Assertions.assertEquals(10, score, "Player score should be updated to 10 after collecting the treasure.");

        // Check that the player has taken one step
        Field stepsField = Player.class.getDeclaredField("steps");
        stepsField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         int steps = (int) stepsField.get(player);
// ERROR: cannot find symbol
//  symbol:   variable steps
//  location: class TestClass
//         Assertions.assertEquals(1, steps, "Player should have taken 1 step.");
    }

    @Test
    public void testMapTreasureCollectionAndDeactivation_1fxz() throws Exception {
        // Create a Position and a Map with treasure
        Position treasurePosition = new Position(0, 0);
        Treasure treasure = new Treasure(10, treasurePosition);
// ERROR: incompatible types: Treasure cannot be converted to Treasure[]
//         Map map = new Map(1, 1, treasure);

        // Create Player at treasure position with max step allowed
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player = new Player(map, treasurePosition, 3);

        // Player moves LEFT but should be constrained by map's boundaries
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.LEFT, 1);

        // Player should collect treasure, and the treasure's score should update
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         int score = (int) scoreField.get(player);
// ERROR: cannot find symbol
//  symbol:   variable score
//  location: class TestClass
//         Assertions.assertEquals(10, score, "Player should have collected treasure worth 10 points.");

        // Now check if the map is still active
        Field isActiveField = Map.class.getDeclaredField("isActive");
        isActiveField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         boolean isActive = (boolean) isActiveField.get(map);
// ERROR: cannot find symbol
//  symbol:   variable isActive
//  location: class TestClass
//         Assertions.assertFalse(isActive, "Map should be deactivated since the treasure has been collected.");
    }

    @Test
    public void testWinnerSelectionWithEqualScores_qjdn() throws Exception {
        // Create two players with the same score
        Map map = new Map(1, 1, new Treasure[0]); // empty map as no treasure is needed
        Player player1 = new Player(map, new Position(0, 0), 5);
        Player player2 = new Player(map, new Position(0, 0), 5);

        // Simulate both players scoring the same points
        Field scoreField1 = Player.class.getDeclaredField("score");
        Field scoreField2 = Player.class.getDeclaredField("score");
        scoreField1.setAccessible(true);
        scoreField2.setAccessible(true);
        scoreField1.set(player1, 10);
        scoreField2.set(player2, 10);
        
        // Create GameSystem and add players
        GameSystem gameSystem = new GameSystem();
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        // Determine the winner
// ERROR: cannot find symbol
//  symbol:   method findWinner()
//  location: variable gameSystem of type GameSystem
//         Player winner = gameSystem.findWinner();

        // Both players have the same score, but since player1 was added first, they should be the winner
// ERROR: cannot find symbol
//  symbol:   variable winner
//  location: class TestClass
//         Assertions.assertEquals(player1, winner, "The winner should be player1 as both players have the same score.");
    }

    @Test
    public void testPlayerMovementBoundaryCases_h169() throws Exception {
        // Create a Map that is 3x3 with no Treasure
        Map map = new Map(3, 3, new Treasure[0]);
        Position startPosition = new Position(1, 1);
        
        // Create a Player in the center of the map
        Player player = new Player(map, startPosition, 5);
        
        // Move the player UP, should be allowed
        player.move(Direction.UP, 1);
        Field positionField = Player.class.getDeclaredField("position");
        positionField.setAccessible(true);
        Position newPosition = (Position) positionField.get(player);
        Assertions.assertEquals(0, newPosition.getRow(), "Player should move up to row 0.");

        // Move the player UP again, should hit the boundary
        player.move(Direction.UP, 1);
        newPosition = (Position) positionField.get(player);
        Assertions.assertEquals(0, newPosition.getRow(), "Player should remain at row 0 after hitting the upper boundary.");

        // Move the player LEFT, should be allowed
        player.move(Direction.LEFT, 1);
        newPosition = (Position) positionField.get(player);
        Assertions.assertEquals(0, newPosition.getCol(), "Player should move left to column 0.");

        // Move the player LEFT again, should hit the boundary
        player.move(Direction.LEFT, 1);
        newPosition = (Position) positionField.get(player);
        Assertions.assertEquals(0, newPosition.getCol(), "Player should remain at column 0 after hitting the left boundary.");
    }





    @Test
    public void testPlayerMovementAndTreasureCollectionWhileOutOfBounds_qrkx() throws Exception {
        // Setup Map with dimensions 3x3 and one Treasure at position (0, 0) with score 10.
        Position treasurePosition = new Position(0, 0);
        Treasure treasure = new Treasure(10, treasurePosition);
        Map map = new Map(3, 3, new Treasure[]{treasure}); // Ensure correct array creation
        Position playerPosition = new Position(1, 1);
        
        // Initialize Player with the Map and Position
        Player player = new Player(map, playerPosition);
        
        // Attempt to move RIGHT out of bounds and collect treasures
        player.move(Direction.RIGHT, 3); // Attempt to move right beyond the map's boundary

        // Assert Player's position is now at (1, 2) due to boundary constraints.
        Field positionField = Player.class.getDeclaredField("position");
        positionField.setAccessible(true);
        Position currentPosition = (Position) positionField.get(player);
        Assertions.assertEquals(1, currentPosition.getRow());
        Assertions.assertEquals(2, currentPosition.getCol());
        
        // Assert that the score remains zero, as we haven't moved to a valid treasure position
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        Assertions.assertEquals(0, scoreField.getInt(player));
    }

    @Test
    public void testPlayerOutsideMapBoundaryTriggersScoreUpdateCorrectly_pek9() throws Exception {
        // Create a Map and a Treasure
        Position treasurePosition = new Position(1, 1);
        Treasure treasure = new Treasure(20, treasurePosition);
        Map map = new Map(2, 2, new Treasure[]{treasure}); // Use the constructor correctly

        // Initialize Player
        Position playerPosition = new Position(0, 0);
        Player player = new Player(map, playerPosition);

        // Now, we'll move the player down and right into the treasure correctly
        player.move(Direction.DOWN, 1); // Move down to (1, 0)
        player.move(Direction.RIGHT, 1); // Move right to (1, 1) where the treasure is

        // Assert score should now be 20 after collecting the treasure
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        Assertions.assertEquals(20, scoreField.getInt(player));

        // Ensure the treasure is updated and cannot be collected again
        Field mapField = Player.class.getDeclaredField("map");
        mapField.setAccessible(true);
        Assertions.assertEquals(0, map.hasTreasure(playerPosition)); // Should return score 0 now
    }

    //@Test
    public void testMapInactiveStateWhenAllTreasuresCollected_b03r() throws Exception {
        // Create a Map with multiple treasures
        Position treasurePosition1 = new Position(1, 1);
        Treasure treasure1 = new Treasure(10, treasurePosition1);
        Position treasurePosition2 = new Position(0, 0);
        Treasure treasure2 = new Treasure(15, treasurePosition2);
        Map map = new Map(2, 2, new Treasure[]{treasure1, treasure2});

        // Initialize a Player
        Position playerPosition = new Position(0, 0);
        Player player = new Player(map, playerPosition);

        // Move player to collect both treasures
        player.move(Direction.RIGHT, 1); // Move to (0,1), collects treasure1
        player.move(Direction.DOWN, 1); // Move to (1,1), collects treasure2

        // Check if the map became inactive
        Field mapField = Player.class.getDeclaredField("map");
        mapField.setAccessible(true);
        Map currentMap = (Map) mapField.get(player);

        // After all treasures are collected, the map should be inactive
        Field isActiveField = Map.class.getDeclaredField("isActive");
        isActiveField.setAccessible(true);
        Assertions.assertFalse(isActiveField.getBoolean(currentMap)); // Map should not be active
    }

    @Test
    public void testPlayerEqualityMethodWithDifferentPlayers_ab3o() throws Exception {
        // Create two Players with different IDs
        Map map = new Map(3, 3, new Treasure[]{new Treasure(10, new Position(0, 0))});
        Player player1 = new Player(map, new Position(2, 2));
        Player player2 = new Player(map, new Position(0, 0));

        // Ensure players are not equal
        Field idField1 = Player.class.getDeclaredField("id");
        idField1.setAccessible(true);
        Assertions.assertNotEquals(idField1.getInt(player1), idField1.getInt(player2));

        // Assert that player equality method returns false
        Assertions.assertFalse(player1.equals(player2));

        // Now make player2 reference player1 and assert equality
        player2 = player1; // Both references are now the same
        Assertions.assertTrue(player1.equals(player2)); // They should be equal
    }





    @Test
    public void testMovePlayerAndUpdateScore_5kej() throws Exception {
        // Create a Map with 5 rows and 5 columns and a Treasure at position (1,1)
// ERROR: incompatible types: Position cannot be converted to int
//         Map map = new Map(5, 5, new Treasure[]{new Treasure(new Position(1, 1), 10)});
        
        // Create a Player starting at position (0, 0) with max steps allowed as 10
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player = new Player(map, new Position(0, 0), 10);
        
        // Move the player DOWN 2 steps
        // Expected new position: (2, 0), score should be 0 as there is no treasure
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.DOWN, 2);
        
        // Move the player RIGHT to position (2, 1) and then DOWN to position (3, 1)
        // Expected new position: (3, 1), score should still be 0
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.RIGHT, 1);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.DOWN, 1);
        
        // Now move the player LEFT to (3, 0) and UP to (2, 0)
        // The player should accumulate score after reaching the treasure at (1, 1)
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.LEFT, 1);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         player.move(Direction.UP, 2);
        
        // Access and assert the player's score
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
// ERROR: cannot find symbol
//  symbol:   variable player
//  location: class TestClass
//         assertEquals(10, scoreField.getInt(player)); // Player should have collected the treasure.
    }

    //@Test
    public void testWinningPlayerFromMultiplePlayers_2z7o() throws Exception {
        // Setup game system and add multiple players
        GameSystem gameSystem = new GameSystem();
// ERROR: incompatible types: Position cannot be converted to int
//         Map map = new Map(5, 5, new Treasure[]{new Treasure(new Position(1, 1), 10)});
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player1 = new Player(map, new Position(0, 0), 10);
// ERROR: cannot find symbol
//  symbol:   variable map
//  location: class TestClass
//         Player player2 = new Player(map, new Position(0, 1), 10);
        
        // Move player1 to collect the treasure
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.DOWN, 2);  // player1 moves to (2, 0)
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.RIGHT, 1); // player1 moves to (2, 1)
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.DOWN, 1);  // player1 moves to (3, 1)
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.LEFT, 1);   // player1 moves to (3, 0)
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         player1.move(Direction.UP, 2);    // player1 moves to (1, 0) and then (0, 0)
        
        // Add players to the game system
// ERROR: cannot find symbol
//  symbol:   variable player1
//  location: class TestClass
//         gameSystem.addPlayer(player1);
// ERROR: cannot find symbol
//  symbol:   variable player2
//  location: class TestClass
//         gameSystem.addPlayer(player2);
        
        // Determine the winner
        Player winner = gameSystem.getWinner();
        
        // Assert that the player1 is the winner by checking the score
        Field winnerScoreField = Player.class.getDeclaredField("score");
        winnerScoreField.setAccessible(true);
        assertEquals(10, winnerScoreField.getInt(winner)); // player1 should be the winner
    }

    @Test
    public void testPlayerMovementLimits_smk3() throws Exception {
        // Prepare a Map with dimensions
        Map map = new Map(5, 5, new Treasure[]{});
        Player player = new Player(map, new Position(0, 0), 3); // Max 3 steps allowed

        // Player moves down to (1, 0)
        player.move(Direction.DOWN, 1);
        
        // Player moves down again to (2, 0)
        player.move(Direction.DOWN, 1);
        
        // Player tries to move down to (3, 0) which is valid
        player.move(Direction.DOWN, 1);
        
        // Now player attempts to move beyond allowed boundaries -- should stop
        boolean result = player.move(Direction.DOWN, 1); // should return false

        // Access and assert the player's position
        Field positionField = Player.class.getDeclaredField("position");
        positionField.setAccessible(true);
        Position position = (Position) positionField.get(player);

        assertEquals(3, position.getRow()); // player should be at row 3
        assertFalse(result); // last move should return false
    }

    @Test
    public void testInvalidMovementBeyondMap_72ht() throws Exception {
        // Create a Map of size 2x2 with no treasure
        Map map = new Map(2, 2, new Treasure[]{});
        
        // Start player at (1, 1) which is the bottom right corner
        Player player = new Player(map, new Position(1, 1), 5); // max steps arbitrary
        
        // Attempt to move DOWN which should exceed limits
        player.move(Direction.DOWN, 1);
        
        // Access and assert position
        Field posField = Player.class.getDeclaredField("position");
        posField.setAccessible(true);
        Position pos = (Position) posField.get(player);
        
        // Assert the player's position is still (1, 1)
        assertEquals(1, pos.getRow());
        assertEquals(1, pos.getCol());
    }


}
