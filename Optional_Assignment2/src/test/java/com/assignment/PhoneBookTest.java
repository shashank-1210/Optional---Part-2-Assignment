package com.assignment;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *  TestClass For PhoneBook.
 */

public class PhoneBookTest {
  /**
   * Creating PhoneBook instance.
  **/

  private PhoneBook phoneBook = new PhoneBook();

  /**
   ** Test1.
  */

  @Test()
  public void findPhoneByName() {

    String name = "Shashank";

    String expected = "12345";

    Optional<String> actual = phoneBook.findPhoneByName(name);

    Assert.assertEquals(expected, actual.get());
  }
  /**
  * Test2.
  */

  @Test(expected = NoSuchElementException.class)
  public void findPhoneByNameNegative() {

    String name = "Shashank";


    Optional<String> actual = phoneBook.findPhoneByName(name);


    actual.get();
  }

  /**
   * Test3.
   */
  @Test()
  public void findNameByPhone() {
    String number  = "12345";

    String expected = "Shashank";

    Optional<String> actual = phoneBook.findNameByPhoneNumber(number);
    Assert.assertEquals(expected, actual.get());
  }

  /**
   * Test4.
  */

  @Test(expected = NoSuchElementException.class)
  public void findNameByPhoneNegative() {
    String number = "123";
    Optional<String> actual = phoneBook.findNameByPhoneNumber(number);
    actual.get();
  }

}
