
class A extends Thread
{     CL cl;
	public A(CL cl) {
		this.cl=cl;
	}

	public void run()
	{
		cl.get();
	}
}

class B extends Thread
{  CL cl;
	public B(CL cl) {
		this.cl=cl;
	}

	public void run()
	{
		cl.get1();
	}
}

public class Test {
	public static void main(String[] args) {
		CL cl=new CL();
		A a=new A(cl);
		B b=new B(cl);
		a.start();
		b.start();
	}

}
