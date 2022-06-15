package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    /**
     * String을 반환하는 경우 - View or HTTP 메시지
     * @ResponseBody 가 없으면
     * response/hello 로 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링 한다.
     * @ResponseBody 가 있으면
     * 뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 response/hello 라는 문자가 입력된다.
     * @RestController 도 마찬가지. view를 찾지 않고 그냥 문자 그대로 나가버린다.
     */

    @RequestMapping("/response-view-v2")
    public  String responseViewV2(Model model) {
        Model data = model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
