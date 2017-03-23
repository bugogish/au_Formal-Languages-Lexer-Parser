package ru.spbau.mit.Lexems;

public class Bracket extends Lexem {
    private LexemType type;

    public Bracket(LexemType type, int line, int start, int finish) {
        super(line, start, finish);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bracket bracket = (Bracket) o;

        return type == bracket.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return  type.name() + "(" + line+", " + start + ", " + finish + ")";
    }
}
