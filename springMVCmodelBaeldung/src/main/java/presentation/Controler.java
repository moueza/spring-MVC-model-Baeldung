package presentation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;/**spring-webmvc*/
import org.springframework.web.bind.annotation.GetMapping;

/** http://www.baeldung.com/spring-mvc-model-model-map-model-view */
public class Controler {
	/** Solution 1of3 Model param */
	@GetMapping("/showViewPage")
	public String passParametersWithModel(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("spring", "mvc");
		model.addAttribute("message", "Baeldung");
		model.mergeAttributes(map);
		return "viewPage";
	}

	/** Solution 2of3 ModelMap param */
	@GetMapping("/printViewPage")
	public String passParametersWithModelMap(ModelMap map) {
		map.addAttribute("welcomeMessage", "welcome");
		map.addAttribute("message", "Baeldung");
		return "viewPage";
	}

	/**
	 * Solution 3of3 ModelMap param /**Solution 2of2 ModelMap param
	 */
	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
		ModelAndView modelAndView = new ModelAndView("viewPage");
		modelAndView.addObject("message", "Baeldung");
		return modelAndView;
	}
}
