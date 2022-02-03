
import java.lang.Math;

class Sphere extends Surface {

	public Vector3D c;
	public double R;

	public Sphere(Vector3D center, double radius) {
		super();
		this.c = center;
		this.R = radius;
	}

	@Override
	public boolean hit(Ray ray, double t0, double t1, HitRecord record) {
		Vector3D eyeToCenter = ray.e.subtract(c);
		double discriminant = Math.pow(ray.d.dot(eyeToCenter), 2) - ray.d.dot(ray.d) * (eyeToCenter.dot(eyeToCenter) - Math.pow(R, 2));
		if (discriminant >= 0) {
			double numTerm = -ray.d.dot(eyeToCenter);
			double denom = ray.d.dot(ray.d);
			double x1 = (numTerm - Math.sqrt(discriminant)) / denom;
			double x2 = (numTerm + Math.sqrt(discriminant)) / denom;
			if (!inRange(x1, t0, t1) && !inRange(x2, t0, t1))
				return false;
			record.t = Math.min(inRange(x1, t0, t1) ? x1 : Math.max(x1, t1 - t0),
			                    inRange(x2, t0, t1) ? x2 : Math.max(x2, t1 - t0));
			record.p = ray.e.add(ray.d.multiply(record.t));
			record.normal = record.p.subtract(c).divide(R);
			return true;
		}
		return false;
	}

}