package ru.spbau.mit.Lexems;

public class Comment extends Lexem {
    private String value;

    public Comment(int line, int start, int finish, String value) {
        super(line, start, finish);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return value.equals(comment.value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override

    public String toString() {
        return "Comment" + "(" + value + ", " + line+", " + start + ", " + finish + ")";
    }
}
