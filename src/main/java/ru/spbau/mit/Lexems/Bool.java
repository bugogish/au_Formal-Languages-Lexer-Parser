package ru.spbau.mit.Lexems;

public class Bool extends Lexem {
    private boolean value;

    public Bool(int line, int start, int finish, boolean value) {
        super(line, start, finish);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bool bool = (Bool) o;

        return value == bool.value;
    }

    @Override
    public int hashCode() {
        return (value ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Bool" + "(" + value + ", " + line+", " + start + ", " + finish + ")";
    }
}
