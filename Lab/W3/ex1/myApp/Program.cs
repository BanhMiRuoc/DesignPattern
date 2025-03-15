class Program
{
    static void Main()
    {
        CoffeinBeverage tea = new Tea();
        CoffeinBeverage coffee = new Coffee();

        Console.WriteLine("Making tea...");
        tea.prepareRecipe();
        Console.WriteLine("Making coffee...");
        coffee.prepareRecipe();
    }
}