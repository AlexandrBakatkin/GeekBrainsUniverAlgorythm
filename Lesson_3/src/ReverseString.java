import stack.StackImpl;

public class ReverseString {

    private String originalStr;

    public ReverseString(String string){
        this.originalStr = string;
    }

    public String reverse(){

        StackImpl <Character> characterStack = new StackImpl<>(originalStr.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < originalStr.length(); i++) {
            characterStack.push(originalStr.charAt(i));
        }

        while (!characterStack.isEmpty()){
            sb.append(characterStack.pop());
        }

        return sb.toString();
    }
}