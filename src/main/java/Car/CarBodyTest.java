package Car;

import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarBodyTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarBody body = new CarBody(csg, 50, 20, 100);
        csg.view(body.generate());
    }
}
