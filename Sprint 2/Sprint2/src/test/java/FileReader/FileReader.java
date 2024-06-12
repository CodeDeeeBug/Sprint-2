package FileReader;

import java.io.*;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.cucumber.datatable.DataTable;

public class FileReader {
	
	public String properties(String str) throws Exception {
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\DSHATRUG\\Desktop\\Sprint 2\\Sprint2\\src\\test\\resources\\Others\\doc.properties"));
		Properties p=new Properties();
		p.load(fis);
		String st=null;
		switch(str) {
		case "BaseURL":
			st=p.getProperty("BaseURL");
			break;
		case "Username":
			st=p.getProperty("Username");
			break;
		case "Password":
			st=p.getProperty("Password");
			break;
		case "Authorize":
			st=p.getProperty("Authorize");
			break;
		case "Token":
			st=p.getProperty("Token");
			break;
		case "BaseURLSpring":
			st=p.getProperty("BaseURLSpring");
			break;
		case "GetAllEmployee":
			st=p.getProperty("GetAllEmployee");
			break;
		case "CreateEmployee":
			st=p.getProperty("CreateEmployee");
			break;
		case "GetSingleEmployee":
			st=p.getProperty("GetSingleEmployee");
			break;
		case "PutSingleEmployee":
			st=p.getProperty("PutSingleEmployee");
			break;	
		case "DeleteEmployee":
			st=p.getProperty("DeleteEmployee");
			break;
		case "BaseURLDummy":
			st=p.getProperty("BaseURLDummy");
			break;
		case "GetAllPosts":
			st=p.getProperty("GetAllPosts");
			break;
		case "GetSinglePost":
			st=p.getProperty("GetSinglePost");
			break;
		case "CreatePost":
			st=p.getProperty("CreatePost");
			break;
		case "UpdatePostPatch":
			st=p.getProperty("UpdatePostPatch");
			break;
		case "UpdatePostPut":
			st=p.getProperty("UpdatePostPut");
			break;
		case "DeletingPost":
			st=p.getProperty("DeletingPost");
			break;
		
		}
		return st;
	}

	public JSONObject authorize(DataTable dataTable) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject generateToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
