package Car;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CarBody
{
    private final JavaCSG csg;
    private final double width;
    private final double height;
    private final double length;

    public CarBody(JavaCSG csg, double width, double height, double length)
    {
        this.csg = csg;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Geometry3D generate()
    {
        Geometry3D body = csg.box3D(width, height, length, true);
        Geometry3D centerHole = csg.box3D(width / 1.2, height / 1.2, length / 1.2, true);
        return csg.difference3D(body, centerHole);
    }
}
