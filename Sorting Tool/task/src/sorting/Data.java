package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Data {
    private final List<Integer> integersList=new ArrayList<>();
    private final List<String> wordsList=new ArrayList<>();
    private final List<String> linesList=new ArrayList<>();

     void gettingIntegerInput(String fileIn) {
         if(!fileIn.equals("noFile")){
             String [] inputText=readingFile(fileIn).split("\\s+");
             System.out.println(readingFile(fileIn));
             for( var entry: inputText){
                integersList.add(Integer.parseInt(entry));
             }
         }
         else {
        Scanner scanner = new Scanner(System.in);
        String str="";
        while (scanner.hasNext()){
            try {
                str=scanner.next();
                int x=Integer.parseInt(str);
                integersList.add(x);
            } catch (NumberFormatException e) {
                System.out.println(str+" is not a long. It will be skipped");
            }
        }}
    }

    void gettingWordsInput(String fileIn) {
        if(!fileIn.equals("noFile")){
            String [] inputText=readingFile(fileIn).split("\\s+");
            System.out.println(readingFile(fileIn));
            Collections.addAll(wordsList, inputText);
        } else {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                wordsList.add(scanner.next());
            }
        }
    }
    void gettingLinesInput(String fileIn) {
        if(!fileIn.equals("noFile")){
            try (BufferedReader br= Files.newBufferedReader(Path.of(fileIn))){
                String intVal;
                while((intVal= br.readLine())!=null){
                    linesList.add(intVal);
                }
            } catch (IOException e) {
                System.out.println("error");
            }
        } else {

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                linesList.add(scanner.nextLine());
            }
        }
    }

     String readingFile(String fileIn) {
        StringBuilder sb=new StringBuilder();

        try (BufferedReader br= Files.newBufferedReader(Paths.get(fileIn))){
            String intVal;
            while((intVal= br.readLine())!=null){
                sb.append(intVal).append(" ");
            }
        } catch (IOException e) {
            System.out.println("error");
        }
        return sb.toString();
    }
      void writingFile(String fileOut, String readText) {
        try (BufferedWriter bw= Files.newBufferedWriter(Path.of(fileOut))){
            bw.write(readText);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public List<Integer> getIntegersList() {
        return integersList;
    }

    public List<String> getWordsList() {
        return wordsList;
    }

    public List<String> getLinesList() {
        return linesList;
    }
}
