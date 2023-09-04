package com.dev.clinic.utils;

public class MedicUtils {

    public MedicUtils() {
    }

    public static String getRegistrationNumber() {
        String registrationNumber;
        registrationNumber = "ABC-" + (long) ((Math.random() * (99999999 - 10000000)) + 10000000);
        return registrationNumber;
    }

}
