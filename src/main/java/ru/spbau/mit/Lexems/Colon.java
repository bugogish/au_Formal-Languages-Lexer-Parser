package ru.spbau.mit.Lexems;

public class Colon extends Lexem {
    public Colon(int line, int start, int finish) {
        super(line, start, finish);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || !(obj == null || getClass() != obj.getClass());
    }

    @Override
    public String toString() {
        return "Colon" + "(" + line+", " + start + ", " + finish + ")";
    }
}
