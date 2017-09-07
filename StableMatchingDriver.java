import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class StableMatchingDriver {
    public static void main(String[] args){
        String alexander = "Alexander";
        String john = "John";
        String angelica = "Angelica";
        String eliza = "Eliza";
        ArrayList<String> singleLadies = new ArrayList<>();
        singleLadies.add(angelica);
        singleLadies.add(eliza);
        Stack<String> aStack = new Stack<>();
        aStack.push(john);
        aStack.push(alexander);
        Stack<String> eStack = new Stack<>();
        eStack.push(alexander);
        eStack.push(john);
        HashMap<String, Stack<String>> femalePreferences = new HashMap<String, Stack<String>>();
        femalePreferences.put(angelica, aStack);
        femalePreferences.put(eliza, eStack);
        HashMap<String, Integer> aPreferences = new HashMap<>();
        aPreferences.put(angelica, 1);
        aPreferences.put(eliza, 2);
        HashMap<String, Integer> jPreferences = new HashMap<>();
        jPreferences.put(eliza, 1);
        jPreferences.put(angelica, 2);
        HashMap<String, HashMap<String, Integer>> malePreferences = new HashMap<String, HashMap<String, Integer>>();
        malePreferences.put(alexander, aPreferences);
        malePreferences.put(john, jPreferences);
        Matchmaker matchmaker = new Matchmaker(singleLadies, femalePreferences, malePreferences);
        matchmaker.makeMatches();
        matchmaker.printMatches();
    }
}
