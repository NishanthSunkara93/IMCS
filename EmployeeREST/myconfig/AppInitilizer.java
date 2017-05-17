import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

public class AppInitilizer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(AppConfig.class);
		webApplicationContext.setServletContext(servletContext);
		webApplicationContext.refresh();
		Dynamic dynamic = (Dynamic) servletContext.addServlet("MySpringRESTWS", new DispatcherServlet(webApplicationContext));
		((ServletRegistration) dynamic).addMapping("/");
		((javax.servlet.ServletRegistration.Dynamic) dynamic).setLoadOnStartup(1);
		((javax.servlet.ServletRegistration.Dynamic) dynamic).setMultipartConfig(webApplicationContext.getBean(MultipartConfigElement.class));
	}
}
