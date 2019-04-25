package com.chefapp.ui;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.*;
import com.chefapp.service.SaladService;
import com.chefapp.service.VegetableService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private final SaladService saladService;
    private final VegetableService vegetableService;
    private final Scanner scanner = new Scanner(System.in);

    public Ui(SaladService saladService, VegetableService vegetableService) {
        scanner.useDelimiter("\n");
        this.saladService = saladService;
        this.vegetableService = vegetableService;
    }

    public void run() {
        boolean toContinue = true;
        int input;
        System.out.println("*******************************************\n" +
                "------------------ Welcome ----------------\n" +
                "*******************************************\n");
        while (toContinue) {
            System.out.print("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n\n" +
                    "Choose what you want to do: \n" +
                    "Create salad       - 1\n" +
                    "Create vegetable   - 2\n" +
                    "See salads         - 3\n" +
                    "See vegetables     - 4\n" +
                    "Exit               - 0\n\n" +
                    "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                    "*******************************************\n" +
                    "Your command: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    createSaladProcess();
                    break;
                case 2:
                    createVegetableProcess();
                    break;
                case 3:
                    printSalads();
                    break;
                case 4:
                    printVegetables();
                    break;
                case 0:
                    toContinue = false;
                    break;
                default:
                    System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                            "Error was detected. Reason: Wrong Input!\n" +
                            "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
            }


        }


    }

    private void createVegetableProcess() {
        boolean toContinue = true;
        int input;
        while (toContinue) {
            Vegetable vegetable = createVegetable();
            if (vegetable == null) {
                System.out.print("\n___________________________________________\n" +
                        "      Go back to Main menu or retry?       \n" +
                        "Menu      - 1\n" +
                        "Retry     - 0\n" +
                        "-------------------------------------------\n" +
                        "Yor choice: ");
                input = scanner.nextInt();
                if (input == 1) {
                    toContinue = false;
                } else if (input != 0) {
                    System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                            "Error was detected. Reason: Wrong Input!\n" +
                            "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
                }
            }
            vegetableService.addVegetable(vegetable);
        }
    }

    private void createSaladProcess() {

        boolean toContinue = true;
        String name = "";
        long id = -1L;

        System.out.println("___________________________________________\n" +
                "            Salad creating started         \n" +
                "-------------------------------------------\n");

        while (toContinue) {
            toContinue = false;

            try {
                System.out.print("Write id: ");
                id = scanner.nextLong();
                System.out.print("\nWrite name: ");
                name = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                        "Error was detected. Reason: Wrong input!\n" +
                        "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
                toContinue = true;
            }

            // Check id is unique
            if (name.isEmpty()) {
                toContinue = true;
                System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                        "Error was detected. Reason: Wrong Name!\n" +
                        "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
            } else if (id < 0) {
                toContinue = true;
                System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                        "Error was detected. Reason: Wrong ID!\n" +
                        "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
            }

        }

        toContinue = true;

        int input;
        List<Vegetable> vegetables = new ArrayList<>();
        Vegetable createdVegetable = null;

        while (toContinue) {
            System.out.print("\n___________________________________________\n" +
                    "Add vegetable         - 1\n" +
                    "Finally create salad " + name + " - 0\n" +
                    "Cancel salad creation - 101\n" +
                    "-------------------------------------------\n" +
                    "Your command: ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    createdVegetable = createVegetable();
                    break;
                case 0:
                    toContinue = false;
                    if (!vegetables.isEmpty())
                        saladService.createSalad(new Salad<>(id, name, vegetables));
                    else {
                        System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                                "Error was detected. \n" +
                                "Reason: Can not create salad without vegetables!\n" +
                                "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
                    }
                    break;
                case 101:
                    return;
                default:
                    System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                            "Error was detected. Reason: Wrong Input!\n" +
                            "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
            }
            if (createdVegetable != null)
                vegetables.add(createdVegetable);


        }


    }

    private Vegetable createVegetable() {

        int input;
        String name;
        Long Id;
        double caloriesH;
        int weight;
        VegetableWayOfCooking[] vegetableWayOfCookings;

        System.out.println("___________________________________________\n" +
                "            Vegetable creating started         \n" +
                "-------------------------------------------\n");

        while (true) {

            while (true) {
                System.out.print("\nChoose what type of vegetable you want to create: \n" +
                        "Bulbous   - 1\n" +
                        "Cabbages  - 2\n" +
                        "Melons    - 3\n" +
                        "RootCrops - 4\n" +
                        "Spicy     - 5\n" +
                        "Stop creation - 101\n" +
                        "Type: "
                );
                input = scanner.nextInt();
                if (input == 101)
                    return null;
                if (!(input < 0 || input > 5)) {
                    break;
                }
                System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                        "Error was detected. Reason: Wrong Input!\n" +
                        "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");

            }
            try {
                System.out.print("Write id: ");
                Id = scanner.nextLong();

                System.out.print("\nWrite name: ");
                name = scanner.next();

                System.out.print("Write wight: ");
                weight = scanner.nextInt();

                System.out.print("\nWrite calories in 100 grams: ");
                caloriesH = scanner.nextDouble();

                vegetableWayOfCookings = createVegetableWayOfCookings();

            } catch (InputMismatchException e) {
                System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                        "Error was detected. Reason: Wrong input!\n" +
                        "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");
                return null;
            }

            switch (input) {
                case 1:
                    System.out.print("___________________________________________\n" + "Is this bulbous sweet?\n" +
                            "Yes - 1\n" + "Default is not sweat\n" +
                            "Sweat: ");

                    boolean isSweet = scanner.nextInt() == 1;
                    return new Bulbous.BulbousBuilder()
                            .id(Id)
                            .name(name)
                            .weight(weight)
                            .caloriesH(caloriesH)
                            .wayOfCooking(vegetableWayOfCookings)
                            .isSweet(isSweet)
                            .build();
                case 2:
                    return new Cabbage.CabbageBuilder()
                            .id(Id)
                            .name(name)
                            .weight(weight)
                            .caloriesH(caloriesH)
                            .wayOfCooking(vegetableWayOfCookings)
                            .build();
                case 3:
                    return new Melons.MelonsBuilder()
                            .id(Id)
                            .name(name)
                            .weight(weight)
                            .caloriesH(caloriesH)
                            .wayOfCooking(vegetableWayOfCookings)
                            .build();
                case 4:
                    return new RootCrop.RootCropBuilder()
                            .id(Id)
                            .name(name)
                            .weight(weight)
                            .caloriesH(caloriesH)
                            .wayOfCooking(vegetableWayOfCookings)
                            .build();
                case 5:
                    System.out.print("Set spicy level: ");
                    int spicylevel = scanner.nextInt();
                    return new Spicy.SpicyBuilder()
                            .id(Id)
                            .name(name)
                            .weight(weight)
                            .caloriesH(caloriesH)
                            .wayOfCooking(vegetableWayOfCookings)
                            .spicyLevel(spicylevel > -1 ? spicylevel : 0)
                            .build();

            }
        }
    }

    private VegetableWayOfCooking[] createVegetableWayOfCookings() {
        System.out.println("___________________________________________\n" +
                "Vegetable ways of cooking creating started\n" +
                "-------------------------------------------\n");
        int input;
        while (true) {
            System.out.print("\nHow many ways of cooking you want to set (max = 10)?\n" +
                    "Ways: ");
            input = scanner.nextInt();
            if (input > 0 && input < 11) {
                VegetableWayOfCooking[] vegetableWayOfCookings = new VegetableWayOfCooking[input];
                for (int i = 0; i < vegetableWayOfCookings.length; i++) {
                    //TODO: check if the way of cooking is already set
                    System.out.print("Choose what you can do with this:\n" +
                            "Wash - 1\n" +
                            "Peel - 2\n" +
                            "Slice - 3\n" +
                            "Dice - 4\n" +
                            "Mash - 5\n" +
                            "Cut - 6\n" +
                            "Fry - 7\n" +
                            "Grill - 8\n" +
                            "Steam - 9\n" +
                            "Boil - 10\n" +
                            "Way of cooking number: "
                    );
                    input = scanner.nextInt();
                    switch (input) {
                        case 2:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.PEEL;
                            break;
                        case 3:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.SLICE;
                            break;
                        case 4:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.DICE;
                            break;
                        case 5:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.MASH;
                            break;
                        case 6:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.CUT;
                            break;
                        case 7:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.FRY;
                            break;
                        case 8:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.GRILL;
                            break;
                        case 9:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.STEAM;
                            break;
                        case 10:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.BOIL;
                            break;

                        default:
                            vegetableWayOfCookings[i] = VegetableWayOfCooking.WASH;

                    }
                }
                return vegetableWayOfCookings;
            }

            System.out.println("!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n" +
                    "Error was detected. Reason: Wrong Input!\n" +
                    "!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!");


        }

    }

    private void printSalads() {
        int input;
        System.out.println("___________________________________________\n" +
                "Salad LIST\n" +
                "-------------------------------------------\n");
        System.out.println("___________________________________________:\n" +
                "In what order you would like to get Salads:\n" +
                "By Id               - 1\n" +
                "By Name             - 2\n" +
                "By vegetables amount -3\n" +
                "By calories         - 4\n" +
                "Don`t care          - any\n" +
                "Sorting: "
        );
        input = scanner.nextInt();
        boolean toSort = true;
        Salad.sortingProperties sortingPropertie = null;
        switch (input) {
            case 1:
                sortingPropertie = Salad.sortingProperties.ID;
                break;
            case 2:
                sortingPropertie = Salad.sortingProperties.NAME;
                break;
            case 3:
                sortingPropertie = Salad.sortingProperties.VEGETABLES_AMOUNT;
                break;
            case 4:
                sortingPropertie = Salad.sortingProperties.CALORITY;
                break;

            default:
                toSort = false;
        }
        if (toSort) {
            saladService.sortByProperty(sortingPropertie).forEach(System.out::println);
        } else {
            saladService.getSalads().forEach(System.out::println);
        }

    }

    private void printVegetables() {
        System.out.println("___________________________________________\n" +
                "Vegetable LIST\n" +
                "-------------------------------------------\n");
        vegetableService.getVegetables().forEach(System.out::println);
    }
}
