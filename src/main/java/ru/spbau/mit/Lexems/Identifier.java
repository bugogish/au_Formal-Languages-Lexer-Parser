package ru.spbau.mit.Lexems;

public class Identifier extends Lexem {
    private String value;

    public Identifier(int line, int start, int finish, String value) {
        super(line, start, finish);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Ident" + "(" + value + ", " + line+", " + start + ", " + finish + ")";
    }
}
