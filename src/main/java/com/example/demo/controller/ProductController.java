package com.example.demo.controller;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        switch (action) {
            case "list-product":
                session.setAttribute("products", productService.getAllProducts());
                resp.sendRedirect("listProduct.jsp");
                break;
            case "update-product":
                String id = req.getParameter("id");
                Product product = productService.findById(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("create.jsp").forward(req, resp);
                break;
            case "delete-product":
                String id1 = req.getParameter("id");
                productService.removeProduct(id1);
                resp.sendRedirect("product?action=list-product");
                break;
            case "create-product":
                resp.sendRedirect("create.jsp");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        switch (action) {
            case "create-product":
                String id = req.getParameter("productID");
                String name = req.getParameter("productName");

                String description = req.getParameter("description");
                String manufacturer = req.getParameter("manID");
                Product product = new Product(id, name, description);
                product.setManufacturer(new Manufacturer(manufacturer));

                productService.addProduct(product);
                resp.sendRedirect("product?action=list-product");
                break;
            case "update-product":
                String id1 = req.getParameter("productID");
                String name1 = req.getParameter("productName");
                String description1 = req.getParameter("description");
                Product product1 = new Product(id1, name1, description1);
                productService.updateProduct(product1);
                resp.sendRedirect("product?action=list-product");
                break;
        }
    }
}
