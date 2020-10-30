import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AcmTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CsesIntroductoryChessboardAndQueensTest extends AcmTest {

    private CsesIntroductoryChessboardAndQueens instance;

    @BeforeEach
    public void before() {
        instance = new CsesIntroductoryChessboardAndQueens();
    }

    @Override
    public void processInput() throws Exception {
        instance.solve();
    }

    @Test
    public void sample() throws Exception {
        compare("........\n" +
                "........\n" +
                "..*.....\n" +
                "........\n" +
                "........\n" +
                ".....**.\n" +
                "...*....\n" +
                "........", "65");
    }

    @Test
    public void allEmpty() throws Exception {
        compare("........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........", "92");
    }

    @Test
    public void checkQueenCode() {
        final int[] queens = {1, 3, 7, 4, 3, 1, 0, 7};
        assertArrayEquals(queens, instance.extractQueens(instance.codeQueens(queens)));
    }

    @Test
    public void checkCantPlaceQueenOnLine() {
        final int[] previousQueens = {0};
        assertFalse(instance.canPutQueen(1, 0, previousQueens));
    }

    @Test
    public void checkCantPlaceQueenOnMainDiagonal() {
        final int[] previousQueens = {0};
        assertFalse(instance.canPutQueen(1, 1, previousQueens));
    }

    @Test
    public void checkCantPlaceQueenOnSecondaryDiagonal() {
        final int[] previousQueens = {5};
        assertFalse(instance.canPutQueen(1, 4, previousQueens));
    }

    @Test
    public void checkCanPlaceQueen() {
        final int[] previousQueens = {0};
        assertTrue(instance.canPutQueen(1, 2, previousQueens));
    }


}