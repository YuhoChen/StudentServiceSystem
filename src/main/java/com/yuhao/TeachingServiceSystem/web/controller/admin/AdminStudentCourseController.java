package com.yuhao.TeachingServiceSystem.web.controller.admin;


import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.yuhao.TeachingServiceSystem.common.UserType;
import com.yuhao.TeachingServiceSystem.dao.CourseDAO;
import com.yuhao.TeachingServiceSystem.dto.CourseDTO;
import com.yuhao.TeachingServiceSystem.dto.StudentDTO;
import com.yuhao.TeachingServiceSystem.dto.UserDTO;
import com.yuhao.TeachingServiceSystem.exception.BizException;
import com.yuhao.TeachingServiceSystem.model.Course;
import com.yuhao.TeachingServiceSystem.service.CourseService;
import com.yuhao.TeachingServiceSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuhao.TeachingServiceSystem.util.Page;
import com.yuhao.TeachingServiceSystem.dto.StudentCourseDTO;
import com.yuhao.TeachingServiceSystem.service.StudentCourseService;
import com.yuhao.TeachingServiceSystem.web.controller.BaseController;


@Controller
@RequestMapping(value = "/admin/studentCourse", produces="text/html;charset=UTF-8")
public class AdminStudentCourseController extends BaseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDAO courseDAO;


    @RequestMapping(value = "/detail")
    public String detail(Map<String, Object> map, Long id) {
        if (id != null) {
            StudentCourseDTO dto = studentCourseService.load(id);
            System.out.println(dto);
//            String msg = dto.getCourseDate();
//            StringBuffer show = new StringBuffer();
//            if(msg!=null){
//                String[] datemsg = msg.split(";");
//                for(int i=0;i<datemsg.length;i++){
//                    if(datemsg[i].charAt(2)=='0'){
//                        show.append("双周");
//                    }else if(datemsg[i].charAt(2)=='1'){
//                        show.append("单周");
//                    }else{
//                        show.append("单双周");
//                    }
//                    if(datemsg[i].charAt(0)=='0'){
//                        show.append("周日");
//                    }else if(datemsg[i].charAt(0)=='1'){
//                        show.append("周一");
//                    }else if(datemsg[i].charAt(0)=='2'){
//                        show.append("周二");
//                    }else if(datemsg[i].charAt(0)=='3'){
//                        show.append("周三");
//                    }else if(datemsg[i].charAt(0)=='4'){
//                        show.append("周四");
//                    }else if(datemsg[i].charAt(0)=='5'){
//                        show.append("周五");
//                    }else if(datemsg[i].charAt(0)=='6'){
//                        show.append("周六");
//                    }
//                    if(datemsg[i].charAt(1)=='1'){
//                        show.append("1~2节");
//                    }else if(datemsg[i].charAt(1)=='2'){
//                        show.append("3~4节");
//                    }else if(datemsg[i].charAt(1)=='3'){
//                        show.append("5~6节");
//                    }else if(datemsg[i].charAt(1)=='4'){
//                        show.append("7~8节");
//                    }else if(datemsg[i].charAt(1)=='5'){
//                        show.append("9~11节");
//                    }
//                    if(i!=datemsg.length-1){
//                        show.append("/");
//                    }
//                }
//            }
//            map.put("msg",show);
            map.put("n", dto);
        }
        return "admin/studentCourse/studentCourse_detail";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(StudentCourseDTO dto) throws Exception {
        if (dto.getId() == null) {
            studentCourseService.create(dto);
        } else {
            throw new RuntimeException("请实现更新逻辑，并删除该行");
            /*
            StudentCourseDTO old = studentCourseService.load(dto.getId());
            // 确定哪些字段是在详情页面需要修改的，不在详情页修改的，就不需要在这里set值。updated和updatedBy不需要在这里处理，框架会统一处理
            old.setId(dto.getId());
            old.setStudentNumber(dto.getStudentNumber());
            old.setCourseNumber(dto.getCourseNumber());
            old.setScore(dto.getScore());
            studentCourseService.updateAllFields(old);
            */
        }
        return ok();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String delete(Long[] ids) throws IOException {
        studentCourseService.deleteByIds(ids);
        return ok();
    }

    @RequestMapping(value = "/list")
    public String list(CourseDTO dto, Boolean search, Map<String, Object> map, Page page) {
        List<CourseDTO> dtos = courseService.find(dto, page);
        List<CourseDTO> list=studentCourseService.findIn(getCurrentUserDTO());
        for (CourseDTO c:dtos) {
            for (CourseDTO c1:list) {
                if (c.getCourseNumber().equals(c1.getCourseNumber())){
                    c.setSelected(true);
                    break;
                }
            }
        }
        map.put("list", dtos);
        map.put("query", dto);
        map.put("search", search);
        map.put("page",page);
        return "admin/studentCourse/studentCourse_list";
    }
    @RequestMapping(value = "/result")
    public String result(CourseDTO dto, Boolean search, Map<String, Object> map, Page page){

        List<CourseDTO> list=studentCourseService.findIn(getCurrentUserDTO());
        map.put("list", list);
        map.put("query", dto);
        map.put("search", search);
        map.put("page",page);
        return "admin/studentCourse/studentCourse_result";
    }

    @RequestMapping(value = "/syllabus")
    public String syllabus(Map<String, Object> map){

        List<CourseDTO> list=studentCourseService.findIn(getCurrentUserDTO());


        List<CourseDTO[]> CourseAll=new ArrayList<CourseDTO[]>();
        List<CourseDTO[]> CourseSingle=new ArrayList<CourseDTO[]>();
        List<CourseDTO[]> CourseDouble=new ArrayList<CourseDTO[]>();
        for (int i = 0; i < 5; i++) {
            CourseAll.add(new CourseDTO[7]);
            CourseSingle.add(new CourseDTO[7]);
            CourseDouble.add(new CourseDTO[7]);
        }


        for (CourseDTO dto:list) {
            if (dto.getCourseDate()!=null){
                for (String s:dto.getCourseDate().split(";")) {
                    int index=Integer.parseInt(s.charAt(1)+"")-1;
                    if("2".equals(s.charAt(2)+"")){
                        if(CourseAll.get(index)==null){
                            CourseDTO[] courseDTOS=new CourseDTO[7];
                            courseDTOS[Integer.parseInt(s.charAt(0)+"")]=dto;
                            CourseAll.set(Integer.parseInt(index+""),courseDTOS);
                        }else {
                            CourseAll.get(index)[Integer.parseInt(s.charAt(0)+"")]=dto;
                        }

                    }else if("1".equals(s.charAt(2)+"")){

                        if(CourseSingle.get(index)==null){

                            CourseDTO[] courseDTOS=new CourseDTO[7];

                            courseDTOS[Integer.parseInt(s.charAt(0)+"")]=dto;

                            CourseSingle.set(Integer.parseInt(s.charAt(1)+""),courseDTOS);

                        }else {
                            CourseSingle.get(index)[Integer.parseInt(index+"")]=dto;

                        }

                    }else if("0".equals(s.charAt(2)+"")){

                        if(CourseDouble.get(index)==null){

                            CourseDTO[] courseDTOS=new CourseDTO[7];

                            courseDTOS[Integer.parseInt(s.charAt(0)+"")]=dto;

                            CourseDouble.set(Integer.parseInt(s.charAt(1)+""),courseDTOS);
                        }else {
                            CourseDouble.get(index)[Integer.parseInt(index+"")]=dto;

                        }
                    }

                }

            }

        }


        map.put("CourseAll", CourseAll);
        map.put("CourseSingle", CourseSingle);
        map.put("CourseDouble", CourseDouble);



        return "admin/studentCourse/studentCourse_syllabus";
    }







    @ResponseBody
    @RequestMapping(value = "/elective")
    public String elective(Long id){

        UserDTO userDTO=getCurrentUserDTO();

        if (userDTO==null||userDTO.getType()!= UserType.STUDENT.getValue()){
            throw new BizException("不是学生，不能选课");
        }

        List<CourseDTO> list=studentCourseService.findIn(getCurrentUserDTO());

        Course course=courseDAO.load(id);

        for (String s:course.getCourseDate().split(";")) {

            for (CourseDTO dto:list) {

                for (String ss:dto.getCourseDate().split(";")) {

                    char s1=s.charAt(1);
                    char ss1=ss.charAt(1);

                    if (s1==ss1){

                        if (s.charAt(2)=='2'){

                            throw new BizException("课程冲突，不能选课!");

                        }
                        else if(s.charAt(1)==ss.charAt(1)){
                            throw new BizException("课程冲突，不能选课!");
                        }
                    }

                }

            }

        }


        studentCourseService.updateElective(id,userDTO);


        return ok();
    }

    @ResponseBody
    @RequestMapping(value = "/retreat")
    public String retreat(Long id){

        studentCourseService.deleteElective(getCurrentUserDTO(),id);

        return ok();
    }




}  
