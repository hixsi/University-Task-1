package com.company;

public enum SweetsType {
    WAFFLE(2), CHOCOLATE(0), BISQUITS(1);

    private int code;

    SweetsType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
