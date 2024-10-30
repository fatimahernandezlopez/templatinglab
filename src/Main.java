import java.util.ArrayList;

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

    public String toString(){
        return "Name: " + _name + "\nQuantity: " + _quantity;
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

    public String toString(){
        return "Name: " + _name + "\nQuantity: " + _quantity;
    }
}


class Recipe<T extends Ingredient> {
    private String _name;
    private ArrayList<T> _ingredients;
    public Recipe(String name, int size){
        _ingredients = new ArrayList<>(size);
    }

    public void addIngredient(T t){
        _ingredients.add(t);

    }

    public void print(){
        for(T t : _ingredients){
            System.out.println(t);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Recipe<Ingredient> r = new Recipe<>("Cookies", 12);
        SolidIngredient s = new SolidIngredient("sugar", 3);
        r.addIngredient(s);
        r.print();


    }
}