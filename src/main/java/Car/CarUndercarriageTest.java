package Car;

import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarUndercarriageTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarUndercarriage undercarriage = new CarUndercarriage(csg, 3, 60);
        csg.view(undercarriage.generate());
    }
}
