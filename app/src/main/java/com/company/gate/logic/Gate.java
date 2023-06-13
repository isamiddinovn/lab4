
package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public enum SwingDirection {
        OUT, IN, CLOSED
    }

    private SwingDirection mSwing;

    public SwingDirection getSwingDirection() {
        return mSwing;
    }

    public boolean setSwing(SwingDirection swing) {
        if (swing != null) {
            this.mSwing = swing;
            return true;
        } else {
            return false;
        }
    }

    public boolean open(SwingDirection direction) {
        if (direction == SwingDirection.IN || direction == SwingDirection.OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }

    public void close() {
        setSwing(SwingDirection.CLOSED);
    }

    public int thru(int count) {
        return (getSwingDirection() == SwingDirection.OUT) ? -count : (getSwingDirection() == SwingDirection.IN) ? count : 0;
    }

    @Override
    public String toString() {
        switch (getSwingDirection()) {
            case OUT:
                return "This gate is open and swings to exit the pen only";
            case IN:
                return "This gate is open and swings to enter the pen only";
            case CLOSED:
                return "This gate is closed";
            default:
                return "This gate has an invalid swing direction";
        }
    }
}