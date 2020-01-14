package utils;

import com.company.PlayCards.AssociationPlayCard;
import com.company.PlayCards.IPlayCard;
import com.company.PlayCards.MultipleChoicePlayCard;
import com.company.PlayCards.SingleAnswerPlayCard;

import java.util.ArrayList;
import java.util.HashMap;

public class TestQuestion {

    public static IPlayCard[] getFakeQuestions(){
        ArrayList<IPlayCard> arrayList = new ArrayList<>();

        String[] ans = {"one", "two", "three", "five"};
        String[] incorectAns = {"six", "seven", "eight"};
        SingleAnswerPlayCard question = new SingleAnswerPlayCard("How do you write 5?", "five", ans);
        arrayList.add(question);

        String[] bandsOptions = {"U2", "The Killers"};
        HashMap<String, Integer> associates = new HashMap<>();
        associates.put("Mr. Brightside", 1);
        associates.put("Human", 1);
        associates.put("With Or without You", 0);
        associates.put("Read My Mind", 1);
        associates.put("every breaking wave", 0);
        AssociationPlayCard question2 = new AssociationPlayCard(bandsOptions,associates);
        arrayList.add(question2);

        MultipleChoicePlayCard multipleChoice = new MultipleChoicePlayCard("choose all even number", new String[]{"1", "3"}, new String[]{"4", "2"});
        arrayList.add(multipleChoice);
        return arrayList.toArray(new IPlayCard[arrayList.size()]);
    }

}



