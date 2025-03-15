class EquilateralTriangle extends TriangleDrawer {
    @Override
    protected void calculateThirdPoint() {
        int dx = B.x - A.x;
        int dy = B.y - A.y;
        C = (A.y < B.y) ? new Point(A.x - dy, A.y + dx) : new Point(B.x - dy, B.y + dx);
    }
}