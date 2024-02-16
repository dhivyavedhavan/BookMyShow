package com.springproject.bookmyshow.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.dto.Admindto;
import com.springproject.bookmyshow.boot.entity.Admin;

public class Adminservice {
	@Autowired
	Admindao adao;
	
	Admindto adto= new Admindto();
	ModelMapper mapper =new  ModelMapper();
	
	public ResponseEntity<Responsestruture<Admindto>> saveAdmin(Admin admin){
		Responsestruture<Admindto> structure=new Responsestruture<Admindto>();
		structure.setMessage("Save data sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(adto);
		return new ResponseEntity<Responsestruture<Admindto>>(structure, HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestruture<Admindto>> findAdmin(int aId)
	{
		Responsestruture<Admindto> str= new Responsestruture<Admindto>();
		Admin a = adao.findadmin(aId);
		if(a!=null)
		{
			mapper.map(a, adao);
			
			str.setMessage(a.getAdminname()+"Admin has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(adto);
			
			return new  ResponseEntity<Responsestruture<Admindto>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Admindto>> deleteAdmin(int aId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Admindto> str=new Responsestruture<Admindto>();
			Admin a=adao.findadmin(aId);
			if(a!=null)
			{
				mapper.map(adao.deleteadmin(aId), adao);
				
				str.setMessage(a.getAdminname()+"Admin ha Deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(adto);
				
				return new ResponseEntity<Responsestruture<Admindto>>(str,HttpStatus.OK);
				
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Admindto>> updateAdmin(Admin admin,int aId,String aEmail,String aPassword)
	{
		Admin exa = adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Admindto> str= new Responsestruture<Admindto>();
			Admin a=adao.findadmin(aId);
			if(a!=null)
			{
				mapper.map(adao.updateadmin(admin, aId), adto);
				
				str.setMessage(admin.getAdminname()+"Admin has Updated");
				str.setStatus(HttpStatus.OK.value());
				str.setData(adto);
				
				return new ResponseEntity<Responsestruture<Admindto>>(str,HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<List<Admindto>>> findAllAdmin()
	{
		List<Admin>  adList = adao.findAllAdmin();
		List<Admindto> aDtoList =new ArrayList<Admindto>();
		if(! adList.isEmpty())
		{
			for(Admin a : adList  )
			{
				mapper.map(a,adto);
				aDtoList.add(adto);
			}
			Responsestruture<List<Admindto>> str = new Responsestruture<List<Admindto>>();
			str.setMessage("All Admin's are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(aDtoList);
			return new ResponseEntity<Responsestruture<List<Admindto>>>(str,HttpStatus.FOUND);
		}
		return null ;
	}
	
	

}
