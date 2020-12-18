package ml.salesail.inventoryOfCartridges.servlet;

import ml.salesail.inventoryOfCartridges.jdbc.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //JDBCHelper jdbcHelper = JDBCHelper.getJDBCHelper();
        req.getRequestDispatcher("jsp/index.jsp").forward(req,resp);



    }
}
