package de.telran.hw_15_20sept_map;

import java.sql.Array;
import java.util.*;

public class Task_1_Sities {
// 1) Есть Map, в котором храниться
// количество жителей по разным городам.
//•	Найдите город с самым большим количеством жителей.
//•	Найдите среднее количество жителей по всем городам.
//•	Найдите все города, у которых количество жителей одинаковое.

    public static void main(String[] args) {
        Map<String, Integer> mapSitis = new HashMap<>();
        mapSitis.put("Dresden", 540000);
        mapSitis.put("Hanover", 950000);
        mapSitis.put("Hamburg", 950000);
        mapSitis.put("Berlin", 3120500);
        mapSitis.put("Leipzig", 490000);
        mapSitis.put("Bremen", 490000);
        System.out.println();
        System.out.println(mapSitis);
        System.out.println();

        // Найдём город с макс количеством жителей и сразу среднее колич жителей по городам

        Integer maxS = 0; // переменная для хранения макс кол-ва жителей
        String maxCountP = null;  // переменная для хранения названия города с макс. кол-вом жителей
     Double averageQuantity=0.0; // переменная для хранения среднего значение жителей

        for (Map.Entry<String, Integer> entry : mapSitis.entrySet()) {
            if (entry.getValue() > maxS) {
                maxS = entry.getValue();
                averageQuantity=averageQuantity+ entry.getValue()/mapSitis.size();
                maxCountP = entry.getKey();
            }
        }

        System.out.println("Количество городов в нашей Мар:  "+ mapSitis.size());
        System.out.println("Город с максимальным количеством жителей:    " + maxCountP);
        System.out.println("Среднее количество жителей по городам в нашей Мар:   "+ averageQuantity);

        // 	Найдите все города, у которых количество жителей одинаковое.
        System.out.println();
        Map<Integer, List<String>> sameNumber = new HashMap<>(); // создадим вспомогат Мар в котоором при совпадении количества жителей из городов будет создаваться список

        for (Map.Entry<String, Integer> entry : mapSitis.entrySet()) {
            int numOfInhabitans = entry.getValue();
            String stadt = entry.getKey();
//            В цикле по каждому городу проверяется, существует ли уже запись в карте с таким количеством жителей:
//            Если такой записи нет, создается новый список для этого числа жителей.
//            Затем город добавляется в соответствующий список.

            if (!sameNumber.containsKey(numOfInhabitans)) {
                sameNumber.put(numOfInhabitans, new ArrayList<>());
            }
            sameNumber.get(numOfInhabitans).add(stadt);
        }

        for (Map.Entry<Integer, List<String>> entry : sameNumber.entrySet()) {
            if (entry.getValue().size() > 1) {  // если в списке больше одного элемента , то печатаем
                System.out.println("Города с населением  " + entry.getKey() + " жителей : " + entry.getValue());
            }
        }


    }
}
