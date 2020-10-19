package com.yapt.demo.test.core.service.api.model.req;

import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @author hurui
 * @version Id: CloneTestReqDTO.java, v 0.1 2020/7/7 14:52 YaphetS Exp $$
 */
@Data
public class CloneTestReqDTO implements Cloneable , Serializable {

    private String name;

    private String age;

    private List<String> hobbies;

    /**
     * 浅克隆
     * @return
     */
    @Override
    public CloneTestReqDTO clone(){
        CloneTestReqDTO clone = new CloneTestReqDTO();
        try {
            clone = (CloneTestReqDTO)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 深克隆
     * @return
     */
    public CloneTestReqDTO deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(bos);
            obs.writeObject(this);
            obs.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            CloneTestReqDTO clone = (CloneTestReqDTO)ois.readObject();
            ois.close();
            return clone;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}