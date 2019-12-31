package base.logger;

public enum StatusEnum {

    PASS("Pass"),
    FAIL("Failure");

    private final String statusName;

    StatusEnum(String name) {
        this.statusName = name;
    }

    public String getStatusName() {
        return this.statusName;
    }



}
