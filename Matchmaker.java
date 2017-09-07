import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Matchmaker {
    private HashMap<String, String> matches; /*males are keys, females are values*/
    private HashMap<String, Stack<String>> femalePreferences;
    private HashMap<String, HashMap<String, Integer>> malePreferences;
    private ArrayList<String> singleLadies;

    public Matchmaker(ArrayList<String> SLs, HashMap<String, Stack<String>> FPs,
                      HashMap<String, HashMap<String, Integer>> MPs){
        this.matches = new HashMap<String, String>();
        this.singleLadies = SLs;
        this.femalePreferences = FPs;
        this.malePreferences = MPs;
    }
    public void makeMatches(){
        boolean done = false;
        while(!done) {
            done = true;
            for (int i = 0; i < this.singleLadies.size(); i++) {
                if(!this.matches.containsValue(this.singleLadies.get(i))) {
                    done = false;
                    Stack<String> currentFemalePreferences = this.femalePreferences.get(this.singleLadies.get(i));
                    String currentPreferredMale = currentFemalePreferences.pop();
                    if (!this.matches.containsKey(currentPreferredMale)) {
                        this.matches.put(currentPreferredMale, this.singleLadies.get(i));
                    } else {
                        String currentMatch = this.matches.get(currentPreferredMale);
                        HashMap<String, Integer> currentMalePreferences = this.malePreferences.
                                get(currentPreferredMale);
                        if(currentMalePreferences.get(this.singleLadies.get(i)) < currentMalePreferences.
                                get(currentMatch)){
                            this.matches.remove(currentPreferredMale);
                            this.matches.put(currentPreferredMale, this.singleLadies.get(i));
                        }
                    }
                }
            }
        }
    }
    public void printMatches(){
        for(String male : this.matches.keySet()){
            System.out.println(male + " and " + this.matches.get(male));
        }
    }
}
