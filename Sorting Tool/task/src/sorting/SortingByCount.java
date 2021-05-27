package sorting;

import java.util.*;

public class SortingByCount {
static Data data= new Data();

    void sortWord(List<String> wordsInput, String fileOut) {
        SortedMap<String, Integer> map ;
        Collections.sort(wordsInput);
        if(wordsInput.size()==1)
            return;
        map= generalSortForStrings(wordsInput);

        SortedSet<Map.Entry<String, Integer>> sortedEntries = entriesSortedByValues(map);
        if(fileOut.equals("noFile")) {
            System.out.println("Total number: " + wordsInput.size());
            sortedEntries.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + (int) (100 * ((double) entry.getValue()) / wordsInput.size()) + "%"));
        } else {
            StringBuilder text=new StringBuilder();
            text.append("\\nTotal number ").append(wordsInput.size()).append("\\n");
            sortedEntries.forEach(entry -> text.append(entry.getKey()).append(" ").append(entry.getValue()).append(" time(s), ").append((int) (100 * ((double) entry.getValue()) / wordsInput.size())).append("%\\n"));
            data.writingFile(fileOut,text.toString());
        }
    }

    static <K> SortedMap<K, Integer> generalSortForStrings(List<String> wordsInput) {
        SortedMap<K, Integer> map = new TreeMap<>();
        Collections.sort(wordsInput);

        int count = 1;
        for (int i = 0; i < wordsInput.size(); i++) {
            K value = (K) wordsInput.get(i);
            if (i == wordsInput.size() - 1) {
                if (!wordsInput.get(i).equals(wordsInput.get(i - 1))) {
                    map.put(value, 1);
                    break;
                } else if (wordsInput.get(i - 1).equals(wordsInput.get(i))) {
                    count++;
                    map.put(value, count);
                    break;
                }
            }
            if (!wordsInput.get(i + 1).equals(wordsInput.get(i))) {
                map.put(value, count);
                count = 1;
            } else if (wordsInput.get(i + 1).equals(wordsInput.get(i))) {
                count++;
            }
        }
        return map;
    }

    void sortLine(List<String> linesInput, String fileOut) {
        SortedMap<String,Integer> map;
        Collections.sort(linesInput);
        if(linesInput.size()==1)
            return;

        map= generalSortForStrings(linesInput);

        SortedSet<Map.Entry<String,Integer>> sortedEntries=  entriesSortedByValues(map);
        if (fileOut.equals("noFile")) {
            System.out.println("Total lines: "+linesInput.size());
            sortedEntries.forEach(entry -> System.out.println(entry.getKey()+": "+ entry.getValue()+ " time(s), "+ (int)(100*((double)entry.getValue())/linesInput.size()) +"%"));
        } else{
            StringBuilder text = new StringBuilder();
            text.append("Total lines: ").append(linesInput.size()).append("\n");
            sortedEntries.forEach(entry -> text.append(entry.getKey()).append(": ").append(entry.getValue()).append(" time(s), ").append((int) (100 * ((double) entry.getValue()) / linesInput.size())).append("%\n"));
            data.writingFile(fileOut,text.toString());
        }
    }

     void sortLong(List<Integer> longsInput, String fileOut) {
        SortedMap<Integer,Integer> map=new TreeMap<>();
        Collections.sort(longsInput);
         if(longsInput.size()==1)
             return;

        int count=1;
        for(int i=0;i<longsInput.size();i++){
            int value=longsInput.get(i);
            if(i==longsInput.size()-1){
                if(!longsInput.get(i).equals(longsInput.get(i-1))){
                    map.put(value, 1);
                    break;
                }
                else if (longsInput.get(i+1).equals(longsInput.get(i))){
                    count++;
                    map.put(value, count);
                    break;
                }
            }
            if(!longsInput.get(i+1).equals(longsInput.get(i))){
                map.put(value, count);
                count=1;
            }
            else if (longsInput.get(i+1).equals(longsInput.get(i))){
                count++;
            }
        }

        SortedSet<Map.Entry<Integer,Integer>> sortedEntries=  entriesSortedByValues(map);
        if (fileOut.equals("noFile")) {
            System.out.println("Total lines: " + longsInput.size());
            sortedEntries.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + (int) (100 * ((double) entry.getValue()) / longsInput.size()) + "%"));
        } else {
            StringBuilder text = new StringBuilder();
            text.append("Total lines: ").append(longsInput.size()).append("\n");
            sortedEntries.forEach(entry -> text.append(entry.getKey()).append(": ").append(entry.getValue()).append(" time(s), ").append((int) (100 * ((double) entry.getValue()) / longsInput.size())).append("%\n"));
            data.writingFile(fileOut,text.toString());
        }
    }

     <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
