package entity;

public class Recipes {
//Jess
	private int recipes_id;
	private String name;
	private String ingredients;
	private String instructions;

	public Recipes(int recipes_id, String name, String ingredients, String instructions) {
		this.recipes_id = recipes_id;
		this.name = name;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Recipe [recipesId = " + recipes_id + ", Name = " + name + ", Ingredients = " + ingredients
				+ ", Instructions = " + instructions + "]";
	}

	public int getRecipeId() {
		return recipes_id;

	}

	public String getName() {
		return name;

	}

	public String getIngredients() {
		return ingredients;

	}

	public String getInstructions() {
		return instructions;

	}
}
