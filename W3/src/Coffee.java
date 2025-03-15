import java.util.Scanner;

public class Coffee extends CoffinBeverage {
    public void brew(){
        System.out.println("Brewing coffee grinds");
    }
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        else {return false;}
    }
    public String getUserInput() {
        System.out.print("Do you want to add Condiments? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
