package com.visa.ncg.canteen;

public class FakeIdGenerator implements IdGenerator {
  private final long alwaysReturns;

  public FakeIdGenerator() {
    alwaysReturns = 1L;
  }

  public FakeIdGenerator(long alwaysReturns) {
    this.alwaysReturns = alwaysReturns;
  }

  @Override
  public Long nextId() {
    return alwaysReturns;
  }
}
