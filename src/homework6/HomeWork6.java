package homework6;

public class HomeWork6 {
    public static void main(String[] args) {
        Animal[] animalArray = new Animal[100];
        animalArray[0] = new Cat("Барсик");
        animalArray[1] = new Dog("Жучка");
        animalArray[2] = new Cat("Мурзик");
        animalArray[3] = new Dog("Тузик");
        animalArray[4] = new Cat("Палтус");
        animalArray[5] = new Dog("Мухтар");

        animalArray[0].run(50);
        animalArray[1].run(60);
        animalArray[2].swim(100);
        animalArray[3].swim(200);
        animalArray[4].run(50);
        animalArray[5].run(60);
        animalArray[0].swim(100);
        animalArray[1].swim(5);
        animalArray[2].run(100);
        animalArray[3].run(200);
        animalArray[4].swim(50);
        animalArray[5].swim(60);

        System.out.printf("\nКошек: %d\nСобак %d\nВсего животных: %d\n", animalCounter(animalArray)[0], animalCounter(animalArray)[1], animalCounter(animalArray)[0] + animalCounter(animalArray)[1] );
    }

    static int[] animalCounter (Animal[] animalArray) {
        int[] counter = {0, 0};
        for (int i = 0; i < animalArray.length; i++) {
            if (animalArray[i] instanceof Cat) counter[0]++;
            else if (animalArray[i] instanceof Dog) counter[1]++;
        }
        return counter;
    }
}

abstract class Animal {
    String name;
    int maxLength;
    int maxSwim;

    Animal(String name) {
       this.name = name;
    }

    void run(int length) {
        System.out.printf("%s пробежал %d метров.\n", name, length);
    }

    abstract void swim(int length);
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
        this.maxLength = 500;
        this.maxSwim = 10;
    }

    @Override
    void run(int length) {
        if (length < maxLength) {
            super.run(length);
        } else super.run(maxLength);

    }

    @Override
    void swim(int length) {
        if (length < maxSwim) {
            System.out.printf("%s проплыл %d метров.\n", name, length);
        } else System.out.printf("%s проплыл только %d метров.\n", name, maxSwim);
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
        this.maxLength = 200;
        this.maxSwim = 0;
    }

    @Override
    void run(int length) {
        if (length < maxLength) {
            super.run(length);
        } else super.run(maxLength);

    }

    @Override
    void swim(int length) {
        System.out.printf("%s не умеет плавать.\n", name);
    }
}
