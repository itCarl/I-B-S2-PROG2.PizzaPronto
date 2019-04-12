import java.util.Arrays;


public class PizzaVO implements Cloneable {
	
    private String name;
    private float price;
    private String[] ingredients;

    
    /*
     * Constructors
     */    
    public PizzaVO() {
    }

    public PizzaVO(String name, String[] ingredients, float price) {
        this.setName(name);
        this.setPrice(price);
        this.setIngredients(ingredients);
    }
    
    
    /*
     * General Methods
     */
    public PizzaVO clone() {
        try {
            return (PizzaVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        hc = hashMultiplier * hc + ((this.getName() == null) ? 0 : this.getName().hashCode());
        hc = hashMultiplier * hc + Float.floatToIntBits(this.getPrice());
        hc = hashMultiplier * hc + Arrays.hashCode(this.getIngredients());
        return hc;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() == this.getClass()) {
            PizzaVO pizza = (PizzaVO) obj;
            return this.hashCode() == pizza.hashCode();
        }

        return false;
    }

    public String toString() {
        return "Pizza " + this.getName() + " mit: " + this.getIngredientsString() + " für " + this.getPrice() + "€";
    }
    
    
    /*
     * Getter & Setter
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = (price > 0.0f) ? price : 0.0f;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    private String getIngredientsString() {
        String ingredientsString = "";

        if (this.getIngredients().length == 1) {
            ingredientsString = this.getIngredients()[0];
        } else {
            for (int i = 0; i < this.getIngredients().length - 1; i++) {
                ingredientsString += this.getIngredients()[i] + ", ";
            }

            ingredientsString = ingredientsString.substring(0, ingredientsString.length() - 2);

            ingredientsString += " und " + this.getIngredients()[this.getIngredients().length - 1];
        }

        return ingredientsString;
    }
}
