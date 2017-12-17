package Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.AlarmSystemImplementation;
import ru.sbt.mipt.oop.AlarmSystemType;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

import static org.junit.Assert.*;

public class AlarmSystemImplementationTest {

    public SensorEvent getSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }

    @Test
    public void testSystemOff(){
        AlarmSystemImplementation alarmSystemImplementation = new AlarmSystemImplementation(1);
        assertEquals(AlarmSystemType.OFF, alarmSystemImplementation.getStateType());
    }

    @Test
    public void testSystemOn(){
        AlarmSystemImplementation alarmSystemImplementation = new AlarmSystemImplementation(1);
        alarmSystemImplementation.turnOn();
        assertEquals(AlarmSystemType.ON, alarmSystemImplementation.getStateType());
    }

    @Test
    public void testSystemSensorEvent(){
        AlarmSystemImplementation alarmSystemImplementation = new AlarmSystemImplementation(1);
        alarmSystemImplementation.turnOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarmSystemImplementation.onSensorEvent(sensorEvent);
        assertEquals(AlarmSystemType.WAIT_FOR_PASSWORD, alarmSystemImplementation.getStateType());
    }

    @Test
    public void testSystemWaitForPassword(){
        AlarmSystemImplementation alarmSystemImplementation = new AlarmSystemImplementation(1);
        alarmSystemImplementation.turnOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarmSystemImplementation.onSensorEvent(sensorEvent);
        alarmSystemImplementation.turnOff();
        assertEquals(AlarmSystemType.ALARM, alarmSystemImplementation.getStateType());
    }

}