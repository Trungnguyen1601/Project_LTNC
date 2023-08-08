package com.example.vetau.helpers;

public class ExtractString {
    public static int extractNumber(String chuoi) {
        StringBuilder soA = new StringBuilder();
        for (int i = chuoi.length() - 1; i >= 0; i--) {
            char kyTu = chuoi.charAt(i);
            if (Character.isDigit(kyTu)) {
                soA.insert(0, kyTu);
            } else {
                break;
            }
        }

        if (soA.length() > 0) {
            return Integer.parseInt(soA.toString());
        } else {
            return -1;
        }
    }
    public int Extract_String(String ID, String MaSo)
    {
        int STT = extractNumber(ID);
        return STT;
    }
    public static String extractNumber_from_ToaTau(String input) {
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                startIndex = i;
                break;
            }
        }

        if (startIndex != -1) {
            for (int i = startIndex; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    endIndex = i;
                    break;
                }
            }

            if (endIndex == -1) {
                endIndex = input.length();
            }

            return input.substring(startIndex, endIndex);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(extractNumber("SV19"));
        String input = "TOA10TAU1";
        String extractedNumber = extractNumber_from_ToaTau(input);

        if (extractedNumber != null) {
            System.out.println("Extracted number: " + extractedNumber);
        } else {
            System.out.println("No number found in the string.");
        }
    }
}

