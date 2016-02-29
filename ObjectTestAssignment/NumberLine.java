package ObjectTestAssignment;

public interface NumberLine {
    public int getSmall();

    int getBig();

    boolean smallInclusive();

    boolean bigInclusive();

    boolean Intersect(NumberLine line);

    String toString();

}
