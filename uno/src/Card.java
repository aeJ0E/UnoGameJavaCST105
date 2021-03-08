

public class Card {

	private String color;
	private int value;
	private String effect;

	public Card(String color, int value, String effect) {
		this.color = color;
		this.value = value;
		this.effect = effect;
	}

	public String toString() {
		if(value < 0) {
			if(value == -1) {
				return color; 
			}
			if(value == -2) {
				return color + " +4";
			}
			if(value == -3) {
				return color + " skip";
			}
			if(value == -4) {
				return color + " reverse";
			}
			if(value == -5) {
				return color + " +2";
			}
		}
		return color + " " + value + " " + effect;
	}
}
