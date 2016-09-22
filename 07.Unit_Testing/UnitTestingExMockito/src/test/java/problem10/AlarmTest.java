package problem10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(this.sensor);
    }

    @Test
    public void testAlarmWithLowPressureShouldTurnAlarmOn() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.5);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHighPressureShouldTurnAlarmOn() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(25.5);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithMidPressureShouldNotStartTheAlarm() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.5);
        this.alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());
    }
}
