package homework7;

public class HomeWork7 {

    public static void main(String[] args) {
        Cat[] catArray = new Cat[8];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Murzik", 2);
        catArray[2] = new Cat("Bim", 4);
        catArray[3] = new Cat("Vaska", 7);
        catArray[4] = new Cat("Murka", 8);
        catArray[5] = new Cat("Matroskin", 10);
        catArray[6] = new Cat("Ponchik", 9);
        catArray[7] = new Cat("Bobik", 6);
        Plate plate = new Plate(50);
        plate.info();
        for (int i = 0; i < catArray.length; i++) {
            if (catArray[i].eat(plate) == false) plate.addFood(10);
            plate.info();
        }
    }

}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public boolean eat(Plate p) {
        if (appetite <= p.food) {
            p.decreaseFood(appetite);
            satiety = true;
        } else satiety = false;
        System.out.printf("%s satietition is %b\n", name, satiety);
        return satiety;
    }
}

class Plate {
    int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food >= n) food -= n;
        else food = 0;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood (int n) {
        food += n;
        System.out.printf("%n food added to plate\n", n);
    }
}

