package com.yuhao.TeachingServiceSystem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;
import com.yuhao.TeachingServiceSystem.util.Page;
import com.yuhao.TeachingServiceSystem.model.Teacher;
import com.yuhao.TeachingServiceSystem.dto.TeacherDTO;


@Repository
public class TeacherDAO extends BaseDAO<Teacher>{


    public List<Teacher> find(TeacherDTO dto,Page page){

            StringBuilder hql = new StringBuilder();
            List<Object> paras = new ArrayList<Object>();
            hql.append("From Teacher n where 1 = 1 ");

                    if(dto.getId()!=null){
                         hql.append(" and n.id = ? ");
                         paras.add(dto.getId());
                     }
                    if (StringUtils.isNotBlank(dto.getTeacherNumber())) {
                        hql.append(" and n.teacherNumber = ? ");
                        paras.add(dto.getTeacherNumber());
                    }

                    if (StringUtils.isNotBlank(dto.getName())) {
                        hql.append(" and n.name like ? ");
                        paras.add("%"+dto.getName()+"%");
                    }

                    if (StringUtils.isNotBlank(dto.getSex())) {
                        hql.append(" and n.sex = ? ");
                        paras.add(dto.getSex());
                    }

                    if (StringUtils.isNotBlank(dto.getIdCard())) {
                        hql.append(" and n.idCard = ? ");
                        paras.add(dto.getIdCard());
                    }

                    if(dto.getBirth()!=null){
                         hql.append(" and n.birth = ? ");
                         paras.add(dto.getBirth());
                     }
                    if (StringUtils.isNotBlank(dto.getNativePlace())) {
                        hql.append(" and n.nativePlace = ? ");
                        paras.add(dto.getNativePlace());
                    }

                    if (StringUtils.isNotBlank(dto.getEmail())) {
                        hql.append(" and n.email = ? ");
                        paras.add(dto.getEmail());
                    }

                    if (StringUtils.isNotBlank(dto.getPhone())) {
                        hql.append(" and n.phone = ? ");
                        paras.add(dto.getPhone());
                    }

                    if (StringUtils.isNotBlank(dto.getCollege())) {
                        hql.append(" and n.college = ? ");
                        paras.add(dto.getCollege());
                    }

                    if (StringUtils.isNotBlank(dto.getPassword())) {
                        hql.append(" and n.password = ? ");
                        paras.add(dto.getPassword());
                    }


            hql.append(" order by n.id desc ");
            return super.find(hql.toString(), paras.toArray(), page);
    }

    public Teacher findOne(TeacherDTO dto){
        Page page = new Page();
        page.setPageSize(1);
        page.setPage(1);

        List<Teacher> list = this.find(dto, page);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);

    }

    @Override
    public Long create(Teacher teacher) {
        return super.create(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        super.update(teacher);
    }





}  
