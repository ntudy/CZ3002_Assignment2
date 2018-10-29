package model;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import repository.UserRepository;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String Username;
    private String password;
 
	public String getName() {
		return Username;
	}

	public void setName(String name) {
		this.Username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		String[] params = new String[] {Username, password};
		UserRepository repo = new UserRepository();
		boolean isSuccess = repo.containsResult(params);
		if (isSuccess)
			return "success";
		else {
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("errorMsg", new String("Invalid user name or password. Please try again!"));
			stack.push(context);
			return "error";
		}
	}
	
    @Override
    public void validate() {
         if (Username == null || Username.trim().equals(""))
          {
             addFieldError("name","Please enter a username.");
          }
         if (password == null || password.trim().equals(""))
          {
             addFieldError("password","Please enter a password.");
          }
    }

}
