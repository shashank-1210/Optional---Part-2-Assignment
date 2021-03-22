package com.assignment;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creating PhoneCrawler class.
 */
public class PhoneCrawler {


  /**
     * Creating instance of Phonebook class.
  */
  private final PhoneBook phoneBook;

  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param phoneBook1 takes name as input
   */
  public PhoneCrawler(final PhoneBook phoneBook1) {
    phoneBook = phoneBook1;
  }


  /**
     * Takes phone as input and return name.
     *
     * @param name takes name as input
     * @return name associated with phoneNumber
  */
  public  String findPhoneByNameAndPunishIfNothingFound(final String name) {
    return phoneBook.findPhoneByName(name).orElse("NothingFound");
  }

  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param name takes name as input
     * @return phoneNumber associated with name
   */
  public String findPhoneByNameAndPrintPhoneBookIfNothingFound(final String name) {

    return phoneBook.findPhoneByName(name)
                .orElseGet(() -> phoneBook.toString());

  }
  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param name takes name as input
     * @return phoneNumber associated with name
   */

  public  String findPhoneByNameAndPunishIfNothingFoundUsingLambda(final String name) {
    return PhoneBook.PHONE_NUMBERS
                .entrySet()
                .stream()
                .filter(x -> x.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        map -> Optional.ofNullable(map.getValue())))
                .get(name)
                .orElse("Nothing");
  }

  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param name takes name as input
     * @return phoneNumber associated with name
   */
  public String findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingLambda(final String name) {

    return PhoneBook.PHONE_NUMBERS
                .entrySet()
                .stream()
                .filter(x -> x.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        map -> Optional.ofNullable(map.getValue())))
                .get(name)
                .orElseGet(phoneBook::toString);


  }

  /**
     * Takes name as input and return PhoneNumber.
     *
     * @param name takes name as input
     * @param phoneNumber takes name as input
     * @return phoneNumber or name
  */
  public String findPhoneNumberByNameOrNameByPhoneNumber(final String name, final String phoneNumber) {
    return Stream.of(phoneBook.findPhoneByName(name),
                phoneBook.findNameByPhoneNumber(phoneNumber))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
  }




}
