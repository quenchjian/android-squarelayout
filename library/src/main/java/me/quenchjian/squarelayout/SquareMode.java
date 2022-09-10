package me.quenchjian.squarelayout;

public enum SquareMode {
  FOLLOW_WIDTH(1),
  FOLLOW_HEIGHT(2);

  public final int id;

  SquareMode(int id) {
    this.id = id;
  }

  public static SquareMode fromId(int id) {
    if (id == 1) {
      return FOLLOW_WIDTH;
    } else if (id == 2) {
      return FOLLOW_HEIGHT;
    } else {
      throw new IllegalArgumentException("Unknown id " + id);
    }
  }
}
