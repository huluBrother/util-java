package org.generic;

import org.generic.wild.Fruit;

import java.util.Arrays;
import java.util.List;

class Animal{}

class Human extends Animal{}

class Program extends Human{}

class Engineer extends Human{}

class Cat extends Animal{}

class Dog extends Animal{}

public class ExtendsWild {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Human human = new Human();
        Program program =new Program();
        Engineer engineer = new Engineer();
        Cat cat = new Cat();
        Dog dog = new Dog();

        // Declare variable is Ok
        List<? extends Animal> list = Arrays.asList(animal,human,program,engineer,cat,dog);
        for(Object obj : list){
            System.out.println(obj.getClass().getName());
        }
        //list.add(new Animal());// Error
    }
}
