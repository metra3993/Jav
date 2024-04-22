package org.example;

import java.util.Scanner;

public class Main {
    public static class PrisonUtils {
        private static int numberOfPrisoners = 0;
        private static SecurityLevel securityLevel = SecurityLevel.MEDIUM; // По умолчанию - средний уровень безопасности

        // Функция для добавления нового заключенного
        public static void addPrisoner() {
            numberOfPrisoners++;
            System.out.println("Заключенный добавлен. Текущее количество заключенных: " + numberOfPrisoners);
        }

        // Функция для добавления нескольких заключенных за один раз
        public static void addMultiplePrisoners(int count) {
            numberOfPrisoners += count;
            System.out.println(count + " заключенных добавлено. Текущее количество заключенных: " + numberOfPrisoners);
        }

        // Функция для освобождения заключенного
        public static void releasePrisoner() {
            if (numberOfPrisoners > 0) {
                numberOfPrisoners--;
                System.out.println("Заключенный освобожден. Текущее количество заключенных: " + numberOfPrisoners);
            } else {
                System.out.println("Нет заключенных для освобождения.");
            }
        }

        // Функция для освобождения всех заключенных
        public static void releaseAllPrisoners() {
            numberOfPrisoners = 0;
            System.out.println("Все заключенные освобождены.");
        }

        // Метод для изменения уровня безопасности тюрьмы
        public static void changeSecurityLevel(SecurityLevel level) {
            securityLevel = level;
            System.out.println("Уровень безопасности изменен на: " + securityLevel);
        }

        // Функция для отображения текущего количества заключенных
        public static void displayNumberOfPrisoners() {
            System.out.println("Текущее количество заключенных: " + numberOfPrisoners);
        }

        // Функция для отображения текущего уровня безопасности
        public static void displaySecurityLevel() {
            System.out.println("Текущий уровень безопасности: " + securityLevel);
        }

        // Функция для отображения общего состояния тюрьмы
        public static void displayPrisonState() {
            displayNumberOfPrisoners();
            displaySecurityLevel();
        }

        // Метод main для демонстрации работы функций
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить заключенного");
                System.out.println("2. Добавить несколько заключенных");
                System.out.println("3. Освободить заключенного");
                System.out.println("4. Освободить всех заключенных");
                System.out.println("5. Изменить уровень безопасности");
                System.out.println("6. Показать текущее количество заключенных");
                System.out.println("7. Показать текущий уровень безопасности");
                System.out.println("8. Показать общее состояние тюрьмы");
                System.out.println("9. Выйти");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addPrisoner();
                        break;
                    case 2:
                        System.out.println("Сколько заключенных вы хотите добавить?");
                        int count = scanner.nextInt();
                        addMultiplePrisoners(count);
                        break;
                    case 3:
                        releasePrisoner();
                        break;
                    case 4:
                        releaseAllPrisoners();
                        break;
                    case 5:
                        System.out.println("Выберите новый уровень безопасности (LOW, MEDIUM, HIGH):");
                        String securityInput = scanner.next();
                        SecurityLevel newLevel = SecurityLevel.valueOf(securityInput.toUpperCase());
                        changeSecurityLevel(newLevel);
                        break;
                    case 6:
                        displayNumberOfPrisoners();
                        break;
                    case 7:
                        displaySecurityLevel();
                        break;
                    case 8:
                        displayPrisonState();
                        break;
                    case 9:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 9.");
                        break;
                }
            }

            scanner.close();
        }
    }

    public enum SecurityLevel {
        LOW,
        MEDIUM,
        HIGH
    }
}
