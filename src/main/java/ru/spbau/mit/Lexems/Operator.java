package ru.spbau.mit.Lexems;

public class Operator extends Lexem {
    private LexemType type;

    public Operator(LexemType type, int line, int start, int finish) {
        super(line, start, finish);
        this.type = type;
    }

    public LexemType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator = (Operator) o;

        return type == operator.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Op" + "(" + type.name() + ", " + line+", " + start + ", " + finish + ")";
    }
}
