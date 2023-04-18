package Car;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class CarBody
{

    // TODO - MABEY STARTOVER WITH THIS CLASS
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


    private  List<Geometry3D> wheelArches()
    {
        List<Geometry3D> wheelArches = new ArrayList<>();
        Geometry3D wheelArch = csg.cylinder3D(width / 2, height, 360, true);
        wheelArch = csg.rotate3DY(csg.degrees(90)).transform(wheelArch);

        for (int i = 0; i < 4; i++)
        {
            Geometry3D currentWheelArch = wheelArch;

            if (i == 0)
            {
                currentWheelArch = csg.translate3D(width / 1.4, height / 2, - height / 2.25).transform(currentWheelArch);
                wheelArches.add(currentWheelArch);
            }
            if (i == 1)
            {
                currentWheelArch = csg.translate3D(-width / 1.4, height / 2, - height / 2.25).transform(currentWheelArch);
                wheelArches.add(currentWheelArch);
            }
            if (i == 2)
            {
                currentWheelArch = csg.translate3D(-width / 1.4, -height / 2, - height / 2.25).transform(currentWheelArch);
                wheelArches.add(currentWheelArch);
            }
            if (i == 3)
            {
                currentWheelArch = csg.translate3D(width / 1.4 , -height / 2, - height / 2.25).transform(currentWheelArch);
                wheelArches.add(currentWheelArch);
            }
        }

        return wheelArches;
    }

    private Geometry3D body()
    {
        List<Geometry3D> items = new ArrayList<>();

        Geometry3D body = csg.box3D(width, height, length, true);
        body = csg.rotate3DX(csg.degrees(90)).transform(body);

        Geometry3D boxRear = csg.box3D(width, height / 2, length / 4, true);
        boxRear = csg.translate3D(width, height, height).transform(boxRear);

//        Geometry3D boxFront = csg.box3D(width, height / 2, length / 3, true);
//        boxFront = csg.translate3D(-50, -50, length - height / 2).transform(boxFront);

        items.add(boxRear);
//        items.add(boxFront);


        return csg.difference3D(body, csg.union3D(items));
    }


    public Geometry3D generate()
    {

        return csg.difference3D(body(), wheelArches());
    }
}
