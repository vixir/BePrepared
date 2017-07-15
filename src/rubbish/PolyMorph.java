package rubbish;

public class PolyMorph {

	public static void main(String[] args) {
		Animal d = new Dawg();
		Animal a = new Animal();
		Donkey dy = new Donkey();
		noise(d);
		noise(a);
		noise(dy);
	}

	public static void noise(Animal animal) {
		animal.makeNoise();
	}
}

class Animal {
	public Animal() {
		System.out.println("Animal Constructor");
	}

	public void makeNoise() {
		System.out.println("talk");
	}
}

class Donkey extends Animal {
	public Donkey() {
		System.out.println("Donkey Doo Constructor.");
	}

	public void makeNoise() {
		System.out.println("bray!! bray!! bray!!");
	}
}

class Dawg extends Animal {
	public  Dawg() {
		System.out.println("Some rappers are stupid.");
	}

	public void makeNoise() {
		System.out.println(".K. .O. .O. .L.!! smoke!! weed!!");
	}
}