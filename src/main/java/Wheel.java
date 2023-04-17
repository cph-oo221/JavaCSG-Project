import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Wheel
{
    private final JavaCSG csg;
    private final double diameter;
    private final double height;
    private final int angularResolution;
    private final int posX;
    private final int posY;
    private final int posZ;


    public Wheel(JavaCSG csg, double diameter, double height,
                 int angularResolution, int posX, int posY, int posZ)
    {
        this.csg = csg;
        this.diameter = diameter;
        this.height = height;
        this.angularResolution = angularResolution;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public Geometry3D generate()
    {
        Geometry3D wheel = csg.cylinder3D(diameter, height, angularResolution, false);
        wheel = csg.rotate3DX(csg.degrees(90)).transform(wheel);
        return csg.translate3D(posX, posY, posZ).transform(wheel);
    }
}
