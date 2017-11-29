/*
 * Created by Dave on 11/29/17.
 */


import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

public class DailyProgrammer341 {

    public static void main(String[] args) {
        String testData = "82156821568221";
        Map<String, Integer> numbers = mapNumbers(testData);
        System.out.println(numbers.toString());

        String testDataTwo = "11111011110111011";
        Map<String, Integer> numbersTwo = mapNumbers(testDataTwo);
        System.out.println(numbersTwo.toString());
    }

    private static Map<String, Integer> mapNumbers(String entireNumber) {
        Map<String, Integer> numbers = new TreeMap<String, Integer>();

        // loop over the number and add each sub number to the map
        // numbers must be at least two digits long
        for (int i = 2; i < entireNumber.length() + 1; i++) {
            String currentChunk = entireNumber.substring(0, i);
            // System.out.println("currentChunk: " + currentChunk);
            // add currentChunk to map or increment the count
            Integer count = numbers.containsKey(currentChunk) ? numbers.get(currentChunk) : 0;
            numbers.put(currentChunk, count + 1);
            // System.out.println("Size: " + numbers.size());

            if (currentChunk.length() > 2) {
                for (int j = 1; j < currentChunk.length(); j++) {
                    String chunkOfChunk = currentChunk.substring(j);
                    if (chunkOfChunk.length() > 1) {
                        // System.out.println("chunkOfChunk: " + chunkOfChunk);
                        Integer currentCount = numbers.containsKey(chunkOfChunk) ? numbers.get(chunkOfChunk) : 0;
                        numbers.put(chunkOfChunk, currentCount + 1);
                        // System.out.println("Inner Loop Size: " + numbers.size());
                    }
                }
            }
        }
        // System.out.println("Loops over");
        return numbers;
    }
}
