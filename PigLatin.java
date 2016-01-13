import java.util.Scanner;
import java.util.Arrays;

public class PigLatin
{
 public static void main(String[] args) 
 {
  System.out.println("Sentence to translate into Pig Latin: ");
  Scanner sc = new Scanner(System.in);
  String inputSentence = sc.nextLine();
  String outputSentence = "";

  int[] index = {1,2,3,4};

  System.out.println("Translated: ");
  for (int i=0; i<numberOfWords(inputSentence); i++)    // prints piglatinfied words at array poisition i of the tokenized sentence
  {
   System.out.print(pigLatinfy(tokenize(inputSentence)[i]) + " ");
  }

 }

 public static String[] tokenize(String sentenceString)
 {
  int slot=0;
  String[] sentenceArray = new String[numberOfWords(sentenceString)];    //makes an array with size numberOfWords
  
  for (int i=0; i<sentenceArray.length; i++)    //makes the slots of the arrays empty strings
  {
   sentenceArray[slot]="";
   slot++;
  }
  slot=0;
  
  for (int i=0;i<sentenceString.length();i++)     //adds characters to the slot's string, if there is a space it moves to the next slot
  {
   if (sentenceString.charAt(i) != ' ')
   {
    sentenceArray[slot] = sentenceArray[slot] + sentenceString.charAt(i);
   }
   else
   {
    slot++;
   }
  }
  return sentenceArray;
 }

 public static int numberOfWords(String sentenceString)
 {
  int numberOfWords=1;
  for (int i=0; i<sentenceString.length(); i++)    //determines the number of words by finding spaces
  {
   if (sentenceString.charAt(i) == ' ' )
   {
    numberOfWords += 1;
   }
  }
  return numberOfWords;
 }

 public static String detectPrefix(String word)
 {
  String prefix = "";

  for (int i = 0; i<word.length(); i++)     //detects the first vowel, and everything before that is added to the prefix string
  {
   if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
   {
    for (int j=0; j<i; j++)
    {
     prefix = prefix + word.charAt(j);
    }
    break;
   }
  }

  return prefix; 
 }

 public static String pigLatinfy(String word)
 {
  int startWordAt=0;
  String pigLatinWord = "";

  for (int i = 0; i<word.length(); i++)     //detects the first vowel as the place to start the string
  {
   if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
   {
    startWordAt=i;
    break;
   }
  }
  for  (int i=startWordAt; i<word.length(); i++)       //adds the letters after the prefix
  {
   pigLatinWord = pigLatinWord + word.charAt(i);
  }
  if (startWordAt==0)
  {
   pigLatinWord = pigLatinWord + detectPrefix(word) +"way";
  }
  else
  {
   pigLatinWord = pigLatinWord + detectPrefix(word) +"ay";
  }
  return pigLatinWord;
 }
}