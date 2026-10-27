import warehouse.*;
import warehouse.factory.*;
import warehouse.valueProject.Price;

import java.util.ArrayList;

public class Main {
    public static void printWarehouse(Warehouse warehouse, String title) {
        System.out.println("_________" + title + "_________");
        for (Product product : warehouse) {
            System.out.println(product);
        }
    }
    public static void printList(ArrayList<Product> list, String title) {
        if (list.isEmpty()) {
            System.out.println("Nothing found");
            return;
        }
        System.out.println(title);
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        System.out.println("********    Сценарий 1    ********\n");

        Warehouse warehouse = new Warehouse(250);
        Warehouse warehouseMove = new Warehouse(250);
        Warehouse warehouseCopy;

        Product smartphone = new SmartphoneFactory().creatProduct("iphone", 1000, 5, 180);
        warehouse.addProduct(smartphone);

        Product laptop = new LaptopFactory().creatProduct("lenovo", 1300, 7, 2600);
        warehouse.addProduct(laptop);

        Product tShirt = new TShirtFactory().creatProduct("nike", 100, 15, 380);
        warehouse.addProduct(tShirt);

        printWarehouse(warehouse, "Список товаров на складе");
        System.out.println();

        System.out.println("********    Сценарий 2    ********\n");

        warehouseCopy = new Warehouse(warehouse);

        warehouseCopy.findById(1).setPrice(new Price(1500));
        warehouseCopy.findById(2).changeQuantity(10);

        printWarehouse(warehouse, "Оригинальный склад");
        System.out.println();
        printWarehouse(warehouseCopy, "Скопированный и измененный склад");
        System.out.println();

        System.out.println("********    Сценарий 3    ********\n");

        Product firstProduct = warehouseCopy.findById(1);
        warehouseMove.transferFrom(warehouseCopy);
        printWarehouse(warehouseCopy, "Скопированный и измененный склад");
        System.out.println();
        printWarehouse(warehouseMove, "Склад, в который переместили");
        System.out.println();
        System.out.println("Тот же первый объект, не копия: " + (warehouseMove.findById(1) == firstProduct));
        System.out.println();

        System.out.println("********    Сценарий 4    ********\n");

        System.out.println("Поиск товара по ID = 1:\n" + warehouse.findById(1));
        System.out.println();
        printList( warehouse.findByCategory("Electronics"), "Поиск товаров по category = Electronics: ");
        System.out.println();
        printList( warehouse.findByPrice(1000), "Поиск товара по price = 1000$: ");

        System.out.println();
        printWarehouse(warehouse, "склад до удалений");
        warehouse.removeById(2);
        System.out.println();
        printWarehouse(warehouse,"склад, после удаления товара с ID = 2");

        System.out.println();
        warehouse.removeByIndex(0);
        printWarehouse(warehouse, "Склад, после удаление товара с index = 0");
        System.out.println();
        System.out.println("Попытка удалить не существующий ID товара на складе");
        try {
            warehouse.removeById(999);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка удаления: " + e.getMessage());
        }
        System.out.println();

        System.out.println("********    Сценарий 5    ********\n");

        Product jacket = new JacketFactory().creatProduct("adidas", 50, 10, 600);
        Product milk = new MilkFactory().creatProduct("milky", 50, 10, 600);
        warehouse.addProduct(jacket);
        warehouse.addProduct(milk);

        printWarehouse(warehouse, "До перемещения milk milky");
        milk.transferTo(warehouseMove);

        System.out.println();
        printWarehouse(warehouse, "Как выглядит склад, после перемещения из него milk milky");
        System.out.println();
        printWarehouse(warehouseMove, "Как выглядит склад, после перемещения в него milk milky");
        System.out.println();
        milk.setPrice(new Price(150));
        milk.changeQuantity(-7);
        printWarehouse(warehouseMove, "Изменение milky (цена и количество)");
        System.out.println();
        System.out.println("Попытка забрать 100 товаров milky");
        try {
            milk.changeQuantity(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка остатка: " + e.getMessage());
        }
    }
}
