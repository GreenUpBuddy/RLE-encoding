
public class RLE {
    //compresses the list from a decompressed list.
    public static LinkedList encode(LinkedList list){
        LinkedList returnList;
        StringBuilder returnString = new StringBuilder();
        Node curr = list.head;
        int count = 0;
        char holder = 0;
        while(curr.next != null){
            if (curr.data == ' '){
                curr = curr.next;
            }
            if(curr.data == curr.next.data){
                count++;
            }else{
                holder = curr.data;
                count++;
                returnString.append(count).append(holder);
                count = 0;
            }
            curr = curr.next;
        }
        if (curr.next == null){
            holder = curr.data;
            returnString.append(count).append(holder);
        }
        returnList = Driver.listCreation(returnString.toString());
        return returnList;
    }
    //determines equality of two lists
    public boolean equals(LinkedList input1, LinkedList input2) {
        Node curr1 = input1.head.next;
        Node curr2 = input2.head.next;
        if (input1.size() != input2.size()){
            return false;
        }else{
            while(curr1.next != null){
                if (curr1 != curr2){
                    return false;
                }
            }
            return true;
        }
    }
    //decompresses a list
    public static LinkedList decode(LinkedList theInput){
        StringBuilder returnMe = new StringBuilder();
        LinkedList returnList;
        String str = theInput.toString();
        str = str.replaceAll("-", "").replaceAll(">", "")
                .replaceAll(" ", "");
        char [] input = str.toCharArray();
        for(int i = 0; i < input.length ; i++){
            if (Character.isDigit(input[i])){
                int iterations;
                iterations = Integer.parseInt(input[i] +"");
                for (int j = 0; j < iterations ; j++){
                    returnMe.append(input[i + 1]);
                }
                i ++;
            }
        }
        returnList = Driver.listCreation(returnMe.toString());
        return returnList;
    }
    //creates a list given a string used for creating a list from the file string.
    public static LinkedList listCreation(String input){
        LinkedList returnMe = new LinkedList();
        char[] list = input.toCharArray();
        for (char c : list) {
            returnMe.add(c);
        }
        returnMe.add(list[list.length -1]);
        return returnMe;
    }
}
