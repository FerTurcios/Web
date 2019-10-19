package mx.upiicsa.nn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.upiicsa.nn.bean.Direccion;
import mx.upiicsa.nn.bs.DireccionBS;


@WebServlet("/DireccionControl")
public class DireccionControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DireccionControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String calle = (String) request.getParameter("nombre.calle");
		String colonia = (String) request.getParameter("nombre.colonia");
		String Municipio = (String) request.getParameter("nombre.municipio");
		String municipio = (String) request.getParameter("nombre.municipio");
		String CodigoPostal = (String) request.getParameter("codigo.Postal");
		String numeroExterior = (String) request.getParameter("num.Ext");
		String numeroInterior = (String) request.getParameter("num.Int");
		String estado = (String) request.getParameter("nombre.estado");
		if (calle == null || calle.isEmpty()) {
			rd = request.getRequestDispatcher("Direccion.jsp");
			codigo = -1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("--->codigo++++" + codigo);
		} else {
			Direccion dir = new Direccion();
		    dir.setCalle(calle);
		    dir.setColonia(colonia);
		    dir.setMunicipio(Municipio);
		    dir.setCodigoPostal(CodigoPostal);
		    dir.setNumeroExterior(numeroExterior);
		    dir.setNumeroInterior(numeroInterior);
		    dir.setEstado(estado);
			DireccionBS dirbs = new DireccionBS();
			int resultado = dirbs.registrarDireccion(dir);
			System.out.println("--->resultado" + resultado);
			if (resultado == 1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("exito.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
		}

	}
}


/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/
