package Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.*;
import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.*;


public class LightEventProcessorTest {
    @Test
    public void lightIsOnTest() {
        List<Light> arrayListForLight = new ArrayList();
        Light light;
        for (int i = 1; i <= 10; i++) {
            light = new Light("" + i, true);
            arrayListForLight.add(light);
        }

        List<Door> arrayListForDoor = new ArrayList<>();
        Door door;
        for (int i = 0; i < 5; i++) {
            door = new Door(false, "" + i);
            arrayListForDoor.add(door);
        }

        ArrayList<Room> arrayListForRoom = new ArrayList<>();
        Room room = new Room(arrayListForLight, arrayListForDoor, "kitchen");
        arrayListForRoom.add(room);

        SmartHome smartHome = new SmartHome(arrayListForRoom);
        SensorEvent sensorEvent = new SensorEvent(LIGHT_ON, "1");

        for (Room rooms : smartHome.getRooms()) {
            for (Light lights : room.getLights()) {
                if (lights.getId().equals(sensorEvent.getObjectId())) {
                    assertTrue(lights.isOn());
                }
            }
        }
    }


        @Test
        public void isOffTest() {
            SmartHome smartHome = new SmartHome();
            SensorEvent sensorEvent = new SensorEvent(LIGHT_OFF, "1");
            Light light = new Light("1", false);
            Door door = new Door(false, "1");
            ArrayList<Light> lights = new ArrayList<>();
            lights.add(light);
            ArrayList<Door> doors = new ArrayList<>();
            doors.add(door);
            Room room = new Room(lights, doors, "object");
            smartHome.addRoom(room);
            for (Room rooms : smartHome.getRooms()) {
                for (Light lightsen : room.getLights()) {
                    if (lightsen.getId().equals(sensorEvent.getObjectId())) {
                        assertFalse(lightsen.isOn());
                    }
                }
            }
        }

}