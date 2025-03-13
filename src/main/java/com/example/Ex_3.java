package com.example;

import java.util.*;

public class Ex_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the number of words");
        int N = scanner.nextInt();
        List<String> inputList = new ArrayList<String>();
        System.out.println("Give the words");
        for (int i = 0; i < N; i++) {
            inputList.add(scanner.next());
        }
        List<Character> firstCharList = new ArrayList<Character>();
        List<Character> lastCharList = new ArrayList<Character>();
        HashMap<Character,Character> twoCharsXY = new HashMap<Character,Character>();
        for(String word : inputList) {
            if(word.length() > 1) {
                firstCharList.add(word.charAt(0));
                lastCharList.add(word.charAt(word.length() - 1));
            }
            for(int i = 0; i < word.length()-1; i++) {
                char X = word.charAt(i);
                char Y = word.charAt(i+1);
                twoCharsXY.put(X, Y);
            }
        }

        Random random = new Random();
        System.out.println("Generated words");
        for(int i = 0; i < 100; i++){
            String output = generateWord(firstCharList,lastCharList,twoCharsXY,random);
            System.out.println(output);
        }

        scanner.close();
    }
    private static String generateWord(List<Character> firstCharList, List<Character> lastCharList,
                                          HashMap<Character, Character> twoCharsXY, Random random) {
        StringBuilder outputWord = new StringBuilder();

        char currentChar = firstCharList.get(random.nextInt(firstCharList.size()));
        outputWord.append(currentChar);

        while (twoCharsXY.containsKey(currentChar)) {
            char nextChar = twoCharsXY.get(currentChar);
            outputWord.append(nextChar);

            currentChar = nextChar;

            if (lastCharList.contains(currentChar) && random.nextBoolean()) {
                break;
            }
        }

        return outputWord.toString();
    }

}
