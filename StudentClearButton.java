public class StudentClearButton
{
	public Object object;
	public static StudentClearButton fromObject(Object p0) { return new StudentClearButton(null,p0); }
	private StudentClearButton(StudentClearButton p0, Object p1) { object = p1; } // p0 avoids collisions with existing constructors

	// pass through constructors
	public StudentClearButton(float p0, float p1, Object p2) throws GraderException { object = Student.construct("ClearButton", new Object[] {p0, p1, p2}); }

	// pass through methods
	public void mousePressed() throws GraderException { Student.callMethod(object, "mousePressed"); }

	// field accessors and methods
}

