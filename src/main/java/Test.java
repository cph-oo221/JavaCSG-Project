import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();
		// Geometry3D cyl = csg.cylinder3D(10, 20, 32, true);

		Geometry3D cube1 = csg.box3D(10, 5, 5, true);
		csg.view(cube1);
	}
}
