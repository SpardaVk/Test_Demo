import com.sun.tools.javac.comp.Resolve;

import java.util.Scanner;

public class MainClass {

    public MainClass() {

    }

    public static void main(String[] args) {

        int[ ] primes = {2, 3, 5, 7};

        for (int a: primes) {
            System.out.println(a);
        }


        Scanner in = new Scanner(System.in);
        System.out.println("What is your name ");
        String name = in.nextLine();
        System.out.println("Hello my friend " + name + " How your old?  ");
        int bit = in.nextInt();

        String menTwo;
        String menOne;


        if (bit < 15) {
            System.out.println("Ты сильно маленький");
        } else if (bit > 20) {
            System.out.println("Ты сильно старый");
        }
        System.out.println("Давай я умножу число, называй дядя:) : ");
        int number = in.nextInt();
        System.out.println("На сколько умнажаем: ");
        int numberTwo = in.nextInt();
        System.out.println("Вышло примерно "+number*numberTwo +" но ты учти у меня по матем так то 7 было");



    }

    }


