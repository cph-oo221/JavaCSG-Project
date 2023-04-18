package Car;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CarUndercarriage
{
    private final JavaCSG csg;
    private final double diameter;
    private final double height;
    private final int angularResolution = 360;

    public CarUndercarriage(JavaCSG csg, double diameter, double height)
    {
        this.csg = csg;
        this.diameter = diameter;
        this.height = height;
    }

    public Geometry3D generate()
    {
        Geometry3D undercarriage = csg.cylinder3D(diameter, height, angularResolution, true);
        undercarriage = csg.rotate3DY(csg.degrees(90)).transform(undercarriage);
        return undercarriage;
    }
}
