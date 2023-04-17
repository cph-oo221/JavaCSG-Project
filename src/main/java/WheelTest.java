import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class WheelTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        Wheel wheel = new Wheel(csg, 20, 5, 360, 20,0, 10);
        csg.view(wheel.generate());
    }
}
