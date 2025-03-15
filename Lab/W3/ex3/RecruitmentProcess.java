abstract class RecruitmentProcess {
    public final void hireCandidate() {
        receiveApplication();
        conductInitialInterview();
        evaluateCandidate();
        makeHiringDecision();
    }

    private void receiveApplication() {
        System.out.println("Nhan ho so.");
    }

    private void conductInitialInterview() {
        System.out.println("Phong van.");
    }

    protected abstract void evaluateCandidate();

    private void makeHiringDecision() {
        System.out.println("Quyet dinh tuyen dung.");
    }
}