package com.example.parenttree;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static Employee findCommonManager(Employee root, Employee employee1, Employee employee2) {
        if (root == null || employee1 == null || employee2 == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }

        if (root == employee1 || root == employee2) {
            return root;
        }

        List<Employee> commonManagers = new ArrayList<>();
        for (Employee subordinate : root.getSubordinates()) {
            Employee commonManager = findCommonManager(subordinate, employee1, employee2);
            if (commonManager != null) {
                commonManagers.add(commonManager);
            }
        }

        if (commonManagers.size() == 2) {
            return root;
        } else if (commonManagers.size() == 1) {
            return commonManagers.get(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Создание структуры с подчиненными
        Employee ceo = new Employee("CEO");
        Employee manager1 = new Employee("Manager 1");
        Employee manager2 = new Employee("Manager 2");
        Employee employee1 = new Employee("Employee 1");
        Employee employee2 = new Employee("Employee 2");
        Employee employee3 = new Employee("Employee 3");

        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        manager1.addSubordinate(employee1);
        manager1.addSubordinate(employee2);
        manager2.addSubordinate(employee3);

        // Поиск общего руководителя
        Employee commonManager = findCommonManager(ceo, employee1, employee3);
        if (commonManager != null) {
            System.out.println("Общий руководитель: " + commonManager.getName());
        } else {
            System.out.println("Общий руководитель не найден");
        }
    }
}