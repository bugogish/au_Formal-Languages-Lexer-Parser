package ru.spbau.mit.utils;


import org.antlr.v4.gui.TreeTextProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

import java.util.List;
import java.util.Objects;

public class CustomTextProvider implements TreeTextProvider {
    private final Vocabulary vocabulary;

    public CustomTextProvider(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public String getText(Tree node) {
        Object payload = node.getPayload();
        if (payload instanceof Token) {
            Token token = (Token) payload;
            int pos = token.getStartIndex();
            String text = token.getText();
            return String.format("[%s, %d]", text, pos);
        } else {
            if (payload.toString().endsWith("expr")) {
                return "expression";
            }
//            if (payload.toString().equals("block")) {
//                return "statement";
//            }
            return payload.toString();
        }
    }
}
