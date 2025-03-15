class Coffee : CoffeinBeverage
{
    protected override void brew()
    {
        Console.WriteLine("Dripping Coffee through filter");
    }

    protected override void addCondiments()
    {
        Console.WriteLine("Adding Sugar and Milk");
    }

    protected override bool customerWantsCondiments()
    {
        Console.WriteLine("Would you like milk and sugar with your coffee? (y/n)");
        string answer = Console.ReadLine().ToLower();
        return answer == "yes";
    }
}