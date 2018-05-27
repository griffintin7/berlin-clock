package com.work.berlinclock;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BerlinClockTest {

    @Test
    public void testInvalidTime() {
        BerlinClock clock = new BerlinClock();
        String time = "";
        Assert.assertEquals(clock.printBerlinClock(""),
                "ERROR: time is NULL or EMPTY.");
        time = null;
        Assert.assertEquals(clock.printBerlinClock(null),
                "ERROR: time is NULL or EMPTY.");
        time = "test";
        Assert.assertEquals(clock.printBerlinClock(time), "ERROR: " + time
                + " is not the valid time format i.e hh:mm:ss.");
        time = "-1:54:59";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Hours specified in time " + time
                        + " is not valid.It should be within 00 to 24");
        time = "25:54:59";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Hours specified in time " + time
                        + " is not valid.It should be within 00 to 24");
        time = "00:-1:59";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Minutes specified in time " + time
                        + " is not valid.It should be within 00 to 59");
        time = "00:60:59";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Minutes specified in time " + time
                        + " is not valid.It should be within 00 to 59");
        time = "00:00:-1";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Seconds specified in time " + time
                        + " is not valid.It should be within 00 to 59");
        time = "00:00:60";
        Assert.assertEquals(clock.printBerlinClock(time),
                "ERROR: Seconds specified in time " + time
                        + " is not valid.It should be within 00 to 59");
        time = "00:00:60:00";
        Assert.assertEquals(clock.printBerlinClock(time), "ERROR: " + time
                + " is not the valid time format i.e hh:mm:ss.");
    }

    @Test
    public void testHappyFlow() {
        BerlinClock clock = new BerlinClock();
        String output1 = "Y"+System.getProperty("line.separator")
                        +"OOOO"+System.getProperty("line.separator")
                        +"OOOO"+System.getProperty("line.separator")
                        +"OOOOOOOOOOO"+System.getProperty("line.separator")
                        +"OOOO";
        String output2 = "O"+System.getProperty("line.separator")
                +"RROO"+System.getProperty("line.separator")
                +"RRRO"+System.getProperty("line.separator")
                +"YYROOOOOOOO"+System.getProperty("line.separator")
                +"YYOO";
        String output3 = "O"+System.getProperty("line.separator")
                +"RRRR"+System.getProperty("line.separator")
                +"RRRO"+System.getProperty("line.separator")
                +"YYRYYRYYRYY"+System.getProperty("line.separator")
                +"YYYY";
        String output4 = "Y"+System.getProperty("line.separator")
                +"RRRR"+System.getProperty("line.separator")
                +"RRRR"+System.getProperty("line.separator")
                +"OOOOOOOOOOO"+System.getProperty("line.separator")
                +"OOOO";
        String time = "00:00:00";
        Assert.assertEquals(clock.printBerlinClock(time), output1);
        time = "13:17:01";
        Assert.assertEquals(clock.printBerlinClock(time), output2);
        time = "23:59:59";
        Assert.assertEquals(clock.printBerlinClock(time), output3);
        time = "24:00:00";
        Assert.assertEquals(clock.printBerlinClock(time), output4);
    }
}
