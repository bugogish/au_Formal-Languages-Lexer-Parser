package ru.spbau.mit;

import org.antlr.v4.runtime.*;
import ru.spbau.mit.utils.ErrorListener;
import ru.spbau.mit.utils.LLanguage;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

class LexerRunner {
    private boolean filter;
    private Lexer lexer;

    LexerRunner(boolean filter) {
        this.filter = filter;
    }

    private void processTokens(List<Token> tokens, Lexer lexer)  {
        for (Token token : tokens) {
            if (!filter || !(token.getChannel() == Token.HIDDEN_CHANNEL)) {
                String type = lexer.getVocabulary().getSymbolicName(token.getType());
                String text = token.getText();
                if (!text.equalsIgnoreCase(type)) {
                    System.out.println(String.format("%s(%s, %d, %d, %d)", type, text, token.getLine(), token.getStartIndex(), token.getStopIndex()));
                } else {
                    System.out.println(String.format("%s(%d, %d, %d)", type, token.getLine(), token.getStartIndex(), token.getStopIndex()));
                }
            }
        }
    }

    void parseFile(String f) throws IOException {
        lexer = new LLanguage(new ANTLRFileStream(f));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> toks = tokens.getTokens();
        System.out.println("Following lexems were found:");
        processTokens(toks, lexer);
    }

    List<Token> getTokensFromInputStream(Reader reader) throws IOException {
        lexer = new LLanguage(new ANTLRInputStream(reader));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        return tokens.getTokens();
    }

    Vocabulary getVocabulary() {
        return lexer != null ? lexer.getVocabulary() : null;
    }
}