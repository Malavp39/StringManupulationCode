package com.challenge;

public class StringManipulator {
	
	private static String alphabetics = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String cleanString(String str){
		char[] c = str.toCharArray();
		char[] finalChar = new char[str.length()];
		int a = 0;
		for(int i = 0; i < c.length ; i++){
			if(alphabetics.indexOf(c[i]) != -1){
				finalChar[a] = c[i];
				a++;
			}
		}
		return String.valueOf(finalChar).toUpperCase();
	}
	
	public boolean isPalindrome(String word){
		String cleanWord = cleanString(word);
		char[] c = cleanWord.trim().toCharArray();
		for(int i = 0; i < c.length/2;i++){
			if(c[i] != c[c.length-1- i])
				return false;
		}
		return true;
	}
	
	public String[] sortStrings(String[] words){		
		return quickSort(words, 0, words.length -1);
	}
	private static String[] quickSort(String[] array,int start, int end){
        int pivotPoint;

        if(start < end){
            pivotPoint = partition(array, start, end);

            quickSort(array, start, pivotPoint -1);

            quickSort(array, pivotPoint + 1, end);
        }
		return array;
    }
	
	private static int partition(String[] array, int start, int end){
        String pivot;
        int endOfLeftList;
        int mid = (start + end)/2;

        swap(array, start, mid);

        pivot = array[start];

        endOfLeftList = start;

        for(int i = start + 1; i <= end; i++){
            if(  array[i].compareTo(pivot) < array[start].compareTo(pivot)){
                endOfLeftList++;
                swap(array, endOfLeftList,i);
            }
        }

        swap(array, start, endOfLeftList);

        return endOfLeftList;
    }

    private static void swap(String[] array, int a, int b){
        String temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
