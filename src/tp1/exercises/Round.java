package tp1.exercises;

import java.util.ArrayList;
import java.util.List;

public class Round {
	private static List<Character> round;
	public Round() {
		round = new ArrayList<Character>();
		
	}
	
	public Round(Round smallerPermutated) {
		round = new ArrayList<Character>();
		for (int i = 0; i < smallerPermutated.size(); i++) {
			round.add(smallerPermutated.get(i));
		}
	}

	public void add(Character exp) {
		round.add(exp);
	}
	
	public int distance(Character exp1, Character exp2){
		int posExp1 = 0;
		int posExp2 = 0;
		
		for (int i = 0; i < round.size(); i++) {
			if (round.get(i) == exp1){
				posExp1 = i;
			}
			if (round.get(i) == exp2){
				posExp1 = i;
			}
		}
		
		return (Math.abs(posExp2-posExp1))% round.size();
	}
	public int size() {
		return round.size();
	}
	public Character get(int index) {
		return round.get(index);
	}
	public Character remove(int i) {
		return round.remove(i);
	}

	public void add(int index, Character firstElement) {
		round.add(index,firstElement);
		
	}
}
