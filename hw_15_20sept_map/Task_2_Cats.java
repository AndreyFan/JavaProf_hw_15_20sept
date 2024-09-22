package de.telran.hw_15_20sept_map;

import java.util.Map;
import java.util.TreeMap;

public class Task_2_Cats {
    //   2) У вас есть приют для животных, в которых живут коты.
//    Есть объект Cat с данными: имя, возраст, вес, порода.
//    создайте Map, ключем которого будет имя, а значением объект Cat.
//    информация о котах должна храниться в упорядоченном виде по имени.
//    выведите имена котов, порода которых равна N (на ваше усмотрение).
//    выведите список всех котов, вес которых больше значения М (на ваше усмотрение).
//      * найдите кота с самым большим весом и возрастом одновременно.
    public static void main(String[] args) {
        Cat cat1 = new Cat("tom", 6, 5.5, "pers");
        Cat cat2 = new Cat("bars", 1, 3.5, "fold");
        Cat cat3 = new Cat("bagira", 2, 2.0, "singapura");
        Cat cat4 = new Cat("pantera", 4, 2.8, "fold");
        Cat cat5 = new Cat("mursik", 5, 5.5, "siamese");
        Cat cat6 = new Cat("murka", 7, 3.5, "shorthair");
        Map<String, Cat> catMap = new TreeMap<>(String::compareTo);
        catMap.put("tom", cat1);
        catMap.put("bars", cat2);
        catMap.put("bagira", cat3);
        catMap.put("pantera", cat4);
        catMap.put("mursik", cat5);
        catMap.put("murka", cat6);
        System.out.println();
        System.out.println("убедимся что Мар отфильтрован по алфавиту по имени :");
        System.out.println(catMap.keySet()); // убедимся что Мар отфильтрован по алфавиту по имени
        System.out.println();
        //    выведем имена котов, порода которых "singapura".
        System.out.print("выведем имена котов, порода которых <singapura>: ");
        for (Map.Entry<String, Cat> entry : catMap.entrySet()) {
            if (entry.getValue().catBreed == "singapura") System.out.println(entry.getKey());
        }

        //выведем список всех котов, вес которых больше 3 кг:
        System.out.println();
        System.out.print("выведем список всех котов, вес которых больше 3 кг: ");
        for (Map.Entry<String, Cat> entry : catMap.entrySet()) {
            if (entry.getValue().weight > 3) System.out.print(" " + entry.getKey() + " ,");
        }
        System.out.println();
        //     * найдём кота с самым большим весом и возрастом одновременно

        double nW = 0;   // создадим переменную для хранения наибольшего значения веса
        Cat fC = new Cat("", 0, 0, ""); // создадим переменную для хранения искомого объекта

        System.out.println();
        for (Cat curCat : catMap.values()) { // воспользуемся списком значений и пройдём по нему циклом
            if (curCat.weight >= nW) {  // найдём объект с наибольшим возрастом
                nW = curCat.weight;
                fC = curCat;
            }
        }

        for (Cat curCat : catMap.values()) {
            if (curCat.weight == fC.weight) {
                if (curCat.age > fC.age) {  // дополнительно отселектируем котов с максимальной по возрасту
                    fC = curCat;
                }
            }
        }

        System.out.println("кот/кошка с самым большим весом и возрастом одновременно:  " + fC);

    }
}
