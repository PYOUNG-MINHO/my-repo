package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.Forward;
import bean.Product;
import dao.ProductDao;

public class ProductMM {
	HttpServletRequest request;
	HttpServletResponse response;
	Forward fw = null;
	
	public ProductMM(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	
	

	public String getAjaxduplicateID(String ID) {
		
		String test = "";
		ProductDao pDao = new ProductDao();
		test=pDao.getDuplicateID(ID);
		
		pDao.close();
		
		Gson gs = new Gson();
		
		
		String showinfo = gs.toJson(test);
		
		return showinfo;
		
	}

//----------예상-------------------------------------------------------------------------------------------
	
	
public Forward searchHouse() {
		
	
		String destination = request.getParameter("destination");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String person = request.getParameter("person");
		
		String searchHouse = null;
		
		ProductDao pDao = new ProductDao();
		
		searchHouse = pDao.searchHouse(destination,checkin,checkout,person);
		
		pDao.close();
		
		
		request.setAttribute("result",searchHouse);
		request.setAttribute("destination",destination);
		fw = new Forward();
		fw.setPath("./SearchDetail.jsp");
		fw.setRedireact(false);
		return fw;
	}
	
	
	
	
	public String getAjaxchangeSearch() {
		String destination = request.getParameter("data");
		System.out.println(destination);
		
		
		String searchHouse = null;
		
		ProductDao pDao = new ProductDao();
		
		searchHouse = pDao.searchHouse(destination);
		
		pDao.close();
		
		
		return searchHouse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//---------------------------동원-------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------민호-------------------------------------------------------------------------------------------
	public Forward detailregiinfo(){
		
		String detailId = request.getParameter("id");
		System.out.println(detailId);
		String detailregiinfo = null;
		
		ProductDao pDao = new ProductDao();
		
		detailregiinfo = pDao.detailregiinfo(detailId);
		
		pDao.close();
		
		
		request.setAttribute("result",detailregiinfo);
		
		fw = new Forward();
		fw.setPath("./detail&reservation.jsp");
		fw.setRedireact(false);
		return fw;
		
		
		
	}



	






	
}
