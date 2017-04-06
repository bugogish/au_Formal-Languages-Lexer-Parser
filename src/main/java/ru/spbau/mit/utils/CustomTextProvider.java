package ru.spbau.mit.utils;


import org.antlr.v4.gui.TreeTextProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

import java.util.List;

public class CustomTextProvider implements TreeTextProvider {
    private List<String> ruleNames;

    public CustomTextProvider(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }

    @Override
    public String getText(Tree node) {
        Object payload = node.getPayload();
        if (payload instanceof Token) {
            Token token = (Token) payload;
            int pos = token.getStartIndex();
            String text = token.getText();
            return String.format("[%s, %d]", text, pos);
        } else if (payload instanceof ParserRuleContext) {
            return String.valueOf(Trees.getNodeText(node, ruleNames));
        }
        return payload.toString();
    }
}
