package com.dengguoxian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dengguoxian.model.Product;
import com.dengguoxian.model.ProductForm;

public class SaveProductController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		com.dengguoxian.model.ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		// 创建model对象
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (NumberFormatException e) {
			System.out.println("输入的价格有误");
		}
		//insert code to add product to the database;
		request.setAttribute("product", product);
		return "/jsp/ProductDetails.jsp";
	}
}
