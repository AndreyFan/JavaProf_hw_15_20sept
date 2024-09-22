package de.telran.hw_15_20sept_map;

public class Cat {
    public String name;
    public int age;
    public double weight;
    public String catBreed;

    public Cat(String name, int age, double weight, String catBreed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.catBreed = catBreed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", catBreed='" + catBreed + '\'' +
                '}';
    }
}
