package com.cakefactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cakefactory.UserRole.UserRole;
import com.cakefactory.UserRole.UserRoleService;
import com.cakefactory.cart.Cart;
import com.cakefactory.cart.CartService;
import com.cakefactory.category.Category;
import com.cakefactory.category.CategoryService;
import com.cakefactory.product.Product;
import com.cakefactory.product.ProductService;
import com.cakefactory.user.User;
import com.cakefactory.user.UserService;

@Controller
public class cakefactoryController {
	@Autowired
	CartService cas;
	@Autowired
	ServletContext context;
	
	@Autowired
	UserRoleService urs;

	@Autowired
	UserService us;
    @Autowired
    CategoryService cs;
	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public String home() {
		UserRole r = urs.getUserRole(1);

		if (r == null) {
			UserRole urnew = new UserRole();

			urnew.setRole(1);
			urnew.setRoleName("USER");

			urs.insert(urnew);
		}

		r = urs.getUserRole(2);

		if (r == null) {
			UserRole urnew = new UserRole();

			urnew.setRole(2);
			urnew.setRoleName("ADMIN");

			urs.insert(urnew);
		}

		return ("index");

	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/head")
	public String head() {
		return "head";
	}

	@RequestMapping("/head-meta")
	public String headmeta() {
		return "head-meta";
	}

	@RequestMapping("/aboutus")
	public String aboutus() {
		return ("aboutus");
	}

	@RequestMapping("/contactus")
	public String contactus() {
		return "contactus";

	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("signup");

		mav.addObject("User", new User());

		return mav;
	}

	@RequestMapping("/plum")
	public String plum() {
		return "plum";
	}

	@RequestMapping("/blackforest")
	public String blackforest() {
		return "blackforest";
	}

	@RequestMapping("/chocolava")
	public String chocolava() {
		return "chocolava";
	}

	
	@RequestMapping("/products")
	public ModelAndView products() {
		
		ModelAndView mav = new ModelAndView("products");
		
		List<Product> list = ps.ListProducts();
		
		JSONArray jarr = new JSONArray();
		
		for( Product p : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("ProductId", p.getId());
			jobj.put("ProductName", p.getProductName());
			jobj.put("ProductDesc", p.getProductDescription());
			jobj.put("ProductCategory", p.getProductCategory());
			jobj.put("ProductPrice", p.getProductPrice());
			jobj.put("ProductQty", p.getProductQty());
			jobj.put("ProductImage", p.getProductImage());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		return mav;
	}
	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		ModelAndView mav = new ModelAndView("addproduct");
		
		mav.addObject("Product",new Product());
		
		mav.addObject("Categories", cs.ListCategory());
		
		return mav;
	}
	
	@RequestMapping("/updateproduct/{pid}")
	public ModelAndView updateproduct( @PathVariable("pid") int pid ) {
		ModelAndView mav = new ModelAndView("updateproduct");
		
		Product p = ps.getProduct(pid);
		
		mav.addObject("Product",p);
		
		mav.addObject("ProductId", p.getId());
		
		mav.addObject("Categories", cs.ListCategory());
		
		return mav;
	}
	
	@RequestMapping(value="/loginpage" , method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("login");
		
		return mav ;
	}
	
	@RequestMapping(value="/UpdateProductToDB",method=RequestMethod.POST)
	public ModelAndView UpdateProductToDB(@ModelAttribute("Product") Product p, BindingResult bind) {
		ModelAndView mav = new ModelAndView("products");
		
		//
		
		try
		{
			String path = context.getRealPath("/");
	        
	        System.out.println(path);
	        
	        File directory = null;
	        
	        if( p.getProductFile() != null )
	        if (p.getProductFile().getContentType().contains("image"))
	        {
	        	directory = new File(path + "/resources/images");
	        	
	        	System.out.println(directory);
	        	
	        	byte[] bytes = null;
	            File file = null;
	            bytes = p.getProductFile().getBytes();
	            
	            if (!directory.exists()) directory.mkdirs();
	            
	            System.out.println(p.getId());
	            
	            file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + "image_" + p.getId() + ".jpg");
	            
	            System.out.println(file.getAbsolutePath());
	            
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
	            stream.write(bytes);
	            stream.close();
	            
	            p.setProductImage("resources/images/image_" + p.getId() + ".jpg");
	            
	            //ps.update(p);
	        }
	        else
	        {
	        	p.setProductImage("resources/images/image_" + p.getId() + ".jpg");
	        }
	        
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		ps.update(p);
		
		List<Product> list = ps.ListProducts();
		
		JSONArray jarr = new JSONArray();
		
		for( Product p1 : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("ProductId", p1.getId());
			jobj.put("ProductName", p1.getProductName());
			jobj.put("ProductDesc", p1.getProductDescription());
			jobj.put("ProductCategory", p1.getProductCategory());
			jobj.put("ProductPrice", p1.getProductPrice());
			jobj.put("ProductQty", p1.getProductQty());
			jobj.put("ProductImage", p1.getProductImage());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;

	}
	
	@RequestMapping("/viewproduct/{pid}")
	public ModelAndView viewproduct(@PathVariable("pid") int pid) {
		ModelAndView mav = new ModelAndView("viewproduct");
		
		Product p = ps.getProduct(pid);
		
		if( p!=null )
		{
			mav.addObject("ProductId",p.getId());
			mav.addObject("ProductName",p.getProductName());
			mav.addObject("ProductCategory",p.getProductCategory());
			mav.addObject("ProductDesc",p.getProductDescription());
			mav.addObject("ProductQty",p.getProductQty());
			mav.addObject("ProductPrice",p.getProductPrice());
			mav.addObject("ProductImage",p.getProductImage());
			
		}
		
		
		
		return mav;
	}
	
	@RequestMapping("/deleteproduct/{pid}")
	public ModelAndView deleteproduct(@PathVariable("pid") int pid) {
		ModelAndView mav = new ModelAndView("products");
		
		ps.delete(pid);
		
List<Product> list = ps.ListProducts();
		
		JSONArray jarr = new JSONArray();
		
		for( Product p : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("ProductId", p.getId());
			jobj.put("ProductName", p.getProductName());
			jobj.put("ProductDesc", p.getProductDescription());
			jobj.put("ProductCategory", p.getProductCategory());
			jobj.put("ProductPrice", p.getProductPrice());
			jobj.put("ProductQty", p.getProductQty());
			jobj.put("ProductImage", p.getProductImage());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;
	}
	
	@RequestMapping(value = "/AddProductToDB", method = RequestMethod.POST)
	public ModelAndView AddProductToDB(@ModelAttribute("Product") Product p, BindingResult bind) {
		ModelAndView mav = new ModelAndView("products");
		
		ps.insert(p);
		
		Product pi = ps.getProductWithMaxId();
		
		//
		
		try
		{
			String path = context.getRealPath("/");
	        
	        System.out.println(path);
	        
	        File directory = null;
	        
	        if (p.getProductFile().getContentType().contains("image"))
	        {
	        	directory = new File(path + "/resources/images");
	        	
	        	System.out.println(directory);
	        	
	        	byte[] bytes = null;
	            File file = null;
	            bytes = p.getProductFile().getBytes();
	            
	            if (!directory.exists()) directory.mkdirs();
	            
	            file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + "image_" + pi.getId() + ".jpg");
	            
	            System.out.println(file.getAbsolutePath());
	            
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
	            stream.write(bytes);
	            stream.close();
	            
	            pi.setProductImage("resources/images/image_" + pi.getId() + ".jpg");
	            
	            ps.update(pi);
	        }
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		//
		
		List<Product> list = ps.ListProducts();
		
		JSONArray jarr = new JSONArray();
		
		for( Product p1 : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("ProductId", p1.getId());
			jobj.put("ProductName", p1.getProductName());
			jobj.put("ProductDesc", p1.getProductDescription());
			jobj.put("ProductCategory", p1.getProductCategory());
			jobj.put("ProductPrice", p1.getProductPrice());
			jobj.put("ProductQty", p1.getProductQty());
			jobj.put("ProductImage", p1.getProductImage());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;
	}
	

	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public ModelAndView AddUser(@Valid @ModelAttribute("User") User i, BindingResult bind) {
		ModelAndView mav = new ModelAndView("signup");

		if (bind.hasErrors()) {
			System.out.println("Bind Errors");
			mav.addObject("User", i);
		}

		else {
			if (i.getPassword().equals(i.getCPassword())) {
				

				List<User> list = us.ListUser();
				boolean usermatch = false;

				for (User u : list) {
					System.out.println(u.getUsername());
					System.out.println(i.getUsername());

					if (u.getUsername().equals(i.getUsername())) {
						usermatch = true;
						break;
					}
				}

				if (usermatch == false) {
					us.insert(i);

					mav.addObject("User", new User());

					mav.addObject("success", "User Created Successfully");
				} else {
					mav.addObject("User", i);

					mav.addObject("error", "User Already Exists");
				}
			} else {
				mav.addObject("User", i);

				mav.addObject("error", "Password Mismatch");
			}
		}

		return mav;
	}
	
	@RequestMapping("/category")
	public ModelAndView category() {
		ModelAndView mav =new ModelAndView("category");
		List<Category> list = cs.ListCategory();
		JSONArray jarr = new JSONArray();
		
		if(list!=null)
		for( Category c : list )
		{
			JSONObject jobj = new JSONObject();
			jobj.put("CategoryId", c.getId());
			jobj.put("CategoryName", c.getCategoryName());
			
			jarr.add(jobj);
		}
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		return mav;
	}
	@RequestMapping("/addcategory")
	public ModelAndView addcategory() {
		ModelAndView mav = new ModelAndView("addcategory");
		
		mav.addObject("Category",new Category());
		
		return mav;
	}
	@RequestMapping("/updatecategory/{cid}")
	public ModelAndView updatecategory( @PathVariable("cid") int cid ) {
		ModelAndView mav = new ModelAndView("updatecategory");
		
		Category c = cs.getCategory(cid);
		
		mav.addObject("Category",c);
		
		mav.addObject("CategoryId",c.getId());
		
		return mav;
	}
	
	@RequestMapping("/viewcategory/{cid}")
	public ModelAndView viewcategory(@PathVariable("cid") int cid) {
		ModelAndView mav = new ModelAndView("viewcategory");
		
		Category c = cs.getCategory(cid);
		
		if( c!=null )
		{
			mav.addObject("CategoryId",c.getId());
			mav.addObject("CategoryName",c.getCategoryName());
			
		}
		
		
		
		return mav;
	}
	
	@RequestMapping("/deletecategory/{cid}")
	public ModelAndView deletecategory(@PathVariable("cid") int cid) {
		ModelAndView mav = new ModelAndView("category");
		
		Category curr = cs.getCategory(cid);
		
		List<Product> plist = ps.ListProducts();
		
		for( Product p : plist )
		{
			if( p.getProductCategory().equals(curr.getCategoryName()) )
			{
				p.setProductCategory("-");
				ps.update(p);
			}
		}
		
		cs.delete(cid);
		
List<Category> list = cs.ListCategory();
		
		JSONArray jarr = new JSONArray();
		
		for( Category c : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("CategoryId", c.getId());
			jobj.put("CategoryName", c.getCategoryName());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;
	}

	@RequestMapping(value="/UpdateCategoryToDB",method=RequestMethod.POST)
	public ModelAndView UpdateCategoryToDB(@ModelAttribute("Category") Category c, BindingResult bind) {
		ModelAndView mav = new ModelAndView("category");
		
		Category curr = cs.getCategory(c.getId());
		
		List<Product> plist = ps.ListProducts();
		
		for( Product p : plist )
		{
			if( p.getProductCategory().equals(curr.getCategoryName()) )
			{
				p.setProductCategory(c.getCategoryName());
				ps.update(p);
			}
		}
		
		cs.update(c);
		
		List<Category> list = cs.ListCategory();
		
		JSONArray jarr = new JSONArray();
		
		for( Category c1 : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("CategoryId", c1.getId());
			jobj.put("CategoryName", c1.getCategoryName());
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;

	}
	@RequestMapping(value = "/AddCategoryToDB", method = RequestMethod.POST)
	public ModelAndView AddCategoryToDB(@ModelAttribute("Category") Category c, BindingResult bind) {
		ModelAndView mav = new ModelAndView("category");
		
		cs.insert(c);
		
		Category ci = cs.getCategoryWithMaxId();
		
		
		
		List<Category> list = cs.ListCategory();
		
		JSONArray jarr = new JSONArray();
		
		if(list!=null)
		for( Category c1 : list )
		{
			JSONObject jobj = new JSONObject();
			
			//{"ProductId":"1","ProductName":"Vasudev","ProductDesc":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQty":"10","ProductImage":"#"},
			
			jobj.put("CategoryId", c1.getId());
			jobj.put("CategoryName", c1.getCategoryName());
			
			
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		mav.addObject("JSONData", jarr.toJSONString());
		
		
		return mav;
	}
	@RequestMapping("/page1")
	public String page1() {
		return "page1";
	}
	@RequestMapping("/page2")
	public String page2() {
		return "page2";
	}
	@RequestMapping("/page3")
	public String page3() {
		return "page3";
	}
	@RequestMapping("/page4")
	public String page4() {
		return "page4";
	}
	public String test()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	
	    	return "false";
	    }
	    else
	    {
	    	
	    	return "true";
	    }
	}
	@RequestMapping(value="/addToCart")	
	public String addToCart( HttpServletRequest request )
	{	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	System.out.println(request.getParameter("pid"));
			System.out.println(request.getParameter("pqty"));
			
			int qty = 1;
			
			try
			{
				qty = Integer.parseInt(request.getParameter("pqty"));
				
				if( !(qty >= 1 && qty <= 10) )
					throw new Exception();
			}
			catch(Exception e)
			{
				System.out.println("Invalid Qty");
			}
			
			Cart c = new Cart();
			
			c.setProductID(request.getParameter("pid"));
			c.setQty(""+qty);
			
			Product p = ps.getProduct( Integer.parseInt(request.getParameter("pid")) );
			
			c.setName(p.getProductName());
			c.setPrice(p.getProductPrice());
			
			c.setUserName(auth.getName());
			
			cas.add(c);
			
			
	    }
	    
	    return "redirect:initiateFlow";
	    
	}
	
	@RequestMapping(value="/initiateFlow" , method = RequestMethod.GET)
	public String redirect(HttpServletRequest request){
		
		String retval = "";
		
		if( request.getUserPrincipal() == null )
			retval = "redirect:/cart?user=none";
		else
			retval = "redirect:/cart?user="+request.getUserPrincipal().getName();
			
		return retval;
	}
}
