package snowfish.cn;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag3 extends SimpleTagSupport{

	private boolean a;
	
	

	public boolean isA() {
		return a;
	}



	public void setA(boolean a) {
		this.a = a;
	}



	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		System.out.println(a);
		if (a) {
			getJspBody().invoke(getJspContext().getOut());
		}
	}

}
