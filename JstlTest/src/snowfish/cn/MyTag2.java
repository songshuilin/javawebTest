package snowfish.cn;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		Writer out=getJspContext().getOut();
		out.write("**************");
		getJspBody().invoke(out);
		out.write("**************");
	}

}
