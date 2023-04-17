package Car;

import Car.Wheels;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class WheelsTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        Wheels wheel = new Wheels(csg, 20, 5, 360);
        csg.view(wheel.generate());
    }
}
