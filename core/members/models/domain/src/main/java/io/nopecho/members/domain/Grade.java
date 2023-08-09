package io.nopecho.members.domain;

public enum Grade {
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM,
    DIAMOND;

    private Grade next;
    private Grade prev;

    static {
        BRONZE.setNext(SILVER);
        BRONZE.setPrev(BRONZE);

        SILVER.setNext(GOLD);
        SILVER.setPrev(BRONZE);

        GOLD.setNext(PLATINUM);
        GOLD.setPrev(SILVER);

        PLATINUM.setNext(DIAMOND);
        PLATINUM.setPrev(GOLD);

        DIAMOND.setNext(DIAMOND);
        DIAMOND.setPrev(PLATINUM);
    }

    public Grade up() {
        return this.next;
    }

    public Grade down() {
        return this.prev;
    }

    private void setNext(Grade next) {
        this.next = next;
    }

    private void setPrev(Grade prev) {
        this.prev = prev;
    }
}
