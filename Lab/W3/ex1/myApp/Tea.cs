class Tea : CoffeinBeverage
{
    protected override void brew()
    {
        Console.WriteLine("Steeping the tea");
    }

    protected override void addCondiments()
    {
        Console.WriteLine("Adding Lemon");
    }

    protected override bool customerWantsCondiments()
    {
        Console.WriteLine("Would you like lemon with your tea? (y/n)");
        string answer = Console.ReadLine().ToLower();
        return answer == "yes";
    }
}