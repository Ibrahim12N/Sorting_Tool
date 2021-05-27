package sorting;

import java.util.Collections;
import java.util.List;

public class SortingNaturally {
    static Data data= new Data();

    void sortWordNaturally(List<String> wordsInput, String fileOut) {
        Collections.sort(wordsInput);

        if (fileOut.equals("noFile")) {
            System.out.println("Total words: " + wordsInput.size());
            System.out.print("Sorted data: ");
            wordsInput.forEach(e -> System.out.print(e + " "));
        }
        else {
            StringBuilder text = new StringBuilder();
            text.append("Total words: ").append(wordsInput.size()).append("\n");
            text.append("Sorted data: \n");
                wordsInput.forEach(e->text.append(e).append(" "));
            data.writingFile(fileOut,text.toString());
        }
    }

     void sortLineNaturally(List<String> linesInput, String fileOut) {
        Collections.sort(linesInput);

        if (fileOut.equals("noFile")) {
            System.out.println("Total lines: "+linesInput.size() );
            System.out.print("Sorted data: \n");
            linesInput.forEach(e -> System.out.println(e+" "));}
        else {
            StringBuilder text = new StringBuilder();
            text.append("Total lines: ").append(linesInput.size()).append("\n");
            text.append("Sorted data: \n");
            linesInput.forEach(e -> text.append(e).append(" \n"));
            data.writingFile(fileOut,text.toString());
        }
    }

     void sortLongNaturally(List<Integer> longsInput, String fileOut) {
        Collections.sort(longsInput);
        if (fileOut.equals("noFile")) {
            System.out.println("Total numbers: "+longsInput.size() );
            System.out.print("Sorted data: ");
            longsInput.forEach(e -> System.out.print(e+" "));}
        else {
            StringBuilder text = new StringBuilder();
            text.append("Total numbers: ").append(longsInput.size()).append("\n");
            text.append("Sorted data: ");
            longsInput.forEach(e -> text.append(e).append(" "));
            data.writingFile(fileOut,text.toString());
        }
    }
}
