package StringsNThings;

public class StringsAndThings {

    public static void main(String[] args) {

        //Q1
        String string1 = "fez day";
        String string2 = "day fez";
        String string3 = "day fyyyz";

        System.out.println("\nQ1:");
        System.out.println("Number of words ending with 'y' or 'z' in '" + string1 + "': " + countYZ(string1));
        System.out.println("Number of words ending with 'y' or 'z' in '" + string2 + "': " + countYZ(string2));
        System.out.println("Number of words ending with 'y' or 'z' in '" + string3 + "': " + countYZ(string3));
        System.out.println("========================================================================");

        //Q2
        String baseString = "Hello there";
        String stringToRemove1 = "llo";
        String stringToRemove2 = "e";
        String stringToRemove3 = "x";
        String result1 = removeString(baseString, stringToRemove1);
        String result2 = removeString(baseString, stringToRemove2);
        String result3 = removeString(baseString, stringToRemove3);

        System.out.println("\nQ2:");
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("========================================================================");

        //Q3
        String input1 = "This is not"; // Should return false
        String input2 = "This is notnot"; // Should return true
        String input3 = "noisxxnotyynotxisi"; // Should return true

        System.out.println("\nQ3:");
        System.out.println("Input 1: " + containsEqualNumberOfIsAndNot(input1));
        System.out.println("Input 2: " + containsEqualNumberOfIsAndNot(input2));
        System.out.println("Input 3: " + containsEqualNumberOfIsAndNot(input3));
        System.out.println("========================================================================");

        //Q4
        String string4 = "xxggxx";
        String string5 = "xxgxx";
        String string6 = "xxggyygxx";

        System.out.println("\nQ4:");
        System.out.println("g is happy Test 1: " + gIsHappy(string4));
        System.out.println("g is happy Test 2: " + gIsHappy(string5));
        System.out.println("g is happy Test 3: " + gIsHappy(string6));
        System.out.println("========================================================================");

        //Q5
        System.out.println("\nQ5:");
        System.out.println(countTriple("abcXXXabc"));   //Should return 1
        System.out.println(countTriple("xxxabyyyycd")); //Should return 3
        System.out.println(countTriple("a"));           //Should return 0
    }





    /*
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */

    //Q1
    public static int countYZ(String input){
        int i = 0;
        String[] words = input.split("[^a-z]+");
        for (String word : words) {
            if (word.toLowerCase().endsWith("y") || word.toLowerCase().endsWith("z")) {
                i++;
            }
        }
        return i;
    }

    /*
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */

    //Q2
    public static String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }


    /*
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    //Q3
    public static boolean containsEqualNumberOfIsAndNot(String input){
        int isCount = 0;
        int notCount = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.startsWith("is", i)) {
                isCount++;
            } else if (input.startsWith("not", i)) {
                notCount++;
            }
        }
        return isCount == notCount;
    }

    /*
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */

    //Q4
    public static boolean gIsHappy(String input) {


        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == 'g') {
                if ((i > 0 && input.charAt(i - 1) != 'g') && (i < input.length() - 1 && input.charAt(i + 1) != 'g')) {
                    return false;
                }
            }
        }
        return true;
    }


    /*
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */

    //Q5
    public static int countTriple(String input){

        int count = 0;

        for (int i = 0; i < input.length() - 2; i++) {                                          //We'll stop looping when we have fewer than 3 characters left in the string.
            char currentChar = input.charAt(i);                                                 //Looking at the character at position 'i' in the string and storing it in a variable named currentChar.
            if (currentChar == input.charAt(i + 1) && currentChar == input.charAt(i + 2)) {     //Checking if the current character is the same as the next two characters. If all three characters are the same, we have found a triple.
            count++;
            }
        }
        return count;
    }


}//Class
