package snowfish.cn;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag1 implements SimpleTag{
 private PageContext pageContext;
 private JspFragment jspFragment;
	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().print("hello tag");
		
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {	
		this.jspFragment=arg0;
	}

	@Override
	public void setJspContext(JspContext arg0) {
		this.pageContext=(PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {	
	}

}
