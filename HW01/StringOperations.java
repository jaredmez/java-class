/*
    a) Create a new `String` object and assign it your name. Print it out.
    b) Pick the first letter in your name, and replace it with 'A'. Then, replace the last letter in your name with 'Z'. 
       Print out the result. Recall that, in Java, strings are *immutable*, meaning you cannot change a String in-place. 
       Do NOT just hard-code a new String with the first and last letters changed.
    c) Lastly, let's work with some URLs. Declare a new `String` and give it the value of some web address, in the 
       form `www.name.tld`, such as `www.gatech.edu` or `www.stackoverflow.com`. Print out this address.
    d) This last operation could be a little tricky. Create a substring of the variable that's just the "name" section, 
       and concatenate the integer "1331" to the end. For example, `www.gatech.edu` would become gatech1331. Print out this 
       final result. **Note**: the String class has a `.length()` method which you'll likely find useful here but is not necessary.
*/

public class StringOperations {

    //TODO: Start your code after this line
    public static void main(String[] args) {
        String myName = new String("Jared");
        System.out.println(myName);

        String modifiedName = myName.replace('J', 'A');
        String modifiedName2 = modifiedName.replace('d', 'Z');
        System.out.println(modifiedName2);

        String url = new String("https://www.facebook.com");
        System.out.println(url);

        int begin = url.indexOf('.');
        String subUrl = url.substring(begin + 1, 20);
        System.out.println(subUrl + 1331);
    }
}
