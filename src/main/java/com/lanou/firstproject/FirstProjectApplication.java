package com.lanou.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	List<Map<String,String>> list=new ArrayList();
	@RequestMapping("/")
	public ModelAndView zf(){
		ModelAndView modelAndView=new ModelAndView("zhuce");
		return modelAndView;
	}
	@RequestMapping("/zhuce1")
	public ModelAndView zhuce1(String username,String password){
		System.out.println(username+password);
		Map<String,String> map=new HashMap<>();
		map.put("username",username);
		map.put("password",password);
		list.add(map);
		System.out.println(map);
		ModelAndView modelAndView=new ModelAndView("index");
		return modelAndView;
	}
	@RequestMapping("login")
	public ModelAndView login(String username,String password){
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("username")+" "+list.get(i).get("password"));
		}
		if(username!=""){
			for(Map<String,String> map:list) {
				/*if(map.containsKey(username)){
					System.out.println("111");
					if((map.get("password")).equals(password)){
						ModelAndView modelAndView=new ModelAndView("hello");
						modelAndView.addObject("username",username);
						modelAndView.addObject("password",password);
						return modelAndView;
					}else {
						ModelAndView modelAndView=new ModelAndView("index");
						System.out.println("123");
						return modelAndView;
					}
				}else {
					System.out.println("222");
					ModelAndView modelAndView=new ModelAndView("index");
					return modelAndView;
				}*/
				if(username.equals(map.get("username"))&&password.equals(map.get("password"))){
					ModelAndView modelAndView=new ModelAndView("hello");
					modelAndView.addObject("username",username);
					modelAndView.addObject("password",password);
					return modelAndView;
				}else{
					ModelAndView modelAndView=new ModelAndView("index");
					return modelAndView;
				}
			}
		}else{
			System.out.println("444444444444444");
			System.out.println(list);
			ModelAndView modelAndView=new ModelAndView("hello");
			modelAndView.addObject("username",username);
			modelAndView.addObject("list",list);
			return modelAndView;
		}

		return null;
	}

	@RequestMapping("helloworld")
	@ResponseBody
	public String helloworld(String name){
		return name+"是牛逼";
	}
	@RequestMapping("helloSpringBoot")
	public ModelAndView helloSpringBoot(String username,String password){
		ModelAndView modelAndView=new ModelAndView("hello");
		//modelAndView.setViewName("hello");
		List<Map<String, Object>> list=new ArrayList();
		for(int i=0;i<10;i++){
			Map<String,Object> person = new HashMap<>();
			person.put("name","张三"+ i+1);
			person.put("age",10+i+1);
			list.add(person);
		}

		modelAndView.addObject("username",username);
		modelAndView.addObject("password",password);
		modelAndView.addObject("list",list);
		return modelAndView;

	}
}

