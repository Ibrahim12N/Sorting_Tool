package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String datatype = "word";
        String sortType="natural";
        String fileIn = "noFile";
        String fileOut = "noFile";


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-inputFile"))
                fileIn = args[i + 1];

            if (args[i].equals("-outputFile"))
                fileOut = args[i + 1];

            if (args[i].equals("-dataType")) {
                if (!List.of("long", "line", "word").contains(args[i + 1])) {
                    System.out.println("No data type defined!");
                    return;
                } else
                    datatype = args[i + 1];
            }

            if (args[i].equals("-sortingType")) {
                if (args.length == i + 1 || !List.of("natural", "byCount").contains(args[i + 1])) {
                    System.out.println("No sorting type defined!");
                    return;
                }
                sortType=args[i+1];
            }
        }

        Sorting sorting=new Sorting(datatype,fileIn,fileOut,sortType);
        sorting.startSorting();
    }
}
