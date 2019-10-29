package com.songchunhao.comon;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@ControllerAdvice
public class CmsControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(value = CmsExceptionJson.class)       
	//使用@ExceptionHandler修饰后会作用在所有的@RequestMapping上。
	public ResultMsg myErrorHandler(CmsExceptionJson ex) {
	    return new ResultMsg(ex.hashCode(), ex.getMessage(), "");
	}
	
	/**
	 * 错误提示
	 * @param ex
	 * @return
	 */
    @ExceptionHandler(value = CmsExceptionView.class)
    public ModelAndView myErrorHandler(CmsExceptionView ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("code", ex.hashCode());
        modelAndView.addObject("msg", ex.getMessage());
        return modelAndView;
    }
}
