package p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmTest {
    private Alarm alarm;
    private static final Sensor SENSOR = Mockito.mock(Sensor.class);

    @BeforeEach
    public void setUp() {
        alarm = new Alarm(SENSOR);
    }

    @Test
    public void testAlarmConstructor() {
        assertNotEquals(null, alarm);
    }

    @Test
    public void testGetAlarmOn() {
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethod_whenPressureIsInBounds() {
        //Arrange
        Mockito.when(SENSOR.popNextPressurePsiValue()).thenReturn(18.0);
        alarm = new Alarm(SENSOR);

        //Act
        alarm.check();

        //Assert
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethod_whenPressureIsOverThreshold() {
        Mockito.when(SENSOR.popNextPressurePsiValue()).thenReturn(22.0);
        alarm = new Alarm(SENSOR);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethod_whenPressureIsLessThreshold() {
        Mockito.when(SENSOR.popNextPressurePsiValue()).thenReturn(16.0);
        alarm = new Alarm(SENSOR);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }
}
