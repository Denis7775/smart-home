package Tests;


import org.junit.Test;
import ru.sbt.mipt.oop.*;
import java.util.*;
import static org.junit.Assert.assertTrue;

public class IterCompTest {
    @Test
    public void testIterCompPattern() {

        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors1 = Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1,"kitchen");

        List<Light> lights2 = Arrays.asList(new Light("3", true));
        List<Door> doors2 = Arrays.asList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2,"bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));

        Set<Object> unvisitedObjects = new HashSet<>();
        unvisitedObjects.add(smartHome);
        unvisitedObjects.add(kitchen);
        unvisitedObjects.add(bathroom);
        unvisitedObjects.addAll(lights1);
        unvisitedObjects.addAll(lights2);
        unvisitedObjects.addAll(doors1);
        unvisitedObjects.addAll(doors2);

        smartHome.executeAction(object -> {
            unvisitedObjects.remove(object);
        });
        assertTrue(unvisitedObjects.isEmpty());
    }
}
