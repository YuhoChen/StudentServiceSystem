package com.yuhao.TeachingServiceSystem.web.controller.admin;


import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuhao.TeachingServiceSystem.util.Page;
import com.yuhao.TeachingServiceSystem.dto.CourseDTO;
import com.yuhao.TeachingServiceSystem.service.CourseService;
import com.yuhao.TeachingServiceSystem.web.controller.BaseController;


@Controller
@RequestMapping(value = "/admin/course", produces="text/html;charset=UTF-8")
public class AdminCourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/detail")
    public String detail(Map<String, Object> map, Long id) {
        if (id != null) {
            CourseDTO dto = courseService.load(id);

            System.out.println(dto);
            String msg = dto.getCourseDate();
            StringBuffer show = new StringBuffer();
            if(msg!=null){
                String[] datemsg = msg.split(";");
                for(int i=0;i<datemsg.length;i++){
                    if(datemsg[i].charAt(2)=='0'){
                        show.append("双周");
                    }else if(datemsg[i].charAt(2)=='1'){
                        show.append("单周");
                    }else{
                        show.append("单双周");
                    }
                    if(datemsg[i].charAt(0)=='0'){
                        show.append("周日");
                    }else if(datemsg[i].charAt(0)=='1'){
                        show.append("周一");
                    }else if(datemsg[i].charAt(0)=='2'){
                        show.append("周二");
                    }else if(datemsg[i].charAt(0)=='3'){
                        show.append("周三");
                    }else if(datemsg[i].charAt(0)=='4'){
                        show.append("周四");
                    }else if(datemsg[i].charAt(0)=='5'){
                        show.append("周五");
                    }else if(datemsg[i].charAt(0)=='6'){
                        show.append("周六");
                    }
                    if(datemsg[i].charAt(1)=='1'){
                        show.append("1~2节");
                    }else if(datemsg[i].charAt(1)=='2'){
                        show.append("3~4节");
                    }else if(datemsg[i].charAt(1)=='3'){
                        show.append("5~6节");
                    }else if(datemsg[i].charAt(1)=='4'){
                        show.append("7~8节");
                    }else if(datemsg[i].charAt(1)=='5'){
                        show.append("9~11节");
                    }
                    if(i!=datemsg.length-1){
                        show.append("/");
                    }
                }
            }
            map.put("msg",show);
            map.put("n", dto);
        }
        return "admin/course/course_detail";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(CourseDTO dto,String Week,String Day,String Jieshu,int Biaozhi) throws Exception {
        if (dto.getId() == null) {
            System.out.println(dto);
            courseService.create(dto);
        } else {
            CourseDTO old = courseService.load(dto.getId());
//            old.setCourseNumber(dto.getCourseNumber());
            old.setCourseName(dto.getCourseName());
            old.setTeacher(dto.getTeacher());
            old.setCourseInfo(dto.getCourseInfo());
            old.setCourseCredit(dto.getCourseCredit());
            StringBuffer kmsg = new StringBuffer();
            kmsg.append(Day);
            kmsg.append(Jieshu);
            kmsg.append(Week);
           // kmsg.append(';');
            String km = old.getCourseDate();
            String knew = kmsg.toString();

            //km = kmsg.toString();
            if(Biaozhi==0){
                old.setCourseDate(km);
                StringBuffer show = new StringBuffer();
                String[] datemsg = km.split(";");
                for(int i=0;i<datemsg.length;i++){
                    if(datemsg[i].charAt(2)=='0'){
                        show.append("双周");
                    }else if(datemsg[i].charAt(2)=='1'){
                        show.append("单周");
                    }else{
                        show.append("单双周");
                    }
                    if(datemsg[i].charAt(0)=='0'){
                        show.append("周日");
                    }else if(datemsg[i].charAt(0)=='1'){
                        show.append("周一");
                    }else if(datemsg[i].charAt(0)=='2'){
                        show.append("周二");
                    }else if(datemsg[i].charAt(0)=='3'){
                        show.append("周三");
                    }else if(datemsg[i].charAt(0)=='4'){
                        show.append("周四");
                    }else if(datemsg[i].charAt(0)=='5'){
                        show.append("周五");
                    }else if(datemsg[i].charAt(0)=='6'){
                        show.append("周六");
                    }
                    if(datemsg[i].charAt(1)=='1'){
                        show.append("1~2节");
                    }else if(datemsg[i].charAt(1)=='2'){
                        show.append("3~4节");
                    }else if(datemsg[i].charAt(1)=='3'){
                        show.append("5~6节");
                    }else if(datemsg[i].charAt(1)=='4'){
                        show.append("7~8节");
                    }else if(datemsg[i].charAt(1)=='5'){
                        show.append("9~11节");
                    }
                    if(i!=datemsg.length-1){
                        show.append("/");
                    }
                }
                String kk = show.toString();
                old.setCourseBeizhu(kk);
            }else if(Biaozhi==1){
                int biaoji=0;
                if(km==null){
                    kmsg.append(";");
                    km = kmsg.toString();
                    old.setCourseDate(km);
                    StringBuffer show = new StringBuffer();
                    String[] datemsg = km.split(";");
                    for(int i=0;i<datemsg.length;i++){
                        if(datemsg[i].charAt(2)=='0'){
                            show.append("双周");
                        }else if(datemsg[i].charAt(2)=='1'){
                            show.append("单周");
                        }else{
                            show.append("单双周");
                        }
                        if(datemsg[i].charAt(0)=='0'){
                            show.append("周日");
                        }else if(datemsg[i].charAt(0)=='1'){
                            show.append("周一");
                        }else if(datemsg[i].charAt(0)=='2'){
                            show.append("周二");
                        }else if(datemsg[i].charAt(0)=='3'){
                            show.append("周三");
                        }else if(datemsg[i].charAt(0)=='4'){
                            show.append("周四");
                        }else if(datemsg[i].charAt(0)=='5'){
                            show.append("周五");
                        }else if(datemsg[i].charAt(0)=='6'){
                            show.append("周六");
                        }
                        if(datemsg[i].charAt(1)=='1'){
                            show.append("1~2节");
                        }else if(datemsg[i].charAt(1)=='2'){
                            show.append("3~4节");
                        }else if(datemsg[i].charAt(1)=='3'){
                            show.append("5~6节");
                        }else if(datemsg[i].charAt(1)=='4'){
                            show.append("7~8节");
                        }else if(datemsg[i].charAt(1)=='5'){
                            show.append("9~11节");
                        }
                        if(i!=datemsg.length-1){
                            show.append("/");
                        }
                    }
                    String kk = show.toString();
                    old.setCourseBeizhu(kk);
                }else {
                    String[] ks = km.split(";");
                    for (int i = 0; i < ks.length; i++) {
                        if (knew.equals(ks[i])) {
                            old.setCourseDate(km);
                            StringBuffer show = new StringBuffer();
                            String[] datemsg = km.split(";");
                            for(int j=0;j<datemsg.length;j++){
                                if(datemsg[j].charAt(2)=='0'){
                                    show.append("双周");
                                }else if(datemsg[j].charAt(2)=='1'){
                                    show.append("单周");
                                }else{
                                    show.append("单双周");
                                }
                                if(datemsg[j].charAt(0)=='0'){
                                    show.append("周日");
                                }else if(datemsg[j].charAt(0)=='1'){
                                    show.append("周一");
                                }else if(datemsg[j].charAt(0)=='2'){
                                    show.append("周二");
                                }else if(datemsg[j].charAt(0)=='3'){
                                    show.append("周三");
                                }else if(datemsg[j].charAt(0)=='4'){
                                    show.append("周四");
                                }else if(datemsg[j].charAt(0)=='5'){
                                    show.append("周五");
                                }else if(datemsg[j].charAt(0)=='6'){
                                    show.append("周六");
                                }
                                if(datemsg[j].charAt(1)=='1'){
                                    show.append("1~2节");
                                }else if(datemsg[j].charAt(1)=='2'){
                                    show.append("3~4节");
                                }else if(datemsg[j].charAt(1)=='3'){
                                    show.append("5~6节");
                                }else if(datemsg[j].charAt(1)=='4'){
                                    show.append("7~8节");
                                }else if(datemsg[j].charAt(1)=='5'){
                                    show.append("9~11节");
                                }
                                if(j!=datemsg.length-1){
                                    show.append("/");
                                }
                            }
                            String kk = show.toString();
                            old.setCourseBeizhu(kk);
                            biaoji = 1;
                            break;
                        }
                    }
                    if (biaoji == 0) {
                        kmsg.append(";");
                        kmsg.append(km);
                        km = kmsg.toString();
                        old.setCourseDate(km);
                        StringBuffer show = new StringBuffer();
                        String[] datemsg = km.split(";");
                        for(int i=0;i<datemsg.length;i++){
                            if(datemsg[i].charAt(2)=='0'){
                                show.append("双周");
                            }else if(datemsg[i].charAt(2)=='1'){
                                show.append("单周");
                            }else{
                                show.append("单双周");
                            }
                            if(datemsg[i].charAt(0)=='0'){
                                show.append("周日");
                            }else if(datemsg[i].charAt(0)=='1'){
                                show.append("周一");
                            }else if(datemsg[i].charAt(0)=='2'){
                                show.append("周二");
                            }else if(datemsg[i].charAt(0)=='3'){
                                show.append("周三");
                            }else if(datemsg[i].charAt(0)=='4'){
                                show.append("周四");
                            }else if(datemsg[i].charAt(0)=='5'){
                                show.append("周五");
                            }else if(datemsg[i].charAt(0)=='6'){
                                show.append("周六");
                            }
                            if(datemsg[i].charAt(1)=='1'){
                                show.append("1~2节");
                            }else if(datemsg[i].charAt(1)=='2'){
                                show.append("3~4节");
                            }else if(datemsg[i].charAt(1)=='3'){
                                show.append("5~6节");
                            }else if(datemsg[i].charAt(1)=='4'){
                                show.append("7~8节");
                            }else if(datemsg[i].charAt(1)=='5'){
                                show.append("9~11节");
                            }
                            if(i!=datemsg.length-1){
                                show.append("/");
                            }
                        }
                        String kk = show.toString();
                        old.setCourseBeizhu(kk);
                    }
                }
            }else{
                old.setCourseDate(knew);
                StringBuffer show = new StringBuffer();
                String[] datemsg = knew.split(";");
                for(int i=0;i<datemsg.length;i++){
                    if(datemsg[i].charAt(2)=='0'){
                        show.append("双周");
                    }else if(datemsg[i].charAt(2)=='1'){
                        show.append("单周");
                    }else{
                        show.append("单双周");
                    }
                    if(datemsg[i].charAt(0)=='0'){
                        show.append("周日");
                    }else if(datemsg[i].charAt(0)=='1'){
                        show.append("周一");
                    }else if(datemsg[i].charAt(0)=='2'){
                        show.append("周二");
                    }else if(datemsg[i].charAt(0)=='3'){
                        show.append("周三");
                    }else if(datemsg[i].charAt(0)=='4'){
                        show.append("周四");
                    }else if(datemsg[i].charAt(0)=='5'){
                        show.append("周五");
                    }else if(datemsg[i].charAt(0)=='6'){
                        show.append("周六");
                    }
                    if(datemsg[i].charAt(1)=='1'){
                        show.append("1~2节");
                    }else if(datemsg[i].charAt(1)=='2'){
                        show.append("3~4节");
                    }else if(datemsg[i].charAt(1)=='3'){
                        show.append("5~6节");
                    }else if(datemsg[i].charAt(1)=='4'){
                        show.append("7~8节");
                    }else if(datemsg[i].charAt(1)=='5'){
                        show.append("9~11节");
                    }
                    if(i!=datemsg.length-1){
                        show.append("/");
                    }
                }
                String kk = show.toString();
                old.setCourseBeizhu(kk);
            }

            courseService.updateAllFields(old);

        }
        return ok();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String delete(Long[] ids) throws IOException {
        courseService.deleteByIds(ids);
        return ok();
    }

    @RequestMapping(value = "/list")
    public String list(CourseDTO dto, Boolean search, Map<String, Object> map, Page page) {
        List<CourseDTO> dtos = courseService.find(dto, page);
        map.put("list", dtos);
        map.put("query", dto);
        map.put("search", search);
        map.put("page",page);
        return "admin/course/course_list";
    }

}  
