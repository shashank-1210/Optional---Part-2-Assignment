package com.assignment;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for PhoneCrawler Test.
 */

public class PhoneCrawlerTest {

  /**
  *  PhoneCrwaler instance.
  */

  private final PhoneCrawler phoneBookCrawler =
            new PhoneCrawler(new PhoneBook());


  /**
  * Test1.
  */
  @Test
  public void findPhoneNumberByNameAndFindSomething() {

    String actual = phoneBookCrawler
        .findPhoneByNameAndPunishIfNothingFound("Shashank");

    String expected = "12345";

    Assert.assertEquals(expected, actual);


  }

  /**
  * Test2.
  */
  @Test
  public void findPhoneNumberByNameAndPunishIfNothingFound() {

    String actual = phoneBookCrawler
        .findPhoneByNameAndPunishIfNothingFound("Raghav");
    String expected = "NothingFound";

    Assert.assertEquals(expected, actual);

  }

  /**
   * Test3.
   */
  @Test
  public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {

    String actual = phoneBookCrawler
            .findPhoneByNameAndPrintPhoneBookIfNothingFound("Saurav");

    String expected = "PhoneBook [phoneNumbers="
           + "{Vasu=67890, Shashank=12345, Anmol=123}]";

    Assert.assertEquals(expected, actual);


  }

  /**
   * Test4.
   */
  @Test
  public void findPhoneNumberByNameOrNameByPhoneNumberfoundByName() {
    String actual = phoneBookCrawler
                   .findPhoneNumberByNameOrNameByPhoneNumber("Shashank", "145");

    String expected = "12345";

    Assert.assertEquals(expected, actual);


  }

  /**
   * Test5.
   */
  @Test
  public void findPhoneNumberByNameOrNameByPhoneNumberfoundByNumber() {
    String actual = phoneBookCrawler
            .findPhoneNumberByNameOrNameByPhoneNumber("Saurav", "12345");

    String expected = "Shashank";

    Assert.assertEquals(expected, actual);


  }
}
