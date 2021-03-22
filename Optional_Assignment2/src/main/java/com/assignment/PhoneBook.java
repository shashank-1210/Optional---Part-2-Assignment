package com.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Creating PhoneBook Class.
 */

public class PhoneBook {
  /**
     * Storing numbers in Hashmap.
   */
  public static final Map<String, String> PHONE_NUMBERS = new HashMap<>();
  PhoneBook() {
    PHONE_NUMBERS.put("Shashank", "12345");
    PHONE_NUMBERS.put("Vasu", "67890");
    PHONE_NUMBERS.put("Anmol", "123");
  }

  /**
     * Logger Instance.
  **/
  private Logger logger = Logger.getLogger(PhoneBook.class.getName());

  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param name takes name as input
     * @return phoneNumber associated with name
   */
  Optional<String> findPhoneByName(final String name) {
    return Optional.ofNullable(PHONE_NUMBERS.get(name));
  }


  /**
     * Takes phone as input and return name.
     *
     * @param phoneNumber takes phoneNumber as input
     * @return name associated with phoneNumber
   */
  Optional<String> findNameByPhoneNumber(final String phoneNumber) {
    for (Map.Entry<String, String> entry : PHONE_NUMBERS.entrySet()) {
      if (entry.getValue().equals(phoneNumber)) {
        return Optional.of(entry.getKey());
      }
    }
    return Optional.empty();
  }


  /**
     * Overriding toString() method.
   */
  @Override
  public String toString() {
    logger.info("Hello from PhoneBook toString Method");
    return "PhoneBook [phoneNumbers=" + PHONE_NUMBERS + "]";
  }

}
