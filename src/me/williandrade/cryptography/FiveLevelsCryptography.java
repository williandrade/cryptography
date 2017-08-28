package me.williandrade.cryptography;

import java.util.ArrayList;
import java.util.List;

public class FiveLevelsCryptography implements Cryptography {
	public final List<String> ascii = new ArrayList<>();
	private final List<Integer> fibonacci = new ArrayList<>();

	public FiveLevelsCryptography() {
		super();
		this.initAscii();
		this.initFibonacci();
	}

	@Override
	public String encript(String input, Integer key) throws Exception {
		char[] letters = input.toCharArray();
		Integer keyToUse = key;

		char[] toBeConverted = letters;
		char[] converting = new char[letters.length];

		for (int n = 0; n < 5; n++) {
			keyToUse = keyToUse + this.fibonacci.get(n);
			for (int i = 0; i < toBeConverted.length; i++) {
				char letter = toBeConverted[i];

				Integer index = indexOf(ascii, String.valueOf(letter));

				if (index == null) {
					throw new Exception("Não está no dicionário esse caractere " + letter);
				}

				Integer nextIndex = indexOffIncremental(ascii, index, keyToUse);

				converting[i] = ascii.get(nextIndex).toCharArray()[0];
			}
			// System.out.println(String.valueOf(converting));
			toBeConverted = converting;
		}

		return String.valueOf(converting);
	}

	@Override
	public String decript(String input, Integer key) throws Exception {
		char[] letters = input.toCharArray();
		Integer keyToUse = key;

		char[] toBeConverted = letters;
		char[] converting = new char[letters.length];

		for (int n = 0; n < 5; n++) {
			keyToUse = keyToUse + this.fibonacci.get(n);
			for (int i = 0; i < toBeConverted.length; i++) {
				char letter = toBeConverted[i];

				Integer index = indexOf(ascii, String.valueOf(letter));

				if (index == null) {
					throw new Exception("Não está no dicionário esse caractere " + letter);
				}

				Integer nextIndex = indexOffDecremental(ascii, index, keyToUse);

				converting[i] = ascii.get(nextIndex).toCharArray()[0];
			}
			// System.out.println(String.valueOf(converting));
			toBeConverted = converting;
		}

		return String.valueOf(converting);
	}

	private Integer indexOf(List<String> arr, String element) {
		Integer result = null;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(element)) {
				result = i;
			}
		}

		return result;
	}

	private Integer indexOffIncremental(final List<?> source, final int start, final int length) {
		int index = start;
		Integer result = null;
		for (int i = 0; i < length; i++) {
			result = index++;
			if (index == source.size()) {
				index = 0;
			}
		}
		return result;
	}

	private Integer indexOffDecremental(final List<?> source, final int start, final int length) {
		int index = start;
		Integer result = null;
		for (int i = 0; i < length; i++) {
			result = index--;
			if (index < 0) {
				index = source.size() - 1;
			}
		}
		return result;
	}

	private void initAscii() {
		for (int i = 33; i < 126; i++) {
			char temp = (char) i;
			this.ascii.add(Character.toString(temp));
		}
	}

	private void initFibonacci() {
		this.fibonacci.add(1);
		this.fibonacci.add(1);
		this.fibonacci.add(2);
		this.fibonacci.add(3);
		this.fibonacci.add(5);
	}

}