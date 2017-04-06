package ru.spbau.mit;

import org.antlr.v4.runtime.*;
import org.junit.Test;
import ru.spbau.mit.utils.ErrorListener;
import ru.spbau.mit.utils.LLanguageLexer;
import ru.spbau.mit.utils.LLanguageLexer;
import ru.spbau.mit.utils.LexException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdvancedTests {
    private void testLexem(String expectedType, String textToParse, Token token, Vocabulary vocabulary, int line, int start, int finish) throws IOException {
        assertEquals(expectedType, vocabulary.getSymbolicName(token.getType()));
        assertEquals(textToParse, token.getText());
        assertEquals(line, token.getLine() - 1);
        assertEquals(start, token.getStartIndex());
        assertEquals(finish, token.getStopIndex());
    }

    @Test
    public void testFileInput() throws IOException, LexException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input").getFile());
        Lexer lexer = new LLanguageLexer(new ANTLRFileStream(file.getAbsolutePath()));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());
        Vocabulary vocabulary = lexer.getVocabulary();

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> toks = tokens.getTokens();
        assertEquals(18, toks.size());

        testLexem("READ", "read", toks.get(0), vocabulary, 0, 0, 3);
        testLexem("Id", "x", toks.get(1), vocabulary, 0, 5, 5);
        testLexem("SEMICOLON", ";", toks.get(2), vocabulary, 0, 6, 6);
        testLexem("IF", "if", toks.get(3), vocabulary, 0, 8, 9);
        testLexem("Id", "y", toks.get(4), vocabulary, 0, 11, 11);
        testLexem("ADD", "+", toks.get(5), vocabulary, 0, 13, 13);
        testLexem("Float", "1", toks.get(6), vocabulary, 0, 15, 15);
        testLexem("EQ", "==", toks.get(7), vocabulary,  0, 17, 18);
        testLexem("Id", "x", toks.get(8), vocabulary, 0, 20, 20);
        testLexem("THEN", "then", toks.get(9), vocabulary, 0, 22, 25);
        testLexem("WRITE", "write", toks.get(10), vocabulary, 0, 27, 31);
        testLexem("Id", "y", toks.get(11), vocabulary, 0, 33, 33);
        testLexem("ELSE", "else", toks.get(12), vocabulary, 0, 35, 38);
        testLexem("WRITE", "write", toks.get(13), vocabulary,  0, 40, 44);
        testLexem("Id", "x", toks.get(14), vocabulary, 0, 46, 46);
        testLexem("LINE_COMMENT", "//comment", toks.get(15), vocabulary, 0, 48,56);
        testLexem("COMMENT", "(* ** **)", toks.get(16), vocabulary, 1, 58, 66);
    }
}
