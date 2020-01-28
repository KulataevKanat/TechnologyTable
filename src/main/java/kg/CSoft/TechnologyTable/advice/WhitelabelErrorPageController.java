package kg.CSoft.TechnologyTable.advice;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WhitelabelErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        if (referrer != null && referrer.contains("/admin")) {
            return "/admin/index.html";
        }
        return "/index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

