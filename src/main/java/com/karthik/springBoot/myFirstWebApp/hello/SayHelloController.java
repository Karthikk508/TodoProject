package com.karthik.springBoot.myFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

//"say-hello" => "Hello,what are you learning today?"
//
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {

		return "Hello,what are you learning today?";

	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public StringBuffer sayHelloHtml() {

		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> Html page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("I am a html page");
		sb.append("</body>");
		sb.append("</html>");

		return sb;
	}

    //// \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    //// \src\main\resources\META-INF\resources\WEB-INF\jsp\welcome.jsp

	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {

		return "sayHello";

	}

}















//
//// "say-hello" => "Hello,what are you learning today?"
//
//@RequestMapping("say-hello")
//@ResponseBody
//public String sayHello() {
//	
//	return "Hello,what are you learning today?";
//	
//	
//}
//
//@RequestMapping("say-hello-html")
//@ResponseBody
//public StringBuffer sayHelloHtml() {
//	
//	StringBuffer sb = new StringBuffer();
//	
//	sb.append("<html>");
//	sb.append("<head>");
//	sb.append("<title> Html page </title>");
//	sb.append("</head>");
//	sb.append("<body>");
//	sb.append("I am a html page");
//	sb.append("</body>");
//	sb.append("</html>");
//	
//	return sb;
//}
//
//// \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
//// \src\main\resources\META-INF\resources\WEB-INF\jsp\welcome.jsp
//
//@RequestMapping("say-hello-jsp")
//public String sayHelloJsp() {
//	
//	return "sayHello";
//}