public abstract class CoffinBeverage {
      final void prepareRecipe() {
        boilWater();
        brew();
        pourCup();
        if (customerWantsCondiments()) {addCondiments();}
    }
    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }
    void pourCup() {
        System.out.println("Pouring cup");
    }
    boolean customerWantsCondiments() {
        return true;
    }
}
