package Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventObserverTest {

    @Test
    public void eventObsTest() {
        SmartHome smartHome = mock(SmartHome.class);
        LightEventProcessor lightEventProcessor = mock(LightEventProcessor.class);
        DoorEventProcessor doorEventProcessor = mock(DoorEventProcessor.class);
        HallEventsProcessor hallEventsProcessor = mock(HallEventsProcessor.class);

        EventObserver sensorEventObserver = new EventObserver(smartHome);
        sensorEventObserver.addHandler(lightEventProcessor);
        sensorEventObserver.addHandler(doorEventProcessor);
        sensorEventObserver.addHandler(hallEventsProcessor);

        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.onEventSens(sensorEvent);

        verify(lightEventProcessor).handle(smartHome, sensorEvent);
        verify(doorEventProcessor).handle(smartHome, sensorEvent);
        verify(hallEventsProcessor).handle(smartHome, sensorEvent);
}
}
