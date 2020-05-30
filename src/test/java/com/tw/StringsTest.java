package com.tw;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This is a sample file. Please delete it.
class StringTest {
    @Test
    void should_iterate_Strings_and_put_into_a_character_array() {
        String strings = new String();
        strings = "I am DK.";
        char[] charArray = new char[strings.length()];
        for (int i = 0; i < strings.length(); i++) {
            charArray[i] = strings.charAt(i);
        }
        //System.out.println("the third element is: "+charArray[2]);
        assertEquals(new char[]{'I', ' ', 'a', 'm', ' ', 'D', 'K', '.'}, charArray);
    }

    @Test
    void should_iterate_Strings_and_put_into_a_int_array() {
        String strings = new String();
        strings = "to int";
        int[] intArray = new int[strings.length()];
        for (int i = 0; i < strings.length(); i++) {
            intArray[i] = (int) strings.charAt(i);
        }
        System.out.println(Arrays.toString(intArray));
    }

    @Test
    void should_split_Strings_by_token_characters() {
        String strings = new String();
        strings = "aaa,bbb,ccc";
        String[] splitedString = strings.split("\\,");
        for (int i = 0; i < splitedString.length; i++) {
            System.out.println(splitedString[i]);
        }
    }

    @Test
    void should_be_replaced_with_special_rules() {
        String strings = new String();
        strings = "aaa,bbb,ccc";
        char[] reslutChar = swapAB(strings);
        System.out.println("original strings:" + strings);
        System.out.println("a-b swap:" + Arrays.toString(reslutChar));
    }

    private char[] swapAB(String strings) {
        char[] charTemp = strings.toCharArray();
        for (int i = 0; i < charTemp.length; i++) {
            if (charTemp[i] == 'b') {
                charTemp[i] = '2';
            }
            if (charTemp[i] == 'a') {
                charTemp[i] = '1';
            } else {
                continue;
            }
        }
        for (int i = 0; i < charTemp.length; i++) {
            if (charTemp[i] == '2') {
                charTemp[i] = 'a';
            }
            if (charTemp[i] == '1') {
                charTemp[i] = 'b';
            } else {
                continue;
            }
        }
        return charTemp;
    }

    @Test
    void should_be_replaced_with_special_rules2() {
        String strings = new String();
        strings = "aaa,bbb,ccc";
        String temp1 = strings.replace("a", "1");
        String temp2 = temp1.replace("b", "2");
        String temp3 = temp2.replace("1", "b");
        String temp4 = temp3.replace("2", "a");

        System.out.println("original strings:" + strings);
        System.out.println("a-b swap:" + temp4);
    }
    @Test
    void align_strings() {
        String strings = "abc";
        StringBuilder temp = new StringBuilder();
        int setNum = 70;
        for (int i = 0; i < setNum ; i++) {
            temp.append(" ");
        }
        temp.replace((temp.length()-strings.length()),temp.length()-1,strings);
        System.out.println(temp);
    }
    @Test
    void reverse_strings() {
        String strings = new String();
        strings = "qwer";
        String reverse = new StringBuffer(strings).reverse().toString();
        System.out.println(reverse);
    }
    @Test
    void reverse_word_in_strings1() {
        String strings = new String();
        strings = "One Two Three";
        String [] split = strings.split("\\ ");
        for (int i = 0; i < split.length; i++) {
            split [i] = new StringBuffer(split[i]).reverse().toString();
        }
        StringBuilder reverseWord = new StringBuilder();
        for (int i = 0; i <split.length ; i++) {
            if (i == split.length - 1) {
                reverseWord.append(split[i]);
            }
            else {
                reverseWord.append(split[i]+" ");
            }
        }
        System.out.println(reverseWord);
    }
    @Test
    void reverse_word_in_strings2() {
        String strings = new String();
        strings = "One Two Three";
        String [] split = strings.split("\\ ");
        StringBuilder reverseWord = new StringBuilder();
        for (int i = split.length - 1; i >= 0 ; i--) {
            if (i == 0) {
                reverseWord.append(split[i]);
            }
            else {
                reverseWord.append(split[i]+" ");
            }
        }
        System.out.println(reverseWord);
    }
    @Test
    void turn_the_first_letter_in_uppercase_of_strings() {
        String strings = "one Two three";
        StringBuilder firstUppercase = new StringBuilder();
        firstUppercase.append(Character.toUpperCase(strings.charAt(0)));
        for (int i = 1; i <strings.toCharArray().length - 1 ; i++) {
            if (Character.isLowerCase(strings.charAt(i)) && strings.charAt(i - 1) == ' ' ){
                firstUppercase = firstUppercase.append(Character.toUpperCase(strings.charAt(i)));
            }
            else {
                firstUppercase = firstUppercase.append(strings.charAt(i));
            }
        }
        firstUppercase.append(strings.charAt(strings.toCharArray().length - 1));
        System.out.println(firstUppercase);
    }
    @Test
    void match_mobile_phone_numbers_in_strings() {
        String phoneNum1 = "+86 155 5032 2354";
        String phoneNum2 = "+86 063 5032 2354";
        String phoneNum3 = "+86 15550322354";
        isPhoneNum(phoneNum1);
        isPhoneNum(phoneNum2);
        isPhoneNum(phoneNum3);

    }

    private boolean isPhoneNum(String string) {
        Pattern rules = Pattern.compile("\\+86 [1-9]\\d{2} \\d{4} \\d{4}");
        Matcher matcher = rules.matcher(string);
        if (matcher.matches()) {
            System.out.println("that is a phone number.");
            return true;
        }
        else {
            System.out.println("that can't be a phone number.");
            return false;
        }
    }
}
//