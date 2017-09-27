package com.visa.ncg.canteen;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongIdGenerator implements IdGenerator {

  private final AtomicLong sequence = new AtomicLong();

  @Override
  public Long nextId() {
    return sequence.getAndIncrement();
  }
}
