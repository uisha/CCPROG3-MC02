import java.util.ArrayList;

public class Product extends Item {
      ArrayList<Item> ingredientsList;

      public Product(String name, int quantity) {
            super(name, quantity);

            this.ingredientsList = new ArrayList<Item>();
      }
      
      public ArrayList<Item> getIngredientsList() {
            return this.ingredientsList;
      }

      public void setIngredientsList(ArrayList<Item> ingredientsList) {
            this.ingredientsList = ingredientsList;
      }
}