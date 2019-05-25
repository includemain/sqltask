package sqltask;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.Loginsql;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.Auser;


/**
 * Servlet implementation class Loginserver
 */
@WebServlet("/Loginserver")
public class Loginserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println(user);
		System.out.println(pass);
		
		ArrayList<Auser> records = null;
		
		records = (ArrayList<Auser>) Loginsql.query(user, pass);	
		

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("records", records);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		response.setContentType("text/html;chatset=UTF-8");
		System.out.println(jsonArray);
		System.out.println(jsonArray.toString());
		
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(jsonArray.toString().getBytes("UTF-8"));
		outputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
