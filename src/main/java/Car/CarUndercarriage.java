package Car;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CarUndercarriage
{
    private final JavaCSG csg;
    private final double width;
    private final double length;
    private final double height;
    private final int angularResolution;

    public CarUndercarriage(JavaCSG csg, double width, double length, double height, int angularResolution)
    {
        this.csg = csg;
        this.width = width;
        this.length = length;
        this.height = height;
        this.angularResolution = angularResolution;
    }

    private Geometry3D generate()
    {
        Geometry3D undercarriage = csg.cylinder3D(width, length, angularResolution, true);
        return undercarriage;
    }
}
