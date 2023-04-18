package Car;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class CarWheels
{
    private final JavaCSG csg;
    private final double diameter;
    private final double height;
    private final int angularResolution;

    public CarWheels(JavaCSG csg, double diameter, double height, int angularResolution)
    {
        this.csg = csg;
        this.diameter = diameter;
        this.height = height;
        this.angularResolution = angularResolution;
    }

    private Geometry3D tire()
    {
        Geometry3D wheel = csg.cylinder3D(diameter, height, angularResolution, true);
        Geometry3D centerHole = csg.cylinder3D(diameter / 1.2, height + 10, angularResolution, true);
        return csg.difference3D(wheel, centerHole);
    }

    private List<Geometry3D> tireCaps()
    {
        List<Geometry3D> items = new ArrayList<>();
        Geometry3D wheelCap = csg.cylinder3D(diameter / 3, height, angularResolution, true);
        items.add(wheelCap);
        Geometry3D pin = csg.box3D(diameter - 1.25, diameter / 10, height, true);
        items.add(pin);
        Geometry3D pin1 = csg.box3D(diameter / 10, diameter - 1.25, height, true);
        items.add(pin1);

        return items;
    }

    private Geometry3D tireCapsHole()
    {
        Geometry3D wheelCapHole = csg.cylinder3D(diameter / 6, height + 20, angularResolution, true);
        return wheelCapHole;
    }

    public Geometry3D generate()
    {
        List<Geometry3D> items = new ArrayList<>();
        items.add(tire());
        items.addAll(tireCaps());
        return csg.difference3D(csg.union3D(items), tireCapsHole());
    }
}
