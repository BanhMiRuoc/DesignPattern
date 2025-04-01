public class SomeClass {
    private CalculationStragetry calculation = new DefaultCalculationStragetry();

    public SomeClass(CalculationStragetry calculation) {
        this.calculation = calculation;
    }

    public void Function1(int some_const) {
        int i = calculation.calculate(10);
        System.out.println(i);
    }
}