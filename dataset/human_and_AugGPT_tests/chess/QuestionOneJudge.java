import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class QuestionOneJudge {
    @Test
    public void test01_ChessboardPointClass() {
        assertNotNull(LocalJudgeUtils.findChessboardPointClass());
    }

    @Test
    public void test02_ChessboardPointClassFields() {
        assertNotNull(LocalJudgeUtils.findXFieldInChessboardPointClass());
        assertNotNull(LocalJudgeUtils.findYFieldInChessboardPointClass());
    }

    @Test
    public void test03_ChessboardPointClassMethods() {

        assertNotNull(LocalJudgeUtils.findChessboardPointConstructor());
        assertNotNull(LocalJudgeUtils.findGetXMethodInChessboardPointClass());
        assertNotNull(LocalJudgeUtils.findGetYMethodInChessboardPointClass());
        assertNotNull(LocalJudgeUtils.findToStringMethodInChessboardPointClass());
        assertNotNull(LocalJudgeUtils.findOffsetMethodInChessboardPointClass());
    }

    @Test
    public void test04_ChessboardPointClassGetXY() {
        Object chessboardPoint = LocalJudgeUtils.newChessboardPoint(1, 2);
        assertEquals(
                1,
                LocalJudgeUtils.callGetXMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (1,2), getX() should be 1"
        );
        assertEquals(
                2,
                LocalJudgeUtils.callGetYMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (1,2), getY() should be 2"
        );
        chessboardPoint = LocalJudgeUtils.newChessboardPoint(2, 1);
        assertEquals(
                2,
                LocalJudgeUtils.callGetXMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (2,1), getX() should be 2"
        );
        assertEquals(
                1,
                LocalJudgeUtils.callGetYMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (2,1), getY() should be 1"
        );
    }

    @Test
    public void test05_ChessboardPointClassToString() {
        Object chessboardPoint = LocalJudgeUtils.newChessboardPoint(6, 10);
        assertEquals(
                "(6,10)",
                LocalJudgeUtils.callToStringMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (1,2), toString() should be (1,2)"
        );
        chessboardPoint = LocalJudgeUtils.newChessboardPoint(100, 66);
        assertEquals(
                "(100,66)",
                LocalJudgeUtils.callToStringMethodInChessboardPointClass(chessboardPoint),
                "ChessboardPoint (100,66), toString() should be (100,66)"
        );
    }

    @Test
    public void test06_ChessboardPointClassOffset() {
        Object chessboardPoint = LocalJudgeUtils.newChessboardPoint(1, 1);
        Object newChessboardPoint = LocalJudgeUtils.callOffsetMethodInChessboardPointClass(chessboardPoint, 2, 4);
        assertEquals(
                "(3,5)",
                LocalJudgeUtils.callToStringMethodInChessboardPointClass(newChessboardPoint),
                "(1,1) -> offset(2,4) should return (3,5)"
        );
        assertNotSame(
                chessboardPoint,
                newChessboardPoint,
                "offset() method should return a new instance"
        );
        newChessboardPoint = LocalJudgeUtils.callOffsetMethodInChessboardPointClass(chessboardPoint, -2, 2);
        assertNull(
                newChessboardPoint,
                "(1,1) -> offset(-2,2) should return null value"
        );
        newChessboardPoint = LocalJudgeUtils.callOffsetMethodInChessboardPointClass(chessboardPoint, 5, 10);
        assertNull(
                newChessboardPoint,
                "(1,1) -> offset(5,10) should return null value"
        );
    }

}
