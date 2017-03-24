import org.junit.Test;
import ru.spbau.mit.Lexems.*;
import ru.spbau.mit.Utils.LexException;
import ru.spbau.mit.Utils.Lexer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.spbau.mit.Lexems.LexemType.*;

public class AdvancedTests {
    @Test
    public void testComplexInput() throws IOException, LexException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input").getFile());

        Lexem[] correctLexems = new Lexem[]{
                new KeyWord(KW_Read, 0, 0, 3),
                new Identifier(0, 5, 5, "x"),
                new Colon(0, 6, 6),
                new KeyWord(KW_If, 0, 8, 9),
                new Identifier(0, 11, 11, "y"),
                new Operator(Plus, 0, 13, 13),
                new NumericValue(0, 15, 15, 1),
                new Operator(Eq, 0, 17, 18),
                new Identifier(0, 20, 20, "x"),
                new KeyWord(KW_Then, 0, 22, 25),
                new KeyWord(KW_Write, 0, 27, 31),
                new Identifier(0, 33, 33, "y"),
                new KeyWord(KW_Else, 0, 35, 38),
                new KeyWord(KW_Write, 0, 40, 44),
                new Identifier(0, 46, 46, "x"),
                new Comment(0, 48,56, "comment")
        };

        ArrayList<Lexem> lexems = Lexer.run(new FileReader(file));
        assertEquals(correctLexems.length, lexems.size());
        for (int i = 0; i < correctLexems.length; i++) {
            Lexem currentLex = lexems.get(i);
            assertTrue(currentLex.getClass().isInstance(correctLexems[i]));

            assertEquals(correctLexems[i].getStart(), currentLex.getStart());
            assertEquals(correctLexems[i].getFinish(), currentLex.getFinish());
            assertEquals(correctLexems[i].getLine(), currentLex.getLine());
            assertEquals(correctLexems[i], currentLex);
        }
    }
}
