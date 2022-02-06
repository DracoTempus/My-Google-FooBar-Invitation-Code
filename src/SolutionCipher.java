public class SolutionCipher {
    public static String solution(String x) {
        //work smarter not harder bros
        char[] characters = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            characters[i] = x.charAt(i);
        }
        System.out.println(x);
        StringBuilder returnString = new StringBuilder("");
        for(char character : characters){
            if(character > 96 && character < 123){
                int tmp = (int)character - ((((int)character - 110) * 2)+1);
                System.out.println(character + " " + (int)character + " " + tmp);
                returnString.append((char)tmp);
            }else{
                returnString.append(character);
            }
        }
        System.out.println(returnString.toString());
        return returnString.toString();
    }

    public static void main(String[] args){
        solution("abcdefghij!!!klmnopqrstuvwxyz");
    }
}
