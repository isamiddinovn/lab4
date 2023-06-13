package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;
    private int mSwing;

    public int getSwingDirection() {
        return mSwing;
    }



    public boolean setSwing(int mSwing) {
        if (-1 <= mSwing && mSwing <= 1) {
            this.mSwing = mSwing;
            return true;
        } else {
            return false;
        }
    }

    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }

    public void close() {
        setSwing(CLOSED);

    }

    public int thru(int count) {
        return (getSwingDirection() == OUT) ? -count : (getSwingDirection() == IN) ? count : 0;

    }

    @Override
    public String toString() {
        if (getSwingDirection() == OUT){
            return "This gate is open and swings to exit the pen only";
        }else {
            if (getSwingDirection()== IN){
                return "This gate is open and swings to enter the pen only";
            }else {
                if (getSwingDirection() == CLOSED){
                    return "This gate is closed";
                }
                else {
                    return "This gate has an invalid swing direction";
                }
            }
        }

    }
}