public class RecruitmentSystem {
    public static void main(String[] args) {

        System.out.println("Tuyen dung dev:");
        RecruitmentProcess devRecruitment = new DeveloperRecruitment();
        devRecruitment.hireCandidate();

        System.out.println("\nTuyen dung sale:");
        RecruitmentProcess salesRecruitment = new SalesRecruitment();
        salesRecruitment.hireCandidate();
    }
}
