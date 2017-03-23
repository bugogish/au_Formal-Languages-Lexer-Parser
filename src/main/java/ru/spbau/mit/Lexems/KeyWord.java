package ru.spbau.mit.Lexems;

public class KeyWord extends Lexem {
    private LexemType type;

    public KeyWord(LexemType type, int line, int start, int finish) {
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

        KeyWord keyWord = (KeyWord) o;

        return type == keyWord.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return type.name() +"(" + line+", " + start + ", " + finish + ")";
    }
}
