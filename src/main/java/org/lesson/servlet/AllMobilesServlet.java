package org.lesson.servlet;

import org.lesson.dao.MobileDao;
import org.lesson.pojo.Mobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(urlPatterns = "/allmobiles", name = "Mobiles")
public class AllMobilesServlet extends HttpServlet {
    @Inject
    private MobileDao mobileDao;
    private Logger logger = LoggerFactory.getLogger(AllMobilesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = null;
        try {
            mobiles = mobileDao.getAllMobile();
        } catch (SQLException e) {
            logger.error("AllMobilesServlet doGet", e);
            throw new ServletException(e);
        }
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("PageTitle", "Mobiles");
        req.setAttribute("PageBody", "allmobiles.jsp");
        req.getRequestDispatcher("/layout.jsp")
            .forward(req, resp);
    }
}
