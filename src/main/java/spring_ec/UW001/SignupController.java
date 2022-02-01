package spring_ec.UW001;

import java.util.Map;

import javax.persistence.PostRemove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_ec.UW001.Service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {
	
	Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserApplicationService service;
	
	//���[�U�[�o�^��ʂ�\��
	@GetMapping("/signup")
	public String getSingup(Model model) {
		log.info("get: singup");
		//���ʂ��擾
		Map<String, Integer> genderMap = service.getGenderMap();
		model.addAllAttributes(genderMap);
		
		//���[�U�[�ɑJ��
		return "user/signup";
	}
	
	//���[�U�[�o�^��ʂɑJ��
	@PostMapping("/signup")
	public String postSignup() {
		log.info("post: singup");
		//���O�C����ʂɃ��_�C���N�g(PRG)
		return "redirect:/login";
	}

}
