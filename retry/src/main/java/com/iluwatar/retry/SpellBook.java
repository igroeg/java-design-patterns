package com.iluwatar.retry;

public class SpellBook {

  public SpellBook() {

  }

  /***
   *
   * @return
   * @throws Exception
   */
  public String getSpellWithTransientFault() throws Exception {
    Exception e = new CustomException("this is some transient fault");

    throw e;
  }

  public String getSpellWithSeriousFault() throws Exception {
    Exception e = new CustomException("this is some serious fault");
    throw e;
  }

}
