package ru.spbau.mit;


import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.antlr.v4.runtime.tree.Tree;
import ru.spbau.mit.utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LexerRunner {
    private boolean filter;
    private boolean fullTree;
    private boolean textTree;
    private boolean noTree;
    private Lexer lexer;
    private LLanguageParser parser;

    LexerRunner(boolean filter) {
        this(filter, false, false, true);
    }
    LexerRunner(boolean filter, boolean fullTree, boolean textTree, boolean noTree) {
        this.filter = filter;
        this.fullTree = fullTree;
        this.textTree = textTree;
        this.noTree = noTree;
    }


    private void processTokens(List<Token> tokens, Lexer lexer)  {
        for (Token token : tokens) {
            if ((!filter || (token.getChannel() != Token.HIDDEN_CHANNEL)) && (token.getType() != Token.EOF)) {
                String type = lexer.getVocabulary().getSymbolicName(token.getType());
                String text = token.getText();
                int pos = token.getCharPositionInLine();
                if (!text.equalsIgnoreCase(type)) {
                    System.out.println(String.format("%s(%s, %d, %d, %d)", type, text, token.getLine(), pos, pos + text.length() - 1));
                } else {
                    System.out.println(String.format("%s(%d, %d, %d)", type, token.getLine(), pos, pos + text.length() - 1));
                }
            }
        }
    }

    private static void clearTree(ParserRuleContext tree) {
        ArrayList<ParseTree> fake = new ArrayList<>();

        for (ParseTree node : tree.children) {

            if (node instanceof ParserRuleContext) {
                clearTree((ParserRuleContext)node);
                fake.add(node);
            }
            else {
                if (node instanceof TerminalNodeImpl) {
                    int type = ((TerminalNodeImpl) node).symbol.getType();
                    if (type > 9 && type != 13 && type != 14) {
                        fake.add(node);
                    }
                }
            }
        }

        tree.children = fake;
    }

    private void showTreeViewer(Tree tree) {
        List<String> ruleNames= Arrays.asList(parser.getRuleNames());
        TreeViewer tv = new TreeViewer(ruleNames, tree);
        tv.setTreeTextProvider(new CustomTextProvider(getVocabulary()));
        tv.setScale(1.7);
        tv.setUseCurvedEdges(true);
        tv.setFontSize(6);
        tv.setAutoscrolls(true);
        tv.open();
    }



    void parseFile(String file) throws IOException {
        CommonTokenStream tokens = lexFile(file, Token.DEFAULT_CHANNEL);

        if (!noTree) {
            parser = new LLanguageParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());
            ParserRuleContext t = parser.program();

            clearTree(t);

            if (fullTree) {
                showTreeViewer(t);
            }
            else {
                Tree tree = new ASTBuilder(t, lexer.getVocabulary());
                showTreeViewer(tree);
            }
            if (textTree) {
                Tree tree = new ASTBuilder(t, lexer.getVocabulary());
                System.out.println("LLanguage AST:");
                System.out.println();
                System.out.println(tree.toStringTree());
            }
        }
    }

    private CommonTokenStream lexFile(String f, int channel) throws IOException {
        lexer = new LLanguageLexer(new ANTLRFileStream(f));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());

        CommonTokenStream tokens = new CommonTokenStream(lexer, channel);
        tokens.fill();
        List<Token> toks = tokens.getTokens();
        System.out.println("***********************************************");
        System.out.println("Following lexems were found:");
        processTokens(toks, lexer);
        System.out.println("***********************************************");
        return tokens;
    }

    List<Token> getTokensFromInputStream(Reader reader) throws IOException {
        lexer = new LLanguageLexer(new ANTLRInputStream(reader));
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