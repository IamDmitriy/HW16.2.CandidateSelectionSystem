package com.company;

import java.util.Scanner;
import java.util.TreeSet;
//TODO остановился на компараторе
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static TreeSet<Candidate> candidateTreeSet = new TreeSet<>(); //TODO Самая суть - замутить сюда компаратор

    public static void main(String[] args) {

        //introduceCandidates();

        addCandidatesExample();

        printCandidates(candidateTreeSet);
    }

    private static void printCandidates(TreeSet<Candidate> treeSet) {
        String tableFormat = "%-4s%-10s%-10s%-10s";
        System.out.println("Список кандидатов:");
        System.out.format(tableFormat, "№", "ФИО", "Релевантность резюме", "Оценка на собеседовании");

        int count = 1;
        for (Candidate candidate : candidateTreeSet) {
            System.out.format("%-4s%s", count, candidate);
            count++;
        }
    }

    private static void addCandidatesExample() {
        //TODO добавить ещё 7
        Candidate[] candidates = new Candidate[]{
                new Candidate("Иванов Иван Иванович", "муж", 55, 0, 0),
                new Candidate("Петров Пётр Иванович", "муж", 30, 5, 5),
                new Candidate("Смирнова Татьяна Николаевна", "жен", 40, 5, 0),
                new Candidate("Любимова Наталья Викторовна", "жен", 20, 0, 5),
        };

        for (Candidate candidate : candidates) {
            System.out.println(candidateTreeSet.add(candidate)); //TODO выдетает про компаратор - значит полюбому надо переопределить
        }
    }

    private static void introduceCandidates() {
        while (true) {
            System.out.println("Введите информацию о кандидате : \"Фамилия Имя Отчество, пол, возраст, " +
                    "релевантность резюме, оценка на собеседовании:\", для выхода введите пустую строку");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            Candidate curCandidate = parseCandidate(input);
            if (curCandidate == null) {
                continue;
            }

            candidateTreeSet.add(curCandidate);
        }
    }

    private static Candidate parseCandidate(String str) {
        String[] inputArray = str.split(",");
        if (inputArray.length != 5) {
            System.out.println("Введите данные в указанном формате!");
            return null;
        }

        String name = inputArray[0].trim();
        String sex = inputArray[1].trim();
        int age = obtainIntFromRange(inputArray[2], 0, 120);
        int relevance = obtainIntFromRange(inputArray[3], 0, 5);
        int rating = obtainIntFromRange(inputArray[4], 0, 5);

        Candidate curCandidate = new Candidate(name, sex, age, relevance, rating);

        return curCandidate;
    }

    static int obtainIntFromRange(String str, int start, int end) {
        Scanner scanner = new Scanner(System.in);
        int number;
        boolean rangeActive = start < end;

        while (true) {
            str = str.trim();

            if (isInteger(str)) {
                number = Integer.parseInt(str);

                if (rangeActive) {
                    if (!(number >= start && number <= end)) {
                        System.out.println("Введите число из диапазона: " + start + " - " + end);
                        str = scanner.nextLine();
                        continue;
                    }
                }

                break;
            } else {
                System.out.println("Введите число!");
                str = scanner.nextLine();
                continue;
            }
        }
        return number;
    }

    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}