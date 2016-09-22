package problem7.models;

public abstract class Person implements Buyer{

    private String name;
    private int age;
    private int food;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = 0;
    }


    public int getFood() {
        return this.food;
    }

    protected void setFood(int food) {
        this.food = food;
    }
}
