import Facade.FacadeArchivo;
import ModeloDTO.ArchivoDTO;
import exception.ConexionException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Archivo;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

        @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
                
		
		PrintWriter writer = response.getWriter();
		try {
                         java.util.Date today = new java.util.Date();
           
			Part part = request.getPart("file");										// javax.servlet.http
			String fileName = getFileName(part);
			String type = part.getContentType();
			final int size = (int) part.getSize();

                        Archivo ar= new Archivo();
                        ar.setFName(fileName);
                        ar.setTipo(type);
                        ar.setSize(size);
                        ar.setDate(new java.sql.Timestamp(today.getTime()));
                        
			FacadeArchivo farr= new FacadeArchivo();
                        farr.save(ar);

			if (writer != null) {
				writer.close();
			}

		} catch (ConexionException ex) { 
                Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
	}


	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}