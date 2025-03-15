abstract class CoffeinBeverage
{
    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    protected void boilWater() {
        Console.WriteLine("Boiling water");
    }

    protected void pourInCup() {
        Console.WriteLine("Pouring into cup");
    }
    // Hook
    protected virtual bool customerWantsCondiments() {
        return true;
    }
}