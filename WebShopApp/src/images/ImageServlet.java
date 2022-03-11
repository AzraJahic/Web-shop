package images;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		response.setContentType("image/gif");             
		ServletOutputStream sos = response.getOutputStream();	// for binary stream of image file
			 
			  File f = new File(this.getImagePath(imageName));
		      System.out.println(f.getAbsolutePath());
		      DataInputStream dis = new DataInputStream(new FileInputStream(f));
		      byte[] barray = new byte[(int) f.length()];
		      
		      try 
		      { 
		        dis.readFully(barray);           // now the array contains the image
		      }
		      catch (Exception e) 
		      { 
		        barray = null; 
		      }
		      finally 
		      { 
		        dis.close( ); 
		      }
		      
		      sos.write(barray);                 // send the byte array to client
		      sos.close();
	}
	        
	public String getImagePath(String imageName) {
		return System.getProperty("user.home") + "\\eclipse-workspace\\WebShopApp\\src\\images\\" + imageName;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
