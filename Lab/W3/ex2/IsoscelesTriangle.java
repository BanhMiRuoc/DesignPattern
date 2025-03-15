class IsoscelesTriangle extends TriangleDrawer {
    @Override
    protected void calculateThirdPoint() {
        int midX = (A.x + B.x) / 2;
        int height = Math.abs(B.x - A.x);
        C = (A.y < B.y) ? new Point(midX, A.y - height) : new Point(midX, B.y - height);
    }
}