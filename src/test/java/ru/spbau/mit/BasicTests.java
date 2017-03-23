/* Программы на языке L записываются символами ASCII. Ограничителями строк являются ASCII-символы
   CR, LF или 2 подряд идущих символа: CR LF. Пробельными символами являются символы-ограничители
   строк и символы пробела (SP), табуляции (HT) и перевода страницы (FF). Пробельные символы не имеют
   значения, для них не должно генерироваться лексем.
   Комментарии только однострочные. Комментарием считается суффикс строки до символа-ограничителя
   строк, начинающийся с "//".
   Идентификаторы в языке — произвольная последовательность символов (до первого пробельного симво-
   ла), начинающаяся либо с буквы, либо символа подчеркивания (_), которая не является ключевым словом.
   Ключевые слова языка: if, then, else, while, do, read, write, begin, end
   Литералы языка: числа с плавающей точкой, true, false.
   Операторы языка: +, −, ∗, /, %, ==, !=, >, >=, <, <=, &&, ||
   Разделители языка: (, ), ;
*/

package ru.spbau.mit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ru.spbau.mit.Lexems.*;
import ru.spbau.mit.Utils.Lexer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class BasicTests {
    private void testComment(String text) throws IOException {
        String[] tokens = text.split("\\r\\n|\\r|\\n");
        text = tokens[0];
        StringReader reader = new StringReader(text);
        ArrayList<Lexem> lexems = Lexer.run(reader);

        assertEquals(1, lexems.size());
        Comment lex = (Comment) lexems.get(0);
        assertEquals(text.substring(2), lex.getValue());
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(text.length() - 1, lex.getFinish());
    }

    private void testCorrectIdentifier(String text) throws IOException {
        String[] tokens = text.split("\\s+");
        text = tokens[0];
        StringReader reader = new StringReader(text);
        ArrayList<Lexem> lexems = Lexer.run(reader);

        assertEquals(1, lexems.size());
        Identifier lex = (Identifier) lexems.get(0);
        assertEquals(new Identifier(-1, -1, -1, text), lex);
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(text.length() - 1, lex.getFinish());
        assertEquals("Ident(" + text + ", 0, 0, " + (text.length() - 1) + ")", lex.toString());
    }

    private void testKeyword(String name, LexemType type) throws IOException{
        StringReader reader = new StringReader(name);
        ArrayList<Lexem> lexems = Lexer.run(reader);
        Lexem lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(new KeyWord(type, -1, -1, -1), lex);
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(name.length() - 1, lex.getFinish());
        assertEquals(type.name() + "(0, 0, " + (name.length() - 1) + ")", lex.toString());
    }

    private void testNum(String number) throws IOException {
        StringReader reader = new StringReader(number);
        ArrayList<Lexem> lexems = Lexer.run(reader);
        NumericValue lex = (NumericValue) lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(new NumericValue(-1,  -1, -1, new Double(number)), lex);
        assertEquals(number.length() - 1, lex.getFinish());
        assertEquals("Num(" + new Double(number) + ", 0, 0, " + (number.length() - 1) + ")", lex.toString());
    }

    private void testOperator(String name, LexemType type) throws IOException {
        StringReader reader = new StringReader(name);
        ArrayList<Lexem> lexems = Lexer.run(reader);
        Lexem lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(new Operator(type, -1, -1, -1), lex);
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(name.length() - 1, lex.getFinish());
        assertEquals("Op(" + type.name() + ", 0, 0, " + (name.length() - 1) + ")", lex.toString());
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
        testKeyword("if", LexemType.KW_If);
        testKeyword("else", LexemType.KW_Else);
        testKeyword("while", LexemType.KW_While);
        testKeyword("do", LexemType.KW_Do);
        testKeyword("read", LexemType.KW_Read);
        testKeyword("write", LexemType.KW_Write);
        testKeyword("begin", LexemType.KW_Begin);
        testKeyword("end", LexemType.KW_End);
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

    @Test(expected = Error.class)
    public void testLeadingZeroNumeric() throws IOException {
        String wrongInteger = "01234";
        testNum(wrongInteger);
    }

    @Test
    public void testBoolean() throws IOException {
        StringReader reader = new StringReader("true");
        ArrayList<Lexem> lexems = Lexer.run(reader);
        Lexem lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(new Bool(-1, -1, -1, true), lex);
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals("true".length() - 1, lex.getFinish());
        assertEquals("Bool(true, 0, 0, " + ("true".length() - 1) + ")", lex.toString());

        reader = new StringReader("false");
        lexems = Lexer.run(reader);
        lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(new Bool(-1, -1, -1, false), lex);
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals("false".length() - 1, lex.getFinish());
        assertEquals("Bool(false, 0, 0, " + ("false".length() - 1) + ")", lex.toString());
    }

    @Test
    public void testBracketAndColon() throws IOException {
        StringReader reader = new StringReader("(");
        ArrayList<Lexem> lexems = Lexer.run(reader);
        Lexem lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(0, lex.getFinish());
        assertEquals("LBracket(0, 0, 0)", lex.toString());

        reader = new StringReader(")");
        lexems = Lexer.run(reader);
        lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(0, lex.getFinish());
        assertEquals("RBracket(0, 0, 0)", lex.toString());

        reader = new StringReader(";");
        lexems = Lexer.run(reader);
        lex = lexems.get(0);

        assertEquals(1, lexems.size());
        assertEquals(0, lex.getLine());
        assertEquals(0, lex.getStart());
        assertEquals(0, lex.getFinish());
        assertEquals("Colon(0, 0, 0)", lex.toString());
    }

    @Test
    public void testOperators() throws IOException {
        testOperator("==", LexemType.Eq);
        testOperator("+", LexemType.Plus);
        testOperator("-", LexemType.Minus);
        testOperator("*", LexemType.Multiplication);
        testOperator("/", LexemType.Division);
        testOperator("%", LexemType.Mod);
        testOperator("!=", LexemType.Neq);
        testOperator(">", LexemType.Greater);
        testOperator(">=", LexemType.Geq);
        testOperator("<", LexemType.Less);
        testOperator("<=", LexemType.Leq);
        testOperator("&&", LexemType.And);
        testOperator("||", LexemType.Or);
    }

    @Test
    public void testCorrectIdentifier() throws IOException {
        String[] identifiers = {"simpleID", "id1234", "_1234 ", "_____", "id_1234",
                "a", "_a", "A", "a_b", "iDeNt", "_i_D_", "__agent007__", "_13", "e2_e4", "reader"};
        for (String id : identifiers) {
            testCorrectIdentifier(id);
        }
    }

    @Test()
    public void testNumIsNotID() throws IOException {
        String id = "1";
        StringReader reader = new StringReader(id);
        ArrayList<Lexem> lexems = Lexer.run(reader);
        assertFalse(lexems.get(0) instanceof Identifier);
    }

    @Test(expected = Error.class)
    public void testWrongIdentifier() throws IOException {
        String id = "!myVar!";
        StringReader reader = new StringReader(id);
        ArrayList<Lexem> lexems = Lexer.run(reader);
        System.out.println(lexems.get(1));
    }


    @Test
    public void testWhitespaces() throws IOException {
        StringReader reader = new StringReader("        ");
        ArrayList<Lexem> lexems = Lexer.run(reader);
        assertEquals(0, lexems.size());

        reader = new StringReader("        \n");
        lexems = Lexer.run(reader);
        assertEquals(0, lexems.size());

        reader = new StringReader("        \n\r \t \f");
        lexems = Lexer.run(reader);
        assertEquals(0, lexems.size());
    }

}
