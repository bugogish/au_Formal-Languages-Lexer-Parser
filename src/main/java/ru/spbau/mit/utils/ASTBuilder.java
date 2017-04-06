package ru.spbau.mit.utils;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * constructs and prints trimmed parse tree
 */

public class ASTBuilder implements Tree {
    private List<ASTBuilder> children;
    private final Object payload;
    private ASTBuilder parent;
    private static Vocabulary vocabulary;

    private ASTBuilder(ASTBuilder parent, ParseTree tree, List<ASTBuilder> children) {
        this.payload = getPayload(tree);
        this.children = children;
        if (parent == null) {
            traverse(tree, this);
        }
        else {
            parent.children.add(this);
            this.parent = parent;
        }
    }

    private ASTBuilder(ASTBuilder root, ParseTree tree) {
        this(root, tree, new ArrayList<>());
    }
    public ASTBuilder(ParseTree tree, Vocabulary vocabulary) {
            this(null, tree);
        ASTBuilder.vocabulary = vocabulary;
        }

    public Object getPayload() {
        return payload;
    }

    @Override
    public Tree getParent() {
        return parent;
    }

    @Override
    public Tree getChild(int i) {
        return children.get(i);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    private Object getPayload(ParseTree node) {
            if (node.getChildCount() == 0) {
                return node.getPayload();
            }
            else {
                String ruleName = node.getClass().getSimpleName().replace("Context", "");
                return Character.toLowerCase(ruleName.charAt(0)) + ruleName.substring(1);
            }
        }

    private static void traverse(ParseTree node, ASTBuilder ASTnode) {
            if (node.getChildCount() == 0) {
                new ASTBuilder(ASTnode, node);
            }
            else if (node.getChildCount() == 1) {
                traverse(node.getChild(0), ASTnode);
            }
            else if (node.getChildCount() > 1) {
                for (int i = 0; i < node.getChildCount(); i++) {
                    ASTBuilder candidateNode = new ASTBuilder(ASTnode, node.getChild(i));
                    if (!(candidateNode.payload instanceof Token)) {
                        traverse(node.getChild(i), candidateNode);
                    }
                }
            }
        }

    @Override
    public String toStringTree() {
        StringBuilder builder = new StringBuilder();

        ASTBuilder node = this;
        List<ASTBuilder> printStack = new ArrayList<>();
        printStack.add(node);

        List<List<ASTBuilder>> childListStack = new ArrayList<>();
        childListStack.add(printStack);

        while (!childListStack.isEmpty()) {

            List<ASTBuilder> childStack = childListStack.get(childListStack.size() - 1);

            if (childStack.isEmpty()) {
                childListStack.remove(childListStack.size() - 1);
            }
            else {
                node = childStack.remove(0);
                String nodeText;

                if (node.payload instanceof Token) {
                    Token token = (Token) node.payload;
                    String type = vocabulary.getSymbolicName(token.getType());
                    String text = token.getText();
                    int pos = token.getCharPositionInLine();
                    if (Objects.equals(type, "Id") || Objects.equals(type, "Float") || Objects.equals(type, "Boolean")) {
                        nodeText = String.format("%s[%s, %d, %d, %d]", type, text, token.getLine(), pos, pos + text.length() - 1);
                    } else {
                        nodeText = String.format("%s[%d, %d, %d]", type, token.getLine(), pos, pos + text.length() - 1);
                    }
                }
                else {
                    nodeText = String.valueOf(node.payload);
                }

                StringBuilder indent = new StringBuilder();

                for (int i = 0; i < childListStack.size() - 1; i++) {
                    indent.append((childListStack.get(i).size() > 0) ? "│  " : "   ");
                }

                builder.append(indent)
                        .append(childStack.isEmpty() ? "└── " : "├── ")
                        .append(nodeText)
                        .append("\n");

                if (node.children.size() > 0) {
                    List<ASTBuilder> children = new ArrayList<>();
                    children.addAll(node.children);
                    childListStack.add(children);
                }
            }
        }

        return builder.toString();
    }
}
