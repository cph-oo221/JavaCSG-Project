package Car;

import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarWheelsTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarWheels wheel = new CarWheels(csg, 20, 5, 360);
        csg.view(wheel.generate());
    }
}
