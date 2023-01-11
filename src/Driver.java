import java.io.*;
import java.util.Scanner;

/*
    JD Sawyer
    TCSS 342 B
    Programming Assignment 1
 */
public class Driver extends RLE{
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new FileOutputStream("encoded.txt", false));
        PrintStream stream2 = new PrintStream(new FileOutputStream("decoded.txt", false));
        PrintStream stream3 = new PrintStream(new FileOutputStream("equals.txt", false));
        Scanner input;
        String equals1;
        String equals2;
        LinkedList in1;
        LinkedList in2;
        String temp;
        String addMe;
        LinkedList decoded;
        LinkedList tempList;
        try {
            input = new Scanner(new File("src/encoding.txt"));
            while (input.hasNextLine()) {
                temp = input.nextLine();
                tempList = listCreation(temp);
                tempList = encode(tempList);
                System.out.println(tempList);
                addMe = tempList.toString();
                addMe = addMe.replaceAll("-", "").replaceAll(">", "")
                        .replaceAll(" ", "");
                System.out.println(addMe);
                stream.append(addMe).append("\n");
            }
            stream.close();
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file encoding.txt does not exist");
        }
        try {
            input = new Scanner(new File("src/decode.txt"));
            while (input.hasNextLine()) {
                temp = input.nextLine();
                decoded = listCreation(temp);
                decoded = decode(decoded);
                addMe = decoded.toString();
                addMe = addMe.replaceAll("-", "").replaceAll(">", "")
                        .replaceAll(" ", "");
                stream2.append(addMe).append("\n");
            }
            stream.close();
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file decode.txt does not exist");
        }
        try {
            input = new Scanner(new File("src/equality.txt"));
            while (input.hasNext()) {
                equals1 = input.next();
                in1 = listCreation(equals1);
                if(input.hasNext()){
                    equals2 = input.next();
                    in2 = listCreation(equals2);
                    stream3.append(equals1).append(" ").append(equals2).append(" are equal: ");
                    if (in1.equals(in2)){
                        stream3.append("True.").append("\n");
                    }else{
                        stream3.append("False.").append("\n");
                    }
                }
            }
            stream.close();
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file equality.txt does not exist");
        }
    }
}