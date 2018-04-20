package com.bookadvisor.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookadvisor.dao.FichaLibroDAOImplementation;
import com.bookadvisor.dao.model.FichaLibro;

@WebServlet("/CreateFichaServlet")
public class CreateFichaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		String editorial = req.getParameter("editorial");
		String ISBN = req.getParameter("ISBN");
		String formato = req.getParameter("formato");
		String categoria = req.getParameter("categoria");
		String fecha = req.getParameter("fecha");
		Image imagen = req.getParameter("portada");
		String fecha = req.getParameter("reseñaEditorial");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRENCH);
		
		try {
			Date date = df.parse(fecha);
			FichaLibro libro = new FichaLibro()
									.setAutor(autor)
									.setTitulo(titulo)
									.setEditorial(editorial)
									.setISBN(ISBN)
									.setFormato(formato)
									.setCategoria(categoria)
									.setDate(date);
									.setImage(imagen);
			
			FichaLibroDAOImplementation.getInstance().create(libro);
			resp.sendRedirect(req.getContextPath() + "/Login.jsp");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
