package io.beansprout.boost.exceptions;

public enum ValidationCode implements ErrorCode {
  NOT_FOUND(201);

  private final int number;

  ValidationCode(int number) {
    this.number = number;
  }

  @Override
  public int getNumber() {
    return number;
  }
}
