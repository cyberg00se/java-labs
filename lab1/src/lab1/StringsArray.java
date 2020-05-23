package lab1;

import java.util.ArrayList;

class StringsArray {
    static public ArrayList<String> getOutputArray(ArrayList<String> inputArray) {
        ArrayList<String> outputArray = new ArrayList<String>();
        double avgLength = countAvgLength(inputArray);

        for(String element:inputArray) {
            if (element.length() < avgLength)
                outputArray.add(element);
        }

        return outputArray;
    }

    static public double getAvgLength(ArrayList<String> inputArray) {
        return countAvgLength(inputArray);
    }

    static private double countAvgLength(ArrayList<String> inputArray) {
        double avgLength = 0;
        for(String element:inputArray) {
            avgLength += element.length();
        }
        avgLength /= inputArray.size();
        return avgLength;
    }
}
