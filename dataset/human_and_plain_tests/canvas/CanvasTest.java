import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class CanvasTest {
    private static String gridString(char[][] grids) {
        StringBuilder sb = new StringBuilder();
        for (char[] line : grids) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Test
    void test1() {
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        assertTrue(canvas.addShape(6, 4, '1', 5));
        assertFalse(canvas.addShape(5, 3, '0', 3));
        assertTrue(canvas.addShape(2, 3, '2', 2, 3, 3));
        assertFalse(canvas.addShape(19, 17, '0', 6, 4, 3));
        assertFalse(canvas.addShape(2, 2, '0', 19, 19, 3));
        assertTrue(canvas.addShape(1, 1, '3', 3, 2, 1));
        assertFalse(canvas.addShape(18, 19, '0', 8));
        assertFalse(canvas.addShape(19, 18, '0', 3, 1, 3));
        assertFalse(canvas.addShape(17, 19, '0', 2));
    }
    @Test
    void test2() {
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(10, 10);
        assertTrue(canvas.addShape(3, 2, '1', 2));
        assertFalse(canvas.addShape(5, 5, '2', 2, 4, 2));
        assertTrue(canvas.addShape(7, 7, '3', 2, 3, 2));
        assertFalse(canvas.addShape(7, 7, '4', 2, 3, 2));
        assertFalse(canvas.addShape(7, 9, '0', 2));
        assertEquals(2, canvas.getShapeCount());
    }
    @Test
    void test3() {
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(15, 20);
        assertTrue(canvas.addShape(3, 4, '1', 2));
        assertFalse(canvas.addShape(4, 5, '2', 13, 4, 1));
        assertTrue(canvas.addShape(12, 15, '3', 1, 2, 2));
        assertTrue(canvas.addShape(11, 18, '0', 2, 1, 3));
        assertFalse(canvas.addShape(0, 15, '4', 12, 1, 2));
        assertEquals("                    \n" + "                    \n" + "                    \n" + "    1111            \n" + "    1111            \n" + "    1111            \n" + "    1111            \n" + "                    \n" + "                    \n" + "                    \n" + "                    \n" + "                  00\n" + "               3    \n" + "               3    \n" + "                    \n", gridString(canvas.getCanvas()));
    }
    @Test
    void test4() {
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        assertTrue(canvas.addShape(0, 0, '1', 3));
        assertFalse(canvas.addShape(3, 3, '0', 1));
        assertTrue(canvas.addShape(6, 0, '2', 4, 6, 1));
        assertTrue(canvas.addShape(14, 12, '3', 4, 6, 2));
        assertFalse(canvas.addShape(0, 0, '0', 4, 3, 1));
        assertFalse(canvas.addShape(6, 6, '4', 7, 12, 3));
        assertTrue(canvas.addShape(3, 3, '0', 7, 12, 3));
        assertEquals(4, canvas.getShapeCount());
        assertEquals("" + "111111              \n" + "111111              \n" + "111111              \n" + "111111   0          \n" + "111111  00          \n" + "111111  00          \n" + "2      000          \n" + "22     000          \n" + "22    0000          \n" + "222  00000          \n" + "2222 00000          \n" + "2222000000          \n" + "    000000          \n" + "   0000000          \n" + "   0000000  3333    \n" + "            3333    \n" + "             333    \n" + "              33    \n" + "              33    \n" + "               3    \n", gridString(canvas.getCanvas()));
    }
    @Test
    void test5() {
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        assertTrue(canvas.addShape(6, 6, '4', 7, 12, 3));
        assertTrue(canvas.addShape(0, 0, '0', 4, 3, 1));
        assertTrue(canvas.addShape(3, 3, '0', 1));
        assertFalse(canvas.addShape(14, 12, '3', 4, 6, 2));
        assertFalse(canvas.addShape(3, 3, '0', 7, 12, 3));
        assertTrue(canvas.addShape(6, 0, '2', 4, 6, 1));
        assertFalse(canvas.addShape(0, 0, '1', 3));
        assertEquals(4, canvas.getShapeCount());
        assertEquals("" + "00                  \n" + "000                 \n" + "0000                \n" + "   00               \n" + "   00               \n" + "                    \n" + "2           4       \n" + "22         44       \n" + "22         44       \n" + "222       444       \n" + "2222      444       \n" + "2222     4444       \n" + "        44444       \n" + "        44444       \n" + "       444444       \n" + "       444444       \n" + "      4444444       \n" + "      4444444       \n" + "                    \n" + "                    \n", gridString(canvas.getCanvas()));
        assertEquals("[Circle: (3,3) area=4 pattern=0, RightTriangle: (0,0) area=9 pattern=0, RightTriangle: (6,0) area=16 pattern=2, RightTriangle: (6,6) area=51 pattern=4]", canvas.getShapesByArea().toString());
        assertEquals("[RightTriangle: (0,0) area=9 pattern=0, Circle: (3,3) area=4 pattern=0, RightTriangle: (6,0) area=16 pattern=2, RightTriangle: (6,6) area=51 pattern=4]", canvas.getShapesByLocation().toString());
    }

    @Test
    void test6() {
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(16, 12);
        assertFalse(canvas.addShape(6, 6, '5', 19, 20, 3));
        assertTrue(canvas.addShape(0, 0, '1', 6));
        assertTrue(canvas.addShape(2, 11, '2', 5, 4, 0));
        assertFalse(canvas.addShape(16, 12, '3', 8, 7, 1));
        assertTrue(canvas.addShape(6, 3, '4', 9, 9, 3));
    }
    @Test
    void test7() {
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(12, 16);
        assertTrue(canvas.addShape(11, 8, '1', 1));
        assertFalse(canvas.addShape(12, 8, '7', 9));
        assertFalse(canvas.addShape(11, 16, '2', 1));
        assertFalse(canvas.addShape(15, 19, '3', 4));
        assertTrue(canvas.addShape(4, 9, '5', 3, 5, 1));
        assertTrue(canvas.addShape(4, 9, '6', 3, 5, 0));
        assertFalse(canvas.addShape(0, 18, '4', 12, 12, 2));
        assertEquals(3, canvas.getShapeCount());
    }

    @Test
    void test8() {
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(12, 16);
        assertFalse(canvas.addShape(0, 19, '1', 4));
        assertTrue(canvas.addShape(6, 4, '2', 1));
        assertFalse(canvas.addShape(9, 13, '3', 18));
        assertTrue(canvas.addShape(6, 1, '4', 13, 8, 1));
        assertTrue(canvas.addShape(6, 1, '5', 13, 8, 1));
        assertTrue(canvas.addShape(6, 6, '6', 13, 8, 0));
        assertFalse(canvas.addShape(0, 16, '7', 12, 12, 2));
        assertEquals("" + "                \n" + "                \n" + "                \n" + "                \n" + "                \n" + "                \n" + " 55 226666666666\n" + " 555526666666666\n" + " 555556666666666\n" + " 55555666666666 \n" + " 555556666666   \n" + " 5555566666     \n", gridString(canvas.getCanvas()));
    }
    @Test
    void test9() {
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(20, 20);
        assertFalse(canvas.addShape(19, 20, '9', 15, 15, 3));
        assertTrue(canvas.addShape(2, 5, '1', 1));
        assertFalse(canvas.addShape(12, 17, '2', 19));
        assertFalse(canvas.addShape(20, 19, '3', 4));
        assertTrue(canvas.addShape(2, 18, '4', 12, 12, 2));
        assertTrue(canvas.addShape(6, 1, '7', 13, 8, 1));
        assertTrue(canvas.addShape(6, 1, '5', 13, 8, 1));
        assertTrue(canvas.addShape(6, 6, '6', 13, 8, 0));
        assertTrue(canvas.addShape(6, 6, '8', 3, 5, 0));
        assertTrue(canvas.addShape(6, 6, '0', 5));
        assertEquals(7, canvas.getShapeCount());
        assertEquals("" + "                    \n" + "                    \n" + "     11           44\n" + "     11            4\n" + "                    \n" + "                    \n" + " 55   8800000066666 \n" + " 5555 800000000666  \n" + " 555550000000000    \n" + " 555550000000000    \n" + " 555550000000000    \n" + " 555550000000000    \n" + " 555550000000000    \n" + " 555550000000000    \n" + "       00000000     \n" + "        000000      \n" + "                    \n" + "                    \n" + "                    \n" + "                    \n", gridString(canvas.getCanvas()));

    }
    @Test
    void test10() {
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(20, 20);
        assertTrue(canvas.addShape(6, 1, '7', 13, 8, 1));
        assertTrue(canvas.addShape(6, 6, '8', 3, 5, 0));
        assertFalse(canvas.addShape(19, 20, '9', 15, 15, 3));
        assertTrue(canvas.addShape(2, 18, '4', 12, 12, 2));
        assertTrue(canvas.addShape(2, 5, '1', 1));
        assertFalse(canvas.addShape(12, 17, '2', 19));
        assertFalse(canvas.addShape(20, 19, '3', 4));
        assertTrue(canvas.addShape(6, 6, '0', 5));
        assertTrue(canvas.addShape(6, 6, '6', 13, 8, 0));
        assertTrue(canvas.addShape(6, 1, '5', 13, 8, 1));
        assertEquals(7, canvas.getShapeCount());
        assertEquals("" + "                    \n" + "                    \n" + "     11           44\n" + "     11            4\n" + "                    \n" + "                    \n" + " 55   6666666666666 \n" + " 5555 666666666666  \n" + " 555556666666666    \n" + " 555555566666660    \n" + " 555555555666000    \n" + " 555555555500000    \n" + " 555555555555000    \n" + " 555555555555500    \n" + "       00000000     \n" + "        000000      \n" + "                    \n" + "                    \n" + "                    \n" + "                    \n", gridString(canvas.getCanvas()));
        assertEquals("[Circle: (2,5) area=4 pattern=1, RightTriangle: (6,6) area=11 pattern=8, RightTriangle: (6,1) area=62 pattern=5, RightTriangle: (6,6) area=62 pattern=6, RightTriangle: (6,1) area=62 pattern=7, RightTriangle: (2,18) area=78 pattern=4, Circle: (6,6) area=88 pattern=0]", canvas.getShapesByArea().toString());
        assertEquals("[Circle: (2,5) area=4 pattern=1, RightTriangle: (2,18) area=78 pattern=4, RightTriangle: (6,1) area=62 pattern=5, RightTriangle: (6,1) area=62 pattern=7, Circle: (6,6) area=88 pattern=0, RightTriangle: (6,6) area=62 pattern=6, RightTriangle: (6,6) area=11 pattern=8]", canvas.getShapesByLocation().toString());
    }
}
