package com.work.berlinclock;

public class BerlinClock {
    /**
     * This function validates the input time & if time is correct it will print
     * Berlin clock representation of input time.
     * 
     * @param time input time
     * @return Berlin clock representation
     */
    public String printBerlinClock(String time) {
        String berlinClockRep = null;
        berlinClockRep = validateTime(time);
        if (null != berlinClockRep && berlinClockRep.contains("ERROR")) {
            return berlinClockRep;
        } else {
            berlinClockRep = getBerlinClockRep(time);
        }
        return berlinClockRep;
    }

    private String validateTime(String time) {
        String berlinClockRep = null;
        if (null == time || time.isEmpty()) {
            berlinClockRep = "ERROR: time is NULL or EMPTY.";
        } else if (!time.isEmpty()) {
            String[] strArray = time.split(":");
            if (strArray.length == 3) {
                int hours = Integer.parseInt(strArray[0]);
                int minutes = Integer.parseInt(strArray[1]);
                int seconds = Integer.parseInt(strArray[2]);
                if (hours < 0 || hours > 24) {
                    berlinClockRep = "ERROR: Hours specified in time " + time
                            + " is not valid.It should be within 00 to 24";
                    return berlinClockRep;
                }
                if (minutes < 0 || minutes > 59) {
                    berlinClockRep = "ERROR: Minutes specified in time " + time
                            + " is not valid.It should be within 00 to 59";
                    return berlinClockRep;
                }
                if (seconds < 0 || seconds > 59) {
                    berlinClockRep = "ERROR: Seconds specified in time " + time
                            + " is not valid.It should be within 00 to 59";
                    return berlinClockRep;
                }
            } else {
                berlinClockRep = "ERROR: " + time
                        + " is not the valid time format i.e hh:mm:ss.";
            }
        }
        return berlinClockRep;
    }

    private String getBerlinClockRep(String time) {
        StringBuilder builder = new StringBuilder();
        String[] strArray = time.split(":");
        int hours = Integer.parseInt(strArray[0]);
        int minutes = Integer.parseInt(strArray[1]);
        int seconds = Integer.parseInt(strArray[2]);
        builder.append(getTopMostRowSec(seconds));
        builder.append(System.getProperty("line.separator"));
        builder.append(getTop1RowHour(hours));
        builder.append(System.getProperty("line.separator"));
        builder.append(getTop2RowHour(hours));
        builder.append(System.getProperty("line.separator"));
        builder.append(getBottom2RowMinue(minutes));
        builder.append(System.getProperty("line.separator"));
        builder.append(getBottomRowMinute(minutes));
        return builder.toString();
    }

    private String getTopMostRowSec(int seconds) {
        String topMostRowInd = "O";
        if (seconds % 2 == 0) {
            topMostRowInd = "Y";
        }
        return topMostRowInd;
    }

    private String getTop1RowHour(int hours) {
        int columns = 4;
        String top1RowHour = getIndicators(columns, hours);
        return top1RowHour;
    }

    private String getIndicators(int columns, int hours) {
        String indicator = "";
        int result = hours / 5;
        if (result == 0) {
            indicator = "OOOO";
        } else {
            for (int i = 0; i < result; i++) {
                indicator = indicator + "R";
            }
            if (result < columns) {
                for (int j = 0; j < columns - result; j++) {
                    indicator = indicator + "O";
                }
            }
        }
        return indicator;
    }

    private String getTop2RowHour(int hours) {
        String indicator = "";
        int columns = 4;
        int remainder = hours % 5;
        if (remainder == 0) {
            indicator = "OOOO";
        } else {
            for (int i = 0; i < remainder; i++) {
                indicator = indicator + "R";
            }
            if (remainder < columns) {
                for (int j = 0; j < columns - remainder; j++) {
                    indicator = indicator + "O";
                }
            }
        }
        return indicator;
    }

    private String getBottom2RowMinue(int minutes) {
        String minIndicator = "";
        int columns = 11;
        int result = minutes / 5;
        if (result == 0) {
            for (int i = 0; i < columns; i++) {
                minIndicator = minIndicator + "O";
            }
        } else {
            for (int i = 1; i <= result; i++) {
                if (i % 3 == 0) {
                    minIndicator = minIndicator + "R";
                } else {
                    minIndicator = minIndicator + "Y";
                }
            }
            if (result < columns) {
                for (int j = 1; j <= columns - result; j++) {
                    minIndicator = minIndicator + "O";
                }
            }
        }
        return minIndicator;
    }

    private String getBottomRowMinute(int minutes) {
        String minIndicator = "";
        int columns = 4;
        int remainder = minutes % 5;
        if (remainder == 0) {
            minIndicator = "OOOO";
        } else {
            for (int i = 0; i < remainder; i++) {
                minIndicator = minIndicator + "Y";
            }
            if (remainder < columns) {
                for (int j = 0; j < columns - remainder; j++) {
                    minIndicator = minIndicator + "O";
                }
            }
        }
        return minIndicator;
    }
}
