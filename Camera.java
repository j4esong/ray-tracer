
class Camera {

	public Vector3D e;
	public Vector3D w, u, v;
	public double focalLength;

	public Camera(Vector3D e, Vector3D w, Vector3D v) {
		this.e = e;
		this.w = w;
		this.u = v.cross(w);
		this.v = v;
		focalLength = 600;
	}

}