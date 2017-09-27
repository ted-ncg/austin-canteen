package com.visa.ncg.canteen;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class AtomicLongIdGenerator implements IdGenerator {

  private final AtomicLong sequence = new AtomicLong();

  @Override
  public Long nextId() {
    return sequence.getAndIncrement();
  }
}
