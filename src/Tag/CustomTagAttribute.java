package Tag;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomTagAttribute extends SimpleTagSupport {
	private String ten;
	private String kieungay;
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getKieungay() {
		return kieungay;
	}

	public void setKieungay(String kieungay) {
		this.kieungay = kieungay;
	}

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		try {
			if(ten.isEmpty()) 
				ten="No";			
			if(kieungay.isEmpty())
				kieungay="dd/MM/yyyy";
			Date date = new Date();
			String chuoiNgay = new SimpleDateFormat(kieungay).format(date);
			out.println("<h2>Hôm nay ngày "+chuoiNgay+"</h2>");
			out.println("<h2>Chào mừng "+ten+" đến đây </h2>");
		} catch (Exception e) {
			throw new JspException("Error", e);
		}
	}
}
