package ru.spbau.mit.Lexems;

public abstract class Lexem {
    int line;
    int start;
    int finish;

    Lexem(int line, int start, int finish) {
        this.line = line;
        this.start = start;
        this.finish = finish;
    }

    public int getLine() {
        return line;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }
}
