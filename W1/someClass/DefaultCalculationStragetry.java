public class DefaultCalculationStragetry implements CalculationStragetry {
    @Override
    public int calculate(int some_const) {
        return (some_const * 50) + 100;
    }
}