public class Main {
    public static void main(String[] args) {
        System.out.println("**Preparing coffee**");
        CoffinBeverage coffee = new Coffee();
        coffee.prepareRecipe();
        System.out.println();
        System.out.println("**Preparing tea**");
        CoffinBeverage tea = new Tea();
        tea.prepareRecipe();
    }

}