package com.dengguoxian.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dengguoxian.model.Product;
import com.dengguoxian.model.ProductForm;
import com.dengguoxian.validator.ProductValidator;

public class SaveProductController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		com.dengguoxian.model.ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		ProductValidator productValidator=new ProductValidator();
		List<String> errors=productValidator.validate(productForm);
		if(errors.isEmpty()){
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			//这里可以做一些插入数据库的操作
			
			//这里讲product保存在request中，可以用来视图的显示。
			request.setAttribute("product", product);
			return "/jsp/ProductDetails.jsp";
		}else{
			request.setAttribute("errors", errors);
			request.setAttribute("form", productForm);
			return "/jsp/ProductForm.jsp";
		}

	}
}
