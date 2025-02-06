
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureHuntTest {
    @Test
    public void test1() throws NoSuchFieldException, NoSuchMethodException {
        assertConstructorModifier(Position.class, "public", int.class, int.class);
        assertConstructorModifier(Treasure.class, "public", int.class, Position.class);
        assertConstructorModifier(Map.class, "public", int.class, int.class, Treasure[].class);
        assertConstructorModifier(Player.class, "public", Map.class, Position.class);
        assertConstructorModifier(Player.class, "public", Map.class, Position.class, int.class);

        assertFieldModifier(Position.class, "row", "private");
        assertFieldModifier(Position.class, "col", "private");
        assertMethodModifier(Position.class, "equals", "public", Object.class);

        assertFieldModifier(Treasure.class, "score", "private");
        assertFieldModifier(Treasure.class, "position", "private");

        assertFieldModifier(Map.class, "rows", "private");
        assertFieldModifier(Map.class, "columns", "private");
        assertFieldModifier(Map.class, "isActive", "private");
        assertFieldModifier(Map.class, "treasures", "private");

        assertMethodModifier(Map.class, "hasTreasure", "public", Position.class);
        assertMethodModifier(Map.class, "update", "public", Position.class);

        assertFieldModifier(Player.class, "id", "private");
        assertFieldModifier(Player.class, "score", "private");
        assertFieldModifier(Player.class, "steps", "private");
        assertFieldModifier(Player.class, "position", "private");
        assertFieldModifier(Player.class, "map", "private");

        assertMethodModifier(Player.class, "move", "public", Direction.class, int.class);
        assertMethodModifier(Player.class, "equals", "public", Object.class);

        assertMethodModifier(GameSystem.class, "addPlayer", "public", Player.class);
        assertMethodModifier(GameSystem.class, "newGame", "public", int.class, int.class, Treasure[].class);
        assertMethodModifier(GameSystem.class, "getWinner", "public");

        assertTrue(Direction.class.isEnum());
    }


    //1
    @Test
    public void test2() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        Position pos3 = new Position(3, 4);
        assertEquals(true, pos1.equals(pos2));
        assertEquals(true,pos1.equals(pos1));
        assertEquals(false, pos1.equals(pos3));
    }
    //2
    @Test
    public void test3() {
        Map map = new Map(4, 4, new Treasure[]{
                new Treasure(10, new Position(0, 1)),
                new Treasure(5, new Position(2, 2)),
                new Treasure(15, new Position(1, 3))
        });
        assertEquals(10, map.hasTreasure(new Position(0, 1)));
        assertEquals(5, map.hasTreasure(new Position(2, 2)));
        assertEquals(15, map.hasTreasure(new Position(1, 3)));
        assertEquals(0, map.hasTreasure(new Position(1, 1)));
        assertEquals(0, map.hasTreasure(new Position(3, 3)));
    }
    //3
    @Test
    public void test4() {
        Map map = new Map(4, 4, new Treasure[]{
                new Treasure(9, new Position(2, 3)),
                new Treasure(4, new Position(3, 0)),
                new Treasure(10, new Position(1, 2))
        });
        Player player31 = new Player(map, new Position(3,3));
        Player player32 = new Player(map, new Position(1,0), 7);
        Player player33 = new Player(map, new Position(2,1));
        Player player34 = new Player(map, new Position(0,0),5);
        assertEquals(true,areAllDifferent(player31.getId(),player32.getId(),player33.getId(),player34.getId()));
        assertEquals(true,player31.getId()!=player32.getId());
        assertEquals(false,player31.equals(player32));
        assertEquals(false,player34.equals(player33));
        assertEquals(false,player33.equals(player34));
        assertEquals(false,player33.equals(player31));

    }
    public static boolean areAllDifferent(int a, int b, int c, int d) {
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        return set.size() == 4;
    }
    //4
    @Test
    public void test5() {
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(2, new Position(7,2));
        treasures[1] = new Treasure(7, new Position(0,0));
        treasures[2] = new Treasure(9, new Position(5,1));
        treasures[3] = new Treasure(256, new Position(4,4));
        GameSystem game = new GameSystem();
        Map map = game.newGame(8,5, treasures);
        Player player41 = new Player(map, new Position(5,3));
        Player player42 = new Player(map, new Position(0,1), 11);
        Player player43 = new Player(map, new Position(2,4));
        Player player44 = new Player(map, new Position(0,1),2);
        game.addPlayer(player41);
        game.addPlayer(player42);
        game.addPlayer(player43);
        game.addPlayer(player44);

    }
    //5
    @Test
    public void test6() {
        Treasure[] treasures = new Treasure[]{
                new Treasure(2, new Position(6, 5)),
                new Treasure(9, new Position(1, 3)),
                new Treasure(740, new Position(3, 1))
        };
        Map map = new Map(8, 6, treasures);
        Player player1 = new Player(map,new Position(4,5),5);
        Player player2 = new Player(map,new Position(1,4));
        Player player3 = new Player(map,new Position(5,2));
        assertEquals(true,map.isActive());
        assertEquals(2,map.hasTreasure(new Position(6, 5)));
        player1.move(Direction.DOWN,2);
        assertEquals(0,map.hasTreasure(new Position(6, 5)));
        assertEquals(9,map.hasTreasure(new Position(1, 3)));
        assertEquals(true,map.isActive());
        player2.move(Direction.LEFT,1);
        assertEquals(0,map.hasTreasure(new Position(1, 3)));
        assertEquals(740,map.hasTreasure(new Position(3, 1)));
        player3.move(Direction.LEFT,1);
        assertEquals(true,map.isActive());
        player3.move(Direction.UP,2);
        assertEquals(0,map.hasTreasure(new Position(3, 1)));
        assertEquals(false,map.isActive());
    }
    //6
    @Test
    public void test7() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(3, new Position(0,0));
        treasures[1] = new Treasure(7, new Position(4,2));
        treasures[2] = new Treasure(9, new Position(1,3));
        treasures[3] = new Treasure(2, new Position(3,3));
        Map map = game.newGame(5,4, treasures);
        Position pos1 = new Position(3, 3);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(1, 3);
        Player player1 = new Player(map, new Position(4,3));
        Player player2 = new Player(map, new Position(1,0));
        Player player3 = new Player(map, new Position(1,2));
        Player player4 = new Player(map, new Position(3,2),0);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        assertEquals(false,player4.move(Direction.UP, 1));
        assertEquals(true,player1.move(Direction.UP,1));
        assertEquals(true,pos1.equals(player1.getPosition()));
        assertEquals(false,player2.move(Direction.LEFT,1));
        assertEquals(true,pos2.equals(player2.getPosition()));
        assertEquals(false,player3.move(Direction.RIGHT,999));
        assertEquals(true,pos3.equals(player3.getPosition()));
    }

    //7
    @Test
    public void test8() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(12, new Position(5,6));
        treasures[1] = new Treasure(666, new Position(2,2));
        treasures[2] = new Treasure(3, new Position(1,5));
        treasures[3] = new Treasure(4, new Position(4,6));
        Map map = game.newGame(6,8, treasures);
        Player player1 = new Player(map, new Position(3,5),3);
        Player player2 = new Player(map, new Position(5,7));
        Player player3 = new Player(map, new Position(1,2));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        Position pos1 = new Position(1, 5);
        Position pos2 = new Position(1,6);
        Position pos3 = new Position(2, 2);
        assertEquals(true,player1.move(Direction.UP,2));
        assertEquals(true,pos1.equals(player1.getPosition()));
        assertEquals(false,player1.move(Direction.RIGHT,2));
        assertEquals(true,pos2.equals(player1.getPosition()));
        assertEquals(true,player2.move(Direction.LEFT,1));
        assertEquals(true,player2.move(Direction.UP,1));
        assertEquals(false,player3.move(Direction.DOWN,9999));
        assertEquals(true,pos3.equals(player3.getPosition()));
        assertEquals(false,map.isActive());
        assertEquals(false,player2.move(Direction.LEFT,1));
        assertEquals(false,player3.move(Direction.RIGHT,1));
        assertEquals(false,player3.move(Direction.UP,1));
        assertEquals(false,player2.move(Direction.DOWN,1));
    }
    //8
    @Test
    public void test9() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[5];
        treasures[0] = new Treasure(0, new Position(9,7));
        treasures[1] = new Treasure(23, new Position(1,3));
        treasures[2] = new Treasure(111, new Position(0,0));
        treasures[3] = new Treasure(9, new Position(6,12));
        treasures[4] = new Treasure(3, new Position(6,7));
        Map map = game.newGame(11,13, treasures);
        Player player1 = new Player(map, new Position(6,5),20);
        Player player2 = new Player(map, new Position(3,7));
        Player player3 = new Player(map, new Position(2,6));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        assertEquals(0,player1.getScore());
        player1.move(Direction.RIGHT,7);
        assertEquals(12,player1.getScore());
        player2.move(Direction.DOWN,6);
        assertEquals(0,player2.getScore());
        player3.move(Direction.UP,1);
        assertEquals(0,player3.getScore());
        player3.move(Direction.LEFT,3);
        assertEquals(23,player3.getScore());
    }
    //9
    @Test
    public void test10() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[3];
        treasures[0] = new Treasure(2, new Position(0,0));
        treasures[1] = new Treasure(999, new Position(2,4));
        treasures[2] = new Treasure(7, new Position(1,1));
        Map map = game.newGame(3,5, treasures);
        Player player1 = new Player(map, new Position(0,1),7);
        Player player2 = new Player(map, new Position(2,0));
        Player player3 = new Player(map, new Position(1,0));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        Position pos1 = new Position(0,0);
        Position pos2 = new Position(2,4);
        Position pos3 = new Position(1,1);
        player1.move(Direction.LEFT,1);
        player2.move(Direction.RIGHT,4);
        player3.move(Direction.RIGHT,1);
        assertEquals(player2,game.getWinner());
        assertEquals(pos1,player1.getPosition());
        assertEquals(pos2,player2.getPosition());
        assertEquals(pos3,player3.getPosition());
        assertEquals(2,player1.getScore());
        assertEquals(999,player2.getScore());
        assertEquals(7,player3.getScore());
        assertEquals(1,player1.getSteps());
        assertEquals(4,player2.getSteps());
        assertEquals(1,player3.getSteps());
    }
    //10
    @Test
    public void test11() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[7];
        treasures[0] = new Treasure(66, new Position(7,0));
        treasures[1] = new Treasure(17, new Position(3,4));
        treasures[2] = new Treasure(93, new Position(5,5));
        treasures[3] = new Treasure(10, new Position(0,1));
        treasures[4] = new Treasure(40, new Position(4,6));
        treasures[5] = new Treasure(3, new Position(1,7));
        treasures[6] = new Treasure(21, new Position(3,3));
        Map map = game.newGame(8,8, treasures);
        Player player1 = new Player(map, new Position(0,0),6);
        Player player2 = new Player(map, new Position(2,3),30);
        Player player3 = new Player(map, new Position(7,4));
        Player player4 = new Player(map, new Position(7,5));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        Position pos1 = new Position(3,3);
        Position pos2 = new Position(0,1);
        Position pos3 = new Position(4,7);
        Position pos4 = new Position(0,5);
        player4.move(Direction.UP,999);
        player4.move(Direction.DOWN,999);
        player4.move(Direction.UP,999);
        player4.move(Direction.DOWN,999);
        player4.move(Direction.UP,999);
        player4.move(Direction.DOWN,999);
        player4.move(Direction.UP,999);
        player4.move(Direction.DOWN,999);
        player4.move(Direction.UP,999);
        player3.move(Direction.UP,2);
        player3.move(Direction.RIGHT,3);
        player3.move(Direction.UP,999);
        player3.move(Direction.LEFT,1);
        player3.move(Direction.DOWN,4);
        player3.move(Direction.LEFT,999);
        player3.move(Direction.RIGHT,300);
        player1.move(Direction.DOWN,3);
        player1.move(Direction.RIGHT,10);
        player3.move(Direction.RIGHT,3);
        player2.move(Direction.RIGHT,1);
        player2.move(Direction.DOWN,5);
        player2.move(Direction.LEFT,20);
        player2.move(Direction.UP,999);
        player2.move(Direction.RIGHT,1);
        assertEquals(pos1,player1.getPosition());
        assertEquals(pos2,player2.getPosition());
        assertEquals(pos3,player3.getPosition());
        assertEquals(pos4,player4.getPosition());
        assertEquals(21,player1.getScore());
        assertEquals(93,player2.getScore());
        assertEquals(43,player3.getScore());
        assertEquals(93,player4.getScore());
        assertEquals(6,player1.getSteps());
        assertEquals(18,player2.getSteps());
        assertEquals(28,player3.getSteps());
        assertEquals(63,player4.getSteps());
        assertEquals(player2,game.getWinner());
    }
    //11
    @Test
    public void test12() {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[5];
        treasures[0] = new Treasure(70, new Position(1,0));
        treasures[1] = new Treasure(60, new Position(0,2));
        treasures[2] = new Treasure(130, new Position(5,6));
        treasures[3] = new Treasure(1, new Position(4,4));
        treasures[4] = new Treasure(9, new Position(4,2));
        Map map = game.newGame(6,7, treasures);
        Player player1 = new Player(map, new Position(0,0),10);
        Player player2 = new Player(map, new Position(3,6),20);
        Player player3 = new Player(map, new Position(4,1));
        Player player4 = new Player(map, new Position(5,2),4);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        Position pos = new Position(0,3);
        assertEquals(false,player1.move(Direction.LEFT,5));
        assertEquals(0,player1.getSteps());
        assertEquals(false,player2.move(Direction.UP,5));
        assertEquals(3,player2.getSteps());
        assertEquals(false,player4.move(Direction.UP,10));
        assertEquals(4,player4.getSteps());
        player3.move(Direction.RIGHT,9999);
        player3.move(Direction.UP,20);
        player3.move(Direction.LEFT,9);
        player3.move(Direction.RIGHT,3);
        assertEquals(18,player3.getSteps());
        assertEquals(true,pos.equals(player3.getPosition()));
    }
    //12
    @Test
    public void test13(){
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(5, new Position(0,1));
        treasures[1] = new Treasure(10, new Position(0,2));
        treasures[2] = new Treasure(2, new Position(0,4));
        treasures[3] = new Treasure(15, new Position(1,3));
        Map map = game.newGame(3,5, treasures);
        Player player1 = new Player(map, new Position(0,0));
        Player player2 = new Player(map, new Position(1,4), 4);
        Player player3 = new Player(map, new Position(0,3));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        player1.move(Direction.DOWN, 2);
        player1.move(Direction.RIGHT, 2);
        player1.move(Direction.UP, 4);
        player2.move(Direction.LEFT, 2);
        player2.move(Direction.UP,1);
        player1.move(Direction.LEFT, 3);
        player2.move(Direction.RIGHT, 2);
        player3.move(Direction.RIGHT,1);
        player3.move(Direction.DOWN, 2);
        assertEquals(8, player1.getSteps());
        assertEquals(new Position(0, 0), player1.getPosition());
        assertEquals(15, player1.getScore());
        assertEquals(4, player2.getSteps());
        assertEquals(new Position(0, 3), player2.getPosition());
        assertEquals(15, player2.getScore());
        assertEquals(1, player3.getSteps());
        assertEquals(new Position(0, 4), player3.getPosition());
        assertEquals(2, player3.getScore());
        Player winner = game.getWinner();
        assertEquals(player2, winner);
    }
    // Helper method to assert the modifier of a field
    private void assertFieldModifier(Class<?> clazz, String fieldName, String expectedModifier) throws NoSuchFieldException {
        Field field = clazz.getDeclaredField(fieldName);
        String actualModifier = getModifier(field.getModifiers());
        assertEquals(expectedModifier, actualModifier);
    }

    // Helper method to assert the modifier of a method
    private void assertMethodModifier(Class<?> clazz, String methodName, String expectedModifier, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        String actualModifier = getModifier(method.getModifiers());
        assertEquals(expectedModifier, actualModifier);
    }
    private void assertConstructorModifier(Class<?> clazz, String expectedModifier, Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor constructor = clazz.getConstructor(parameterTypes);
        String actualModifier = getModifier(constructor.getModifiers());
        assertEquals(expectedModifier, actualModifier);
    }
    // Helper method to get the modifier as a string
    private String getModifier(int modifiers) {
        if (java.lang.reflect.Modifier.isPublic(modifiers)) {
            return "public";
        } else if (java.lang.reflect.Modifier.isPrivate(modifiers)) {
            return "private";
        } else {
            return "other";
        }
    }
}
