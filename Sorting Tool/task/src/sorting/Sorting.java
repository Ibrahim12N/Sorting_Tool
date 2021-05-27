package sorting;

import java.util.List;

public class Sorting {

    String datatype;
    String fileIn;
    String fileOut;
    String sortType;

    public Sorting(String datatype, String fileIn, String fileOut, String sortType) {
        this.datatype = datatype;
        this.fileIn = fileIn;
        this.fileOut = fileOut;
        this.sortType = sortType;
    }

    void startSorting(){
        Data data=new Data();
        if(sortType.equals("byCount")){
            SortingByCount sortingByCount=new SortingByCount();
            switch (datatype) {
                case "long":
                    data.gettingIntegerInput(fileIn);
                    List<Integer> input=data.getIntegersList();
                    sortingByCount.sortLong(input,fileOut);
                    break;
                case "line":
                    data.gettingLinesInput(fileIn);
                    List<String> linesInput=data.getLinesList();
                    sortingByCount.sortLine(linesInput,fileOut);
                    break;
                case "word":
                    data.gettingWordsInput(fileIn);
                    List<String> wordsInput=data.getWordsList();
                    sortingByCount.sortWord(wordsInput, fileOut);
                    break;
            }
        }

        else  {
            SortingNaturally sortingNaturally=new SortingNaturally();
            switch (datatype) {
                case "long":
                    data.gettingIntegerInput(fileIn);
                    List<Integer> input=data.getIntegersList();
                    sortingNaturally.sortLongNaturally(input,fileOut);
                    break;
                case "line":
                    data.gettingLinesInput(fileIn);
                    List<String> linesInput=data.getLinesList();
                    sortingNaturally.sortLineNaturally(linesInput,fileOut);
                    break;
                case "word":
                    data.gettingWordsInput(fileIn);
                    List<String> wordsInput=data.getWordsList();
                    sortingNaturally.sortWordNaturally(wordsInput, fileOut);
                    break;
                default:
                    System.out.println(datatype+" is not a valid parameter. It will be skipped.");
                    break;
            }
        }
    }
    }

