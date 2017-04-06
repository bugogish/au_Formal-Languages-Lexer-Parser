package ru.spbau.mit;
/* Программы на языке L записываются символами ASCII. Ограничителями строк являются ASCII-символы
   CR, LF или 2 подряд идущих символа: CR LF. Пробельными символами являются символы-ограничители
   строк и символы пробела (SP), табуляции (HT) и перевода страницы (FF). Пробельные символы не имеют
   значения, для них не должно генерироваться лексем.
   Комментарии только однострочные. Комментарием считается суффикс строки до символа-ограничителя
   строк, начинающийся с "//".
   Формат многострочного комментария (*comment*)
   на (* (* comment *) лексер должен выдавать ошибку, потому что комментарий не закрыт.
   Идентификаторы в языке — произвольная последовательность символов (до первого пробельного симво-
   ла), начинающаяся либо с буквы, либо символа подчеркивания (_), которая не является ключевым словом.
   Ключевые слова языка: if, then, else, while, do, read, write, begin, end
   Литералы языка: числа с плавающей точкой, true, false.
   Операторы языка: +, −, ∗, **, /, %, ==, !=, >, >=, <, <=, &&, ||
   Разделители языка: (, ), ;
*/

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.junit.Test;
import ru.spbau.mit.utils.LexException;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BasicTests {
    private void testLexem(String expectedType, String textToParse) throws IOException {
        textToParse = textToParse.trim();
        LexerRunner runner = new LexerRunner(false);
        List<Token> lexems = runner.getTokensFromInputStream(new StringReader(textToParse));
        Vocabulary vocabulary = runner.getVocabulary();
        Token token = lexems.get(0);

        assertEquals(2, lexems.size());
        assertEquals(expectedType, vocabulary.getSymbolicName(token.getType()));
        assertEquals(textToParse, token.getText());
        assertEquals(0, token.getLine() - 1);
        assertEquals(0, token.getStartIndex());
        assertEquals(textToParse.length() - 1, token.getStopIndex());
    }

    private void testComment(String text) throws IOException {
        testLexem("LINE_COMMENT", text);
    }

    private void testCorrectId(String text) throws IOException {
        testLexem("Id", text);
    }

    private void testKeyword(String name, String type) throws IOException {
        testLexem(type, name);
    }

    private void testNum(String number) throws IOException {
        testLexem("Float", number);
    }

    private void testOperator(String name, String type) throws IOException {
        testLexem(type, name);
    }

    @Test
    public void testComments() throws IOException {
        final String simpleComment = "//cmnt";
        final String fewWords = "//few words comment";
        final String withNewLine1 = "//    hasNewLine\n";
        final String withNewLine2 = "//    hasNewLine\r";
        final String withNewLine3 = "//    hasNewLine\r\n";

        testComment(simpleComment);
        testComment(fewWords);
        testComment(withNewLine1);
        testComment(withNewLine2);
        testComment(withNewLine3);
    }

    @Test
    public void testKeyWords() throws IOException {
        testKeyword("if", "IF");
        testKeyword("else", "ELSE");
        testKeyword("while", "WHILE");
        testKeyword("do", "DO");
        testKeyword("read", "READ");
        testKeyword("write", "WRITE");
        testKeyword("begin", "BEGIN");
        testKeyword("end", "END");
    }

    @Test
    public void testCorrectNumericValues() throws IOException {
        String simpleInteger = "1234";
        String negativeInteger = "-1234";
        String simpleFloat = "1234.1234";
        String floatStartingWithPt = ".1234";
        String negativeFloatStartingWithPt = "-.1234";
        String negativeFloat = "-1234.1234";
        String exponentFloat = "1234.1e+234";
        String exponentFloat1 = "1234.1e-234";
        String exponentFloat2 = "1234.1e0";
        String exponentInteger = "10e-123";
        String exponentInteger1 = "10e123";

        testNum(simpleInteger);
        testNum(negativeInteger);
        testNum(simpleFloat);
        testNum(floatStartingWithPt);
        testNum(negativeFloatStartingWithPt);
        testNum(negativeFloat);
        testNum(exponentFloat);
        testNum(exponentFloat1);
        testNum(exponentFloat2);
        testNum(exponentInteger);
        testNum(exponentInteger1);
    }

    @Test
    public void testBoolean() throws IOException {
        testLexem("Boolean", "true");
        testLexem("Boolean", "false");
        testLexem("Id", "TRUE");
        testLexem("Id", "False");
    }

    @Test
    public void testBracketAndColon() throws IOException {
        testLexem("LPAREN", "(");
        testLexem("RPAREN", ")");
        testLexem("SEMICOLON", ";");
    }

    @Test
    public void testOperators() throws IOException, LexException {
        testOperator(":=", "ASSIGN");
        testOperator("==", "EQ");
        testOperator("+", "ADD");
        testOperator("-", "SUB");
        testOperator("*", "MUL");
        testOperator("**", "POW");
        testOperator("/", "DIV");
        testOperator("%", "MOD");
        testOperator("!=","NEQ");
        testOperator(">", "GT");
        testOperator(">=", "GEQ");
        testOperator("<", "LT");
        testOperator("<=", "LEQ");
        testOperator("&&", "AND");
        testOperator("||", "OR");
    }

    @Test(expected = LexException.class)
    public void neitherAssignNorEQ() throws IOException {
        testLexem(null, "=");
    }

    @Test(expected = LexException.class)
    public void incorrectOperator() throws IOException {
        testLexem(null, "^");
    }

    @Test
    public void testCorrectId() throws IOException, LexException {
        String[] Ids = {"simpleID", "id1234", "_1234 ", "_____", "id_1234",
                "a", "_a", "A", "a_b", "iDeNt", "_i_D_", "__agent007__", "_13", "e2_e4", "reader", "Write"};
        for (String id : Ids) {
            testCorrectId(id);
        }
    }

    @Test
    public void testNumIsNotID() throws IOException, LexException {
        String id = "1";
        StringReader reader = new StringReader(id);
        LexerRunner runner = new LexerRunner(false);
        List<Token> lexems = runner.getTokensFromInputStream(reader);
        Vocabulary vocabulary = runner.getVocabulary();
        Token token = lexems.get(0);
        assertFalse(vocabulary.getSymbolicName(token.getType()).equals("Id"));
    }

    @Test(expected = LexException.class)
    public void testWrongId() throws IOException, LexException {
        String id = "!myVar!";
        LexerRunner runner = new LexerRunner(false);
        runner.getTokensFromInputStream(new StringReader(id));
    }


    @Test
    public void testWhitespaces() throws IOException, LexException {
        StringReader reader = new StringReader("        ");
        LexerRunner runner = new LexerRunner(false);
        List<Token> lexems = runner.getTokensFromInputStream(reader);
        assertEquals(1, lexems.size());

        reader = new StringReader("        \n");
        runner = new LexerRunner(false);
        lexems = runner.getTokensFromInputStream(reader);
        assertEquals(1, lexems.size());

        reader = new StringReader("        \n\r \t \f");
        runner = new LexerRunner(false);
        lexems = runner.getTokensFromInputStream(reader);
        assertEquals(1, lexems.size());
    }

    @Test
    public void testMultiLineComments() throws IOException {
        testLexem("COMMENT", "(*This is\n a\n multiline comment*)");
        testLexem("COMMENT", "(*This is \r\n another \r multiline \n comment*)");
    }

    @Test
    public void testCorrectNestedComments() throws IOException {
        testLexem("COMMENT", "(*This is (*a basic nested *) comment*)");
        testLexem("COMMENT", "(* a*b (* (A*B) (* third *) a*b *)  A*B *)"); //can use MUL and Brackets inside the comment
        testLexem("COMMENT", "(* ((( (* INSIDE *) ))))))) *)");
        testLexem("COMMENT", "(* (* *) *)");
        testLexem("COMMENT", "(* (* \n multiline nestes *)  \r *)");
    }

    //    на (* (* comment *) лексер должен выдавать ошибку, потому что комментарий не закрыт.
    @Test(expected = LexException.class)
    public void testIncorrectlyClosedNestedComment() throws IOException {
        testLexem(null, "(*This is (*not correctly closed nested *) comment");
    }

    @Test(expected = LexException.class)
    public void testIncorrectNestedComment() throws IOException {
        testLexem(null, "(* (* comment *)");
    }
    @Test
    public void starEndingComment() throws IOException {
        testLexem("COMMENT", "(* ** **)");
    }
}
