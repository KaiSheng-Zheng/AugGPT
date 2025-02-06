import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class QuestionTwoJudge {
    @Test
    public void test01_ChessComponentClass() {
        assertNotNull(LocalJudgeUtils.findChessComponentClass());
    }

    @Test
    public void test02_ChessComponentClassFields() {
        assertNotNull(LocalJudgeUtils.findSourceInChessComponentClass());
        assertNotNull(LocalJudgeUtils.findChessColorFieldInChessComponentClass());
        assertNotNull(LocalJudgeUtils.findNameFieldInChessComponentClass());
    }

    @Test
    public void test03_ChessComponentClassMethods() {
        assertNotNull(LocalJudgeUtils.findChessComponentConstructor());
        assertNotNull(LocalJudgeUtils.findCanMoveToMethodInChessComponentClass());
        assertNotNull(LocalJudgeUtils.findToStringMethodInChessComponentClass());
    }

}
