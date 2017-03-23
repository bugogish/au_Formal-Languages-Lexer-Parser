package ru.spbau.mit.Lexems;

public class NumericValue extends Lexem {
    private double value;

    public NumericValue(int line, int start, int finish, double value) {
        super(line, start, finish);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumericValue that = (NumericValue) o;

        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override

    public String toString() {
        return "Num" + "(" + value + ", " + line+", " + start + ", " + finish + ")";
    }
}
