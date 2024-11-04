import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
}

class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;

    public SolidIngredient(String name, double quantity){
        _name = name;
        _quantity = quantity;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return _quantity;
    }
}

class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;

    public LiquidIngredient(String name, double quantity){
        _name = name;
        _quantity = quantity;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return _quantity;
    }
}

class Recipe<T extends Ingredient> { // use "extends" for T to implement interface
    private String _name;
    private ArrayList<T> _ingredients;
    private String _instructions;

    public Recipe(String name, String i){
        _ingredients = new ArrayList<>();
        _name = name;
        _instructions = i;
    }
    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void print(){
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("\nIngredients:");
        for(T t : _ingredients){
            System.out.println("\nName: " + t.getName());
            System.out.println("Quantity: " + t.getQuantity());
        }
    }
}

public class Main {
    public static void addIngredient(Recipe r, Scanner scan){
        System.out.println("Select from below:");
        System.out.println("1. Add a liquid ingredient");
        System.out.println("2. Add a solid ingredient");
        System.out.print("Enter choice: ");
        String choice = scan.nextLine();
        if(choice.equals("1") || choice.equals("2")){
            System.out.print("\nEnter ingredient: ");
            String ingredient = scan.nextLine();
            try{
                System.out.print("Enter quantity: ");
                double q = Double.parseDouble(scan.nextLine());
                Ingredient i;
                switch(choice){
                    case "1" -> i = new LiquidIngredient(ingredient, q);
                    default -> i = new SolidIngredient(ingredient, q);
                }
                r.addIngredient(i);
            }catch(Exception e){
                System.out.println("\nInvalid Input. Please enter a number.");
            }
        }
        else
            System.out.println("Invalid Choice.");
    }

    public static String menu(Scanner scan){
        System.out.println("\nSelect from below:");
        System.out.println("1. Add an ingredient to a recipe");
        System.out.println("2. List the ingredients of a recipe");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        String choice = scan.nextLine();
        System.out.println();
        return choice;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! Please create a new Recipe.");
        System.out.print("Recipe name: ");
        String name = scan.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scan.nextLine();
        Recipe<Ingredient> r = new Recipe<>(name, instructions);
        String choice = menu(scan);
        while(!choice.equals("3")){
            switch(choice){
                case "1" -> addIngredient(r, scan);
                case "2" -> r.print();
                default -> System.out.println("Invalid choice. Please try again.");
            }
            choice = menu(scan);
        }
    }
}